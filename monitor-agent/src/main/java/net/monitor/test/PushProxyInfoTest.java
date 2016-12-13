package net.monitor.test;

import net.monitor.bean.Info;
import net.monitor.dao.InfoDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class PushProxyInfoTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PushProxyInfoTest pushProxyInfoTest = new PushProxyInfoTest();
        pushProxyInfoTest.pushProxyInfoTest();
    }

    public void pushProxyInfoTest() {
        String resource = "conf/MyBatis-Configuration.xml";
        Reader reader = null;
        SqlSession session = null;
        try {
            reader = Resources.getResourceAsReader(resource);
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(reader);
            session = factory.openSession();
            InfoDao infoDao = session.getMapper(InfoDao.class);
            List<Info> infoList = infoDao.select_pushproxyinfo("2013-08-07 00:00:00");
            for (Info pushProxyInfo : infoList) {
                System.out.println(pushProxyInfo.getUpdateTime());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (reader != null)
                    reader.close();
                if (session != null)
                    session.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
