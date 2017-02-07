package net.monitor.source;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author gaochuanjun
 * @since 14-5-13
 */
@Entity
@Table(name = "traffic_monitor", schema = "", catalog = "process")
@IdClass(TrafficMonitorEntityPK.class)
public class TrafficMonitorEntity {
    private String ip;
    private Timestamp updateTime;
    private Float receiveTraffic;
    private Float receivePackets;
    private Float receiveErrs;
    private Float transmitTraffic;
    private Float transmitPackets;
    private Float transmitErrs;

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

    @Basic
    @Column(name = "ReceiveTraffic", nullable = true, insertable = true, updatable = true, precision = 2)
    public Float getReceiveTraffic() {
        return receiveTraffic;
    }

    public void setReceiveTraffic(Float receiveTraffic) {
        this.receiveTraffic = receiveTraffic;
    }

    @Basic
    @Column(name = "ReceivePackets", nullable = true, insertable = true, updatable = true, precision = 2)
    public Float getReceivePackets() {
        return receivePackets;
    }

    public void setReceivePackets(Float receivePackets) {
        this.receivePackets = receivePackets;
    }

    @Basic
    @Column(name = "ReceiveErrs", nullable = true, insertable = true, updatable = true, precision = 2)
    public Float getReceiveErrs() {
        return receiveErrs;
    }

    public void setReceiveErrs(Float receiveErrs) {
        this.receiveErrs = receiveErrs;
    }

    @Basic
    @Column(name = "TransmitTraffic", nullable = true, insertable = true, updatable = true, precision = 2)
    public Float getTransmitTraffic() {
        return transmitTraffic;
    }

    public void setTransmitTraffic(Float transmitTraffic) {
        this.transmitTraffic = transmitTraffic;
    }

    @Basic
    @Column(name = "TransmitPackets", nullable = true, insertable = true, updatable = true, precision = 2)
    public Float getTransmitPackets() {
        return transmitPackets;
    }

    public void setTransmitPackets(Float transmitPackets) {
        this.transmitPackets = transmitPackets;
    }

    @Basic
    @Column(name = "TransmitErrs", nullable = true, insertable = true, updatable = true, precision = 2)
    public Float getTransmitErrs() {
        return transmitErrs;
    }

    public void setTransmitErrs(Float transmitErrs) {
        this.transmitErrs = transmitErrs;
    }

    @Override
    public int hashCode() {
        int result = ip != null ? ip.hashCode() : 0;
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (receiveTraffic != null ? receiveTraffic.hashCode() : 0);
        result = 31 * result + (receivePackets != null ? receivePackets.hashCode() : 0);
        result = 31 * result + (receiveErrs != null ? receiveErrs.hashCode() : 0);
        result = 31 * result + (transmitTraffic != null ? transmitTraffic.hashCode() : 0);
        result = 31 * result + (transmitPackets != null ? transmitPackets.hashCode() : 0);
        result = 31 * result + (transmitErrs != null ? transmitErrs.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrafficMonitorEntity that = (TrafficMonitorEntity) o;

        if (receiveTraffic != null ? !receiveTraffic.equals(that.receiveTraffic) : that.receiveTraffic != null)
            return false;
        if (ip != null ? !ip.equals(that.ip) : that.ip != null) return false;
        if (receivePackets != null ? !receivePackets.equals(that.receivePackets) : that.receivePackets != null)
            return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (receiveErrs != null ? !receiveErrs.equals(that.receiveErrs) : that.receiveErrs != null) return false;
        if (transmitTraffic != null ? !transmitTraffic.equals(that.transmitTraffic) : that.transmitTraffic != null)
            return false;
        if (transmitPackets != null ? !transmitPackets.equals(that.receiveErrs) : that.transmitPackets != null)
            return false;
        if (transmitErrs != null ? !transmitErrs.equals(that.transmitErrs) : that.transmitErrs != null) return false;

        return true;
    }
}
