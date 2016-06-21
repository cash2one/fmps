CREATE TABLE `weixin_gasolinegift` (
	`id` VARCHAR(100) NOT NULL COMMENT '主键',
	`openid` VARCHAR(100) NOT NULL COMMENT 'openid',
	`applyTime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '申请时间',
	`giftid` VARCHAR(100) NOT NULL COMMENT '加油宝券id',
	PRIMARY KEY (`id`)
)
COMMENT='加油宝'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;
