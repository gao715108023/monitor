package net.monitor.main;

import net.monitor.gather.io.IOStatMonitor;
import net.monitor.gather.netstat.NetstatMonitor;
import net.monitor.gather.netstat.NetstatMonitorForWindows;
import net.monitor.gather.process.ProcessCPUAndMemoryMonitor;
import net.monitor.gather.traffic.TrafficForWindows;
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
        switch (Config.os) {
            case LINUX:
                String localHostIp = HostUtil.getLinuxHostIP();
                LOGGER.info("ip: {}", localHostIp);
                new Thread(new ProcessCPUAndMemoryMonitor(localHostIp)).start();
                new Thread(new IOStatMonitor(localHostIp)).start();
                new Thread(new NetstatMonitor(localHostIp)).start();
                new Thread(new TrafficMonitor(localHostIp)).start();
            case WINDOWS:
                localHostIp = HostUtil.getWindowsHostIP();
                LOGGER.info("ip: {}", localHostIp);
                new Thread(new NetstatMonitorForWindows(localHostIp)).start();
                new Thread(new TrafficForWindows(localHostIp)).start();
            default:
                throw new IllegalArgumentException("暂不支持该操作系统！os = " + Config.os);
        }
    }
}
