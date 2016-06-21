ALTER TABLE `weixin_gasolinegift`
	ADD COLUMN `updateTime` DATETIME NULL DEFAULT NULL COMMENT '更新时间' AFTER `rchgDctExpire`,
	ADD COLUMN `payStatus` INT(2) NULL DEFAULT NULL COMMENT '支付情况：1、完成支付、 ' AFTER `updateTime`;