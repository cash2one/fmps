ALTER TABLE `weixin_report_info`
	ADD COLUMN `repairState` TINYINT(3) NULL DEFAULT NULL COMMENT '0-未扫码; 1-兜底维修厂扫码 ; 2-其他修理厂修改' AFTER `createTime`;
