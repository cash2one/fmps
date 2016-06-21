/*更新春节活动赠险定时承保任务*/
/* '0 0 1 31 1 ? 2016'表示2016年1月31号凌晨1点 */
update t_s_timetask set cron_expression = '0 0 1 31 1 ? 2016' where id = 'lunarNewYearCoreUnderwrite160201'