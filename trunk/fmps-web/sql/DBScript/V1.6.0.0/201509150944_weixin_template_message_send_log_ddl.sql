/*封装后的微信模板消息送达状态*/
alter table weixin_template_message_send_log MODIFY COLUMN status tinyint(4) comment '封装后的微信模板消息送达状态 0:成功;1:用户拒绝接收;2:发送失败(非用户拒绝)';