DROP TABLE IF EXISTS `weixin_repair_evaluation`;
CREATE TABLE `weixin_repair_evaluation` (
  `ID` varchar(32) NOT NULL COMMENT '����',
  `repairid` varchar(32) NOT NULL COMMENT 'ά�޳�ID',
  `scanQrCodeTime` datetime DEFAULT NULL COMMENT 'ɨ��ʱ��',
  `qRcodeUUID` varchar(32) NOT NULL COMMENT '��ά��UUID',
  `openid` varchar(100) DEFAULT NULL COMMENT '������û�΢�ź�',
  `nickname` varchar(500) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '������û��ǳ�',
  `reportinfoid` varchar(32) DEFAULT NULL COMMENT '΢�ű�����Ϣ��id',
  `headimgurl` varchar(400) DEFAULT NULL COMMENT '������û�ͷ��',
  `evaluation` int(1) DEFAULT NULL COMMENT '�����Ǽ�',
  `comment` varchar(500) DEFAULT NULL COMMENT '��������',
  `repairname` varchar(100) DEFAULT NULL COMMENT 'ά�޳�����',
  `createtime` datetime DEFAULT NULL COMMENT '����ʱ��',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ά�޳�������Ϣ��';

 