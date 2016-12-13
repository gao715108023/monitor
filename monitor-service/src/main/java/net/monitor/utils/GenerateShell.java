package net.monitor.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA. User: zyj Date: 13-5-15 Time: 下午4:24 To change
 * this template use File | Settings | File Templates.
 */
public class GenerateShell {
    public static void getShell(String processName) {
        List<String> pidList = FileUtils.readFile("D:\\工作\\pid.txt");

        FileWriter fileWriter = null;
        int j = 1;
        StringBuilder sb = null;

        try {
            String result;
            for (int i = 0; i < pidList.size(); i++) {

                if (i % 20 == 0) {

                    String filePath = "D:\\工作\\" + processName + "_top_" + j + ".sh";
                    fileWriter = new FileWriter(filePath);
                    sb = new StringBuilder();
                    fileWriter.write("#!/bin/sh\r\n");
                    j++;
                }

                if (sb != null) {
                    sb.append("top -p ");
                }

                String pid = pidList.get(i);
                if (sb != null) {
                    sb.append(pid).append(",");
                }

                if ((i + 1) % 20 == 0) {
                    String temp = null;
                    if (sb != null) {
                        temp = sb.toString();
                    }
                    int len = 0;
                    if (temp != null) {
                        len = temp.length();
                    }
                    String str = null;
                    if (temp != null) {
                        str = temp.substring(0, len - 1);
                    }
                    result = str + " -d 10 -b>" + processName + "_top_" + j + ".log &\r";
                    if (fileWriter != null) {
                        fileWriter.write(result);
                    }
                }
            }
            String temp = null;
            if (sb != null) {
                temp = sb.toString();
            }
            int len = 0;
            if (temp != null) {
                len = temp.length();
            }
            String str = null;
            if (temp != null) {
                str = temp.substring(0, len - 1);
            }
            result = str + " -d 10 -b>" + processName + "_top_" + j + ".log &\r";
            if (fileWriter != null) {
                fileWriter.write(result);
            }

        } catch (IOException e) {
            e.printStackTrace(); // To change body of catch statement use File |
            // Settings | File Templates.
        } finally {
            try {
                if (fileWriter != null)
                    fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace(); // To change body of catch statement use
                // File | Settings | File Templates.
            }
        }
        // }
    }

    public static void main(String[] args) {
        GenerateShell.getShell("CalculationUnit");
    }
}