/* 金额小于10的案件状态修改为112 */
update weixin_report_info set caseStatus='112' where claimCaseFee < 10;

