create or replace view weixin_policy_report_view as 
select po.policyno, po.`status` as policyStatus, nt.total_fee/100 as totalFee, cu.name as insuredName, cu.identifynumber, cu.address, 
cu.phone, cu.school, po.premium, po.createtime, gz.nickname, gz.openid
from weixin_customer cu,weixin_policy_insured_identity pii,weixin_gzuserinfo gz,weixin_policy po
left join weixin_unifiedorder der on po.orderno = der.userPayCode
left join weixin_notify nt on der.out_trade_no = nt.out_trade_no
where po.policyno = pii.policyno and pii.customerid = cu.id and po.openid = gz.openid;