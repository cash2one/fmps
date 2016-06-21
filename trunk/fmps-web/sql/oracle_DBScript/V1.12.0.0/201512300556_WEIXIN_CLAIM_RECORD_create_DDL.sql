-- Create table
create table WEIXIN_CLAIM_RECORD
(
  ID             VARCHAR2(32) not null,
  RISKCODE       VARCHAR2(10),
  TITLE          VARCHAR2(32),
  REMARK         VARCHAR2(200),
  INSUREDNAME    VARCHAR2(10),
  IDEDTIFYNUMBER VARCHAR2(32) not null,
  REGISTNO       VARCHAR2(32) not null,
  NODENAME       VARCHAR2(32) not null,
  FLOWINTIME     DATE not null,
  SUMCLAIM       VARCHAR2(32)
)
tablespace USERS
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
comment on column WEIXIN_CLAIM_RECORD.RISKCODE
  is '险种代码';
comment on column WEIXIN_CLAIM_RECORD.TITLE
  is '标题';
comment on column WEIXIN_CLAIM_RECORD.REMARK
  is '案件描述';
comment on column WEIXIN_CLAIM_RECORD.INSUREDNAME
  is '被保险人姓名';
comment on column WEIXIN_CLAIM_RECORD.IDEDTIFYNUMBER
  is '证件号码';
comment on column WEIXIN_CLAIM_RECORD.REGISTNO
  is '报案号';
comment on column WEIXIN_CLAIM_RECORD.NODENAME
  is '当前进度';
comment on column WEIXIN_CLAIM_RECORD.FLOWINTIME
  is '节点处理日期';
comment on column WEIXIN_CLAIM_RECORD.SUMCLAIM
  is '赔款金额';
-- Create/Recreate primary, unique and foreign key constraints 
alter table WEIXIN_CLAIM_RECORD
  add constraint PRIMARY_KEY_ID primary key (ID)
  using index 
  tablespace USERS
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
