CREATE TABLE `weixin_policy_insured_identity` (
	`id` VARCHAR(32) NOT NULL COMMENT '主键',
	`policyno` VARCHAR(20) NOT NULL COMMENT '保单号',
	`identity` VARCHAR(3) NOT NULL COMMENT '身份 (1、被保人。2、 受益人 )',
	`customerid` VARCHAR(32) NOT NULL COMMENT '客户ID',
	PRIMARY KEY (`id`)
)
COMMENT='被保险人信息表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;
