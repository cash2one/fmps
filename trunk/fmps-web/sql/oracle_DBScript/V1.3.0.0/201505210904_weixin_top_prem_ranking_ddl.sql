/*
�û�: query2
��: OFFWEBDBP

*/

/*�޸��ֶ�customercodeΪidentifynumber*/
alter table weixin_top_prem_ranking rename column customercode to identifynumber;
comment on column weixin_top_prem_ranking.identifynumber is '֤������';