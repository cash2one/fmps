/*
用户: query2
库: OFFWEBDBP

*/

/*修改字段customercode为identifynumber*/
alter table weixin_top_prem_ranking rename column customercode to identifynumber;
comment on column weixin_top_prem_ranking.identifynumber is '证件号码';