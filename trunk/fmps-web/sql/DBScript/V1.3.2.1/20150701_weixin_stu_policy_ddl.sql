
/*weixin_stu_policy���ֶ�payorderno;paystate */
alter table weixin_stu_policy
    add payorderno varchar(32) DEFAULT NULL COMMENT  '֧��������';


alter table weixin_stu_policy
    add paystatus varchar(4) DEFAULT NULL COMMENT  '֧��״̬��δ֧����0��֧���ɹ���1��֧��ʧ��:2��ȡ��֧��:3��';