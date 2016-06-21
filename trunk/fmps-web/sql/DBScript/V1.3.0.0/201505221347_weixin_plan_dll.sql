CREATE TABLE `weixin_plan` (
	`id` VARCHAR(32) NOT NULL COMMENT '主键',
	`serialno` INT(6) NOT NULL COMMENT '计划序号',
	`planname` VARCHAR(20) NOT NULL COMMENT '计划名称',
	`productid` VARCHAR(32) NOT NULL COMMENT '产品ID',
	`codeproductcode` VARCHAR(20) NOT NULL COMMENT '核心产品代码',
	`period` INT(6) NOT NULL COMMENT '保险期限',
	`periodtype` VARCHAR(5) NOT NULL COMMENT '保险期限类型(年、月、日)',
	`premium` INT(6) NOT NULL COMMENT '保费',
	`createtime` DATETIME NOT NULL COMMENT '创建时间',
	`state` VARCHAR(5) NOT NULL COMMENT '状态',
	PRIMARY KEY (`id`)
)
COMMENT='产品计划表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;
