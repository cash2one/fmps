ALTER TABLE `weixin_cashcoupon`
	ALTER `amount` DROP DEFAULT;
ALTER TABLE `weixin_cashcoupon`
	CHANGE COLUMN `amount` `amount` DECIMAL(20,0) NOT NULL COMMENT '红包金额' AFTER `id`,
	ADD COLUMN `openid` VARCHAR(64) NULL COMMENT '用户openid' AFTER `seqid`,
	ADD COLUMN `externalno` VARCHAR(64) NULL COMMENT '外部ID' AFTER `openid`;
	