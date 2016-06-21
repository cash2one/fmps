ALTER TABLE `weixin_huodong_record`
	ADD COLUMN `starttime` DATETIME NULL DEFAULT NULL COMMENT '起始时间' AFTER `phonenum`,
	ADD COLUMN `endtime` DATETIME NULL DEFAULT NULL COMMENT '结束时间' AFTER `starttime`,
	ADD COLUMN `cashcouponid` VARCHAR(64) NULL DEFAULT NULL COMMENT '初始化表ID' AFTER `endtime`,
	ADD COLUMN `amount` DECIMAL(20.2) NULL DEFAULT NULL COMMENT '金额' AFTER `cashcouponid`,
	ADD COLUMN `status` INT(2) NULL DEFAULT NULL COMMENT '领取状态 0 失败，1 成功' AFTER `amount`;
