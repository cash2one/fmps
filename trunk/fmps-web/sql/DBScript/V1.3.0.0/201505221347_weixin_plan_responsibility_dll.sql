CREATE TABLE `weixin_plan_responsibility` (
	`id` VARCHAR(32) NOT NULL COMMENT '主键',
	`planid` VARCHAR(32) NOT NULL COMMENT '计划ID',
	`liabilitycode` VARCHAR(20) NOT NULL COMMENT '责任代码',
	`liability` VARCHAR(100) NOT NULL COMMENT '保险责任',
	`amount` VARCHAR(10) NOT NULL COMMENT '保额',
	PRIMARY KEY (`id`)
)
COMMENT='计划责任维护表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;
