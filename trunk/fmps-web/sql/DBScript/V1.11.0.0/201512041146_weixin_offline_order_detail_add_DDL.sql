ALTER TABLE `weixin_offline_order_detail`
	ADD COLUMN `itemname` VARCHAR(50) NULL COMMENT '�����Ŀ��Ϣ' AFTER `RiskKind`,
	ADD COLUMN `riskname` VARCHAR(50) NULL COMMENT '�����������' AFTER `itemname`,
	ADD COLUMN `subpremium` DOUBLE(20,2) NULL COMMENT '���ֱ���' AFTER `riskname`;