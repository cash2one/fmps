ALTER TABLE `weixin_product_affiliated`
	ADD COLUMN `sorting` INT(2) NOT NULL COMMENT '排序' AFTER `description`;