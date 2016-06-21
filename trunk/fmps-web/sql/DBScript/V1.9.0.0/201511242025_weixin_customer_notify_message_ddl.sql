ALTER TABLE `weixin_customer_notify_message`
	CHANGE COLUMN `policyno` `policyno` VARCHAR(50) NULL DEFAULT NULL COMMENT '保单号' AFTER `licenseno`;