package com.gcj.bean;

/**
 * Created by gaochuanjun on 14-5-13.
 */
public class IOStatMonitor{

    private String ip;

    private String updateTime;

    private String name;

    private float await;

    private float svctm;

    private float util;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAwait() {
        return await;
    }

    public void setAwait(float await) {
        this.await = await;
    }

    public float getSvctm() {
        return svctm;
    }

    public void setSvctm(float svctm) {
        this.svctm = svctm;
    }

    public float getUtil() {
        return util;
    }

    public void setUtil(float util) {
        this.util = util;
    }
}
