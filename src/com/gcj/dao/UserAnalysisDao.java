package com.gcj.dao;

import java.util.List;

import com.gcj.bean.UserAnalysis;

public interface UserAnalysisDao {

    public void insert_user_analysis(UserAnalysis userAnalysis);

    public List<UserAnalysis> select_user_analysis();
}
