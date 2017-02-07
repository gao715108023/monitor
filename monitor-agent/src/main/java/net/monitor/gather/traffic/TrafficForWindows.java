package net.monitor.gather.traffic;

import net.monitor.common.Constants;
import net.monitor.dao.dto.TrafficMonitorDTO;
import net.monitor.dao.mapper.TrafficMonitorMapper;
import net.monitor.utils.Config;
import net.monitor.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.hyperic.sigar.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author gaochuanjun
 * @since 2014/6/16
 */
public class TrafficForWindows implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(TrafficForWindows.class);

    private static final AtomicBoolean running = new AtomicBoolean(true);

    private final String localIp;

    public TrafficForWindows(String localIp) {
        this.localIp = localIp;
    }

    public void start() {
        Sigar sigar = new Sigar();
        String networkCardName = getNetworkCardName(sigar);
        while (running.get()) {
            process(sigar, networkCardName);
            try {
                Thread.sleep(Config.intervalTime);
            } catch (InterruptedException e) {
                LOGGER.error("thread error.", e);
            }
        }
    }

    private void process(Sigar sigar, String networkCardName) {
        try {
            NetInterfaceStat netInterfaceStat = sigar.getNetInterfaceStat(networkCardName);
            TrafficMonitorDTO trafficMonitorDTO = new TrafficMonitorDTO();
            trafficMonitorDTO.setIp(localIp);
            trafficMonitorDTO.setNetworkCardName(networkCardName);
            trafficMonitorDTO.setReceiveTraffic((float) (netInterfaceStat.getRxBytes() / Constants.UNITS));
            trafficMonitorDTO.setReceivePackets((float) netInterfaceStat.getRxPackets());
            trafficMonitorDTO.setReceiveErrs((float) netInterfaceStat.getRxErrors());
            trafficMonitorDTO.setTransmitTraffic((float) (netInterfaceStat.getTxBytes() / Constants.UNITS));
            trafficMonitorDTO.setTransmitPackets((float) netInterfaceStat.getTxPackets());
            trafficMonitorDTO.setTransmitErrs((float) netInterfaceStat.getTxErrors());
            trafficMonitorDTO.setGmtCreate(new Date());
            LOGGER.debug(trafficMonitorDTO.toString());
            insertSelective(trafficMonitorDTO);
        } catch (SigarException e) {
            LOGGER.error("gather traffic error.", e);
        }
    }

    private void insertSelective(TrafficMonitorDTO record) {
        try (SqlSession session = MybatisUtils.sqlSessionFactory.openSession(Boolean.FALSE)) {
            TrafficMonitorMapper trafficMonitorMapper = session.getMapper(TrafficMonitorMapper.class);
            trafficMonitorMapper.insertSelective(record);
            session.commit();
        }
    }

    private String getNetworkCardName(Sigar sigar) {
        try {
            String[] netInterfaceList = sigar.getNetInterfaceList();
            for (String netInterface : netInterfaceList) {
                NetInterfaceConfig netInterfaceConfig = sigar.getNetInterfaceConfig(netInterface);
                if (NetFlags.LOOPBACK_ADDRESS.equals(netInterfaceConfig.getAddress()) || (netInterfaceConfig.getFlags() & NetFlags.IFF_LOOPBACK) != 0 || NetFlags.NULL_HWADDR.equals(netInterfaceConfig.getHwaddr())) {
                    continue;
                }
                if (netInterfaceConfig.getAddress().equals(localIp)) {
                    return netInterfaceConfig.getName();
                }
            }
        } catch (SigarException e) {
            LOGGER.error("get network card name error.", e);
        }
        return null;
    }

    @Override
    public void run() {
        start();
    }
}