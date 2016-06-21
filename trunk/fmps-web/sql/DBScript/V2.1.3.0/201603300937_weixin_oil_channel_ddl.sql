CREATE TABLE IF NOT EXISTS `weixin_oil_channel` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `insertTime` timestamp NULL DEFAULT NULL COMMENT '新增时间',
  `channel` int(3) NOT NULL COMMENT '1、94频道 ',
  `userid` varchar(32) NOT NULL COMMENT '操作人员ID',
  `mobile` varchar(15) DEFAULT NULL COMMENT '手机号',
  `licenseno` varchar(20) DEFAULT NULL COMMENT '车牌号',
  `username` varchar(100) DEFAULT NULL COMMENT '用户姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='加油宝用户来源表';