ALTER TABLE `weixin_email_operatelog`
	ADD COLUMN `operatelogId` VARCHAR(50) NOT NULL COMMENT '操作日志id' AFTER `id`;