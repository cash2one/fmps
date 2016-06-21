/*
用户: query2
库: OFFWEBDBP

*/

/*weixin_top_prem_ranking更新原customercode对应的证件号码*/
update weixin_top_prem_ranking o
   set o.identifynumber =
       (select distinct r.identifynumber
          from netqueryinsured r
         where r.insuredcode = o.identifynumber
           and r.identifynumber is not null)