/*删除外键约束和引用*/
alter table weixin_template_message_send_log drop foreign key FK_TEMPLATE_MESSAGE_LOG_TEMPLATE_MESSAGE__MESSAGE_ID;

drop index FK_TEMPLATE_MESSAGE_LOG_TEMPLATE_MESSAGE__MESSAGE_ID on weixin_template_message_send_log;
