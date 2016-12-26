package net.monitor.main;

import net.monitor.domain.OS;
import net.monitor.gather.io.IOStatMonitor;
import net.monitor.gather.netstat.NetstatMonitor;
import net.monitor.gather.process.ProcessCPUAndMemoryMonitor;
import net.monitor.gather.traffic.TrafficMonitor;
import net.monitor.utils.Config;
import net.monitor.utils.HostUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA. User: zyj Date: 13-5-15 Time: 下午2:49 To change
 * this template use File | Settings | File Templates.
 */
public class MonitorMain {

    private static final Logger LOGGER = LoggerFactory.getLogger(MonitorMain.class);

    public static void main(String[] args) {

        MonitorMain monitorMain = new MonitorMain();
        try {
            monitorMain.start();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            System.exit(-1);
        }
    }

    public void start() throws Exception {
        String localHostIp = null;
        if (OS.LINUX == Config.os) {
            localHostIp = HostUtil.getLinuxHostIP();
        } else if (OS.WINDOWS == Config.os) {
            localHostIp = HostUtil.getWindowsHostIP();
        }
        if (localHostIp == null || localHostIp.equals("")) {
            throw new Exception("获取ip异常！");
        }

        LOGGER.info("ip: {}", localHostIp);

        new Thread(new ProcessCPUAndMemoryMonitor(localHostIp)).start();

        new Thread(new IOStatMonitor(localHostIp)).start();

        new Thread(new NetstatMonitor(localHostIp)).start();

        new Thread(new TrafficMonitor(localHostIp)).start();

        //if (args.length == 0) {
        //    startProcessCPUAndMemory(conf, localhostIP, sampleTime);
        //    startTraffic(conf, localhostIP, sampleTime);
        //    startIO(localhostIP);
        //} else {
        //    for (String arg : args) {
        //        switch (arg.charAt(arg.length() - 1)) {
        //            case 'c':
        //                startProcessCPUAndMemory(conf, localhostIP, sampleTime);
        //                break;
        //            case 't':
        //                startTraffic(conf, localhostIP, sampleTime);
        //                break;
        //            case 'n':
        //                startNetstat(conf, localhostIP, sampleTime);
        //                break;
        //            case 'i':
        //                startIO(localhostIP);
        //                break;
        //            default:
        //                LOG.error("输入参数错误" + arg + "请输入./startup.sh -h/--help查看帮助选项");
        //                System.exit(1);
        //        }
        //    }
        //}
    }

    //private void startIO(String localhostIP) {
    //    IOStatInfo ioStat = new IOStatInfo(localhostIP);
    //    Thread t = new Thread(ioStat);
    //    t.start();
    //    LOGGER.info("Starting The Monitor for IOStatInfo.      [OK]");
    //}

    //private void startNetstat(ConfigUtils conf, String localhostIP, int sampleTime) {
    //
    //    int listeningPort = conf.getInt("listening_port");
    //    LOGGER.info("The Port for netstat: " + listeningPort);
    //
    //    new Thread(new NetstatMonitor(localhostIP)).start();
    //    LOGGER.info("Starting The Monitor for netstat.      [OK]");
    //}

    //private void startTraffic(ConfigUtils conf, String localhostIP, int sampleTime) {

    //String networkCardName = conf.getString("network_card_name");
    //LOGGER.info("The Name of Network Card: " + networkCardName);
    //
    //new Thread(new TrafficMonitor(sampleTime, localhostIP, networkCardName)).start();
    //LOGGER.info("Start The Monitor for TrafficMonitor.      [OK]");
    //}

    //private void startProcessCPUAndMemory(ConfigUtils conf, String localhostIP, int sampleTime) {
    //
    //    String processName = conf.getString("process_name");
    //    LOGGER.info("Process Name: " + processName);
    //    new Thread(new ProcessCPUAndMemoryMonitor(localhostIP)).start();
    //
    //    LOGGER.info("Start The Monitor for CPU & Memory.      [OK]");
    //}
}
