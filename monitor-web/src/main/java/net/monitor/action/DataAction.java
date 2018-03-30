package net.monitor.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.monitor.bean.HighChartBean;
import net.monitor.common.Constant;
import net.monitor.dao.DBAbstract;
import net.monitor.dao.JDBCCommon;
import net.monitor.source.ComputeNodeStatusEntity;
import net.monitor.source.IostatMonitorEntity;
import net.monitor.source.NetstatMonitorEntity;
import net.monitor.source.ServerMonitorEntity;
import net.monitor.source.TrafficMonitorEntity;

/**
 * @author gaochuanjun
 * @since 14-5-13
 */
public class DataAction extends ActionSupport {

  private String flag;

  private String ip;

  private String begin;

  private String end;

  private String diskname;

  private String await;

  private String svctm;

  private String util;

  private String processId;

  private String cpuUsage;

  private String memUsage;

  private String oneMinsProcs;

  private String fiveMinsProcs;

  private String fifteenMinsProcs;

  private String processName;

  private String receiveTraffic;

  private String transmitTraffic;

  private String port;

  private String total;

  private String established;

  private String timeWait;

  private String finWait2;

  private String totalTime;

  private String userTime;

  private String niceTime;

  private String systemTime;

  private String iowaitTime;

  private String idleTime;

  private String totalMemory;

  private String usedMemory;

  private String idleMemory;

  private String swapSize;

  private String usedSwap;

  private String idleSwap;

  private DBAbstract dbAbstract = new JDBCCommon();

  public String execute() {

    if (hasActionErrors()) {
      return INPUT;
    }
    if (flag.equals("1")) {
      if (getData())
      //getDiskname();
      {
        return "iostat";
      } else {
        return "nodata";
      }
    } else if (flag.equals("2")) {
      if (getServerMonitorData()) {
        return "CPUAndMemory";
      } else {
        return "nodata";
      }
    } else if (flag.equals("3")) {
      if (getTrafficMonitorData()) {
        return "traffic";
      } else {
        return "nodata";
      }

    } else if (flag.equals("4")) {
      if (getNetstatMonitorData()) {
        return "netstat";
      } else {
        return "nodata";
      }
    } else if (flag.equals("5")) {
      if (getComputeNodeStatus()) {
        return "computenodestatus";
      } else {
        return "nodata";
      }
    }
    return "error";
  }

  public void validate() {
    //用户输入验证
    if (begin == null || begin.trim().equals("")) {
      addFieldError("ip", "IP不能为空！");
    } else if (checkIP()) {
      addFieldError("ip", "IP格式错误！");
    }
//        System.out.println("begin: " + begin);
    if (begin == null || begin.trim().equals("")) {
//            System.out.println("begin: " + begin);
      addFieldError("begin", "开始时间不能为空！");
    }

    if (end == null || end.trim().equals("")) {
      addFieldError("end", "结束时间不能为空！");
    }

    if (flag.equals("1")) {
      if (diskname == null || diskname.trim().equals("")) {
        addFieldError("diskname", "磁盘名称不能为空！");
      }
    }

    if (flag.equals("2")) {
      if (processId == null || processId.trim().equals("")) {
        addFieldError("processId", "进程ID不能为空！");
      }
    }

    if (flag.equals("4")) {
      if (port == null || port.trim().equals("")) {
        addFieldError("port", "端口号不能为空！");
      }
    }
  }

  private boolean checkIP() {
    Pattern pattern = Pattern.compile(
        "\\b((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\b");
    Matcher matcher = pattern.matcher(ip);
    if (matcher.matches()) {
      return false;
    } else {
      return true;
    }
  }

  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

  public boolean getData() {
    List<IostatMonitorEntity> iostatMonitorEntities = dbAbstract
        .select_iostat_monitor(ip, begin, end, diskname);
    List<HighChartBean> awaitList = new ArrayList<HighChartBean>();
    List<HighChartBean> svctmList = new ArrayList<HighChartBean>();
    List<HighChartBean> utillist = new ArrayList<HighChartBean>();
    if (iostatMonitorEntities.size() == 0) {
      return false;
    }
    for (IostatMonitorEntity iostatMonitorEntity : iostatMonitorEntities) {
      awaitList.add(new HighChartBean(iostatMonitorEntity.getUpdateTime().getTime(),
          String.valueOf(iostatMonitorEntity.getAwait())));
      svctmList.add(new HighChartBean(iostatMonitorEntity.getUpdateTime().getTime(),
          String.valueOf(iostatMonitorEntity.getSvctm())));
      utillist.add(new HighChartBean(iostatMonitorEntity.getUpdateTime().getTime(),
          String.valueOf(iostatMonitorEntity.getUtil())));
    }
//        System.out.println(packData(awaitList));
    setAwait(packData(awaitList));
    setSvctm(packData(svctmList));
    setUtil(packData(utillist));
//        return packData(awaitList);
    return true;
  }

  public boolean getServerMonitorData() {
    List<ServerMonitorEntity> serverMonitorEntityList = dbAbstract
        .select_server_monitor(ip, begin, end, processId);
    List<HighChartBean> cpuList = new ArrayList<HighChartBean>();
    List<HighChartBean> memList = new ArrayList<HighChartBean>();
    List<HighChartBean> oneMinsProcsList = new ArrayList<HighChartBean>();
    List<HighChartBean> fiveMinsProcsList = new ArrayList<HighChartBean>();
    List<HighChartBean> fifteenMinsProcsList = new ArrayList<HighChartBean>();

    if (serverMonitorEntityList.size() == 0) {
      return false;
    }

    for (ServerMonitorEntity serverMonitorEntity : serverMonitorEntityList) {
      cpuList.add(new HighChartBean(serverMonitorEntity.getUpdateTime().getTime(),
          String.valueOf(serverMonitorEntity.getCpuUsage())));
      memList.add(new HighChartBean(serverMonitorEntity.getUpdateTime().getTime(),
          String.valueOf(serverMonitorEntity.getUsedMemory())));
      oneMinsProcsList.add(new HighChartBean(serverMonitorEntity.getUpdateTime().getTime(),
          String.valueOf(serverMonitorEntity.getOneMinsProcs())));
      fiveMinsProcsList.add(new HighChartBean(serverMonitorEntity.getUpdateTime().getTime(),
          String.valueOf(serverMonitorEntity.getFiveMinsProcs())));
      fifteenMinsProcsList.add(new HighChartBean(serverMonitorEntity.getUpdateTime().getTime(),
          String.valueOf(serverMonitorEntity.getFifteenMinsProcs())));
    }
    setCpuUsage(packData(cpuList));
    setMemUsage(packData(memList));
    setOneMinsProcs(packData(oneMinsProcsList));
    setFiveMinsProcs(packData(fiveMinsProcsList));
    setFifteenMinsProcs(packData(fifteenMinsProcsList));
    return true;
  }

  public boolean getTrafficMonitorData() {
    List<TrafficMonitorEntity> trafficMonitorEntityList = dbAbstract
        .select_traffic_monitor(ip, begin, end);
    List<HighChartBean> receiveTrafficList = new ArrayList<HighChartBean>();
    List<HighChartBean> transmitTrafficList = new ArrayList<HighChartBean>();

    if (trafficMonitorEntityList.size() == 0) {
      return false;
    }

    for (TrafficMonitorEntity trafficMonitorEntity : trafficMonitorEntityList) {
      receiveTrafficList.add(new HighChartBean(trafficMonitorEntity.getUpdateTime().getTime(),
          String.valueOf(trafficMonitorEntity.getReceiveTraffic() / Constant.UNITS)));
      transmitTrafficList.add(new HighChartBean(trafficMonitorEntity.getUpdateTime().getTime(),
          String.valueOf(trafficMonitorEntity.getTransmitTraffic() / Constant.UNITS)));
    }

    setReceiveTraffic(packData(receiveTrafficList));
    setTransmitTraffic(packData(transmitTrafficList));
    return true;
  }

  public boolean getNetstatMonitorData() {
    List<NetstatMonitorEntity> netstatMonitorEntityList = dbAbstract
        .select_netstat_monitor(ip, begin, end, port);
    List<HighChartBean> totalList = new ArrayList<HighChartBean>();
    List<HighChartBean> establishedList = new ArrayList<HighChartBean>();
    List<HighChartBean> timeWaitList = new ArrayList<HighChartBean>();
    List<HighChartBean> finWait2List = new ArrayList<HighChartBean>();

    if (netstatMonitorEntityList.size() == 0) {
      return false;
    }

    for (NetstatMonitorEntity netstatMonitorEntity : netstatMonitorEntityList) {
      totalList.add(new HighChartBean(netstatMonitorEntity.getUpdateTime().getTime(),
          String.valueOf(netstatMonitorEntity.getTotal())));
      establishedList.add(new HighChartBean(netstatMonitorEntity.getUpdateTime().getTime(),
          String.valueOf(netstatMonitorEntity.getEstablished())));
      timeWaitList.add(new HighChartBean(netstatMonitorEntity.getUpdateTime().getTime(),
          String.valueOf(netstatMonitorEntity.getTimeWait())));
      finWait2List.add(new HighChartBean(netstatMonitorEntity.getUpdateTime().getTime(),
          String.valueOf(netstatMonitorEntity.getFinWait2())));
    }

    setTotal(packData(totalList));
    setEstablished(packData(establishedList));
    setTimeWait(packData(timeWaitList));
    setFinWait2(packData(finWait2List));
    return true;
  }

  public boolean getComputeNodeStatus() {

    List<ComputeNodeStatusEntity> computeNodeStatusEntityList = dbAbstract
        .select_compute_node_status(ip, begin, end);
    List<HighChartBean> oneMinsProcsList = new ArrayList<HighChartBean>();
    List<HighChartBean> fiveMinsProcsList = new ArrayList<HighChartBean>();
    List<HighChartBean> fifteenMinsProcsList = new ArrayList<HighChartBean>();
    List<HighChartBean> totalTimeList = new ArrayList<HighChartBean>();
    List<HighChartBean> userTimeList = new ArrayList<HighChartBean>();
    List<HighChartBean> niceTimeList = new ArrayList<HighChartBean>();
    List<HighChartBean> systemTimeList = new ArrayList<HighChartBean>();
    List<HighChartBean> iowaitTimeList = new ArrayList<HighChartBean>();
    List<HighChartBean> idleTimeList = new ArrayList<HighChartBean>();
    List<HighChartBean> totalMemoryList = new ArrayList<HighChartBean>();
    List<HighChartBean> usedMemoryList = new ArrayList<HighChartBean>();
    List<HighChartBean> idleMemoryList = new ArrayList<HighChartBean>();
    List<HighChartBean> swapSizeList = new ArrayList<HighChartBean>();
    List<HighChartBean> usedSwapList = new ArrayList<HighChartBean>();
    List<HighChartBean> idleSwapList = new ArrayList<HighChartBean>();

    for (ComputeNodeStatusEntity computeNodeStatusEntity : computeNodeStatusEntityList) {

      oneMinsProcsList.add(new HighChartBean(computeNodeStatusEntity.getUpdateTime().getTime(),
          String.valueOf(computeNodeStatusEntity.getOneMinsProcs())));
      fiveMinsProcsList.add(new HighChartBean(computeNodeStatusEntity.getUpdateTime().getTime(),
          String.valueOf(computeNodeStatusEntity.getFiveMinsProcs())));
      fifteenMinsProcsList.add(new HighChartBean(computeNodeStatusEntity.getUpdateTime().getTime(),
          String.valueOf(computeNodeStatusEntity.getFifteenMinsProcs())));

      totalTimeList.add(new HighChartBean(computeNodeStatusEntity.getUpdateTime().getTime(),
          String.valueOf(computeNodeStatusEntity.getTotalTime())));
      userTimeList.add(new HighChartBean(computeNodeStatusEntity.getUpdateTime().getTime(),
          String.valueOf(computeNodeStatusEntity.getUserTime())));
      niceTimeList.add(new HighChartBean(computeNodeStatusEntity.getUpdateTime().getTime(),
          String.valueOf(computeNodeStatusEntity.getNiceTime())));
      systemTimeList.add(new HighChartBean(computeNodeStatusEntity.getUpdateTime().getTime(),
          String.valueOf(computeNodeStatusEntity.getSystemTime())));
      iowaitTimeList.add(new HighChartBean(computeNodeStatusEntity.getUpdateTime().getTime(),
          String.valueOf(computeNodeStatusEntity.getIowaitTime())));
      idleTimeList.add(new HighChartBean(computeNodeStatusEntity.getUpdateTime().getTime(),
          String.valueOf(computeNodeStatusEntity.getIdleTime())));

      totalMemoryList.add(new HighChartBean(computeNodeStatusEntity.getUpdateTime().getTime(),
          String.valueOf(computeNodeStatusEntity.getTotalMemory())));
      usedMemoryList.add(new HighChartBean(computeNodeStatusEntity.getUpdateTime().getTime(),
          String.valueOf(computeNodeStatusEntity.getUsedMemory())));
      idleMemoryList.add(new HighChartBean(computeNodeStatusEntity.getUpdateTime().getTime(),
          String.valueOf(computeNodeStatusEntity.getIdleMemory())));
      swapSizeList.add(new HighChartBean(computeNodeStatusEntity.getUpdateTime().getTime(),
          String.valueOf(computeNodeStatusEntity.getSwapSize())));
      usedSwapList.add(new HighChartBean(computeNodeStatusEntity.getUpdateTime().getTime(),
          String.valueOf(computeNodeStatusEntity.getUsedSwap())));
      idleSwapList.add(new HighChartBean(computeNodeStatusEntity.getUpdateTime().getTime(),
          String.valueOf(computeNodeStatusEntity.getIdleSwap())));
    }
    setOneMinsProcs(packData(oneMinsProcsList));
    setFiveMinsProcs(packData(fiveMinsProcsList));
    setFifteenMinsProcs(packData(fifteenMinsProcsList));
    setTotalTime(packData(totalTimeList));
    setUserTime(packData(userTimeList));
    setNiceTime(packData(niceTimeList));
    setSystemTime(packData(systemTimeList));
    setIowaitTime(packData(iowaitTimeList));
    setIdleTime(packData(idleTimeList));
    setTotalMemory(packData(totalMemoryList));
    setUsedMemory(packData(usedMemoryList));
    setIdleMemory(packData(idleMemoryList));
    setSwapSize(packData(swapSizeList));
    setUsedSwap(packData(usedSwapList));
    setIdleSwap(packData(idleSwapList));
    return true;
  }

  private String packData(List<HighChartBean> highChartBeans) {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (HighChartBean highChartBean : highChartBeans) {
      sb.append("[").append(highChartBean.getUpdateTime()).append(",")
          .append(highChartBean.getValue()).append("]").append(",");
    }
    sb = canTheLsatChar(sb);
    sb.append("]");
    return sb.toString();
  }

  private StringBuilder canTheLsatChar(StringBuilder sb) {
    StringBuilder result = new StringBuilder();
    String str = sb.toString();
    str = str.substring(0, str.length() - 1);
    result.append(str);
    return result;
  }

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public String getBegin() {
    return begin;
  }

  public void setBegin(String begin) {
    this.begin = begin;
  }

  public String getEnd() {
    return end;
  }

  public void setEnd(String end) {
    this.end = end;
  }

  public String getDiskname() {
    return diskname;
  }

  public void setDiskname(String diskname) {
    this.diskname = diskname;
  }

  public String getAwait() {
    return await;
  }

  public void setAwait(String await) {
    this.await = await;
  }

  public String getSvctm() {
    return svctm;
  }

  public void setSvctm(String svctm) {
    this.svctm = svctm;
  }

  public String getUtil() {
    return util;
  }

  public void setUtil(String util) {
    this.util = util;
  }

  public String getProcessId() {
    return processId;
  }

  public void setProcessId(String processId) {
    this.processId = processId;
  }

  public String getCpuUsage() {
    return cpuUsage;
  }

  public void setCpuUsage(String cpuUsage) {
    this.cpuUsage = cpuUsage;
  }

  public String getMemUsage() {
    return memUsage;
  }

  public void setMemUsage(String memUsage) {
    this.memUsage = memUsage;
  }

  public String getOneMinsProcs() {
    return oneMinsProcs;
  }

  public void setOneMinsProcs(String oneMinsProcs) {
    this.oneMinsProcs = oneMinsProcs;
  }

  public String getFiveMinsProcs() {
    return fiveMinsProcs;
  }

  public void setFiveMinsProcs(String fiveMinsProcs) {
    this.fiveMinsProcs = fiveMinsProcs;
  }

  public String getFifteenMinsProcs() {
    return fifteenMinsProcs;
  }

  public void setFifteenMinsProcs(String fifteenMinsProcs) {
    this.fifteenMinsProcs = fifteenMinsProcs;
  }

  public String getProcessName() {
    return processName;
  }

  public void setProcessName(String processName) {
    this.processName = processName;
  }

  public String getReceiveTraffic() {
    return receiveTraffic;
  }

  public void setReceiveTraffic(String receiveTraffic) {
    this.receiveTraffic = receiveTraffic;
  }

  public String getTransmitTraffic() {
    return transmitTraffic;
  }

  public void setTransmitTraffic(String transmitTraffic) {
    this.transmitTraffic = transmitTraffic;
  }

  public String getPort() {
    return port;
  }

  public void setPort(String port) {
    this.port = port;
  }

  public String getTotal() {
    return total;
  }

  public void setTotal(String total) {
    this.total = total;
  }

  public String getEstablished() {
    return established;
  }

  public void setEstablished(String established) {
    this.established = established;
  }

  public String getTimeWait() {
    return timeWait;
  }

  public void setTimeWait(String timeWait) {
    this.timeWait = timeWait;
  }

  public String getFinWait2() {
    return finWait2;
  }

  public void setFinWait2(String finWait2) {
    this.finWait2 = finWait2;
  }

  public String getTotalTime() {
    return totalTime;
  }

  public void setTotalTime(String totalTime) {
    this.totalTime = totalTime;
  }

  public String getUserTime() {
    return userTime;
  }

  public void setUserTime(String userTime) {
    this.userTime = userTime;
  }

  public String getNiceTime() {
    return niceTime;
  }

  public void setNiceTime(String niceTime) {
    this.niceTime = niceTime;
  }

  public String getSystemTime() {
    return systemTime;
  }

  public void setSystemTime(String systemTime) {
    this.systemTime = systemTime;
  }

  public String getIowaitTime() {
    return iowaitTime;
  }

  public void setIowaitTime(String iowaitTime) {
    this.iowaitTime = iowaitTime;
  }

  public String getIdleTime() {
    return idleTime;
  }

  public void setIdleTime(String idleTime) {
    this.idleTime = idleTime;
  }

  public String getTotalMemory() {
    return totalMemory;
  }

  public void setTotalMemory(String totalMemory) {
    this.totalMemory = totalMemory;
  }

  public String getUsedMemory() {
    return usedMemory;
  }

  public void setUsedMemory(String usedMemory) {
    this.usedMemory = usedMemory;
  }

  public String getIdleMemory() {
    return idleMemory;
  }

  public void setIdleMemory(String idleMemory) {
    this.idleMemory = idleMemory;
  }

  public String getSwapSize() {
    return swapSize;
  }

  public void setSwapSize(String swapSize) {
    this.swapSize = swapSize;
  }

  public String getUsedSwap() {
    return usedSwap;
  }

  public void setUsedSwap(String usedSwap) {
    this.usedSwap = usedSwap;
  }

  public String getIdleSwap() {
    return idleSwap;
  }

  public void setIdleSwap(String idleSwap) {
    this.idleSwap = idleSwap;
  }
}