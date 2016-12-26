package net.monitor.gather.process;

import net.monitor.dao.dto.ProcessMonitorDTO;
import net.monitor.dao.mapper.ProcessMonitorMapper;
import net.monitor.domain.LoadAvgInfo;
import net.monitor.domain.WatchProcess;
import net.monitor.gather.CpuStaticInfo;
import net.monitor.utils.Config;
import net.monitor.utils.FileUtils;
import net.monitor.utils.MybatisUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author gaochuanjun
 * @since 14-3-3
 */
public class ProcessCPUAndMemoryMonitor implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProcessCPUAndMemoryMonitor.class);

    private static final AtomicBoolean running = new AtomicBoolean(true);

    private static final AtomicBoolean looping = new AtomicBoolean(true);
    private static final Pattern p = Pattern.compile("[^0-9]");
    private final String localIp;

    public ProcessCPUAndMemoryMonitor(String localIp) {
        this.localIp = localIp;
    }

    public void start() {
        int ncpu = CpuStaticInfo.getNumberOfCPUs();
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
                        LoadAvgInfo loadAvg = getLoadAvg();
                        int[] processMemUsed = getProcessMemUsed();
                        double[] processCpuUsages = computeProcessCpuUsage(ncpu, preTotalCpuTime, preProcessCpuTimes, curTotalCpuTime, curProcessCpuTimes);
                        save(loadAvg, processCpuUsages, processMemUsed);
                        preTotalCpuTime = curTotalCpuTime;
                        preProcessCpuTimes = curProcessCpuTimes;
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

    private void save(LoadAvgInfo loadAvg, double[] processCpuUsages, int[] processMemUsed) {
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
                insertSelective(processMonitorDTO);
            }
        } catch (Exception e) {
            LOGGER.error("保存监控信息异常！", e);
        }
    }

    private void insertSelective(ProcessMonitorDTO record) {
        try (SqlSession session = MybatisUtils.sqlSessionFactory.openSession(Boolean.FALSE)) {
            ProcessMonitorMapper processMonitorMapper = session.getMapper(ProcessMonitorMapper.class);
            processMonitorMapper.insertSelective(record);
            session.commit();
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

    private LoadAvgInfo getLoadAvg() throws Exception {
        //读取LoadAvg信息
        BufferedReader reader = null;
        try {
            LoadAvgInfo loadAvgInfo = new LoadAvgInfo();
            String tempString;
            reader = new BufferedReader(new FileReader("/proc/loadavg"));
            if ((tempString = reader.readLine()) != null) {
                tempString = tempString.replaceAll(" {2,}", " ").trim();
                String[] array = tempString.split(" ");
                loadAvgInfo.setOneMinsProcs(Float.parseFloat(array[0]));
                loadAvgInfo.setFiveMinsProcs(Float.parseFloat(array[1]));
                loadAvgInfo.setFifteenMinsProcs(Float.parseFloat(array[2]));
            } else {
                LOGGER.error("/proc/loadavg the contents of the file is empty!");
            }
            LOGGER.debug("OneMinsProcs: {}  FiveMinsProcs: {}   FifteenMinsProcs: {}", loadAvgInfo.getOneMinsProcs(), loadAvgInfo.getFiveMinsProcs(), loadAvgInfo.getFifteenMinsProcs());
            return loadAvgInfo;
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