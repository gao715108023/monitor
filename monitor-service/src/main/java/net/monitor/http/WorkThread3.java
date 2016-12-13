package net.monitor.http;

import net.monitor.utils.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class WorkThread3 implements Runnable {

    private String processId;

    private String tokenId;

    private String versionCode;

    private int connectTimeOut;

    private int readTimeOut;

    private byte[] msg;

    public WorkThread3(String processId, String tokenId, String versionCode, int connectTimeOut, int readTimeOut, byte[] msg) {
        super();
        this.processId = processId;
        this.tokenId = tokenId;
        this.versionCode = versionCode;
        this.connectTimeOut = connectTimeOut;
        this.readTimeOut = readTimeOut;
        this.msg = msg;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    private boolean exeucute() {
        boolean result = true;
        URL url = null;
        URLConnection connection = null;
        OutputStream os = null;
        BufferedReader in = null;
        String host = new String("http://10.15.87.19:8088/jci/collectUserData");
        HttpConstants.msgId++;
        String para = "process_id=" + processId + "&token_id=" + tokenId + "&version_code=" + versionCode + "&msg_id=" + HttpConstants.msgId + "&messages=";

        try {
            url = new URL(host);
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setConnectTimeout(connectTimeOut);
            connection.setReadTimeout(readTimeOut);
            connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            if (msg != null) {
                os = connection.getOutputStream();
                os.write(StringUtils.stringToByte(host));
                os.write(StringUtils.stringToByte(para));
                os.write(msg);
                os.flush();
                System.out.println(host + "?" + para);
                in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line = "";
                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                }
            }

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
            result = false;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
            result = false;
        } finally {
            try {
                if (os != null)
                    os.close();
                if (in != null)
                    in.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                //e.printStackTrace();
                result = false;
            }
        }
        return result;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        boolean result = exeucute();
        if (!result) {
            HttpConstants.timeoutCount++;
        }
        // while (!result) {
        // try {
        // Thread.sleep(1000);
        // } catch (InterruptedException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        // result = exeucute();
        // }
    }
}
