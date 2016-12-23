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