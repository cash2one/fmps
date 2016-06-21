ALTER TABLE `weixin_giftset_detail`
	CHANGE COLUMN `etl_status` `etl_status` TINYINT(1) NULL DEFAULT NULL COMMENT 'ÅÜÅú×´Ì¬' AFTER `etl_inserttime`;
