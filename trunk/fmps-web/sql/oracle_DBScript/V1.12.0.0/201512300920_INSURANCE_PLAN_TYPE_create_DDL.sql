-- Create table
create table INSURANCE_PLAN_TYPE
(
  ID                   VARCHAR2(32) not null,
  INSURANCE_PLAN_CODE  VARCHAR2(4) not null,
  INSURANCE_PLAN_CNAME VARCHAR2(42)
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
-- Create/Recreate primary, unique and foreign key constraints 
alter table INSURANCE_PLAN_TYPE
  add primary key (ID, INSURANCE_PLAN_CODE)
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
