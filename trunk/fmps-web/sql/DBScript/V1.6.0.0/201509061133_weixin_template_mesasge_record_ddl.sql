alter table weixin_template_mesasge_record modify column status varchar(50)
comment '发送状态:success成功;failed:user block用户拒绝接收;failed: system failed发送失败（非用户拒绝）;';
alter table weixin_template_mesasge_record add errcode varchar(10) null comment '接口调用返回码';
alter table weixin_template_mesasge_record add errmsg varchar(255) null comment '接口调用返回消息';
alter table weixin_template_mesasge_record add next_invoke_time datetime null comment '定时任务重发时间';
alter table weixin_template_mesasge_record add send_count tinyint(4) default '0' comment '定时任务已发送次数,最大为5';