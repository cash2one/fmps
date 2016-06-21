ALTER TABLE `weixin_gasolinegift_report`
	ADD COLUMN `channel` INT(3) NULL COMMENT '渠道（1、富邦2、94频道）' AFTER `pickupAddress`,
	ADD COLUMN `receiveWay` INT(3) NULL COMMENT '领取方式（取领方式 邮寄10  渠道自取20）' AFTER `channel`,
	ADD COLUMN `applyStatus` INT(3) NULL COMMENT '申请状态05:待预充值支付 10:申请待处理（表示已支付）20:申请处理完成' AFTER `receiveWay`,
	ADD COLUMN `oilCardNo` VARCHAR(30) NULL COMMENT '油卡卡号' AFTER `applyStatus`,
	ADD COLUMN `rchgDct` INT(3) NULL COMMENT '充值返点例如3%' AFTER `oilCardNo`,
	ADD COLUMN `payStatus` INT(3) NULL COMMENT '支付情况：1、完成支付、' AFTER `rchgDct`,
	ADD COLUMN `rchgDctExpire` DATETIME NULL COMMENT '优惠有效期' AFTER `payStatus`;