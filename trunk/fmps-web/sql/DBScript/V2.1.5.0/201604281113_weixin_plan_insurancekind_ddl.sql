ALTER TABLE `weixin_plan_insurancekind`
	ADD COLUMN `affiliatedId` VARCHAR(32) NULL COMMENT '对应条款ID' AFTER `kindname`;