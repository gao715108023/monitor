package net.monitor.gather.netstat;

import net.monitor.bean.NetstatBean;
import net.monitor.behavior.GatherAbstract;
import net.monitor.common.Constants;
import net.monitor.utils.HostUtil;
import net.monitor.utils.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hyperic.sigar.NetStat;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

/**
 * Created by gaochuanjun on 2014/6/16.
 */
public class NetstatForWindows extends GatherAbstract {

    private static final Log LOG = LogFactory.getLog(NetstatForWindows.class);

    private Sigar sigar;

    private NetStat netStat;

    private byte[] ipBytes;

    private long port;

    protected NetstatForWindows(String ip, long port) {
        super(ip);
        this.port = port;
    }

    public static void main(String[] args) {
        GatherAbstract gatherAbstract = new NetstatForWindows(HostUtil.getHostIP(), 445);
        new Thread(gatherAbstract).start();
    }

    @Override
    public void start() {
        sigar = new Sigar();
        ipBytes = StringUtils.ipv4Address2BinaryArray(getIp());
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

        int established = netStat.getTcpEstablished();
        int timeWait = netStat.getTcpTimeWait();
        int finWait2 = netStat.getTcpFinWait2();
        int total = netStat.getTcpCloseWait() + netStat.getAllInboundTotal();
        NetstatBean netstatBean = new NetstatBean();

        netstatBean.setLocalHostIp(getIp());

        netstatBean.setPort((int) port);

        netstatBean.setUpdateTime(getCurrentTime());

        netstatBean.setTotal(total);

        netstatBean.setEstablished(established);

        netstatBean.setTimeWait(timeWait);

        netstatBean.setFinWait2(finWait2);

        if (LOG.isDebugEnabled()) {
            printMsg(netstatBean);
        }
    }

    @Override
    public boolean getKernelStats() {
        try {
            //netStat = sigar.getNetStat(ipBytes, port);
            netStat = sigar.getNetStat();
        } catch (SigarException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void printMsg(NetstatBean netstatBean) {
        LOG.info("IP地址：" + netstatBean.getLocalHostIp());
        LOG.info("更新时间：" + netstatBean.getUpdateTime());
        LOG.info("端口号：" + netstatBean.getPort());
        LOG.info("总连接数：" + netstatBean.getTotal());
        LOG.info("Established状态的连接数：" + netstatBean.getEstablished());
        LOG.info("TimeWait状态的连接数：" + netstatBean.getTimeWait());
        LOG.info("FinWait2状态的连接数：" + netstatBean.getFinWait2());
    }

    @Override
    public void run() {
        start();
    }
}
