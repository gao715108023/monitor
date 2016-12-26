package net.monitor.utils;

import org.hyperic.sigar.OperatingSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class HostUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(HostUtil.class);

    public static String getLinuxHostIP() {
        String localHostIP = null;
        Enumeration<NetworkInterface> netInterfaces;
        try {
            netInterfaces = NetworkInterface.getNetworkInterfaces();
            while (netInterfaces.hasMoreElements()) {
                NetworkInterface ni = netInterfaces.nextElement();
                Enumeration<InetAddress> ips = ni.getInetAddresses();
                while (ips.hasMoreElements()) {
                    String ip = ips.nextElement().getHostAddress();
                    if (isIp(ip) && !ip.equals("127.0.0.1")) {
                        localHostIP = ip;
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.error("get ip error.", e);
        }
        return localHostIP;
    }

    public static String getWindowsHostIP() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            LOGGER.error("get ip error.", e);
        }
        return null;
    }

    public static String getHostIP() {
        OperatingSystem os = OperatingSystem.getInstance();
        String vendorName = os.getVendorName();
        if (vendorName.contains("Windows")) {
            Constants.OS = 1;
            return getWindowsHostIP();
        } else {
            Constants.OS = 0;
            return getLinuxHostIP();
        }

    }

    private static boolean isIp(String ipAddress) {
        String regex = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\." + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\." + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\." + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
        return ipAddress.matches(regex);
    }
}
