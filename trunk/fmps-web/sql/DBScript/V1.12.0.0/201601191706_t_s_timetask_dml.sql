/*新增春节活动赠险定时承保任务*/
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
  ('lunarNewYearCoreUnderwrite160201',
   '4028d881436d514601436d5215ac0043',
   '2016-01-19 17:09:26',
   'admin',
   '0 0 10 * * ?',
   '1',
   '0',
   '春节活动定时跑批核心承保',
   'lunarNewYearCoreUnderwriteTrigger',
   '4028d881436d514601436d5215ac0043',
   '2016-01-19 17:09:26',
   'admin',
   '10.1.18.88');