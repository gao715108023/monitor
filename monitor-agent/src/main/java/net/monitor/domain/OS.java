package net.monitor.domain;

import org.hyperic.sigar.OperatingSystem;

/**
 * @author gaochuanjun
 * @since 15/4/15
 */
public enum OS {

    LINUX(0),
    WINDOWS(1);

    private final int os;

    OS(int os) {
        this.os = os;
    }

    public static OS findOS(int os) {
        switch (os) {
            case 0:
                return LINUX;
            case 1:
                return WINDOWS;
            default:
                return LINUX;
        }
    }

    public static OS findOS() {
        OperatingSystem os = OperatingSystem.getInstance();
        String vendorName = os.getVendorName();
        if (vendorName.contains("Windows")) {
            return WINDOWS;
        } else {
            return LINUX;
        }
    }

    public int getOS() {
        return os;
    }
}
