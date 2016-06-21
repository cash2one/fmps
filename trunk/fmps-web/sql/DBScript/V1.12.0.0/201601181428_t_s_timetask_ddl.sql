/*t_s_timetask.IP_Filter comment ALL*/
ALTER TABLE t_s_timetask CHANGE COLUMN IP_Filter IP_Filter VARCHAR(50) NULL DEFAULT NULL COMMENT '任务启动IP地址过滤,ALL表示不指定特定IP';