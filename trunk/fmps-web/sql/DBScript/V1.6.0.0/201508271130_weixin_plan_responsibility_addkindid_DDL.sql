ALTER TABLE `weixin_plan_responsibility`
	ADD COLUMN `kindid` VARCHAR(32) NOT NULL COMMENT '保险产品险种ID' AFTER `planid`;
