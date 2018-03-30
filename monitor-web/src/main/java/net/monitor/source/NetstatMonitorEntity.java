package net.monitor.source;

import java.sql.Timestamp;
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
@Table(name = "netstat_monitor", schema = "", catalog = "process")
@IdClass(NetstatMonitorEntityPK.class)
public class NetstatMonitorEntity {

  private String ip;
  private int port;
  private Timestamp updateTime;
  private int total;
  private int established;
  private int timeWait;
  private int finWait2;

  @Id
  @Column(name = "IP", nullable = false, insertable = true, updatable = true, length = 16)
  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  @Id
  @Column(name = "port", nullable = false, insertable = true, updatable = true)
  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }

  @Id
  @Column(name = "UpdateTime", nullable = false, insertable = true, updatable = true)
  public Timestamp getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Timestamp updateTime) {
    this.updateTime = updateTime;
  }

  @Id
  @Column(name = "Total", nullable = false, insertable = true, updatable = true)
  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  @Id
  @Column(name = "Established", nullable = false, insertable = true, updatable = true)
  public int getEstablished() {
    return established;
  }

  public void setEstablished(int established) {
    this.established = established;
  }

  @Id
  @Column(name = "TimeWait", nullable = false, insertable = true, updatable = true)
  public int getTimeWait() {
    return timeWait;
  }

  public void setTimeWait(int timeWait) {
    this.timeWait = timeWait;
  }

  @Id
  @Column(name = "FinWait2", nullable = false, insertable = true, updatable = true)
  public int getFinWait2() {
    return finWait2;
  }

  public void setFinWait2(int finWait2) {
    this.finWait2 = finWait2;
  }

  @Override
  public int hashCode() {
    int result = ip != null ? ip.hashCode() : 0;
    result = 31 * result + port;
    result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
    result = 31 * result + total;
    result = 31 * result + established;
    result = 31 * result + timeWait;
    result = 31 * result + finWait2;
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

    NetstatMonitorEntity that = (NetstatMonitorEntity) o;

    if (port != that.port) {
      return false;
    }
    if (total != that.total) {
      return false;
    }
    if (established != that.established) {
      return false;
    }
    if (timeWait != that.timeWait) {
      return false;
    }
    if (finWait2 != that.finWait2) {
      return false;
    }

    return true;
  }
}
