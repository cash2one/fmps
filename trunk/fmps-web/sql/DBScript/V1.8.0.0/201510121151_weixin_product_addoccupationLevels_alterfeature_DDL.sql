ALTER TABLE `weixin_product`
	CHANGE COLUMN `feature` `feature` VARCHAR(22) NULL DEFAULT NULL COMMENT '商品特色' AFTER `salemode`,
	ADD COLUMN `occupationLevels` VARCHAR(20) NULL DEFAULT NULL COMMENT '适用职业范围' AFTER `feature`;
