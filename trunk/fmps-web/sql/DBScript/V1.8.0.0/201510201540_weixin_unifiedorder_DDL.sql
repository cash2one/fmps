ALTER TABLE `weixin_unifiedorder`
	ADD COLUMN `userPayCode` VARCHAR(32) NULL DEFAULT NULL COMMENT '用户订单号' AFTER `product_id`;