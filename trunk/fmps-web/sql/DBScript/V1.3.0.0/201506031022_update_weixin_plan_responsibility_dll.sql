ALTER TABLE `weixin_plan_responsibility`
	ADD COLUMN `unit` VARCHAR(20) NOT NULL COMMENT '单位' AFTER `amount`;
