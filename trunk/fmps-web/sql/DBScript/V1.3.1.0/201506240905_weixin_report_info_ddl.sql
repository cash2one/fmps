/*weixin_report_info���ֶ�claimCaseFee*/
alter table weixin_report_info
    add claimCaseFee varchar(10) DEFAULT NULL COMMENT '������';

/*weixin_report_info���ֶ�createTime*/
alter table weixin_report_info
    add createTime timestamp NULL DEFAULT NULL COMMENT '����ʱ��';