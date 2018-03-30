package net.monitor.dao.dto;

import java.io.Serializable;
import java.util.Date;

public class NetstatMonitorDTO implements Serializable {

  private static final long serialVersionUID = 1L;
  private Long id;
  private String ip;
  private Integer port;
  private Integer total;
  private Integer established;
  private Integer timeWait;
  private Integer finWait2;
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

  public Integer getPort() {
    return port;
  }

  public void setPort(Integer port) {
    this.port = port;
  }

  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

  public Integer getEstablished() {
    return established;
  }

  public void setEstablished(Integer established) {
    this.established = established;
  }

  public Integer getTimeWait() {
    return timeWait;
  }

  public void setTimeWait(Integer timeWait) {
    this.timeWait = timeWait;
  }

  public Integer getFinWait2() {
    return finWait2;
  }

  public void setFinWait2(Integer finWait2) {
    this.finWait2 = finWait2;
  }

  public Date getGmtCreate() {
    return gmtCreate;
  }

  public void setGmtCreate(Date gmtCreate) {
    this.gmtCreate = gmtCreate;
  }
}