package net.monitor.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author gaochuanjun
 * @since 14-5-13
 */
public class DateUtils {

  private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  private static Date stringToDate(String str) {
    try {
      return sdf.parse(str);
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }

  public static long getCurrentTimeMillis(String str) {
    return stringToDate(str).getTime();
  }
}
