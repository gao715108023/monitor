package net.monitor.gather.system;

import net.monitor.bean.BlkioInfo;
import net.monitor.bean.CPUInfo;
import net.monitor.bean.PartInfo;
import net.monitor.common.Parameter;
import net.monitor.dao.dto.IOMonitorDTO;
import net.monitor.dao.mapper.IOMonitorMapper;
import net.monitor.gather.CpuStaticInfo;
import net.monitor.utils.Config;
import net.monitor.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class IOStatMonitor implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(IOStatMonitor.class);

    private static final AtomicBoolean running = new AtomicBoolean(true);

    private static final int MAX_PARTITIONS = 64;

    private final String localIp;

    public IOStatMonitor(String localIp) {
        this.localIp = localIp;
    }

    /**
     * start gather system io and cpu info
     */
    public void start() {
        //open file /proc/diskstats
        File iofp = new File("/proc/diskstats");
        //if /proc/diskstats not exists, then open file  /proc/partitions
        if (!iofp.exists()) {
            iofp = new File("/proc/partitions");
            if (!iofp.exists()) {
                LOGGER.error("Can't get I/O statistics on this system");
            }
        }
        //open file  /proc/stat
        File cpufp = new File("/proc/stat");
        if (!cpufp.exists()) {
            LOGGER.error("Can't open /proc/stat");
        }
        //get cpu number
        int ncpu = CpuStaticInfo.getNumberOfCPUs();
        //get partitions
        List<PartInfo> partitions = getPartitions(iofp);
        //initial io info
        BlkioInfo[] preBlkioInfos = getBlkioInfo(iofp, partitions);
        //initial cpu info
        CPUInfo preCpuInfo = getCpuInfo(cpufp);
        while (running.get()) {
            try {
                Thread.sleep(Config.intervalTime);
            } catch (InterruptedException e) {
                LOGGER.error("thread interrupted exception", e);
            }
            //get current io info
            BlkioInfo[] curBlkioInfos = getBlkioInfo(iofp, partitions);
            //get current cpu info
            CPUInfo curCpuInfo = getCpuInfo(cpufp);
            //compute usage and save to MySQL
            computePersistence(preBlkioInfos, curBlkioInfos, preCpuInfo, curCpuInfo, ncpu, partitions);
            //set current io info to pre
            preBlkioInfos = curBlkioInfos;
            //set current cpu to pre
            preCpuInfo = curCpuInfo;
        }
    }

    /**
     * compute io and cpu usage, then save to MySQL
     *
     * @param preBlkioInfos last time io info
     * @param curBlkioInfos now io info
     * @param preCpuInfo    last time cpu info
     * @param curCpuInfo    now cpu info
     * @param ncpu          cpu cores
     * @param partitions    partition infos
     */
    private void computePersistence(BlkioInfo[] preBlkioInfos, BlkioInfo[] curBlkioInfos, CPUInfo preCpuInfo, CPUInfo curCpuInfo, int ncpu, List<PartInfo> partitions) {
        double deltams = 1000.0 * ((curCpuInfo.getUser() + curCpuInfo.getSystem() + curCpuInfo.getIdle() + curCpuInfo.getIowait()) - (preCpuInfo.getUser() + preCpuInfo.getSystem() + preCpuInfo.getIdle() + preCpuInfo.getIowait())) / ncpu / Parameter.HZ;
        for (int i = 0; i < curBlkioInfos.length; i++) {
            BlkioInfo blkioInfo = new BlkioInfo();
            double nIOs;     //I/O完成次数
            double nTicks;     //每秒I/O花费的毫秒数
            double busy;    //磁盘利用率(%) util
            double svcT;	 /* 平均每次输入/输出操作花费的毫秒数svctm*/
            double wait;	 /* 平均每次I/O花费的毫秒数 await*/
            blkioInfo.setRdIos(curBlkioInfos[i].getRdIos() - preBlkioInfos[i].getRdIos());//每秒读完成次数 r/s
            blkioInfo.setRdMerges(curBlkioInfos[i].getRdMerges() - preBlkioInfos[i].getRdMerges());//每秒合并读完成次数 rrqm/s
            blkioInfo.setRdSectors(curBlkioInfos[i].getRdSectors() - preBlkioInfos[i].getRdSectors());//每秒读扇区的次数 rkB/s
            blkioInfo.setRdTicks(curBlkioInfos[i].getRdTicks() - preBlkioInfos[i].getRdTicks());//每秒读花费的毫秒数
            blkioInfo.setWrIos(curBlkioInfos[i].getWrIos() - preBlkioInfos[i].getWrIos()); //每秒写完成次数 w/s
            blkioInfo.setWrMerges(curBlkioInfos[i].getWrMerges() - preBlkioInfos[i].getWrMerges());//每秒合并写完成次数wrqm/s
            blkioInfo.setWrSectors(curBlkioInfos[i].getWrSectors() - preBlkioInfos[i].getWrSectors());//每秒写扇区次数 wkB/s
            blkioInfo.setWrTicks(curBlkioInfos[i].getWrTicks() - preBlkioInfos[i].getWrTicks());//每秒写操作花费的毫秒数
            blkioInfo.setTicks(curBlkioInfos[i].getTicks() - preBlkioInfos[i].getTicks());//每秒输入/输出操作花费的毫秒数
            blkioInfo.setAveq(curBlkioInfos[i].getAveq() - preBlkioInfos[i].getAveq());//每秒输入/输出操作花费的加权毫秒数
            nIOs = blkioInfo.getRdIos() + blkioInfo.getWrIos();
            nTicks = blkioInfo.getRdTicks() + blkioInfo.getWrTicks();
            wait = (nIOs != 0 ? nTicks / nIOs : 0.0);
            svcT = (nIOs != 0 ? blkioInfo.getTicks() / nIOs : 0.0);
            busy = 100.0 * blkioInfo.getTicks() / deltams;
            if (busy > 100.0)
                busy = 100.0;

            IOMonitorDTO ioMonitorDTO = new IOMonitorDTO();
            ioMonitorDTO.setIp(localIp);
            ioMonitorDTO.setDiskName(partitions.get(i).getName());
            ioMonitorDTO.setAwait((float) wait);
            ioMonitorDTO.setSvctm((float) svcT);
            ioMonitorDTO.setUtil((float) busy);
            ioMonitorDTO.setGmtCreate(new Date());
            insertSelective(ioMonitorDTO);
        }
    }

    private void insertSelective(IOMonitorDTO record) {
        try (SqlSession session = MybatisUtils.sqlSessionFactory.openSession(Boolean.FALSE)) {
            IOMonitorMapper ioMonitorMapper = session.getMapper(IOMonitorMapper.class);
            ioMonitorMapper.insertSelective(record);
            session.commit();
        }
    }

    /**
     * get io info  at present
     *
     * @param iofp       io file
     * @param partitions partition info
     * @return io info
     */
    private BlkioInfo[] getBlkioInfo(File iofp, List<PartInfo> partitions) {
        BlkioInfo[] blkioInfos = new BlkioInfo[partitions.size()];
        //read /proc/partitions or /proc/diskstats
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(iofp));
            String tempString;
            while ((tempString = reader.readLine()) != null) {
                PartInfo partInfo = new PartInfo();
                BlkioInfo blkioInfo = new BlkioInfo();
                tempString = tempString.replaceAll(" {2,}", " ").trim();//2和11舍弃
                String[] array = tempString.split(" ");
                partInfo.setMajor(Integer.parseInt(array[0]));
                partInfo.setMinor(Integer.parseInt(array[1]));
                blkioInfo.setRdIos(Long.parseLong(array[3])); //读完成次数 ----- 读磁盘的次数，成功完成读的总次数。
                blkioInfo.setRdMerges(Long.parseLong(array[4]));//合并读完成次数
                blkioInfo.setRdSectors(Long.parseLong(array[5])); //读扇区的次数，成功读过的扇区总次数。
                blkioInfo.setRdTicks(Long.parseLong(array[6])); //读花费的毫秒数，这是所有读操作所花费的毫秒数
                blkioInfo.setWrIos(Long.parseLong(array[7])); //写完成次数 ----写完成的次数，成功写完成的总次数。
                blkioInfo.setWrMerges(Long.parseLong(array[8])); //合并写完成次数
                blkioInfo.setWrSectors(Long.parseLong(array[9])); //写扇区次数 ---- 写扇区的次数，成功写扇区总次数。
                blkioInfo.setWrTicks(Long.parseLong(array[10])); //写操作花费的毫秒数
                blkioInfo.setTicks(Long.parseLong(array[12])); //输入/输出操作花费的毫秒数  ----花在I/O操作上的毫秒数，这个域会增长只要field 9不为0。
                blkioInfo.setAveq(Long.parseLong(array[13]));//输入/输出操作花费的加权毫秒数 -----  加权， 花在I/O操作上的毫秒数，在每次I/O开始，I/O结束，I/O合并时这个域都会增加。这可以给I/O完成时间和存储那些可以累积的提供一个便利的测量标准。

                //set io of partition to array
                for (int i = 0; i < partitions.size(); i++) {
                    if (partitions.get(i).getMajor() == partInfo.getMajor() && partitions.get(i).getMinor() == partInfo.getMinor()) {
                        blkioInfos[i] = blkioInfo;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.error(String.format("read %s error.", iofp.getAbsolutePath()), e);
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                LOGGER.error(String.format("close BufferedReader error. file = %s", iofp.getAbsolutePath()), e);
            }
        }
        return blkioInfos;
    }

    /**
     * get cpu info
     *
     * @param cpufp cpu file
     * @return cpu info
     */
    private CPUInfo getCpuInfo(File cpufp) {
        CPUInfo cpuInfo = new CPUInfo();
        BufferedReader reader = null;
        try {
            //read /proc/stat
            reader = new BufferedReader(new FileReader(cpufp));
            String tempString;
            while ((tempString = reader.readLine()) != null) {
                if (tempString.contains("cpu ")) {
                    double nice, irq, softirq;
                    tempString = tempString.replaceAll(" {2,}", " ").trim();
                    String[] array = tempString.split(" ");
                    cpuInfo.setUser(Double.parseDouble(array[1]));
                    nice = Double.parseDouble(array[2]);
                    cpuInfo.setSystem(Double.parseDouble(array[3]));
                    cpuInfo.setIdle(Double.parseDouble(array[4]));
                    cpuInfo.setIowait(Double.parseDouble(array[5]));
                    irq = Double.parseDouble(array[6]);
                    softirq = Double.parseDouble(array[7]);
                    cpuInfo.setUser(cpuInfo.getUser() + nice);
                    cpuInfo.setSystem(cpuInfo.getSystem() + irq + softirq);
                }
            }
        } catch (Exception e) {
            LOGGER.error(String.format("read %s error.", cpufp.getAbsolutePath()), e);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                LOGGER.error(String.format("close BufferedReader error. file = %s", cpufp.getAbsolutePath()), e);
            }
        }
        return cpuInfo;
    }

    /**
     * Obtain information on the disk
     *
     * @param iofp io file
     * @return disk info
     */
    private List<PartInfo> getPartitions(File iofp) {
        int nPartitions = 0;
        List<PartInfo> partitions = new ArrayList<>();
        //read /proc/partitions or /proc/diskstats
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(iofp));
            String tempString;
            while ((tempString = reader.readLine()) != null) {
                PartInfo partInfo = new PartInfo();
                int reads;
                tempString = tempString.replaceAll(" {2,}", " ").trim();
                String[] array = tempString.split(" ");
                partInfo.setMajor(Integer.parseInt(array[0])); //Major
                partInfo.setMinor(Integer.parseInt(array[1])); //Minor
                partInfo.setName(array[2]);  //磁盘名称
                reads = Integer.parseInt(array[3]);
                int p = 0;
                while (p < nPartitions && (partitions.get(p).getMajor() != partInfo.getMajor() || partitions.get(p).getMinor() != partInfo.getMinor())) {
                    p++;
                }
                if (p == nPartitions && p < MAX_PARTITIONS) {
                    if (reads != 0 && (p == 0 || !partInfo.getName().contains(partitions.get(p - 1).getName()))) {
                        partitions.add(partInfo);
                        nPartitions = p + 1;
                    }
                }
            }
        } catch (IOException e) {
            LOGGER.error(String.format("read io info error, file = %s", iofp.getAbsolutePath()), e);
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                LOGGER.error(String.format("close BufferedReader error, file = %s", iofp.getAbsolutePath()), e);
            }
        }
        return partitions;
    }

    @Override
    public void run() {
        start();
    }
}
