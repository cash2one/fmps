CREATE TABLE `weixin_card_info` (
	`id` VARCHAR(32) NOT NULL COMMENT '主键',
	`card_no` VARCHAR(50) NOT NULL COMMENT '卡号',
	`imputdate` DATETIME NOT NULL COMMENT '插入日期',
	`result_status` VARCHAR(5) NOT NULL COMMENT '1、卡号或密码有误：00：卡号或密码错误2、卡状态：01：可激活02：已激活03：不可用',
	`card_version_code` VARCHAR(50) NOT NULL COMMENT '保险卡卡版本代码',
	`validate` VARCHAR(5) NOT NULL COMMENT '有效性',
	`state` VARCHAR(5) NOT NULL COMMENT '当前状态',
	`not_pass_reason` VARCHAR(150) NOT NULL COMMENT '卡号的归属机构',
	`startdate` DATETIME NOT NULL COMMENT '保单起始日期',
	`enddate` DATETIME NOT NULL COMMENT '保单终止日期',
	`openid` VARCHAR(100) NOT NULL COMMENT 'openid',
	`comcode` VARCHAR(20) NOT NULL,
	`comname` VARCHAR(50) NOT NULL,
	`comaddress` VARCHAR(100) NOT NULL,
	PRIMARY KEY (`id`)
)
COMMENT='卡单投保表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;
