ALTER TABLE `weixin_product_rule`
	ADD COLUMN `rulename` VARCHAR(100) NOT NULL COMMENT '规则名称' AFTER `unit`,
	ADD COLUMN `ruletype` VARCHAR(20) NOT NULL COMMENT '规则类型' AFTER `rulename`,
	ADD COLUMN `ruleclass` VARCHAR(50) NOT NULL COMMENT '规则分类' AFTER `ruletype`;
