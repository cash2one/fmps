/*���ֶ��������:*/
alter table query2.netquerydservicenetwork add (networkid varchar2(10));
comment on column query2.netquerydservicenetwork.networkid is '�������,�ο����Ĵ���';

/*���ֶ�����㼶:*/
alter table query2.netquerydservicenetwork add (networklevel varchar2(1));
comment on column query2.netquerydservicenetwork.networklevel is '����㼶';
