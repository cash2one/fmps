ALTER TABLE `weixin_policy_insured_identity`
	ADD COLUMN `occupationgrade` VARCHAR(3) NULL COMMENT '职业类别（1~6）' AFTER `customerid`,
	ADD COLUMN `occupationcode` VARCHAR(10) NULL COMMENT '职业代码' AFTER `occupationgrade`,
	ADD COLUMN `occupationname` VARCHAR(100) NULL COMMENT '职业类别中文名称' AFTER `occupationcode`;
