/*
select substr(rownum||'1130402889f8476650de01476666acbf',0,32) as id,
p.provincename as province,p.provincecode as provincecode,
c.cityname as city,c.citycode as citycode,
d.districtname as county,d.districtcode as countycode 
from utiadminprovince p,utiadmincity c,utiadmindistrict d
where p.provincecode=c.provincecode and c.citycode=d.citycode
and provincename='�Ĵ�ʡ' and c.cityname not in ('���β���������','���Ӳ���Ǽ��������','��ɽ����������')
order by p.provincecode,c.citycode,d.districtcode;
*/

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('11130402889f8476650de01476666acb', '�Ĵ�ʡ', '510000', '�ɶ���', '510100', '������', '510104');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('21130402889f8476650de01476666acb', '�Ĵ�ʡ', '510000', '�ɶ���', '510100', '������', '510105');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('31130402889f8476650de01476666acb', '�Ĵ�ʡ', '510000', '�ɶ���', '510100', '��ţ��', '510106');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('41130402889f8476650de01476666acb', '�Ĵ�ʡ', '510000', '�ɶ���', '510100', '�����', '510107');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('51130402889f8476650de01476666acb', '�Ĵ�ʡ', '510000', '�ɶ���', '510100', '�ɻ���', '510108');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('61130402889f8476650de01476666acb', '�Ĵ�ʡ', '510000', '�ɶ���', '510100', '��Ȫ����', '510112');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('71130402889f8476650de01476666acb', '�Ĵ�ʡ', '510000', '�ɶ���', '510100', '��׽���', '510113');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('81130402889f8476650de01476666acb', '�Ĵ�ʡ', '510000', '�ɶ���', '510100', '�¶���', '510114');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('91130402889f8476650de01476666acb', '�Ĵ�ʡ', '510000', '�ɶ���', '510100', '�½���', '510115');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('101130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '�ɶ���', '510100', '������', '510121');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('111130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '�ɶ���', '510100', '˫����', '510122');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('121130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '�ɶ���', '510100', 'ۯ��', '510124');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('131130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '�ɶ���', '510100', '������', '510129');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('141130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '�ɶ���', '510100', '�ѽ���', '510131');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('151130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '�ɶ���', '510100', '�½���', '510132');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('161130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '�ɶ���', '510100', '��������', '510181');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('171130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '�ɶ���', '510100', '������', '510182');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('181130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '�ɶ���', '510100', '������', '510183');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('191130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '�ɶ���', '510100', '������', '510184');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('201130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '�Թ���', '510300', '��������', '510302');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('211130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '�Թ���', '510300', '������', '510303');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('221130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '�Թ���', '510300', '����', '510304');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('231130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '�Թ���', '510300', '��̲��', '510311');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('241130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '�Թ���', '510300', '����', '510321');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('251130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '�Թ���', '510300', '��˳��', '510322');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('261130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '��֦����', '510400', '����', '510402');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('271130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '��֦����', '510400', '����', '510403');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('281130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '��֦����', '510400', '�ʺ���', '510411');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('291130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '��֦����', '510400', '������', '510421');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('301130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '��֦����', '510400', '�α���', '510422');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('311130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '������', '510500', '������', '510502');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('321130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '������', '510500', '��Ϫ��', '510503');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('331130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '������', '510500', '����̶��', '510504');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('341130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '������', '510500', '����', '510521');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('351130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '������', '510500', '�Ͻ���', '510522');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('361130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '������', '510500', '������', '510524');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('371130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '������', '510500', '������', '510525');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('381130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '������', '510600', '�����', '510603');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('391130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '������', '510600', '�н���', '510623');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('401130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '������', '510600', '�޽���', '510626');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('411130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '������', '510600', '�㺺��', '510681');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('421130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '������', '510600', 'ʲ����', '510682');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('431130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '������', '510600', '������', '510683');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('441130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '������', '510700', '������', '510703');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('451130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '������', '510700', '������', '510704');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('461130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '������', '510700', '��̨��', '510722');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('471130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '������', '510700', '��ͤ��', '510723');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('481130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '������', '510700', '����', '510724');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('491130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '������', '510700', '������', '510725');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('501130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '������', '510700', '����Ǽ��������', '510726');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('511130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '������', '510700', 'ƽ����', '510727');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('521130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '������', '510700', '������', '510781');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('531130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '��Ԫ��', '510800', '������', '510802');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('541130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '��Ԫ��', '510800', 'Ԫ����', '510811');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('551130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '��Ԫ��', '510800', '������', '510812');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('561130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '��Ԫ��', '510800', '������', '510821');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('571130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '��Ԫ��', '510800', '�ന��', '510822');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('581130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '��Ԫ��', '510800', '������', '510823');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('591130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '��Ԫ��', '510800', '��Ϫ��', '510824');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('601130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '������', '510900', '��ɽ��', '510903');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('611130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '������', '510900', '������', '510904');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('621130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '������', '510900', '��Ϫ��', '510921');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('631130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '������', '510900', '�����', '510922');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('641130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '������', '510900', '��Ӣ��', '510923');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('651130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '�ڽ���', '511000', '������', '511002');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('661130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '�ڽ���', '511000', '������', '511011');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('671130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '�ڽ���', '511000', '��Զ��', '511024');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('681130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '�ڽ���', '511000', '������', '511025');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('691130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '�ڽ���', '511000', '¡����', '511028');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('701130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '��ɽ��', '511100', '������', '511102');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('711130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '��ɽ��', '511100', 'ɳ����', '511111');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('721130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '��ɽ��', '511100', '��ͨ����', '511112');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('731130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '��ɽ��', '511100', '��ں���', '511113');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('741130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '��ɽ��', '511100', '��Ϊ��', '511123');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('751130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '��ɽ��', '511100', '������', '511124');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('761130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '��ɽ��', '511100', '�н���', '511126');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('771130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '��ɽ��', '511100', '�崨��', '511129');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('781130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '��ɽ��', '511100', '�������������', '511132');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('791130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '��ɽ��', '511100', '�������������', '511133');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('801130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '��ɽ��', '511100', '��üɽ��', '511181');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('811130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '�ϳ���', '511300', '˳����', '511302');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('821130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '�ϳ���', '511300', '��ƺ��', '511303');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('831130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '�ϳ���', '511300', '������', '511304');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('841130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '�ϳ���', '511300', '�ϲ���', '511321');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('851130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '�ϳ���', '511300', 'Ӫɽ��', '511322');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('861130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '�ϳ���', '511300', '���', '511323');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('871130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '�ϳ���', '511300', '��¤��', '511324');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('881130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '�ϳ���', '511300', '������', '511325');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('891130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '�ϳ���', '511300', '������', '511381');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('901130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', 'üɽ��', '511400', '������', '511402');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('911130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', 'üɽ��', '511400', '������', '511421');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('921130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', 'üɽ��', '511400', '��ɽ��', '511422');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('931130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', 'üɽ��', '511400', '������', '511423');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('941130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', 'üɽ��', '511400', '������', '511424');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('951130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', 'üɽ��', '511400', '������', '511425');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('961130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '�˱���', '511500', '������', '511502');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('971130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '�˱���', '511500', '��Ϫ��', '511503');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('981130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '�˱���', '511500', '�˱���', '511521');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('991130402889f8476650de01476666ac', '�Ĵ�ʡ', '510000', '�˱���', '511500', '������', '511523');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1001130402889f8476650de01476666a', '�Ĵ�ʡ', '510000', '�˱���', '511500', '������', '511524');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1011130402889f8476650de01476666a', '�Ĵ�ʡ', '510000', '�˱���', '511500', '����', '511525');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1021130402889f8476650de01476666a', '�Ĵ�ʡ', '510000', '�˱���', '511500', '����', '511526');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1031130402889f8476650de01476666a', '�Ĵ�ʡ', '510000', '�˱���', '511500', '������', '511527');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1041130402889f8476650de01476666a', '�Ĵ�ʡ', '510000', '�˱���', '511500', '������', '511528');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1051130402889f8476650de01476666a', '�Ĵ�ʡ', '510000', '�˱���', '511500', '��ɽ��', '511529');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1061130402889f8476650de01476666a', '�Ĵ�ʡ', '510000', '�㰲��', '511600', '�㰲��', '511602');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1071130402889f8476650de01476666a', '�Ĵ�ʡ', '510000', '�㰲��', '511600', '������', '511621');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1081130402889f8476650de01476666a', '�Ĵ�ʡ', '510000', '�㰲��', '511600', '��ʤ��', '511622');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1091130402889f8476650de01476666a', '�Ĵ�ʡ', '510000', '�㰲��', '511600', '��ˮ��', '511623');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1101130402889f8476650de01476666a', '�Ĵ�ʡ', '510000', '�㰲��', '511600', '������', '511681');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1111130402889f8476650de01476666a', '�Ĵ�ʡ', '510000', '������', '511700', 'ͨ����', '511702');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1121130402889f8476650de01476666a', '�Ĵ�ʡ', '510000', '������', '511700', '����', '511721');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1131130402889f8476650de01476666a', '�Ĵ�ʡ', '510000', '������', '511700', '������', '511722');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1141130402889f8476650de01476666a', '�Ĵ�ʡ', '510000', '������', '511700', '������', '511723');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1151130402889f8476650de01476666a', '�Ĵ�ʡ', '510000', '������', '511700', '������', '511724');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1161130402889f8476650de01476666a', '�Ĵ�ʡ', '510000', '������', '511700', '����', '511725');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1171130402889f8476650de01476666a', '�Ĵ�ʡ', '510000', '������', '511700', '��Դ��', '511781');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1181130402889f8476650de01476666a', '�Ĵ�ʡ', '510000', '�Ű���', '511800', '�����', '511802');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1191130402889f8476650de01476666a', '�Ĵ�ʡ', '510000', '�Ű���', '511800', '��ɽ��', '511803');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1201130402889f8476650de01476666a', '�Ĵ�ʡ', '510000', '�Ű���', '511800', '������', '511822');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1211130402889f8476650de01476666a', '�Ĵ�ʡ', '510000', '�Ű���', '511800', '��Դ��', '511823');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1221130402889f8476650de01476666a', '�Ĵ�ʡ', '510000', '�Ű���', '511800', 'ʯ����', '511824');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1231130402889f8476650de01476666a', '�Ĵ�ʡ', '510000', '�Ű���', '511800', '��ȫ��', '511825');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1241130402889f8476650de01476666a', '�Ĵ�ʡ', '510000', '�Ű���', '511800', '«ɽ��', '511826');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1251130402889f8476650de01476666a', '�Ĵ�ʡ', '510000', '�Ű���', '511800', '������', '511827');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1261130402889f8476650de01476666a', '�Ĵ�ʡ', '510000', '������', '511900', '������', '511902');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1271130402889f8476650de01476666a', '�Ĵ�ʡ', '510000', '������', '511900', 'ͨ����', '511921');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1281130402889f8476650de01476666a', '�Ĵ�ʡ', '510000', '������', '511900', '�Ͻ���', '511922');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1291130402889f8476650de01476666a', '�Ĵ�ʡ', '510000', '������', '511900', 'ƽ����', '511923');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1301130402889f8476650de01476666a', '�Ĵ�ʡ', '510000', '������', '512000', '�㽭��', '512002');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1311130402889f8476650de01476666a', '�Ĵ�ʡ', '510000', '������', '512000', '������', '512021');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1321130402889f8476650de01476666a', '�Ĵ�ʡ', '510000', '������', '512000', '������', '512022');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1331130402889f8476650de01476666a', '�Ĵ�ʡ', '510000', '������', '512000', '������', '512081');


