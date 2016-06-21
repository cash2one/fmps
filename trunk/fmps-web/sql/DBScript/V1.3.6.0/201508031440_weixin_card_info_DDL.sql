ALTER TABLE `weixin_card_info`
	CHANGE COLUMN `state` `status` VARCHAR(5) NOT NULL COMMENT 'µ±Ç°×´Ì¬' AFTER `validate`;