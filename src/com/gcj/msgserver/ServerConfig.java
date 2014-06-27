package com.gcj.msgserver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.gcj.common.StringUtil;

public class ServerConfig {
    public static Properties serverPropertyes = new Properties();

    public static String serverNo = String.format("%1$02d", new Object[]{Integer.valueOf(Integer.parseInt(getPropertieVal("serverNo")))});

    public static String zmqRouter = getPropertieVal("zmqRouter");

    public static String zmqDealer = getPropertieVal("zmqDealer");

    public static long recvHWM = Long.parseLong(getPropertieVal("recvHWM"));

    public static int dealerCount = Integer.parseInt(getPropertieVal("dealerCount"));

    public static int epollWaitTimeout = Integer.parseInt(getPropertieVal("epollWaitTimeout"));

    public static int msgCacheSize = Integer.parseInt(getPropertieVal("msgCacheSize")) * 1024 * 1024;

    public static String hdfsPath = getPropertieVal("hdfsPath");

    public static String colSplit = StringUtil.asciiToStr(getPropertieVal("colSplit"));

    public static String rowSplit = StringUtil.asciiToStr(getPropertieVal("rowSplit"));

    public static String charset = getPropertieVal("charset");

    public static String getPropertieVal(String properties) {
        if ((serverPropertyes == null) || (serverPropertyes.size() == 0))
            readProperties();
        return serverPropertyes.getProperty(properties);
    }

    public static void readProperties() {
        try {
            serverPropertyes.load(ServerConfig.class.getResourceAsStream("/MsgServer.properties"));
        } catch (FileNotFoundException e) {
            System.err.println("Error reading server properties");
            System.out.println(e.toString());
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public static void main(String[] args) {
        System.out.println(zmqDealer);
    }
}