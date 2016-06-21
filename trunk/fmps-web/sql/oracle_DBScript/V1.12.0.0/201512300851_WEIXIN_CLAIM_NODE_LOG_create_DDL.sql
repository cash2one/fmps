-- Create table
create table WEIXIN_CLAIM_NODE_LOG
(
  ID         VARCHAR2(32) not null,
  REGISTNO   VARCHAR2(32),
  NODENAME   VARCHAR2(200),
  FLOWINTIME DATE,
  SUMCLAIM   VARCHAR2(32)
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
comment on column WEIXIN_CLAIM_NODE_LOG.REGISTNO
  is '报案号';
comment on column WEIXIN_CLAIM_NODE_LOG.NODENAME
  is '节点名称';
comment on column WEIXIN_CLAIM_NODE_LOG.FLOWINTIME
  is '节点处理日期';
comment on column WEIXIN_CLAIM_NODE_LOG.SUMCLAIM
  is '赔款金额';
-- Create/Recreate primary, unique and foreign key constraints 
alter table WEIXIN_CLAIM_NODE_LOG
  add primary key (ID)
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
