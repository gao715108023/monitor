package net.monitor.dao;

import net.monitor.bean.Info;

import java.util.List;

public interface InfoDao {

    int insert_pushproxyinfo(Info pushProxyInfo);

    List<Info> select_pushproxyinfo(String updateTime);

    int insert_querywebinfo(Info info);

    List<Info> select_querywebinfo(String updateTime);

    int insert_cjiinfo(Info info);

    List<Info> select_cjiinfo(String updateTime);

    int insert_elasticsearch(Info info);
}
