package com.gcj.dao;

import java.util.List;

import com.gcj.bean.Info;

public interface InfoDao {

    public int insert_pushproxyinfo(Info pushProxyInfo);

    public List<Info> select_pushproxyinfo(String updateTime);

    public int insert_querywebinfo(Info info);

    public List<Info> select_querywebinfo(String updateTime);

    public int insert_cjiinfo(Info info);

    public List<Info> select_cjiinfo(String updateTime);

    public int insert_elasticsearch(Info info);
}
