/*新增发送模板消息定时任务*/
insert into t_s_timetask
  (ID,
   CREATE_BY,
   CREATE_DATE,
   CREATE_NAME,
   CRON_EXPRESSION,
   IS_EFFECT,
   IS_START,
   TASK_DESCRIBE,
   TASK_ID,
   UPDATE_BY,
   UPDATE_DATE,
   UPDATE_NAME,
   IP_Filter)
values
  ('ga8sdfsdfb4881111423423470014234',
   '4028d881436d514601436d5215ac0043',
   '2014-09-17 08:47:39',
   'admin',
   '0 0/5 * * * ?',
   '1',
   '0',
   '定时发送模板消息',
   'templateMessageSendJobTrigger',
   '4028d881436d514601436d5215ac0043',
   '2015-08-07 14:04:25',
   'admin',
   '10.1.18.88');