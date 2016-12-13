package net.monitor.main;

import net.monitor.cpu.TotalCPUMonitor;
import net.monitor.io.IOStat;
import net.monitor.netstat.NetstatMonitor;
import net.monitor.traffic.Traffic;
import net.monitor.utils.ConfigUtils;
import net.monitor.utils.HostUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created with IntelliJ IDEA. User: zyj Date: 13-5-15 Time: 下午2:49 To change
 * this template use File | Settings | File Templates.
 */
public class MonitorMain {

    private static final Log LOG = LogFactory.getLog(MonitorMain.class);

    public static void main(String[] args) {

        if (args != null) {
            StringBuilder sb = new StringBuilder();
            for (String arg : args) {
                sb.append(arg.charAt(arg.length() - 1)).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            LOG.info("输入的参数为：" + sb.toString());
        } else {
            LOG.info("未输入任何参数！");
        }

        MonitorMain monitorMain = new MonitorMain();
        monitorMain.start(args);
    }

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
            startTraffic(conf, localhostIP, sampleTime);
            startIO(localhostIP);
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
    }

    private void startIO(String localhostIP) {
        IOStat ioStat = new IOStat(localhostIP);
        Thread t = new Thread(ioStat);
        t.start();
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

        String processName = conf.getString("process_name");
        LOG.info("Process Name: " + processName);
        new Thread(new TotalCPUMonitor(localhostIP, processName, sampleTime)).start();

        LOG.info("Start The Monitor for CPU & Memory.      [OK]");
    }
}
