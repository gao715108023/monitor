package net.monitor.bean;

public class SystemResourceBean {

    private String localHostIp;
    private String updateTime;
    private float cpuUsage;
    private float memUsage;

    public String getLocalHostIp() {
        return localHostIp;
    }

    public void setLocalHostIp(String localHostIp) {
        this.localHostIp = localHostIp;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public float getCpuUsage() {
        return cpuUsage;
    }

    public void setCpuUsage(float cpuUsage) {
        this.cpuUsage = cpuUsage;
    }

    public float getMemUsage() {
        return memUsage;
    }

    public void setMemUsage(float memUsage) {
        this.memUsage = memUsage;
    }
}
