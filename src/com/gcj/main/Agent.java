package com.gcj.main;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created with IntelliJ IDEA. User: zyj Date: 13-5-15 Time: 下午5:39 To change
 * this template use File | Settings | File Templates.
 */
public class Agent implements Runnable {
    private ServerSocket serverSocket;// 服务器端套接字
    private int port; // 提供远程管理工具连接的端口号
    private String hostName; // 本地主机名

    /**
     * @param port
     */
    public Agent(int port) {
        this.port = port; // 初始化端口号
    }

    /**
     * 数据类型转换，将byte型转换为int型
     *
     * @param b
     * @return
     */
    public static int b2i(byte[] b) {
        int value = 0;
        for (int i = 0; i < 4; i++) {
            int shift = (4 - 1 - i) * 8;
            value += (b[i] & 0x000000FF) << shift;
        }
        return value;
    }

    /**
     * 监听端口等待远程管理工具的连接
     */
    public void listeningPort() {
        try {
            serverSocket = new ServerSocket(port); // 开启服务器监听端口
            while (true) {
                Socket socket = serverSocket.accept(); // 有远程管理工具连接进来
                // 接收到客户端的连接后，新建一个线程处理连接
                new Client(socket).start();
            }
        } catch (IOException e) {
            System.exit(0);
        }
    }

    /**
     * 获得主机名
     *
     * @return
     */
    private String getHostName() {
        InetAddress ia = null;
        try {
            ia = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        if (ia == null) {
            return "some error...";
        } else {
            String nodeName = ia.getHostName();
            if (nodeName.length() > 6) {
                hostName = nodeName.substring(0, 6);
            } else {
                hostName = nodeName;
            }
            return hostName;
        }
    }

    /**
     * 获取Group的状态信息
     *
     * @return
     */

    /**
     * 判断文件是否存在
     *
     * @param file
     * @return
     */
    private boolean isFileExists(File file) {
        return file.isFile();
    }

    @Override
    public void run() {
        // To change body of implemented methods use File | Settings | File
        // Templates.
        listeningPort();
    }

    /**
     * 内部类，处理远程管理工具的连接
     *
     * @author 高传俊
     */
    class Client extends Thread {
        private InputStream inputStream;// 网络输入流
        private OutputStream outputStream; // 网络输出流
        private Socket socket; // 套接字
        private DataOutputStream dos; // 数据输出流
        private DataInputStream dis; // 数据输入流
        private PrintWriter pw; // 字符串输入输出流

        /**
         * 构造函数，初始化Socket
         *
         * @param socket
         */
        public Client(Socket socket) {
            try {
                this.socket = socket; // 初始化套接字
                inputStream = socket.getInputStream(); // 初始化网络输入流
                outputStream = socket.getOutputStream(); // 初始化网络输出流
                dos = new DataOutputStream(new BufferedOutputStream(outputStream)); // 初始化数据输出流
                dis = new DataInputStream(new BufferedInputStream(inputStream)); // 初始化数据输入流
                pw = new PrintWriter(socket.getOutputStream(), true);// 初始化字符串输入输出流
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        private String collectLog(String filePath, String fileName) {
            String returnInfo = "";
            File file = new File(filePath);
            long fileLength;// 文件长度
            if (isFileExists(file)) {
                fileLength = file.length();
                System.out.println("Agent is sending log " + fileName + "\nPlease wait......");
                // 获得本地的文件输入流
                DataInputStream di;
                try {
                    di = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
                    // 发送文件名和长度
                    try {
                        dos.writeUTF(fileName);
                        dos.writeLong(fileLength);
                        dos.flush();
                        // 发送文件内容
                        int first;
                        long j = fileLength / 10;
                        long i = 0;
                        int flag = 0;
                        long begin = System.currentTimeMillis();
                        while ((first = di.read()) != -1) {
                            dos.write(first);
                            // 如果文件大小大于1KB
                            if (fileLength > 2048) {
                                i++;
                                if (i % j == 0) {
                                    flag += 10;
                                    if (flag == 100) {
                                        System.out.println("100%!");
                                    } else {
                                        System.out.println(flag + "%-->");
                                    }
                                }
                            }
                        }
                        dos.flush();
                        // 关闭输入输出流
                        di.close();
                        long end = System.currentTimeMillis();
                        long costTime = end - begin;
                        double average = 0;
                        String speed = "The maximum network";
                        if (costTime > 1000) {
                            average = costTime / 1000;
                        }
                        if (costTime != 0) {
                            speed = (fileLength / costTime) + "Kb";
                        }
                        System.out.println("The Agent sends the log file " + fileName + " complete!");
                        System.out.println("Spent a total time:" + average + "second.Average speed:" + speed);
                        returnInfo = "success";
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        returnInfo = e.getMessage();
                        // e.printStackTrace();
                    }

                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    returnInfo = "File " + filePath + " is not found";
                    // e.printStackTrace();
                }
            }
            return returnInfo;
        }

        private String deleteTheBackupFile() {
            String returnInfo = "";
            if (deleteGroup("Group.jar.old")) {// 删除上次备份的Group
                returnInfo = "success";
                // dos.writeUTF("Deleted successfully!");
            } else {
                returnInfo = "failure";
                // dos.writeUTF("Deleted failure!");
            }
            // dos.flush();
            return returnInfo;
        }

        private void reStartGroup() {

        }

        public void run() {
            try {
                String commond = dis.readUTF(); // 读取远程管理工具的命令
                if (commond.equalsIgnoreCase("2")) { // 如果命令为2，待完成
                    collectLog("", "");
                } else if (commond.equalsIgnoreCase("4")) { // 如果命令为4
                    /*
					 * if (deleteGroup("Group.jar.old")) {// 删除上次备份的Group
					 * dos.writeUTF("Deleted successfully!"); } else {
					 * dos.writeUTF("Deleted failure!"); } dos.flush();
					 */
                    String resultInfo = deleteTheBackupFile();
                    dos.writeUTF(resultInfo);
                    dos.flush();
                } else if (commond.equalsIgnoreCase("8")) { // 如果命令为8，则重启Group
                    dos.writeUTF("restartsuccess");
                    dos.flush();
                    reStartGroup(); // 重启Group接口，待完成
                    // System.exit(0); // 关闭Group
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                try {
                    if (dos != null)
                        dos.close(); // 关闭数据输出流
                    if (dis != null)
                        dis.close(); // 关闭数据输入流
                    if (outputStream != null)
                        outputStream.close(); // 关闭网络输出流
                    if (inputStream != null)
                        inputStream.close(); // 关闭网络输入流
                    if (socket != null)
                        socket.close(); // 关闭套接字
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 删除本地Group
     */
    private boolean deleteGroup(String path) {
        // 获取本地文件的路径列表
        File file = new File(path);
        if (file.exists()) {
            file.delete();
            return true;
        } else {
            System.out.println("file[+" + file.getAbsolutePath() + "] dosen't not exists!");
            return false;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new Thread(new Agent(2001)).start();
    }
}