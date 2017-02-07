package net.monitor.gather.netstat;

import net.monitor.dao.dto.NetstatMonitorDTO;
import net.monitor.dao.mapper.NetstatMonitorMapper;
import net.monitor.utils.Config;
import net.monitor.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.hyperic.sigar.NetStat;
import org.hyperic.sigar.Sigar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author gaochuanjun
 * @since 2014/6/16
 */
public class NetstatMonitorForWindows implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(NetstatMonitorForWindows.class);

    private static final AtomicBoolean running = new AtomicBoolean(true);

    private static final Sigar sigar = new Sigar();

    private final String localIp;

    public NetstatMonitorForWindows(String localIp) {
        this.localIp = localIp;
    }

    public void start() {
        while (running.get()) {
            try {
                NetStat netStat = sigar.getNetStat();
                computePersistence(netStat);
            } catch (Exception e) {
                LOGGER.error("monitor netstat error.", e);
            }
            try {
                Thread.sleep(Config.intervalTime);
            } catch (InterruptedException e) {
                LOGGER.error("thread error.", e);
            }
        }
    }

    private void computePersistence(NetStat netStat) {
        int established = netStat.getTcpEstablished();
        int timeWait = netStat.getTcpTimeWait();
        int finWait2 = netStat.getTcpFinWait2();
        int total = netStat.getTcpCloseWait() + netStat.getAllInboundTotal();
        NetstatMonitorDTO netstatMonitorDTO = new NetstatMonitorDTO();
        netstatMonitorDTO.setIp(localIp);
        netstatMonitorDTO.setPort(Config.listeningPort);
        netstatMonitorDTO.setTotal(total);
        netstatMonitorDTO.setEstablished(established);
        netstatMonitorDTO.setTimeWait(timeWait);
        netstatMonitorDTO.setFinWait2(finWait2);
        netstatMonitorDTO.setGmtCreate(new Date());
        insertSelective(netstatMonitorDTO);
    }

    private void insertSelective(NetstatMonitorDTO record) {
        try (SqlSession session = MybatisUtils.sqlSessionFactory.openSession(Boolean.FALSE)) {
            NetstatMonitorMapper netstatMonitorMapper = session.getMapper(NetstatMonitorMapper.class);
            netstatMonitorMapper.insertSelective(record);
            session.commit();
        }
    }

    @Override
    public void run() {
        start();
    }
}
