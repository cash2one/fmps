ALTER TABLE `weixin_policy_insured_identity`
	ADD COLUMN `occupationgrade` VARCHAR(3) NULL COMMENT 'ְҵ���1~6��' AFTER `customerid`,
	ADD COLUMN `occupationcode` VARCHAR(10) NULL COMMENT 'ְҵ����' AFTER `occupationgrade`,
	ADD COLUMN `occupationname` VARCHAR(100) NULL COMMENT 'ְҵ�����������' AFTER `occupationcode`;
