package net.monitor.gather;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author gaochuanjun
 * @since 2016/12/23
 */
public class CpuStaticInfo {

  private static final Logger LOGGER = LoggerFactory.getLogger(CpuStaticInfo.class);

  /**
   * 获取逻辑CPU个数
   *
   * @return 逻辑CPU个数
   */
  public static int getNumberOfCPUs() {
    int ncpu = 0;
    File ncpufp = new File("/proc/cpuinfo");
    if (!ncpufp.exists()) {
      LOGGER.error("Can't open /proc/cpuinfo");
      return ncpu;
    }
    BufferedReader reader = null;
    try {
      reader = new BufferedReader(new FileReader(ncpufp));
      String tempString;
      while ((tempString = reader.readLine()) != null) {
        if (tempString.contains("processor\t:")) {
          ncpu++;
        }
      }
      LOGGER.info("logical CPU number: " + ncpu);
    } catch (FileNotFoundException e) {
      LOGGER.error("/proc/cpuinfo文件不存在！", e);
    } catch (IOException e) {
      LOGGER.error("获取cpu数目失败！", e);
    } finally {
      try {
        if (reader != null) {
          reader.close();
        }
      } catch (IOException e) {
        LOGGER.error("关闭buffer异常！", e);
      }
    }
    return ncpu;
  }
}
