package net.monitor.gather.traffic;

import net.monitor.dao.dto.TrafficMonitorDTO;
import net.monitor.dao.mapper.TrafficMonitorMapper;
import net.monitor.utils.Config;
import net.monitor.utils.DoubleUtils;
import net.monitor.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TrafficMonitor implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(TrafficMonitor.class);

    private static final AtomicBoolean running = new AtomicBoolean(true);

    private static final Pattern p = Pattern.compile("[^0-9]");

    private final String localIp;

    public TrafficMonitor(String localIp) {
        this.localIp = localIp;
    }

    public void start() {
        File netfp = new File("/proc/net/dev");
        if (!netfp.exists())
            LOGGER.error("Can't open /proc/net/dev");
        else
            LOGGER.info("Open /proc/net/dev......[OK]");

        while (running.get()) {
            double[] preDatas = getTrafficDatas(netfp);
            try {
                Thread.sleep(Config.intervalTime);
            } catch (InterruptedException e) {
                LOGGER.error("thread interrupted exception", e);
            }
            double[] curDatas = getTrafficDatas(netfp);
            computePersistence(preDatas, curDatas);
            System.arraycopy(curDatas, 0, preDatas, 0, preDatas.length);
        }
    }

    private void computePersistence(double[] preDatas, double[] curDatas) {
        double[] results = new double[6];
        for (int i = 0; i < results.length; i++) {
            results[i] = ((curDatas[i] - preDatas[i])) / (Config.intervalTime / 1000);
        }
        TrafficMonitorDTO trafficMonitorDTO = new TrafficMonitorDTO();
        trafficMonitorDTO.setIp(localIp);
        trafficMonitorDTO.setNetworkCardName(Config.networkCardName);
        trafficMonitorDTO.setReceiveTraffic(DoubleUtils.round(results[0]));
        trafficMonitorDTO.setReceivePackets(DoubleUtils.round(results[1]));
        trafficMonitorDTO.setReceiveErrs(DoubleUtils.round(results[2]));
        trafficMonitorDTO.setTransmitTraffic(DoubleUtils.round(results[3]));
        trafficMonitorDTO.setTransmitPackets(DoubleUtils.round(results[4]));
        trafficMonitorDTO.setTransmitErrs(DoubleUtils.round(results[5]));
        trafficMonitorDTO.setGmtCreate(new Date());
        insertSelective(trafficMonitorDTO);
    }

    private void insertSelective(TrafficMonitorDTO record) {
        try (SqlSession session = MybatisUtils.sqlSessionFactory.openSession(Boolean.FALSE)) {
            TrafficMonitorMapper trafficMonitorMapper = session.getMapper(TrafficMonitorMapper.class);
            trafficMonitorMapper.insertSelective(record);
            session.commit();
        }
    }

    private double[] getTrafficDatas(File netfp) {
        double[] datas = new double[6];
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(netfp));
            String tempString;
            while ((tempString = reader.readLine()) != null) {
                if (tempString.contains(Config.networkCardName)) {
                    Matcher m = p.matcher(tempString);
                    String str = m.replaceAll(" ").trim().replaceAll(" {2,}", " ");
                    String[] array = str.split(" ");
                    datas[0] += Double.parseDouble(array[1]);
                    datas[1] += Double.parseDouble(array[2]);
                    datas[2] += Double.parseDouble(array[3]);
                    datas[3] += Double.parseDouble(array[9]);
                    datas[4] += Double.parseDouble(array[10]);
                    datas[5] += Double.parseDouble(array[11]);
                }
            }
        } catch (Exception e) {
            LOGGER.error(String.format("read file %s error.", netfp.getAbsolutePath()), e);
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                LOGGER.error(String.format("close file %s error.", netfp.getAbsolutePath()), e);
            }
        }
        return datas;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        start();
    }
}
