package com.gcj.io;

import com.gcj.bean.*;
import com.gcj.behavior.GatherAbstract;
import com.gcj.common.Parameter;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class IOStat extends GatherAbstract {

    private static final Log LOG = LogFactory.getLog(IOStat.class);

    private File iofp;

    private File cpufp;			/* /proc/stat */

    //private int kernel; //Kernel: 4 (2.4, /proc/partitions) or 6 (2.6, /proc/diskstats)

    //private List<BlkioInfo> newBlkio = new ArrayList<BlkioInfo>();

    BlkioInfo[] newBlkio;

    //private List<BlkioInfo> oldBlkio = new ArrayList<BlkioInfo>();

    BlkioInfo[] oldBlkio;

    CPUInfo newCPU = new CPUInfo();

    CPUInfo oldCPU = new CPUInfo(0, 0, 0, 0);

    private int nPartitions;

    int MAX_PARTITIONS = 64;

    //PartInfo[] partition = new PartInfo[MAX_PARTITIONS];
    List<PartInfo> partition = new ArrayList<PartInfo>();

    private int ncpu;		/* Number of processors */

//    private Formatter f1 = new Formatter(System.out);

    //private ServerMsgDao serverMsgDao;

    // private String ip;

//    public IOStat() {
//        super();
//    }

    public IOStat(String ip) {
        super(ip);
        //this.ip = ip;
        //this.serverMsgDao = MybatisUtils.session.getMapper(ServerMsgDao.class);
    }

    private void getNumberOfCPUs() {
        File ncpufp = new File("/proc/cpuinfo");
        if (!ncpufp.exists())
            LOG.error("Can't open /proc/cpuinfo");

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(ncpufp));
            String tempString;
            while ((tempString = reader.readLine()) != null) {
                if (tempString.contains("processor\t:")) {
                    ncpu++;
                }
            }
//            System.out.println("cpus: " + ncpu);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (ncpu == 0)
            LOG.error("Error parsing /proc/cpuinfo");
    }

    public void start() {
        int interval = 1000;
        iofp = new File("/proc/diskstats");
        if (!iofp.exists()) {
            iofp = new File("/proc/partitions");
            if (!iofp.exists()) {
                LOG.error("Can't get I/O statistics on this system");
            }
        }

        cpufp = new File("/proc/stat");

        if (!cpufp.exists()) {
            LOG.error("Can't open /proc/stat");
        }

        initialize();

        getNumberOfCPUs();

        while (true) {
            process();
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void process() {

        int p;

        getKernelStats();

        computePersistence();

        /* Save old stats */

        try {
            for (p = 0; p < nPartitions; p++)
                BeanUtils.copyProperties(oldBlkio[p], newBlkio[p]);
            BeanUtils.copyProperties(oldCPU, newCPU);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        // oldBlkio[p] = newBlkio[p];
        //oldBlkio = Arrays.copyOf(newBlkio, newBlkio.length);
        //oldCPU = newCPU;
    }

    /**
     * 计算磁盘信息并存储到数据库
     */
    @Override
    public void computePersistence() {
        int p;
        double deltams = 1000.0 * ((newCPU.getUser() + newCPU.getSystem() + newCPU.getIdle() + newCPU.getIowait()) - (oldCPU.getUser() + oldCPU.getSystem() + oldCPU.getIdle() + oldCPU.getIowait())) / ncpu / Parameter.HZ;

        //System.out.println("1000.0 * ((" + newCPU.getUser() + " + " + newCPU.getSystem() + " + " + newCPU.getIdle() + " + " + newCPU.getIowait() + ") - (" + oldCPU.getUser() + " + " + oldCPU.getSystem() + " + " + oldCPU.getIdle() + " + " + oldCPU.getIowait() + ")) / " + ncpu + " / " + Parameter.HZ);
        //System.out.println("deltams: " + deltams);
//        System.out.println("Device:          rrqm/s    wrqm/s     r/s       w/s      rkB/s     wkB/s     avgrq-sz      avgqu-sz     await      svctm     %util");
        for (p = 0; p < nPartitions; p++) {
            BlkioInfo blkioInfo = new BlkioInfo();
            double nIOs;     //I/O完成次数
            double nTicks;     //每秒I/O花费的毫秒数
            //double nKbytes; //每秒I/O扇区的次数
            double busy;    //磁盘利用率(%) util
            double svcT;	 /* 平均每次输入/输出操作花费的毫秒数svctm*/
            double wait;	 /* 平均每次I/O花费的毫秒数 await*/
            //double size;     //平均1次I/O需要读取多少次扇区 avgrq-sz
            //double queue;	 /* Average queue avgqu-sz*/
            blkioInfo.setRdIos(newBlkio[p].getRdIos() - oldBlkio[p].getRdIos());//每秒读完成次数 r/s
            blkioInfo.setRdMerges(newBlkio[p].getRdMerges() - oldBlkio[p].getRdMerges());//每秒合并读完成次数 rrqm/s
            blkioInfo.setRdSectors(newBlkio[p].getRdSectors() - oldBlkio[p].getRdSectors());//每秒读扇区的次数 rkB/s
            blkioInfo.setRdTicks(newBlkio[p].getRdTicks() - oldBlkio[p].getRdTicks());//每秒读花费的毫秒数
            blkioInfo.setWrIos(newBlkio[p].getWrIos() - oldBlkio[p].getWrIos()); //每秒写完成次数 w/s
            blkioInfo.setWrMerges(newBlkio[p].getWrMerges() - oldBlkio[p].getWrMerges());//每秒合并写完成次数wrqm/s
            blkioInfo.setWrSectors(newBlkio[p].getWrSectors() - oldBlkio[p].getWrSectors());//每秒写扇区次数 wkB/s
            blkioInfo.setWrTicks(newBlkio[p].getWrTicks() - oldBlkio[p].getWrTicks());//每秒写操作花费的毫秒数
            blkioInfo.setTicks(newBlkio[p].getTicks() - oldBlkio[p].getTicks());//每秒输入/输出操作花费的毫秒数
            blkioInfo.setAveq(newBlkio[p].getAveq() - oldBlkio[p].getAveq());//每秒输入/输出操作花费的加权毫秒数

            nIOs = blkioInfo.getRdIos() + blkioInfo.getWrIos();

            nTicks = blkioInfo.getRdTicks() + blkioInfo.getWrTicks();

            //nKbytes = (blkioInfo.getRdSectors() + blkioInfo.getWrSectors()) / 2.0;

            //queue = blkioInfo.getAveq() / deltams;

            //size = (nIOs != 0 ? nKbytes / nIOs : 0.0);

            wait = (nIOs != 0 ? nTicks / nIOs : 0.0);

            svcT = (nIOs != 0 ? blkioInfo.getTicks() / nIOs : 0.0);

            busy = 100.0 * blkioInfo.getTicks() / deltams; /* percentage! */

            if (busy > 100.0)
                busy = 100.0;
            //System.out.println(partition.get(p).getName() + "        " + blkioInfo.getRdMerges() + "    " + blkioInfo.getWrMerges() + "    " + blkioInfo.getRdIos() + "    " + blkioInfo.getWrIos() + "    " + blkioInfo.getRdSectors() / 2.0 + "    " + blkioInfo.getWrSectors() / 2.0 + "    " + round(size) + "    " + round(queue) + "    " + round(wait) + "    " + round(svcT) + "    " + round(busy));
            //f1.format("%-16s %-5.2f %-5.2f %-6.2f %-6.2f %-7.2f %-7.2f %-6.2f %-5.2f %-6.2f %-5.2f %-3.2f", partition.get(p).getName(), (float)blkioInfo.getRdMerges(), (float)blkioInfo.getWrMerges(), (float)blkioInfo.getRdIos(), (float)blkioInfo.getWrIos(), (blkioInfo.getRdSectors() / 2.0), (blkioInfo.getWrSectors() / 2.0), size, queue, wait, svcT, busy);
//            f1.format("%-16s %-9.2f %-9.2f %-9.2f %-9.2f %-9.2f %-9.2f %-9.2f %-9.2f %-9.2f %-9.2f %-9.2f", partition.get(p).getName(), (float) blkioInfo.getRdMerges(), (float) blkioInfo.getWrMerges(), (float) blkioInfo.getRdIos(), (float) blkioInfo.getWrIos(), (blkioInfo.getRdSectors() / 2.0), (blkioInfo.getWrSectors() / 2.0), size, queue, wait, svcT, busy);
//            System.out.println("\n");

            IOStatMonitor ioStatMonitor = new IOStatMonitor();
            ioStatMonitor.setIp(getIp());
            ioStatMonitor.setUpdateTime(getCurrentTime());
            ioStatMonitor.setName(partition.get(p).getName());
            ioStatMonitor.setAwait((float) wait);
            ioStatMonitor.setSvctm((float) svcT);
            ioStatMonitor.setUtil((float) busy);
            getServerMsgDao().insert_iostat_monitor(ioStatMonitor);
            commitTransaction();
        }
    }

    @Override
    public boolean getKernelStats() {

        //获取/proc/partitions中的信息
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

                //得到最新的磁盘信息
                for (int p = 0; p < nPartitions; p++) {
                    if (partition.get(p).getMajor() == partInfo.getMajor() && partition.get(p).getMinor() == partInfo.getMinor()) {
                        try {
                            BeanUtils.copyProperties(newBlkio[p], blkioInfo);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                        //newBlkio[p] = blkioInfo;
                        break;
                    }
                }
            }


            ////获取/proc/stat中的信息
            reader = new BufferedReader(new FileReader(cpufp));
            while ((tempString = reader.readLine()) != null) {
                if (tempString.contains("cpu ")) {
                    double nice, irq, softirq;

                    tempString = tempString.replaceAll(" {2,}", " ").trim();
                    String[] array = tempString.split(" ");
//                    for (int i = 0; i < array.length; i++) {
//                        System.out.println(array[i] + "   ");
//                    }
                    newCPU.setUser(Double.parseDouble(array[1]));
                    nice = Double.parseDouble(array[2]);
                    newCPU.setSystem(Double.parseDouble(array[3]));
                    newCPU.setIdle(Double.parseDouble(array[4]));
                    newCPU.setIowait(Double.parseDouble(array[5]));
                    irq = Double.parseDouble(array[6]);
                    softirq = Double.parseDouble(array[7]);
                    newCPU.setUser(newCPU.getUser() + nice);
                    newCPU.setSystem(newCPU.getSystem() + irq + softirq);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 初始化，获取磁盘的信息
     */
    private void initialize() {

        //获取/proc/partitions中的信息
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

                int p;

                for (p = 0; p < nPartitions && (partition.get(p).getMajor() != partInfo.getMajor() || partition.get(p).getMinor() != partInfo.getMinor()); p++)
                    ;
                if (p == nPartitions && p < MAX_PARTITIONS) {
                    if (reads != 0 && (p == 0 || !partInfo.getName().contains(partition.get(p - 1).getName()))) {
                        //partition[p] = partInfo;
                        partition.add(partInfo);
                        nPartitions = p + 1;
                    }
                }
            }
            oldBlkio = new BlkioInfo[nPartitions];

            for (int i = 0; i < nPartitions; i++)
                oldBlkio[i] = new BlkioInfo(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
            newBlkio = new BlkioInfo[nPartitions];
            for (int i = 0; i < nPartitions; i++)
                newBlkio[i] = new BlkioInfo();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void printPartition() {
        for (PartInfo partInfo : partition) {
            System.out.println(partInfo.getName());
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        IOStat ioStat = new IOStat(HostUtil.getLocalHostIP());
//        ioStat.start();
        //ioStat.initialize();
        //ioStat.printPartition();
    }

    @Override
    public void run() {
        start();
    }
}
