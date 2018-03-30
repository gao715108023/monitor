package net.monitor.dao.dto;

import java.io.Serializable;
import java.util.Date;

public class TrafficMonitorDTO implements Serializable {

  private static final long serialVersionUID = 1L;
  private Long id;
  private String ip;
  private String networkCardName;
  private Float receiveTraffic;
  private Float receivePackets;
  private Float receiveErrs;
  private Float transmitTraffic;
  private Float transmitPackets;
  private Float transmitErrs;
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

  public String getNetworkCardName() {
    return networkCardName;
  }

  public void setNetworkCardName(String networkCardName) {
    this.networkCardName = networkCardName == null ? null : networkCardName.trim();
  }

  public Float getReceiveTraffic() {
    return receiveTraffic;
  }

  public void setReceiveTraffic(Float receiveTraffic) {
    this.receiveTraffic = receiveTraffic;
  }

  public Float getReceivePackets() {
    return receivePackets;
  }

  public void setReceivePackets(Float receivePackets) {
    this.receivePackets = receivePackets;
  }

  public Float getReceiveErrs() {
    return receiveErrs;
  }

  public void setReceiveErrs(Float receiveErrs) {
    this.receiveErrs = receiveErrs;
  }

  public Float getTransmitTraffic() {
    return transmitTraffic;
  }

  public void setTransmitTraffic(Float transmitTraffic) {
    this.transmitTraffic = transmitTraffic;
  }

  public Float getTransmitPackets() {
    return transmitPackets;
  }

  public void setTransmitPackets(Float transmitPackets) {
    this.transmitPackets = transmitPackets;
  }

  public Float getTransmitErrs() {
    return transmitErrs;
  }

  public void setTransmitErrs(Float transmitErrs) {
    this.transmitErrs = transmitErrs;
  }

  public Date getGmtCreate() {
    return gmtCreate;
  }

  public void setGmtCreate(Date gmtCreate) {
    this.gmtCreate = gmtCreate;
  }

  @Override
  public String toString() {
    return "TrafficMonitorDTO{" +
        "id=" + id +
        ", ip='" + ip + '\'' +
        ", networkCardName='" + networkCardName + '\'' +
        ", receiveTraffic=" + receiveTraffic +
        ", receivePackets=" + receivePackets +
        ", receiveErrs=" + receiveErrs +
        ", transmitTraffic=" + transmitTraffic +
        ", transmitPackets=" + transmitPackets +
        ", transmitErrs=" + transmitErrs +
        ", gmtCreate=" + gmtCreate +
        '}';
  }
}