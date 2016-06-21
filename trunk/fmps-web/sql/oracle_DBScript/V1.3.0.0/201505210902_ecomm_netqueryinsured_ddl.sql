/*
用户: query2
库: OFFWEBDBP

*/

-- Create table
create table ECOMM_NETQUERYINSURED
(
  POLICYNO        VARCHAR2(22) not null,
  RISKCODE        VARCHAR2(4) not null,
  SERIALNO        INTEGER not null,
  INSUREDTYPE     VARCHAR2(1),
  INSUREDCODE     VARCHAR2(20),
  INSUREDNAME     VARCHAR2(120),
  INSUREDFLAG     VARCHAR2(1),
  INSUREDIDENTITY VARCHAR2(2),
  IDENTIFYTYPE    VARCHAR2(10),
  IDENTIFYNUMBER  VARCHAR2(20),
  LINKERNAME      VARCHAR2(120)
)
tablespace YWSPACE
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
-- Add comments to the columns 
comment on column ECOMM_NETQUERYINSURED.POLICYNO
  is '保单号';
comment on column ECOMM_NETQUERYINSURED.RISKCODE
  is '险种代码';
comment on column ECOMM_NETQUERYINSURED.SERIALNO
  is '保险关系人序号';
comment on column ECOMM_NETQUERYINSURED.INSUREDTYPE
  is '保险关系人类型';
comment on column ECOMM_NETQUERYINSURED.INSUREDCODE
  is '客户代码';
comment on column ECOMM_NETQUERYINSURED.INSUREDNAME
  is '客户名称';
comment on column ECOMM_NETQUERYINSURED.INSUREDFLAG
  is '保险关系人身份';
comment on column ECOMM_NETQUERYINSURED.INSUREDIDENTITY
  is '与被保险人关系';
comment on column ECOMM_NETQUERYINSURED.IDENTIFYTYPE
  is '证件类型';
comment on column ECOMM_NETQUERYINSURED.IDENTIFYNUMBER
  is '证件号码';
comment on column ECOMM_NETQUERYINSURED.LINKERNAME
  is '联系人名称';
-- Create/Recreate primary, unique and foreign key constraints 
alter table ECOMM_NETQUERYINSURED
  add constraint PK_NETQUERYINSURED primary key (POLICYNO, SERIALNO)
  using index 
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
-- Create/Recreate indexes 
create index IDX_ECOMM_INSURE_IDENTIFY_NAME on ECOMM_NETQUERYINSURED (IDENTIFYNUMBER, INSUREDNAME)
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
grant select on ECOMM_NETQUERYINSURED to FMPSREAD;