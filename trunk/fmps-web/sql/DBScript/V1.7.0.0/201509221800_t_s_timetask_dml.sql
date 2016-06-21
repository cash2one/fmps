/*新增发送生日提醒模板消息定时任务*/
/* '0 0 10 * * ?'表示每天10点0分 */
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
  ('birthdaymessage11423423470014234',
   '4028d881436d514601436d5215ac0043',
   '2015-09-22 14:12:26',
   'admin',
   '0 0 10 * * ?',
   '1',
   '0',
   '定时生日提醒模板消息',
   'templateMessageSendBirthdayMessageTrigger',
   '4028d881436d514601436d5215ac0043',
   '2015-09-22 14:13:35',
   'admin',
   '10.1.18.88');