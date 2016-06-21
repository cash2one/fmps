ALTER TABLE `weixin_cashcouponhistory`
	CHANGE COLUMN `status` `status` VARCHAR(200) NULL DEFAULT NULL COMMENT '发放状态（成功：SUCCESS；失败:FAIL(失败原因)）' AFTER `client_ip`;
