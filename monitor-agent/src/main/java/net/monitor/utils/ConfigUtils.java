package net.monitor.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA. User: zyj Date: 13-5-16 Time: 下午2:40 To change
 * this template use File | Settings | File Templates.
 */
public class ConfigUtils {

    private Properties properties;

    private FileInputStream inputFile;

    /**
     * 读取文件
     *
     * @param filePath 文件路径
     */
    public ConfigUtils(String filePath) {
        properties = new Properties();
        try {
            inputFile = new FileInputStream(filePath);
            properties.load(inputFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputFile != null)
                    inputFile.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取配置文件中的数据
     *
     * @param key 需要获取的值
     * @return 获取的值
     */
    private String getValue(String key) {
        if (properties.containsKey(key)) {
            return properties.getProperty(key);
        } else
            return null;
    }

    public String getString(String key) {
        if (properties.containsKey(key)) {
            return properties.getProperty(key);
        } else
            return null;
    }

    public int getInt(String key) {
        if (properties.containsKey(key)) {
            String value = properties.getProperty(key);
            return Integer.parseInt(value);
        } else
            return -1;
    }

    public boolean getBoolean(String key) {
        boolean isOK = false;
        if (properties.containsKey(key)) {
            String value = properties.getProperty(key);
            if (value.equalsIgnoreCase("Y")) {
                isOK = true;
            }
        }
        return isOK;
    }

    /**
     * 获取配置文件中的数据
     *
     * @param fileName 文件名
     * @param key      需要获取的值
     * @return 获取的值
     */
    private String getValue(String fileName, String key) {
        try {
            String value = "";
            inputFile = new FileInputStream(fileName);
            properties.load(inputFile);
            inputFile.close();
            if (properties.contains(key)) {
                value = properties.getProperty(key);
                return value;
            } else
                return value;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
