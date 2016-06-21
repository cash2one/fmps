ALTER TABLE `weixin_transaction_record`
	CHANGE COLUMN `internalRequest` `internalRequest` VARCHAR(6000) NULL DEFAULT NULL COMMENT '请求内部内容' AFTER `createtime`;