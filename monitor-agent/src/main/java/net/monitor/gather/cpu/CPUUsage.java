package net.monitor.gather.cpu;

import net.monitor.utils.FileUtils;
import net.monitor.utils.SystemUtils;

import java.io.*;

public class CPUUsage {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String str = "6873 (a.out) R 6723 6873 6723 34819 6873 8388608 77 0 0 0 41958 31 0 0 25 0 3 0 5882654 1409024 56 4294967295 134512640 134513720 3215579040 0 2097798 0 0 0 0 0 0 0 17 0 0 0";
        String[] array = str.split(" ");
        System.out.println(array.length);
        CPUUsage cpuUsage = new CPUUsage();
        cpuUsage.getProcessCPUInfoFromStat("D:\\stat");
        double total = cpuUsage.getCPUInfoFromStat("D:\\工作\\stat");

        System.out.println(total);
        /*
         * ConfigUtils config = new
		 * ConfigUtils("/opt/proc/infoconfig.properties"); String processName =
		 * config.getValue("process_name"); String samplingTime =
		 * config.getValue("sampling_time"); int samplingTimeInt =
		 * Integer.parseInt(samplingTime); String pidPath =
		 * config.getValue("pidPath"); String pid = FileUtils.getPid(pidPath);
		 * String interval_time = config.getValue("interval_time"); int
		 * intervalTime = Integer.parseInt(interval_time); if (pid == null ||
		 * pid.endsWith(" ")) { System.out.println("Can't get the pid!");
		 * System.exit(0); } String processPath = "/proc/" + pid + "/stat";
		 * String path = "/proc/stat"; CPUUsage cpuUsage = new CPUUsage(); short
		 * cpuS = cpuUsage.getCPUs(); String cmd = "top -p " + pid + " -b -n 1";
		 * Runtime run = Runtime.getRuntime(); BufferedInputStream in = null;
		 * BufferedReader inBr = null; try { try { while (true) { float pcpu =
		 * cpuUsage.calUsage(processPath, path, cpuS, samplingTimeInt);
		 * System.out.println("CPUUsage: " + pcpu + "%"); Process p =
		 * run.exec(cmd); in = new BufferedInputStream(p.getInputStream()); inBr
		 * = new BufferedReader(new InputStreamReader(in), 1024); String
		 * lineStr; String topCPU = null; while ((lineStr = inBr.readLine()) !=
		 * null) { if (lineStr.contains(processName)) { lineStr =
		 * lineStr.replaceAll(" {2,}", " ").trim(); String[] array =
		 * lineStr.split(" "); topCPU = array[8]; } }
		 * System.out.println("CPUUsage: " + pcpu + "%      " + "TOP result: " +
		 * topCPU + "%"); Thread.sleep(intervalTime); } } catch (IOException e)
		 * { // TODO Auto-generated catch block e.printStackTrace(); } } catch
		 * (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } finally { try { if (inBr != null)
		 * inBr.close(); if (in != null) in.close(); } catch (IOException e) {
		 * // TODO Auto-generated catch block e.printStackTrace(); } }
		 */
    }

    public float getCPUUsageByTopCommond(String pid, String processName) {
        float pcpu = 0;
        String cmd = "top -p " + pid + " -b -n 1";
        BufferedInputStream in = null;
        BufferedReader inBr = null;
        Runtime run = Runtime.getRuntime();
        try {
            Process p = run.exec(cmd);
            in = new BufferedInputStream(p.getInputStream());
            inBr = new BufferedReader(new InputStreamReader(in), 1024);
            String lineStr;
            while ((lineStr = inBr.readLine()) != null) {
                if (lineStr.contains(processName)) {
                    lineStr = lineStr.replaceAll(" {2,}", " ").trim();
                    String[] array = lineStr.split(" ");
                    String cpu = array[8];
                    pcpu = Float.parseFloat(cpu);
                }
            }
            try {
                if (p.waitFor() != 0) {
                    if (p.exitValue() == 1) {
                        System.err.println("命令执行失败!");
                    }
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (inBr != null)
                    inBr.close();
                if (in != null)
                    in.close();
            } catch (IOException e) {
                e.printStackTrace(); // To change body of catch statement use
                // File | Settings | File Templates.
            }
        }
        return pcpu;
    }

    public float getCPUUsageByTopCommond(String pid, String processName, String filePath) {
        float pcpu = 0;
        String cmd = "top -p " + pid + " -b -n 1";
        BufferedInputStream in = null;
        BufferedReader inBr = null;
        Runtime run = Runtime.getRuntime();
        try {
            Process p = run.exec(cmd);
            in = new BufferedInputStream(p.getInputStream());
            inBr = new BufferedReader(new InputStreamReader(in), 1024);
            String lineStr;
            while ((lineStr = inBr.readLine()) != null) {
                FileUtils.writeShellFile(filePath, lineStr);
                if (lineStr.contains(processName)) {
                    lineStr = lineStr.replaceAll(" {2,}", " ").trim();
                    String[] array = lineStr.split(" ");
                    String cpu = array[8];
                    pcpu = Float.parseFloat(cpu);
                }
            }
            try {
                if (p.waitFor() != 0) {
                    if (p.exitValue() == 1) {
                        System.err.println("命令执行失败!");
                    }
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (inBr != null)
                    inBr.close();
                if (in != null)
                    in.close();
            } catch (IOException e) {
                e.printStackTrace(); // To change body of catch statement use
                // File | Settings | File Templates.
            }
        }
        return pcpu;
    }

    public float getCPUUsageByTopCommond(Runtime run, String cmd, String process_name) {
        float pcpu = -1;
        BufferedInputStream in = null;
        BufferedReader inBr = null;
        Process p = null;
        try {
            p = run.exec(cmd);
            in = new BufferedInputStream(p.getInputStream());
            inBr = new BufferedReader(new InputStreamReader(in), 1024);
            String lineStr;
            while ((lineStr = inBr.readLine()) != null) {
                if (lineStr.contains(process_name)) {
                    lineStr = lineStr.replaceAll(" {2,}", " ").trim();
                    String[] array = lineStr.split(" ");
                    String cpu = array[8];
                    pcpu = Float.parseFloat(cpu);
                }
            }
            if (p.waitFor() != 0) {
                if (p.exitValue() == 1) {
                    System.err.println("命令执行失败!");
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (inBr != null)
                    inBr.close();
                if (in != null)
                    in.close();
                if (p.getErrorStream() != null) {
                    p.getErrorStream().close();
                }
                if (p.getInputStream() != null) {
                    p.getInputStream().close();
                }
                if (p.getOutputStream() != null) {
                    p.getOutputStream().close();
                }
                if (p != null) {
                    p.waitFor();
                    p.destroy();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return pcpu;
    }

    public double getProcessCPUInfoFromStat(String fileName) {
        double total = 0;
        File file = new File(fileName);
        BufferedReader reader = null;
        FileReader fileReader = null;
        String[] strArray = null;
        String utime = null;
        String stime = null;
        String cutime = null;
        String cstime = null;
        try {
            fileReader = new FileReader(file);
            reader = new BufferedReader(fileReader);
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                strArray = tempString.split(" ");
                utime = strArray[13];
                stime = strArray[14];
                cutime = strArray[15];
                cstime = strArray[16];
                total = Double.parseDouble(utime) + Double.parseDouble(stime) + Double.parseDouble(cutime) + Double.parseDouble(cstime);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            SystemUtils.closeJVM();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                SystemUtils.closeJVM();
            }
            try {
                reader.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                SystemUtils.closeJVM();
            }
        }
        return total;
    }

    public double getCPUInfoFromStat(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        FileReader fileReader = null;
        double total = 0;
        String[] a = null;
        try {
            fileReader = new FileReader(file);
            reader = new BufferedReader(fileReader);
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                if (tempString.contains("cpu")) {
                    tempString = tempString.replaceAll(" {2,}", " ");
                    a = tempString.split(" ");
                    if (a[0].equalsIgnoreCase("cpu")) {
                        for (int i = 1; i < a.length; i++) {
                            total += Double.parseDouble(a[i]);
                        }
                    }
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            SystemUtils.closeJVM();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                SystemUtils.closeJVM();
            }
            try {
                reader.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                SystemUtils.closeJVM();
            }
        }
        return total;
    }

    public double calUsage(String processPath, String path, short cpuS, int samplingTime) {

        double pcpu = 0;

        try {

            double totalCpuTime1 = getCPUInfoFromStat(path);

            double processCpuTime1 = getProcessCPUInfoFromStat(processPath);

            Thread.sleep(samplingTime);

            double totalCpuTime2 = getCPUInfoFromStat(path);

            double processCpuTime2 = getProcessCPUInfoFromStat(processPath);

            pcpu = 100 * (processCpuTime2 - processCpuTime1) / (totalCpuTime2 - totalCpuTime1);

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return pcpu * cpuS;
    }

    public short getCPUs() {
        short cpuS = 0;
        FileReader reader = null;
        BufferedReader br = null;
        try {
            reader = new FileReader("/proc/cpuinfo");
            br = new BufferedReader(reader);
            String str = null;
            while ((str = br.readLine()) != null) {
                String a[] = str.split(":");
                if (a[0].trim().equals("processor")) {
                    cpuS++;
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return cpuS;
    }
}
