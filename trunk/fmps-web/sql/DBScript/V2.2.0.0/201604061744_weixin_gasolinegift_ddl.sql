ALTER TABLE `weixin_gasolinegift`
	ADD COLUMN `channel` INT(5) NULL COMMENT '渠道（1、富邦2、94频道）' AFTER `username`,
	ADD COLUMN `receiveWay` INT(5) NULL COMMENT '领取方式（取领方式 邮寄10  渠道自取20）' AFTER `channel`,
	ADD COLUMN `orgCode` VARCHAR(15) NULL COMMENT '子机构编码' AFTER `receiveWay`,
	ADD COLUMN `applyId` VARCHAR(100) NULL COMMENT '申请流水号' AFTER `orgCode`,
	ADD COLUMN `respCode` VARCHAR(15) NULL COMMENT '响应码' AFTER `applyId`,
	ADD COLUMN `respMsg` VARCHAR(100) NULL COMMENT '应答信息' AFTER `respCode`,
	ADD COLUMN `applyStatus` INT(5) NULL COMMENT '申请状态05:待预充值支付 10:申请待处理（表示已支付）20:申请处理完成' AFTER `respMsg`,
	ADD COLUMN `oilCardNo` VARCHAR(30) NULL COMMENT '油卡卡号' AFTER `applyStatus`,
	ADD COLUMN `rchgDct` INT(3) NULL COMMENT '充值返点例如3%' AFTER `oilCardNo`,
	ADD COLUMN `rchgDctExpire` DATETIME NULL COMMENT '优惠有效期' AFTER `rchgDct`;