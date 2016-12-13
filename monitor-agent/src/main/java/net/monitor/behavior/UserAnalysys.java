package net.monitor.behavior;

import net.monitor.bean.UserAnalysis;
import net.monitor.dao.UserAnalysisDao;
import net.monitor.log.LogProcess;
import net.monitor.utils.MybatisUtils;

import java.util.List;

public class UserAnalysys {

    private MybatisUtils mybatisUtils;

    private UserAnalysisDao userAnalysisDao;

    public UserAnalysys() {
        super();
        // TODO Auto-generated constructor stub
        mybatisUtils = new MybatisUtils();
        userAnalysisDao = MybatisUtils.session.getMapper(UserAnalysisDao.class);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        UserAnalysys userAnalysys = new UserAnalysys();
        userAnalysys.doProcess();
    }

    public void doProcess() {
        LogProcess logProcess = new LogProcess();
        String filePath = "D:\\catalina.out";
        List<List<String>> allMessages = logProcess.readInfoFromLog(filePath);
        for (List<String> oneMessage : allMessages) {
            UserAnalysis userAnalysis = new UserAnalysis();
            for (String message : oneMessage) {
                if (message.contains("---pid")) {

                    String result = segStr(message);
                    // System.out.println(result);
                    userAnalysis.setPid(Integer.parseInt(result));
                }
                if (message.contains("---message")) {
                    String[] array = message.split("message:");
                    // System.out.println(result);
                    userAnalysis.setMessage(array[1]);
                }
                if (message.contains("token")) {
                    String[] array1 = message.split("token:");
                    String[] array2 = array1[1].split(" ");
                    // System.out.println(array2[0]);
                    userAnalysis.setTokenValue(array2[0]);
                }
                if (message.contains("---v")) {
                    String result = segStr2(message);
                    // System.out.println(result);
                    userAnalysis.setVersion(result);
                }
            }
            userAnalysisDao.insert_user_analysis(userAnalysis);
            MybatisUtils.session.commit();
        }
    }

    private String segStr(String str) {
        String[] array = str.split(":");
        return array[1];
    }

    private String segStr2(String str) {
        String[] array1 = str.split(":");
        String[] array2 = array1[1].split(" ");
        return array2[0];
    }
}
