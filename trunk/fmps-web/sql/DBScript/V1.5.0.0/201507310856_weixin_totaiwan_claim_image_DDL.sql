CREATE TABLE `weixin_totaiwan_claim_image` (
	`id` VARCHAR(32) NOT NULL COMMENT '主键',
	`customername` VARCHAR(30) NOT NULL COMMENT '客户姓名',
	`phonenum` INT NOT NULL COMMENT '电话号码',
	`openid` VARCHAR(64) NOT NULL COMMENT '微信用户openid',
	`localpath` VARCHAR(100) NOT NULL COMMENT '本地上传路径',
	`mediaid` VARCHAR(64) NOT NULL COMMENT '微信服务器上多媒体文件的mediaid',
	`uploadtime` TIMESTAMP NOT NULL COMMENT '图片上传时间',
	PRIMARY KEY (`id`)
)
COMMENT='微信理赔资料信息表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;
