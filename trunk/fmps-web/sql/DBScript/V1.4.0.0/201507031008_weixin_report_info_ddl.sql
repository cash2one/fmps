ALTER TABLE `weixin_report_info`
	ADD COLUMN `repairState` TINYINT(3) NULL DEFAULT NULL COMMENT '0-δɨ��; 1-����ά�޳�ɨ�� ; 2-���������޸�' AFTER `createTime`;
