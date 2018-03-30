package net.monitor.bean;

public class TrafficInfoBean {

  private String ip;

  private String updateTime;

  private float receiveTraffic;

  private float receivePackets;

  private float receiveErrs;

  private float transmitTraffic;

  private float transmitPackets;

  private float transmitErrs;

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public String getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(String updateTime) {
    this.updateTime = updateTime;
  }

  public float getReceiveTraffic() {
    return receiveTraffic;
  }

  public void setReceiveTraffic(float receiveTraffic) {
    this.receiveTraffic = receiveTraffic;
  }

  public float getReceivePackets() {
    return receivePackets;
  }

  public void setReceivePackets(float receivePackets) {
    this.receivePackets = receivePackets;
  }

  public float getReceiveErrs() {
    return receiveErrs;
  }

  public void setReceiveErrs(float receiveErrs) {
    this.receiveErrs = receiveErrs;
  }

  public float getTransmitTraffic() {
    return transmitTraffic;
  }

  public void setTransmitTraffic(float transmitTraffic) {
    this.transmitTraffic = transmitTraffic;
  }

  public float getTransmitPackets() {
    return transmitPackets;
  }

  public void setTransmitPackets(float transmitPackets) {
    this.transmitPackets = transmitPackets;
  }

  public float getTransmitErrs() {
    return transmitErrs;
  }

  public void setTransmitErrs(float transmitErrs) {
    this.transmitErrs = transmitErrs;
  }


}
