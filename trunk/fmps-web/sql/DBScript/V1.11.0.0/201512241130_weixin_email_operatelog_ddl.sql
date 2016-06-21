CREATE TABLE `weixin_email_operatelog` (
	`id` VARCHAR(50) NOT NULL,
	`broswer` VARCHAR(50) NULL DEFAULT NULL COMMENT '用户浏览器',
	`operateType` VARCHAR(50) NULL DEFAULT NULL COMMENT '操作动作',
	`logContent` VARCHAR(500) NULL DEFAULT NULL COMMENT '日志内容',
	`importBatchId` VARCHAR(50) NULL DEFAULT NULL COMMENT '导入批次号',
	`huodongid` VARCHAR(32) NULL DEFAULT NULL COMMENT '活动id',
	`operater` VARCHAR(100) NULL DEFAULT NULL COMMENT '操作人',
	`ipAddr` VARCHAR(50) NULL DEFAULT NULL COMMENT 'ip地址',
	`operateTime` DATETIME NULL DEFAULT NULL COMMENT '操作时间',
	PRIMARY KEY (`id`)
)
COMMENT='邮箱操作日志表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;