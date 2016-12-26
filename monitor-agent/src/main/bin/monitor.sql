-- ----------------------------
--  Table structure for `process_monitor`
-- ----------------------------
DROP TABLE
IF EXISTS `process_monitor`;

CREATE TABLE `process_monitor` (
  `id`                   BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `ip`                   VARCHAR(128) NOT NULL
  COMMENT '服务器ip地址',
  `process_name`         VARCHAR(128) NOT NULL
  COMMENT '进程名',
  `pid`                  INT          NOT NULL
  COMMENT '进程id',
  `one_mins_procs`       FLOAT        NOT NULL DEFAULT 0
  COMMENT '1分钟进程数',
  `five_mins_procs`      FLOAT        NOT NULL DEFAULT 0
  COMMENT '5分钟进程数',
  `fifteen_mins_procs`   FLOAT        NOT NULL DEFAULT 0
  COMMENT '15分钟进程数',
  `process_cpu_usage`    FLOAT        NOT NULL DEFAULT 0
  COMMENT '进程cpu使用率',
  `process_memory_usage` FLOAT        NOT NULL DEFAULT 0
  COMMENT '进程memory使用率',
  `gmt_create`           DATETIME              DEFAULT NULL
  COMMENT '创建时间',
  PRIMARY KEY (`id`)
)
  ENGINE = INNODB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = COMPACT;

-- ----------------------------
--  Table structure for `io_monitor`
-- ----------------------------

DROP TABLE
IF EXISTS `io_monitor`;

CREATE TABLE `io_monitor` (
  `id`         BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `ip`         VARCHAR(128) NOT NULL
  COMMENT '服务器ip地址',
  `disk_name`  VARCHAR(128) NOT NULL
  COMMENT '磁盘名称',
  `await`      FLOAT        NOT NULL DEFAULT 0
  COMMENT '平均每次I/O花费的毫秒数',
  `svctm`      FLOAT        NOT NULL DEFAULT 0
  COMMENT '平均每次输入/输出操作花费的毫秒数',
  `util`       FLOAT        NOT NULL DEFAULT 0
  COMMENT '磁盘利用率(%)',
  `gmt_create` DATETIME              DEFAULT NULL
  COMMENT '创建时间',
  PRIMARY KEY (`id`)
)
  ENGINE = INNODB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = COMPACT;

-- ----------------------------
--  Table structure for `netstat_monitor`
-- ----------------------------

DROP TABLE
IF EXISTS `netstat_monitor`;

CREATE TABLE `netstat_monitor` (
  `id`          BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `ip`          VARCHAR(128) NOT NULL
  COMMENT '服务器ip地址',
  `port`        INT          NOT NULL DEFAULT 0
  COMMENT '被监控的端口号',
  `total`       INT          NOT NULL DEFAULT 0
  COMMENT '总连接数',
  `established` INT          NOT NULL DEFAULT 0
  COMMENT '状态为ESTABLISHED的连接数',
  `time_wait`   INT          NOT NULL DEFAULT 0
  COMMENT '状态为TIME_WAIT的连接数',
  `fin_wait2`   INT          NOT NULL DEFAULT 0
  COMMENT '状态为FIN_WAIT2的连接数',
  `gmt_create`  DATETIME              DEFAULT NULL
  COMMENT '创建时间',
  PRIMARY KEY (`id`)
)
  ENGINE = INNODB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = COMPACT;

-- ----------------------------
--  Table structure for `traffic_monitor`
-- ----------------------------
DROP TABLE
IF EXISTS `traffic_monitor`;

CREATE TABLE `traffic_monitor` (
  `id`                BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `ip`                VARCHAR(128) NOT NULL
  COMMENT '服务器ip地址',
  `network_card_name` VARCHAR(128) NOT NULL
  COMMENT '被监控的网卡名称',
  `receive_traffic`   FLOAT        NOT NULL DEFAULT 0
  COMMENT '流入带宽/秒',
  `receive_packets`   FLOAT        NOT NULL DEFAULT 0
  COMMENT '流入正确的包量/秒',
  `receive_errs`      FLOAT        NOT NULL DEFAULT 0
  COMMENT '流入错误的包量/秒',
  `transmit_traffic`  FLOAT        NOT NULL DEFAULT 0
  COMMENT '流出带宽/秒',
  `transmit_packets`  FLOAT        NOT NULL DEFAULT 0
  COMMENT '流出正确的包量/秒',
  `transmit_errs`     FLOAT        NOT NULL DEFAULT 0
  COMMENT '流出错误的包量/秒',
  `gmt_create`        DATETIME              DEFAULT NULL
  COMMENT '创建时间',
  PRIMARY KEY (`id`)
)
  ENGINE = INNODB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = COMPACT;