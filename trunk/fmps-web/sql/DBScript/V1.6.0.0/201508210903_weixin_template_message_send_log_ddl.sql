/* weixin_template_message_send_log 加字段 status */
alter table weixin_template_message_send_log
    add status varchar(50) default null comment '发送状态:success成功;failed:user block用户拒绝接收;failed: system failed发送失败（非用户拒绝）';

/*ALTER删字段 return_code:*/
alter table weixin_template_message_send_log drop column return_code;

/*ALTER删字段 return_msg:*/
alter table weixin_template_message_send_log drop column return_msg;
