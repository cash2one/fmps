ALTER TABLE `weixin_cashcoupon`
	ADD COLUMN `ip` VARCHAR(15) NULL DEFAULT NULL COMMENT '服务器端ip' AFTER `receivetime`;
