ALTER TABLE `weixin_huodong_record`
	ADD COLUMN `phonenum` VARCHAR(11) NULL DEFAULT NULL COMMENT '发起人手机号码' AFTER `huodongid`;
