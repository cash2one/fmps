
/*�����ֶ� customerSex*/
ALTER TABLE weixin_gzuserinfo ADD customerSex varchar(1) NULL COMMENT '��֤�ͻ����Ա�';

/*�����ֶ� customerBirthday*/
ALTER TABLE weixin_gzuserinfo ADD customerBirthday date NULL COMMENT '��֤�ͻ�������';

/*�����ֶ� identifyType*/
ALTER TABLE weixin_gzuserinfo ADD identifyType varchar(10) NULL COMMENT '��֤�ͻ���֤������';