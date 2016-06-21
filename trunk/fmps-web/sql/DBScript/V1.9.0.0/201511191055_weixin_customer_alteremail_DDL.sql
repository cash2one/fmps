ALTER TABLE `weixin_customer`
	ALTER `email` DROP DEFAULT;
ALTER TABLE `weixin_customer`
	CHANGE COLUMN `email` `email` VARCHAR(100) NULL COMMENT '邮件' AFTER `address`;
