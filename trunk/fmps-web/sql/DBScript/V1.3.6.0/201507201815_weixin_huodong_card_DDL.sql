ALTER TABLE `weixin_huodong_card`
	ADD COLUMN `validtime` TIMESTAMP NULL DEFAULT NULL COMMENT '有效期' AFTER `receivetime`;
