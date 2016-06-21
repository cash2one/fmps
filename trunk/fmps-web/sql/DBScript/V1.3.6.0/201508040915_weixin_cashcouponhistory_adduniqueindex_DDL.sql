ALTER TABLE `weixin_cashcouponhistory`
	ADD UNIQUE INDEX `INX_WEIXIN_CASHCOUPON_HUODONGID_RE_OPENID` (`huodongid`, `re_openid`);