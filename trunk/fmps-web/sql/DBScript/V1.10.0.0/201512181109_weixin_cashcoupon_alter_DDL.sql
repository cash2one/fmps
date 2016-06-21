ALTER TABLE `weixin_cashcoupon`
	CHANGE COLUMN `externalno` `externalSerialNo` VARCHAR(64) NULL DEFAULT NULL COMMENT 'Íâ²¿ID' AFTER `openid`;