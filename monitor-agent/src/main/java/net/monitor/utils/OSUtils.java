package net.monitor.utils;

import net.monitor.domain.OS;

/**
 * @author gaochuanjun
 * @since 2017/2/28
 */
public class OSUtils {

    private static final String OS = System.getProperty("os.name").toLowerCase();

    private OS os;

    private OSUtils() {
    }

    public static OSUtils getInstance() {
        return OSUtilsHolder.INSTANCE;
    }

    private static boolean isLinux() {
        return OS.contains("linux");
    }

    private static boolean isMacOS() {
        return OS.contains("mac") && OS.indexOf("os") > 0 && !OS.contains("x");
    }

    private static boolean isMacOSX() {
        return OS.contains("mac") && OS.indexOf("os") > 0 && OS.indexOf("x") > 0;
    }

    private static boolean isWindows() {
        return OS.contains("windows");
    }

    /**
     * 获取操作系统名字
     *
     * @return 操作系统名
     */
    public OS getOS() {
        return os;
    }

    private static class OSUtilsHolder {
        private static final OSUtils INSTANCE = new OSUtils();

        static {
            if (isLinux()) {
                INSTANCE.os = net.monitor.domain.OS.LINUX;
            } else if (isMacOS()) {
                INSTANCE.os = net.monitor.domain.OS.MAC_OS;
            } else if (isMacOSX()) {
                INSTANCE.os = net.monitor.domain.OS.MAC_OS_X;
            } else if (isWindows()) {
                INSTANCE.os = net.monitor.domain.OS.WINDOWS;
            } else {
                INSTANCE.os = net.monitor.domain.OS.OTHERS;
            }
        }
    }
}
