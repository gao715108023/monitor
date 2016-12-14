package net.monitor.bean;

/**
 * @author gaochuanjun
 * @since 14-5-13
 */
public class HighChartBean {

    private long updateTime;

    private String value;

    public HighChartBean(long updateTime, String value) {
        this.updateTime = updateTime;
        this.value = value;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public String getValue() {
        return value;
    }
}
