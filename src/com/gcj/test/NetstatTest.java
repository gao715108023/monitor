package com.gcj.test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NetstatTest {

    public int getUsers() {
        int users = 0;
        String cmd = "sh /opt/elasticsearch_test/statistics.sh";
        BufferedInputStream in = null;
        BufferedReader inBr = null;
        Runtime run = Runtime.getRuntime();
        try {
            Process p = run.exec(cmd);
            in = new BufferedInputStream(p.getInputStream());
            inBr = new BufferedReader(new InputStreamReader(in), 1024);
            String lineStr;
            while ((lineStr = inBr.readLine()) != null) {
                System.out.println(lineStr);
            }
            if (p.waitFor() != 0) {
                if (p.exitValue() == 1) {
                    System.err.println("命令执行失败!");
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (inBr != null)
                    inBr.close();
                if (in != null)
                    in.close();
            } catch (IOException e) {
                e.printStackTrace(); // To change body of catch statement use
                // File | Settings | File Templates.
            }
        }
        return users;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        NetstatTest netstatTest = new NetstatTest();
        netstatTest.getUsers();
    }
}
