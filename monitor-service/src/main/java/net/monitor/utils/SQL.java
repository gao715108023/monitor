package net.monitor.utils;

public class SQL {

    public static String insert_traffic = "insert into traffic(updatetime, receivetraffic, receivepackets, receiveerrs, transmittraffic, transmitpackets, transmiterrs) values(?,?,?,?,?,?,?)";

    public static String insert_trafficinfo = "insert into trafficinfo(updatetime, cpuusage, memusage) values(?,?,?)";

    public static String insert_ubamsgserver = "insert into ubamsgserver(updatetime, cpuusage, memusage) values(?,?,?)";

    public static String insert_request_proxy_info = "insert into request_proxy_info(updatetime, cpuusage, memusage) values(?,?,?)";

}
