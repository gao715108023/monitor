package net.monitor.utils;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {

  public static final SqlSessionFactory SQL_SESSION_FACTORY;

  static {
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    SQL_SESSION_FACTORY = builder
        .build(MybatisUtils.class.getResourceAsStream("/MyBatis-Configuration.xml"));
  }
}
