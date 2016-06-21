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
  is '������������м��';
-- Add comments to the columns 
comment on column ODS_POLICY_GIFT_SET.POLICYNO
  is '������';
comment on column ODS_POLICY_GIFT_SET.GIFTSETID
  is '���id';
  comment on column ODS_POLICY_GIFT_SET.GIFTSETNAME
  is '�������';
comment on column ODS_POLICY_GIFT_SET.DISTRIBUTEDCOUNT
  is '��������';
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
