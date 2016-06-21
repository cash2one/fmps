ALTER TABLE `weixin_gasolinegift_report`
	ADD COLUMN `getWay` VARCHAR(10) NULL DEFAULT NULL COMMENT '领取方式(0上门领取,1寄送)' AFTER `giftid`,
	ADD COLUMN `expressAddress` VARCHAR(200) NULL DEFAULT NULL COMMENT '快递寄送地址' AFTER `getWay`,
	ADD COLUMN `pickupAddress` VARCHAR(200) NULL DEFAULT NULL COMMENT '上门自取地址' AFTER `expressAddress`;