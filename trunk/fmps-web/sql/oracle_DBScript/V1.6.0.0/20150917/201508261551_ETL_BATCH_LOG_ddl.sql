-- ����һ�����κŵ�sequence
CREATE SEQUENCE seqBatchId
INCREMENT BY 1 -- ÿ�μӼ���
START WITH 1 -- ��1��ʼ����
NOMAXvalue -- ���������ֵ
NOCYCLE -- һֱ�ۼӣ���ѭ��
NOCACHE;


-- Create table
create table ETL_BATCH_LOG
(
  BATCHID   NUMBER(28) not null,
  TASKNAME  VARCHAR2(50),
  STARTTIME DATE,
  ENDTIME   DATE,
  STATUS    INTEGER default 0,
  REASON    VARCHAR2(255)
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
comment on table ETL_BATCH_LOG
  is 'etl�������α�';
-- Add comments to the columns 
comment on column ETL_BATCH_LOG.BATCHID
  is '����,���κ�';
comment on column ETL_BATCH_LOG.TASKNAME
  is '��������(ת��,job��洢���̵�)';
comment on column ETL_BATCH_LOG.STARTTIME
  is '����ʼʱ��';
comment on column ETL_BATCH_LOG.ENDTIME
  is '�������ʱ��';
comment on column ETL_BATCH_LOG.STATUS
  is '����״̬(0:ʧ��;1:�ɹ�)';
comment on column ETL_BATCH_LOG.REASON
  is 'ʧ��ԭ��';
-- Create/Recreate primary, unique and foreign key constraints 
alter table ETL_BATCH_LOG
  add constraint ETL_BATCH_LOG_PK primary key (BATCHID)
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
-- Create/Recreate indexes 
create index ETL_BATCH_LOG_IDX1 on ETL_BATCH_LOG (TASKNAME)
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
