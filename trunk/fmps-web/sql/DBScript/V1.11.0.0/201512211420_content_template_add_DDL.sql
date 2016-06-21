CREATE TABLE `content_template` (
	`id` VARCHAR(32) NOT NULL,
	`templatemsg` VARCHAR(6000) NULL DEFAULT NULL COMMENT '模板消息内容',
	`type` VARCHAR(20) NULL DEFAULT NULL COMMENT '类型(1、邮件模板)',
	`status` VARCHAR(3) NULL DEFAULT NULL COMMENT '状态(1、启用；0、未启用)',
	`title` VARCHAR(50) NULL DEFAULT NULL COMMENT '标题',
	`createtime` DATETIME NULL DEFAULT NULL COMMENT '创建时间',
	PRIMARY KEY (`id`)
)
COMMENT='消息模板表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;
