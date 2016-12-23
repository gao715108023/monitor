package net.monitor.utils;

import net.monitor.domain.OS;
import net.monitor.domain.WatchProcess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author gaochuanjun
 * @since 15/1/7
 */
public class Config {

    public final static OS os;
    public static final int intervalTime;  //采集信息的间隔
    public static final int listeningPort;    //被监控的端口号
    public static final String networkCardName;     //网卡名
    public static final List<WatchProcess> watchProcessList = new ArrayList<>();   //被监控的进程信息
    private static final Logger LOGGER = LoggerFactory.getLogger(Config.class);
    private static Properties p = new Properties();

    static {
        load("/infoconfig.properties");
        intervalTime = getInt("sampling.time", 5000);
        os = OS.findOS(getInt("os", 0));
        listeningPort = getInt("listening.port.name", -1);
        networkCardName = get("network.card.name");
        String watchProcess = get("watch.process");
        if (StringUtils.isNotBlank(watchProcess)) {
            String[] watchProcessArray = watchProcess.split(",");
            for (String watchProcessGroup : watchProcessArray) {
                String[] watchProcessGroupArray = watchProcessGroup.split(":");
                if (watchProcessGroupArray.length != 2) {
                    throw new RuntimeException("配置文件错误，请按tomcat1:/opt/tomcat1/tomcat1.pid,tomcat2:/opt/tomcat2/tomcat2.pid格式配置");
                }
                watchProcessList.add(new WatchProcess(watchProcessGroupArray[0], watchProcessGroupArray[1]));
            }
        }
        LOGGER.info("os = {}, interval_time = {}, listening_port = {}, watch_process_list = {}", os, intervalTime, listeningPort, networkCardName, watchProcessList);
    }

    private static void load(String propPath) {
        try {
            if (p.size() == 0) {
                p.load(Config.class.getResourceAsStream(propPath));
            }
        } catch (IOException e) {
            LOGGER.error("load config error.", e);
            System.exit(-1);
        }
    }

    private static String getProperty(String name) {
        return p.getProperty(name);
    }

    /**
     * getProperty方法的简写
     *
     * @param name 属性名
     * @return value
     */
    private static String get(String name) {
        return getProperty(name);
    }

    /**
     * 从配制文件中获取一个整形的配制值，如果没有配制，则返回默认值
     *
     * @param item         属性名
     * @param defaultValue 默认值
     * @return int value
     */
    private static int getInt(String item, int defaultValue) {
        String value = getProperty(item);
        if (value == null) {
            return defaultValue;
        }
        int ret = defaultValue;
        try {
            ret = Integer.parseInt(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    private static boolean getBoolean(String item, boolean defaultValue) {
        String value = getProperty(item);
        if (value == null) {
            return defaultValue;
        }
        boolean ret = defaultValue;
        try {
            ret = Boolean.parseBoolean(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
}
