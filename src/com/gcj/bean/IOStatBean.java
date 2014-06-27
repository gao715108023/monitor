package com.gcj.bean;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-12-17
 * Time: 下午6:33
 * To change this template use File | Settings | File Templates.
 */
public class IOStatBean {

    private String ip;

    private String updateTime;

    private float user;

    private float nice;

    private float system;

    private float iowait;

    private float steal;

    private float idle;

    private double tps;

    private double blkReadSpeed;

    private double blkWrtnSpeed;

    private double blkRead;

    private double blkWrtn;

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

    public float getUser() {
        return user;
    }

    public void setUser(float user) {
        this.user = user;
    }

    public float getNice() {
        return nice;
    }

    public void setNice(float nice) {
        this.nice = nice;
    }

    public float getSystem() {
        return system;
    }

    public void setSystem(float system) {
        this.system = system;
    }

    public float getIowait() {
        return iowait;
    }

    public void setIowait(float iowait) {
        this.iowait = iowait;
    }

    public float getSteal() {
        return steal;
    }

    public void setSteal(float steal) {
        this.steal = steal;
    }

    public float getIdle() {
        return idle;
    }

    public void setIdle(float idle) {
        this.idle = idle;
    }

    public double getTps() {
        return tps;
    }

    public void setTps(double tps) {
        this.tps = tps;
    }

    public double getBlkReadSpeed() {
        return blkReadSpeed;
    }

    public void setBlkReadSpeed(double blkReadSpeed) {
        this.blkReadSpeed = blkReadSpeed;
    }

    public double getBlkWrtnSpeed() {
        return blkWrtnSpeed;
    }

    public void setBlkWrtnSpeed(double blkWrtnSpeed) {
        this.blkWrtnSpeed = blkWrtnSpeed;
    }

    public double getBlkRead() {
        return blkRead;
    }

    public void setBlkRead(double blkRead) {
        this.blkRead = blkRead;
    }

    public double getBlkWrtn() {
        return blkWrtn;
    }

    public void setBlkWrtn(double blkWrtn) {
        this.blkWrtn = blkWrtn;
    }
}
