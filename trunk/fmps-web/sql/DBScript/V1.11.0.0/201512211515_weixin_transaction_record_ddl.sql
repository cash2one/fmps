ALTER TABLE `weixin_transaction_record`
	CHANGE COLUMN `internalRequest` `internalRequest` LONGTEXT NULL DEFAULT NULL COMMENT '请求内部内容' AFTER `createtime`,
    CHANGE COLUMN `externalRequest` `externalRequest` LONGTEXT NULL DEFAULT NULL COMMENT '请求外部内容' AFTER `internalRequest`,
	CHANGE COLUMN `internalResponse` `internalResponse` LONGTEXT NULL DEFAULT NULL COMMENT '响应内部内容' AFTER `externalRequest`,
    CHANGE COLUMN `externalResponse` `externalResponse` LONGTEXT NULL DEFAULT NULL COMMENT '响应外部内容' AFTER `internalResponse`;