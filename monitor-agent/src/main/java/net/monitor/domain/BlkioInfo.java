package net.monitor.domain;

/**
 * @author gaochuanjun
 * @since 14-5-9
 */
public class BlkioInfo {

    private long rdIos;	/* Read I/O operations */
    private long rdMerges;	/* Reads merged */
    private long rdSectors; /* Sectors read */
    private long rdTicks;	/* Time in queue + service for read */
    private long wrIos;	/* Write I/O operations */
    private long wrMerges;	/* Writes merged */
    private long wrSectors; /* Sectors written */
    private long wrTicks;	/* Time in queue + service for write */
    private long ticks;	/* Time of requests in queue */
    private long aveq;	/* Average queue length */

    public BlkioInfo(long rdIos, long rdMerges, long rdSectors, long rdTicks, long wrIos, long wrMerges, long wrSectors, long wrTicks, long ticks, long aveq) {
        this.rdIos = rdIos;
        this.rdMerges = rdMerges;
        this.rdSectors = rdSectors;
        this.rdTicks = rdTicks;
        this.wrIos = wrIos;
        this.wrMerges = wrMerges;
        this.wrSectors = wrSectors;
        this.wrTicks = wrTicks;
        this.ticks = ticks;
        this.aveq = aveq;
    }

    public BlkioInfo() {
    }

    public long getRdIos() {
        return rdIos;
    }

    public void setRdIos(long rdIos) {
        this.rdIos = rdIos;
    }

    public long getRdMerges() {
        return rdMerges;
    }

    public void setRdMerges(long rdMerges) {
        this.rdMerges = rdMerges;
    }

    public long getRdSectors() {
        return rdSectors;
    }

    public void setRdSectors(long rdSectors) {
        this.rdSectors = rdSectors;
    }

    public long getRdTicks() {
        return rdTicks;
    }

    public void setRdTicks(long rdTicks) {
        this.rdTicks = rdTicks;
    }

    public long getWrIos() {
        return wrIos;
    }

    public void setWrIos(long wrIos) {
        this.wrIos = wrIos;
    }

    public long getWrMerges() {
        return wrMerges;
    }

    public void setWrMerges(long wrMerges) {
        this.wrMerges = wrMerges;
    }

    public long getWrSectors() {
        return wrSectors;
    }

    public void setWrSectors(long wrSectors) {
        this.wrSectors = wrSectors;
    }

    public long getWrTicks() {
        return wrTicks;
    }

    public void setWrTicks(long wrTicks) {
        this.wrTicks = wrTicks;
    }

    public long getTicks() {
        return ticks;
    }

    public void setTicks(long ticks) {
        this.ticks = ticks;
    }

    public long getAveq() {
        return aveq;
    }

    public void setAveq(long aveq) {
        this.aveq = aveq;
    }
}
