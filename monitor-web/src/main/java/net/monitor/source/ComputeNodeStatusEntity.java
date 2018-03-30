package net.monitor.source;

import java.sql.Timestamp;

/**
 * @author gaochuanjun
 * @since 14-5-13
 */
public class ComputeNodeStatusEntity {

  private String nodeName;
  private Timestamp updateTime;
  private Float oneMinsProcs;
  private Float fiveMinsProcs;
  private Float fifteenMinsProcs;
  private Float totalTime;
  private Float userTime;
  private Float niceTime;
  private Float systemTime;
  private Float iowaitTime;
  private Float idleTime;
  private String allTotalTime;
  private String allUserTime;
  private String allNiceTime;
  private String allSystemTime;
  private String allIowaitTime;
  private String allIdleTime;
  private Integer totalMemory;
  private Integer usedMemory;
  private Integer idleMemory;
  private Integer swapSize;
  private Integer usedSwap;
  private Integer idleSwap;

  public String getNodeName() {
    return nodeName;
  }

  public void setNodeName(String nodeName) {
    this.nodeName = nodeName;
  }

  public Timestamp getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Timestamp updateTime) {
    this.updateTime = updateTime;
  }

  public Float getOneMinsProcs() {
    return oneMinsProcs;
  }

  public void setOneMinsProcs(Float oneMinsProcs) {
    this.oneMinsProcs = oneMinsProcs;
  }

  public Float getFiveMinsProcs() {
    return fiveMinsProcs;
  }

  public void setFiveMinsProcs(Float fiveMinsProcs) {
    this.fiveMinsProcs = fiveMinsProcs;
  }

  public Float getFifteenMinsProcs() {
    return fifteenMinsProcs;
  }

  public void setFifteenMinsProcs(Float fifteenMinsProcs) {
    this.fifteenMinsProcs = fifteenMinsProcs;
  }

  public Float getTotalTime() {
    return totalTime;
  }

  public void setTotalTime(Float totalTime) {
    this.totalTime = totalTime;
  }

  public Float getUserTime() {
    return userTime;
  }

  public void setUserTime(Float userTime) {
    this.userTime = userTime;
  }

  public Float getNiceTime() {
    return niceTime;
  }

  public void setNiceTime(Float niceTime) {
    this.niceTime = niceTime;
  }

  public Float getSystemTime() {
    return systemTime;
  }

  public void setSystemTime(Float systemTime) {
    this.systemTime = systemTime;
  }

  public Float getIowaitTime() {
    return iowaitTime;
  }

  public void setIowaitTime(Float iowaitTime) {
    this.iowaitTime = iowaitTime;
  }

  public Float getIdleTime() {
    return idleTime;
  }

  public void setIdleTime(Float idleTime) {
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

  public Integer getTotalMemory() {
    return totalMemory;
  }

  public void setTotalMemory(Integer totalMemory) {
    this.totalMemory = totalMemory;
  }

  public Integer getUsedMemory() {
    return usedMemory;
  }

  public void setUsedMemory(Integer usedMemory) {
    this.usedMemory = usedMemory;
  }

  public Integer getIdleMemory() {
    return idleMemory;
  }

  public void setIdleMemory(Integer idleMemory) {
    this.idleMemory = idleMemory;
  }

  public Integer getSwapSize() {
    return swapSize;
  }

  public void setSwapSize(Integer swapSize) {
    this.swapSize = swapSize;
  }

  public Integer getUsedSwap() {
    return usedSwap;
  }

  public void setUsedSwap(Integer usedSwap) {
    this.usedSwap = usedSwap;
  }

  public Integer getIdleSwap() {
    return idleSwap;
  }

  public void setIdleSwap(Integer idleSwap) {
    this.idleSwap = idleSwap;
  }
}
