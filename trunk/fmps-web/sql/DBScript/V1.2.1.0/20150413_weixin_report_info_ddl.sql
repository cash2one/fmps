alter table weixin_report_info
    add kindName varchar(800) DEFAULT NULL COMMENT '险别信息';
alter table weixin_report_info
    add carModel varchar(200) DEFAULT NULL COMMENT '车型;车架号;发动机号';