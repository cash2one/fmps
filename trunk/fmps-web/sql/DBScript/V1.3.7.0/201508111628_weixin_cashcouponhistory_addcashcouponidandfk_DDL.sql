ALTER TABLE `weixin_cashcouponhistory`
	ADD COLUMN `cashcouponid` VARCHAR(64) NULL DEFAULT NULL COMMENT '红包编号' AFTER `fromtag`,
	ADD CONSTRAINT `FK_WEIXIN_CASHCOUPONHISTORY_CASHCOUPONID` FOREIGN KEY (`cashcouponid`) REFERENCES `weixin_cashcoupon` (`id`);
