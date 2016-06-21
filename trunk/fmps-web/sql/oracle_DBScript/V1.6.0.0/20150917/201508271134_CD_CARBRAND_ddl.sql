
-- Create table
create table CD_CARBRAND
(
  BRANDID   VARCHAR2(3) not null,
  BRANDNAME VARCHAR2(60) not null
)
tablespace TBS_QUERY2
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table CD_CARBRAND
  is '车品牌';
-- Add comments to the columns 
comment on column CD_CARBRAND.BRANDID
  is '品牌id';
comment on column CD_CARBRAND.BRANDNAME
  is '品牌名称';
-- Create/Recreate primary, unique and foreign key constraints 
alter table CD_CARBRAND
  add primary key (BRANDID)
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
-- Grant/Revoke object privileges 
grant select on CD_CARBRAND to FMPSREAD;
