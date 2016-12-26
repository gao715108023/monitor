package net.monitor.gather.traffic;

import net.monitor.bean.TrafficInfoBean;
import net.monitor.behavior.GatherAbstract;
import net.monitor.common.Constants;
import net.monitor.utils.HostUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hyperic.sigar.*;

/**
 * @author gaochuanjun
 * @since 2014/6/16
 */
public class TrafficForWindows extends GatherAbstract {

    private static final Log LOG = LogFactory.getLog(TrafficForWindows.class);

    private Sigar sigar;

    private NetInterfaceStat netInterfaceStat;

    private String networkCardName;

    protected TrafficForWindows(String ip, String networkCardName) {
        super(ip);
        this.networkCardName = networkCardName;
    }

    public static void main(String[] args) {
        GatherAbstract gatherAbstract = new TrafficForWindows(HostUtil.getHostIP(), "en4");
        new Thread(gatherAbstract).start();
    }

    @Override
    public void start() {

        sigar = new Sigar();

        getNetworkCardName();

        while (true) {
            process();
            try {
                Thread.sleep(Constants.SLEEPTIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void process() {

        getKernelStats();

        computePersistence();
    }

    @Override
    public void computePersistence() {

        long receiveTraffic = netInterfaceStat.getRxBytes() / Constants.UNITS;

        long receivePackets = netInterfaceStat.getRxPackets();

        long receiveErrs = netInterfaceStat.getRxErrors();

        long transmitTraffic = netInterfaceStat.getTxBytes() / Constants.UNITS;

        long transmitPackets = netInterfaceStat.getTxPackets();

        long transmitErrs = netInterfaceStat.getTxErrors();

        TrafficInfoBean trafficInfoBean = new TrafficInfoBean();

        trafficInfoBean.setIp(getIp());

        trafficInfoBean.setUpdateTime(getCurrentTime());

        trafficInfoBean.setReceiveTraffic(receiveTraffic);

        trafficInfoBean.setReceivePackets(receivePackets);

        trafficInfoBean.setReceiveErrs(receiveErrs);

        trafficInfoBean.setTransmitTraffic(transmitTraffic);

        trafficInfoBean.setTransmitPackets(transmitPackets);

        trafficInfoBean.setTransmitErrs(transmitErrs);

        getServerMsgDao().insert_traffic(trafficInfoBean);

        commitTransaction();

        if (LOG.isDebugEnabled()) {
            printMsg(trafficInfoBean);
        }
    }

    @Override
    public boolean getKernelStats() {
        try {
            netInterfaceStat = sigar.getNetInterfaceStat(networkCardName);
        } catch (SigarException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void printMsg(TrafficInfoBean trafficInfoBean) {

        LOG.info("接收到的总字节数:" + trafficInfoBean.getReceiveTraffic());// 接收到的总字节数

        LOG.info("接收的总包裹数:" + trafficInfoBean.getReceivePackets());// 接收的总包裹数

        LOG.info("接收到的错误包数:" + trafficInfoBean.getReceiveErrs());// 接收到的错误包数

        LOG.info("发送的总字节数:" + trafficInfoBean.getTransmitTraffic());// 发送的总字节数

        LOG.info("发送的总包裹数:" + trafficInfoBean.getTransmitPackets());// 发送的总包裹数

        LOG.info("发送数据包时的错误数:" + trafficInfoBean.getTransmitErrs());// 发送数据包时的错误数
    }

    public String getNetworkCardName() {
        try {
            String[] ifaces = sigar.getNetInterfaceList();
            for (String iface : ifaces) {
                NetInterfaceConfig cfg = sigar.getNetInterfaceConfig(iface);
                if (NetFlags.LOOPBACK_ADDRESS.equals(cfg.getAddress()) || (cfg.getFlags() & NetFlags.IFF_LOOPBACK) != 0 || NetFlags.NULL_HWADDR.equals(cfg.getHwaddr()))
                    continue;
                if (cfg.getAddress().equals(getIp())) {
                    setNetworkCardName(cfg.getName());
                    break;
                }
            }
        } catch (SigarException e) {
            e.printStackTrace();
        }
        return networkCardName;
    }

    public void setNetworkCardName(String networkCardName) {
        this.networkCardName = networkCardName;
    }

    @Override
    public void run() {
        start();
    }
}