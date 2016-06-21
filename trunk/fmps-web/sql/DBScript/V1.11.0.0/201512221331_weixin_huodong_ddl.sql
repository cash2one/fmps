ALTER TABLE `weixin_huodong`
	CHANGE COLUMN `totalamount` `totalamount` INT(11) NULL DEFAULT '0' COMMENT '总金额' AFTER `accountid`;