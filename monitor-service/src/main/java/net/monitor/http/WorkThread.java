package net.monitor.http;

import net.monitor.bean.UserAnalysis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class WorkThread implements Runnable {

    private String urlStr;
    private int counts;
    private List<UserAnalysis> userAnalysisList;
    private int restCount;
    private String tokenValue;

    public WorkThread(List<UserAnalysis> userAnalysisList, int timeInterval, String tokenValue) {
        super();
        this.userAnalysisList = userAnalysisList;
        this.tokenValue = tokenValue;
        this.counts = (timeInterval * 60) / (userAnalysisList.size() * 10);
        int temp = this.counts * userAnalysisList.size() * 10;
        if (temp < timeInterval * 60) {
            this.restCount = timeInterval * 60 - temp;
            this.restCount /= 10;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        for (int i = 0; i < counts; i++) {
            for (UserAnalysis userAnalysis : userAnalysisList) {
                int pid = userAnalysis.getPid();
                String version = userAnalysis.getVersion();
                String message = userAnalysis.getMessage();
                this.urlStr = "http://10.15.107.140:8088/jci/collectUserData?pid=" + pid + "&s=" + this.tokenValue + "&v=" + version + "&m=" + message;
                myDoGet();
            }
        }
        for (int i = 0; i < this.restCount; i++) {
            UserAnalysis userAnalysis = this.userAnalysisList.get(i);
            int pid = userAnalysis.getPid();
            String version = userAnalysis.getVersion();
            String message = userAnalysis.getMessage();
            this.urlStr = "http://10.15.107.140:8088/jci/collectUserData?pid=" + pid + "&s=" + this.tokenValue + "&v=" + version + "&m=" + message;
            System.err.println(this.urlStr);
            myDoGet();
        }
    }

    private void myDoGet() {
        String temp;
        InputStream in = null;
        InputStreamReader ins = null;
        BufferedReader br = null;
        HttpURLConnection httpURLConn = null;
        try {
            URL url = new URL(urlStr);
            httpURLConn = (HttpURLConnection) url.openConnection();
            httpURLConn.setDoOutput(true);
            httpURLConn.setRequestMethod("POST");
            httpURLConn.setIfModifiedSince(999999999);
            httpURLConn.connect();
            in = httpURLConn.getInputStream();
            ins = new InputStreamReader(in);
            br = new BufferedReader(ins);
            while ((temp = br.readLine()) != null) {
                System.out.println(temp);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (ins != null)
                    ins.close();
                if (in != null)
                    in.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            httpURLConn.disconnect();
        }
    }
}
