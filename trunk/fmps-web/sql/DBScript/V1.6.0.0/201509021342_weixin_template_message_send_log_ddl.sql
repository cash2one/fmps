/*id字段的类型改成varchar(32)*/
ALTER TABLE weixin_template_message_send_log modify column id varchar(32) NOT NULL COMMENT '主键' primary key;