ALTER TABLE `weixin_newcar_licenseno`
	ADD COLUMN `identifynumber` VARCHAR(50) NULL COMMENT '֤������' AFTER `applicationNo`,
	ADD COLUMN `customercname` VARCHAR(10) NULL COMMENT '�ͻ�����' AFTER `identifynumber`;