-- Create table
create table ODS_POLICY_GIFT_SET
(
  POLICYNO         VARCHAR2(22) not null,
  GIFTSETID        VARCHAR2(20) not null,
  GIFTSETNAME      VARCHAR2(200) not null,
  DISTRIBUTEDCOUNT INTEGER not null
)
tablespace TBS_QUERY2
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64
    next 8
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table ODS_POLICY_GIFT_SET
  is '电销保单礼包中间表';
-- Add comments to the columns 
comment on column ODS_POLICY_GIFT_SET.POLICYNO
  is '保单号';
comment on column ODS_POLICY_GIFT_SET.GIFTSETID
  is '礼包id';
  comment on column ODS_POLICY_GIFT_SET.GIFTSETNAME
  is '礼包名称';
comment on column ODS_POLICY_GIFT_SET.DISTRIBUTEDCOUNT
  is '发放数量';
-- Create/Recreate primary, unique and foreign key constraints 
alter table ODS_POLICY_GIFT_SET
  add constraint ODS_POLICY_GIFT_SET_PK primary key (POLICYNO, GIFTSETID)
  using index 
  tablespace TBS_QUERY2
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
