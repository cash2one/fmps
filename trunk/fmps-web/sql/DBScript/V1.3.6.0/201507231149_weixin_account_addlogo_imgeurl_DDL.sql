ALTER TABLE `weixin_account`
	ADD COLUMN `logo_imgurl` VARCHAR(200) NULL DEFAULT NULL COMMENT '商户logo的URL' AFTER `status`;
