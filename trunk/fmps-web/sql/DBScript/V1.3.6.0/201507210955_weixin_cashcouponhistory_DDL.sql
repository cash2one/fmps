CREATE TABLE `weixin_cashcouponhistory` (
	`id` VARCHAR(32) NOT NULL COMMENT '主键',
	`nonce_str` VARCHAR(32) NULL DEFAULT NULL COMMENT '随机字符串，不长于32位',
	`huodongid` VARCHAR(100) NULL DEFAULT NULL COMMENT '活动编号',
	`sign` VARCHAR(32) NULL DEFAULT NULL COMMENT '签名',
	`mch_billno` VARCHAR(28) NULL DEFAULT NULL COMMENT '商户订单号（每个订单号必须唯一）',
	`re_openid` VARCHAR(32) NULL DEFAULT NULL COMMENT '用户openid',
	`total_amount` INT(11) NULL DEFAULT NULL COMMENT '付款金额，单位分',
	`min_value` INT(11) NULL DEFAULT NULL COMMENT '最小红包金额，单位分',
	`max_value` INT(11) NULL DEFAULT NULL COMMENT '最大红包金额，单位分',
	`total_num` INT(11) NULL DEFAULT NULL COMMENT '红包发放总人数',
	`client_ip` VARCHAR(15) NULL DEFAULT NULL COMMENT 'Ip地址',
	`status` VARCHAR(10) NULL DEFAULT NULL COMMENT '发放状态（1，成功；2，失败）',
	`rltime` DATETIME NULL DEFAULT NULL COMMENT '发放时间',
	PRIMARY KEY (`id`)
)
COMMENT='微信红包领取记录表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;
