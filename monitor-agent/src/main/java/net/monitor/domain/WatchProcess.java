package net.monitor.domain;

/**
 * @author gaochuanjun
 * @since 2016/12/23
 */
public class WatchProcess {

    private String processName;

    private int pid;

    private String pidPath;

    public WatchProcess() {
    }

    public WatchProcess(String processName, String pidPath) {
        this.processName = processName;
        this.pidPath = pidPath;
    }

    public WatchProcess(String processName, int pid, String pidPath) {
        this.processName = processName;
        this.pid = pid;
        this.pidPath = pidPath;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPidPath() {
        return pidPath;
    }

    public void setPidPath(String pidPath) {
        this.pidPath = pidPath;
    }

    @Override
    public String toString() {
        return "WatchProcess{" +
                "processName='" + processName + '\'' +
                ", pid=" + pid +
                ", pidPath='" + pidPath + '\'' +
                '}';
    }
}
