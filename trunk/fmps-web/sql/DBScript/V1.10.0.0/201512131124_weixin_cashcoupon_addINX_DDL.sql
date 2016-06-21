ALTER TABLE `weixin_cashcoupon`
	ADD UNIQUE INDEX `INX_WEIXIN_CASHCOUPON_HUODONGID_OPENID` (`huodongid`, `openid`);
