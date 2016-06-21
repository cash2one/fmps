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
  is '΢�ű������������';
-- Add comments to the columns 
comment on column WEIXIN_POLICY_GIFT_SET.POLICYNO
  is '������';
comment on column WEIXIN_POLICY_GIFT_SET.GIFT_SET_ID
  is '���ID�����ֽ�ȯID';
comment on column WEIXIN_POLICY_GIFT_SET.GIFT_SET_COUNT
  is '������ֽ�ȯ��������';
comment on column WEIXIN_POLICY_GIFT_SET.INSERTTIME
  is '����ʱ��';
comment on column WEIXIN_POLICY_GIFT_SET.GIFT_SET_DETAIL_ID
  is 'ȯID';
comment on column WEIXIN_POLICY_GIFT_SET.GIFT_SET_DETAIL_COUNT
  is 'ȯ��������,һ��������ܺ����Ŵ���ȯ,ϴ��ȯ��';
comment on column WEIXIN_POLICY_GIFT_SET.NAME
  is 'ȯ����';
comment on column WEIXIN_POLICY_GIFT_SET.REPAIRLOGO
  is '����logo';
comment on column WEIXIN_POLICY_GIFT_SET.DEEPCOLOR
  is '��ɫ';
comment on column WEIXIN_POLICY_GIFT_SET.LIGHTCOLOR
  is 'ǳɫ';
comment on column WEIXIN_POLICY_GIFT_SET.PROVIDEREPAIRNAME
  is '��������';
comment on column WEIXIN_POLICY_GIFT_SET.STARTDATE
  is '��ʼ����';
comment on column WEIXIN_POLICY_GIFT_SET.ENDDATE
  is '��ֹ����';
comment on column WEIXIN_POLICY_GIFT_SET.APPLICANTNAME
  is 'Ͷ��������';
comment on column WEIXIN_POLICY_GIFT_SET.APPIDENTIFYNUMBER
  is 'Ͷ����֤����';
comment on column WEIXIN_POLICY_GIFT_SET.INSUREDNAME
  is '����������';
comment on column WEIXIN_POLICY_GIFT_SET.INSIDENTIFYNUMBER
  is '������֤����';
comment on column WEIXIN_POLICY_GIFT_SET.BATCHID
  is '���κ�';
comment on column WEIXIN_POLICY_GIFT_SET.GIFT_SET_NAME
  is '������ֽ�ȯ����';
comment on column WEIXIN_POLICY_GIFT_SET.AREANAME
  is '��������';
comment on column WEIXIN_POLICY_GIFT_SET.CARDTYPE
  is 'ȯ����';
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
