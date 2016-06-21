CREATE TABLE `weixin_customer` (
	`id` VARCHAR(32) NOT NULL COMMENT '主键',
	`name` VARCHAR(20) NOT NULL COMMENT '姓名',
	`identifytype` VARCHAR(10) NOT NULL COMMENT '证件类型',
	`identifynumber` VARCHAR(60) NOT NULL COMMENT '证件号码',
	`gender` VARCHAR(5) NOT NULL COMMENT '性别',
	`birthday` DATETIME NOT NULL COMMENT '出生日期',
	`phone` VARCHAR(20) NOT NULL COMMENT '手机',
	`address` VARCHAR(120) NOT NULL COMMENT '联系地址',
	`email` VARCHAR(100) NOT NULL COMMENT '邮件',
	PRIMARY KEY (`id`)
)
COMMENT='客户表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;
