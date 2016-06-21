CREATE TABLE `weixin_salechannel_config` (
	`id` VARCHAR(50) NOT NULL,
	`salemode` VARCHAR(20) NOT NULL COMMENT '商品销售方式(微店:1,赴台:2)',
	`operateCode` VARCHAR(100) NULL DEFAULT NULL COMMENT '出单人员',
	`handler1code` VARCHAR(100) NULL DEFAULT NULL COMMENT '归属人员',
	`channeltype` VARCHAR(20) NOT NULL COMMENT '销售渠道',
	`businessnature` VARCHAR(20) NOT NULL COMMENT '业务来源',
	PRIMARY KEY (`id`)
)
COMMENT='销售渠道配置表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;
