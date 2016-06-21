alter table weixin_template_message_send_log modify column status varchar(50)
comment '发送状态:success成功;failed:user block用户拒绝接收;failed: system failed发送失败（非用户拒绝）;';
alter table weixin_template_message_send_log add record_id varchar(36) null comment '外键';
alter table weixin_template_message_send_log add errcode varchar(10) null comment '接口调用返回码';
alter table weixin_template_message_send_log add errmsg varchar(255) null comment '接口调用返回消息';
alter table weixin_template_message_send_log
add constraint FK_TEMPLATE_MESSAGE_LOG_TEMPLATE_MESSAGE__RECORD_ID foreign key (record_id)
references weixin_template_mesasge_record (id);