CREATE TABLE `weixin_cashcoupon` (
	`id` VARCHAR(64) NOT NULL COMMENT '主键',
	`amount` INT(11) NOT NULL COMMENT '红包金额',
	`huodongid` VARCHAR(100) NOT NULL COMMENT '活动编号',
	`seqid` INT(11) NOT NULL COMMENT '红包编号',
	PRIMARY KEY (`id`)
)
COMMENT='微信红包初始化表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;
