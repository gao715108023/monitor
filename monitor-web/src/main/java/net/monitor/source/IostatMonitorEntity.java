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
@Table(name = "iostat_monitor", schema = "", catalog = "process")
@IdClass(IostatMonitorEntityPK.class)
public class IostatMonitorEntity {

  private String ip;
  private Timestamp updateTime;
  private String name;
  private Float await;
  private Float svctm;
  private Float util;

  @Id
  @Column(name = "IP", nullable = false, insertable = true, updatable = true, length = 16)
  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
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
  @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 255)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Basic
  @Column(name = "await", nullable = true, insertable = true, updatable = true, precision = 2)
  public Float getAwait() {
    return await;
  }

  public void setAwait(Float await) {
    this.await = await;
  }

  @Basic
  @Column(name = "svctm", nullable = true, insertable = true, updatable = true, precision = 2)
  public Float getSvctm() {
    return svctm;
  }

  public void setSvctm(Float svctm) {
    this.svctm = svctm;
  }

  @Basic
  @Column(name = "util", nullable = true, insertable = true, updatable = true, precision = 2)
  public Float getUtil() {
    return util;
  }

  public void setUtil(Float util) {
    this.util = util;
  }

  @Override
  public int hashCode() {
    int result = ip != null ? ip.hashCode() : 0;
    result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (await != null ? await.hashCode() : 0);
    result = 31 * result + (svctm != null ? svctm.hashCode() : 0);
    result = 31 * result + (util != null ? util.hashCode() : 0);
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

    IostatMonitorEntity that = (IostatMonitorEntity) o;

    if (await != null ? !await.equals(that.await) : that.await != null) {
      return false;
    }
    if (ip != null ? !ip.equals(that.ip) : that.ip != null) {
      return false;
    }
    if (name != null ? !name.equals(that.name) : that.name != null) {
      return false;
    }
    if (svctm != null ? !svctm.equals(that.svctm) : that.svctm != null) {
      return false;
    }
    if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) {
      return false;
    }
    if (util != null ? !util.equals(that.util) : that.util != null) {
      return false;
    }

    return true;
  }
}
