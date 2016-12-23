package net.monitor.gather.cpu;

import net.monitor.bean.LoadAvgBean;
import net.monitor.dao.dto.ProcessMonitorDTO;
import net.monitor.dao.mapper.ProcessMonitorMapper;
import net.monitor.domain.WatchProcess;
import net.monitor.utils.Config;
import net.monitor.utils.FileUtils;
import net.monitor.utils.MybatisUtils;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author gaochuanjun
 * @since 14-3-3
 */
public class TotalCPUMonitor implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(TotalCPUMonitor.class);

    private static final AtomicBoolean running = new AtomicBoolean(true);

    private static final AtomicBoolean looping = new AtomicBoolean(true);
    private static final Pattern p = Pattern.compile("[^0-9]");
    private final String localIp;
    private ProcessMonitorMapper processMonitorMapper = MybatisUtils.session.getMapper(ProcessMonitorMapper.class);

    public TotalCPUMonitor(String localIp) {
        this.localIp = localIp;
    }

    public void start() {
        int ncpu = getNumberOfCPUs();
        mainLoop(ncpu);
    }

    /**
     * 主循环，一直运行，除了JVM退出
     */
    private void mainLoop(int ncpu) {
        while (looping.get()) {
            try {
                setPidsLoop();
                double preTotalCpuTime = getTotalCpuTime();
                double[] preProcessCpuTimes = getProcessCpuTime();
                while (running.get()) {
                    try {
                        try {
                            Thread.sleep(Config.intervalTime);
                        } catch (InterruptedException e) {
                            LOGGER.error("线程中断异常！", e);
                        }
                        double curTotalCpuTime = getTotalCpuTime();
                        double[] curProcessCpuTimes = getProcessCpuTime();
                        LoadAvgBean loadAvg = getLoadAvg();
                        int[] processMemUsed = getProcessMemUsed();
                        double[] processCpuUsages = computeProcessCpuUsage(ncpu, preTotalCpuTime, preProcessCpuTimes, curTotalCpuTime, curProcessCpuTimes);
                        save(loadAvg, processCpuUsages, processMemUsed);
                    } catch (Exception e) {
                        LOGGER.error("monitor error.", e);
                        running.compareAndSet(true, false);
                    }
                }
            } catch (Throwable t) {
                LOGGER.error("total cpu monitor error.", t);
            }
        }
    }

    /**
     * 获取逻辑CPU个数
     *
     * @return 逻辑CPU个数
     */
    private int getNumberOfCPUs() {
        int ncpu = 0;
        File ncpufp = new File("/proc/cpuinfo");
        if (!ncpufp.exists()) {
            LOGGER.error("Can't open /proc/cpuinfo");
            return ncpu;
        }
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(ncpufp));
            String tempString;
            while ((tempString = reader.readLine()) != null) {
                if (tempString.contains("processor\t:")) {
                    ncpu++;
                }
            }
            LOGGER.info("logical CPU number: " + ncpu);
        } catch (FileNotFoundException e) {
            LOGGER.error("/proc/cpuinfo文件不存在！", e);
        } catch (IOException e) {
            LOGGER.error("获取cpu数目失败！", e);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                LOGGER.error("关闭buffer异常！", e);
            }
        }
        return ncpu;
    }

    private double[] computeProcessCpuUsage(int ncpu, double preTotalCpuTime, double[] preProcessCpuTimes, double curTotalCpuTime, double[] curProcessCpuTimes) throws Exception {
        if (preProcessCpuTimes.length != curProcessCpuTimes.length) {
            throw new Exception("preProcessCpuTimes与curProcessCpuTimes的长度不匹配！");
        }
        double[] pcpu = new double[preProcessCpuTimes.length];
        for (int i = 0; i < preProcessCpuTimes.length; i++) {
            pcpu[i] = 100 * ((curProcessCpuTimes[i] - preProcessCpuTimes[i]) / (curTotalCpuTime - preTotalCpuTime)) * ncpu;
            LOGGER.debug("double pcpu = 100 * (({} - {}) / ({} - {})) * {}", curProcessCpuTimes[i], preProcessCpuTimes[i], curTotalCpuTime, preTotalCpuTime, ncpu);
            if (pcpu[i] > (100 * ncpu)) {
                LOGGER.warn("Over the Maximum Value: " + pcpu[i] + "%. Maximum Value: " + (100 * ncpu) + "%");
            }
            LOGGER.debug("Process CPU Used(%): {}%", pcpu[i]);
        }
        return pcpu;
    }

    private void save(LoadAvgBean loadAvg, double[] processCpuUsages, int[] processMemUsed) {
        try {
            for (int i = 0; i < Config.watchProcessList.size(); i++) {
                WatchProcess watchProcess = Config.watchProcessList.get(i);
                ProcessMonitorDTO processMonitorDTO = new ProcessMonitorDTO();
                processMonitorDTO.setIp(localIp);
                processMonitorDTO.setProcessName(watchProcess.getProcessName());
                processMonitorDTO.setPid(watchProcess.getPid());
                processMonitorDTO.setOneMinsProcs(loadAvg.getOneMinsProcs());
                processMonitorDTO.setFiveMinsProcs(loadAvg.getFiveMinsProcs());
                processMonitorDTO.setFifteenMinsProcs(loadAvg.getFifteenMinsProcs());
                processMonitorDTO.setProcessCpuUsage((float) processCpuUsages[i]);
                processMonitorDTO.setProcessMemoryUsage((float) processMemUsed[i]);
                processMonitorDTO.setGmtCreate(new Date());
                processMonitorMapper.insertSelective(processMonitorDTO);
                MybatisUtils.session.commit();
            }
        } catch (Exception e) {
            LOGGER.error("保存监控信息异常！", e);
        }
    }

    private double getTotalCpuTime() {
        BufferedReader reader = null;
        double totalCpuTime = 0;
        try {
            String tempString;
            //读取总CPU的信息
            reader = new BufferedReader(new FileReader("/proc/stat"));
            while ((tempString = reader.readLine()) != null) {
                if (tempString.contains("cpu ")) {
                    tempString = tempString.replaceAll(" {2,}", " ").trim();
                    String[] array = tempString.split(" ");
                    for (int i = 1; i < array.length; i++) {
                        totalCpuTime += Double.parseDouble(array[i]);
                    }
                }
            }
            LOGGER.debug("The Total CPU Time: {}", totalCpuTime);
        } catch (Exception e) {
            LOGGER.error("read /proc/stat error.", e);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                LOGGER.error("close BufferedReader error.", e);
            }
        }
        return totalCpuTime;
    }

    private double[] getProcessCpuTime() throws Exception {
        double[] processCpuTime = new double[Config.watchProcessList.size()];
        //读取进程CPU的信息
        for (int i = 0; i < Config.watchProcessList.size(); i++) {
            WatchProcess watchProcess = Config.watchProcessList.get(i);
            BufferedReader reader = null;
            String tempString;
            try {
                String fileName = "/proc/" + watchProcess.getPid() + "/stat";
                reader = new BufferedReader(new FileReader(fileName));
                if ((tempString = reader.readLine()) != null) {
                    tempString = tempString.replaceAll(" {2,}", " ").trim();
                    String[] array = tempString.split(" ");
                    for (int j = 13; j < 17; j++) {
                        processCpuTime[i] += Double.parseDouble(array[j]);
                    }
                } else {
                    throw new Exception(fileName + " the contents of the file is empty!");
                }
                LOGGER.debug("The Process's CPU Time, process_id = {}, cpu_time = {} ", watchProcess.getPid(), processCpuTime);
            } finally {
                if (reader != null) {
                    reader.close();
                }
            }
        }
        return processCpuTime;
    }

    private LoadAvgBean getLoadAvg() throws Exception {
        //读取LoadAvg信息
        BufferedReader reader = null;
        try {
            LoadAvgBean loadAvgBean = new LoadAvgBean();
            String tempString;
            reader = new BufferedReader(new FileReader("/proc/loadavg"));
            if ((tempString = reader.readLine()) != null) {
                tempString = tempString.replaceAll(" {2,}", " ").trim();
                String[] array = tempString.split(" ");
                loadAvgBean.setOneMinsProcs(Float.parseFloat(array[0]));
                loadAvgBean.setFiveMinsProcs(Float.parseFloat(array[1]));
                loadAvgBean.setFifteenMinsProcs(Float.parseFloat(array[2]));
            } else {
                LOGGER.error("/proc/loadavg the contents of the file is empty!");
            }
            LOGGER.debug("OneMinsProcs: {}  FiveMinsProcs: {}   FifteenMinsProcs: {}", loadAvgBean.getOneMinsProcs(), loadAvgBean.getFiveMinsProcs(), loadAvgBean.getFifteenMinsProcs());
            return loadAvgBean;
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    private int[] getProcessMemUsed() throws Exception {
        int[] memUsed = new int[Config.watchProcessList.size()];
        //读取进程内存信息
        for (int i = 0; i < Config.watchProcessList.size(); i++) {
            WatchProcess watchProcess = Config.watchProcessList.get(i);
            BufferedReader reader = null;
            try {
                String tempString;
                reader = new BufferedReader(new FileReader("/proc/" + watchProcess.getPid() + "/status"));
                while ((tempString = reader.readLine()) != null) {
                    if (tempString.contains("VmRSS")) {
                        Matcher m = p.matcher(tempString);
                        memUsed[i] = (Integer.parseInt(m.replaceAll("").trim())) / 1024;
                    }
                }
                LOGGER.debug("The Process {} Memory Used: {}MB", watchProcess.getPid(), memUsed[i]);
            } finally {
                if (reader != null) {
                    reader.close();
                }
            }
        }
        return memUsed;
    }

    /**
     * 循环获取进程id
     */
    private void setPidsLoop() throws Exception {
        resetPid();
        boolean getPidLoop = true;
        int retry = 0;
        while (getPidLoop) {
            try {
                Thread.sleep(Config.intervalTime);
            } catch (InterruptedException e) {
                LOGGER.error("线程中断异常.", e);
            }
            boolean allSuccess = true;
            for (WatchProcess watchProcess : Config.watchProcessList) {
                if (watchProcess.getPid() != -1) {
                    continue;
                }
                List<String> contentList = FileUtils.readFile(watchProcess.getPidPath());
                if (CollectionUtils.isEmpty(contentList)) {
                    allSuccess = false;
                    break;
                }
                if (contentList.size() > 1) {
                    looping.compareAndSet(true, false);
                    throw new Exception(String.format("pid file content error. content should only one line. pid_path = %s, process_name = %s", watchProcess.getPidPath(), watchProcess.getProcessName()));
                }
                try {
                    watchProcess.setPid(Integer.parseInt(contentList.get(0)));
                } catch (Exception e) {
                    looping.compareAndSet(true, false);
                    throw new Exception(String.format("convert pid type error. pid must be number. pid_path = %s, process_name = %s", watchProcess.getPidPath(), watchProcess.getProcessName()));
                }
            }

            if (allSuccess) {
                getPidLoop = false;
            } else {
                LOGGER.error("get pid error. retry = {}", retry++);
            }
        }
    }

    private void resetPid() {
        for (WatchProcess watchProcess : Config.watchProcessList) {
            watchProcess.setPid(-1);
        }
    }

    @Override
    public void run() {
        start();
    }
}