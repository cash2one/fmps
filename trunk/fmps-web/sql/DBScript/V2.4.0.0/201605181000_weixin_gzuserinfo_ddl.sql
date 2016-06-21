ALTER TABLE `weixin_gzuserinfo`
	CHANGE COLUMN `customercode` `customercode` VARCHAR(110) NULL DEFAULT NULL COMMENT 'netquerydcustomeridv客户代码' AFTER `account_id`;