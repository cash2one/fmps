ALTER TABLE `weixin_huodong_record`
	add COLUMN `customercname`  VARCHAR(120) NULL DEFAULT NULL COMMENT '客户名称' AFTER `huodongid`,
	add COLUMN `identifynumber` VARCHAR(20) NULL DEFAULT NULL COMMENT '身份证号' AFTER `customercname`;