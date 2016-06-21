-- 新增一个批次号的sequence
CREATE SEQUENCE seqBatchId
INCREMENT BY 1 -- 每次加几个
START WITH 1 -- 从1开始计数
NOMAXvalue -- 不设置最大值
NOCYCLE -- 一直累加，不循环
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
  is 'etl提数批次表';
-- Add comments to the columns 
comment on column ETL_BATCH_LOG.BATCHID
  is '主键,批次号';
comment on column ETL_BATCH_LOG.TASKNAME
  is '任务名称(转换,job或存储过程等)';
comment on column ETL_BATCH_LOG.STARTTIME
  is '任务开始时间';
comment on column ETL_BATCH_LOG.ENDTIME
  is '任务结束时间';
comment on column ETL_BATCH_LOG.STATUS
  is '跑批状态(0:失败;1:成功)';
comment on column ETL_BATCH_LOG.REASON
  is '失败原因';
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
