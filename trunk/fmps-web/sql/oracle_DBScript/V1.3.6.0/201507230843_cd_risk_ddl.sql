/* cd_risk 新增险种中文简称字段*/ 
alter table query2.cd_risk add (riskshortname varchar2(20));
comment on column query2.cd_risk.riskshortname is '险种中文简称';