package net.monitor.source;

import java.sql.Timestamp;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * @author gaochuanjun
 * @since 14-5-13
 */
@Entity
@Table(name = "server_monitor", schema = "", catalog = "process")
@IdClass(ServerMonitorEntityPK.class)
public class ServerMonitorEntity {

  private String ip;
  private int processId;
  private Timestamp updateTime;
  private String processName;
  private Float oneMinsProcs;
  private Float fiveMinsProcs;
  private Float fifteenMinsProcs;
  private Float cpuUsage;
  private Float iowaitTime;
  private Integer usedMemory;

  @Id
  @Column(name = "IP", nullable = false, insertable = true, updatable = true, length = 16)
  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  @Id
  @Column(name = "ProcessId", nullable = false, insertable = true, updatable = true)
  public int getProcessId() {
    return processId;
  }

  public void setProcessId(int processId) {
    this.processId = processId;
  }

  @Id
  @Column(name = "UpdateTime", nullable = false, insertable = true, updatable = true)
  public Timestamp getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Timestamp updateTime) {
    this.updateTime = updateTime;
  }

  @Basic
  @Column(name = "ProcessName", nullable = true, insertable = true, updatable = true, length = 32)
  public String getProcessName() {
    return processName;
  }

  public void setProcessName(String processName) {
    this.processName = processName;
  }

  @Basic
  @Column(name = "OneMinsProcs", nullable = true, insertable = true, updatable = true, precision = 2)
  public Float getOneMinsProcs() {
    return oneMinsProcs;
  }

  public void setOneMinsProcs(Float oneMinsProcs) {
    this.oneMinsProcs = oneMinsProcs;
  }

  @Basic
  @Column(name = "FiveMinsProcs", nullable = true, insertable = true, updatable = true, precision = 2)
  public Float getFiveMinsProcs() {
    return fiveMinsProcs;
  }

  public void setFiveMinsProcs(Float fiveMinsProcs) {
    this.fiveMinsProcs = fiveMinsProcs;
  }

  @Basic
  @Column(name = "FifteenMinsProcs", nullable = true, insertable = true, updatable = true, precision = 2)
  public Float getFifteenMinsProcs() {
    return fifteenMinsProcs;
  }

  public void setFifteenMinsProcs(Float fifteenMinsProcs) {
    this.fifteenMinsProcs = fifteenMinsProcs;
  }

  @Basic
  @Column(name = "CPUUsage", nullable = true, insertable = true, updatable = true, precision = 2)
  public Float getCpuUsage() {
    return cpuUsage;
  }

  public void setCpuUsage(Float cpuUsage) {
    this.cpuUsage = cpuUsage;
  }

  @Basic
  @Column(name = "IowaitTime", nullable = true, insertable = true, updatable = true, precision = 2)
  public Float getIowaitTime() {
    return iowaitTime;
  }

  public void setIowaitTime(Float iowaitTime) {
    this.iowaitTime = iowaitTime;
  }

  @Basic
  @Column(name = "UsedMemory", nullable = true, insertable = true, updatable = true)
  public Integer getUsedMemory() {
    return usedMemory;
  }

  public void setUsedMemory(Integer usedMemory) {
    this.usedMemory = usedMemory;
  }

  @Override
  public int hashCode() {
    int result = ip != null ? ip.hashCode() : 0;
    result = 31 * result + processId;
    result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
    result = 31 * result + (processName != null ? processName.hashCode() : 0);
    result = 31 * result + (oneMinsProcs != null ? oneMinsProcs.hashCode() : 0);
    result = 31 * result + (fiveMinsProcs != null ? fiveMinsProcs.hashCode() : 0);
    result = 31 * result + (fifteenMinsProcs != null ? fifteenMinsProcs.hashCode() : 0);
    result = 31 * result + (cpuUsage != null ? cpuUsage.hashCode() : 0);
    result = 31 * result + (iowaitTime != null ? iowaitTime.hashCode() : 0);
    result = 31 * result + (usedMemory != null ? usedMemory.hashCode() : 0);
    return result;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    ServerMonitorEntity that = (ServerMonitorEntity) o;

    if (processId != that.processId) {
      return false;
    }
    if (cpuUsage != null ? !cpuUsage.equals(that.cpuUsage) : that.cpuUsage != null) {
      return false;
    }
    if (fifteenMinsProcs != null ? !fifteenMinsProcs.equals(that.fifteenMinsProcs)
        : that.fifteenMinsProcs != null) {
      return false;
    }
    if (fiveMinsProcs != null ? !fiveMinsProcs.equals(that.fiveMinsProcs)
        : that.fiveMinsProcs != null) {
      return false;
    }
    if (iowaitTime != null ? !iowaitTime.equals(that.iowaitTime) : that.iowaitTime != null) {
      return false;
    }
    if (ip != null ? !ip.equals(that.ip) : that.ip != null) {
      return false;
    }
    if (oneMinsProcs != null ? !oneMinsProcs.equals(that.oneMinsProcs)
        : that.oneMinsProcs != null) {
      return false;
    }
    if (processName != null ? !processName.equals(that.processName) : that.processName != null) {
      return false;
    }
    if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) {
      return false;
    }
    if (usedMemory != null ? !usedMemory.equals(that.usedMemory) : that.usedMemory != null) {
      return false;
    }

    return true;
  }
}
