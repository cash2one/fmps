ALTER TABLE `weixin_giftset_detail`
	CHANGE COLUMN `etl_inserttime` `etl_inserttime` DATETIME NULL COMMENT '跑批时间' AFTER `enddate`,
	CHANGE COLUMN `etl_status` `etl_status` TINYINT(1) NULL DEFAULT '0' COMMENT '跑批状态' AFTER `etl_inserttime`,
	CHANGE COLUMN `batchid` `batchid` INT(28) NULL COMMENT '批次号' AFTER `etl_status`;