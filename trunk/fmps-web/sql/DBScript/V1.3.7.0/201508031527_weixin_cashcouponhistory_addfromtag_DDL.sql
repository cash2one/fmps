ALTER TABLE `weixin_cashcouponhistory`
	ADD COLUMN `fromtag` VARCHAR(12) NULL COMMENT '来源' AFTER `rltime`;
