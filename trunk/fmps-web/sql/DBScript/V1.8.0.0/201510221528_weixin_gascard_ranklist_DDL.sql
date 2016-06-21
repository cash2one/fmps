CREATE TABLE `weixin_gascard_ranklist` (
	`id` VARCHAR(64) NOT NULL COMMENT '主键',
	`nickname` VARCHAR(200) NULL DEFAULT NULL COMMENT '微信用户昵称',
	`openid` VARCHAR(100) NULL DEFAULT NULL COMMENT '微信用户openid',
	`cnt` VARCHAR(6) NULL DEFAULT NULL COMMENT '好友助力数',
	`rankno` INT(11) NULL DEFAULT NULL COMMENT '排名',
	`updatetime` DATETIME NULL DEFAULT NULL COMMENT '更新时间',
	PRIMARY KEY (`id`)
)
COMMENT='加油卡活动排行榜(排名前150名)'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;
