-- Create table
create table ODS_GIFT_SET_DETAIL
(
  ID                VARCHAR2(32) not null,
  POLICYNO          VARCHAR2(22) not null,
  NAME              VARCHAR2(200) not null,
  REPAIRLOGO        VARCHAR2(200),
  PROVIDEREPAIRNAME VARCHAR2(200),
  DEEPCOLOR         VARCHAR2(10) not null,
  LIGHTCOLOR        VARCHAR2(10) not null,
  STARTDATE         DATE not null,
  ENDDATE           DATE not null,
  ETL_INSERTTIME    DATE not null,
  APPLICANTNAME     VARCHAR2(120) not null,
  APPIDENTIFYNUMBER VARCHAR2(20) not null,
  INSUREDNAME       VARCHAR2(120) not null,
  INSIDENTIFYNUMBER VARCHAR2(20) not null,
  GIFTSETID         VARCHAR2(20) not null,
  BATCHID           NUMBER(28) not null,
  GIFTSETNAME       VARCHAR2(200) not null,
  AREANAME          VARCHAR2(100) not null,
  CARDTYPE          NUMBER(2) not null,
  GIFTSETDETAILID   VARCHAR2(20) not null,
  LICENSENO         VARCHAR2(20)
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
comment on table ODS_GIFT_SET_DETAIL
  is '微信礼包券详细中间表';
-- Add comments to the columns 
comment on column ODS_GIFT_SET_DETAIL.ID
  is '详细券ID';
comment on column ODS_GIFT_SET_DETAIL.POLICYNO
  is '保单号';
comment on column ODS_GIFT_SET_DETAIL.NAME
  is '券名称';
comment on column ODS_GIFT_SET_DETAIL.REPAIRLOGO
  is '车行logo';
comment on column ODS_GIFT_SET_DETAIL.PROVIDEREPAIRNAME
  is '车行名称';
comment on column ODS_GIFT_SET_DETAIL.DEEPCOLOR
  is '深颜色';
comment on column ODS_GIFT_SET_DETAIL.LIGHTCOLOR
  is '浅颜色';
comment on column ODS_GIFT_SET_DETAIL.STARTDATE
  is '起始日期';
comment on column ODS_GIFT_SET_DETAIL.ENDDATE
  is '终止日期';
comment on column ODS_GIFT_SET_DETAIL.ETL_INSERTTIME
  is '跑批时间';
comment on column ODS_GIFT_SET_DETAIL.APPLICANTNAME
  is '投保人姓名';
comment on column ODS_GIFT_SET_DETAIL.APPIDENTIFYNUMBER
  is '投保人证件号';
comment on column ODS_GIFT_SET_DETAIL.INSUREDNAME
  is '被保人姓名';
comment on column ODS_GIFT_SET_DETAIL.INSIDENTIFYNUMBER
  is '被保人证件号';
comment on column ODS_GIFT_SET_DETAIL.GIFTSETID
  is '礼包或现金券ID';
comment on column ODS_GIFT_SET_DETAIL.BATCHID
  is '批次号';
comment on column ODS_GIFT_SET_DETAIL.GIFTSETNAME
  is '礼包或现金券名称';
comment on column ODS_GIFT_SET_DETAIL.AREANAME
  is '地区名称';
comment on column ODS_GIFT_SET_DETAIL.CARDTYPE
  is '券类型';
comment on column ODS_GIFT_SET_DETAIL.GIFTSETDETAILID
  is '抵用券或现金券ID';
comment on column ODS_GIFT_SET_DETAIL.LICENSENO
  is '车牌号';
-- Create/Recreate primary, unique and foreign key constraints 
alter table ODS_GIFT_SET_DETAIL
  add constraint ODS_GIFT_SET_DETAIL_PK primary key (ID)
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
