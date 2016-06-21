ALTER TABLE `weixin_cashcoupon`
	ADD COLUMN `receivetime` DATETIME NULL DEFAULT NULL COMMENT '领取时间' AFTER `externalno`;
