ALTER TABLE `weixin_huodong_record`
	ADD COLUMN `starttime` DATETIME NULL DEFAULT NULL COMMENT '��ʼʱ��' AFTER `phonenum`,
	ADD COLUMN `endtime` DATETIME NULL DEFAULT NULL COMMENT '����ʱ��' AFTER `starttime`,
	ADD COLUMN `cashcouponid` VARCHAR(64) NULL DEFAULT NULL COMMENT '��ʼ����ID' AFTER `endtime`,
	ADD COLUMN `amount` DECIMAL(20.2) NULL DEFAULT NULL COMMENT '���' AFTER `cashcouponid`,
	ADD COLUMN `status` INT(2) NULL DEFAULT NULL COMMENT '��ȡ״̬ 0 ʧ�ܣ�1 �ɹ�' AFTER `amount`;
