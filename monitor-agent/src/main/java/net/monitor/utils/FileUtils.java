package net.monitor.utils;


import net.monitor.bean.ProcessInfoBean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA. User: zyj Date: 13-5-15 Time: 下午2:13 To change
 * this template use File | Settings | File Templates.
 */
public class FileUtils {

    private static final Log LOG = LogFactory.getLog(FileUtils.class);

    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public static List<ProcessInfoBean> readFileByLines(String fileName, String processName) {
        List<ProcessInfoBean> processInfoBeanList = new ArrayList<ProcessInfoBean>();
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString;
            ProcessInfoBean processInfoBean = null;
            while ((tempString = reader.readLine()) != null) {
                if (tempString.contains("root")) {
                    String cpu = tempString.substring(42, 45);
                    if (processInfoBean != null) {
                        processInfoBean.setCpuUsage(Float.parseFloat(cpu));
                    }
                    String memory = tempString.substring(47, 50);
                    if (processInfoBean != null) {
                        processInfoBean.setMemUsage(Integer.parseInt(memory));
                    }
                    processInfoBeanList.add(processInfoBean);
                } else if (tempString.contains("load average")) {
                    processInfoBean = new ProcessInfoBean();
                    processInfoBean.setProceeName(processName);
                    String updateTime = tempString.substring(6, 14);
                    processInfoBean.setUpdateTime(updateTime);
                }
            }
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
        return processInfoBeanList;
    }

    public static List<String> readFile(String fileName) {
        List<String> msgList = new ArrayList<String>();
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString;
            while ((tempString = reader.readLine()) != null) {
                msgList.add(tempString);
            }
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
        return msgList;
    }

    public static String getPid(String pidPath, int intervalTime) {
        String pid = null;

        File file = new File(pidPath);

        boolean lock = true;

        while (lock) {
            if (file.exists()) {
                BufferedReader reader = null;
                try {
                    reader = new BufferedReader(new FileReader(file));
                    String tempString;
                    while ((tempString = reader.readLine()) != null) {
                        String[] pids = tempString.split(" ");
                        pid = pids[0];
                    }
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } finally {
                    try {
                        if (reader != null)
                            reader.close();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                lock = false;
            } else {
                LOG.info(pidPath + " does not exist！");
                try {
                    Thread.sleep(intervalTime);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return pid;
    }

    public static String getPidOnce(String pidPath) {
        String pid = null;

        File file = new File(pidPath);

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString;
            while ((tempString = reader.readLine()) != null) {
                pid = tempString;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return pid;
    }

    public static List<String> getPidList(String pidPath) {
        List<String> pidList = new ArrayList<String>();

        File file = new File(pidPath);

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString;
            while ((tempString = reader.readLine()) != null) {
                pidList.add(tempString);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return pidList;
    }

    public static void writeFile(String filePath, String info) {
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            osw = new OutputStreamWriter(new FileOutputStream(filePath, false));
            bw = new BufferedWriter(osw);
            try {
                bw.write("#!/bin/sh");
                bw.newLine();
                bw.write(info);
                bw.newLine();
                bw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (osw != null)
                    osw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // FileUtils.readFileByLines("D:\\工作\\external_read_proxy_top.log",
        // "external_read_proxy");
        FileUtils.writeFile("D:\\test\\filewrite\\test.sh", "netstat -ant |grep ':6789' | grep 'FIN_WAIT2' |wc -l");
    }
}
