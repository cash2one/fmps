/* weixin_template_message_send_log ���ֶ� status */
alter table weixin_template_message_send_log
    add status varchar(50) default null comment '����״̬:success�ɹ�;failed:user block�û��ܾ�����;failed: system failed����ʧ�ܣ����û��ܾ���';

/*ALTERɾ�ֶ� return_code:*/
alter table weixin_template_message_send_log drop column return_code;

/*ALTERɾ�ֶ� return_msg:*/
alter table weixin_template_message_send_log drop column return_msg;
