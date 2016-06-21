ALTER TABLE `weixin_offline_orderinfo`
	ADD COLUMN `paycode_md5` VARCHAR(64) NULL COMMENT 'MD5支付码' AFTER `PayCode`;
