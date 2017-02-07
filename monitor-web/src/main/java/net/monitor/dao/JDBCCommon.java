package net.monitor.dao;


import net.monitor.bean.DBBean;
import net.monitor.source.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gaochuanjun
 * @since 14-6-12
 */
public class JDBCCommon extends DBAbstract {

    @Override
    public List<IostatMonitorEntity> select_iostat_monitor(String ip, String begin, String end, String diskname) {
        List<IostatMonitorEntity> iostatMonitorEntityList = new ArrayList<IostatMonitorEntity>();
        String sSQL = "select UpdateTime,await,svctm,util from iostat_monitor where ip = '" + ip + "' and UpdateTime >= '" + begin + "' and UpdateTime < '" + end + "' and name = '" + diskname + "'";
        System.out.println(sSQL);
        JDBCUtils jdbcUtils = new JDBCUtils();
        DBBean dbBean = jdbcUtils.getConf();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = jdbcUtils.getConn(dbBean);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sSQL);
            while (rs.next()) {
                IostatMonitorEntity iostatMonitorEntity = new IostatMonitorEntity();
                iostatMonitorEntity.setIp(ip);
                iostatMonitorEntity.setUpdateTime(rs.getTimestamp(1));
                iostatMonitorEntity.setName(diskname);
                iostatMonitorEntity.setAwait(rs.getFloat(2));
                iostatMonitorEntity.setSvctm(rs.getFloat(3));
                iostatMonitorEntity.setUtil(rs.getFloat(4));
                iostatMonitorEntityList.add(iostatMonitorEntity);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return iostatMonitorEntityList;
    }

    @Override
    public List<ServerMonitorEntity> select_server_monitor(String ip, String begin, String end, String processId) {
        List<ServerMonitorEntity> serverMonitorEntityList = new ArrayList<ServerMonitorEntity>();
        String sSQL = "select UpdateTime,ProcessName,OneMinsProcs,FiveMinsProcs,FifteenMinsProcs,CPUUsage,IowaitTime,UsedMemory from server_monitor where ip = '" + ip + "' and UpdateTime >= '" + begin + "' and UpdateTime < '" + end + "' and processId = " + processId;
        System.out.println(sSQL);
        JDBCUtils jdbcUtils = new JDBCUtils();
        DBBean dbBean = jdbcUtils.getConf();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = jdbcUtils.getConn(dbBean);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sSQL);
            while (rs.next()) {
                ServerMonitorEntity serverMonitorEntity = new ServerMonitorEntity();
                serverMonitorEntity.setIp(ip);
                serverMonitorEntity.setUpdateTime(rs.getTimestamp(1));
                serverMonitorEntity.setProcessName(rs.getString(2));
                serverMonitorEntity.setOneMinsProcs(rs.getFloat(3));
                serverMonitorEntity.setFiveMinsProcs(rs.getFloat(4));
                serverMonitorEntity.setFifteenMinsProcs(rs.getFloat(5));
                serverMonitorEntity.setCpuUsage(rs.getFloat(6));
                serverMonitorEntity.setIowaitTime(rs.getFloat(7));
                serverMonitorEntity.setUsedMemory(rs.getInt(8));
                serverMonitorEntityList.add(serverMonitorEntity);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return serverMonitorEntityList;
    }

    @Override
    public List<TrafficMonitorEntity> select_traffic_monitor(String ip, String begin, String end) {
        List<TrafficMonitorEntity> trafficMonitorEntityList = new ArrayList<TrafficMonitorEntity>();
        String sSQL = "select UpdateTime,ReceiveTraffic,ReceivePackets,ReceiveErrs,TransmitTraffic,TransmitPackets,TransmitErrs from traffic_monitor where ip = '" + ip + "' and UpdateTime >= '" + begin + "' and UpdateTime < '" + end + "'";
        System.out.println(sSQL);
        JDBCUtils jdbcUtils = new JDBCUtils();
        DBBean dbBean = jdbcUtils.getConf();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = jdbcUtils.getConn(dbBean);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sSQL);
            while (rs.next()) {
                TrafficMonitorEntity trafficMonitorEntity = new TrafficMonitorEntity();
                trafficMonitorEntity.setIp(ip);
                trafficMonitorEntity.setUpdateTime(rs.getTimestamp(1));
                trafficMonitorEntity.setReceiveTraffic(rs.getFloat(2));
                trafficMonitorEntity.setReceivePackets(rs.getFloat(3));
                trafficMonitorEntity.setReceiveErrs(rs.getFloat(4));
                trafficMonitorEntity.setTransmitTraffic(rs.getFloat(5));
                trafficMonitorEntity.setTransmitPackets(rs.getFloat(6));
                trafficMonitorEntity.setTransmitErrs(rs.getFloat(7));
                trafficMonitorEntityList.add(trafficMonitorEntity);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return trafficMonitorEntityList;
    }

    @Override
    public List<NetstatMonitorEntity> select_netstat_monitor(String ip, String begin, String end, String port) {
        List<NetstatMonitorEntity> netstatMonitorEntityList = new ArrayList<NetstatMonitorEntity>();
        String sSQL = "select UpdateTime,Total,Established,TimeWait,FinWait2 from netstat_monitor where ip = '" + ip + "' and UpdateTime >= '" + begin + "' and UpdateTime < '" + end + "' and port = " + port;
        System.out.println(sSQL);
        JDBCUtils jdbcUtils = new JDBCUtils();
        DBBean dbBean = jdbcUtils.getConf();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = jdbcUtils.getConn(dbBean);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sSQL);
            while (rs.next()) {
                NetstatMonitorEntity netstatMonitorEntity = new NetstatMonitorEntity();
                netstatMonitorEntity.setIp(ip);
                netstatMonitorEntity.setUpdateTime(rs.getTimestamp(1));
                netstatMonitorEntity.setPort(Integer.parseInt(port));
                netstatMonitorEntity.setTotal(rs.getInt(2));
                netstatMonitorEntity.setEstablished(rs.getInt(3));
                netstatMonitorEntity.setTimeWait(rs.getInt(4));
                netstatMonitorEntity.setFinWait2(rs.getInt(5));
                netstatMonitorEntityList.add(netstatMonitorEntity);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return netstatMonitorEntityList;
    }

    @Override
    public List<ComputeNodeStatusEntity> select_compute_node_status(String ip, String begin, String end) {
        List<ComputeNodeStatusEntity> computeNodeStatusEntities = new ArrayList<ComputeNodeStatusEntity>();
        String sSQL = "select UpdateTime,OneMinsProcs,FiveMinsProcs,FifteenMinsProcs,TotalTime,UserTime,NiceTime,SystemTime,IowaitTime,IdleTime,AllTotalTime,AllUserTime,AllNiceTime,AllSystemTime,AllIowaitTime,AllIdleTime,TotalMemory,UsedMemory,IdleMemory,SwapSize,UsedSwap,IdleSwap from computenodestatus where NodeName = '" + ip + "' and UpdateTime >= '" + begin + "' and UpdateTime < '" + end + "'";
        System.out.println(sSQL);
        JDBCUtils jdbcUtils = new JDBCUtils();
        DBBean dbBean = jdbcUtils.getConf();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = jdbcUtils.getConn(dbBean);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sSQL);
            while (rs.next()) {
                ComputeNodeStatusEntity computeNodeStatusEntity = new ComputeNodeStatusEntity();
                computeNodeStatusEntity.setNodeName(ip);
                computeNodeStatusEntity.setUpdateTime(rs.getTimestamp(1));
                computeNodeStatusEntity.setOneMinsProcs(rs.getFloat(2));
                computeNodeStatusEntity.setFiveMinsProcs(rs.getFloat(3));
                computeNodeStatusEntity.setFifteenMinsProcs(rs.getFloat(4));
                computeNodeStatusEntity.setTotalTime(rs.getFloat(5));
                computeNodeStatusEntity.setUserTime(rs.getFloat(6));
                computeNodeStatusEntity.setNiceTime(rs.getFloat(7));
                computeNodeStatusEntity.setSystemTime(rs.getFloat(8));
                computeNodeStatusEntity.setIowaitTime(rs.getFloat(9));
                computeNodeStatusEntity.setIdleTime(rs.getFloat(10));
                computeNodeStatusEntity.setAllTotalTime(rs.getString(11));
                computeNodeStatusEntity.setAllUserTime(rs.getString(12));
                computeNodeStatusEntity.setAllNiceTime(rs.getString(13));
                computeNodeStatusEntity.setAllSystemTime(rs.getString(14));
                computeNodeStatusEntity.setAllIowaitTime(rs.getString(15));
                computeNodeStatusEntity.setAllIdleTime(rs.getString(16));
                computeNodeStatusEntity.setTotalMemory(rs.getInt(17));
                computeNodeStatusEntity.setUsedMemory(rs.getInt(18));
                computeNodeStatusEntity.setIdleMemory(rs.getInt(19));
                computeNodeStatusEntity.setSwapSize(rs.getInt(20));
                computeNodeStatusEntity.setUsedSwap(rs.getInt(21));
                computeNodeStatusEntity.setIdleSwap(rs.getInt(22));
                computeNodeStatusEntities.add(computeNodeStatusEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return computeNodeStatusEntities;
    }
}
