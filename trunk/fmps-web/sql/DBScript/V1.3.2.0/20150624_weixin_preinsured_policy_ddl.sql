
 drop table weixin_preinsured_policy;
CREATE TABLE `weixin_preinsured_policy` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `createtime` datetime NOT NULL COMMENT '创建时间',
  `block` varchar(20) DEFAULT NULL COMMENT '所在地区',
  `name` varchar(30) NOT NULL COMMENT '姓名',
  `telephone` varchar(32) DEFAULT NULL COMMENT '手机',
  `openid` varchar(100) NOT NULL COMMENT 'openid',

  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='(投保预约表)';


