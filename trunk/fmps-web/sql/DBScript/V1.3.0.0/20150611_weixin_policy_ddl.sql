CREATE TABLE `weixin_policy` (
	`id` VARCHAR(32) NOT NULL COMMENT '主键',
	`policyno` VARCHAR(20) NOT NULL COMMENT '保单号',
	`planid` VARCHAR(32) NOT NULL COMMENT '产品ID',
	`type` VARCHAR(5) NOT NULL COMMENT '类型（1、投保单   2保单）',
	`createtime` DATETIME NOT NULL COMMENT '创建时间',
	`startdate` DATETIME NOT NULL COMMENT '保单起始日期',
	`enddate` DATETIME NOT NULL COMMENT '保单终止日期',
	`applicant` VARCHAR(32) NOT NULL COMMENT '投保人',
	`insuredidentity` VARCHAR(20) NULL DEFAULT NULL COMMENT '投被保人关系（1、本人2、父母  3、子女 等 ）',
	`isbeneficiary` VARCHAR(5) NOT NULL COMMENT '是否法定受益人',
	`addressId` VARCHAR(32) NULL DEFAULT NULL COMMENT '保单标的地址',
	`openid` VARCHAR(100) NULL DEFAULT NULL COMMENT 'openid',
	PRIMARY KEY (`id`)
)
COMMENT=' 微信保单表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;
