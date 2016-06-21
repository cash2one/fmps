ALTER TABLE `weixin_menuentity`
	ADD COLUMN `status` VARCHAR(3) NULL DEFAULT NULL COMMENT '状态（1、有效 2、暂停）' AFTER `accountid`;