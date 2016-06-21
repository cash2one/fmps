ALTER TABLE `weixin_huodong_record`
	ADD COLUMN `ip` VARCHAR(50) NULL DEFAULT NULL COMMENT 'ip地址' AFTER `status`;