package net.monitor.main;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;
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

  private static final ExecutorService THREAD_POOL = new ThreadPoolExecutor(10, 10, 0L,
      TimeUnit.MILLISECONDS,
      new LinkedBlockingQueue<Runnable>(1024),
      new ThreadFactoryBuilder().setNameFormat("monitor-pool-%d")
          .build(), new AbortPolicy());


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
        THREAD_POOL.execute(new ProcessCPUAndMemoryMonitor(localHostIp));
        THREAD_POOL.execute(new IOStatMonitor(localHostIp));
        THREAD_POOL.execute(new NetstatMonitor(localHostIp));
        THREAD_POOL.execute(new TrafficMonitor(localHostIp));
        break;
      case WINDOWS:
        localHostIp = HostUtil.getWindowsHostIP();
        LOGGER.info("ip: {}", localHostIp);
        THREAD_POOL.execute(new NetstatMonitorForWindows(localHostIp));
        THREAD_POOL.execute(new TrafficForWindows(localHostIp));
        break;
      default:
        throw new IllegalArgumentException("暂不支持该操作系统！os = " + Config.os);
    }
  }
}
