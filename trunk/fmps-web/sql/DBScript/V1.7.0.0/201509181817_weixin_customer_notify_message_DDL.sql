CREATE TABLE `weixin_customer_notify_message` (
	`id` VARCHAR(100) NOT NULL COMMENT '主键',
	`msgtype` INT(11) NOT NULL COMMENT '消息类型',
	`sendstatus` TINYINT(4) NULL DEFAULT '0' COMMENT '发送成功标记',
	`brandname` VARCHAR(100) NULL DEFAULT NULL COMMENT '车型名称',
	`engineno` VARCHAR(100) NULL DEFAULT NULL COMMENT '发动机号',
	`frameno` VARCHAR(30) NULL DEFAULT NULL COMMENT '车架号',
	`licenseno` VARCHAR(20) NULL DEFAULT NULL COMMENT '车牌号',
	`policyno` VARCHAR(22) NULL DEFAULT NULL COMMENT '保单号',
	`identifynumber` VARCHAR(20) NULL DEFAULT NULL COMMENT '证件号码',
	`insuredname` VARCHAR(120) NULL DEFAULT NULL COMMENT '客户名称',
	`record_id` VARCHAR(100) NULL DEFAULT NULL COMMENT '发送出去的消息ID',
	`nextsendtime` DATETIME NULL DEFAULT NULL COMMENT '下次发送时间'
)
COMMENT='客户通知消息表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;