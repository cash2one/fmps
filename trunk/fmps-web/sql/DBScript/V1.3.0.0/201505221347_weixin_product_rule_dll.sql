CREATE TABLE `weixin_product_rule` (
	`id` VARCHAR(32) NOT NULL COMMENT '主键',
	`productid` VARCHAR(32) NOT NULL COMMENT '产品ID',
	`maxage` INT(6) NOT NULL COMMENT '投保最大年龄',
	`minage` INT(6) NOT NULL COMMENT '投保最小年龄',
	`unit` INT(3) NOT NULL COMMENT '最大份数',
	`rulename` VARCHAR(100) NOT NULL COMMENT '规则名称',
	`ruletype` VARCHAR(20) NOT NULL COMMENT '规则类型',
	`ruleclass` VARCHAR(50) NOT NULL COMMENT '规则分类',
	PRIMARY KEY (`id`)
)
COMMENT='产品投保规则'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;
