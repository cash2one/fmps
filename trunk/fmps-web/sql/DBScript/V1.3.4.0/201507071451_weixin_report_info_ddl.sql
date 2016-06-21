/*理赔金额该成decimal(20,2)*/
alter table weixin_report_info modify column claimCaseFee decimal(20,2) comment '理赔金额';
