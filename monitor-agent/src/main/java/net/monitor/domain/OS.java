package net.monitor.domain;

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

    public int getOS() {
        return os;
    }
}
