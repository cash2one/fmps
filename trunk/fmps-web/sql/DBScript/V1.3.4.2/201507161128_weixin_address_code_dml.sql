/*
select substr(rownum||'1130402889f8476650de01476666acbf',0,32) as id,
p.provincename as province,p.provincecode as provincecode,
c.cityname as city,c.citycode as citycode,
d.districtname as county,d.districtcode as countycode 
from utiadminprovince p,utiadmincity c,utiadmindistrict d
where p.provincecode=c.provincecode and c.citycode=d.citycode
and provincename='四川省' and c.cityname not in ('甘孜藏族自治州','阿坝藏族羌族自治州','凉山彝族自治州')
order by p.provincecode,c.citycode,d.districtcode;
*/

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('11130402889f8476650de01476666acb', '四川省', '510000', '成都市', '510100', '锦江区', '510104');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('21130402889f8476650de01476666acb', '四川省', '510000', '成都市', '510100', '青羊区', '510105');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('31130402889f8476650de01476666acb', '四川省', '510000', '成都市', '510100', '金牛区', '510106');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('41130402889f8476650de01476666acb', '四川省', '510000', '成都市', '510100', '武侯区', '510107');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('51130402889f8476650de01476666acb', '四川省', '510000', '成都市', '510100', '成华区', '510108');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('61130402889f8476650de01476666acb', '四川省', '510000', '成都市', '510100', '龙泉驿区', '510112');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('71130402889f8476650de01476666acb', '四川省', '510000', '成都市', '510100', '青白江区', '510113');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('81130402889f8476650de01476666acb', '四川省', '510000', '成都市', '510100', '新都区', '510114');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('91130402889f8476650de01476666acb', '四川省', '510000', '成都市', '510100', '温江区', '510115');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('101130402889f8476650de01476666ac', '四川省', '510000', '成都市', '510100', '金堂县', '510121');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('111130402889f8476650de01476666ac', '四川省', '510000', '成都市', '510100', '双流县', '510122');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('121130402889f8476650de01476666ac', '四川省', '510000', '成都市', '510100', '郫县', '510124');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('131130402889f8476650de01476666ac', '四川省', '510000', '成都市', '510100', '大邑县', '510129');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('141130402889f8476650de01476666ac', '四川省', '510000', '成都市', '510100', '蒲江县', '510131');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('151130402889f8476650de01476666ac', '四川省', '510000', '成都市', '510100', '新津县', '510132');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('161130402889f8476650de01476666ac', '四川省', '510000', '成都市', '510100', '都江堰市', '510181');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('171130402889f8476650de01476666ac', '四川省', '510000', '成都市', '510100', '彭州市', '510182');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('181130402889f8476650de01476666ac', '四川省', '510000', '成都市', '510100', '邛崃市', '510183');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('191130402889f8476650de01476666ac', '四川省', '510000', '成都市', '510100', '崇州市', '510184');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('201130402889f8476650de01476666ac', '四川省', '510000', '自贡市', '510300', '自流井区', '510302');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('211130402889f8476650de01476666ac', '四川省', '510000', '自贡市', '510300', '贡井区', '510303');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('221130402889f8476650de01476666ac', '四川省', '510000', '自贡市', '510300', '大安区', '510304');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('231130402889f8476650de01476666ac', '四川省', '510000', '自贡市', '510300', '沿滩区', '510311');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('241130402889f8476650de01476666ac', '四川省', '510000', '自贡市', '510300', '荣县', '510321');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('251130402889f8476650de01476666ac', '四川省', '510000', '自贡市', '510300', '富顺县', '510322');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('261130402889f8476650de01476666ac', '四川省', '510000', '攀枝花市', '510400', '东区', '510402');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('271130402889f8476650de01476666ac', '四川省', '510000', '攀枝花市', '510400', '西区', '510403');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('281130402889f8476650de01476666ac', '四川省', '510000', '攀枝花市', '510400', '仁和区', '510411');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('291130402889f8476650de01476666ac', '四川省', '510000', '攀枝花市', '510400', '米易县', '510421');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('301130402889f8476650de01476666ac', '四川省', '510000', '攀枝花市', '510400', '盐边县', '510422');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('311130402889f8476650de01476666ac', '四川省', '510000', '泸州市', '510500', '江阳区', '510502');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('321130402889f8476650de01476666ac', '四川省', '510000', '泸州市', '510500', '纳溪区', '510503');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('331130402889f8476650de01476666ac', '四川省', '510000', '泸州市', '510500', '龙马潭区', '510504');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('341130402889f8476650de01476666ac', '四川省', '510000', '泸州市', '510500', '泸县', '510521');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('351130402889f8476650de01476666ac', '四川省', '510000', '泸州市', '510500', '合江县', '510522');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('361130402889f8476650de01476666ac', '四川省', '510000', '泸州市', '510500', '叙永县', '510524');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('371130402889f8476650de01476666ac', '四川省', '510000', '泸州市', '510500', '古蔺县', '510525');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('381130402889f8476650de01476666ac', '四川省', '510000', '德阳市', '510600', '旌阳区', '510603');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('391130402889f8476650de01476666ac', '四川省', '510000', '德阳市', '510600', '中江县', '510623');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('401130402889f8476650de01476666ac', '四川省', '510000', '德阳市', '510600', '罗江县', '510626');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('411130402889f8476650de01476666ac', '四川省', '510000', '德阳市', '510600', '广汉市', '510681');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('421130402889f8476650de01476666ac', '四川省', '510000', '德阳市', '510600', '什邡市', '510682');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('431130402889f8476650de01476666ac', '四川省', '510000', '德阳市', '510600', '绵竹市', '510683');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('441130402889f8476650de01476666ac', '四川省', '510000', '绵阳市', '510700', '涪城区', '510703');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('451130402889f8476650de01476666ac', '四川省', '510000', '绵阳市', '510700', '游仙区', '510704');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('461130402889f8476650de01476666ac', '四川省', '510000', '绵阳市', '510700', '三台县', '510722');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('471130402889f8476650de01476666ac', '四川省', '510000', '绵阳市', '510700', '盐亭县', '510723');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('481130402889f8476650de01476666ac', '四川省', '510000', '绵阳市', '510700', '安县', '510724');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('491130402889f8476650de01476666ac', '四川省', '510000', '绵阳市', '510700', '梓潼县', '510725');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('501130402889f8476650de01476666ac', '四川省', '510000', '绵阳市', '510700', '北川羌族自治县', '510726');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('511130402889f8476650de01476666ac', '四川省', '510000', '绵阳市', '510700', '平武县', '510727');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('521130402889f8476650de01476666ac', '四川省', '510000', '绵阳市', '510700', '江油市', '510781');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('531130402889f8476650de01476666ac', '四川省', '510000', '广元市', '510800', '利州区', '510802');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('541130402889f8476650de01476666ac', '四川省', '510000', '广元市', '510800', '元坝区', '510811');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('551130402889f8476650de01476666ac', '四川省', '510000', '广元市', '510800', '朝天区', '510812');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('561130402889f8476650de01476666ac', '四川省', '510000', '广元市', '510800', '旺苍县', '510821');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('571130402889f8476650de01476666ac', '四川省', '510000', '广元市', '510800', '青川县', '510822');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('581130402889f8476650de01476666ac', '四川省', '510000', '广元市', '510800', '剑阁县', '510823');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('591130402889f8476650de01476666ac', '四川省', '510000', '广元市', '510800', '苍溪县', '510824');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('601130402889f8476650de01476666ac', '四川省', '510000', '遂宁市', '510900', '船山区', '510903');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('611130402889f8476650de01476666ac', '四川省', '510000', '遂宁市', '510900', '安居区', '510904');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('621130402889f8476650de01476666ac', '四川省', '510000', '遂宁市', '510900', '蓬溪县', '510921');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('631130402889f8476650de01476666ac', '四川省', '510000', '遂宁市', '510900', '射洪县', '510922');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('641130402889f8476650de01476666ac', '四川省', '510000', '遂宁市', '510900', '大英县', '510923');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('651130402889f8476650de01476666ac', '四川省', '510000', '内江市', '511000', '市中区', '511002');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('661130402889f8476650de01476666ac', '四川省', '510000', '内江市', '511000', '东兴区', '511011');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('671130402889f8476650de01476666ac', '四川省', '510000', '内江市', '511000', '威远县', '511024');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('681130402889f8476650de01476666ac', '四川省', '510000', '内江市', '511000', '资中县', '511025');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('691130402889f8476650de01476666ac', '四川省', '510000', '内江市', '511000', '隆昌县', '511028');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('701130402889f8476650de01476666ac', '四川省', '510000', '乐山市', '511100', '市中区', '511102');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('711130402889f8476650de01476666ac', '四川省', '510000', '乐山市', '511100', '沙湾区', '511111');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('721130402889f8476650de01476666ac', '四川省', '510000', '乐山市', '511100', '五通桥区', '511112');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('731130402889f8476650de01476666ac', '四川省', '510000', '乐山市', '511100', '金口河区', '511113');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('741130402889f8476650de01476666ac', '四川省', '510000', '乐山市', '511100', '犍为县', '511123');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('751130402889f8476650de01476666ac', '四川省', '510000', '乐山市', '511100', '井研县', '511124');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('761130402889f8476650de01476666ac', '四川省', '510000', '乐山市', '511100', '夹江县', '511126');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('771130402889f8476650de01476666ac', '四川省', '510000', '乐山市', '511100', '沐川县', '511129');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('781130402889f8476650de01476666ac', '四川省', '510000', '乐山市', '511100', '峨边彝族自治县', '511132');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('791130402889f8476650de01476666ac', '四川省', '510000', '乐山市', '511100', '马边彝族自治县', '511133');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('801130402889f8476650de01476666ac', '四川省', '510000', '乐山市', '511100', '峨眉山市', '511181');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('811130402889f8476650de01476666ac', '四川省', '510000', '南充市', '511300', '顺庆区', '511302');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('821130402889f8476650de01476666ac', '四川省', '510000', '南充市', '511300', '高坪区', '511303');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('831130402889f8476650de01476666ac', '四川省', '510000', '南充市', '511300', '嘉陵区', '511304');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('841130402889f8476650de01476666ac', '四川省', '510000', '南充市', '511300', '南部县', '511321');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('851130402889f8476650de01476666ac', '四川省', '510000', '南充市', '511300', '营山县', '511322');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('861130402889f8476650de01476666ac', '四川省', '510000', '南充市', '511300', '蓬安县', '511323');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('871130402889f8476650de01476666ac', '四川省', '510000', '南充市', '511300', '仪陇县', '511324');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('881130402889f8476650de01476666ac', '四川省', '510000', '南充市', '511300', '西充县', '511325');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('891130402889f8476650de01476666ac', '四川省', '510000', '南充市', '511300', '阆中市', '511381');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('901130402889f8476650de01476666ac', '四川省', '510000', '眉山市', '511400', '东坡区', '511402');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('911130402889f8476650de01476666ac', '四川省', '510000', '眉山市', '511400', '仁寿县', '511421');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('921130402889f8476650de01476666ac', '四川省', '510000', '眉山市', '511400', '彭山县', '511422');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('931130402889f8476650de01476666ac', '四川省', '510000', '眉山市', '511400', '洪雅县', '511423');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('941130402889f8476650de01476666ac', '四川省', '510000', '眉山市', '511400', '丹棱县', '511424');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('951130402889f8476650de01476666ac', '四川省', '510000', '眉山市', '511400', '青神县', '511425');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('961130402889f8476650de01476666ac', '四川省', '510000', '宜宾市', '511500', '翠屏区', '511502');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('971130402889f8476650de01476666ac', '四川省', '510000', '宜宾市', '511500', '南溪区', '511503');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('981130402889f8476650de01476666ac', '四川省', '510000', '宜宾市', '511500', '宜宾县', '511521');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('991130402889f8476650de01476666ac', '四川省', '510000', '宜宾市', '511500', '江安县', '511523');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1001130402889f8476650de01476666a', '四川省', '510000', '宜宾市', '511500', '长宁县', '511524');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1011130402889f8476650de01476666a', '四川省', '510000', '宜宾市', '511500', '高县', '511525');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1021130402889f8476650de01476666a', '四川省', '510000', '宜宾市', '511500', '珙县', '511526');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1031130402889f8476650de01476666a', '四川省', '510000', '宜宾市', '511500', '筠连县', '511527');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1041130402889f8476650de01476666a', '四川省', '510000', '宜宾市', '511500', '兴文县', '511528');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1051130402889f8476650de01476666a', '四川省', '510000', '宜宾市', '511500', '屏山县', '511529');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1061130402889f8476650de01476666a', '四川省', '510000', '广安市', '511600', '广安区', '511602');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1071130402889f8476650de01476666a', '四川省', '510000', '广安市', '511600', '岳池县', '511621');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1081130402889f8476650de01476666a', '四川省', '510000', '广安市', '511600', '武胜县', '511622');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1091130402889f8476650de01476666a', '四川省', '510000', '广安市', '511600', '邻水县', '511623');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1101130402889f8476650de01476666a', '四川省', '510000', '广安市', '511600', '华蓥市', '511681');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1111130402889f8476650de01476666a', '四川省', '510000', '达州市', '511700', '通川区', '511702');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1121130402889f8476650de01476666a', '四川省', '510000', '达州市', '511700', '达县', '511721');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1131130402889f8476650de01476666a', '四川省', '510000', '达州市', '511700', '宣汉县', '511722');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1141130402889f8476650de01476666a', '四川省', '510000', '达州市', '511700', '开江县', '511723');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1151130402889f8476650de01476666a', '四川省', '510000', '达州市', '511700', '大竹县', '511724');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1161130402889f8476650de01476666a', '四川省', '510000', '达州市', '511700', '渠县', '511725');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1171130402889f8476650de01476666a', '四川省', '510000', '达州市', '511700', '万源市', '511781');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1181130402889f8476650de01476666a', '四川省', '510000', '雅安市', '511800', '雨城区', '511802');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1191130402889f8476650de01476666a', '四川省', '510000', '雅安市', '511800', '名山区', '511803');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1201130402889f8476650de01476666a', '四川省', '510000', '雅安市', '511800', '荥经县', '511822');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1211130402889f8476650de01476666a', '四川省', '510000', '雅安市', '511800', '汉源县', '511823');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1221130402889f8476650de01476666a', '四川省', '510000', '雅安市', '511800', '石棉县', '511824');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1231130402889f8476650de01476666a', '四川省', '510000', '雅安市', '511800', '天全县', '511825');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1241130402889f8476650de01476666a', '四川省', '510000', '雅安市', '511800', '芦山县', '511826');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1251130402889f8476650de01476666a', '四川省', '510000', '雅安市', '511800', '宝兴县', '511827');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1261130402889f8476650de01476666a', '四川省', '510000', '巴中市', '511900', '巴州区', '511902');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1271130402889f8476650de01476666a', '四川省', '510000', '巴中市', '511900', '通江县', '511921');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1281130402889f8476650de01476666a', '四川省', '510000', '巴中市', '511900', '南江县', '511922');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1291130402889f8476650de01476666a', '四川省', '510000', '巴中市', '511900', '平昌县', '511923');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1301130402889f8476650de01476666a', '四川省', '510000', '资阳市', '512000', '雁江区', '512002');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1311130402889f8476650de01476666a', '四川省', '510000', '资阳市', '512000', '安岳县', '512021');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1321130402889f8476650de01476666a', '四川省', '510000', '资阳市', '512000', '乐至县', '512022');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1331130402889f8476650de01476666a', '四川省', '510000', '资阳市', '512000', '简阳市', '512081');


