package com.gcj.bean;

/**
 * Created with IntelliJ IDEA. User: zyj Date: 13-5-15 Time: 下午3:11 To change
 * this template use File | Settings | File Templates.
 */
public class ProcessInfoBean {

    private String localHostIp;
    private int pid;
    private String updateTime;
    private String proceeName;
    private float cpuUsage;
    private int memUsage;

    public String getProceeName() {
        return proceeName;
    }

    public void setProceeName(String proceeName) {
        this.proceeName = proceeName;
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

    public int getMemUsage() {
        return memUsage;
    }

    public void setMemUsage(int memUsage) {
        this.memUsage = memUsage;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getLocalHostIp() {
        return localHostIp;
    }

    public void setLocalHostIp(String localHostIp) {
        this.localHostIp = localHostIp;
    }
}
