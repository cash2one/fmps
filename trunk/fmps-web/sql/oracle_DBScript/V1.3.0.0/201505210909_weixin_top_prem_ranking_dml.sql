/*
�û�: query2
��: OFFWEBDBP

*/

/*weixin_top_prem_ranking����ԭcustomercode��Ӧ��֤������*/
update weixin_top_prem_ranking o
   set o.identifynumber =
       (select distinct r.identifynumber
          from netqueryinsured r
         where r.insuredcode = o.identifynumber
           and r.identifynumber is not null)