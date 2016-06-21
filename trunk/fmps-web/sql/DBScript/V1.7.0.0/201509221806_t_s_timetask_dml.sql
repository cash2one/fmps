/*新增定时发送新车上牌提醒模板消息 时间*/
/* 修改为'0 0 10 * * ?'表示每天10点0分 */
update t_s_timetask t
   set t.CRON_EXPRESSION = '0 0 10 * * ?'
 where t.id = 'zymtestdfb4881111423423470014234';