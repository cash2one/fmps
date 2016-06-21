ALTER TABLE `weixin_huodong`
	CHANGE COLUMN `totalamount` `totalamount` INT(11) NULL DEFAULT NULL COMMENT '总金额，单位元' AFTER `accountid`;