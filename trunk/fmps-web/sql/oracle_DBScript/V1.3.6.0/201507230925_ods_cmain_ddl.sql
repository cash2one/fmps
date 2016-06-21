/* ods_cmain 新增险种中文简称字段*/ 
alter table query2.ods_cmain add (riskshortname varchar2(20));
comment on column query2.ods_cmain.riskshortname is '险种中文简称';