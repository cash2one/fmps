/*
�û�: query2
��: OFFWEBDBP

*/

drop table WEIXIN_USER_RISKS;

-- Create table
create table WEIXIN_USER_RISKS
(
  RISKCODE       VARCHAR2(4) not null,
  IDENTIFYNUMBER VARCHAR2(20) not null,
  CUSTOMERCNAME  VARCHAR2(120) not null
)
tablespace YWSPACE
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
-- Add comments to the table 
comment on table WEIXIN_USER_RISKS
  is '�ͻ�Ͷ��������';
-- Add comments to the columns 
comment on column WEIXIN_USER_RISKS.RISKCODE
  is '�������ִ���';
comment on column WEIXIN_USER_RISKS.IDENTIFYNUMBER
  is '֤������';
comment on column WEIXIN_USER_RISKS.CUSTOMERCNAME
  is '�ͻ�����';
-- Create/Recreate indexes 
create index IDX_USER_RISKS_IDENTIFY_NAME on WEIXIN_USER_RISKS (IDENTIFYNUMBER, CUSTOMERCNAME)
  tablespace YWSPACE
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
grant select on WEIXIN_USER_RISKS to FMPSREAD;