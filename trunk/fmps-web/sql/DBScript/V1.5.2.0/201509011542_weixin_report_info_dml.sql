update weixin_report_info set confirmStyle=3  where claimCaseFee is null and caseStatus='110' and reportDate <'2015-06-25' ;