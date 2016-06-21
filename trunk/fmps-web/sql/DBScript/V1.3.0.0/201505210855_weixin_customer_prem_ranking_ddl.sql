/*保费排名表结构修改*/

/*修改customercode为字段identifynumber*/
ALTER TABLE weixin_customer_prem_ranking CHANGE customercode identifynumber varchar(20) NOT NULL COMMENT '证件号码';

/*新增字段openid*/
ALTER TABLE weixin_customer_prem_ranking ADD openid varchar(36) NULL COMMENT '微信号';

/*表引擎修改*/
alter table weixin_customer_prem_ranking engine=MyISAM;
 