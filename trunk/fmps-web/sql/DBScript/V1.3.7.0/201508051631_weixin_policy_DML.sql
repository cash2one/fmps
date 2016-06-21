UPDATE weixin_policy a INNER JOIN weixin_policy b ON a.id=b.id
SET a.startdate=(date_format(a.startdate,'%Y-%m-%d 00:00:00'))


UPDATE weixin_policy a INNER JOIN weixin_policy b ON a.id=b.id
SET a.enddate=(date_format(b.enddate,'%Y-%m-%d 23:59:59'))