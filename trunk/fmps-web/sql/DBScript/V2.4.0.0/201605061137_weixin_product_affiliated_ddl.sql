ALTER TABLE `weixin_product_affiliated`
	CHANGE COLUMN `sorting` `sorting` INT(2) NULL COMMENT '排序' AFTER `description`;