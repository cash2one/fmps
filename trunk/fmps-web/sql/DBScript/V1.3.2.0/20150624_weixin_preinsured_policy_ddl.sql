
 drop table weixin_preinsured_policy;
CREATE TABLE `weixin_preinsured_policy` (
  `id` varchar(32) NOT NULL COMMENT '����',
  `createtime` datetime NOT NULL COMMENT '����ʱ��',
  `block` varchar(20) DEFAULT NULL COMMENT '���ڵ���',
  `name` varchar(30) NOT NULL COMMENT '����',
  `telephone` varchar(32) DEFAULT NULL COMMENT '�ֻ�',
  `openid` varchar(100) NOT NULL COMMENT 'openid',

  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='(Ͷ��ԤԼ��)';


