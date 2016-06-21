ALTER TABLE `weixin_giftset_detail`
	ADD COLUMN `receivedate` DATETIME NULL COMMENT '领券时间' AFTER `openid`;