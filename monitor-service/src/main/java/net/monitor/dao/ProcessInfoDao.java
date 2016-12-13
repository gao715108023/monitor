package net.monitor.dao;


import net.monitor.bean.IOStatBean;
import net.monitor.bean.NetstatBean;
import net.monitor.bean.ProcessInfoBean;
import net.monitor.bean.SystemResourceBean;

public interface ProcessInfoDao {

    int insert_process_monitor(ProcessInfoBean processInfoBean);

    int insert_resource_monitor(SystemResourceBean systemResourceBean);

    int insert_netstat_monitor(NetstatBean netstatBean);

    int insert_iostat_monitor(IOStatBean ioStatBean);

}