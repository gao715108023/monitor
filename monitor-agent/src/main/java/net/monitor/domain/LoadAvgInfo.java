package net.monitor.domain;

/**
 * @author gaochuanjun
 * @since 14-5-28
 */
public class LoadAvgInfo {

    private float oneMinsProcs;
    private float fiveMinsProcs;
    private float fifteenMinsProcs;

    public LoadAvgInfo() {
        this(0, 0, 0);
    }

    public LoadAvgInfo(float oneMinsProcs, float fiveMinsProcs, float fifteenMinsProcs) {
        this.oneMinsProcs = oneMinsProcs;
        this.fiveMinsProcs = fiveMinsProcs;
        this.fifteenMinsProcs = fifteenMinsProcs;
    }

    public float getOneMinsProcs() {
        return oneMinsProcs;
    }

    public void setOneMinsProcs(float oneMinsProcs) {
        this.oneMinsProcs = oneMinsProcs;
    }

    public float getFiveMinsProcs() {
        return fiveMinsProcs;
    }

    public void setFiveMinsProcs(float fiveMinsProcs) {
        this.fiveMinsProcs = fiveMinsProcs;
    }

    public float getFifteenMinsProcs() {
        return fifteenMinsProcs;
    }

    public void setFifteenMinsProcs(float fifteenMinsProcs) {
        this.fifteenMinsProcs = fifteenMinsProcs;
    }
}