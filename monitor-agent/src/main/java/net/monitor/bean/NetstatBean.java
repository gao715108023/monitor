package net.monitor.bean;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-8
 * Time: 上午10:58
 * To change this template use File | Settings | File Templates.
 */
public class NetstatBean {

  private String localHostIp;
  private int port;
  private String updateTime;
  private int total;
  private int established;
  private int timeWait;
  private int finWait2;

  public String getLocalHostIp() {
    return localHostIp;
  }

  public void setLocalHostIp(String localHostIp) {
    this.localHostIp = localHostIp;
  }

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }

  public String getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(String updateTime) {
    this.updateTime = updateTime;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public int getEstablished() {
    return established;
  }

  public void setEstablished(int established) {
    this.established = established;
  }

  public int getTimeWait() {
    return timeWait;
  }

  public void setTimeWait(int timeWait) {
    this.timeWait = timeWait;
  }

  public int getFinWait2() {
    return finWait2;
  }

  public void setFinWait2(int finWait2) {
    this.finWait2 = finWait2;
  }
}
