package net.monitor.gather.netstat;

import net.monitor.dao.dto.NetstatMonitorDTO;
import net.monitor.dao.mapper.NetstatMonitorMapper;
import net.monitor.utils.Config;
import net.monitor.utils.FileUtils;
import net.monitor.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created with IntelliJ IDEA. User: Administrator Date: 13-11-8 Time: 上午10:52
 * To change this template use File | Settings | File Templates.
 */
public class NetstatMonitor implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(NetstatMonitor.class);

    private static final AtomicBoolean running = new AtomicBoolean(true);

    private final String localIp;

    public NetstatMonitor(String localIp) {
        this.localIp = localIp;
    }

    public void start() {
        Runtime runtime = Runtime.getRuntime();
        String[] cmds = generateCmds(runtime);
        while (running.get()) {
            try {
                Thread.sleep(Config.intervalTime);
            } catch (InterruptedException e) {
                LOGGER.error("thread interrupted exception", e);
            }
            int[] datas = getDatas(runtime, cmds);
            computePersistence(datas);
        }
    }

    private void computePersistence(int[] datas) {
        NetstatMonitorDTO netstatMonitorDTO = new NetstatMonitorDTO();
        netstatMonitorDTO.setIp(localIp);
        netstatMonitorDTO.setPort(Config.listeningPort);
        netstatMonitorDTO.setTotal(datas[0]);
        netstatMonitorDTO.setEstablished(datas[1]);
        netstatMonitorDTO.setTimeWait(datas[2]);
        netstatMonitorDTO.setFinWait2(datas[3]);
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

    private int[] getDatas(Runtime runtime, String[] cmds) {
        int[] datas = new int[cmds.length];
        Process process = null;
        BufferedReader bufferedReader = null;
        try {
            for (int i = 0; i < cmds.length; i++) {
                process = runtime.exec(cmds[i]);
                bufferedReader = new BufferedReader(new InputStreamReader(new BufferedInputStream(process.getInputStream())), 1024);
                String lineStr;
                while ((lineStr = bufferedReader.readLine()) != null) {
                    datas[i] = Integer.parseInt(lineStr);
                }
                if (process.waitFor() != 0 && process.exitValue() == 1)
                    LOGGER.error("Failed to execute the command: {}", cmds[i]);
            }
        } catch (IOException | InterruptedException e) {
            LOGGER.error(String.format("Failed to execute commands: %s", Arrays.toString(cmds)), e);
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                LOGGER.error(String.format("close BufferedReader error: %s", Arrays.toString(cmds)), e);
            }
            if (process != null) {
                process.destroy();
            }
        }
        return datas;
    }


    private String[] generateCmds(Runtime runtime) {
        String totalCmd = "netstat -ant |grep ':" + Config.listeningPort + "' |wc -l";
        String establishedCmd = "netstat -ant |grep ':" + Config.listeningPort + "' |grep 'ESTABLISHED' |wc -l";
        String timeWaitCmd = "netstat -ant |grep ':" + Config.listeningPort + "' |grep 'TIME_WAIT' |wc -l";
        String finWait2Cmd = "netstat -ant |grep ':" + Config.listeningPort + "' | grep 'FIN_WAIT2' |wc -l";
        LOGGER.info("netstat For All STATE: {}", totalCmd);
        LOGGER.info("netstat For ESTABLISHED STATE：{}", establishedCmd);
        LOGGER.info("netstat For TIME_WAIT STATE：{}", timeWaitCmd);
        LOGGER.info("netstat FOR FIN_WAIT2 STATE：{}", finWait2Cmd);
        FileUtils.writeShellFile("established.sh", establishedCmd);
        FileUtils.writeShellFile("fin_wait2.sh", finWait2Cmd);
        FileUtils.writeShellFile("time_wait.sh", timeWaitCmd);
        FileUtils.writeShellFile("total.sh", totalCmd);
        addPermissions(runtime, "established.sh");
        addPermissions(runtime, "fin_wait2.sh");
        addPermissions(runtime, "time_wait.sh");
        addPermissions(runtime, "total.sh");
        return new String[]{"sh total.sh", "sh established.sh", "sh time_wait.sh", "sh fin_wait2.sh"};
    }

    private void addPermissions(Runtime runtime, String file) {
        String cmd = "chmod +x " + file;
        BufferedReader bufferedReader = null;
        Process process = null;
        try {
            process = runtime.exec(cmd);
            bufferedReader = new BufferedReader(new InputStreamReader(new BufferedInputStream(process.getInputStream())), 1024);
            String lineStr;
            while ((lineStr = bufferedReader.readLine()) != null) {
                LOGGER.info(lineStr);
            }
            if (process.waitFor() != 0 && process.exitValue() == 1)
                LOGGER.error("Failed to perform the command: " + cmd);
        } catch (IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            LOGGER.error(String.format("read file error, file = %s", file), e);
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                LOGGER.error(String.format("close BufferedReader file: %s", file), e);
            }
            if (process != null) {
                process.destroy();
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
