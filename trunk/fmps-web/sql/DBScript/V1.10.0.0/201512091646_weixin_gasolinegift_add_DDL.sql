ALTER TABLE `weixin_gasolinegift`
	ADD COLUMN `mobile` VARCHAR(15) NULL DEFAULT NULL COMMENT '�ֻ���' AFTER `giftid`,
	ADD COLUMN `licenseno` VARCHAR(20) NULL DEFAULT NULL COMMENT '���ƺ�' AFTER `mobile`,
	ADD COLUMN `address` VARCHAR(200) NULL DEFAULT NULL COMMENT '�ͻ���ϸ��ַ' AFTER `licenseno`,
	ADD COLUMN `getstatus` INT(5) NULL DEFAULT NULL COMMENT '0������ȡ,1����' AFTER `address`;