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

    private String processName;  //进程名

    private volatile boolean running = true;

    private volatile boolean getPidLoop = true;

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
        this.processName = processName;
        this.intervalTime = intervalTime;
        this.p = Pattern.compile("[^0-9]");
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

        pcpufp = new File[size];

        for (int i = 0; i < size; i++) {
            pcpufp[i] = new File("/proc/" + processIdStrs[i] + "/stat");
        }

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
        } else {
            LOG.warn("The service which monitored has been stopped running, monitoring program is to get the process ID of the service, please wait...");
            running = false;
            getPidLoop = true;
        }
    }

    @Override
    public void computePersistence() {

        double[] pcpu = new double[size];

        for (int i = 0; i < size; i++) {
            pcpu[i] = 100 * ((newProcessCpuTime[i] - oldProcessCpuTime[i]) / (newTotalCpuTime - oldTotalCpuTime)) * ncpu;
            LOG.debug("double pcpu = 100 * ((" + newProcessCpuTime[i] + " - " + oldProcessCpuTime[i] + ") / (" + newTotalCpuTime + " - " + oldTotalCpuTime + ")) * " + ncpu);

            if (pcpu[i] > (100 * ncpu)) {
                LOG.warn("Over the Maximum Value: " + pcpu[i] + "%. Maximum Value: " + (100 * ncpu) + "%");
                pcpu[i] = 0;
            }

            LOG.debug("Process CPU Used(%): " + pcpu[i] + "%");
        }

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

            LOG.debug("The Total CPU Time: " + newTotalCpuTime);

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
                LOG.debug("The Process's CPU Time: " + newProcessCpuTime[i]);
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

            LOG.debug("OneMinsProcs: " + loadAvgBean.getOneMinsProcs() + "  FiveMinsProcs: " + loadAvgBean.getFiveMinsProcs() + " FifteenMinsProcs: " + loadAvgBean.getFifteenMinsProcs());

            //读取进程内存信息
            for (int i = 0; i < size; i++) {
                reader = new BufferedReader(new FileReader(memfp[i]));
                while ((tempString = reader.readLine()) != null) {
                    if (tempString.contains("VmRSS")) {
                        Matcher m = p.matcher(tempString);
                        memUsed[i] = (Integer.parseInt(m.replaceAll("").trim())) / 1024;
                    }
                }
                LOG.debug("The Process Memory Used: " + memUsed[i] + "MB.");
            }
        } catch (FileNotFoundException e) {
            LOG.error(LogTrance.getTrace(e));
            result = false;
        } catch (IOException e) {
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
                    LOG.debug(sb.toString());
                }
            } catch (IOException e) {
                e.printStackTrace();
                result = false;
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
                LOG.info("Successfully get the list of pid." + processName + ": " + processIdList);
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
        start();
    }

    public static void main(String[] args) {

    }
}