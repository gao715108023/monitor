package net.monitor.utils;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {

    public static final SqlSessionFactory sqlSessionFactory;

    static {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        sqlSessionFactory = builder.build(MybatisUtils.class.getResourceAsStream("/MyBatis-Configuration.xml"));
    }
}
