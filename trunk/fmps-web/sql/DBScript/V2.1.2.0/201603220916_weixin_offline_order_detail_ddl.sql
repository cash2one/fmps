ALTER TABLE `weixin_offline_order_detail`
	CHANGE COLUMN `itemname` `itemname` VARCHAR(150) NULL DEFAULT NULL COMMENT '标的项目信息' AFTER `RiskKind`; 