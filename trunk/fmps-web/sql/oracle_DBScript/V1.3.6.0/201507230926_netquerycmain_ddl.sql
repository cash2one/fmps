/* netquerycmain 新增险种中文简称字段*/ 
alter table query2.netquerycmain add (riskshortname varchar2(20));
comment on column query2.netquerycmain.riskshortname is '险种中文简称';
