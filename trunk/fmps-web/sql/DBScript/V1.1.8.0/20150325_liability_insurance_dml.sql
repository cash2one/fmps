/**MYSQL**/
/**��һ��΢�����ִ���**/
insert into insurance_plan_type(id,insurance_plan_code,insurance_plan_cname)
values('402889f657666ae401476670bb74000g','06','������');

/**�������������ֵ�΢�����ִ���**/
update weixin_plan_risk_map set insurance_plan_code='06' where risk_code like '15__';

/**������������������ֶι��ɾ�ʹ��**/
alter table weixin_customer_prem_ranking
    add liability varchar(1) DEFAULT NULL COMMENT '������';
