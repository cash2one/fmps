ALTER TABLE `weixin_plan`
	CHANGE COLUMN `premium` `premium` DECIMAL(10,2) NOT NULL COMMENT '保费' AFTER `periodtype`;