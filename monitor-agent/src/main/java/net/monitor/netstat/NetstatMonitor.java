package net.monitor.netstat;

import net.monitor.bean.NetstatBean;
import net.monitor.behavior.GatherAbstract;
import net.monitor.utils.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA. User: Administrator Date: 13-11-8 Time: 上午10:52
 * To change this template use File | Settings | File Templates.
 */
public class NetstatMonitor extends GatherAbstract {

    private static final Log LOG = LogFactory.getLog(NetstatMonitor.class);

    private int intervalTime;

    private int listeningPort;

    private Runtime runtime;

    private String cmds[];

    private int[] datas;

    public NetstatMonitor(String localHostIp, int intervalTime, int listeningPort) {
        super(localHostIp);
        this.intervalTime = intervalTime;
        this.listeningPort = listeningPort;
        this.initial();
    }

    private void initial() {
        datas = new int[4];
    }

    @Override
    public void start() {
        runtime = Runtime.getRuntime();
        setCmds();
        while (true) {
            process();
            try {
                Thread.sleep(intervalTime);
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
        NetstatBean netstatBean = new NetstatBean();
        netstatBean.setLocalHostIp(getIp());
        netstatBean.setPort(listeningPort);
        netstatBean.setUpdateTime(getCurrentTime());
        netstatBean.setTotal(datas[0]);
        netstatBean.setEstablished(datas[1]);
        netstatBean.setTimeWait(datas[2]);
        netstatBean.setFinWait2(datas[3]);
        getServerMsgDao().insert_netstat_monitor(netstatBean);
        commitTransaction();
    }

    @Override
    public boolean getKernelStats() {
        Process process = null;
        BufferedReader bufferedReader = null;
        try {
            for (int i = 0; i < 4; i++) {
                process = runtime.exec(cmds[i]);
                bufferedReader = new BufferedReader(new InputStreamReader(new BufferedInputStream(process.getInputStream())), 1024);
                String lineStr;
                while ((lineStr = bufferedReader.readLine()) != null) {
                    datas[i] = Integer.parseInt(lineStr);
                }
                if (process.waitFor() != 0 && process.exitValue() == 1)
                    LOG.error("Failed to perform the command: " + cmds[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
                if (process != null)
                    process.destroy();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    public void setCmds() {
        String totalCmd = "netstat -ant |grep ':" + listeningPort + "' |wc -l";
        String establishedCmd = "netstat -ant |grep ':" + listeningPort + "' |grep 'ESTABLISHED' |wc -l";
        String timeWaitCmd = "netstat -ant |grep ':" + listeningPort + "' |grep 'TIME_WAIT' |wc -l";
        String finWait2Cmd = "netstat -ant |grep ':" + listeningPort + "' | grep 'FIN_WAIT2' |wc -l";
        LOG.info("netstat For All STATE: " + totalCmd);
        LOG.info("netstat For ESTABLISHED STATE：" + establishedCmd);
        LOG.info("netstat For TIME_WAIT STATE：" + timeWaitCmd);
        LOG.info("netstat FOR FIN_WAIT2 STATE：" + finWait2Cmd);
        FileUtils.writeFile("established.sh", establishedCmd);
        FileUtils.writeFile("fin_wait2.sh", finWait2Cmd);
        FileUtils.writeFile("time_wait.sh", timeWaitCmd);
        FileUtils.writeFile("total.sh", totalCmd);
        addPermissions("established.sh");
        addPermissions("fin_wait2.sh");
        addPermissions("time_wait.sh");
        addPermissions("total.sh");
        cmds = new String[]{"sh total.sh", "sh established.sh", "sh time_wait.sh", "sh fin_wait2.sh"};
    }

    private void addPermissions(String file) {
        String cmd = "chmod +x " + file;
        BufferedReader bufferedReader = null;
        Process process = null;
        try {
            process = runtime.exec(cmd);
            bufferedReader = new BufferedReader(new InputStreamReader(new BufferedInputStream(process.getInputStream())), 1024);
            String lineStr;
            while ((lineStr = bufferedReader.readLine()) != null) {
                LOG.info(lineStr);
            }
            if (process.waitFor() != 0 && process.exitValue() == 1)
                LOG.error("Failed to perform the command: " + cmd);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
                if (process != null)
                    process.destroy();
            } catch (IOException e) {
                e.printStackTrace(); // To change body of catch statement use
                // File | Settings | File Templates.
            }
        }
    }

    @Override
    public void run() {
        // To change body of implemented methods use File | Settings | File
        // Templates.
        start();
    }
}
