CREATE TABLE `weixin_cashcoupon_rule` (
	`id` VARCHAR(32) NOT NULL COMMENT '主键',
	`rulename` VARCHAR(32) NULL DEFAULT NULL COMMENT '规则名称',
	`huodongid` VARCHAR(100) NULL DEFAULT NULL COMMENT '活动编号',
	`proportion` VARCHAR(100) NULL DEFAULT NULL COMMENT '占比',
	`maxvalue` FLOAT NULL DEFAULT NULL COMMENT '最大值',
	`minvalue` FLOAT NULL DEFAULT NULL COMMENT '最小值',
	`rule_type` VARCHAR(20) NULL DEFAULT NULL COMMENT '固定类型(金额，数量等)',
	`num` INT(11) NULL DEFAULT NULL COMMENT '总数',
	PRIMARY KEY (`id`)
)
COMMENT='红包规则表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;
