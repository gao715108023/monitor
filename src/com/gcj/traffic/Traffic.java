package com.gcj.traffic;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.gcj.bean.TrafficInfoBean;
import com.gcj.behavior.GatherAbstract;
import com.gcj.utils.DoubleUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Traffic extends GatherAbstract {

    private static final Log LOG = LogFactory.getLog(Traffic.class);

    private int intervalTimeMillisecond;
    private int intervalTimeSecond;
    private String networkCardName;
    private File netfp;
    private double[] oldDatas;
    private double[] newDatas;
    private Pattern p;

    public Traffic(int intervalTime, String ip, String networkCardName) {
        super(ip);
        this.intervalTimeMillisecond = intervalTime;
        this.intervalTimeSecond = intervalTime / 1000;
        this.networkCardName = networkCardName;
        this.p = Pattern.compile("[^0-9]");
        this.initial();
    }

    private void initial() {
        oldDatas = new double[6];
        newDatas = new double[6];
    }

    @Override
    public void start() {
        netfp = new File("/proc/net/dev");
        if (!netfp.exists())
            LOG.error("Can't open /proc/net/dev");
        else
            LOG.info("Open /proc/net/dev......[OK]");

        while (true) {
            process();
            try {
                Thread.sleep(intervalTimeMillisecond);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void process() {

        getKernelStats();

        computePersistence();

        for (int i = 0; i < newDatas.length; i++) {
            oldDatas[i] = newDatas[i];
            newDatas[i] = 0;
        }
    }

    @Override
    public void computePersistence() {
        double[] results = new double[6];
        for (int i = 0; i < results.length; i++) {
            results[i] = ((newDatas[i] - oldDatas[i])) / intervalTimeSecond;
        }
        TrafficInfoBean trafficInfoBean = new TrafficInfoBean();
        trafficInfoBean.setIp(getIp());
        trafficInfoBean.setUpdateTime(getCurrentTime());
        trafficInfoBean.setReceiveTraffic(DoubleUtils.round(results[0]));
        trafficInfoBean.setReceivePackets(DoubleUtils.round(results[1]));
        trafficInfoBean.setReceiveErrs(DoubleUtils.round(results[2]));
        trafficInfoBean.setTransmitTraffic(DoubleUtils.round(results[3]));
        trafficInfoBean.setTransmitPackets(DoubleUtils.round(results[4]));
        trafficInfoBean.setTransmitErrs(DoubleUtils.round(results[5]));
        getServerMsgDao().insert_traffic(trafficInfoBean);
        commitTransaction();
    }

    @Override
    public boolean getKernelStats() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(netfp));
            String tempString;
            while ((tempString = reader.readLine()) != null) {
                if (tempString.contains(networkCardName)) {
                    Matcher m = p.matcher(tempString);
                    String str = m.replaceAll(" ").trim().replaceAll(" {2,}", " ");
                    String[] array = str.split(" ");
                    newDatas[0] += Double.parseDouble(array[1]);
                    newDatas[1] += Double.parseDouble(array[2]);
                    newDatas[2] += Double.parseDouble(array[3]);
                    newDatas[3] += Double.parseDouble(array[9]);
                    newDatas[4] += Double.parseDouble(array[10]);
                    newDatas[5] += Double.parseDouble(array[11]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        start();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Traffic traffic = new Traffic(5000, "127.0.0.1", "eth0");
        Thread thread = new Thread(traffic);
        thread.start();
    }
}
