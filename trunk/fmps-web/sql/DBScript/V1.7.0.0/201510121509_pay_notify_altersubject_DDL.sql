ALTER TABLE `pay_notify`
	CHANGE COLUMN `subject` `subject` VARCHAR(256) NULL DEFAULT NULL COMMENT '商品名称' AFTER `out_trade_no`;
