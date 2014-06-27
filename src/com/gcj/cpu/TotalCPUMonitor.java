package com.gcj.cpu;

import com.gcj.bean.LoadAvgBean;
import com.gcj.bean.ServerMsgBean;
import com.gcj.behavior.GatherAbstract;
import com.gcj.common.LogTrance;
import com.gcj.utils.MybatisUtils;
import com.gcj.utils.TimeUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by gaochuanjun on 14-3-3.
 */
public class TotalCPUMonitor extends GatherAbstract {

    private static final Log LOG = LogFactory.getLog(TotalCPUMonitor.class);

    private List<Integer> processIdList;  //进程ID

    // private String ip; //本机IP地址

    private String processName;  //进程名

    private volatile boolean running = true;

    private volatile boolean getPidLoop = true;

    //private ServerMsgDao serverMsgDao;

    private int intervalTime;  //采集信息的间隔

    private int ncpu;		/* Number of processors */

    private File cpufp;

    private File[] pcpufp;

    private File loadavgfp;

    private File[] memfp;

    private double newTotalCpuTime;

    private double oldTotalCpuTime;

    private double[] newProcessCpuTime;

    private double[] oldProcessCpuTime;

    private LoadAvgBean loadAvgBean = new LoadAvgBean();

    private int[] memUsed;

    private Pattern p;

    private int size;


    /**
     * 构造函数
     *
     * @param ip
     * @param processName
     * @param intervalTime
     */
    public TotalCPUMonitor(String ip, String processName, int intervalTime) {
        super(ip);
        //this.ip = ip;
        this.processName = processName;
        this.intervalTime = intervalTime;
        //this.serverMsgDao = MybatisUtils.session.getMapper(ServerMsgDao.class);
        this.p = Pattern.compile("[^0-9]");
    }

    /**
     * 根据top命令获取进程的cpu使用率
     *
     * @param run
     * @param serverMsgBean
     * @return
     */
    private boolean getCPUMsgByTop(Runtime run, ServerMsgBean serverMsgBean) {
        BufferedInputStream in = null;
        BufferedReader inBr = null;
        Process p = null;
        boolean result = false;
        try {
            p = run.exec("");
            in = new BufferedInputStream(p.getInputStream());
            inBr = new BufferedReader(new InputStreamReader(in), 1024);
            String lineStr;
            while ((lineStr = inBr.readLine()) != null) {
                if (lineStr.contains(processName)) {
                    result = true;  //如果能够获取到进程的cpu信息，返回true
                    LOG.debug(lineStr);
                    lineStr = lineStr.replaceAll(" {2,}", " ").trim();//去掉字符串中多余的空格，只留一个空格
                    LOG.debug(lineStr);
                    String[] array = lineStr.split(" ");
                    float cpuUsage = Float.parseFloat(array[8]);
                    serverMsgBean.setCpuUsage(cpuUsage);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inBr != null)
                    inBr.close();
                if (in != null)
                    in.close();
                if ((p != null ? p.getErrorStream() : null) != null) {
                    p.getErrorStream().close();
                }
                if ((p != null ? p.getInputStream() : null) != null) {
                    p.getInputStream().close();
                }
                if ((p != null ? p.getOutputStream() : null) != null) {
                    p.getOutputStream().close();
                }
                if (p != null) {
                    p.waitFor();
                    p.destroy();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return result;
    }


    /**
     * 获取CPU核心数
     */
    private void getNumberOfCPUs() {

        File ncpufp = new File("/proc/cpuinfo");

        if (!ncpufp.exists())
            LOG.error("Can't open /proc/cpuinfo");

        LOG.info("Open /proc/cpuinfo......[OK]");

        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(ncpufp));
            String tempString;
            while ((tempString = reader.readLine()) != null) {
                if (tempString.contains("processor\t:")) {
                    ncpu++;
                }
            }
            LOG.info("The Number of CPU: " + ncpu);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                    LOG.info("Closed the buffer of " + ncpufp.getAbsolutePath() + "......[OK]");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (ncpu == 0)
            LOG.error("Error parsing /proc/cpuinfo");
    }

    @Override
    public void start() {

        cpufp = new File("/proc/stat");

        if (!cpufp.exists())
            LOG.error("Can't open /proc/stat");
        else
            LOG.info("Open /proc/stat......[OK]");

        loadavgfp = new File("/proc/loadavg");

        if (!loadavgfp.exists())
            LOG.error("Can't open /proc/loadavg");
        else
            LOG.info("Open /proc/loadavg......[OK]");

        getNumberOfCPUs();

        mainLoop();
    }

    /**
     * 主循环，一直运行，除了JVM退出
     */
    private void mainLoop() {

        while (true) {

            processIdList = getPids();

            size = processIdList.size();

            //变量初始化
            newTotalCpuTime = 0;
            oldTotalCpuTime = 0;

            newProcessCpuTime = new double[size];
            oldProcessCpuTime = new double[size];
            memUsed = new int[size];

            for (int i = 0; i < size; i++) {
                newProcessCpuTime[i] = 0;
                oldProcessCpuTime[i] = 0;
                memUsed[i] = 0;
            }
            //oldProcessCpuTime = 0;
            //memUsed = 0;
            loadAvgBean.setOneMinsProcs(0);
            loadAvgBean.setFiveMinsProcs(0);
            loadAvgBean.setFifteenMinsProcs(0);

            openPidFiles();

            while (running) {
                process();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void openPidFiles() {

        String[] processIdStrs = new String[size];

        for (int i = 0; i < size; i++) {
            processIdStrs[i] = String.valueOf(processIdList.get(i));
        }

        //String processIdStr = String.valueOf(processId);
        pcpufp = new File[size];

        for (int i = 0; i < size; i++) {
            pcpufp[i] = new File("/proc/" + processIdStrs[i] + "/stat");
        }

        //pcpufp = new File("/proc/" + processIdStr + "/stat");

        for (int i = 0; i < size; i++) {
            if (!pcpufp[i].exists()) {
                LOG.error("Can't open /proc/" + processIdStrs[i] + "/stat");
                openPidFiles();
                return;
            }
        }


        for (int i = 0; i < size; i++) {
            LOG.info("Open " + pcpufp[i].getAbsolutePath() + "......[OK]");
        }

        memfp = new File[size];

        for (int i = 0; i < size; i++) {
            memfp[i] = new File("/proc/" + processIdStrs[i] + "/status");
        }

        //memfp = new File("/proc/" + processIdStr + "/status");

        for (int i = 0; i < size; i++) {
            if (!memfp[i].exists()) {
                LOG.error("Can't open /proc/" + processIdStrs[i] + "/status");
                openPidFiles();
                return;
            }
        }

        for (int i = 0; i < size; i++) {
            LOG.info("Open " + memfp[i].getAbsolutePath() + "......[OK]");
        }
    }

    @Override
    public void process() {

        boolean result = getKernelStats();

        if (result) {
            computePersistence();

        /* Save old stats */
            oldTotalCpuTime = newTotalCpuTime;
            newTotalCpuTime = 0;
            for (int i = 0; i < processIdList.size(); i++) {
                oldProcessCpuTime[i] = newProcessCpuTime[i];
                newProcessCpuTime[i] = 0;
            }
            //oldProcessCpuTime = newProcessCpuTime;
            //newProcessCpuTime = 0;
        } else {
            running = false;
        }
    }

    @Override
    public void computePersistence() {

        double[] pcpu = new double[size];

        for (int i = 0; i < size; i++) {
            pcpu[i] = 100 * ((newProcessCpuTime[i] - oldProcessCpuTime[i]) / (newTotalCpuTime - oldTotalCpuTime)) * ncpu;
            LOG.info("double pcpu = 100 * ((" + newProcessCpuTime[i] + " - " + oldProcessCpuTime[i] + ") / (" + newTotalCpuTime + " - " + oldTotalCpuTime + ")) * " + ncpu);

            if (pcpu[i] > (100 * ncpu)) {
                LOG.warn("Over the Maximum Value: " + pcpu[i] + "%. Maximum Value: " + (100 * ncpu) + "%");
                pcpu[i] = 0;
            }

            LOG.info("Process CPU Used(%): " + pcpu[i] + "%");
        }
        //double pcpu = 100 * ((newProcessCpuTime - oldProcessCpuTime) / (newTotalCpuTime - oldTotalCpuTime)) * ncpu;

        for (int i = 0; i < size; i++) {
            ServerMsgBean serverMsgBean = new ServerMsgBean();
            serverMsgBean.setIp(getIp());
            serverMsgBean.setUpdateTime(TimeUtils.getCurrentTime());
            serverMsgBean.setProceeName(processName);
            serverMsgBean.setPid(processIdList.get(i));
            serverMsgBean.setCpuUsage((float) pcpu[i]);
            serverMsgBean.setOneMinsProcs(loadAvgBean.getOneMinsProcs());
            serverMsgBean.setFiveMinsProcs(loadAvgBean.getFiveMinsProcs());
            serverMsgBean.setFifteenMinsProcs(loadAvgBean.getFifteenMinsProcs());
            serverMsgBean.setMemUsage(memUsed[i]);
            getServerMsgDao().insert_server_monitor(serverMsgBean);
            MybatisUtils.session.commit();
        }
    }

    @Override
    public boolean getKernelStats() {

        boolean result = true;

        BufferedReader reader = null;

        try {

            String tempString;

            //读取总CPU的信息
            reader = new BufferedReader(new FileReader(cpufp));
            while ((tempString = reader.readLine()) != null) {
                if (tempString.contains("cpu ")) {
                    tempString = tempString.replaceAll(" {2,}", " ").trim();
                    String[] array = tempString.split(" ");
                    for (int i = 1; i < array.length; i++) {
                        newTotalCpuTime += Double.parseDouble(array[i]);
                    }
                }
            }

            LOG.info("The Total CPU Time: " + newTotalCpuTime);

            //读取进程CPU的信息
            for (int i = 0; i < size; i++) {
                reader = new BufferedReader(new FileReader(pcpufp[i]));
                if ((tempString = reader.readLine()) != null) {
                    tempString = tempString.replaceAll(" {2,}", " ").trim();
                    String[] array = tempString.split(" ");
                    for (int j = 13; j < 17; j++) {
                        newProcessCpuTime[i] += Double.parseDouble(array[j]);
                    }
                } else {
                    LOG.error(pcpufp[i].getAbsolutePath() + " the contents of the file is empty!");
                    result = false;
                }
                LOG.info("The Process's CPU Time: " + newProcessCpuTime[i]);
            }


            //读取LoadAvg信息
            reader = new BufferedReader(new FileReader(loadavgfp));
            if ((tempString = reader.readLine()) != null) {
                tempString = tempString.replaceAll(" {2,}", " ").trim();
                String[] array = tempString.split(" ");
                loadAvgBean.setOneMinsProcs(Float.parseFloat(array[0]));
                loadAvgBean.setFiveMinsProcs(Float.parseFloat(array[1]));
                loadAvgBean.setFifteenMinsProcs(Float.parseFloat(array[2]));
            } else {
                LOG.error(loadavgfp.getAbsolutePath() + " the contents of the file is empty!");
                result = false;
            }

            LOG.info("OneMinsProcs: " + loadAvgBean.getOneMinsProcs() + "  FiveMinsProcs: " + loadAvgBean.getFiveMinsProcs() + " FifteenMinsProcs: " + loadAvgBean.getFifteenMinsProcs());

            //读取进程内存信息
            for (int i = 0; i < size; i++) {
                reader = new BufferedReader(new FileReader(memfp[i]));
                while ((tempString = reader.readLine()) != null) {
                    if (tempString.contains("VmRSS")) {
                        Matcher m = p.matcher(tempString);
                        memUsed[i] = (Integer.parseInt(m.replaceAll("").trim())) / 1024;
                    }
                }
                LOG.info("The Process Memory Used: " + memUsed[i] + "MB.");
            }
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            LOG.error(LogTrance.getTrace(e));
            //LOG.warn("Can't open " + pcpufp.getAbsolutePath() + ". Application will retrieve process, please wait...");
            result = false;
        } catch (IOException e) {
            //e.printStackTrace();
            LOG.error(LogTrance.getTrace(e));
            result = false;
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Closed the buffer of ");
                    for (int i = 0; i < size; i++) {
                        sb.append(pcpufp[i].getAbsolutePath()).append(" and ");
                    }
                    for (int i = 0; i < size; i++) {
                        sb.append(memfp[i].getAbsolutePath()).append(" and ");
                    }
                    sb.append(cpufp.getAbsolutePath());
                    sb.append("......[OK]");
                    LOG.info(sb.toString());
                    //LOG.info("Closed the buffer of " + cpufp.getAbsolutePath() + " and " + pcpufp.getAbsolutePath() + " and " + loadavgfp.getAbsolutePath() + " and " + memfp.getAbsolutePath() + "......[OK]");
                }
            } catch (IOException e) {
                e.printStackTrace();
                result = false;
            }
        }
        return result;
    }

    /**
     * 从proc获取进程平均负载信息
     *
     * @param serverMsgBean
     * @return
     */
    public boolean getProcessInfoFromProc(ServerMsgBean serverMsgBean) {
        FileReader reader = null;
        BufferedReader br = null;
        boolean result = false;
        try {
            float oneMinsProcs;
            float fiveMInsProcs;
            float fifteenMinsProcs;
            reader = new FileReader("/proc/loadavg"); //读取来自/proc/loadavg文件中的信息
            br = new BufferedReader(reader);
            String str = br.readLine();
            while (str != null && !str.equals("") && !str.equals(" ")) {
                String a[] = str.split(" "); //根据空格对字符串进行切分
                oneMinsProcs = Float.parseFloat(a[0]); //第一位为1分钟进程数
                fiveMInsProcs = Float.parseFloat(a[1]); //第二位为5分钟进程数
                fifteenMinsProcs = Float.parseFloat(a[2]); //第三位为15分钟进程数
                serverMsgBean.setOneMinsProcs(oneMinsProcs);
                serverMsgBean.setFiveMinsProcs(fiveMInsProcs);
                serverMsgBean.setFifteenMinsProcs(fifteenMinsProcs);
                str = br.readLine();
            }
            result = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * debug模式
     *
     * @param serverMsgBean
     */
    private void debugMsg(ServerMsgBean serverMsgBean) {
        LOG.debug("LocalHostIp: " + serverMsgBean.getIp() + "    pid: "
                + serverMsgBean.getPid() + "  UpdateTime: "
                + serverMsgBean.getUpdateTime() + "   ProceeName: "
                + serverMsgBean.getProceeName() + "   OneMinsProcs: "
                + serverMsgBean.getOneMinsProcs() + "   FiveMinsProcs: "
                + serverMsgBean.getFiveMinsProcs() + " FifteenMinsProcs: "
                + serverMsgBean.getFifteenMinsProcs() + "   CPUUsage: "
                + serverMsgBean.getCpuUsage() + "   IOWaitTime: "
                + serverMsgBean.getIowaitTime() + "   MemUsage: "
                + serverMsgBean.getMemUsage());
    }

    /**
     * 获取进程的pid信息，通过执行脚本/opt/resource_monitor/bin/getpid.sh
     *
     * @return
     */
    public List<Integer> getPids() {

        List<Integer> processIdList = new ArrayList<Integer>();

        //int processId = -1;

        Runtime run = Runtime.getRuntime();
        BufferedReader inBr = null;
        Process p = null;
        String cmd = "sh getpid.sh";

        while (getPidLoop) {
            try {
                p = run.exec(cmd);
                inBr = new BufferedReader(new InputStreamReader(new BufferedInputStream(p.getInputStream())), 1024);
                String lineStr;
                while ((lineStr = inBr.readLine()) != null) {
                    processIdList.add(Integer.parseInt(lineStr));
                    //processId = Integer.parseInt(lineStr);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (inBr != null) {
                        inBr.close();
                        LOG.info("Closed the buffer of Process p......[OK]");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (p != null) {
                    p.destroy();
                    LOG.info("Closed the Process p......[OK]");
                }
            }
            //如果成功获取到进程pid，则退出循环
            if (processIdList.size() != 0) {
                LOG.info("The pid of " + processName + ": " + processIdList);
                getPidLoop = false;
            }
            try {
                Thread.sleep(intervalTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return processIdList;
    }


    @Override
    public void run() {

//        MemUsage memUsage = new MemUsage();
//        Runtime run = Runtime.getRuntime();
//        String memPath;
//
//        String currentTime;
//        File statusFile;
//        ServerMsgBean serverMsgBean = new ServerMsgBean();
//        serverMsgBean.setLocalHostIp(ip);
//        serverMsgBean.setProceeName(processName);
//        //serverMsgBean.setPid(Integer.parseInt(processId));
//        boolean processInfo;
//        boolean cpuMsg;
//        boolean memInfo;
//        while (shutdown) {
//
//            processId = getPid(); //获取进程id
//            LOG.info("Process Id: " + processId);
//
//            cmd = "top -p " + processId + " -b -n 1"; //top命令
//            LOG.info("Top Command For Collecting CPU & Memory: " + cmd);
//
//            running = true;
//
//            processIdStr = String.valueOf(processId);
//
//            memPath = "/proc/" + processIdStr + "/status";
//            LOG.info("Reading the file for memory: " + memPath);
//            statusFile = new File(memPath);
//
//            serverMsgBean.setPid(processId);
//
//            while (shutdown && running) {
//
//                currentTime = TimeUtils.getCurrentTime();//获取系统当前时间
//                serverMsgBean.setUpdateTime(currentTime);
//
//                //获取进程的负载信息
//                processInfo = getProcessInfoFromProc(serverMsgBean);
//
//                //获取进程的cpu信息
//                cpuMsg = getCPUMsgByTop(run, serverMsgBean);
//
//                //获取内存信息
//                memInfo = memUsage.getMemUsage(statusFile, serverMsgBean);
//
//                debugMsg(serverMsgBean);
//
//                //如果三个信息都获取到了，则存储至数据库
//                if (processInfo && cpuMsg && memInfo) {
//                    serverMsgDao.insert_server_monitor(serverMsgBean);
//                    MybatisUtils.session.commit();
//
//                } else if (!cpuMsg || !memInfo) {//否则，查看是否cpu还是内存没有获取到，若是这两个未获取到，一般是因为进程id改变了
//                    running = false;
//                    getPidLoop = true;
//                }
//                try {
//                    Thread.sleep(intervalTime);
//                } catch (InterruptedException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//            }
//        }
        start();
    }

    public static void main(String[] args) {

    }
}