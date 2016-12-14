package net.monitor.dao;

import net.monitor.source.IostatMonitorEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.List;
import java.util.Map;

/**
 * @author gaochuanjun
 * @since 14-5-13
 */
public class DBUtils {
    private static final SessionFactory ourSessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            ourSessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        try {
            System.out.println("querying all the managed entities...");
            final Map metadataMap = session.getSessionFactory().getAllClassMetadata();
            for (Object key : metadataMap.keySet()) {
                final ClassMetadata classMetadata = (ClassMetadata) metadataMap.get(key);
                final String entityName = classMetadata.getEntityName();
                System.out.println("EntityName: " + entityName);
            }
            final String entityName = "com.gw.source.IostatMonitorEntity";
            if (metadataMap.containsKey(entityName)) {
                final Query query = session.createQuery("from " + entityName + " where updateTime >= '2014-05-13 10:35:12'");
                System.out.println("executing: " + query.getQueryString());
                List<IostatMonitorEntity> iostatMonitorEntityList = query.list();
                for (IostatMonitorEntity iostatMonitorEntity : iostatMonitorEntityList) {
                    System.out.println(iostatMonitorEntity.getIp() + " " + iostatMonitorEntity.getUpdateTime() + " " + iostatMonitorEntity.getName() + " " + iostatMonitorEntity.getAwait() + " " + iostatMonitorEntity.getSvctm() + " " + iostatMonitorEntity.getUtil());
                }
            }
//            for (Object key : metadataMap.keySet()) {
//                final ClassMetadata classMetadata = (ClassMetadata) metadataMap.get(key);
//                final String entityName = classMetadata.getEntityName();
//                final Query query = session.createQuery("from " + entityName);
//                System.out.println("executing: " + query.getQueryString());
//                for (Object o : query.list()) {
//                    System.out.println("  " + o);
//                }
//            }
        } finally {
            session.close();
        }
    }
}
