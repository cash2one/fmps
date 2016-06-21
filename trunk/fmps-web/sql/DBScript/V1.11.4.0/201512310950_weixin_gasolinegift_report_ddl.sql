ALTER TABLE `weixin_gasolinegift_report`
	ADD COLUMN `mobile` VARCHAR(15) NULL DEFAULT NULL COMMENT '手机号' AFTER `customercname`;