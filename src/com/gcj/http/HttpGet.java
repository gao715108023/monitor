package com.gcj.http;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.gcj.bean.UserAnalysis;
import com.gcj.dao.UserAnalysisDao;
import com.gcj.utils.ConfigUtils;
import com.gcj.utils.MybatisUtils;

public class HttpGet {

    public List<String> getRules(String filePath) {
        List<String> rulesList = new ArrayList<String>();
        File file = new File(filePath);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                rulesList.add(tempString);
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rulesList;
    }

    private List<UserAnalysis> getInfoFromDB() {
        UserAnalysisDao userAnalysisDao = MybatisUtils.session.getMapper(UserAnalysisDao.class);
        List<UserAnalysis> userAnalysisList = userAnalysisDao.select_user_analysis();
        return userAnalysisList;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int cpuS = Runtime.getRuntime().availableProcessors();
        String filePath = "infoconfig.properties";
        ConfigUtils config = new ConfigUtils(filePath);
        String userS = config.getString("users");
        String tokenValue = config.getString("token_value");
        int threads = Integer.parseInt(userS);
        int timeInterval = Integer.parseInt(config.getString("collect_time"));
        ExecutorService pool = Executors.newFixedThreadPool(cpuS);
        HttpGet httpGet = new HttpGet();
        WorkThread workThread = new WorkThread(httpGet.getInfoFromDB(), timeInterval, tokenValue);
        for (int i = 0; i < threads; i++) {
            pool.execute(workThread);
        }
    }
}
