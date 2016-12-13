package net.monitor.dao;

import net.monitor.bean.UserAnalysis;

import java.util.List;


public interface UserAnalysisDao {

    void insert_user_analysis(UserAnalysis userAnalysis);

    List<UserAnalysis> select_user_analysis();
}
