# monitor
监控服务器（Linux）的资源，包括：CPU、内存、磁盘IO、网络带宽、端口的连接数、进程的CPU使用率、进程内存占用

# 项目分为三个模块

* monitor-agent：资源采集agent
* monitor-dao：数据库DAO层操作
* monitor-web：监控页面展示


# 使用方法

## 一、安装MySQL

### 1.1 创建数据库monitor

### 1.2 创建表

	DROP TABLE IF EXISTS `process_monitor`;
	CREATE TABLE `process_monitor` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`localIp` VARCHAR(128) NOT NULL COMMENT '服务器ip地址',
	`process_name` VARCHAR(128) NOT NULL COMMENT '进程名',
	`pid` INT NOT NULL COMMENT '进程id',
	`one_mins_procs` FLOAT NOT NULL DEFAULT 0 COMMENT '1分钟进程数',
	`five_mins_procs` FLOAT NOT NULL DEFAULT 0 COMMENT '5分钟进程数',
	`fifteen_mins_procs` FLOAT NOT NULL DEFAULT 0 COMMENT '15分钟进程数',
	`process_cpu_usage` FLOAT NOT NULL DEFAULT 0 COMMENT '进程cpu使用率',
	`process_memory_usage` FLOAT NOT NULL DEFAULT 0 COMMENT '进程memory使用率',
	`gmt_create` DATETIME DEFAULT NULL COMMENT '创建时间',
	PRIMARY KEY (`id`)
	) ENGINE = INNODB AUTO_INCREMENT = 1 CHARSET = utf8mb4 ROW_FORMAT = COMPACT;
	
	DROP TABLE IF EXISTS `io_monitor`;
	CREATE TABLE `io_monitor` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`localIp` VARCHAR(128) NOT NULL COMMENT '服务器ip地址',
	`disk_name` VARCHAR(128) NOT NULL COMMENT '磁盘名称',
	`await` FLOAT NOT NULL DEFAULT 0 COMMENT '平均每次I/O花费的毫秒数',
	`svctm` FLOAT NOT NULL DEFAULT 0 COMMENT '平均每次输入/输出操作花费的毫秒数',
	`util` FLOAT NOT NULL DEFAULT 0 COMMENT '磁盘利用率(%)',
	`gmt_create` DATETIME DEFAULT NULL COMMENT '创建时间',
	PRIMARY KEY (`id`)
	) ENGINE = INNODB AUTO_INCREMENT = 1 CHARSET = utf8mb4 ROW_FORMAT = COMPACT;
	
	DROP TABLE IF EXISTS `netstat_monitor`;
	CREATE TABLE `netstat_monitor` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`localIp` VARCHAR(128) NOT NULL COMMENT '服务器ip地址',
	`port` INT NOT NULL DEFAULT 0 COMMENT '被监控的端口号',
	`total` INT NOT NULL DEFAULT 0 COMMENT '总连接数',
	`established` INT NOT NULL DEFAULT 0 COMMENT '状态为ESTABLISHED的连接数',
	`time_wait` INT NOT NULL DEFAULT 0 COMMENT '状态为TIME_WAIT的连接数',
	`fin_wait2` INT NOT NULL DEFAULT 0 COMMENT '状态为FIN_WAIT2的连接数',
	`gmt_create` DATETIME DEFAULT NULL COMMENT '创建时间',
	PRIMARY KEY (`id`)
	) ENGINE = INNODB AUTO_INCREMENT = 1 CHARSET = utf8mb4 ROW_FORMAT = COMPACT;
	
	DROP TABLE IF EXISTS `traffic_monitor`;
	CREATE TABLE `traffic_monitor` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`localIp` VARCHAR(128) NOT NULL COMMENT '服务器ip地址',
	`network_card_name` VARCHAR(128) NOT NULL COMMENT '被监控的网卡名称',
	`receive_traffic` FLOAT NOT NULL DEFAULT 0 COMMENT '流入带宽/秒',
	`receive_packets` FLOAT NOT NULL DEFAULT 0 COMMENT '流入正确的包量/秒',
	`receive_errs` FLOAT NOT NULL DEFAULT 0 COMMENT '流入错误的包量/秒',
	`transmit_traffic` FLOAT NOT NULL DEFAULT 0 COMMENT '流出带宽/秒',
	`transmit_packets` FLOAT NOT NULL DEFAULT 0 COMMENT '流出正确的包量/秒',
	`transmit_errs` FLOAT NOT NULL DEFAULT 0 COMMENT '流出错误的包量/秒',
	`gmt_create` DATETIME DEFAULT NULL COMMENT '创建时间',
	PRIMARY KEY (`id`)
	) ENGINE = INNODB AUTO_INCREMENT = 1 CHARSET = utf8mb4 ROW_FORMAT = COMPACT;

## 二、clone代码至本地

### 2.1 执行`mvn clean install -DskipTests`

### 2.2 将monitor-agent.zip拷贝至待监控的服务器，并解压缩unzip monitor-agent.zip

## 三、修复conf下的配置信息

### 3.1 修改infoconfig.properties

	sampling.time=5000  #采样时间，设置每隔多长时间监控程序采集一次系统信息，单位为毫秒，默认为5000毫秒
	listening.port=80  #该属性只有在监控某端口号的连接数的时候才会起作用，值为需要监控的端口号
	network.card.name=eth1  网卡名，当需要监控网络带宽的时候，请设置该选项，默认为eth0
	watch.process=tomcat:/opt/tomcat/tomcat.pid  #被监控的进程名和该进程的pid文件路径（绝对路径），多个进程用英文,分割

### 3.2 修改MyBatis-Configuration.xml

修改MySQL的连接地址

	<dataSource type="POOLED">
                <property name="driver" value="com.mysql.jdbc.Driver"/>
                <property name="url"
                          value="jdbc:mysql://localhost:3306/monitor?useUnicode=true&amp;characterEncoding=UTF-8&amp;zeroDateTimeBehavior=convertToNull"/>
                <property name="username" value="root"/>
                <property name="password" value="123456"/>
            </dataSource>

## 四、启动agent采集节点

执行`sh service.sh start`

## 五、关闭agent采集节点

执行`sh service.sh stop`

## 六、重启agent采集节点

执行`sh service.sh restart`

## 七、部署监控页，图形化展示监控结果（如果不需要可不部署，通过查询MySQL数据库可获取监控结果）

### 7.1 配置filters下面的配置文件，修改数据库连接地址

### 7.2 将monitor-web.war拷贝至tomcat下，启动tomcat，打开http://localhost:8080/index.html




