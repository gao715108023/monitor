package net.monitor.domain;

/**
 * @author gaochuanjun
 * @since 14-5-12
 */
public class CPUInfo {

  private double user;
  private double system;
  private double idle;
  private double iowait;

  public CPUInfo() {
  }

  public CPUInfo(double user, double system, double idle, double iowait) {
    this.user = user;
    this.system = system;
    this.idle = idle;
    this.iowait = iowait;
  }

  public double getUser() {
    return user;
  }

  public void setUser(double user) {
    this.user = user;
  }

  public double getSystem() {
    return system;
  }

  public void setSystem(double system) {
    this.system = system;
  }

  public double getIdle() {
    return idle;
  }

  public void setIdle(double idle) {
    this.idle = idle;
  }

  public double getIowait() {
    return iowait;
  }

  public void setIowait(double iowait) {
    this.iowait = iowait;
  }
}
