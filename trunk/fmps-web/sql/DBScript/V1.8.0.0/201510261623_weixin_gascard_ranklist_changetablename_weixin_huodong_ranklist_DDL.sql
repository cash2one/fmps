drop table weixin_gascard_ranklist;
CREATE TABLE `weixin_huodong_ranklist` (
	`huodongid` VARCHAR(200) NULL DEFAULT NULL COMMENT '活动编号',
	`nickname` VARCHAR(200) NULL DEFAULT NULL COMMENT '微信用户昵称',
	`openid` VARCHAR(100) NULL DEFAULT NULL COMMENT '微信用户openid',
	`cnt` VARCHAR(6) NULL DEFAULT NULL COMMENT '好友助力数',
	`updatetime` DATETIME NULL DEFAULT NULL COMMENT '更新时间',
	INDEX `IDX_WEIXIN_RANKLIST_HUODONGID` (`huodongid`)
)
COMMENT='加油卡活动排行榜(排名前150名)'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;
