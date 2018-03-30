package net.monitor.source;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author gaochuanjun
 * @since 14-5-13
 */
public class ServerMonitorEntityPK implements Serializable {

  private String ip;
  private int processId;
  private Timestamp updateTime;

  @Column(name = "IP", nullable = false, insertable = true, updatable = true, length = 16)
  @Id
  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  @Column(name = "ProcessId", nullable = false, insertable = true, updatable = true)
  @Id
  public int getProcessId() {
    return processId;
  }

  public void setProcessId(int processId) {
    this.processId = processId;
  }

  @Column(name = "UpdateTime", nullable = false, insertable = true, updatable = true)
  @Id
  public Timestamp getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Timestamp updateTime) {
    this.updateTime = updateTime;
  }

  @Override
  public int hashCode() {
    int result = ip != null ? ip.hashCode() : 0;
    result = 31 * result + processId;
    result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
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

    ServerMonitorEntityPK that = (ServerMonitorEntityPK) o;

    if (processId != that.processId) {
      return false;
    }
    if (ip != null ? !ip.equals(that.ip) : that.ip != null) {
      return false;
    }
    if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) {
      return false;
    }

    return true;
  }
}
