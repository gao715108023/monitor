package com.gcj.bean;

/**
 * Created by gaochuanjun on 14-3-3.
 */
public class ServerMsgBean{

    private String ip;
    private int pid;
    private String updateTime;
    private String proceeName;
    private float oneMinsProcs;
    private float fiveMinsProcs;
    private float fifteenMinsProcs;
    private float cpuUsage;
    private float iowaitTime;
    private int memUsage;


    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getProceeName() {
        return proceeName;
    }

    public void setProceeName(String proceeName) {
        this.proceeName = proceeName;
    }

    public float getOneMinsProcs() {
        return oneMinsProcs;
    }

    public void setOneMinsProcs(float oneMinsProcs) {
        this.oneMinsProcs = oneMinsProcs;
    }


    public float getFiveMinsProcs() {
        return fiveMinsProcs;
    }

    public void setFiveMinsProcs(float fiveMinsProcs) {
        this.fiveMinsProcs = fiveMinsProcs;
    }

    public float getFifteenMinsProcs() {
        return fifteenMinsProcs;
    }

    public void setFifteenMinsProcs(float fifteenMinsProcs) {
        this.fifteenMinsProcs = fifteenMinsProcs;
    }

    public float getCpuUsage() {
        return cpuUsage;
    }

    public void setCpuUsage(float cpuUsage) {
        this.cpuUsage = cpuUsage;
    }

    public float getIowaitTime() {
        return iowaitTime;
    }

    public void setIowaitTime(float iowaitTime) {
        this.iowaitTime = iowaitTime;
    }

    public int getMemUsage() {
        return memUsage;
    }

    public void setMemUsage(int memUsage) {
        this.memUsage = memUsage;
    }
}
