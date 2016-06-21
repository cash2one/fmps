ALTER TABLE `weixin_customer`
	ADD COLUMN `department` VARCHAR(20) NULL COMMENT '院系' AFTER `licenseno`,
	ADD COLUMN `studentNo` VARCHAR(20) NULL COMMENT '学号' AFTER `department`;