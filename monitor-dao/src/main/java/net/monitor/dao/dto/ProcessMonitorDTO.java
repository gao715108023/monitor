package net.monitor.dao.dto;

import java.io.Serializable;
import java.util.Date;

public class ProcessMonitorDTO implements Serializable {

  private static final long serialVersionUID = 1L;
  private Long id;
  private String ip;
  private String processName;
  private Integer pid;
  private Float oneMinsProcs;
  private Float fiveMinsProcs;
  private Float fifteenMinsProcs;
  private Float processCpuUsage;
  private Float processMemoryUsage;
  private Date gmtCreate;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip == null ? null : ip.trim();
  }

  public String getProcessName() {
    return processName;
  }

  public void setProcessName(String processName) {
    this.processName = processName == null ? null : processName.trim();
  }

  public Integer getPid() {
    return pid;
  }

  public void setPid(Integer pid) {
    this.pid = pid;
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

  public Float getProcessCpuUsage() {
    return processCpuUsage;
  }

  public void setProcessCpuUsage(Float processCpuUsage) {
    this.processCpuUsage = processCpuUsage;
  }

  public Float getProcessMemoryUsage() {
    return processMemoryUsage;
  }

  public void setProcessMemoryUsage(Float processMemoryUsage) {
    this.processMemoryUsage = processMemoryUsage;
  }

  public Date getGmtCreate() {
    return gmtCreate;
  }

  public void setGmtCreate(Date gmtCreate) {
    this.gmtCreate = gmtCreate;
  }
}