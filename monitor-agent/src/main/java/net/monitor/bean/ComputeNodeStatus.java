package net.monitor.bean;

/**
 * @author gaochuanjun
 * @since 2014/6/16
 */
public class ComputeNodeStatus {

  private String nodeName;

  private String updateTime;

  private float oneMinsProcs;

  private float fiveMinsProcs;

  private float fifteenMinsProcs;

  private float totalTime;

  private float userTime;

  private float niceTime;

  private float systemTime;

  private float iowaitTime;

  private float idleTime;

  private String allTotalTime;

  private String allUserTime;

  private String allNiceTime;

  private String allSystemTime;

  private String allIowaitTime;

  private String allIdleTime;

  private int totalMemory;

  private int usedMemory;

  private int idleMemory;

  private int swapSize;

  private int usedSwap;

  private int idleSwap;

  public String getNodeName() {
    return nodeName;
  }

  public void setNodeName(String nodeName) {
    this.nodeName = nodeName;
  }

  public String getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(String updateTime) {
    this.updateTime = updateTime;
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

  public float getTotalTime() {
    return totalTime;
  }

  public void setTotalTime(float totalTime) {
    this.totalTime = totalTime;
  }

  public float getUserTime() {
    return userTime;
  }

  public void setUserTime(float userTime) {
    this.userTime = userTime;
  }

  public float getNiceTime() {
    return niceTime;
  }

  public void setNiceTime(float niceTime) {
    this.niceTime = niceTime;
  }

  public float getSystemTime() {
    return systemTime;
  }

  public void setSystemTime(float systemTime) {
    this.systemTime = systemTime;
  }

  public float getIowaitTime() {
    return iowaitTime;
  }

  public void setIowaitTime(float iowaitTime) {
    this.iowaitTime = iowaitTime;
  }

  public float getIdleTime() {
    return idleTime;
  }

  public void setIdleTime(float idleTime) {
    this.idleTime = idleTime;
  }

  public String getAllTotalTime() {
    return allTotalTime;
  }

  public void setAllTotalTime(String allTotalTime) {
    this.allTotalTime = allTotalTime;
  }

  public String getAllUserTime() {
    return allUserTime;
  }

  public void setAllUserTime(String allUserTime) {
    this.allUserTime = allUserTime;
  }

  public String getAllNiceTime() {
    return allNiceTime;
  }

  public void setAllNiceTime(String allNiceTime) {
    this.allNiceTime = allNiceTime;
  }

  public String getAllSystemTime() {
    return allSystemTime;
  }

  public void setAllSystemTime(String allSystemTime) {
    this.allSystemTime = allSystemTime;
  }

  public String getAllIowaitTime() {
    return allIowaitTime;
  }

  public void setAllIowaitTime(String allIowaitTime) {
    this.allIowaitTime = allIowaitTime;
  }

  public String getAllIdleTime() {
    return allIdleTime;
  }

  public void setAllIdleTime(String allIdleTime) {
    this.allIdleTime = allIdleTime;
  }

  public int getTotalMemory() {
    return totalMemory;
  }

  public void setTotalMemory(int totalMemory) {
    this.totalMemory = totalMemory;
  }

  public int getUsedMemory() {
    return usedMemory;
  }

  public void setUsedMemory(int usedMemory) {
    this.usedMemory = usedMemory;
  }

  public int getIdleMemory() {
    return idleMemory;
  }

  public void setIdleMemory(int idleMemory) {
    this.idleMemory = idleMemory;
  }

  public int getSwapSize() {
    return swapSize;
  }

  public void setSwapSize(int swapSize) {
    this.swapSize = swapSize;
  }

  public int getUsedSwap() {
    return usedSwap;
  }

  public void setUsedSwap(int usedSwap) {
    this.usedSwap = usedSwap;
  }

  public int getIdleSwap() {
    return idleSwap;
  }

  public void setIdleSwap(int idleSwap) {
    this.idleSwap = idleSwap;
  }
}
