package com.gcj.dao;

import com.gcj.bean.IOStatBean;
import com.gcj.bean.NetstatBean;
import com.gcj.bean.ProcessInfoBean;
import com.gcj.bean.SystemResourceBean;

public interface ProcessInfoDao {

    public int insert_process_monitor(ProcessInfoBean processInfoBean);

    public int insert_resource_monitor(SystemResourceBean systemResourceBean);

    public int insert_netstat_monitor(NetstatBean netstatBean);

    public int insert_iostat_monitor(IOStatBean ioStatBean);

}