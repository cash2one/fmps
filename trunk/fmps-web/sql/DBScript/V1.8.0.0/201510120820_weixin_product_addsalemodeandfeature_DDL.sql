ALTER TABLE `weixin_product`
	CHANGE COLUMN `riskshortname` `riskshortname` VARCHAR(30) NULL DEFAULT NULL COMMENT '产品简称' AFTER `productname`,
	ADD COLUMN `salemode` VARCHAR(20) NULL DEFAULT NULL COMMENT '销售方式' AFTER `occupationcode`,
	ADD COLUMN `feature` VARCHAR(200) NULL DEFAULT NULL COMMENT '商品特色' AFTER `salemode`;
