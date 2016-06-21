drop table if exists weixin_plan_insurancekind;
CREATE TABLE `weixin_plan_insurancekind` (
	`id` VARCHAR(32) NOT NULL COMMENT '主键',
	`planid` VARCHAR(32) NOT NULL COMMENT '保险产品计划id',
	`kindcode` VARCHAR(10) NOT NULL COMMENT '险种代码',
	`kindname` VARCHAR(200) NOT NULL COMMENT '险种名称',
	PRIMARY KEY (`id`)
)
COMMENT='保险产品险种表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;
