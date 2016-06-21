ALTER TABLE `weixin_giftset_detail`
	CHANGE COLUMN `etl_status` `etl_status` TINYINT(1) NULL COMMENT '跑批状态' AFTER `etl_inserttime`;
ALTER TABLE `weixin_giftset_detail`
	ADD COLUMN `huodongid` VARCHAR(32) NULL COMMENT '活动id' AFTER `batchid`;