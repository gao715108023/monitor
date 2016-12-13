package net.monitor.http;

import net.monitor.utils.ConfigUtils;
import net.monitor.utils.StringUtils;
import net.monitor.utils.TimeUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;


public class ConcurrentTest {

    private static int thread_num = 1; // 并发数

    private static int client_num = 1; // 用户数

    private List<byte[]> msgByteList = new ArrayList<byte[]>();

    private List<String> contentList = new ArrayList<String>();

    private String tokenId;

    private String versionCode = "7.50.00.12367";

    private int msgId = 1;

    private Random random = new Random();

    private int msgSize;

    private int sendRate;

    private int connectTimeOut;

    private int readTimeOut;

    private byte[] msg;

    private static String packMsg(byte[] dataArr) {
        AESUtil aes = new AESUtil("2)GwuBa1#$%^&*()");
        String str = null;
        try {
            byte[] enc = aes.encrypt(dataArr);
            // str = Base64Util.byteArrayToBase64(enc);
            str = new String(enc, "gb2312");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return str;
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

    private static void sleep(int sleep) {
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        // TODO Auto-generated method stub

        final ConcurrentTest concurrentTest = new ConcurrentTest();
        // concurrentTest.generateByteArray();
        concurrentTest.generateByList();
        ExecutorService exec = Executors.newCachedThreadPool();

        final Semaphore semp = new Semaphore(thread_num);

        for (int index = 0; index < client_num; index++) {

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            final int no = index;

            Runnable run = new Runnable() {

                public void run() {
                    concurrentTest.doProcess(semp, no);
                }
            };
            exec.execute(run);
        }
        exec.shutdown();
    }

    private String initialize() {

        String content = null;

        String configFilePath = "infoconfig.properties";

        ConfigUtils config = new ConfigUtils(configFilePath);

        String userS = config.getString("users");

        String tokenValue = config.getString("token_value");

        String concurrency = config.getString("concurrency");

        String version = config.getString("version");

        String send_rate = config.getString("send_rate");

        String connect_time_out = config.getString("connect_time_out");

        String read_time_out = config.getString("read_time_out");

        String file_path = config.getString("file_path");

        sendRate = Integer.parseInt(send_rate);

        versionCode = version;

        client_num = Integer.parseInt(userS);

        tokenId = tokenValue;

        thread_num = Integer.parseInt(concurrency);

        connectTimeOut = Integer.parseInt(connect_time_out);

        readTimeOut = Integer.parseInt(read_time_out);

        FileInputStream fis = null;

        BufferedReader br = null;

        try {
            fis = new FileInputStream(file_path);
            br = new BufferedReader(new InputStreamReader(fis, "gb2312"));
            String line;
            while ((line = br.readLine()) != null) {
                contentList.add(line);
                content = line;
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
        return content;
    }

    private void generateByteArray() {
        String content = initialize();
        String[] urlarr = content.split(":;");
        if (urlarr == null || urlarr.length < 2)
            return;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < sendRate; i++) {
            String dt = TimeUtils.getCurrentTime2();
            sb.append("\"" + dt + "\",\"" + urlarr[0] + "\",\"" + urlarr[1] + "\"\n");
        }
        System.err.println(sb.toString());
        msg = packMsgByte(StringUtils.stringToByte(sb.toString()));
    }

    private void generateByList() {
        String content = initialize();
        int size = contentList.size();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < sendRate; i++) {
            int index = i % size;
            String[] urlarr = content.split(":;");
            if (urlarr == null || urlarr.length < 2)
                return;
            content = contentList.get(index);
            String dt = TimeUtils.getCurrentTime2();
            sb.append("\"" + dt + "\",\"" + urlarr[0] + "\",\"" + urlarr[1] + "\"\n");
        }
        System.err.println(sb.toString());
        msg = packMsgByte(StringUtils.stringToByte(sb.toString()));
    }

    public void iteration(URL url, String host, HttpURLConnection connection, OutputStream os, String para, BufferedReader in, int no) throws IOException {
        url = new URL(host);
        connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setConnectTimeout(connectTimeOut);
        connection.setReadTimeout(readTimeOut);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        os = connection.getOutputStream();
        os.write(StringUtils.stringToByte(host));
        os.write(StringUtils.stringToByte(para));
        os.write(msg);
        os.flush();
        // System.err.println(host + "?" + para);
        in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line = "";
        String result = "";
        while ((line = in.readLine()) != null) {
            result += line;
        }
        // System.out.println("第：" + no + " 个");
    }

    public void doProcess(Semaphore semp, int no) {
        URL url = null;
        HttpURLConnection connection = null;
        BufferedReader in = null;
        OutputStream os = null;
        try {
            semp.acquire();
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        // System.out.println("Thread: " + no);
        String host = "http://10.15.144.76:8088/jci/collectUserData";
        String processId = "0";
        String para = "process_id=" + processId + "&token_id=" + tokenId + "&version_code=" + versionCode + "&msg_id=" + msgId + "&messages=";
        msgId++;
        try {
            iteration(url, host, connection, os, para, in, no);
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
            System.out.println("Connection time out, trying reconnect.....");
            try {
                if (in != null)
                    in.close();
                if (os != null)
                    os.close();

            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            sleep(1000);
            try {
                iteration(url, host, connection, os, para, in, no);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        } finally {
            try {
                if (in != null)
                    in.close();
                if (os != null)
                    os.close();
                connection.disconnect();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        semp.release();
    }

    class Client extends Thread {
        @Override
        public void run() {
            // TODO Auto-generated method stub
        }
    }
}
