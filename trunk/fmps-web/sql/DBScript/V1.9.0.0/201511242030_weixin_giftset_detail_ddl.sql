ALTER TABLE `weixin_giftset_detail`
	CHANGE COLUMN `policyno` `policyno` VARCHAR(50) NULL DEFAULT NULL COMMENT '保单号' AFTER `giftsetid`;