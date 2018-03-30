package net.monitor.behavior;

import java.text.SimpleDateFormat;
import java.util.Date;
import net.monitor.common.Constants;
import net.monitor.dao.ServerMsgDao;

/**
 * @author gaochuanjun
 * @since 14-6-3
 */
public abstract class GatherAbstract implements Runnable {

    private ServerMsgDao serverMsgDao;

    private String ip;

    private SimpleDateFormat simpleDateFormat;

    protected GatherAbstract(String ip) {
        this.ip = ip;
        //this.serverMsgDao = MybatisUtils.session.getMapper(ServerMsgDao.class);
        this.simpleDateFormat = new SimpleDateFormat(Constants.DATE_FORMAT);
    }

    /**
     * 每个监控类的入口方法，
     */
    public abstract void start();

    public abstract void process();

    public abstract void computePersistence();

    public abstract boolean getKernelStats();

    /**
     * 关闭与数据库的连接
     */
    public void destroy() {
        //MybatisUtils.closeSession();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public ServerMsgDao getServerMsgDao() {
        return serverMsgDao;
    }

    public String getCurrentTime() {
        return simpleDateFormat.format(new Date());
    }

    public void commitTransaction() {
        //MybatisUtils.session.commit();
    }

    public float round(double value) {
        return (float) ((Math.round(value * 100)) / 100.0);
    }
}