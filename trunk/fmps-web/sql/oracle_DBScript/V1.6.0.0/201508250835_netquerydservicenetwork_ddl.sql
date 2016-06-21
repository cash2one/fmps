/*加字段网点代码:*/
alter table query2.netquerydservicenetwork add (networkid varchar2(10));
comment on column query2.netquerydservicenetwork.networkid is '网点代码,参考核心代码';

/*加字段网点层级:*/
alter table query2.netquerydservicenetwork add (networklevel varchar2(1));
comment on column query2.netquerydservicenetwork.networklevel is '网点层级';
