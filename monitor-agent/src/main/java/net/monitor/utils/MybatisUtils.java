package net.monitor.utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {

    //private static final Log LOG = LogFactory.getLog(MybatisUtils.class);
    public static SqlSession session = null;
    // private static String resource = "/conf/MyBatis-Configuration.xml";
    //private static Reader reader = null;

    static {
        //if (LOG.isDebugEnabled()) {
        //    LOG.info("配置文件路径：" + new File(System.getProperty("user.dir")).getParent() + resource);
        //}
        //reader = new FileReader(new File((new File(System.getProperty("user.dir")).getParent() + resource)));
        //reader = Resources.getResourceAsReader((new File("").getAbsolutePath() + resource));
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(MybatisUtils.class.getResourceAsStream("/MyBatis-Configuration.xml"));
        session = factory.openSession();
    }

    public static void closeSession() {
        if (session != null)
            session.close();
    }
}
