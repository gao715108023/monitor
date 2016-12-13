package net.monitor.log;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogProcess {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LogProcess logProcess = new LogProcess();
        String filePath = "D:\\catalina.out";
        List<List<String>> allMessages = logProcess.readInfoFromLog(filePath);
        for (List<String> oneMessage : allMessages) {
            for (String message : oneMessage) {
                System.out.println(message);
            }
        }
    }

    public List<List<String>> readInfoFromLog(String filePath) {
        List<List<String>> allMessages = new ArrayList<List<String>>();
        File file = new File(filePath);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            List<String> oneMessage = null;
            while ((tempString = reader.readLine()) != null) {
                if (tempString.contains("token")) {
                    if (!tempString.contains("token:null")) {
                        oneMessage = new ArrayList<String>();
                        oneMessage.add(tempString);
                        // System.out.println(tempString);
                    }
                } else if (tempString.contains("MQ发送成功")) {
                    oneMessage.add(tempString);
                    allMessages.add(oneMessage);
                    oneMessage = null;
                } else if (oneMessage != null) {
                    oneMessage.add(tempString);
                }
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return allMessages;
    }
}
