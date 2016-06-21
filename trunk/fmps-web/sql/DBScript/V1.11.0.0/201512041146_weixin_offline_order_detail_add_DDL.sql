ALTER TABLE `weixin_offline_order_detail`
	ADD COLUMN `itemname` VARCHAR(50) NULL COMMENT '标的项目信息' AFTER `RiskKind`,
	ADD COLUMN `riskname` VARCHAR(50) NULL COMMENT '险种类别内容' AFTER `itemname`,
	ADD COLUMN `subpremium` DOUBLE(20,2) NULL COMMENT '险种保费' AFTER `riskname`;