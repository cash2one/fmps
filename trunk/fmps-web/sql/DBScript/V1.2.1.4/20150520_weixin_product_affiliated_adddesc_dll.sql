ALTER TABLE `weixin_product_affiliated`
	ADD COLUMN `description` VARCHAR(200) NOT NULL COMMENT '标题' AFTER `document`;
