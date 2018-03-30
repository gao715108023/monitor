package net.monitor.source;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author gaochuanjun
 * @since 14-5-13
 */
public class NetstatMonitorEntityPK implements Serializable {

  private String ip;
  private int port;
  private Timestamp updateTime;

  @Column(name = "IP", nullable = false, insertable = true, updatable = true, length = 16)
  @Id
  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  @Column(name = "port", nullable = false, insertable = true, updatable = true)
  @Id
  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
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
    result = 31 * result + port;
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

    NetstatMonitorEntityPK that = (NetstatMonitorEntityPK) o;

    if (port != that.port) {
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
