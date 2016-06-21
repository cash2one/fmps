ALTER TABLE `weixin_huodong`
	ADD COLUMN `wishing` VARCHAR(500) NULL DEFAULT NULL COMMENT '祝福语' AFTER `totalamount`;
