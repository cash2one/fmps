CREATE TABLE `pay_log` (
	`id` VARCHAR(32) NOT NULL COMMENT '主键',
	`out_trade_no` VARCHAR(64) NOT NULL COMMENT '订单号',
	`reqtime` DATETIME NOT NULL COMMENT '请求时间',
	`type` VARCHAR(20) NOT NULL COMMENT '支付方式(支付宝，微信支付，网银在线，快钱支付等)',
	`reqtype` VARCHAR(20) NOT NULL COMMENT '请求类型(下单，交易等)',
	`total_fee` DOUBLE NULL DEFAULT NULL COMMENT '交易金额',
	`token` VARCHAR(100) NULL DEFAULT NULL COMMENT '授权',
	`result` VARCHAR(100) NULL DEFAULT NULL COMMENT '结果',
	`errcode` VARCHAR(16) NULL DEFAULT NULL COMMENT '错误代码',
	`errdetail` VARCHAR(150) NULL DEFAULT NULL COMMENT '错误描述'
)
COMMENT='第三方支付交易记录表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;
