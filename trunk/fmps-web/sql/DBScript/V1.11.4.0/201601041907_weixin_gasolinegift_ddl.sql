ALTER TABLE `weixin_gasolinegift`
	ADD COLUMN `receiveAddress` VARCHAR(200) NULL DEFAULT '' COMMENT '领取地址' AFTER `getstatus`;