package com.gcj.utils;

import java.io.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.gcj.common.Constants;

public class MybatisUtils {

    private static final Log LOG = LogFactory.getLog(MybatisUtils.class);

    private static String resource = "/conf/MyBatis-Configuration.xml";

    private static Reader reader = null;

    public static SqlSession session = null;

    static {
        try {
//            File file = new File((new File("").getAbsolutePath() + resource));
//            if (file.exists()) {
//                System.out.println("发现文件");
//            } else {
//                System.err.println("找不到文件");
//            }
            if (Constants.OS == 1) {
                resource = "\\conf\\MyBatis-Configuration.xml";
                //LOG.info(new File(System.getProperty("user.dir")).getParent());
            }
            if (LOG.isDebugEnabled()) {
                LOG.info("配置文件路径：" + new File(System.getProperty("user.dir")).getParent() + resource);
            }
            reader = new FileReader(new File((new File(System.getProperty("user.dir")).getParent() + resource)));
            //reader = Resources.getResourceAsReader((new File("").getAbsolutePath() + resource));
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(reader);
            session = factory.openSession();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void closeSession() {
        try {
            if (reader != null)
                reader.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (session != null)
            session.close();
    }

    public static void main(String[] args) {
        MybatisUtils.closeSession();
    }
}
