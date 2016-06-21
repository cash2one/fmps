ALTER TABLE `weixin_giftset_detail`
	CHANGE COLUMN `policyno` `policyno` VARCHAR(32) NULL COMMENT '保单号' AFTER `giftsetid`;