package com.gcj.main;

import com.gcj.cpu.TotalCPUMonitor;
import com.gcj.netstat.NetstatMonitor;
import com.gcj.traffic.Traffic;
import com.gcj.io.IOStat;
import com.gcj.utils.ConfigUtils;
import com.gcj.utils.HostUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created with IntelliJ IDEA. User: zyj Date: 13-5-15 Time: 下午2:49 To change
 * this template use File | Settings | File Templates.
 */
public class MonitorMain {

    private static final Log LOG = LogFactory.getLog(MonitorMain.class);

    public void start(String[] args) {

        String configFilePath = "../conf/infoconfig.properties";

        ConfigUtils conf = new ConfigUtils(configFilePath);

        //String os = conf.getString("os");

        String localhostIP = HostUtil.getLinuxHostIP();

//        if (os.equalsIgnoreCase("Windows")) {
//            localhostIP = HostUtil.getWindowsHostIP();
//            Constants.OS = 1;
//        } else if (os.equalsIgnoreCase("Linux")) {
//            localhostIP = HostUtil.getLinuxHostIP();
//            Constants.OS = 0;
//        } else {
//            localhostIP = HostUtil.getHostIP();
//        }

        LOG.info("The IP Address of Localhost: " + localhostIP);

        int sampleTime = conf.getInt("sampling_time");
        LOG.info("Sample Time: " + sampleTime);

        if (args.length == 0) {
            startCPUAndMenory(conf, localhostIP, sampleTime);
        } else {
            for (String arg : args) {
                switch (arg.charAt(arg.length() - 1)) {
                    case 'c':
                        startCPUAndMenory(conf, localhostIP, sampleTime);
                        break;
                    case 't':
                        startTraffic(conf, localhostIP, sampleTime);
                        break;
                    case 'n':
                        startNetstat(conf, localhostIP, sampleTime);
                        break;
                    case 'i':
                        startIO(localhostIP);
                        break;
                    default:
                        LOG.error("输入参数错误" + arg + "请输入./startup.sh -h/--help查看帮助选项");
                        System.exit(1);
                }
            }
        }


//        String pidPath = conf.getString("pidPath");
//        String processName = conf.getString("process_name");
//        int sampleTime = conf.getInt("sampling_time");
//        String localhostIP = HostUtil.getLocalHostIP();
//        String pid = FileUtils.getPidOnce(pidPath);
//        String cmd = "top -p " + pid + " -b -n 1";
//        int listeningPort = conf.getInt("listening_port");
//        String networkCardName = conf.getString("network_card_name");
//        boolean isCollectCPUAndMemory = conf.getBoolean("collect_cpu_memory");
//        boolean isCollectTraffic = conf.getBoolean("collect_traffic");
//        boolean isCollectNetstat = conf.getBoolean("collect_netstat");
//        boolean isSimpleProcess = conf.getBoolean("simple_process");
//        LOG.info("The Path of Process Id: " + pidPath);
//        LOG.info("Process Name: " + processName);
//        LOG.info("Sample Time: " + sampleTime);
//        LOG.info("The IP Address of Localhost: " + localhostIP);
//        LOG.info("Process Id: " + pid);
//        LOG.info("Top Command For Collecting CPU & Memory: " + cmd);
//        LOG.info("The Port for netstat: " + listeningPort);
//        LOG.info("The Name of Network Card: " + networkCardName);
//        LOG.info("Is Collect CPU & Memory: " + isCollectCPUAndMemory);
//        LOG.info("Is Collect Traffic: " + isCollectTraffic);
//        LOG.info("Is Collect Netstat: " + isCollectNetstat);
//        LOG.info("Is Simple Process: " + isSimpleProcess);
//        if (isCollectCPUAndMemory && isSimpleProcess) {
//            LOG.info("Starting The Thread for CPU & Memory......");
//            new Thread(new CPUAndMemMonitor(cmd, processName, pid, sampleTime, localhostIP)).start();
//        } else if (!isSimpleProcess && isCollectCPUAndMemory) {
//            String[] array = pid.split(",");
//            for (int i = 0; i < array.length; i++) {
//                LOG.info("Starting The Thread[" + i + "] for CPU & Memory......");
//                new Thread(new CPUAndMemMonitor(cmd, processName, array[i], sampleTime, localhostIP)).start();
//            }
//        }
//        if (isCollectTraffic) {
//            LOG.info("Starting The Thread for traffic......");
//            new Thread(new Traffic(sampleTime, localhostIP, networkCardName)).start();
//        }
//        if (isCollectNetstat) {
//            LOG.info("Starting The Thread for netstat......");
//            new Thread(new NetstatMonitor(localhostIP, sampleTime, listeningPort)).start();
//        }
    }

    private void startIO(String localhostIP) {
        IOStat ioStat = new IOStat(localhostIP);
        Thread t = new Thread(ioStat);
        t.start();
        //new Thread(new IOStat()).start();

        LOG.info("Starting The Monitor for IOStat.      [OK]");
    }

    private void startNetstat(ConfigUtils conf, String localhostIP, int sampleTime) {

        int listeningPort = conf.getInt("listening_port");
        LOG.info("The Port for netstat: " + listeningPort);

        new Thread(new NetstatMonitor(localhostIP, sampleTime, listeningPort)).start();
        LOG.info("Starting The Monitor for netstat.      [OK]");
    }


    private void startTraffic(ConfigUtils conf, String localhostIP, int sampleTime) {

        String networkCardName = conf.getString("network_card_name");
        LOG.info("The Name of Network Card: " + networkCardName);

        new Thread(new Traffic(sampleTime, localhostIP, networkCardName)).start();
        LOG.info("Start The Monitor for Traffic.      [OK]");
    }

    private void startCPUAndMenory(ConfigUtils conf, String localhostIP, int sampleTime) {

//        String pidPath = conf.getString("pidPath");
//        LOG.info("The Path of Process Id: " + pidPath);

//        String pid = FileUtils.getPidOnce(pidPath);
//        LOG.info("Process Id: " + pid);

//        String cmd = "top -p " + pid + " -b -n 1";
//        LOG.info("Top Command For Collecting CPU & Memory: " + cmd);

        String processName = conf.getString("process_name");
        LOG.info("Process Name: " + processName);

//        if (pid == null) {
//            LOG.error("请确认进程ID的文件路径是正确的：pidPath=" + pidPath);
//            System.exit(1);
//        }

//        new Thread(new CPUAndMemMonitor(cmd, processName, pid, sampleTime, localhostIP)).start();
        new Thread(new TotalCPUMonitor(localhostIP, processName, sampleTime)).start();

        LOG.info("Start The Monitor for CPU & Memory.      [OK]");
    }

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        for (String arg : args) {
            sb.append(arg.charAt(arg.length() - 1)).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        LOG.info("输入的参数为：" + sb.toString());
        MonitorMain monitorMain = new MonitorMain();
        monitorMain.start(args);
    }
}
