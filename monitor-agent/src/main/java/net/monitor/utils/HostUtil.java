package net.monitor.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;
import org.hyperic.sigar.OperatingSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HostUtil {

  private static final Logger LOGGER = LoggerFactory.getLogger(HostUtil.class);

  private static final String WINDOWS = "Windows";

  public static String getLinuxHostIP() throws Exception {
    String localHostIP = null;
    Enumeration<NetworkInterface> netInterfaces;
    try {
      netInterfaces = NetworkInterface.getNetworkInterfaces();
      while (netInterfaces.hasMoreElements()) {
        NetworkInterface ni = netInterfaces.nextElement();
        Enumeration<InetAddress> ips = ni.getInetAddresses();
        while (ips.hasMoreElements()) {
          String ip = ips.nextElement().getHostAddress();
          if (isIp(ip) && !"127.0.0.1".equals(ip)) {
            localHostIP = ip;
          }
        }
      }
    } catch (Exception e) {
      LOGGER.error("get linux ip error.", e);
    }
    if (localHostIP == null) {
      throw new Exception("get linux ip error. local_ip = null.");
    }
    return localHostIP;
  }

  public static String getWindowsHostIP() throws Exception {
    String localHostIP = null;
    try {
      localHostIP = InetAddress.getLocalHost().getHostAddress();
    } catch (UnknownHostException e) {
      LOGGER.error("get windows ip error.", e);
    }
    if (localHostIP == null) {
      throw new Exception("get windows ip error. local_ip = null.");
    }
    return localHostIP;
  }

  public static String getHostIP() throws Exception {
    OperatingSystem os = OperatingSystem.getInstance();
    String vendorName = os.getVendorName();
    if (vendorName.contains(WINDOWS)) {
      Constants.OS = 1;
      return getWindowsHostIP();
    } else {
      Constants.OS = 0;
      return getLinuxHostIP();
    }

  }

  private static boolean isIp(String ipAddress) {
    String regex = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
        + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
        + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
        + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
    return ipAddress.matches(regex);
  }
}
