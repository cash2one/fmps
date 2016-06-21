CREATE TABLE `weixin_product` (
	`id` VARCHAR(32) NOT NULL COMMENT '主键ID',
	`productname` VARCHAR(30) NOT NULL COMMENT '产品名称',
	`internalcode` VARCHAR(20) NOT NULL COMMENT '产品代码',
	`type` INT(6) NOT NULL COMMENT '类型',
	`iscard` VARCHAR(2) NOT NULL COMMENT '是否卡单',
	`createtime` DATETIME NOT NULL COMMENT '创建时间',
	`state` VARCHAR(5) NOT NULL COMMENT '状态',
	`imagename` VARCHAR(255) NULL DEFAULT NULL COMMENT '图片名称',
	`imagehref` VARCHAR(255) NULL DEFAULT NULL COMMENT '图片链接',
	PRIMARY KEY (`id`)
)
COMMENT='微信产品表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;
