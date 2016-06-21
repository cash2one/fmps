/*ecomm_netqueryinsured 历史数据处理 删除注销，全单退保且生效日期小时等于起保日期小时的保单 */
delete from ecomm_netqueryinsured i
where 
exists
 (select 1
          from netqueryphead h,netquerycmain m
         where h.policyno = i.policyno and h.policyno = m.policyno
           and (h.endortype = '19' or
               (h.endortype = '21' and h.validdate = m.startdate and
               h.validhour = m.starthour)))
;