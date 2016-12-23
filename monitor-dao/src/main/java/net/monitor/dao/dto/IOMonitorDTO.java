package net.monitor.dao.dto;

import java.io.Serializable;
import java.util.Date;

public class IOMonitorDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String ip;
    private String diskName;
    private Float await;
    private Float svctm;
    private Float util;
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

    public String getDiskName() {
        return diskName;
    }

    public void setDiskName(String diskName) {
        this.diskName = diskName == null ? null : diskName.trim();
    }

    public Float getAwait() {
        return await;
    }

    public void setAwait(Float await) {
        this.await = await;
    }

    public Float getSvctm() {
        return svctm;
    }

    public void setSvctm(Float svctm) {
        this.svctm = svctm;
    }

    public Float getUtil() {
        return util;
    }

    public void setUtil(Float util) {
        this.util = util;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}