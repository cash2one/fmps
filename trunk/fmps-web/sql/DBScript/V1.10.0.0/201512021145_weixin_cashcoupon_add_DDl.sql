ALTER TABLE `weixin_cashcoupon`
	ALTER `amount` DROP DEFAULT;
ALTER TABLE `weixin_cashcoupon`
	CHANGE COLUMN `amount` `amount` DECIMAL(20,0) NOT NULL COMMENT '������' AFTER `id`,
	ADD COLUMN `openid` VARCHAR(64) NULL COMMENT '�û�openid' AFTER `seqid`,
	ADD COLUMN `externalno` VARCHAR(64) NULL COMMENT '�ⲿID' AFTER `openid`;
	