/**MYSQL**/
/**加一个微信险种大类**/
insert into insurance_plan_type(id,insurance_plan_code,insurance_plan_cname)
values('402889f657666ae401476670bb74000g','06','责任险');

/**更新责任险险种的微信险种大类**/
update weixin_plan_risk_map set insurance_plan_code='06' where risk_code like '15__';

/**保费排名表加责任险字段供成就使用**/
alter table weixin_customer_prem_ranking
    add liability varchar(1) DEFAULT NULL COMMENT '责任险';
