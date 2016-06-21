ALTER TABLE `weixin_offline_orderinfo`
	ALTER `PayCode` DROP DEFAULT;
ALTER TABLE `weixin_offline_orderinfo`
	CHANGE COLUMN `PayCode` `PayCode` VARCHAR(64) NOT NULL COMMENT '支付码' AFTER `ID`,
	CHANGE COLUMN `TransactionId` `TransactionId` VARCHAR(32) NULL DEFAULT NULL COMMENT '订单号' AFTER `PayStatus`;
