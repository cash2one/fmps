ALTER TABLE `weixin_cashcouponhistory`
	ADD INDEX `INX_WEIXIN_CASHCOUPONHISTORY_TOTAL_AMOUNT_RLTIME` (`total_amount`, `rltime`);
