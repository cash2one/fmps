CREATE TABLE `weixin_product_affiliated` (
	`id` VARCHAR(32) NOT NULL COMMENT '主键',
	`productid` VARCHAR(32) NOT NULL COMMENT '产品ID',
	`type` VARCHAR(3) NOT NULL COMMENT '文档类型',
	`document` MEDIUMBLOB NOT NULL COMMENT '文档内容',
	PRIMARY KEY (`id`)
)
COMMENT='产品附加信息表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;
