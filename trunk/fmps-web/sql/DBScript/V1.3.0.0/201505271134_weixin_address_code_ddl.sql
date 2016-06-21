CREATE TABLE `weixin_address_code` (
	`id` VARCHAR(32) NOT NULL COMMENT '主键',
	`province` VARCHAR(10) NOT NULL COMMENT '省',
	`provincecode` VARCHAR(10) NOT NULL COMMENT '省份代码',
	`city` VARCHAR(10) NOT NULL COMMENT '市',
	`citycode` VARCHAR(10) NOT NULL COMMENT '市代码',
	`county` VARCHAR(50) NOT NULL COMMENT '区县',
	`countycode` VARCHAR(10) NOT NULL COMMENT '区县代码',
	PRIMARY KEY (`id`)
)
COMMENT='地址选择表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;
