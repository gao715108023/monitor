package net.monitor.domain;

public class PartInfo {

  /**
   * Device major number
   */
  private int major;
  /**
   * Device minor number
   */
  private int minor;
  private String name;

  public int getMajor() {
    return major;
  }

  public void setMajor(int major) {
    this.major = major;
  }

  public int getMinor() {
    return minor;
  }

  public void setMinor(int minor) {
    this.minor = minor;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}