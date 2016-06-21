DROP TABLE IF EXISTS `weixin_giftset_detail`;
CREATE TABLE `weixin_giftset_detail` (
  `id` varchar(32) NOT NULL COMMENT '券ID(主键)',
  `giftsetname` varchar(200) NOT NULL COMMENT '礼包名称',
  `giftsetid` varchar(32) NOT NULL COMMENT '券类型',
  `policyno` varchar(32) NOT NULL COMMENT '保单号',
  `name` varchar(50) NOT NULL COMMENT '券名称',
  `repairlogo` varchar(200) DEFAULT NULL COMMENT '车行logo',
  `deepcolor` varchar(10) NOT NULL COMMENT '深色',
  `lightcolor` varchar(10) NOT NULL COMMENT '浅色',
  `providerepairname` varchar(200) DEFAULT NULL,
  `startdate` datetime NOT NULL COMMENT '起始日期',
  `enddate` datetime NOT NULL COMMENT '终止日期',
  `etl_inserttime` datetime NOT NULL COMMENT '跑批时间',
  `etl_status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '跑批状态',
  `batchid` int(28) NOT NULL COMMENT '批次号',
  `usedopenid` varchar(100) DEFAULT NULL COMMENT '跑批状态',
  `scandate` datetime DEFAULT NULL COMMENT '扫码日期',
  `scanrepairid` varchar(32) DEFAULT NULL COMMENT '扫码维修厂ID',
  `scanrepairname` varchar(50) DEFAULT NULL COMMENT '维修厂名称',
  `applicantname` varchar(15) DEFAULT NULL COMMENT '投保人姓名',
  `appIdentifynumber` varchar(32) DEFAULT NULL COMMENT '投保人证件号',
  `insuredname` varchar(15) DEFAULT NULL COMMENT '被保人姓名',
  `insIdentifynumber` varchar(32) DEFAULT NULL COMMENT '被保人证件号',
  `areaname` varchar(100) NOT NULL COMMENT '地区名称',
  `cardtype` int(2) NOT NULL COMMENT '券类型1：现金券; 2：抵用券;',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='微信抵用券明细表';

