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
  is '΢�����ȯ��ϸ�м��';
-- Add comments to the columns 
comment on column ODS_GIFT_SET_DETAIL.ID
  is '��ϸȯID';
comment on column ODS_GIFT_SET_DETAIL.POLICYNO
  is '������';
comment on column ODS_GIFT_SET_DETAIL.NAME
  is 'ȯ����';
comment on column ODS_GIFT_SET_DETAIL.REPAIRLOGO
  is '����logo';
comment on column ODS_GIFT_SET_DETAIL.PROVIDEREPAIRNAME
  is '��������';
comment on column ODS_GIFT_SET_DETAIL.DEEPCOLOR
  is '����ɫ';
comment on column ODS_GIFT_SET_DETAIL.LIGHTCOLOR
  is 'ǳ��ɫ';
comment on column ODS_GIFT_SET_DETAIL.STARTDATE
  is '��ʼ����';
comment on column ODS_GIFT_SET_DETAIL.ENDDATE
  is '��ֹ����';
comment on column ODS_GIFT_SET_DETAIL.ETL_INSERTTIME
  is '����ʱ��';
comment on column ODS_GIFT_SET_DETAIL.APPLICANTNAME
  is 'Ͷ��������';
comment on column ODS_GIFT_SET_DETAIL.APPIDENTIFYNUMBER
  is 'Ͷ����֤����';
comment on column ODS_GIFT_SET_DETAIL.INSUREDNAME
  is '����������';
comment on column ODS_GIFT_SET_DETAIL.INSIDENTIFYNUMBER
  is '������֤����';
comment on column ODS_GIFT_SET_DETAIL.GIFTSETID
  is '������ֽ�ȯID';
comment on column ODS_GIFT_SET_DETAIL.BATCHID
  is '���κ�';
comment on column ODS_GIFT_SET_DETAIL.GIFTSETNAME
  is '������ֽ�ȯ����';
comment on column ODS_GIFT_SET_DETAIL.AREANAME
  is '��������';
comment on column ODS_GIFT_SET_DETAIL.CARDTYPE
  is 'ȯ����';
comment on column ODS_GIFT_SET_DETAIL.GIFTSETDETAILID
  is '����ȯ���ֽ�ȯID';
comment on column ODS_GIFT_SET_DETAIL.LICENSENO
  is '���ƺ�';
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
