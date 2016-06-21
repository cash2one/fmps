CREATE TABLE `weixin_scheme_address` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `schemename` varchar(30) DEFAULT NULL COMMENT '方案名称',
  `period` varchar(30) DEFAULT NULL COMMENT '保险期限',
  `premiumsf` varchar(60) DEFAULT NULL COMMENT '方案一保险费',
  `premiumss` varchar(60) DEFAULT NULL COMMENT '方案二保险费',
  `premiumst` varchar(60) DEFAULT NULL COMMENT '方案三保险费',
  `province` varchar(50) DEFAULT NULL COMMENT '省份',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;