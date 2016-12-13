package net.monitor.utils;

import javax.swing.*;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created with IntelliJ IDEA. User: zyj Date: 13-5-16 Time: 下午2:35 To change
 * this template use File | Settings | File Templates.
 */
public class TimeUtils {

    private static SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static SimpleDateFormat f1 = new SimpleDateFormat("yyyyMMddHHmmss");

    public static String getCurrentTime() {
        Date today = new Date();

        // SimpleDateFormat f = new SimpleDateFormat("HH-mm-ss");
        return f.format(today);
    }

    public static String getCurrentTime2() {
        Date today = new Date();

        // SimpleDateFormat f = new SimpleDateFormat("HH-mm-ss");
        return f1.format(today);
    }

    public static Date getDate(String dateStr) {
        try {
            return f.parse(dateStr);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static boolean isValidDate(String s1, String s2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        try {
            c1.setTime(df.parse(s1));
            c2.setTime(df.parse(s2));
        } catch (ParseException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "日期格式错误", "提示！", JOptionPane.ERROR_MESSAGE);
        }
        int result = c1.compareTo(c2);
        if (result >= 0) {
            JOptionPane.showMessageDialog(null, "开始日期必须小于结束日期！", "提示！", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    public static Timestamp stringToTime(String dateString) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        dateFormat.setLenient(false);
        Timestamp dateTime = null;
        try {
            Date timeDate = dateFormat.parse(dateString);
            dateTime = new Timestamp(timeDate.getTime());
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dateTime;
    }

    public static List<Date> dateDiff(String startTime, String endTime, String format) {
        SimpleDateFormat sd = new SimpleDateFormat(format);
        List<Date> dateList = new ArrayList<Date>();
        long diff;
        try {
            long start = sd.parse(startTime).getTime();
            long end = sd.parse(endTime).getTime();
            diff = end - start;
            long dateLon = start;
            long day = diff / 20;
            for (int i = 0; i < 20; i++) {
                dateLon = dateLon + day;
                if (dateLon <= end) {
                    Date date = new Date(dateLon);
                    dateList.add(date);
                } else {
                    Date date = new Date(end);
                    dateList.add(date);
                }
            }

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dateList;
    }
}
