ALTER TABLE `weixin_product`
	CHANGE COLUMN `salemode` `salemode` VARCHAR(20) NULL DEFAULT NULL COMMENT '销售方式 微店_1,微信_2,赠险_3' AFTER `occupationcode`;
	