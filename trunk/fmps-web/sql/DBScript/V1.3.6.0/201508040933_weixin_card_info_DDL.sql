ALTER TABLE `weixin_card_info`
	CHANGE COLUMN `status` `status` VARCHAR(5) NOT NULL COMMENT '当前状态(-1可激活;-2已激活)' AFTER `validate`;