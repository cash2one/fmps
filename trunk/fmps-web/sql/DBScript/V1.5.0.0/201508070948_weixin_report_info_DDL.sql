ALTER TABLE `weixin_report_info`
	ADD COLUMN `confirmTime` DATETIME NULL DEFAULT NULL COMMENT '������ȷ��ʱ��' AFTER `repairState`,
	ADD COLUMN `confirmStyle` VARCHAR(3) NULL DEFAULT NULL COMMENT '������ȷ�Ϸ�ʽ1���ֶ�  0��ϵͳ�Զ�' AFTER `confirmTime`;