package net.monitor.utils;

import java.io.UnsupportedEncodingException;

public class StringUtils {
    public static boolean isNull(String str) {
        return str.equals("") || str.length() == 0;
    }

    public static byte[] stringToByte(String str) {
        try {
            return str.getBytes("gb2312");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] ipv4Address2BinaryArray(String ipAdd) {
        byte[] binIP = new byte[4];
        String[] strs = ipAdd.split("\\.");
        for (int i = 0; i < strs.length; i++) {
            binIP[i] = (byte) Integer.parseInt(strs[i]);
        }
        return binIP;
    }
}