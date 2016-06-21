
 drop table weixin_stu_policy;
CREATE TABLE `weixin_stu_policy` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `name` varchar(50) NOT NULL COMMENT '学生姓名',
  `identifytype` varchar(10) NOT NULL COMMENT '证件类型',
  `identifynumber` varchar(60) NOT NULL COMMENT '证件号码',
  `phone` varchar(11) NOT NULL COMMENT '手机',
  `province` varchar(20) DEFAULT NULL COMMENT '省份',
  `city` varchar(30) DEFAULT NULL COMMENT '城市',
  `area` varchar(50) DEFAULT NULL COMMENT '区',
  `policyno` varchar(50) DEFAULT NULL COMMENT '保单号',
  `detail` varchar(120) DEFAULT NULL COMMENT '详细地址',
  `school` varchar(120) DEFAULT NULL COMMENT '学校',
  `createtime` datetime NOT NULL COMMENT '创建时间',
  `schemetype` varchar(20) DEFAULT NULL COMMENT '方案类型',
  `period` varchar(30) NOT NULL COMMENT '保险期限',
  `premium` varchar(32) DEFAULT NULL COMMENT '保费',
  `openid` varchar(100) DEFAULT NULL COMMENT 'openid',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='(学生) (微信保单表)';
