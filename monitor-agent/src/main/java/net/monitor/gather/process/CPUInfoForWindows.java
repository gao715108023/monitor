package net.monitor.gather.process;

import net.monitor.bean.ComputeNodeStatus;
import net.monitor.behavior.GatherAbstract;
import net.monitor.common.Constants;
import net.monitor.utils.HostUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hyperic.sigar.*;

/**
 * @author gaochuanjun
 * @since 2014/6/16
 */
public class CPUInfoForWindows extends GatherAbstract {

    private static final Log LOG = LogFactory.getLog(CPUInfoForWindows.class);

    private Sigar sigar;

    private Mem mem;

    private Swap swap;

    private CpuPerc cpuPerc;

    private CpuPerc[] cpuPercList;

    protected CPUInfoForWindows(String ip) {
        super(ip);
    }

    public static void main(String[] args) {
        LOG.info(System.getProperty("java.library.path"));
        GatherAbstract gatherAbstract = new CPUInfoForWindows(HostUtil.getHostIP());

        Constants.OS = 1;

        new Thread(gatherAbstract).start();
    }

    @Override
    public void start() {
        sigar = new Sigar();
        while (true) {
            process();
            try {
                Thread.sleep(Constants.SLEEPTIME);
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

        if (LOG.isDebugEnabled()) {
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

        LOG.info("begin: ----------------------------------------------");

        LOG.info("IP地址：" + computeNodeStatus.getNodeName());

        LOG.info("更新时间：" + computeNodeStatus.getUpdateTime());

        LOG.info("一分钟进程数：" + computeNodeStatus.getOneMinsProcs());

        LOG.info("五分钟进程数：" + computeNodeStatus.getFiveMinsProcs());

        LOG.info("十五分钟进程数：" + computeNodeStatus.getFifteenMinsProcs());

        LOG.info("所有CPU的平均使用率：" + computeNodeStatus.getTotalTime() + "%");

        LOG.info("所有CPU的User平均使用率：" + computeNodeStatus.getUserTime() + "%");

        LOG.info("所有CPU的Nice平均使用率：" + computeNodeStatus.getNiceTime() + "%");

        LOG.info("所有CPU的System平均使用率：" + computeNodeStatus.getSystemTime() + "%");

        LOG.info("所有CPU的Iowait平均使用率：" + computeNodeStatus.getIowaitTime() + "%");

        LOG.info("所有CPU的Idle平均使用率：" + computeNodeStatus.getIdleTime() + "%");

        LOG.info("所有CPU的使用率：" + computeNodeStatus.getAllTotalTime());

        LOG.info("所有CPU的User使用率：" + computeNodeStatus.getAllUserTime());

        LOG.info("所有CPU的Nice使用率：" + computeNodeStatus.getAllNiceTime());

        LOG.info("所有CPU的System使用率：" + computeNodeStatus.getAllSystemTime());

        LOG.info("所有CPU的Iowait使用率：" + computeNodeStatus.getAllIowaitTime());

        LOG.info("所有CPU的Idle使用率：" + computeNodeStatus.getAllIdleTime());

        LOG.info("总内存大小：" + computeNodeStatus.getTotalMemory() + "MB");

        LOG.info("已使用内存大小：" + computeNodeStatus.getUsedMemory() + "MB");

        LOG.info("空闲内存大小：" + computeNodeStatus.getIdleMemory() + "MB");

        LOG.info("交换区大小：" + computeNodeStatus.getSwapSize() + "MB");

        LOG.info("使用的交换区大小：" + computeNodeStatus.getUsedSwap() + "MB");

        LOG.info("空闲的交换区大小：" + computeNodeStatus.getIdleSwap() + "MB");

        LOG.info("end: ----------------------------------------------");
    }

    @Override
    public void run() {
        start();
    }
}
