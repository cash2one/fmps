-- Create table
create table WEIXIN_POLICY_GIFT_SET
(
  POLICYNO              VARCHAR2(22) not null,
  GIFT_SET_ID           VARCHAR2(10) not null,
  GIFT_SET_COUNT        INTEGER not null,
  INSERTTIME            DATE not null,
  GIFT_SET_DETAIL_ID    VARCHAR2(10) not null,
  GIFT_SET_DETAIL_COUNT INTEGER not null,
  NAME                  VARCHAR2(50) not null,
  REPAIRLOGO            VARCHAR2(200),
  DEEPCOLOR             VARCHAR2(10) not null,
  LIGHTCOLOR            VARCHAR2(10) not null,
  PROVIDEREPAIRNAME     VARCHAR2(200),
  STARTDATE             DATE not null,
  ENDDATE               DATE not null,
  APPLICANTNAME         VARCHAR2(120) not null,
  APPIDENTIFYNUMBER     VARCHAR2(20) not null,
  INSUREDNAME           VARCHAR2(120) not null,
  INSIDENTIFYNUMBER     VARCHAR2(20) not null,
  BATCHID               NUMBER(28) not null,
  GIFT_SET_NAME         VARCHAR2(200) not null,
  AREANAME              VARCHAR2(100) not null,
  CARDTYPE              NUMBER(2) not null
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
comment on table WEIXIN_POLICY_GIFT_SET
  is '微信保单礼包关联表';
-- Add comments to the columns 
comment on column WEIXIN_POLICY_GIFT_SET.POLICYNO
  is '保单号';
comment on column WEIXIN_POLICY_GIFT_SET.GIFT_SET_ID
  is '礼包ID或者现金券ID';
comment on column WEIXIN_POLICY_GIFT_SET.GIFT_SET_COUNT
  is '礼包或现金券发放数量';
comment on column WEIXIN_POLICY_GIFT_SET.INSERTTIME
  is '新增时间';
comment on column WEIXIN_POLICY_GIFT_SET.GIFT_SET_DETAIL_ID
  is '券ID';
comment on column WEIXIN_POLICY_GIFT_SET.GIFT_SET_DETAIL_COUNT
  is '券发放数量,一个礼包可能含多张打蜡券,洗车券等';
comment on column WEIXIN_POLICY_GIFT_SET.NAME
  is '券名称';
comment on column WEIXIN_POLICY_GIFT_SET.REPAIRLOGO
  is '车行logo';
comment on column WEIXIN_POLICY_GIFT_SET.DEEPCOLOR
  is '深色';
comment on column WEIXIN_POLICY_GIFT_SET.LIGHTCOLOR
  is '浅色';
comment on column WEIXIN_POLICY_GIFT_SET.PROVIDEREPAIRNAME
  is '车行名称';
comment on column WEIXIN_POLICY_GIFT_SET.STARTDATE
  is '起始日期';
comment on column WEIXIN_POLICY_GIFT_SET.ENDDATE
  is '终止日期';
comment on column WEIXIN_POLICY_GIFT_SET.APPLICANTNAME
  is '投保人姓名';
comment on column WEIXIN_POLICY_GIFT_SET.APPIDENTIFYNUMBER
  is '投保人证件号';
comment on column WEIXIN_POLICY_GIFT_SET.INSUREDNAME
  is '被保人姓名';
comment on column WEIXIN_POLICY_GIFT_SET.INSIDENTIFYNUMBER
  is '被保人证件号';
comment on column WEIXIN_POLICY_GIFT_SET.BATCHID
  is '批次号';
comment on column WEIXIN_POLICY_GIFT_SET.GIFT_SET_NAME
  is '礼包或现金券名称';
comment on column WEIXIN_POLICY_GIFT_SET.AREANAME
  is '地区名称';
comment on column WEIXIN_POLICY_GIFT_SET.CARDTYPE
  is '券类型';
-- Create/Recreate indexes 
create index WX_POLICY_GIFT_SET_GIFTSETID on WEIXIN_POLICY_GIFT_SET (GIFT_SET_ID)
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
create index WX_POLICY_GIFT_SET_POLICYNO on WEIXIN_POLICY_GIFT_SET (POLICYNO)
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
