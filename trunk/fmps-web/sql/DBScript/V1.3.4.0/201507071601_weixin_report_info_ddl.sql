ALTER TABLE `weixin_report_info`
	CHANGE COLUMN `caseStatus` `caseStatus` TINYINT(3) NOT NULL COMMENT '����״̬ 1:δ�᰸;2:�ѽ᰸,ȱ����;100:�鿴���ȸ����޸����ⷽʽ;110:�����ύ;' AFTER `remark`,
	CHANGE COLUMN `sessionState` `sessionState` TINYINT(3) NULL DEFAULT NULL COMMENT '�Ự״̬  1:�Ự��;0:�����Ự,2:�ͻ��Ƴ��Ự' AFTER `headimgurl`;
