CREATE TABLE IF NOT EXISTS `weixin_oilcard_organization` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `updateTime` datetime NOT NULL COMMENT '更新时间',
  `orgCode` varchar(20) NOT NULL COMMENT '机构编码',
  `orgName` varchar(120) DEFAULT NULL COMMENT '机构名称', 
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='加油宝申请机构对应代码';