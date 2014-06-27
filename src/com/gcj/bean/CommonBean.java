package com.gcj.bean;

/**
 * Created by gaochuanjun on 14-6-4.
 */
public abstract class CommonBean {

    private String ip;

    private String updateTime;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
