package net.monitor.display;

import net.monitor.utils.JDBCUtils;
import net.monitor.utils.TimeUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DisplayMain {
    private String processName;
    private String ip;
    private String startTime;
    private String endTime;

    public DisplayMain(String processName, String ip, String startTime, String endTime) {
        super();
        this.processName = processName;
        this.ip = ip;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public static boolean isValidIPAddress(String str) {
        String temp = "";
        int tag = 0;
        if (str.charAt(0) == '.' || str.charAt(str.length() - 1) == '.')
            return false;
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == '.') {
                tag++;
                if (Integer.parseInt(temp) > 255)
                    return false;
                temp = "";
                continue;
            }
            if (str.charAt(i) < '0' || str.charAt(i) > '9')
                return false;
            temp += String.valueOf(str.charAt(i));
        }
        if (tag != 3)
            return false;
        return true;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String processName = null;
        while (true) {
            processName = JOptionPane.showInputDialog("请输入待查询的进程名：");
            if (processName.equalsIgnoreCase("mysql_read_proxy") || processName.equalsIgnoreCase("mysql_read")) {
                processName = "mysql_read";
                break;
            } else if (processName.equalsIgnoreCase("internal_read_proxy") || processName.equalsIgnoreCase("internal_read")) {
                processName = "internal_read";
                break;
            } else if (processName.equalsIgnoreCase("external_read_proxy") || processName.equalsIgnoreCase("external_read")) {
                processName = "external_read";
                break;
            } else if (processName.equalsIgnoreCase("CalculationUnit")) {
                processName = "CalculationUnit";
                break;
            } else if (processName.equalsIgnoreCase("queueserver")) {
                processName = "queueserver";
                break;
            } else if (processName.equalsIgnoreCase("apache-activemq")) {
                processName = "apache-activemq";
                break;
            } else {
                JOptionPane.showMessageDialog(null, "暂时不支持该进程的信息查询!", "提示！", JOptionPane.ERROR_MESSAGE);
            }
        }

        String ip = null;
        while (true) {
            if (processName.equalsIgnoreCase("internal_read")) {
                ip = JOptionPane.showInputDialog("请输入进程所在的主机IP[10.15.89.187]：", "10.15.107.218 or 10.15.107.220");

            }
            if (processName.equalsIgnoreCase("mysql_read")) {
                ip = JOptionPane.showInputDialog("请输入进程所在的主机IP[10.15.89.187]：", "10.15.107.218");
            }
            if (processName.equalsIgnoreCase("external_read")) {
                ip = JOptionPane.showInputDialog("请输入进程所在的主机IP[10.15.89.187]：", "10.15.107.151");
            }
            if (processName.equalsIgnoreCase("queueserver")) {
                ip = JOptionPane.showInputDialog("请输入进程所在的主机IP[10.15.89.187]：", "10.15.107.151");
            }
            if (processName.equalsIgnoreCase("CalculationUnit")) {
                ip = JOptionPane.showInputDialog("请输入进程所在的主机IP[10.15.89.187]：", "10.15.107.217");
            }
            if (processName.equalsIgnoreCase("apache-activemq")) {
                ip = JOptionPane.showInputDialog("请输入进程所在的主机IP[10.15.144.162]：", "10.15.144.162");
            }
            if (isValidIPAddress(ip)) {
                break;
            } else {
                JOptionPane.showMessageDialog(null, "IP格式错误!", "提示！", JOptionPane.ERROR_MESSAGE);
            }
        }

        // String ip =
        // JOptionPane.showInputDialog("请输入进程所在的主机IP[10.15.89.187]：",
        // "10.15.89.187");
        while (true) {
            String startTime = JOptionPane.showInputDialog("请输入待查询时间段的起始时间【格式为：yyyy-mm-dd HH:mm:ss】：");
            String endTime = JOptionPane.showInputDialog("请输入待查询时间段的结束时间【格式为：yyyy-mm-dd HH:mm:ss】：");
            if (TimeUtils.isValidDate(startTime, endTime)) {
                System.out.println("进程名：" + processName);
                System.out.println("进程所在的主机IP：" + ip);
                System.out.println("待查询时间段的起始时间：" + startTime);
                System.out.println("待查询时间段的结束时间：" + endTime);
                DisplayMain jfreeChartTwo = new DisplayMain(processName, ip, startTime, endTime);
                jfreeChartTwo.getDataFromMySQL("10.15.89.187", "root", "123456", "process");
                break;
            }
        }

		/*
         * String series1 = "First"; String series2 = "Second"; String series3 =
		 * "Third"; String type1 = "2001"; String type2 = "2002"; String type3 =
		 * "2003"; String type4 = "2004"; String type5 = "2005"; String type6 =
		 * "2006"; String type7 = "2007"; String type8 = "2008";
		 * DefaultCategoryDataset defaultcategorydataset = new
		 * DefaultCategoryDataset(); defaultcategorydataset.addValue(1.0D,
		 * series1, type1); defaultcategorydataset.addValue(4D, series1, type2);
		 * defaultcategorydataset.addValue(3D, series1, type3);
		 * defaultcategorydataset.addValue(5D, series1, type4);
		 * defaultcategorydataset.addValue(5D, series1, type5);
		 * defaultcategorydataset.addValue(7D, series1, type6);
		 * defaultcategorydataset.addValue(7D, series1, type7);
		 * defaultcategorydataset.addValue(8D, series1, type8);
		 *
		 * defaultcategorydataset.addValue(5D, series2, type1);
		 * defaultcategorydataset.addValue(7D, series2, type2);
		 * defaultcategorydataset.addValue(6D, series2, type3);
		 * defaultcategorydataset.addValue(8D, series2, type4);
		 * defaultcategorydataset.addValue(4D, series2, type5);
		 * defaultcategorydataset.addValue(4D, series2, type6);
		 * defaultcategorydataset.addValue(2D, series2, type7);
		 * defaultcategorydataset.addValue(1.0D, series2, type8);
		 *
		 * defaultcategorydataset.addValue(4D, series3, type1);
		 * defaultcategorydataset.addValue(3D, series3, type2);
		 * defaultcategorydataset.addValue(2D, series3, type3);
		 * defaultcategorydataset.addValue(3D, series3, type4);
		 * defaultcategorydataset.addValue(6D, series3, type5);
		 * defaultcategorydataset.addValue(3D, series3, type6);
		 * defaultcategorydataset.addValue(4D, series3, type7);
		 * defaultcategorydataset.addValue(3D, series3, type8); JFreeChart
		 * jfreechart = ChartFactory.createLineChart("折线图Demo 1", "Type",
		 * "Value", defaultcategorydataset, PlotOrientation.VERTICAL, true,
		 * true, false); CategoryPlot categoryplot = (CategoryPlot)
		 * jfreechart.getPlot();
		 * categoryplot.setBackgroundPaint(Color.lightGray);
		 * categoryplot.setRangeGridlinePaint(Color.white); ChartFrame frame =
		 * new ChartFrame("折线图", jfreechart, true); frame.pack();
		 * frame.setVisible(true);
		 */
    }

    public void getDataFromMySQL(String mysql_IPAddress, String mysql_user, String mysql_password, String mysql_databaseName) {
        String url = "jdbc:mysql://" + mysql_IPAddress + ":3306/" + mysql_databaseName;
        Connection conn = JDBCUtils.connectToMySQL(url, mysql_user, mysql_password);
        String sql = "select cpuusage,memusage,updatetime from processinfo where processname=? and updatetime>=? and updatetime<=? and localIP=?";
        String qSql = "select count(*) from processinfo where processname=? and updatetime>=? and updatetime<=? and localIP=?";
        PreparedStatement pstmt = null;
        PreparedStatement pstmt1 = null;
        ResultSet rs = null;
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        String series1 = "CPUUsage";
        String series2 = "MemUsage";
        try {
            pstmt1 = conn.prepareStatement(qSql);
            pstmt1.setString(1, processName);
            pstmt1.setString(2, startTime);
            pstmt1.setString(3, endTime);
            pstmt1.setString(4, ip);
            rs = pstmt1.executeQuery();
            int total = 0;
            while (rs.next()) {
                total = rs.getInt(1);
            }
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, processName);
            pstmt.setString(2, startTime);
            pstmt.setString(3, endTime);
            pstmt.setString(4, ip);
            rs = pstmt.executeQuery();
            int size = 0;
            while (rs.next()) {
                size++;
                float cpuusage = rs.getFloat(1);
                float memusage = rs.getFloat(2);
                String updatetime = rs.getString(3);

                String[] array = updatetime.split(" ");
                System.out.println("当前时间：" + updatetime);
                System.out.println("CPU使用率：" + cpuusage + "%");
                System.out.println("内存使用率：" + memusage + "%");
                if (size % total == 0) {
                    defaultcategorydataset.addValue(cpuusage, series1, array[1]);
                    defaultcategorydataset.addValue(memusage, series2, array[1]);
                } else {
                    defaultcategorydataset.addValue(cpuusage, series1, "");
                    defaultcategorydataset.addValue(memusage, series2, "");
                }

            }
            String info = ip + "@" + processName;
            JFreeChart jfreechart = ChartFactory.createLineChart(info, "Time(m:s)", "Percent(%)", defaultcategorydataset, PlotOrientation.VERTICAL, true, true, false);
            CategoryPlot categoryplot = (CategoryPlot) jfreechart.getPlot();
            categoryplot.setBackgroundPaint(Color.lightGray);
            categoryplot.setRangeGridlinePaint(Color.white);
            ChartFrame frame = new ChartFrame("折线图", jfreechart, true);
            frame.pack();
            frame.setVisible(true);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
