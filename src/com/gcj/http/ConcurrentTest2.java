package com.gcj.http;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.gcj.utils.ConfigUtils;
import com.gcj.utils.StringUtils;
import com.gcj.utils.TimeUtils;

public class ConcurrentTest2 implements Runnable {

    private int thread_num; // 并发数

    private int client_num; // 用户数

    private String processId;

    private String tokenId;

    private String versionCode;

    private int sendRate;

    private int connectTimeOut;

    private int readTimeOut;

    private String filePath;

    public ConcurrentTest2(int thread_num, int client_num, String processId, String tokenId, String versionCode, int sendRate, int connectTimeOut, int readTimeOut, String filePath) {
        super();
        this.thread_num = thread_num;
        this.client_num = client_num;
        this.processId = processId;
        this.tokenId = tokenId;
        this.versionCode = versionCode;
        this.sendRate = sendRate;
        this.connectTimeOut = connectTimeOut;
        this.readTimeOut = readTimeOut;
        this.filePath = filePath;
    }

    private List<String> readInfoFromTxt() {

        List<String> contentList = new ArrayList<String>();

        FileInputStream fis = null;

        BufferedReader br = null;

        try {
            fis = new FileInputStream(filePath);
            br = new BufferedReader(new InputStreamReader(fis, "gb2312"));
            String line;
            while ((line = br.readLine()) != null) {
                contentList.add(line);
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return contentList;
    }

    private byte[] generateByList() {
        List<String> contentList = readInfoFromTxt();
        int size = contentList.size();
        StringBuffer sb = new StringBuffer();
        String content = null;
        for (int i = 0; i < sendRate; i++) {
            int index = i % size;
            content = contentList.get(index);
            String[] urlarr = content.split(":;");
            if (urlarr == null || urlarr.length < 2)
                return null;
            content = contentList.get(index);
            String dt = TimeUtils.getCurrentTime2();
            sb.append("\"" + dt + "\",\"" + urlarr[0] + "\",\"" + urlarr[1] + "\"\n");
        }
        //System.err.println(sb.toString());
        return packMsgByte(StringUtils.stringToByte(sb.toString()));
    }

    private static byte[] packMsgByte(byte[] dataArr) {
        AESUtil aes = new AESUtil("2)GwuBa1#$%^&*()");
        try {
            return aes.encrypt(dataArr);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {

        // TODO Auto-generated method stub
        String configFilePath = "infoconfig.properties";

        ConfigUtils config = new ConfigUtils(configFilePath);

        int userS = config.getInt("users");

        String tokenValue = config.getString("token_value");

        int concurrency = config.getInt("concurrency");

        String version = config.getString("version");

        int send_rate = config.getInt("send_rate");

        int connect_time_out = config.getInt("connect_time_out");

        int read_time_out = config.getInt("read_time_out");

        String file_path = config.getString("file_path");

        ConcurrentTest2 concurrentTest = new ConcurrentTest2(concurrency, userS, "1", tokenValue, version, send_rate, connect_time_out, read_time_out, file_path);
        Thread thread = new Thread(concurrentTest);
        thread.start();
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        ExecutorService pool = Executors.newFixedThreadPool(thread_num);
        byte[] msg = generateByList();
        WorkThread3 workThread3 = new WorkThread3(processId, tokenId, versionCode, connectTimeOut, readTimeOut, msg);
        for (int i = 0; i < client_num; i++) {
            pool.execute(workThread3);
        }
        pool.shutdown();
        System.out.println("timeoutCount: " + HttpConstants.timeoutCount);
    }
}
