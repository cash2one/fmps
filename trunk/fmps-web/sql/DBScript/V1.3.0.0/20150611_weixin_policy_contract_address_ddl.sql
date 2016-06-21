CREATE TABLE `weixin_policy_contract_address` (
	`id` VARCHAR(32) NOT NULL COMMENT '主键',
	`policyno` VARCHAR(20) NOT NULL COMMENT '保单号',
	`provincecode` VARCHAR(10) NOT NULL COMMENT '标的所在省',
	`citycode` VARCHAR(10) NOT NULL COMMENT '标的所在市',
	`countycode` VARCHAR(10) NOT NULL COMMENT '标的所在区县',
	`insuredaddress` VARCHAR(100) NOT NULL COMMENT '标的所在详细地址',
	PRIMARY KEY (`id`)
)
COMMENT='保单标的地址表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;
