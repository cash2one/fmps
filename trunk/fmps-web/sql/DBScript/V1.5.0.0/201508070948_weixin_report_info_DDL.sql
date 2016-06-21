ALTER TABLE `weixin_report_info`
	ADD COLUMN `confirmTime` DATETIME NULL DEFAULT NULL COMMENT '理赔金额确认时间' AFTER `repairState`,
	ADD COLUMN `confirmStyle` VARCHAR(3) NULL DEFAULT NULL COMMENT '理赔金额确认方式1、手动  0、系统自动' AFTER `confirmTime`;