/*����������ṹ�޸�*/

/*�޸�customercodeΪ�ֶ�identifynumber*/
ALTER TABLE weixin_customer_prem_ranking CHANGE customercode identifynumber varchar(20) NOT NULL COMMENT '֤������';

/*�����ֶ�openid*/
ALTER TABLE weixin_customer_prem_ranking ADD openid varchar(36) NULL COMMENT '΢�ź�';

/*�������޸�*/
alter table weixin_customer_prem_ranking engine=MyISAM;
 