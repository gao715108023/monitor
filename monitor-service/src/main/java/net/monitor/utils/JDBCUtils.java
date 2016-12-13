package net.monitor.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created with IntelliJ IDEA. User: zyj Date: 13-5-15 Time: 下午2:46 To change
 * this template use File | Settings | File Templates.
 */
public class JDBCUtils {
    public static Connection connectToMySQL(String url, String user, String password) {
        Connection conn = null;
        String driver = "com.mysql.jdbc.Driver";
        try {
            Class.forName(driver);
            try {
                conn = DriverManager.getConnection(url, user, password);
                // System.out.println("链接成功！");
            } catch (SQLException e) {
                e.printStackTrace(); // To change body of catch statement use
                // File | Settings | File Templates.
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // To change body of catch statement use File |
            // Settings | File Templates.
        }
        return conn;
    }

    public static Connection connectToOracle(String url, String user, String password) {
        Connection conn = null;
        String driver = "oracle.jdbc.driver.OracleDriver";
        try {
            Class.forName(driver);
            try {
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("链接成功！");
            } catch (SQLException e) {
                e.printStackTrace(); // To change body of catch statement use
                // File | Settings | File Templates.
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // To change body of catch statement use File |
            // Settings | File Templates.
        }
        return conn;
    }

    public static void deleteData(String url, String user, String password) {
        Connection conn = connectToMySQL(url, user, password);
        Statement stmt = null;
        String dSql = "delete * from process";
        try {
            stmt = conn.createStatement();
            stmt.executeQuery(dSql);
        } catch (SQLException e) {
            e.printStackTrace(); // To change body of catch statement use File |
            // Settings | File Templates.
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace(); // To change body of catch statement use
                // File | Settings | File Templates.
            }
        }
    }
}
