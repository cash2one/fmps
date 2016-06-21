/*新增发送新车上牌提醒模板消息定时任务*/
/* '0 0 10 1 * ?'表示每月1号10点0分 */
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
  ('zymtestdfb4881111423423470014234',
   '4028d881436d514601436d5215ac0043',
   '2015-09-17 09:08:26',
   'admin',
   '0 0 10 1 * ?',
   '1',
   '0',
   '定时发送新车上牌提醒模板消息',
   'templateMessageSendNewCarTrigger',
   '4028d881436d514601436d5215ac0043',
   '2015-09-17 17:04:35',
   'admin',
   '10.1.18.88');