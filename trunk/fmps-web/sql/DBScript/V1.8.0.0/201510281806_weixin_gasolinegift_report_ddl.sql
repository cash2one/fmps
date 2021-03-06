CREATE TABLE `weixin_gasolinegift_report` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`openid` VARCHAR(100) NULL DEFAULT NULL COMMENT 'openid',
	`identifynumber` VARCHAR(20) NULL DEFAULT NULL COMMENT '身份证号',
	`customercname` VARCHAR(120) NULL DEFAULT NULL COMMENT '客户名称',
	`licenseno` VARCHAR(20) NULL DEFAULT NULL COMMENT '车牌号',
	`comcname` VARCHAR(80) NULL DEFAULT NULL COMMENT '机构名称',
	`handlercode` VARCHAR(18) NULL DEFAULT NULL COMMENT '业务员工号',
	`handlername` VARCHAR(300) NULL DEFAULT NULL COMMENT '业务员姓名',
	`applyTime` TIMESTAMP NULL DEFAULT NULL COMMENT '使用日期',
	`giftid` VARCHAR(100) NULL DEFAULT NULL COMMENT '加油宝券id',
	PRIMARY KEY (`id`)
)
COMMENT='加油宝报表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;