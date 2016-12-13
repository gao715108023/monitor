package net.monitor.gc;

import net.monitor.utils.FileUtils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class GCLogAnalysis {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        GCLogAnalysis gcLogAnalysis = new GCLogAnalysis();
        // gcLogAnalysis.parsingStr("80534.473: [GC 12392084K->4728864K(17658496K), 0.3187020 secs]");
        // gcLogAnalysis.getProcessStartTime("22:50:34");79200+3000+34
        // long millisTime = gcLogAnalysis.timeToMillis("22:50:34");
        // System.out.println(millisTime);
        // gcLogAnalysis.processStartTime("22:50:34");
    }

    private List<String> readMsgFromLog(String filePath) {
        return FileUtils.readFile(filePath);
    }

    private long[] parsingStr(String srcStr) {
        long[] result = new long[2];
        String[] firstArray = srcStr.split(":");
        result[0] = Integer.parseInt(firstArray[0]) * 1000;
        String[] secondArray = firstArray[1].split(",");
        String[] threeArray = secondArray[1].split(" ");
        result[1] = Integer.parseInt(threeArray[1]);
        return result;
    }

    private long processStartTime(String lastTime) {
        return System.currentTimeMillis() - timeToMillis(lastTime);
    }

    private long timeToMillis(String lastTime) {
        String[] array = lastTime.split(":");
        return (Integer.parseInt(array[0]) * 60 * 60 + Integer.parseInt(array[1]) * 60 + Integer.parseInt(array[2])) * 1000;
    }

    private String getLastTime(String cmd) {
        BufferedReader inBr = null;
        String lastTime = null;
        try {
            inBr = new BufferedReader(new InputStreamReader(new BufferedInputStream(Runtime.getRuntime().exec(cmd).getInputStream())), 1024);
            String lineStr;
            while ((lineStr = inBr.readLine()) != null) {
                String[] array = lineStr.replaceAll(" {2,}", " ").trim().split(" ");
                lastTime = array[1];
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (inBr != null)
                    inBr.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return lastTime;
    }

    public void startJob(String filePath, String cmd) {
        List<String> fileContentS = readMsgFromLog(filePath);
        for (String content : fileContentS) {
            long[] temp = parsingStr(content);
            String lastTime = getLastTime(cmd);
            long startTime = processStartTime(lastTime);
            long updateTime = startTime + temp[0];
        }
    }
}
