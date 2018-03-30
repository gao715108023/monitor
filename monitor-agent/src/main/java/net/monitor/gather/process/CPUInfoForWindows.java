package net.monitor.gather.process;

import net.monitor.bean.ComputeNodeStatus;
import net.monitor.behavior.GatherAbstract;
import net.monitor.common.Constants;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.Swap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author gaochuanjun
 * @since 2014/6/16
 */
public class CPUInfoForWindows extends GatherAbstract {

    private static final Logger LOGGER = LoggerFactory.getLogger(CPUInfoForWindows.class);

    private Sigar sigar;

    private Mem mem;

    private Swap swap;

    private CpuPerc cpuPerc;

    private CpuPerc[] cpuPercList;

    protected CPUInfoForWindows(String ip) {
        super(ip);
    }

    @Override
    public void start() {
        sigar = new Sigar();
        while (true) {
            process();
            try {
                Thread.sleep(Constants.SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void process() {
        getKernelStats();
        computePersistence();
    }

    @Override
    public void computePersistence() {

        ComputeNodeStatus computeNodeStatus = new ComputeNodeStatus();

        double totalTime = cpuPerc.getCombined() * 100;

        double userTime = cpuPerc.getUser() * 100;

        double niceTime = cpuPerc.getNice() * 100;

        double systemTime = cpuPerc.getSys() * 100;

        double iowaitTime = cpuPerc.getWait() * 100;

        double idleTime = cpuPerc.getIdle() * 100;

        String[] allTimes = getAllTimes();

        long totalMemory = mem.getTotal() / Constants.UNITS; //MB

        long usedMemory = mem.getUsed() / Constants.UNITS;  //MB

        long idleMemory = mem.getFree() / Constants.UNITS;  //MB

        long swapSize = swap.getTotal() / Constants.UNITS; //MB

        long usedSwap = swap.getUsed() / Constants.UNITS;  //MB

        long idleSwap = swap.getFree() / Constants.UNITS;  //MB

        computeNodeStatus.setNodeName(getIp());

        computeNodeStatus.setUpdateTime(getCurrentTime());

        computeNodeStatus.setTotalTime((float) totalTime);

        computeNodeStatus.setUserTime((float) userTime);

        computeNodeStatus.setNiceTime((float) niceTime);

        computeNodeStatus.setSystemTime((float) systemTime);

        computeNodeStatus.setIowaitTime((float) iowaitTime);

        computeNodeStatus.setIdleTime((float) idleTime);

        computeNodeStatus.setAllTotalTime(allTimes[0]);

        computeNodeStatus.setAllUserTime(allTimes[1]);

        computeNodeStatus.setAllNiceTime(allTimes[2]);

        computeNodeStatus.setAllSystemTime(allTimes[3]);

        computeNodeStatus.setAllIowaitTime(allTimes[4]);

        computeNodeStatus.setAllIdleTime(allTimes[5]);

        computeNodeStatus.setTotalMemory((int) totalMemory);

        computeNodeStatus.setUsedMemory((int) usedMemory);

        computeNodeStatus.setIdleMemory((int) idleMemory);

        computeNodeStatus.setSwapSize((int) swapSize);

        computeNodeStatus.setUsedSwap((int) usedSwap);

        computeNodeStatus.setIdleSwap((int) idleSwap);

        if (LOGGER.isDebugEnabled()) {
            printMsg(computeNodeStatus);
        }

        getServerMsgDao().insert_computenodestatus(computeNodeStatus);
        commitTransaction();
    }

    @Override
    public boolean getKernelStats() {
        try {
            mem = sigar.getMem();
            swap = sigar.getSwap();
            cpuPerc = sigar.getCpuPerc();
            cpuPercList = sigar.getCpuPercList();
        } catch (SigarException e) {
            e.printStackTrace();
        }
        return true;
    }

    private String[] getAllTimes() {
        String[] allTimes = new String[6];
        StringBuilder[] builders = new StringBuilder[6];
        for (int i = 0; i < builders.length; i++) {
            builders[i] = new StringBuilder();
        }
        for (CpuPerc aCpuPercList : cpuPercList) {
            add(builders[0], aCpuPercList.getCombined() * 100);
            add(builders[1], aCpuPercList.getUser() * 100);
            add(builders[2], aCpuPercList.getNice() * 100);
            add(builders[3], aCpuPercList.getSys() * 100);
            add(builders[4], aCpuPercList.getWait() * 100);
            add(builders[5], aCpuPercList.getIdle() * 100);
        }

        for (int i = 0; i < builders.length; i++) {
            delete(builders[i]);
            allTimes[i] = builders[i].toString();
        }
        return allTimes;
    }

    private void add(StringBuilder builder, double value) {
        builder.append(round(value)).append("@@");
    }

    private void delete(StringBuilder builder) {
        builder.delete((builder.length() - 2), builder.length());
    }

    private void printMsg(ComputeNodeStatus computeNodeStatus) {

        LOGGER.info("begin: ----------------------------------------------");

        LOGGER.info("IP地址：" + computeNodeStatus.getNodeName());

        LOGGER.info("更新时间：" + computeNodeStatus.getUpdateTime());

        LOGGER.info("一分钟进程数：" + computeNodeStatus.getOneMinsProcs());

        LOGGER.info("五分钟进程数：" + computeNodeStatus.getFiveMinsProcs());

        LOGGER.info("十五分钟进程数：" + computeNodeStatus.getFifteenMinsProcs());

        LOGGER.info("所有CPU的平均使用率：" + computeNodeStatus.getTotalTime() + "%");

        LOGGER.info("所有CPU的User平均使用率：" + computeNodeStatus.getUserTime() + "%");

        LOGGER.info("所有CPU的Nice平均使用率：" + computeNodeStatus.getNiceTime() + "%");

        LOGGER.info("所有CPU的System平均使用率：" + computeNodeStatus.getSystemTime() + "%");

        LOGGER.info("所有CPU的Iowait平均使用率：" + computeNodeStatus.getIowaitTime() + "%");

        LOGGER.info("所有CPU的Idle平均使用率：" + computeNodeStatus.getIdleTime() + "%");

        LOGGER.info("所有CPU的使用率：" + computeNodeStatus.getAllTotalTime());

        LOGGER.info("所有CPU的User使用率：" + computeNodeStatus.getAllUserTime());

        LOGGER.info("所有CPU的Nice使用率：" + computeNodeStatus.getAllNiceTime());

        LOGGER.info("所有CPU的System使用率：" + computeNodeStatus.getAllSystemTime());

        LOGGER.info("所有CPU的Iowait使用率：" + computeNodeStatus.getAllIowaitTime());

        LOGGER.info("所有CPU的Idle使用率：" + computeNodeStatus.getAllIdleTime());

        LOGGER.info("总内存大小：" + computeNodeStatus.getTotalMemory() + "MB");

        LOGGER.info("已使用内存大小：" + computeNodeStatus.getUsedMemory() + "MB");

        LOGGER.info("空闲内存大小：" + computeNodeStatus.getIdleMemory() + "MB");

        LOGGER.info("交换区大小：" + computeNodeStatus.getSwapSize() + "MB");

        LOGGER.info("使用的交换区大小：" + computeNodeStatus.getUsedSwap() + "MB");

        LOGGER.info("空闲的交换区大小：" + computeNodeStatus.getIdleSwap() + "MB");

        LOGGER.info("end: ----------------------------------------------");
    }

    @Override
    public void run() {
        start();
    }
}
