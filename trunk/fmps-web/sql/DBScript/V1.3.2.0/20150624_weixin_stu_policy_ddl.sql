
 drop table weixin_stu_policy;
CREATE TABLE `weixin_stu_policy` (
  `id` varchar(32) NOT NULL COMMENT '����',
  `name` varchar(50) NOT NULL COMMENT 'ѧ������',
  `identifytype` varchar(10) NOT NULL COMMENT '֤������',
  `identifynumber` varchar(60) NOT NULL COMMENT '֤������',
  `phone` varchar(11) NOT NULL COMMENT '�ֻ�',
  `province` varchar(20) DEFAULT NULL COMMENT 'ʡ��',
  `city` varchar(30) DEFAULT NULL COMMENT '����',
  `area` varchar(50) DEFAULT NULL COMMENT '��',
  `policyno` varchar(50) DEFAULT NULL COMMENT '������',
  `detail` varchar(120) DEFAULT NULL COMMENT '��ϸ��ַ',
  `school` varchar(120) DEFAULT NULL COMMENT 'ѧУ',
  `createtime` datetime NOT NULL COMMENT '����ʱ��',
  `schemetype` varchar(20) DEFAULT NULL COMMENT '��������',
  `period` varchar(30) NOT NULL COMMENT '��������',
  `premium` varchar(32) DEFAULT NULL COMMENT '����',
  `openid` varchar(100) DEFAULT NULL COMMENT 'openid',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='(ѧ��) (΢�ű�����)';
