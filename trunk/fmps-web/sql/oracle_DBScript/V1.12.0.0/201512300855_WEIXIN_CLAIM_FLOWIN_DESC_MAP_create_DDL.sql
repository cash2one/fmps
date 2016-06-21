-- Create table
create table WEIXIN_CLAIM_FLOWIN_DESC_MAP
(
  ID              VARCHAR2(32) not null,
  CORE_NODENAME   VARCHAR2(50),
  WEIXIN_NODENAME VARCHAR2(50),
  WEIXIN_NODEDESC VARCHAR2(400)
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
comment on column WEIXIN_CLAIM_FLOWIN_DESC_MAP.CORE_NODENAME
  is '核心节点名称';
comment on column WEIXIN_CLAIM_FLOWIN_DESC_MAP.WEIXIN_NODENAME
  is '微信节点名称';
comment on column WEIXIN_CLAIM_FLOWIN_DESC_MAP.WEIXIN_NODEDESC
  is '微信节点描述';
-- Create/Recreate primary, unique and foreign key constraints 
alter table WEIXIN_CLAIM_FLOWIN_DESC_MAP
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
