CREATE TABLE `weixin_gascard_help_record` (
	`id` VARCHAR(32) NOT NULL COMMENT '主键',
	`sponsor` VARCHAR(100) NULL DEFAULT NULL COMMENT '发起人',
	`openid` VARCHAR(100) NULL DEFAULT NULL COMMENT '帮助者openid',
	`createdate` DATETIME NULL DEFAULT NULL COMMENT '帮抢日期',
	`huodongid` VARCHAR(100) NULL DEFAULT NULL COMMENT '活动编号',
	PRIMARY KEY (`id`),
	UNIQUE INDEX `IDX_WEIXIN_GASCARD_RECORD_SPONSOR_OPENID_HUODONGID` (`sponsor`, `openid`, `huodongid`)
)
COMMENT='加油卡领取记录'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;
