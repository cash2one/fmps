ALTER TABLE `weixin_product`
	ADD COLUMN `occupationcategory` VARCHAR(20) NULL DEFAULT NULL COMMENT '职业类别' AFTER `imagehref`,
	ADD COLUMN `occupationcode` VARCHAR(20) NULL DEFAULT NULL COMMENT '职业代码' AFTER `occupationcategory`;
