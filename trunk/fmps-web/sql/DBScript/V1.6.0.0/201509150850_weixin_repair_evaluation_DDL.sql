DROP TABLE IF EXISTS `weixin_repair_evaluation`;
CREATE TABLE `weixin_repair_evaluation` (
  `ID` varchar(32) NOT NULL COMMENT '主键',
  `repairid` varchar(32) NOT NULL COMMENT '维修厂ID',
  `scanQrCodeTime` datetime DEFAULT NULL COMMENT '扫码时间',
  `qRcodeUUID` varchar(32) NOT NULL COMMENT '二维码UUID',
  `openid` varchar(100) DEFAULT NULL COMMENT '服务号用户微信号',
  `nickname` varchar(500) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '服务号用户昵称',
  `reportinfoid` varchar(32) DEFAULT NULL COMMENT '微信报案信息表id',
  `headimgurl` varchar(400) DEFAULT NULL COMMENT '服务号用户头像',
  `evaluation` int(1) DEFAULT NULL COMMENT '评价星级',
  `comment` varchar(500) DEFAULT NULL COMMENT '评价内容',
  `repairname` varchar(100) DEFAULT NULL COMMENT '维修厂名称',
  `createtime` datetime DEFAULT NULL COMMENT '评价时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='维修厂评价信息表';

 