
/*weixin_stu_policy加字段payorderno;paystate */
alter table weixin_stu_policy
    add payorderno varchar(32) DEFAULT NULL COMMENT  '支付订单号';


alter table weixin_stu_policy
    add paystatus varchar(4) DEFAULT NULL COMMENT  '支付状态（未支付：0；支付成功：1，支付失败:2，取消支付:3）';