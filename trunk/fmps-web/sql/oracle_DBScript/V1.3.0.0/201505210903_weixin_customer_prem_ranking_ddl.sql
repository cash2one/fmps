/*
用户: query2
库: OFFWEBDBP

*/

/*customercode改成identifynumber*/
alter table weixin_customer_prem_ranking rename column customercode to identifynumber;
comment on column weixin_customer_prem_ranking.identifynumber is '证件号码';

/*索引*/
-- Create/Recreate indexes 
create index IDX_PREM_RANKING_IDENTIFY_NAME on WEIXIN_CUSTOMER_PREM_RANKING (CUSTOMERNAME, IDENTIFYNUMBER)
  tablespace YWSPACE
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
-- Grant/Revoke object privileges 
grant select on WEIXIN_CUSTOMER_PREM_RANKING to FMPSREAD;