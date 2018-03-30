package net.monitor.dao;

import java.util.List;
import net.monitor.source.ComputeNodeStatusEntity;
import net.monitor.source.IostatMonitorEntity;
import net.monitor.source.NetstatMonitorEntity;
import net.monitor.source.ServerMonitorEntity;
import net.monitor.source.TrafficMonitorEntity;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * @author gaochuanjun
 * @since 14-5-13
 */
public class DBCommon extends DBAbstract {

  public static void main(String[] args) {
    //select_iostat_monitor("10.15.88.70", "2014-05-13 10:35:00", "2014-05-13 11:00:00", "sda");
  }

  @Override
  public List<IostatMonitorEntity> select_iostat_monitor(String ip, String begin, String end,
      String diskname) {
    final Session session = DBUtils.getSession();

    try {
      System.out.println("querying iostat_monitor...");
      //final Map metadataMap = session.getSessionFactory().getAllClassMetadata();
      final String entityName = "com.gw.source.IostatMonitorEntity";
      final Query query = session.createQuery(
          "from " + entityName + " where ip = '" + ip + "' and updateTime >= '" + begin
              + "' and updateTime < '" + end + "' and name = '" + diskname + "'");
      System.out.println("executing: " + query.getQueryString());
      List<IostatMonitorEntity> iostatMonitorEntityList = query.list();
//            for (IostatMonitorEntity iostatMonitorEntity : iostatMonitorEntityList) {
//                System.out.println(iostatMonitorEntity.getIp() + " " + iostatMonitorEntity.getUpdateTime() + " " + iostatMonitorEntity.getName() + " " + iostatMonitorEntity.getAwait() + " " + iostatMonitorEntity.getSvctm() + " " + iostatMonitorEntity.getUtil());
//            }
      return iostatMonitorEntityList;
    } finally {
      if (session != null) {
        session.close();
      }
    }
  }

  @Override
  public List<ServerMonitorEntity> select_server_monitor(String ip, String begin, String end,
      String processId) {
    final Session session = DBUtils.getSession();

    try {
      System.out.println("querying server_monitor...");
      //final Map metadataMap = session.getSessionFactory().getAllClassMetadata();
      final String entityName = "com.gw.source.ServerMonitorEntity";
      final Query query = session.createQuery(
          "from " + entityName + " where ip = '" + ip + "' and updateTime >= '" + begin
              + "' and updateTime < '" + end + "' and processId = " + processId + "");
      System.out.println("executing: " + query.getQueryString());
      List<ServerMonitorEntity> serverMonitorEntityList = query.list();
      return serverMonitorEntityList;
    } finally {
      if (session != null) {
        session.close();
      }
    }
  }

  @Override
  public List<TrafficMonitorEntity> select_traffic_monitor(String ip, String begin, String end) {
    final Session session = DBUtils.getSession();

    try {
      System.out.println("querying traffic_monitor...");
      final String entityName = "com.gw.source.TrafficMonitorEntity";
      final Query query = session.createQuery(
          "from " + entityName + " where ip = '" + ip + "' and updateTime >= '" + begin
              + "' and updateTime < '" + end + "'");
      System.out.println("executing: " + query.getQueryString());
      List<TrafficMonitorEntity> trafficMonitorEntities = query.list();
      return trafficMonitorEntities;
    } finally {
      if (session != null) {
        session.close();
      }
    }
  }

  @Override
  public List<NetstatMonitorEntity> select_netstat_monitor(String ip, String begin, String end,
      String port) {
    final Session session = DBUtils.getSession();

    try {
      System.out.println("querying netstat_monitor...");
      //final Map metadataMap = session.getSessionFactory().getAllClassMetadata();
      final String entityName = "com.gw.source.NetstatMonitorEntity";
      final Query query = session.createQuery(
          "from " + entityName + " where ip = '" + ip + "' and updateTime >= '" + begin
              + "' and updateTime < '" + end + "' and port = " + port + "");
      System.out.println("executing: " + query.getQueryString());
      List<NetstatMonitorEntity> netstatMonitorEntityList = query.list();
      return netstatMonitorEntityList;
    } finally {
      if (session != null) {
        session.close();
      }
    }
  }

  @Override
  public List<ComputeNodeStatusEntity> select_compute_node_status(String ip, String begin,
      String end) {
    return null;
  }
}
