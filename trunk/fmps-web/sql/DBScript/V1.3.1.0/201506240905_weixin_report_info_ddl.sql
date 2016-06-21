/*weixin_report_info加字段claimCaseFee*/
alter table weixin_report_info
    add claimCaseFee varchar(10) DEFAULT NULL COMMENT '理赔金额';

/*weixin_report_info加字段createTime*/
alter table weixin_report_info
    add createTime timestamp NULL DEFAULT NULL COMMENT '新增时间';