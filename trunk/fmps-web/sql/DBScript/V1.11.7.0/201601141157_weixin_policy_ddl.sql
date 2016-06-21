ALTER TABLE weixin_policy CHANGE COLUMN status status varchar(5) NULL DEFAULT NULL COMMENT '0:未支付;1:支付完成;2:支付成功;3:支付失败;4:取消支付';
