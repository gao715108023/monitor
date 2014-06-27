package com.gcj.dao;

import com.gcj.bean.*;

/**
 * Created by gaochuanjun on 14-3-3.
 */
public interface ServerMsgDao {

    public int insert_server_monitor(ServerMsgBean serverMsgBean);

    public int insert_iostat_monitor(IOStatMonitor ioStatMonitor);

    public int insert_traffic(TrafficInfoBean trafficInfoBean);

    public int insert_netstat_monitor(NetstatBean netstatBean);

    public int insert_computenodestatus(ComputeNodeStatus computeNodeStatus);

}
