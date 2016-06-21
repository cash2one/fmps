ALTER TABLE `weixin_policy`
	CHANGE COLUMN `status` `status` VARCHAR(5) NULL DEFAULT NULL COMMENT '支付状态（未支付：0；支付成功：1，支付失败:2，取消支付:3）' AFTER `orderno`;
