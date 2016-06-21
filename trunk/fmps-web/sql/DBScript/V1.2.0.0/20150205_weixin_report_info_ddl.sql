CREATE TABLE `weixin_report_info` (
	`ID` VARCHAR(32) NOT NULL COMMENT '����',
	`registNo` VARCHAR(100) NOT NULL DEFAULT '' COMMENT '������',
	`reportorName` VARCHAR(50) NULL DEFAULT NULL COMMENT '���������� ',
	`licenseNo` VARCHAR(20) NULL DEFAULT NULL COMMENT '���ƺ�',
	`reportDate` VARCHAR(20) NULL DEFAULT NULL COMMENT '�������� YYYY-MM-DD',
	`reportTime` VARCHAR(20) NULL DEFAULT NULL COMMENT '����ʱ�� HH24:MM:SS',
	`operatorCode` VARCHAR(15) NULL DEFAULT NULL COMMENT '������Ա����',
	`certiMaterialType` VARCHAR(200) NULL DEFAULT NULL COMMENT 'Ƿȱ��������',
	`remark` VARCHAR(500) NULL DEFAULT NULL COMMENT '����ժҪ',
	`caseStatus` VARCHAR(3) NOT NULL COMMENT '����״̬ 1:δ�᰸;2:�ѽ᰸,ȱ����;100:�鿴���ȸ����޸����ⷽʽ;110:�����ύ;',
	`newCarFlag` VARCHAR(5) NULL DEFAULT NULL COMMENT '�Ƿ��³� 1���� 0����',
	`openid` VARCHAR(100) NULL DEFAULT NULL COMMENT 'openid',
	`nickname` VARCHAR(100) NULL DEFAULT NULL COMMENT '�ǳ�',
	`headimgurl` VARCHAR(255) NULL DEFAULT NULL COMMENT '�û�ͷ��',
	`sessionState` VARCHAR(5) NULL DEFAULT NULL COMMENT '�Ự״̬  1:�Ự��;0:�����Ự',
	`messageTotal` VARCHAR(5) NULL DEFAULT NULL COMMENT 'δ����Ϣ����',
	`phoneNumber` VARCHAR(20) NULL DEFAULT NULL COMMENT '�����绰',
	`underwritingTime` TIMESTAMP NULL DEFAULT NULL COMMENT '�������ʱ��',
	PRIMARY KEY (`ID`),
	INDEX `Index` (`registNo`)
)
COMMENT='΢�ű�����Ϣ��'
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;
