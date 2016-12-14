<%--
  Created by IntelliJ IDEA.
  User: gaochuanjun
  Date: 14-5-19
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>资源监控系统使用帮助</title>
    <link rel="stylesheet" href="css/fontstyle.css" />
</head>
<body background="images/skulls.png">
<div class="help">
    <h1 align="center" class="title">监控程序使用教程</h1>
    &nbsp;&nbsp;&nbsp;&nbsp;监控程序分为采集部分和展示部分，主页上下载的resource_monitor-1.0.tar.gz属于采集部分， <br /><br />
    &nbsp;&nbsp;&nbsp;&nbsp;<a href="http://10.15.144.162:8080/monitorweb/" target="_blank">http://10.15.144.162:8080/monitorweb/<font
        face="Courier New"></font></a>
    则为​展示部分，其原理就是采集部分将采集的信息存储至MySQL数据库中，然后展示部分从MySQL中查询数据进行展示。​（后续将会支持其它库的存储）。<br /><br />
    &nbsp;&nbsp;&nbsp;&nbsp;官方提供了一个默认的MySQL地址：10.15.63.128&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;user:&nbsp;gcj&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;pwd:&nbsp;123456<br /><br />
    &nbsp;&nbsp;&nbsp;&nbsp;10.15.144.162上的​展示部分​默认是从该库中查询数据的，若需要换数据库，需要修改展示部分的MySQL地址。<br /><br />
    &nbsp;&nbsp;&nbsp;&nbsp;下面是采集部分的使用步骤，使用过程比较简单，只要按步骤修改部分配置文件便可使用。若使用官方默认的数据库地址，数据库部分可直接忽略。<br /><br />
    &nbsp;&nbsp;&nbsp;&nbsp;1、安装部署MySQL<br /><br />
    &nbsp;&nbsp;&nbsp;&nbsp;2、创建库名process<br />
    &nbsp;&nbsp;&nbsp;&nbsp;create database process;<br />
    &nbsp;&nbsp;&nbsp;&nbsp;use process;<br /><br />
    &nbsp;&nbsp;&nbsp;&nbsp;3、创建表server_monitor、iostat_monitor、traffic_monitor和netstat_monitor<br />
    &nbsp;&nbsp;&nbsp;&nbsp;SET FOREIGN_KEY_CHECKS=0;<br />
    &nbsp;&nbsp;&nbsp;&nbsp;DROP TABLE IF EXISTS `iostat_monitor`;<br />
    &nbsp;&nbsp;&nbsp;&nbsp;CREATE TABLE `iostat_monitor` (<br />
    &nbsp;&nbsp;&nbsp;&nbsp;`IP` varchar(16) NOT NULL,<br />
    &nbsp;&nbsp;&nbsp;&nbsp;`UpdateTime` datetime NOT NULL,<br />
    &nbsp;&nbsp;&nbsp;&nbsp;`name` varchar(255) NOT NULL,<br />
    &nbsp;&nbsp;&nbsp;&nbsp;`await` float(10,2) DEFAULT NULL,<br />
    &nbsp;&nbsp;&nbsp;&nbsp;`svctm` float(10,2) DEFAULT NULL,<br />
    &nbsp;&nbsp;&nbsp;&nbsp;`util` float(10,2) DEFAULT NULL,<br />
    &nbsp;&nbsp;&nbsp;&nbsp;PRIMARY KEY (`UpdateTime`,`IP`,`name`)<br />
    &nbsp;&nbsp;&nbsp;&nbsp; ENGINE=MyISAM DEFAULT CHARSET=gbk;<br /><br />
    &nbsp;&nbsp;&nbsp;&nbsp;SET FOREIGN_KEY_CHECKS=0;<br />
    &nbsp;&nbsp;&nbsp;&nbsp;DROP TABLE IF EXISTS `server_monitor`;<br />
    &nbsp;&nbsp;&nbsp;&nbsp;CREATE TABLE `server_monitor` (<br />
    &nbsp;&nbsp;&nbsp;&nbsp;`IP` varchar(16) NOT NULL,<br />
    &nbsp;&nbsp;&nbsp;&nbsp;`ProcessId` int(32) NOT NULL,<br />
    &nbsp;&nbsp;&nbsp;&nbsp;`UpdateTime` datetime NOT NULL,<br />
    &nbsp;&nbsp;&nbsp;&nbsp;`ProcessName` varchar(32) DEFAULT NULL,<br />
    &nbsp;&nbsp;&nbsp;&nbsp;`OneMinsProcs` float(6,2) DEFAULT NULL,<br />
    &nbsp;&nbsp;&nbsp;&nbsp;`FiveMinsProcs` float(6,2) DEFAULT NULL,<br />
    &nbsp;&nbsp;&nbsp;&nbsp;`FifteenMinsProcs` float(6,2) DEFAULT NULL,<br />
    &nbsp;&nbsp;&nbsp;&nbsp;`CPUUsage` float(6,2) DEFAULT NULL,<br />
    &nbsp;&nbsp;&nbsp;&nbsp;`IowaitTime` float(6,2) DEFAULT NULL,<br />
    &nbsp;&nbsp;&nbsp;&nbsp;`UsedMemory` mediumint(9) DEFAULT NULL,<br />
    &nbsp;&nbsp;&nbsp;&nbsp;PRIMARY KEY (`IP`,`ProcessId`,`UpdateTime`)<br />
    &nbsp;&nbsp;&nbsp;&nbsp;) ENGINE=MyISAM DEFAULT CHARSET=gbk;<br /><br />
    &nbsp;&nbsp;&nbsp;&nbsp;DROP TABLE IF EXISTS `traffic_monitor`;<br /><br />
    &nbsp;&nbsp;&nbsp;&nbsp;CREATE TABLE `traffic_monitor` (<br /><br />
    &nbsp;&nbsp;&nbsp;&nbsp;`IP` varchar(16) NOT NULL,<br /><br />
    &nbsp;&nbsp;&nbsp;&nbsp;`UpdateTime` datetime NOT NULL,<br /><br />
    &nbsp;&nbsp;&nbsp;&nbsp;`ReceiveTraffic` float DEFAULT NULL,<br /><br />
    &nbsp;&nbsp;&nbsp;&nbsp;`ReceivePackets` float DEFAULT NULL,<br /><br />
    &nbsp;&nbsp;&nbsp;&nbsp;`ReceiveErrs` float DEFAULT NULL,<br /><br />
    &nbsp;&nbsp;&nbsp;&nbsp;`TransmitTraffic` float DEFAULT NULL,<br /><br />
    &nbsp;&nbsp;&nbsp;&nbsp;`TransmitPackets` float DEFAULT NULL,<br /><br />
    &nbsp;&nbsp;&nbsp;&nbsp;`TransmitErrs` float DEFAULT NULL,<br /><br />
    &nbsp;&nbsp;&nbsp;&nbsp;PRIMARY KEY (`IP`,`UpdateTime`)<br /><br />
    &nbsp;&nbsp;&nbsp;&nbsp;) ENGINE=InnoDB DEFAULT CHARSET=utf8;<br /><br />
    &nbsp;&nbsp;&nbsp;&nbsp;DROP TABLE IF EXISTS `netstat_monitor`;<br /><br />
    &nbsp;&nbsp;&nbsp;&nbsp;CREATE TABLE `netstat_monitor` (<br /><br />
    &nbsp;&nbsp;&nbsp;&nbsp;`IP` varchar(255) NOT NULL,<br /><br />
    &nbsp;&nbsp;&nbsp;&nbsp;`port` int(11) NOT NULL,<br /><br />
    &nbsp;&nbsp;&nbsp;&nbsp;`UpdateTime` datetime NOT NULL,<br /><br />
    &nbsp;&nbsp;&nbsp;&nbsp;`Total` int(11) DEFAULT NULL,<br /><br />
    &nbsp;&nbsp;&nbsp;&nbsp;`Established` int(11) DEFAULT NULL,<br /><br />
    &nbsp;&nbsp;&nbsp;&nbsp;`TimeWait` int(11) DEFAULT NULL,<br /><br />
    &nbsp;&nbsp;&nbsp;&nbsp;`FinWait2` int(11) DEFAULT NULL,<br /><br />
    &nbsp;&nbsp;&nbsp;&nbsp;PRIMARY KEY (`IP`,`UpdateTime`,`port`)<br /><br />
    &nbsp;&nbsp;&nbsp;&nbsp;) ENGINE=InnoDB DEFAULT CHARSET=utf8;<br /><br />
    &nbsp;&nbsp;&nbsp;&nbsp;4、下载压缩包，将压缩包拷贝至待监控的服务器的任意目录下，例如：拷贝至/opt目录下<br /><br />
    &nbsp;&nbsp;&nbsp;&nbsp;5、解压缩, tar zxvf resource_monitor-1.0.tar.gz<br /><br />
    &nbsp;&nbsp;&nbsp;&nbsp;6、修改conf目录下的配置文件infoconfig.properties<br /><br />

    &nbsp;&nbsp;&nbsp;&nbsp;#进程名，注意，这里的Java进程名请填写java，不要填写任何jar包名或者项目名，否则程序无法正常获取进程的CPU和内存<br />
    &nbsp;&nbsp;&nbsp;&nbsp;<font color="red">process_name = test</font><br />
    &nbsp;&nbsp;&nbsp;&nbsp;#采样时间，设置每隔多长时间监控程序采集一次系统信息，单位为毫秒，默认为5000毫秒<br />
    &nbsp;&nbsp;&nbsp;&nbsp;<font color="red">sampling_time = 5000</font><br />
    &nbsp;&nbsp;&nbsp;&nbsp;#该属性只有在监控某端口号的连接数的时候才会起作用，值为需要监控的端口号<br />
    &nbsp;&nbsp;&nbsp;&nbsp;<font color="red">listening_port = 80</font><br />
    &nbsp;&nbsp;&nbsp;&nbsp;#网卡名，当需要监控网络带宽的时候，请设置该选项，默认为eth0<br />
    &nbsp;&nbsp;&nbsp;&nbsp;<font color="red">network_card_name = eth0</font><br /><br />
    &nbsp;&nbsp;&nbsp;&nbsp;7、修改配置文件MyBatis-Configuration.xml，修改MySQL的IP地址和账号密码，以及库名；<br />
    &nbsp;&nbsp;&nbsp;&nbsp;name="driver" value="com.mysql.jdbc.Driver" /><br />
    &nbsp;&nbsp;&nbsp;&nbsp;name="url" value="jdbc:mysql://<font color="red">mysql-ip</font>:<font
        color="red">mysql-port</font>/process?useUnicode=true&amp;characterEncoding=UTF-8&amp;zeroDateTimeBehavior=convertToNull"<br />
    &nbsp;&nbsp;&nbsp;&nbsp;name="username" value="<font color="red">mysql-user</font>"<br />
    &nbsp;&nbsp;&nbsp;&nbsp;name="password" value="<font color="red">mysql-pwd</font>"<br /><br />
    &nbsp;&nbsp;&nbsp;&nbsp;8、在bin目录下，修改getpid.sh<br />
    &nbsp;&nbsp;&nbsp;&nbsp;#!/bin/sh<br />
    &nbsp;&nbsp;&nbsp;&nbsp;ps -ef | grep -v grep | grep <font color="red">process</font> | awk '{print $2}'<br />
    &nbsp;&nbsp;&nbsp;&nbsp;将process替换为待监控的进程名称<br /><br />

    &nbsp;&nbsp;&nbsp;&nbsp;9、执行startup.sh启动监控，注意：startup.sh附带4个参数，不加参数默认只监控进程的CPU和Memory，4个参数如下：<br /><br />

    &nbsp;&nbsp;&nbsp;&nbsp;Options:-c cpu&memory Monitor the information of CPU & Memory.<br /><br />
    &nbsp;&nbsp;&nbsp;&nbsp;-t traffic Monitor the informatin of traffic. For example, eth0.<br /><br />
    &nbsp;&nbsp;&nbsp;&nbsp;-n netstat Monitor the number of connections of port.<br /><br />
    &nbsp;&nbsp;&nbsp;&nbsp;-i iostat Monitor the information of I/O.<br /><br />
    &nbsp;&nbsp;&nbsp;&nbsp;--help/-h Print this help.<br /><br />
    &nbsp;&nbsp;&nbsp;&nbsp;example: ./startup.sh -c -t -n -i<br /><br />


    &nbsp;&nbsp;&nbsp;&nbsp;10、执行shutdown.sh关闭监控。<br /><br />

    &nbsp;&nbsp;&nbsp;&nbsp;<font color="blue">最后附上本人的博客地址：</font><a href="http://www.loveyqq.tk/"
                                                                     target="_blank">http://www.loveyqq.tk/</a><br /><br />
    &nbsp;&nbsp;&nbsp;&nbsp;Posted by GaoChuanjun May 19th, 2014 <a href="http://www.gw.com.cn/" target="_blank">Great
    Wisdom</a>
</div>
</body>
</html>
