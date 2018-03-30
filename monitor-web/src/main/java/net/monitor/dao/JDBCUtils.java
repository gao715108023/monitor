package net.monitor.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import net.monitor.bean.DBBean;
import net.monitor.common.Constant;
import net.monitor.utils.ConfigUtils;

/**
 * @author gaochuanjun
 * @since 14-6-12
 */
public class JDBCUtils {

  static {
    try {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    JDBCUtils jdbcUtils = new JDBCUtils();
    DBBean dbBean = jdbcUtils.getConf();
    System.out.println("URL: " + dbBean.getUrl());
    System.out.println("User: " + dbBean.getUser());
    System.out.println("pwd: " + dbBean.getPwd());
  }

  public DBBean getConf() {
    ConfigUtils conf = new ConfigUtils(Constant.confPath);
    String url = "jdbc:mysql://" + conf.getString("mysql_ip") + "/" + conf.getString("database")
        + "?useUnicode=true&characterEncoding=utf8";
    return new DBBean(url, conf.getString("mysql_user"), conf.getString("mysql_pwd"));
  }

  public Connection getConn(DBBean dbBean) throws SQLException {
    return DriverManager.getConnection(dbBean.getUrl(), dbBean.getUser(), dbBean.getPwd());
  }
}
