ALTER TABLE `weixin_newcar_licenseno`
	ADD COLUMN `identifynumber` VARCHAR(50) NULL COMMENT '证件号码' AFTER `applicationNo`,
	ADD COLUMN `customercname` VARCHAR(10) NULL COMMENT '客户姓名' AFTER `identifynumber`;