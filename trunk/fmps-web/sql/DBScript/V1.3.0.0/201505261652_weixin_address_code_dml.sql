
/*从ORACLE导数据*/
/*
select substr(rownum || '402889f8476650de01476666acbf0005',0,32) as id,
p.provincename as province,p.provincecode as provincecode,
c.cityname as city,c.citycode as citycode,
d.districtname as county,d.districtcode as countycode
 from utiadminprovince p,
utiadmincity c,utiadmindistrict d
where p.provincecode=c.provincecode
and c.citycode=d.citycode
order by p.provincecode,c.citycode,d.districtcode
;
*/

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2207402889f8476650de01476666acbf', '北京市', '110000', '北京市', '110000', '东城区', '110101');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2208402889f8476650de01476666acbf', '北京市', '110000', '北京市', '110000', '西城区', '110102');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2209402889f8476650de01476666acbf', '北京市', '110000', '北京市', '110000', '朝阳区', '110105');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2210402889f8476650de01476666acbf', '北京市', '110000', '北京市', '110000', '丰台区', '110106');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2211402889f8476650de01476666acbf', '北京市', '110000', '北京市', '110000', '石景山区', '110107');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2212402889f8476650de01476666acbf', '北京市', '110000', '北京市', '110000', '海淀区', '110108');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2213402889f8476650de01476666acbf', '北京市', '110000', '北京市', '110000', '门头沟区', '110109');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2214402889f8476650de01476666acbf', '北京市', '110000', '北京市', '110000', '房山区', '110111');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2215402889f8476650de01476666acbf', '北京市', '110000', '北京市', '110000', '通州区', '110112');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2216402889f8476650de01476666acbf', '北京市', '110000', '北京市', '110000', '顺义区', '110113');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2217402889f8476650de01476666acbf', '北京市', '110000', '北京市', '110000', '昌平区', '110114');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2218402889f8476650de01476666acbf', '北京市', '110000', '北京市', '110000', '大兴区', '110115');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2219402889f8476650de01476666acbf', '北京市', '110000', '北京市', '110000', '怀柔区', '110116');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2220402889f8476650de01476666acbf', '北京市', '110000', '北京市', '110000', '平谷区', '110117');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2221402889f8476650de01476666acbf', '北京市', '110000', '北京市', '110000', '密云县', '110228');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2222402889f8476650de01476666acbf', '北京市', '110000', '北京市', '110000', '延庆县', '110229');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2223402889f8476650de01476666acbf', '天津市', '120000', '天津市', '120000', '和平区', '120101');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2224402889f8476650de01476666acbf', '天津市', '120000', '天津市', '120000', '河东区', '120102');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2225402889f8476650de01476666acbf', '天津市', '120000', '天津市', '120000', '河西区', '120103');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2226402889f8476650de01476666acbf', '天津市', '120000', '天津市', '120000', '南开区', '120104');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2227402889f8476650de01476666acbf', '天津市', '120000', '天津市', '120000', '河北区', '120105');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2228402889f8476650de01476666acbf', '天津市', '120000', '天津市', '120000', '红桥区', '120106');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2229402889f8476650de01476666acbf', '天津市', '120000', '天津市', '120000', '东丽区', '120110');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2230402889f8476650de01476666acbf', '天津市', '120000', '天津市', '120000', '西青区', '120111');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2231402889f8476650de01476666acbf', '天津市', '120000', '天津市', '120000', '津南区', '120112');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2232402889f8476650de01476666acbf', '天津市', '120000', '天津市', '120000', '北辰区', '120113');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2233402889f8476650de01476666acbf', '天津市', '120000', '天津市', '120000', '武清区', '120114');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2234402889f8476650de01476666acbf', '天津市', '120000', '天津市', '120000', '宝坻区', '120115');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2235402889f8476650de01476666acbf', '天津市', '120000', '天津市', '120000', '滨海新区', '120116');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2236402889f8476650de01476666acbf', '天津市', '120000', '天津市', '120000', '宁河县', '120221');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2237402889f8476650de01476666acbf', '天津市', '120000', '天津市', '120000', '静海县', '120223');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2238402889f8476650de01476666acbf', '天津市', '120000', '天津市', '120000', '蓟县', '120225');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2239402889f8476650de01476666acbf', '河北省', '130000', '石家庄市', '130100', '长安区', '130102');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2240402889f8476650de01476666acbf', '河北省', '130000', '石家庄市', '130100', '桥东区', '130103');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2241402889f8476650de01476666acbf', '河北省', '130000', '石家庄市', '130100', '桥西区', '130104');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2242402889f8476650de01476666acbf', '河北省', '130000', '石家庄市', '130100', '新华区', '130105');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2243402889f8476650de01476666acbf', '河北省', '130000', '石家庄市', '130100', '井陉矿区', '130107');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2244402889f8476650de01476666acbf', '河北省', '130000', '石家庄市', '130100', '裕华区', '130108');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2245402889f8476650de01476666acbf', '河北省', '130000', '石家庄市', '130100', '井陉县', '130121');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2246402889f8476650de01476666acbf', '河北省', '130000', '石家庄市', '130100', '正定县', '130123');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2247402889f8476650de01476666acbf', '河北省', '130000', '石家庄市', '130100', '栾城县', '130124');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2248402889f8476650de01476666acbf', '河北省', '130000', '石家庄市', '130100', '行唐县', '130125');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2249402889f8476650de01476666acbf', '河北省', '130000', '石家庄市', '130100', '灵寿县', '130126');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2250402889f8476650de01476666acbf', '河北省', '130000', '石家庄市', '130100', '高邑县', '130127');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2251402889f8476650de01476666acbf', '河北省', '130000', '石家庄市', '130100', '深泽县', '130128');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2252402889f8476650de01476666acbf', '河北省', '130000', '石家庄市', '130100', '赞皇县', '130129');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2253402889f8476650de01476666acbf', '河北省', '130000', '石家庄市', '130100', '无极县', '130130');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2254402889f8476650de01476666acbf', '河北省', '130000', '石家庄市', '130100', '平山县', '130131');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2255402889f8476650de01476666acbf', '河北省', '130000', '石家庄市', '130100', '元氏县', '130132');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2256402889f8476650de01476666acbf', '河北省', '130000', '石家庄市', '130100', '赵县', '130133');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2257402889f8476650de01476666acbf', '河北省', '130000', '石家庄市', '130100', '辛集市', '130181');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2258402889f8476650de01476666acbf', '河北省', '130000', '石家庄市', '130100', '藁城市', '130182');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2259402889f8476650de01476666acbf', '河北省', '130000', '石家庄市', '130100', '晋州市', '130183');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2260402889f8476650de01476666acbf', '河北省', '130000', '石家庄市', '130100', '新乐市', '130184');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2261402889f8476650de01476666acbf', '河北省', '130000', '石家庄市', '130100', '鹿泉市', '130185');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2262402889f8476650de01476666acbf', '河北省', '130000', '唐山市', '130200', '路南区', '130202');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2263402889f8476650de01476666acbf', '河北省', '130000', '唐山市', '130200', '路北区', '130203');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2264402889f8476650de01476666acbf', '河北省', '130000', '唐山市', '130200', '古冶区', '130204');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2265402889f8476650de01476666acbf', '河北省', '130000', '唐山市', '130200', '开平区', '130205');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2266402889f8476650de01476666acbf', '河北省', '130000', '唐山市', '130200', '丰南区', '130207');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2267402889f8476650de01476666acbf', '河北省', '130000', '唐山市', '130200', '丰润区', '130208');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2268402889f8476650de01476666acbf', '河北省', '130000', '唐山市', '130200', '曹妃甸区', '130209');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2269402889f8476650de01476666acbf', '河北省', '130000', '唐山市', '130200', '滦县', '130223');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2270402889f8476650de01476666acbf', '河北省', '130000', '唐山市', '130200', '滦南县', '130224');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2271402889f8476650de01476666acbf', '河北省', '130000', '唐山市', '130200', '乐亭县', '130225');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2272402889f8476650de01476666acbf', '河北省', '130000', '唐山市', '130200', '迁西县', '130227');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2273402889f8476650de01476666acbf', '河北省', '130000', '唐山市', '130200', '玉田县', '130229');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2274402889f8476650de01476666acbf', '河北省', '130000', '唐山市', '130200', '遵化市', '130281');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2275402889f8476650de01476666acbf', '河北省', '130000', '唐山市', '130200', '迁安市', '130283');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2276402889f8476650de01476666acbf', '河北省', '130000', '秦皇岛市', '130300', '海港区', '130302');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2277402889f8476650de01476666acbf', '河北省', '130000', '秦皇岛市', '130300', '山海关区', '130303');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2278402889f8476650de01476666acbf', '河北省', '130000', '秦皇岛市', '130300', '北戴河区', '130304');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2279402889f8476650de01476666acbf', '河北省', '130000', '秦皇岛市', '130300', '青龙满族自治县', '130321');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2280402889f8476650de01476666acbf', '河北省', '130000', '秦皇岛市', '130300', '昌黎县', '130322');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2281402889f8476650de01476666acbf', '河北省', '130000', '秦皇岛市', '130300', '抚宁县', '130323');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2282402889f8476650de01476666acbf', '河北省', '130000', '秦皇岛市', '130300', '卢龙县', '130324');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2283402889f8476650de01476666acbf', '河北省', '130000', '邯郸市', '130400', '邯山区', '130402');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2284402889f8476650de01476666acbf', '河北省', '130000', '邯郸市', '130400', '丛台区', '130403');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2285402889f8476650de01476666acbf', '河北省', '130000', '邯郸市', '130400', '复兴区', '130404');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2286402889f8476650de01476666acbf', '河北省', '130000', '邯郸市', '130400', '峰峰矿区', '130406');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2287402889f8476650de01476666acbf', '河北省', '130000', '邯郸市', '130400', '邯郸县', '130421');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2288402889f8476650de01476666acbf', '河北省', '130000', '邯郸市', '130400', '临漳县', '130423');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2289402889f8476650de01476666acbf', '河北省', '130000', '邯郸市', '130400', '成安县', '130424');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2290402889f8476650de01476666acbf', '河北省', '130000', '邯郸市', '130400', '大名县', '130425');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2291402889f8476650de01476666acbf', '河北省', '130000', '邯郸市', '130400', '涉县', '130426');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2292402889f8476650de01476666acbf', '河北省', '130000', '邯郸市', '130400', '磁县', '130427');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2293402889f8476650de01476666acbf', '河北省', '130000', '邯郸市', '130400', '肥乡县', '130428');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2294402889f8476650de01476666acbf', '河北省', '130000', '邯郸市', '130400', '永年县', '130429');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2295402889f8476650de01476666acbf', '河北省', '130000', '邯郸市', '130400', '邱县', '130430');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2296402889f8476650de01476666acbf', '河北省', '130000', '邯郸市', '130400', '鸡泽县', '130431');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2297402889f8476650de01476666acbf', '河北省', '130000', '邯郸市', '130400', '广平县', '130432');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2298402889f8476650de01476666acbf', '河北省', '130000', '邯郸市', '130400', '馆陶县', '130433');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2299402889f8476650de01476666acbf', '河北省', '130000', '邯郸市', '130400', '魏县', '130434');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2300402889f8476650de01476666acbf', '河北省', '130000', '邯郸市', '130400', '曲周县', '130435');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2301402889f8476650de01476666acbf', '河北省', '130000', '邯郸市', '130400', '武安市', '130481');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2302402889f8476650de01476666acbf', '河北省', '130000', '邢台市', '130500', '桥东区', '130502');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2303402889f8476650de01476666acbf', '河北省', '130000', '邢台市', '130500', '桥西区', '130503');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2304402889f8476650de01476666acbf', '河北省', '130000', '邢台市', '130500', '邢台县', '130521');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2305402889f8476650de01476666acbf', '河北省', '130000', '邢台市', '130500', '临城县', '130522');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2306402889f8476650de01476666acbf', '河北省', '130000', '邢台市', '130500', '内丘县', '130523');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2307402889f8476650de01476666acbf', '河北省', '130000', '邢台市', '130500', '柏乡县', '130524');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2308402889f8476650de01476666acbf', '河北省', '130000', '邢台市', '130500', '隆尧县', '130525');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2309402889f8476650de01476666acbf', '河北省', '130000', '邢台市', '130500', '任县', '130526');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2310402889f8476650de01476666acbf', '河北省', '130000', '邢台市', '130500', '南和县', '130527');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2311402889f8476650de01476666acbf', '河北省', '130000', '邢台市', '130500', '宁晋县', '130528');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2312402889f8476650de01476666acbf', '河北省', '130000', '邢台市', '130500', '巨鹿县', '130529');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2313402889f8476650de01476666acbf', '河北省', '130000', '邢台市', '130500', '新河县', '130530');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2314402889f8476650de01476666acbf', '河北省', '130000', '邢台市', '130500', '广宗县', '130531');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2315402889f8476650de01476666acbf', '河北省', '130000', '邢台市', '130500', '平乡县', '130532');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2316402889f8476650de01476666acbf', '河北省', '130000', '邢台市', '130500', '威县', '130533');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2317402889f8476650de01476666acbf', '河北省', '130000', '邢台市', '130500', '清河县', '130534');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2318402889f8476650de01476666acbf', '河北省', '130000', '邢台市', '130500', '临西县', '130535');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2319402889f8476650de01476666acbf', '河北省', '130000', '邢台市', '130500', '南宫市', '130581');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2320402889f8476650de01476666acbf', '河北省', '130000', '邢台市', '130500', '沙河市', '130582');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2321402889f8476650de01476666acbf', '河北省', '130000', '保定市', '130600', '新市区', '130602');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2322402889f8476650de01476666acbf', '河北省', '130000', '保定市', '130600', '北市区', '130603');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2323402889f8476650de01476666acbf', '河北省', '130000', '保定市', '130600', '南市区', '130604');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2324402889f8476650de01476666acbf', '河北省', '130000', '保定市', '130600', '满城县', '130621');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2325402889f8476650de01476666acbf', '河北省', '130000', '保定市', '130600', '清苑县', '130622');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2326402889f8476650de01476666acbf', '河北省', '130000', '保定市', '130600', '涞水县', '130623');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2327402889f8476650de01476666acbf', '河北省', '130000', '保定市', '130600', '阜平县', '130624');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2328402889f8476650de01476666acbf', '河北省', '130000', '保定市', '130600', '徐水县', '130625');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2329402889f8476650de01476666acbf', '河北省', '130000', '保定市', '130600', '定兴县', '130626');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2330402889f8476650de01476666acbf', '河北省', '130000', '保定市', '130600', '唐县', '130627');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2331402889f8476650de01476666acbf', '河北省', '130000', '保定市', '130600', '高阳县', '130628');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2332402889f8476650de01476666acbf', '河北省', '130000', '保定市', '130600', '容城县', '130629');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2333402889f8476650de01476666acbf', '河北省', '130000', '保定市', '130600', '涞源县', '130630');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2334402889f8476650de01476666acbf', '河北省', '130000', '保定市', '130600', '望都县', '130631');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2335402889f8476650de01476666acbf', '河北省', '130000', '保定市', '130600', '安新县', '130632');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2336402889f8476650de01476666acbf', '河北省', '130000', '保定市', '130600', '易县', '130633');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2337402889f8476650de01476666acbf', '河北省', '130000', '保定市', '130600', '曲阳县', '130634');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2338402889f8476650de01476666acbf', '河北省', '130000', '保定市', '130600', '蠡县', '130635');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2339402889f8476650de01476666acbf', '河北省', '130000', '保定市', '130600', '顺平县', '130636');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2340402889f8476650de01476666acbf', '河北省', '130000', '保定市', '130600', '博野县', '130637');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2341402889f8476650de01476666acbf', '河北省', '130000', '保定市', '130600', '雄县', '130638');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2342402889f8476650de01476666acbf', '河北省', '130000', '保定市', '130600', '涿州市', '130681');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2343402889f8476650de01476666acbf', '河北省', '130000', '保定市', '130600', '定州市', '130682');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2344402889f8476650de01476666acbf', '河北省', '130000', '保定市', '130600', '安国市', '130683');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2345402889f8476650de01476666acbf', '河北省', '130000', '保定市', '130600', '高碑店市', '130684');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2346402889f8476650de01476666acbf', '河北省', '130000', '张家口市', '130700', '桥东区', '130702');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2347402889f8476650de01476666acbf', '河北省', '130000', '张家口市', '130700', '桥西区', '130703');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2348402889f8476650de01476666acbf', '河北省', '130000', '张家口市', '130700', '宣化区', '130705');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2349402889f8476650de01476666acbf', '河北省', '130000', '张家口市', '130700', '下花园区', '130706');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2350402889f8476650de01476666acbf', '河北省', '130000', '张家口市', '130700', '宣化县', '130721');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2351402889f8476650de01476666acbf', '河北省', '130000', '张家口市', '130700', '张北县', '130722');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2352402889f8476650de01476666acbf', '河北省', '130000', '张家口市', '130700', '康保县', '130723');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2353402889f8476650de01476666acbf', '河北省', '130000', '张家口市', '130700', '沽源县', '130724');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2354402889f8476650de01476666acbf', '河北省', '130000', '张家口市', '130700', '尚义县', '130725');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2355402889f8476650de01476666acbf', '河北省', '130000', '张家口市', '130700', '蔚县', '130726');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2356402889f8476650de01476666acbf', '河北省', '130000', '张家口市', '130700', '阳原县', '130727');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2357402889f8476650de01476666acbf', '河北省', '130000', '张家口市', '130700', '怀安县', '130728');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2358402889f8476650de01476666acbf', '河北省', '130000', '张家口市', '130700', '万全县', '130729');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2359402889f8476650de01476666acbf', '河北省', '130000', '张家口市', '130700', '怀来县', '130730');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2360402889f8476650de01476666acbf', '河北省', '130000', '张家口市', '130700', '涿鹿县', '130731');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2361402889f8476650de01476666acbf', '河北省', '130000', '张家口市', '130700', '赤城县', '130732');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2362402889f8476650de01476666acbf', '河北省', '130000', '张家口市', '130700', '崇礼县', '130733');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2363402889f8476650de01476666acbf', '河北省', '130000', '承德市', '130800', '双桥区', '130802');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2364402889f8476650de01476666acbf', '河北省', '130000', '承德市', '130800', '双滦区', '130803');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2365402889f8476650de01476666acbf', '河北省', '130000', '承德市', '130800', '鹰手营子矿区', '130804');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2366402889f8476650de01476666acbf', '河北省', '130000', '承德市', '130800', '承德县', '130821');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2367402889f8476650de01476666acbf', '河北省', '130000', '承德市', '130800', '兴隆县', '130822');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2368402889f8476650de01476666acbf', '河北省', '130000', '承德市', '130800', '平泉县', '130823');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2369402889f8476650de01476666acbf', '河北省', '130000', '承德市', '130800', '滦平县', '130824');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2370402889f8476650de01476666acbf', '河北省', '130000', '承德市', '130800', '隆化县', '130825');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2371402889f8476650de01476666acbf', '河北省', '130000', '承德市', '130800', '丰宁满族自治县', '130826');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2372402889f8476650de01476666acbf', '河北省', '130000', '承德市', '130800', '宽城满族自治县', '130827');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2373402889f8476650de01476666acbf', '河北省', '130000', '承德市', '130800', '围场满族蒙古族自治县', '130828');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2374402889f8476650de01476666acbf', '河北省', '130000', '沧州市', '130900', '新华区', '130902');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2375402889f8476650de01476666acbf', '河北省', '130000', '沧州市', '130900', '运河区', '130903');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2376402889f8476650de01476666acbf', '河北省', '130000', '沧州市', '130900', '沧县', '130921');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2377402889f8476650de01476666acbf', '河北省', '130000', '沧州市', '130900', '青县', '130922');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2378402889f8476650de01476666acbf', '河北省', '130000', '沧州市', '130900', '东光县', '130923');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2379402889f8476650de01476666acbf', '河北省', '130000', '沧州市', '130900', '海兴县', '130924');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2380402889f8476650de01476666acbf', '河北省', '130000', '沧州市', '130900', '盐山县', '130925');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2381402889f8476650de01476666acbf', '河北省', '130000', '沧州市', '130900', '肃宁县', '130926');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2382402889f8476650de01476666acbf', '河北省', '130000', '沧州市', '130900', '南皮县', '130927');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2383402889f8476650de01476666acbf', '河北省', '130000', '沧州市', '130900', '吴桥县', '130928');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2384402889f8476650de01476666acbf', '河北省', '130000', '沧州市', '130900', '献县', '130929');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2385402889f8476650de01476666acbf', '河北省', '130000', '沧州市', '130900', '孟村回族自治县', '130930');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2386402889f8476650de01476666acbf', '河北省', '130000', '沧州市', '130900', '泊头市', '130981');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2387402889f8476650de01476666acbf', '河北省', '130000', '沧州市', '130900', '任丘市', '130982');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2388402889f8476650de01476666acbf', '河北省', '130000', '沧州市', '130900', '黄骅市', '130983');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2389402889f8476650de01476666acbf', '河北省', '130000', '沧州市', '130900', '河间市', '130984');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2390402889f8476650de01476666acbf', '河北省', '130000', '廊坊市', '131000', '安次区', '131002');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2391402889f8476650de01476666acbf', '河北省', '130000', '廊坊市', '131000', '广阳区', '131003');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2392402889f8476650de01476666acbf', '河北省', '130000', '廊坊市', '131000', '固安县', '131022');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2393402889f8476650de01476666acbf', '河北省', '130000', '廊坊市', '131000', '永清县', '131023');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2394402889f8476650de01476666acbf', '河北省', '130000', '廊坊市', '131000', '香河县', '131024');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2395402889f8476650de01476666acbf', '河北省', '130000', '廊坊市', '131000', '大城县', '131025');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2396402889f8476650de01476666acbf', '河北省', '130000', '廊坊市', '131000', '文安县', '131026');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2397402889f8476650de01476666acbf', '河北省', '130000', '廊坊市', '131000', '大厂回族自治县', '131028');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2398402889f8476650de01476666acbf', '河北省', '130000', '廊坊市', '131000', '霸州市', '131081');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2399402889f8476650de01476666acbf', '河北省', '130000', '廊坊市', '131000', '三河市', '131082');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2400402889f8476650de01476666acbf', '河北省', '130000', '衡水市', '131100', '桃城区', '131102');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2401402889f8476650de01476666acbf', '河北省', '130000', '衡水市', '131100', '枣强县', '131121');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2402402889f8476650de01476666acbf', '河北省', '130000', '衡水市', '131100', '武邑县', '131122');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2403402889f8476650de01476666acbf', '河北省', '130000', '衡水市', '131100', '武强县', '131123');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2404402889f8476650de01476666acbf', '河北省', '130000', '衡水市', '131100', '饶阳县', '131124');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2405402889f8476650de01476666acbf', '河北省', '130000', '衡水市', '131100', '安平县', '131125');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2406402889f8476650de01476666acbf', '河北省', '130000', '衡水市', '131100', '故城县', '131126');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2407402889f8476650de01476666acbf', '河北省', '130000', '衡水市', '131100', '景县', '131127');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2408402889f8476650de01476666acbf', '河北省', '130000', '衡水市', '131100', '阜城县', '131128');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2409402889f8476650de01476666acbf', '河北省', '130000', '衡水市', '131100', '冀州市', '131181');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2410402889f8476650de01476666acbf', '河北省', '130000', '衡水市', '131100', '深州市', '131182');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2411402889f8476650de01476666acbf', '山西省', '140000', '太原市', '140100', '小店区', '140105');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2412402889f8476650de01476666acbf', '山西省', '140000', '太原市', '140100', '迎泽区', '140106');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2413402889f8476650de01476666acbf', '山西省', '140000', '太原市', '140100', '杏花岭区', '140107');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2414402889f8476650de01476666acbf', '山西省', '140000', '太原市', '140100', '尖草坪区', '140108');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2415402889f8476650de01476666acbf', '山西省', '140000', '太原市', '140100', '万柏林区', '140109');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2416402889f8476650de01476666acbf', '山西省', '140000', '太原市', '140100', '晋源区', '140110');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2417402889f8476650de01476666acbf', '山西省', '140000', '太原市', '140100', '清徐县', '140121');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2418402889f8476650de01476666acbf', '山西省', '140000', '太原市', '140100', '阳曲县', '140122');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2419402889f8476650de01476666acbf', '山西省', '140000', '太原市', '140100', '娄烦县', '140123');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2420402889f8476650de01476666acbf', '山西省', '140000', '太原市', '140100', '古交市', '140181');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2421402889f8476650de01476666acbf', '山西省', '140000', '大同市', '140200', '城区', '140202');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1154402889f8476650de01476666acbf', '山西省', '140000', '大同市', '140200', '矿区', '140203');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1155402889f8476650de01476666acbf', '山西省', '140000', '大同市', '140200', '南郊区', '140211');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1156402889f8476650de01476666acbf', '山西省', '140000', '大同市', '140200', '新荣区', '140212');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1157402889f8476650de01476666acbf', '山西省', '140000', '大同市', '140200', '阳高县', '140221');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1158402889f8476650de01476666acbf', '山西省', '140000', '大同市', '140200', '天镇县', '140222');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1159402889f8476650de01476666acbf', '山西省', '140000', '大同市', '140200', '广灵县', '140223');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1160402889f8476650de01476666acbf', '山西省', '140000', '大同市', '140200', '灵丘县', '140224');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1161402889f8476650de01476666acbf', '山西省', '140000', '大同市', '140200', '浑源县', '140225');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1162402889f8476650de01476666acbf', '山西省', '140000', '大同市', '140200', '左云县', '140226');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1163402889f8476650de01476666acbf', '山西省', '140000', '大同市', '140200', '大同县', '140227');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1164402889f8476650de01476666acbf', '山西省', '140000', '阳泉市', '140300', '城区', '140302');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1165402889f8476650de01476666acbf', '山西省', '140000', '阳泉市', '140300', '矿区', '140303');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1166402889f8476650de01476666acbf', '山西省', '140000', '阳泉市', '140300', '郊区', '140311');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1167402889f8476650de01476666acbf', '山西省', '140000', '阳泉市', '140300', '平定县', '140321');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1168402889f8476650de01476666acbf', '山西省', '140000', '阳泉市', '140300', '盂县', '140322');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1169402889f8476650de01476666acbf', '山西省', '140000', '长治市', '140400', '城区', '140402');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1170402889f8476650de01476666acbf', '山西省', '140000', '长治市', '140400', '郊区', '140411');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1171402889f8476650de01476666acbf', '山西省', '140000', '长治市', '140400', '长治县', '140421');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1172402889f8476650de01476666acbf', '山西省', '140000', '长治市', '140400', '襄垣县', '140423');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1173402889f8476650de01476666acbf', '山西省', '140000', '长治市', '140400', '屯留县', '140424');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1174402889f8476650de01476666acbf', '山西省', '140000', '长治市', '140400', '平顺县', '140425');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1175402889f8476650de01476666acbf', '山西省', '140000', '长治市', '140400', '黎城县', '140426');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1176402889f8476650de01476666acbf', '山西省', '140000', '长治市', '140400', '壶关县', '140427');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1177402889f8476650de01476666acbf', '山西省', '140000', '长治市', '140400', '长子县', '140428');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1178402889f8476650de01476666acbf', '山西省', '140000', '长治市', '140400', '武乡县', '140429');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1179402889f8476650de01476666acbf', '山西省', '140000', '长治市', '140400', '沁县', '140430');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1180402889f8476650de01476666acbf', '山西省', '140000', '长治市', '140400', '沁源县', '140431');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1181402889f8476650de01476666acbf', '山西省', '140000', '长治市', '140400', '潞城市', '140481');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1182402889f8476650de01476666acbf', '山西省', '140000', '晋城市', '140500', '城区', '140502');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1183402889f8476650de01476666acbf', '山西省', '140000', '晋城市', '140500', '沁水县', '140521');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1184402889f8476650de01476666acbf', '山西省', '140000', '晋城市', '140500', '阳城县', '140522');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1185402889f8476650de01476666acbf', '山西省', '140000', '晋城市', '140500', '陵川县', '140524');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1186402889f8476650de01476666acbf', '山西省', '140000', '晋城市', '140500', '泽州县', '140525');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1187402889f8476650de01476666acbf', '山西省', '140000', '晋城市', '140500', '高平市', '140581');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1188402889f8476650de01476666acbf', '山西省', '140000', '朔州市', '140600', '朔城区', '140602');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1189402889f8476650de01476666acbf', '山西省', '140000', '朔州市', '140600', '平鲁区', '140603');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1190402889f8476650de01476666acbf', '山西省', '140000', '朔州市', '140600', '山阴县', '140621');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1191402889f8476650de01476666acbf', '山西省', '140000', '朔州市', '140600', '应县', '140622');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1192402889f8476650de01476666acbf', '山西省', '140000', '朔州市', '140600', '右玉县', '140623');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1193402889f8476650de01476666acbf', '山西省', '140000', '朔州市', '140600', '怀仁县', '140624');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1194402889f8476650de01476666acbf', '山西省', '140000', '晋中市', '140700', '榆次区', '140702');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1195402889f8476650de01476666acbf', '山西省', '140000', '晋中市', '140700', '榆社县', '140721');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1196402889f8476650de01476666acbf', '山西省', '140000', '晋中市', '140700', '左权县', '140722');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1197402889f8476650de01476666acbf', '山西省', '140000', '晋中市', '140700', '和顺县', '140723');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1198402889f8476650de01476666acbf', '山西省', '140000', '晋中市', '140700', '昔阳县', '140724');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1199402889f8476650de01476666acbf', '山西省', '140000', '晋中市', '140700', '寿阳县', '140725');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1200402889f8476650de01476666acbf', '山西省', '140000', '晋中市', '140700', '太谷县', '140726');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1201402889f8476650de01476666acbf', '山西省', '140000', '晋中市', '140700', '祁县', '140727');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1202402889f8476650de01476666acbf', '山西省', '140000', '晋中市', '140700', '平遥县', '140728');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1203402889f8476650de01476666acbf', '山西省', '140000', '晋中市', '140700', '灵石县', '140729');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1204402889f8476650de01476666acbf', '山西省', '140000', '晋中市', '140700', '介休市', '140781');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1205402889f8476650de01476666acbf', '山西省', '140000', '运城市', '140800', '盐湖区', '140802');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1206402889f8476650de01476666acbf', '山西省', '140000', '运城市', '140800', '临猗县', '140821');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1207402889f8476650de01476666acbf', '山西省', '140000', '运城市', '140800', '万荣县', '140822');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1208402889f8476650de01476666acbf', '山西省', '140000', '运城市', '140800', '闻喜县', '140823');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1209402889f8476650de01476666acbf', '山西省', '140000', '运城市', '140800', '稷山县', '140824');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1210402889f8476650de01476666acbf', '山西省', '140000', '运城市', '140800', '新绛县', '140825');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1211402889f8476650de01476666acbf', '山西省', '140000', '运城市', '140800', '绛县', '140826');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1212402889f8476650de01476666acbf', '山西省', '140000', '运城市', '140800', '垣曲县', '140827');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1213402889f8476650de01476666acbf', '山西省', '140000', '运城市', '140800', '夏县', '140828');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1214402889f8476650de01476666acbf', '山西省', '140000', '运城市', '140800', '平陆县', '140829');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1215402889f8476650de01476666acbf', '山西省', '140000', '运城市', '140800', '芮城县', '140830');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1216402889f8476650de01476666acbf', '山西省', '140000', '运城市', '140800', '永济市', '140881');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1217402889f8476650de01476666acbf', '山西省', '140000', '运城市', '140800', '河津市', '140882');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1218402889f8476650de01476666acbf', '山西省', '140000', '忻州市', '140900', '忻府区', '140902');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1219402889f8476650de01476666acbf', '山西省', '140000', '忻州市', '140900', '定襄县', '140921');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1220402889f8476650de01476666acbf', '山西省', '140000', '忻州市', '140900', '五台县', '140922');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1221402889f8476650de01476666acbf', '山西省', '140000', '忻州市', '140900', '代县', '140923');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1222402889f8476650de01476666acbf', '山西省', '140000', '忻州市', '140900', '繁峙县', '140924');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1223402889f8476650de01476666acbf', '山西省', '140000', '忻州市', '140900', '宁武县', '140925');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1224402889f8476650de01476666acbf', '山西省', '140000', '忻州市', '140900', '静乐县', '140926');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1225402889f8476650de01476666acbf', '山西省', '140000', '忻州市', '140900', '神池县', '140927');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1226402889f8476650de01476666acbf', '山西省', '140000', '忻州市', '140900', '五寨县', '140928');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1227402889f8476650de01476666acbf', '山西省', '140000', '忻州市', '140900', '岢岚县', '140929');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1228402889f8476650de01476666acbf', '山西省', '140000', '忻州市', '140900', '河曲县', '140930');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1229402889f8476650de01476666acbf', '山西省', '140000', '忻州市', '140900', '保德县', '140931');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1230402889f8476650de01476666acbf', '山西省', '140000', '忻州市', '140900', '偏关县', '140932');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1231402889f8476650de01476666acbf', '山西省', '140000', '忻州市', '140900', '原平市', '140981');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1232402889f8476650de01476666acbf', '山西省', '140000', '临汾市', '141000', '尧都区', '141002');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1233402889f8476650de01476666acbf', '山西省', '140000', '临汾市', '141000', '曲沃县', '141021');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1234402889f8476650de01476666acbf', '山西省', '140000', '临汾市', '141000', '翼城县', '141022');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1235402889f8476650de01476666acbf', '山西省', '140000', '临汾市', '141000', '襄汾县', '141023');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1236402889f8476650de01476666acbf', '山西省', '140000', '临汾市', '141000', '洪洞县', '141024');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1237402889f8476650de01476666acbf', '山西省', '140000', '临汾市', '141000', '古县', '141025');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1238402889f8476650de01476666acbf', '山西省', '140000', '临汾市', '141000', '安泽县', '141026');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1239402889f8476650de01476666acbf', '山西省', '140000', '临汾市', '141000', '浮山县', '141027');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1240402889f8476650de01476666acbf', '山西省', '140000', '临汾市', '141000', '吉县', '141028');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1241402889f8476650de01476666acbf', '山西省', '140000', '临汾市', '141000', '乡宁县', '141029');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1242402889f8476650de01476666acbf', '山西省', '140000', '临汾市', '141000', '大宁县', '141030');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1243402889f8476650de01476666acbf', '山西省', '140000', '临汾市', '141000', '隰县', '141031');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1244402889f8476650de01476666acbf', '山西省', '140000', '临汾市', '141000', '永和县', '141032');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1245402889f8476650de01476666acbf', '山西省', '140000', '临汾市', '141000', '蒲县', '141033');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1246402889f8476650de01476666acbf', '山西省', '140000', '临汾市', '141000', '汾西县', '141034');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1247402889f8476650de01476666acbf', '山西省', '140000', '临汾市', '141000', '侯马市', '141081');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1248402889f8476650de01476666acbf', '山西省', '140000', '临汾市', '141000', '霍州市', '141082');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1249402889f8476650de01476666acbf', '山西省', '140000', '吕梁市', '141100', '离石区', '141102');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1250402889f8476650de01476666acbf', '山西省', '140000', '吕梁市', '141100', '文水县', '141121');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1251402889f8476650de01476666acbf', '山西省', '140000', '吕梁市', '141100', '交城县', '141122');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1252402889f8476650de01476666acbf', '山西省', '140000', '吕梁市', '141100', '兴县', '141123');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1253402889f8476650de01476666acbf', '山西省', '140000', '吕梁市', '141100', '临县', '141124');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1254402889f8476650de01476666acbf', '山西省', '140000', '吕梁市', '141100', '柳林县', '141125');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1255402889f8476650de01476666acbf', '山西省', '140000', '吕梁市', '141100', '石楼县', '141126');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1256402889f8476650de01476666acbf', '山西省', '140000', '吕梁市', '141100', '岚县', '141127');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1257402889f8476650de01476666acbf', '山西省', '140000', '吕梁市', '141100', '方山县', '141128');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1258402889f8476650de01476666acbf', '山西省', '140000', '吕梁市', '141100', '中阳县', '141129');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1259402889f8476650de01476666acbf', '山西省', '140000', '吕梁市', '141100', '交口县', '141130');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1260402889f8476650de01476666acbf', '山西省', '140000', '吕梁市', '141100', '孝义市', '141181');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1261402889f8476650de01476666acbf', '山西省', '140000', '吕梁市', '141100', '汾阳市', '141182');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1262402889f8476650de01476666acbf', '内蒙古自治区', '150000', '呼和浩特市', '150100', '新城区', '150102');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1263402889f8476650de01476666acbf', '内蒙古自治区', '150000', '呼和浩特市', '150100', '回民区', '150103');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1264402889f8476650de01476666acbf', '内蒙古自治区', '150000', '呼和浩特市', '150100', '玉泉区', '150104');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1265402889f8476650de01476666acbf', '内蒙古自治区', '150000', '呼和浩特市', '150100', '赛罕区', '150105');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1266402889f8476650de01476666acbf', '内蒙古自治区', '150000', '呼和浩特市', '150100', '土默特左旗', '150121');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1267402889f8476650de01476666acbf', '内蒙古自治区', '150000', '呼和浩特市', '150100', '托克托县', '150122');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1268402889f8476650de01476666acbf', '内蒙古自治区', '150000', '呼和浩特市', '150100', '和林格尔县', '150123');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1269402889f8476650de01476666acbf', '内蒙古自治区', '150000', '呼和浩特市', '150100', '清水河县', '150124');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1270402889f8476650de01476666acbf', '内蒙古自治区', '150000', '呼和浩特市', '150100', '武川县', '150125');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1271402889f8476650de01476666acbf', '内蒙古自治区', '150000', '包头市', '150200', '东河区', '150202');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1272402889f8476650de01476666acbf', '内蒙古自治区', '150000', '包头市', '150200', '昆都仑区', '150203');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1273402889f8476650de01476666acbf', '内蒙古自治区', '150000', '包头市', '150200', '青山区', '150204');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1274402889f8476650de01476666acbf', '内蒙古自治区', '150000', '包头市', '150200', '石拐区', '150205');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1275402889f8476650de01476666acbf', '内蒙古自治区', '150000', '包头市', '150200', '白云鄂博矿区', '150206');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1276402889f8476650de01476666acbf', '内蒙古自治区', '150000', '包头市', '150200', '九原区', '150207');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1277402889f8476650de01476666acbf', '内蒙古自治区', '150000', '包头市', '150200', '土默特右旗', '150221');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1278402889f8476650de01476666acbf', '内蒙古自治区', '150000', '包头市', '150200', '固阳县', '150222');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1279402889f8476650de01476666acbf', '内蒙古自治区', '150000', '包头市', '150200', '达尔罕茂明安联合旗', '150223');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1280402889f8476650de01476666acbf', '内蒙古自治区', '150000', '乌海市', '150300', '海勃湾区', '150302');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1281402889f8476650de01476666acbf', '内蒙古自治区', '150000', '乌海市', '150300', '海南区', '150303');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1282402889f8476650de01476666acbf', '内蒙古自治区', '150000', '乌海市', '150300', '乌达区', '150304');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1283402889f8476650de01476666acbf', '内蒙古自治区', '150000', '赤峰市', '150400', '红山区', '150402');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1284402889f8476650de01476666acbf', '内蒙古自治区', '150000', '赤峰市', '150400', '元宝山区', '150403');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1285402889f8476650de01476666acbf', '内蒙古自治区', '150000', '赤峰市', '150400', '松山区', '150404');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1286402889f8476650de01476666acbf', '内蒙古自治区', '150000', '赤峰市', '150400', '阿鲁科尔沁旗', '150421');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1287402889f8476650de01476666acbf', '内蒙古自治区', '150000', '赤峰市', '150400', '巴林左旗', '150422');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1288402889f8476650de01476666acbf', '内蒙古自治区', '150000', '赤峰市', '150400', '巴林右旗', '150423');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1289402889f8476650de01476666acbf', '内蒙古自治区', '150000', '赤峰市', '150400', '林西县', '150424');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1290402889f8476650de01476666acbf', '内蒙古自治区', '150000', '赤峰市', '150400', '克什克腾旗', '150425');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1291402889f8476650de01476666acbf', '内蒙古自治区', '150000', '赤峰市', '150400', '翁牛特旗', '150426');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1292402889f8476650de01476666acbf', '内蒙古自治区', '150000', '赤峰市', '150400', '喀喇沁旗', '150428');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1293402889f8476650de01476666acbf', '内蒙古自治区', '150000', '赤峰市', '150400', '宁城县', '150429');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1294402889f8476650de01476666acbf', '内蒙古自治区', '150000', '赤峰市', '150400', '敖汉旗', '150430');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1295402889f8476650de01476666acbf', '内蒙古自治区', '150000', '通辽市', '150500', '科尔沁区', '150502');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1296402889f8476650de01476666acbf', '内蒙古自治区', '150000', '通辽市', '150500', '科尔沁左翼中旗', '150521');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1297402889f8476650de01476666acbf', '内蒙古自治区', '150000', '通辽市', '150500', '科尔沁左翼后旗', '150522');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1298402889f8476650de01476666acbf', '内蒙古自治区', '150000', '通辽市', '150500', '开鲁县', '150523');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1299402889f8476650de01476666acbf', '内蒙古自治区', '150000', '通辽市', '150500', '库伦旗', '150524');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1300402889f8476650de01476666acbf', '内蒙古自治区', '150000', '通辽市', '150500', '奈曼旗', '150525');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1301402889f8476650de01476666acbf', '内蒙古自治区', '150000', '通辽市', '150500', '扎鲁特旗', '150526');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1302402889f8476650de01476666acbf', '内蒙古自治区', '150000', '通辽市', '150500', '霍林郭勒市', '150581');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1303402889f8476650de01476666acbf', '内蒙古自治区', '150000', '鄂尔多斯市', '150600', '东胜区', '150602');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1304402889f8476650de01476666acbf', '内蒙古自治区', '150000', '鄂尔多斯市', '150600', '达拉特旗', '150621');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1305402889f8476650de01476666acbf', '内蒙古自治区', '150000', '鄂尔多斯市', '150600', '准格尔旗', '150622');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1306402889f8476650de01476666acbf', '内蒙古自治区', '150000', '鄂尔多斯市', '150600', '鄂托克前旗', '150623');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1307402889f8476650de01476666acbf', '内蒙古自治区', '150000', '鄂尔多斯市', '150600', '鄂托克旗', '150624');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1308402889f8476650de01476666acbf', '内蒙古自治区', '150000', '鄂尔多斯市', '150600', '杭锦旗', '150625');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1309402889f8476650de01476666acbf', '内蒙古自治区', '150000', '鄂尔多斯市', '150600', '乌审旗', '150626');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1310402889f8476650de01476666acbf', '内蒙古自治区', '150000', '鄂尔多斯市', '150600', '伊金霍洛旗', '150627');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1311402889f8476650de01476666acbf', '内蒙古自治区', '150000', '呼伦贝尔市', '150700', '海拉尔区', '150702');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1312402889f8476650de01476666acbf', '内蒙古自治区', '150000', '呼伦贝尔市', '150700', '阿荣旗', '150721');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1313402889f8476650de01476666acbf', '内蒙古自治区', '150000', '呼伦贝尔市', '150700', '莫力达瓦达斡尔族自治旗', '150722');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1314402889f8476650de01476666acbf', '内蒙古自治区', '150000', '呼伦贝尔市', '150700', '鄂伦春自治旗', '150723');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1315402889f8476650de01476666acbf', '内蒙古自治区', '150000', '呼伦贝尔市', '150700', '鄂温克族自治旗', '150724');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1316402889f8476650de01476666acbf', '内蒙古自治区', '150000', '呼伦贝尔市', '150700', '陈巴尔虎旗', '150725');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1317402889f8476650de01476666acbf', '内蒙古自治区', '150000', '呼伦贝尔市', '150700', '新巴尔虎左旗', '150726');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1318402889f8476650de01476666acbf', '内蒙古自治区', '150000', '呼伦贝尔市', '150700', '新巴尔虎右旗', '150727');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1319402889f8476650de01476666acbf', '内蒙古自治区', '150000', '呼伦贝尔市', '150700', '满洲里市', '150781');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1320402889f8476650de01476666acbf', '内蒙古自治区', '150000', '呼伦贝尔市', '150700', '牙克石市', '150782');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1321402889f8476650de01476666acbf', '内蒙古自治区', '150000', '呼伦贝尔市', '150700', '扎兰屯市', '150783');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1322402889f8476650de01476666acbf', '内蒙古自治区', '150000', '呼伦贝尔市', '150700', '额尔古纳市', '150784');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1323402889f8476650de01476666acbf', '内蒙古自治区', '150000', '呼伦贝尔市', '150700', '根河市', '150785');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1324402889f8476650de01476666acbf', '内蒙古自治区', '150000', '巴彦淖尔市', '150800', '临河区', '150802');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1325402889f8476650de01476666acbf', '内蒙古自治区', '150000', '巴彦淖尔市', '150800', '五原县', '150821');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1326402889f8476650de01476666acbf', '内蒙古自治区', '150000', '巴彦淖尔市', '150800', '磴口县', '150822');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1327402889f8476650de01476666acbf', '内蒙古自治区', '150000', '巴彦淖尔市', '150800', '乌拉特前旗', '150823');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1328402889f8476650de01476666acbf', '内蒙古自治区', '150000', '巴彦淖尔市', '150800', '乌拉特中旗', '150824');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1329402889f8476650de01476666acbf', '内蒙古自治区', '150000', '巴彦淖尔市', '150800', '乌拉特后旗', '150825');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1330402889f8476650de01476666acbf', '内蒙古自治区', '150000', '巴彦淖尔市', '150800', '杭锦后旗', '150826');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1331402889f8476650de01476666acbf', '内蒙古自治区', '150000', '乌兰察布市', '150900', '集宁区', '150902');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1332402889f8476650de01476666acbf', '内蒙古自治区', '150000', '乌兰察布市', '150900', '卓资县', '150921');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1333402889f8476650de01476666acbf', '内蒙古自治区', '150000', '乌兰察布市', '150900', '化德县', '150922');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1334402889f8476650de01476666acbf', '内蒙古自治区', '150000', '乌兰察布市', '150900', '商都县', '150923');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1335402889f8476650de01476666acbf', '内蒙古自治区', '150000', '乌兰察布市', '150900', '兴和县', '150924');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1336402889f8476650de01476666acbf', '内蒙古自治区', '150000', '乌兰察布市', '150900', '凉城县', '150925');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1337402889f8476650de01476666acbf', '内蒙古自治区', '150000', '乌兰察布市', '150900', '察哈尔右翼前旗', '150926');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1338402889f8476650de01476666acbf', '内蒙古自治区', '150000', '乌兰察布市', '150900', '察哈尔右翼中旗', '150927');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1339402889f8476650de01476666acbf', '内蒙古自治区', '150000', '乌兰察布市', '150900', '察哈尔右翼后旗', '150928');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1340402889f8476650de01476666acbf', '内蒙古自治区', '150000', '乌兰察布市', '150900', '四子王旗', '150929');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1341402889f8476650de01476666acbf', '内蒙古自治区', '150000', '乌兰察布市', '150900', '丰镇市', '150981');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1342402889f8476650de01476666acbf', '内蒙古自治区', '150000', '兴安盟', '151000', '乌兰浩特市', '152201');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1402889f8476650de01476666acbf000', '内蒙古自治区', '150000', '兴安盟', '151000', '阿尔山市', '152202');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2402889f8476650de01476666acbf000', '内蒙古自治区', '150000', '兴安盟', '151000', '科尔沁右翼前旗', '152221');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('3402889f8476650de01476666acbf000', '内蒙古自治区', '150000', '兴安盟', '151000', '科尔沁右翼中旗', '152222');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('4402889f8476650de01476666acbf000', '内蒙古自治区', '150000', '兴安盟', '151000', '扎赉特旗', '152223');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('5402889f8476650de01476666acbf000', '内蒙古自治区', '150000', '兴安盟', '151000', '突泉县', '152224');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('6402889f8476650de01476666acbf000', '内蒙古自治区', '150000', '锡林郭勒盟', '151100', '二连浩特市', '152501');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('7402889f8476650de01476666acbf000', '内蒙古自治区', '150000', '锡林郭勒盟', '151100', '锡林浩特市', '152502');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('8402889f8476650de01476666acbf000', '内蒙古自治区', '150000', '锡林郭勒盟', '151100', '阿巴嘎旗', '152522');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('9402889f8476650de01476666acbf000', '内蒙古自治区', '150000', '锡林郭勒盟', '151100', '苏尼特左旗', '152523');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('10402889f8476650de01476666acbf00', '内蒙古自治区', '150000', '锡林郭勒盟', '151100', '苏尼特右旗', '152524');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('11402889f8476650de01476666acbf00', '内蒙古自治区', '150000', '锡林郭勒盟', '151100', '东乌珠穆沁旗', '152525');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('12402889f8476650de01476666acbf00', '内蒙古自治区', '150000', '锡林郭勒盟', '151100', '西乌珠穆沁旗', '152526');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('13402889f8476650de01476666acbf00', '内蒙古自治区', '150000', '锡林郭勒盟', '151100', '太仆寺旗', '152527');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('14402889f8476650de01476666acbf00', '内蒙古自治区', '150000', '锡林郭勒盟', '151100', '镶黄旗', '152528');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('15402889f8476650de01476666acbf00', '内蒙古自治区', '150000', '锡林郭勒盟', '151100', '正镶白旗', '152529');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('16402889f8476650de01476666acbf00', '内蒙古自治区', '150000', '锡林郭勒盟', '151100', '正蓝旗', '152530');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('17402889f8476650de01476666acbf00', '内蒙古自治区', '150000', '锡林郭勒盟', '151100', '多伦县', '152531');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('18402889f8476650de01476666acbf00', '内蒙古自治区', '150000', '阿拉善盟', '151200', '阿拉善左旗', '152921');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('19402889f8476650de01476666acbf00', '内蒙古自治区', '150000', '阿拉善盟', '151200', '阿拉善右旗', '152922');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('20402889f8476650de01476666acbf00', '内蒙古自治区', '150000', '阿拉善盟', '151200', '额济纳旗', '152923');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('21402889f8476650de01476666acbf00', '辽宁省', '210000', '沈阳市', '210100', '和平区', '210102');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('22402889f8476650de01476666acbf00', '辽宁省', '210000', '沈阳市', '210100', '沈河区', '210103');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('23402889f8476650de01476666acbf00', '辽宁省', '210000', '沈阳市', '210100', '大东区', '210104');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('24402889f8476650de01476666acbf00', '辽宁省', '210000', '沈阳市', '210100', '皇姑区', '210105');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('25402889f8476650de01476666acbf00', '辽宁省', '210000', '沈阳市', '210100', '铁西区', '210106');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('26402889f8476650de01476666acbf00', '辽宁省', '210000', '沈阳市', '210100', '苏家屯区', '210111');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('27402889f8476650de01476666acbf00', '辽宁省', '210000', '沈阳市', '210100', '东陵区', '210112');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1345402889f8476650de01476666acbf', '辽宁省', '210000', '沈阳市', '210100', '沈北新区', '210113');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1346402889f8476650de01476666acbf', '辽宁省', '210000', '沈阳市', '210100', '于洪区', '210114');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1347402889f8476650de01476666acbf', '辽宁省', '210000', '沈阳市', '210100', '辽中县', '210122');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1348402889f8476650de01476666acbf', '辽宁省', '210000', '沈阳市', '210100', '康平县', '210123');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1349402889f8476650de01476666acbf', '辽宁省', '210000', '沈阳市', '210100', '法库县', '210124');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1350402889f8476650de01476666acbf', '辽宁省', '210000', '沈阳市', '210100', '新民市', '210181');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1351402889f8476650de01476666acbf', '辽宁省', '210000', '大连市', '210200', '中山区', '210202');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1352402889f8476650de01476666acbf', '辽宁省', '210000', '大连市', '210200', '西岗区', '210203');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1353402889f8476650de01476666acbf', '辽宁省', '210000', '大连市', '210200', '沙河口区', '210204');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1354402889f8476650de01476666acbf', '辽宁省', '210000', '大连市', '210200', '甘井子区', '210211');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1355402889f8476650de01476666acbf', '辽宁省', '210000', '大连市', '210200', '旅顺口区', '210212');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1356402889f8476650de01476666acbf', '辽宁省', '210000', '大连市', '210200', '金州区', '210213');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1357402889f8476650de01476666acbf', '辽宁省', '210000', '大连市', '210200', '长海县', '210224');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1358402889f8476650de01476666acbf', '辽宁省', '210000', '大连市', '210200', '瓦房店市', '210281');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1359402889f8476650de01476666acbf', '辽宁省', '210000', '大连市', '210200', '普兰店市', '210282');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1360402889f8476650de01476666acbf', '辽宁省', '210000', '大连市', '210200', '庄河市', '210283');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1343402889f8476650de01476666acbf', '辽宁省', '210000', '大连市', '210200', '经济开发区', '210284');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1130402889f8476650de01476666acbf', '辽宁省', '210000', '大连市', '210200', '高新园区', '210285');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1361402889f8476650de01476666acbf', '辽宁省', '210000', '鞍山市', '210300', '铁东区', '210302');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1362402889f8476650de01476666acbf', '辽宁省', '210000', '鞍山市', '210300', '铁西区', '210303');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1363402889f8476650de01476666acbf', '辽宁省', '210000', '鞍山市', '210300', '立山区', '210304');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1364402889f8476650de01476666acbf', '辽宁省', '210000', '鞍山市', '210300', '千山区', '210311');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1365402889f8476650de01476666acbf', '辽宁省', '210000', '鞍山市', '210300', '台安县', '210321');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1366402889f8476650de01476666acbf', '辽宁省', '210000', '鞍山市', '210300', '岫岩满族自治县', '210323');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1367402889f8476650de01476666acbf', '辽宁省', '210000', '鞍山市', '210300', '海城市', '210381');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1368402889f8476650de01476666acbf', '辽宁省', '210000', '抚顺市', '210400', '新抚区', '210402');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1369402889f8476650de01476666acbf', '辽宁省', '210000', '抚顺市', '210400', '东洲区', '210403');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1370402889f8476650de01476666acbf', '辽宁省', '210000', '抚顺市', '210400', '望花区', '210404');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1371402889f8476650de01476666acbf', '辽宁省', '210000', '抚顺市', '210400', '顺城区', '210411');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1372402889f8476650de01476666acbf', '辽宁省', '210000', '抚顺市', '210400', '抚顺县', '210421');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1373402889f8476650de01476666acbf', '辽宁省', '210000', '抚顺市', '210400', '新宾满族自治县', '210422');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1374402889f8476650de01476666acbf', '辽宁省', '210000', '抚顺市', '210400', '清原满族自治县', '210423');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1375402889f8476650de01476666acbf', '辽宁省', '210000', '本溪市', '210500', '平山区', '210502');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1376402889f8476650de01476666acbf', '辽宁省', '210000', '本溪市', '210500', '溪湖区', '210503');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1377402889f8476650de01476666acbf', '辽宁省', '210000', '本溪市', '210500', '明山区', '210504');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1378402889f8476650de01476666acbf', '辽宁省', '210000', '本溪市', '210500', '南芬区', '210505');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1379402889f8476650de01476666acbf', '辽宁省', '210000', '本溪市', '210500', '本溪满族自治县', '210521');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1380402889f8476650de01476666acbf', '辽宁省', '210000', '本溪市', '210500', '桓仁满族自治县', '210522');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1381402889f8476650de01476666acbf', '辽宁省', '210000', '丹东市', '210600', '元宝区', '210602');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1382402889f8476650de01476666acbf', '辽宁省', '210000', '丹东市', '210600', '振兴区', '210603');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1383402889f8476650de01476666acbf', '辽宁省', '210000', '丹东市', '210600', '振安区', '210604');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1384402889f8476650de01476666acbf', '辽宁省', '210000', '丹东市', '210600', '宽甸满族自治县', '210624');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1385402889f8476650de01476666acbf', '辽宁省', '210000', '丹东市', '210600', '东港市', '210681');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1386402889f8476650de01476666acbf', '辽宁省', '210000', '丹东市', '210600', '凤城市', '210682');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1387402889f8476650de01476666acbf', '辽宁省', '210000', '锦州市', '210700', '古塔区', '210702');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1388402889f8476650de01476666acbf', '辽宁省', '210000', '锦州市', '210700', '凌河区', '210703');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1389402889f8476650de01476666acbf', '辽宁省', '210000', '锦州市', '210700', '太和区', '210711');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1390402889f8476650de01476666acbf', '辽宁省', '210000', '锦州市', '210700', '黑山县', '210726');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1391402889f8476650de01476666acbf', '辽宁省', '210000', '锦州市', '210700', '义县', '210727');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1392402889f8476650de01476666acbf', '辽宁省', '210000', '锦州市', '210700', '凌海市', '210781');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1393402889f8476650de01476666acbf', '辽宁省', '210000', '锦州市', '210700', '北镇市', '210782');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1394402889f8476650de01476666acbf', '辽宁省', '210000', '营口市', '210800', '站前区', '210802');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1395402889f8476650de01476666acbf', '辽宁省', '210000', '营口市', '210800', '西市区', '210803');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1396402889f8476650de01476666acbf', '辽宁省', '210000', '营口市', '210800', '鲅鱼圈区', '210804');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1397402889f8476650de01476666acbf', '辽宁省', '210000', '营口市', '210800', '老边区', '210811');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1398402889f8476650de01476666acbf', '辽宁省', '210000', '营口市', '210800', '盖州市', '210881');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1399402889f8476650de01476666acbf', '辽宁省', '210000', '营口市', '210800', '大石桥市', '210882');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1400402889f8476650de01476666acbf', '辽宁省', '210000', '阜新市', '210900', '海州区', '210902');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1401402889f8476650de01476666acbf', '辽宁省', '210000', '阜新市', '210900', '新邱区', '210903');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1402402889f8476650de01476666acbf', '辽宁省', '210000', '阜新市', '210900', '太平区', '210904');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1403402889f8476650de01476666acbf', '辽宁省', '210000', '阜新市', '210900', '清河门区', '210905');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1404402889f8476650de01476666acbf', '辽宁省', '210000', '阜新市', '210900', '细河区', '210911');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1405402889f8476650de01476666acbf', '辽宁省', '210000', '阜新市', '210900', '阜新蒙古族自治县', '210921');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1406402889f8476650de01476666acbf', '辽宁省', '210000', '阜新市', '210900', '彰武县', '210922');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1407402889f8476650de01476666acbf', '辽宁省', '210000', '辽阳市', '211000', '白塔区', '211002');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1408402889f8476650de01476666acbf', '辽宁省', '210000', '辽阳市', '211000', '文圣区', '211003');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1409402889f8476650de01476666acbf', '辽宁省', '210000', '辽阳市', '211000', '宏伟区', '211004');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1410402889f8476650de01476666acbf', '辽宁省', '210000', '辽阳市', '211000', '弓长岭区', '211005');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1411402889f8476650de01476666acbf', '辽宁省', '210000', '辽阳市', '211000', '太子河区', '211011');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1412402889f8476650de01476666acbf', '辽宁省', '210000', '辽阳市', '211000', '辽阳县', '211021');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1413402889f8476650de01476666acbf', '辽宁省', '210000', '辽阳市', '211000', '灯塔市', '211081');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1777402889f8476650de01476666acbf', '辽宁省', '210000', '盘锦市', '211100', '双台子区', '211102');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1778402889f8476650de01476666acbf', '辽宁省', '210000', '盘锦市', '211100', '兴隆台区', '211103');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1779402889f8476650de01476666acbf', '辽宁省', '210000', '盘锦市', '211100', '大洼县', '211121');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1780402889f8476650de01476666acbf', '辽宁省', '210000', '盘锦市', '211100', '盘山县', '211122');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1781402889f8476650de01476666acbf', '辽宁省', '210000', '铁岭市', '211200', '银州区', '211202');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1782402889f8476650de01476666acbf', '辽宁省', '210000', '铁岭市', '211200', '清河区', '211204');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1783402889f8476650de01476666acbf', '辽宁省', '210000', '铁岭市', '211200', '铁岭县', '211221');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1784402889f8476650de01476666acbf', '辽宁省', '210000', '铁岭市', '211200', '西丰县', '211223');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1785402889f8476650de01476666acbf', '辽宁省', '210000', '铁岭市', '211200', '昌图县', '211224');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1786402889f8476650de01476666acbf', '辽宁省', '210000', '铁岭市', '211200', '调兵山市', '211281');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1787402889f8476650de01476666acbf', '辽宁省', '210000', '铁岭市', '211200', '开原市', '211282');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1788402889f8476650de01476666acbf', '辽宁省', '210000', '朝阳市', '211300', '双塔区', '211302');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1789402889f8476650de01476666acbf', '辽宁省', '210000', '朝阳市', '211300', '龙城区', '211303');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1790402889f8476650de01476666acbf', '辽宁省', '210000', '朝阳市', '211300', '朝阳县', '211321');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1791402889f8476650de01476666acbf', '辽宁省', '210000', '朝阳市', '211300', '建平县', '211322');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1792402889f8476650de01476666acbf', '辽宁省', '210000', '朝阳市', '211300', '喀喇沁左翼蒙古族自治县', '211324');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1793402889f8476650de01476666acbf', '辽宁省', '210000', '朝阳市', '211300', '北票市', '211381');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1794402889f8476650de01476666acbf', '辽宁省', '210000', '朝阳市', '211300', '凌源市', '211382');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1795402889f8476650de01476666acbf', '辽宁省', '210000', '葫芦岛市', '211400', '连山区', '211402');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1796402889f8476650de01476666acbf', '辽宁省', '210000', '葫芦岛市', '211400', '龙港区', '211403');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1797402889f8476650de01476666acbf', '辽宁省', '210000', '葫芦岛市', '211400', '南票区', '211404');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1798402889f8476650de01476666acbf', '辽宁省', '210000', '葫芦岛市', '211400', '绥中县', '211421');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1799402889f8476650de01476666acbf', '辽宁省', '210000', '葫芦岛市', '211400', '建昌县', '211422');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1800402889f8476650de01476666acbf', '辽宁省', '210000', '葫芦岛市', '211400', '兴城市', '211481');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1801402889f8476650de01476666acbf', '吉林省', '220000', '长春市', '220100', '南关区', '220102');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1802402889f8476650de01476666acbf', '吉林省', '220000', '长春市', '220100', '宽城区', '220103');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1803402889f8476650de01476666acbf', '吉林省', '220000', '长春市', '220100', '朝阳区', '220104');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1804402889f8476650de01476666acbf', '吉林省', '220000', '长春市', '220100', '二道区', '220105');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1805402889f8476650de01476666acbf', '吉林省', '220000', '长春市', '220100', '绿园区', '220106');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1806402889f8476650de01476666acbf', '吉林省', '220000', '长春市', '220100', '双阳区', '220112');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1807402889f8476650de01476666acbf', '吉林省', '220000', '长春市', '220100', '农安县', '220122');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1808402889f8476650de01476666acbf', '吉林省', '220000', '长春市', '220100', '九台市', '220181');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1809402889f8476650de01476666acbf', '吉林省', '220000', '长春市', '220100', '榆树市', '220182');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1810402889f8476650de01476666acbf', '吉林省', '220000', '长春市', '220100', '德惠市', '220183');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1811402889f8476650de01476666acbf', '吉林省', '220000', '吉林市', '220200', '昌邑区', '220202');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1812402889f8476650de01476666acbf', '吉林省', '220000', '吉林市', '220200', '龙潭区', '220203');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1813402889f8476650de01476666acbf', '吉林省', '220000', '吉林市', '220200', '船营区', '220204');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1814402889f8476650de01476666acbf', '吉林省', '220000', '吉林市', '220200', '丰满区', '220211');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1815402889f8476650de01476666acbf', '吉林省', '220000', '吉林市', '220200', '永吉县', '220221');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1816402889f8476650de01476666acbf', '吉林省', '220000', '吉林市', '220200', '蛟河市', '220281');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1817402889f8476650de01476666acbf', '吉林省', '220000', '吉林市', '220200', '桦甸市', '220282');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1818402889f8476650de01476666acbf', '吉林省', '220000', '吉林市', '220200', '舒兰市', '220283');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1819402889f8476650de01476666acbf', '吉林省', '220000', '吉林市', '220200', '磐石市', '220284');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1820402889f8476650de01476666acbf', '吉林省', '220000', '四平市', '220300', '铁西区', '220302');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1821402889f8476650de01476666acbf', '吉林省', '220000', '四平市', '220300', '铁东区', '220303');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1822402889f8476650de01476666acbf', '吉林省', '220000', '四平市', '220300', '梨树县', '220322');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1823402889f8476650de01476666acbf', '吉林省', '220000', '四平市', '220300', '伊通满族自治县', '220323');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1824402889f8476650de01476666acbf', '吉林省', '220000', '四平市', '220300', '公主岭市', '220381');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1825402889f8476650de01476666acbf', '吉林省', '220000', '四平市', '220300', '双辽市', '220382');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1826402889f8476650de01476666acbf', '吉林省', '220000', '辽源市', '220400', '龙山区', '220402');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1827402889f8476650de01476666acbf', '吉林省', '220000', '辽源市', '220400', '西安区', '220403');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1828402889f8476650de01476666acbf', '吉林省', '220000', '辽源市', '220400', '东丰县', '220421');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1829402889f8476650de01476666acbf', '吉林省', '220000', '辽源市', '220400', '东辽县', '220422');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1830402889f8476650de01476666acbf', '吉林省', '220000', '通化市', '220500', '东昌区', '220502');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1831402889f8476650de01476666acbf', '吉林省', '220000', '通化市', '220500', '二道江区', '220503');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1832402889f8476650de01476666acbf', '吉林省', '220000', '通化市', '220500', '通化县', '220521');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1833402889f8476650de01476666acbf', '吉林省', '220000', '通化市', '220500', '辉南县', '220523');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1834402889f8476650de01476666acbf', '吉林省', '220000', '通化市', '220500', '柳河县', '220524');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1835402889f8476650de01476666acbf', '吉林省', '220000', '通化市', '220500', '梅河口市', '220581');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1836402889f8476650de01476666acbf', '吉林省', '220000', '通化市', '220500', '集安市', '220582');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1837402889f8476650de01476666acbf', '吉林省', '220000', '白山市', '220600', '浑江区', '220602');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1838402889f8476650de01476666acbf', '吉林省', '220000', '白山市', '220600', '江源区', '220605');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1839402889f8476650de01476666acbf', '吉林省', '220000', '白山市', '220600', '抚松县', '220621');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1840402889f8476650de01476666acbf', '吉林省', '220000', '白山市', '220600', '靖宇县', '220622');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1841402889f8476650de01476666acbf', '吉林省', '220000', '白山市', '220600', '长白朝鲜族自治县', '220623');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1842402889f8476650de01476666acbf', '吉林省', '220000', '白山市', '220600', '临江市', '220681');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1843402889f8476650de01476666acbf', '吉林省', '220000', '松原市', '220700', '宁江区', '220702');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1844402889f8476650de01476666acbf', '吉林省', '220000', '松原市', '220700', '前郭尔罗斯蒙古族自治县', '220721');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1845402889f8476650de01476666acbf', '吉林省', '220000', '松原市', '220700', '长岭县', '220722');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1846402889f8476650de01476666acbf', '吉林省', '220000', '松原市', '220700', '乾安县', '220723');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1847402889f8476650de01476666acbf', '吉林省', '220000', '松原市', '220700', '扶余县', '220724');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1848402889f8476650de01476666acbf', '吉林省', '220000', '白城市', '220800', '洮北区', '220802');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1849402889f8476650de01476666acbf', '吉林省', '220000', '白城市', '220800', '镇赉县', '220821');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1850402889f8476650de01476666acbf', '吉林省', '220000', '白城市', '220800', '通榆县', '220822');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1851402889f8476650de01476666acbf', '吉林省', '220000', '白城市', '220800', '洮南市', '220881');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1852402889f8476650de01476666acbf', '吉林省', '220000', '白城市', '220800', '大安市', '220882');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1853402889f8476650de01476666acbf', '吉林省', '220000', '延边朝鲜族自治州', '220900', '延吉市', '222401');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1854402889f8476650de01476666acbf', '吉林省', '220000', '延边朝鲜族自治州', '220900', '图们市', '222402');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1855402889f8476650de01476666acbf', '吉林省', '220000', '延边朝鲜族自治州', '220900', '敦化市', '222403');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1856402889f8476650de01476666acbf', '吉林省', '220000', '延边朝鲜族自治州', '220900', '珲春市', '222404');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1857402889f8476650de01476666acbf', '吉林省', '220000', '延边朝鲜族自治州', '220900', '龙井市', '222405');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1858402889f8476650de01476666acbf', '吉林省', '220000', '延边朝鲜族自治州', '220900', '和龙市', '222406');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1859402889f8476650de01476666acbf', '吉林省', '220000', '延边朝鲜族自治州', '220900', '汪清县', '222424');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1860402889f8476650de01476666acbf', '吉林省', '220000', '延边朝鲜族自治州', '220900', '安图县', '222426');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1861402889f8476650de01476666acbf', '黑龙江省', '230000', '哈尔滨市', '230100', '道里区', '230102');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1862402889f8476650de01476666acbf', '黑龙江省', '230000', '哈尔滨市', '230100', '南岗区', '230103');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1863402889f8476650de01476666acbf', '黑龙江省', '230000', '哈尔滨市', '230100', '道外区', '230104');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1864402889f8476650de01476666acbf', '黑龙江省', '230000', '哈尔滨市', '230100', '平房区', '230108');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1865402889f8476650de01476666acbf', '黑龙江省', '230000', '哈尔滨市', '230100', '松北区', '230109');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1866402889f8476650de01476666acbf', '黑龙江省', '230000', '哈尔滨市', '230100', '香坊区', '230110');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1867402889f8476650de01476666acbf', '黑龙江省', '230000', '哈尔滨市', '230100', '呼兰区', '230111');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1868402889f8476650de01476666acbf', '黑龙江省', '230000', '哈尔滨市', '230100', '阿城区', '230112');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1869402889f8476650de01476666acbf', '黑龙江省', '230000', '哈尔滨市', '230100', '依兰县', '230123');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1870402889f8476650de01476666acbf', '黑龙江省', '230000', '哈尔滨市', '230100', '方正县', '230124');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1871402889f8476650de01476666acbf', '黑龙江省', '230000', '哈尔滨市', '230100', '宾县', '230125');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1872402889f8476650de01476666acbf', '黑龙江省', '230000', '哈尔滨市', '230100', '巴彦县', '230126');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1873402889f8476650de01476666acbf', '黑龙江省', '230000', '哈尔滨市', '230100', '木兰县', '230127');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1874402889f8476650de01476666acbf', '黑龙江省', '230000', '哈尔滨市', '230100', '通河县', '230128');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1875402889f8476650de01476666acbf', '黑龙江省', '230000', '哈尔滨市', '230100', '延寿县', '230129');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1876402889f8476650de01476666acbf', '黑龙江省', '230000', '哈尔滨市', '230100', '双城市', '230182');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1877402889f8476650de01476666acbf', '黑龙江省', '230000', '哈尔滨市', '230100', '尚志市', '230183');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1878402889f8476650de01476666acbf', '黑龙江省', '230000', '哈尔滨市', '230100', '五常市', '230184');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1879402889f8476650de01476666acbf', '黑龙江省', '230000', '齐齐哈尔市', '230200', '龙沙区', '230202');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1880402889f8476650de01476666acbf', '黑龙江省', '230000', '齐齐哈尔市', '230200', '建华区', '230203');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1881402889f8476650de01476666acbf', '黑龙江省', '230000', '齐齐哈尔市', '230200', '铁锋区', '230204');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1882402889f8476650de01476666acbf', '黑龙江省', '230000', '齐齐哈尔市', '230200', '昂昂溪区', '230205');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1883402889f8476650de01476666acbf', '黑龙江省', '230000', '齐齐哈尔市', '230200', '富拉尔基区', '230206');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1884402889f8476650de01476666acbf', '黑龙江省', '230000', '齐齐哈尔市', '230200', '碾子山区', '230207');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1885402889f8476650de01476666acbf', '黑龙江省', '230000', '齐齐哈尔市', '230200', '梅里斯达斡尔族区', '230208');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1886402889f8476650de01476666acbf', '黑龙江省', '230000', '齐齐哈尔市', '230200', '龙江县', '230221');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1887402889f8476650de01476666acbf', '黑龙江省', '230000', '齐齐哈尔市', '230200', '依安县', '230223');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1888402889f8476650de01476666acbf', '黑龙江省', '230000', '齐齐哈尔市', '230200', '泰来县', '230224');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1889402889f8476650de01476666acbf', '黑龙江省', '230000', '齐齐哈尔市', '230200', '甘南县', '230225');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1890402889f8476650de01476666acbf', '黑龙江省', '230000', '齐齐哈尔市', '230200', '富裕县', '230227');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1891402889f8476650de01476666acbf', '黑龙江省', '230000', '齐齐哈尔市', '230200', '克山县', '230229');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1892402889f8476650de01476666acbf', '黑龙江省', '230000', '齐齐哈尔市', '230200', '克东县', '230230');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1893402889f8476650de01476666acbf', '黑龙江省', '230000', '齐齐哈尔市', '230200', '拜泉县', '230231');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1894402889f8476650de01476666acbf', '黑龙江省', '230000', '齐齐哈尔市', '230200', '讷河市', '230281');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1895402889f8476650de01476666acbf', '黑龙江省', '230000', '鸡西市', '230300', '鸡冠区', '230302');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1896402889f8476650de01476666acbf', '黑龙江省', '230000', '鸡西市', '230300', '恒山区', '230303');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1897402889f8476650de01476666acbf', '黑龙江省', '230000', '鸡西市', '230300', '滴道区', '230304');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1898402889f8476650de01476666acbf', '黑龙江省', '230000', '鸡西市', '230300', '梨树区', '230305');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1899402889f8476650de01476666acbf', '黑龙江省', '230000', '鸡西市', '230300', '城子河区', '230306');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1900402889f8476650de01476666acbf', '黑龙江省', '230000', '鸡西市', '230300', '麻山区', '230307');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1901402889f8476650de01476666acbf', '黑龙江省', '230000', '鸡西市', '230300', '鸡东县', '230321');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1902402889f8476650de01476666acbf', '黑龙江省', '230000', '鸡西市', '230300', '虎林市', '230381');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1903402889f8476650de01476666acbf', '黑龙江省', '230000', '鸡西市', '230300', '密山市', '230382');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1904402889f8476650de01476666acbf', '黑龙江省', '230000', '鹤岗市', '230400', '向阳区', '230402');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1905402889f8476650de01476666acbf', '黑龙江省', '230000', '鹤岗市', '230400', '工农区', '230403');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1906402889f8476650de01476666acbf', '黑龙江省', '230000', '鹤岗市', '230400', '南山区', '230404');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1907402889f8476650de01476666acbf', '黑龙江省', '230000', '鹤岗市', '230400', '兴安区', '230405');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1908402889f8476650de01476666acbf', '黑龙江省', '230000', '鹤岗市', '230400', '东山区', '230406');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1909402889f8476650de01476666acbf', '黑龙江省', '230000', '鹤岗市', '230400', '兴山区', '230407');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1910402889f8476650de01476666acbf', '黑龙江省', '230000', '鹤岗市', '230400', '萝北县', '230421');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1911402889f8476650de01476666acbf', '黑龙江省', '230000', '鹤岗市', '230400', '绥滨县', '230422');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1912402889f8476650de01476666acbf', '黑龙江省', '230000', '双鸭山市', '230500', '尖山区', '230502');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1913402889f8476650de01476666acbf', '黑龙江省', '230000', '双鸭山市', '230500', '岭东区', '230503');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1914402889f8476650de01476666acbf', '黑龙江省', '230000', '双鸭山市', '230500', '四方台区', '230505');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1915402889f8476650de01476666acbf', '黑龙江省', '230000', '双鸭山市', '230500', '宝山区', '230506');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1916402889f8476650de01476666acbf', '黑龙江省', '230000', '双鸭山市', '230500', '集贤县', '230521');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1917402889f8476650de01476666acbf', '黑龙江省', '230000', '双鸭山市', '230500', '友谊县', '230522');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1918402889f8476650de01476666acbf', '黑龙江省', '230000', '双鸭山市', '230500', '宝清县', '230523');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1919402889f8476650de01476666acbf', '黑龙江省', '230000', '双鸭山市', '230500', '饶河县', '230524');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1920402889f8476650de01476666acbf', '黑龙江省', '230000', '大庆市', '230600', '萨尔图区', '230602');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1921402889f8476650de01476666acbf', '黑龙江省', '230000', '大庆市', '230600', '龙凤区', '230603');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1922402889f8476650de01476666acbf', '黑龙江省', '230000', '大庆市', '230600', '让胡路区', '230604');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1923402889f8476650de01476666acbf', '黑龙江省', '230000', '大庆市', '230600', '红岗区', '230605');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1924402889f8476650de01476666acbf', '黑龙江省', '230000', '大庆市', '230600', '大同区', '230606');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1925402889f8476650de01476666acbf', '黑龙江省', '230000', '大庆市', '230600', '肇州县', '230621');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1926402889f8476650de01476666acbf', '黑龙江省', '230000', '大庆市', '230600', '肇源县', '230622');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1927402889f8476650de01476666acbf', '黑龙江省', '230000', '大庆市', '230600', '林甸县', '230623');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1928402889f8476650de01476666acbf', '黑龙江省', '230000', '大庆市', '230600', '杜尔伯特蒙古族自治县', '230624');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1929402889f8476650de01476666acbf', '黑龙江省', '230000', '伊春市', '230700', '伊春区', '230702');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1930402889f8476650de01476666acbf', '黑龙江省', '230000', '伊春市', '230700', '南岔区', '230703');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1931402889f8476650de01476666acbf', '黑龙江省', '230000', '伊春市', '230700', '友好区', '230704');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1932402889f8476650de01476666acbf', '黑龙江省', '230000', '伊春市', '230700', '西林区', '230705');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1933402889f8476650de01476666acbf', '黑龙江省', '230000', '伊春市', '230700', '翠峦区', '230706');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1934402889f8476650de01476666acbf', '黑龙江省', '230000', '伊春市', '230700', '新青区', '230707');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1935402889f8476650de01476666acbf', '黑龙江省', '230000', '伊春市', '230700', '美溪区', '230708');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1936402889f8476650de01476666acbf', '黑龙江省', '230000', '伊春市', '230700', '金山屯区', '230709');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1937402889f8476650de01476666acbf', '黑龙江省', '230000', '伊春市', '230700', '五营区', '230710');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1938402889f8476650de01476666acbf', '黑龙江省', '230000', '伊春市', '230700', '乌马河区', '230711');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1939402889f8476650de01476666acbf', '黑龙江省', '230000', '伊春市', '230700', '汤旺河区', '230712');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1940402889f8476650de01476666acbf', '黑龙江省', '230000', '伊春市', '230700', '带岭区', '230713');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1941402889f8476650de01476666acbf', '黑龙江省', '230000', '伊春市', '230700', '乌伊岭区', '230714');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1942402889f8476650de01476666acbf', '黑龙江省', '230000', '伊春市', '230700', '红星区', '230715');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1943402889f8476650de01476666acbf', '黑龙江省', '230000', '伊春市', '230700', '上甘岭区', '230716');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1944402889f8476650de01476666acbf', '黑龙江省', '230000', '伊春市', '230700', '嘉荫县', '230722');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1945402889f8476650de01476666acbf', '黑龙江省', '230000', '伊春市', '230700', '铁力市', '230781');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1946402889f8476650de01476666acbf', '黑龙江省', '230000', '佳木斯市', '230800', '向阳区', '230803');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1947402889f8476650de01476666acbf', '黑龙江省', '230000', '佳木斯市', '230800', '前进区', '230804');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1948402889f8476650de01476666acbf', '黑龙江省', '230000', '佳木斯市', '230800', '东风区', '230805');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1949402889f8476650de01476666acbf', '黑龙江省', '230000', '佳木斯市', '230800', '郊区', '230811');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1950402889f8476650de01476666acbf', '黑龙江省', '230000', '佳木斯市', '230800', '桦南县', '230822');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1951402889f8476650de01476666acbf', '黑龙江省', '230000', '佳木斯市', '230800', '桦川县', '230826');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1952402889f8476650de01476666acbf', '黑龙江省', '230000', '佳木斯市', '230800', '汤原县', '230828');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1953402889f8476650de01476666acbf', '黑龙江省', '230000', '佳木斯市', '230800', '抚远县', '230833');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1954402889f8476650de01476666acbf', '黑龙江省', '230000', '佳木斯市', '230800', '同江市', '230881');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1955402889f8476650de01476666acbf', '黑龙江省', '230000', '佳木斯市', '230800', '富锦市', '230882');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1956402889f8476650de01476666acbf', '黑龙江省', '230000', '七台河市', '230900', '新兴区', '230902');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1957402889f8476650de01476666acbf', '黑龙江省', '230000', '七台河市', '230900', '桃山区', '230903');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1958402889f8476650de01476666acbf', '黑龙江省', '230000', '七台河市', '230900', '茄子河区', '230904');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1959402889f8476650de01476666acbf', '黑龙江省', '230000', '七台河市', '230900', '勃利县', '230921');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1960402889f8476650de01476666acbf', '黑龙江省', '230000', '牡丹江市', '231000', '东安区', '231002');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1961402889f8476650de01476666acbf', '黑龙江省', '230000', '牡丹江市', '231000', '阳明区', '231003');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1962402889f8476650de01476666acbf', '黑龙江省', '230000', '牡丹江市', '231000', '爱民区', '231004');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1963402889f8476650de01476666acbf', '黑龙江省', '230000', '牡丹江市', '231000', '西安区', '231005');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1964402889f8476650de01476666acbf', '黑龙江省', '230000', '牡丹江市', '231000', '东宁县', '231024');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1965402889f8476650de01476666acbf', '黑龙江省', '230000', '牡丹江市', '231000', '林口县', '231025');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1966402889f8476650de01476666acbf', '黑龙江省', '230000', '牡丹江市', '231000', '绥芬河市', '231081');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1967402889f8476650de01476666acbf', '黑龙江省', '230000', '牡丹江市', '231000', '海林市', '231083');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1968402889f8476650de01476666acbf', '黑龙江省', '230000', '牡丹江市', '231000', '宁安市', '231084');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1969402889f8476650de01476666acbf', '黑龙江省', '230000', '牡丹江市', '231000', '穆棱市', '231085');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1970402889f8476650de01476666acbf', '黑龙江省', '230000', '黑河市', '231100', '爱辉区', '231102');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1971402889f8476650de01476666acbf', '黑龙江省', '230000', '黑河市', '231100', '嫩江县', '231121');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1972402889f8476650de01476666acbf', '黑龙江省', '230000', '黑河市', '231100', '逊克县', '231123');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1973402889f8476650de01476666acbf', '黑龙江省', '230000', '黑河市', '231100', '孙吴县', '231124');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1974402889f8476650de01476666acbf', '黑龙江省', '230000', '黑河市', '231100', '北安市', '231181');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1975402889f8476650de01476666acbf', '黑龙江省', '230000', '黑河市', '231100', '五大连池市', '231182');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1976402889f8476650de01476666acbf', '黑龙江省', '230000', '绥化市', '231200', '北林区', '231202');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1977402889f8476650de01476666acbf', '黑龙江省', '230000', '绥化市', '231200', '望奎县', '231221');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1978402889f8476650de01476666acbf', '黑龙江省', '230000', '绥化市', '231200', '兰西县', '231222');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1979402889f8476650de01476666acbf', '黑龙江省', '230000', '绥化市', '231200', '青冈县', '231223');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1980402889f8476650de01476666acbf', '黑龙江省', '230000', '绥化市', '231200', '庆安县', '231224');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1981402889f8476650de01476666acbf', '黑龙江省', '230000', '绥化市', '231200', '明水县', '231225');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1982402889f8476650de01476666acbf', '黑龙江省', '230000', '绥化市', '231200', '绥棱县', '231226');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1983402889f8476650de01476666acbf', '黑龙江省', '230000', '绥化市', '231200', '安达市', '231281');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1984402889f8476650de01476666acbf', '黑龙江省', '230000', '绥化市', '231200', '肇东市', '231282');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1985402889f8476650de01476666acbf', '黑龙江省', '230000', '绥化市', '231200', '海伦市', '231283');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1986402889f8476650de01476666acbf', '黑龙江省', '230000', '大兴安岭地区', '231300', '呼玛县', '232721');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1987402889f8476650de01476666acbf', '黑龙江省', '230000', '大兴安岭地区', '231300', '塔河县', '232722');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1988402889f8476650de01476666acbf', '黑龙江省', '230000', '大兴安岭地区', '231300', '漠河县', '232723');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1989402889f8476650de01476666acbf', '上海市', '310000', '上海市', '310000', '黄浦区', '310101');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1990402889f8476650de01476666acbf', '上海市', '310000', '上海市', '310000', '徐汇区', '310104');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1991402889f8476650de01476666acbf', '上海市', '310000', '上海市', '310000', '长宁区', '310105');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1992402889f8476650de01476666acbf', '上海市', '310000', '上海市', '310000', '静安区', '310106');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2422402889f8476650de01476666acbf', '上海市', '310000', '上海市', '310000', '普陀区', '310107');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2423402889f8476650de01476666acbf', '上海市', '310000', '上海市', '310000', '闸北区', '310108');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2424402889f8476650de01476666acbf', '上海市', '310000', '上海市', '310000', '虹口区', '310109');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2425402889f8476650de01476666acbf', '上海市', '310000', '上海市', '310000', '杨浦区', '310110');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2426402889f8476650de01476666acbf', '上海市', '310000', '上海市', '310000', '闵行区', '310112');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2427402889f8476650de01476666acbf', '上海市', '310000', '上海市', '310000', '宝山区', '310113');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2428402889f8476650de01476666acbf', '上海市', '310000', '上海市', '310000', '嘉定区', '310114');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2429402889f8476650de01476666acbf', '上海市', '310000', '上海市', '310000', '浦东新区', '310115');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2430402889f8476650de01476666acbf', '上海市', '310000', '上海市', '310000', '金山区', '310116');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2431402889f8476650de01476666acbf', '上海市', '310000', '上海市', '310000', '松江区', '310117');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2432402889f8476650de01476666acbf', '上海市', '310000', '上海市', '310000', '青浦区', '310118');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2433402889f8476650de01476666acbf', '上海市', '310000', '上海市', '310000', '奉贤区', '310120');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2434402889f8476650de01476666acbf', '上海市', '310000', '上海市', '310000', '崇明县', '310230');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2435402889f8476650de01476666acbf', '江苏省', '320000', '南京市', '320100', '玄武区', '320102');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2436402889f8476650de01476666acbf', '江苏省', '320000', '南京市', '320100', '白下区', '320103');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2437402889f8476650de01476666acbf', '江苏省', '320000', '南京市', '320100', '秦淮区', '320104');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2438402889f8476650de01476666acbf', '江苏省', '320000', '南京市', '320100', '建邺区', '320105');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2439402889f8476650de01476666acbf', '江苏省', '320000', '南京市', '320100', '鼓楼区', '320106');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2440402889f8476650de01476666acbf', '江苏省', '320000', '南京市', '320100', '下关区', '320107');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2441402889f8476650de01476666acbf', '江苏省', '320000', '南京市', '320100', '浦口区', '320111');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2442402889f8476650de01476666acbf', '江苏省', '320000', '南京市', '320100', '栖霞区', '320113');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2443402889f8476650de01476666acbf', '江苏省', '320000', '南京市', '320100', '雨花台区', '320114');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2444402889f8476650de01476666acbf', '江苏省', '320000', '南京市', '320100', '江宁区', '320115');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2445402889f8476650de01476666acbf', '江苏省', '320000', '南京市', '320100', '六合区', '320116');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2446402889f8476650de01476666acbf', '江苏省', '320000', '南京市', '320100', '溧水县', '320124');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2447402889f8476650de01476666acbf', '江苏省', '320000', '南京市', '320100', '高淳县', '320125');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2448402889f8476650de01476666acbf', '江苏省', '320000', '无锡市', '320200', '崇安区', '320202');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2449402889f8476650de01476666acbf', '江苏省', '320000', '无锡市', '320200', '南长区', '320203');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2450402889f8476650de01476666acbf', '江苏省', '320000', '无锡市', '320200', '北塘区', '320204');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2451402889f8476650de01476666acbf', '江苏省', '320000', '无锡市', '320200', '锡山区', '320205');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2452402889f8476650de01476666acbf', '江苏省', '320000', '无锡市', '320200', '惠山区', '320206');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2453402889f8476650de01476666acbf', '江苏省', '320000', '无锡市', '320200', '滨湖区', '320211');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2454402889f8476650de01476666acbf', '江苏省', '320000', '无锡市', '320200', '江阴市', '320281');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2455402889f8476650de01476666acbf', '江苏省', '320000', '无锡市', '320200', '宜兴市', '320282');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2456402889f8476650de01476666acbf', '江苏省', '320000', '徐州市', '320300', '鼓楼区', '320302');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2457402889f8476650de01476666acbf', '江苏省', '320000', '徐州市', '320300', '云龙区', '320303');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2458402889f8476650de01476666acbf', '江苏省', '320000', '徐州市', '320300', '贾汪区', '320305');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2459402889f8476650de01476666acbf', '江苏省', '320000', '徐州市', '320300', '泉山区', '320311');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2460402889f8476650de01476666acbf', '江苏省', '320000', '徐州市', '320300', '铜山区', '320312');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2461402889f8476650de01476666acbf', '江苏省', '320000', '徐州市', '320300', '丰县', '320321');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2462402889f8476650de01476666acbf', '江苏省', '320000', '徐州市', '320300', '沛县', '320322');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2463402889f8476650de01476666acbf', '江苏省', '320000', '徐州市', '320300', '睢宁县', '320324');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2464402889f8476650de01476666acbf', '江苏省', '320000', '徐州市', '320300', '新沂市', '320381');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2465402889f8476650de01476666acbf', '江苏省', '320000', '徐州市', '320300', '邳州市', '320382');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2466402889f8476650de01476666acbf', '江苏省', '320000', '常州市', '320400', '天宁区', '320402');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2467402889f8476650de01476666acbf', '江苏省', '320000', '常州市', '320400', '钟楼区', '320404');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2468402889f8476650de01476666acbf', '江苏省', '320000', '常州市', '320400', '戚墅堰区', '320405');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2469402889f8476650de01476666acbf', '江苏省', '320000', '常州市', '320400', '新北区', '320411');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2470402889f8476650de01476666acbf', '江苏省', '320000', '常州市', '320400', '武进区', '320412');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2471402889f8476650de01476666acbf', '江苏省', '320000', '常州市', '320400', '溧阳市', '320481');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2472402889f8476650de01476666acbf', '江苏省', '320000', '常州市', '320400', '金坛市', '320482');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2473402889f8476650de01476666acbf', '江苏省', '320000', '苏州市', '320500', '虎丘区', '320505');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2474402889f8476650de01476666acbf', '江苏省', '320000', '苏州市', '320500', '吴中区', '320506');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2475402889f8476650de01476666acbf', '江苏省', '320000', '苏州市', '320500', '相城区', '320507');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2476402889f8476650de01476666acbf', '江苏省', '320000', '苏州市', '320500', '姑苏区', '320508');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2477402889f8476650de01476666acbf', '江苏省', '320000', '苏州市', '320500', '吴江区', '320509');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2478402889f8476650de01476666acbf', '江苏省', '320000', '苏州市', '320500', '常熟市', '320581');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2479402889f8476650de01476666acbf', '江苏省', '320000', '苏州市', '320500', '张家港市', '320582');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2480402889f8476650de01476666acbf', '江苏省', '320000', '苏州市', '320500', '昆山市', '320583');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2481402889f8476650de01476666acbf', '江苏省', '320000', '苏州市', '320500', '太仓市', '320585');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2482402889f8476650de01476666acbf', '江苏省', '320000', '南通市', '320600', '崇川区', '320602');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2483402889f8476650de01476666acbf', '江苏省', '320000', '南通市', '320600', '港闸区', '320611');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2484402889f8476650de01476666acbf', '江苏省', '320000', '南通市', '320600', '通州区', '320612');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2485402889f8476650de01476666acbf', '江苏省', '320000', '南通市', '320600', '海安县', '320621');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2486402889f8476650de01476666acbf', '江苏省', '320000', '南通市', '320600', '如东县', '320623');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2487402889f8476650de01476666acbf', '江苏省', '320000', '南通市', '320600', '启东市', '320681');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2488402889f8476650de01476666acbf', '江苏省', '320000', '南通市', '320600', '如皋市', '320682');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2489402889f8476650de01476666acbf', '江苏省', '320000', '南通市', '320600', '海门市', '320684');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2490402889f8476650de01476666acbf', '江苏省', '320000', '连云港市', '320700', '连云区', '320703');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2491402889f8476650de01476666acbf', '江苏省', '320000', '连云港市', '320700', '新浦区', '320705');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2492402889f8476650de01476666acbf', '江苏省', '320000', '连云港市', '320700', '海州区', '320706');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2493402889f8476650de01476666acbf', '江苏省', '320000', '连云港市', '320700', '赣榆县', '320721');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2494402889f8476650de01476666acbf', '江苏省', '320000', '连云港市', '320700', '东海县', '320722');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2495402889f8476650de01476666acbf', '江苏省', '320000', '连云港市', '320700', '灌云县', '320723');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2496402889f8476650de01476666acbf', '江苏省', '320000', '连云港市', '320700', '灌南县', '320724');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2497402889f8476650de01476666acbf', '江苏省', '320000', '淮安市', '320800', '清河区', '320802');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2498402889f8476650de01476666acbf', '江苏省', '320000', '淮安市', '320800', '淮安区', '320803');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2499402889f8476650de01476666acbf', '江苏省', '320000', '淮安市', '320800', '淮阴区', '320804');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2500402889f8476650de01476666acbf', '江苏省', '320000', '淮安市', '320800', '清浦区', '320811');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2501402889f8476650de01476666acbf', '江苏省', '320000', '淮安市', '320800', '涟水县', '320826');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2502402889f8476650de01476666acbf', '江苏省', '320000', '淮安市', '320800', '洪泽县', '320829');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2503402889f8476650de01476666acbf', '江苏省', '320000', '淮安市', '320800', '盱眙县', '320830');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2504402889f8476650de01476666acbf', '江苏省', '320000', '淮安市', '320800', '金湖县', '320831');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2505402889f8476650de01476666acbf', '江苏省', '320000', '盐城市', '320900', '亭湖区', '320902');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2506402889f8476650de01476666acbf', '江苏省', '320000', '盐城市', '320900', '盐都区', '320903');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2507402889f8476650de01476666acbf', '江苏省', '320000', '盐城市', '320900', '响水县', '320921');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2508402889f8476650de01476666acbf', '江苏省', '320000', '盐城市', '320900', '滨海县', '320922');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2509402889f8476650de01476666acbf', '江苏省', '320000', '盐城市', '320900', '阜宁县', '320923');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2510402889f8476650de01476666acbf', '江苏省', '320000', '盐城市', '320900', '射阳县', '320924');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2511402889f8476650de01476666acbf', '江苏省', '320000', '盐城市', '320900', '建湖县', '320925');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2512402889f8476650de01476666acbf', '江苏省', '320000', '盐城市', '320900', '东台市', '320981');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2513402889f8476650de01476666acbf', '江苏省', '320000', '盐城市', '320900', '大丰市', '320982');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2514402889f8476650de01476666acbf', '江苏省', '320000', '扬州市', '321000', '广陵区', '321002');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2515402889f8476650de01476666acbf', '江苏省', '320000', '扬州市', '321000', '邗江区', '321003');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2516402889f8476650de01476666acbf', '江苏省', '320000', '扬州市', '321000', '江都区', '321012');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2517402889f8476650de01476666acbf', '江苏省', '320000', '扬州市', '321000', '宝应县', '321023');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2518402889f8476650de01476666acbf', '江苏省', '320000', '扬州市', '321000', '仪征市', '321081');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2519402889f8476650de01476666acbf', '江苏省', '320000', '扬州市', '321000', '高邮市', '321084');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2520402889f8476650de01476666acbf', '江苏省', '320000', '镇江市', '321100', '京口区', '321102');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2521402889f8476650de01476666acbf', '江苏省', '320000', '镇江市', '321100', '润州区', '321111');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2522402889f8476650de01476666acbf', '江苏省', '320000', '镇江市', '321100', '丹徒区', '321112');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2523402889f8476650de01476666acbf', '江苏省', '320000', '镇江市', '321100', '丹阳市', '321181');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2524402889f8476650de01476666acbf', '江苏省', '320000', '镇江市', '321100', '扬中市', '321182');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2525402889f8476650de01476666acbf', '江苏省', '320000', '镇江市', '321100', '句容市', '321183');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2526402889f8476650de01476666acbf', '江苏省', '320000', '泰州市', '321200', '海陵区', '321202');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2527402889f8476650de01476666acbf', '江苏省', '320000', '泰州市', '321200', '高港区', '321203');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2528402889f8476650de01476666acbf', '江苏省', '320000', '泰州市', '321200', '兴化市', '321281');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2529402889f8476650de01476666acbf', '江苏省', '320000', '泰州市', '321200', '靖江市', '321282');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2530402889f8476650de01476666acbf', '江苏省', '320000', '泰州市', '321200', '泰兴市', '321283');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2531402889f8476650de01476666acbf', '江苏省', '320000', '泰州市', '321200', '姜堰市', '321284');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2532402889f8476650de01476666acbf', '江苏省', '320000', '宿迁市', '321300', '宿城区', '321302');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2533402889f8476650de01476666acbf', '江苏省', '320000', '宿迁市', '321300', '宿豫区', '321311');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2534402889f8476650de01476666acbf', '江苏省', '320000', '宿迁市', '321300', '沭阳县', '321322');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2535402889f8476650de01476666acbf', '江苏省', '320000', '宿迁市', '321300', '泗阳县', '321323');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2536402889f8476650de01476666acbf', '江苏省', '320000', '宿迁市', '321300', '泗洪县', '321324');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2537402889f8476650de01476666acbf', '浙江省', '330000', '杭州市', '330100', '上城区', '330102');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2538402889f8476650de01476666acbf', '浙江省', '330000', '杭州市', '330100', '下城区', '330103');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2539402889f8476650de01476666acbf', '浙江省', '330000', '杭州市', '330100', '江干区', '330104');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2540402889f8476650de01476666acbf', '浙江省', '330000', '杭州市', '330100', '拱墅区', '330105');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2541402889f8476650de01476666acbf', '浙江省', '330000', '杭州市', '330100', '西湖区', '330106');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2542402889f8476650de01476666acbf', '浙江省', '330000', '杭州市', '330100', '滨江区', '330108');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2543402889f8476650de01476666acbf', '浙江省', '330000', '杭州市', '330100', '萧山区', '330109');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2544402889f8476650de01476666acbf', '浙江省', '330000', '杭州市', '330100', '余杭区', '330110');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2545402889f8476650de01476666acbf', '浙江省', '330000', '杭州市', '330100', '桐庐县', '330122');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2546402889f8476650de01476666acbf', '浙江省', '330000', '杭州市', '330100', '淳安县', '330127');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2547402889f8476650de01476666acbf', '浙江省', '330000', '杭州市', '330100', '建德市', '330182');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2548402889f8476650de01476666acbf', '浙江省', '330000', '杭州市', '330100', '富阳市', '330183');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2549402889f8476650de01476666acbf', '浙江省', '330000', '杭州市', '330100', '临安市', '330185');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2550402889f8476650de01476666acbf', '浙江省', '330000', '宁波市', '330200', '海曙区', '330203');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2551402889f8476650de01476666acbf', '浙江省', '330000', '宁波市', '330200', '江东区', '330204');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2552402889f8476650de01476666acbf', '浙江省', '330000', '宁波市', '330200', '江北区', '330205');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2553402889f8476650de01476666acbf', '浙江省', '330000', '宁波市', '330200', '北仑区', '330206');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2554402889f8476650de01476666acbf', '浙江省', '330000', '宁波市', '330200', '镇海区', '330211');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2555402889f8476650de01476666acbf', '浙江省', '330000', '宁波市', '330200', '鄞州区', '330212');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2556402889f8476650de01476666acbf', '浙江省', '330000', '宁波市', '330200', '象山县', '330225');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2557402889f8476650de01476666acbf', '浙江省', '330000', '宁波市', '330200', '宁海县', '330226');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2558402889f8476650de01476666acbf', '浙江省', '330000', '宁波市', '330200', '余姚市', '330281');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2559402889f8476650de01476666acbf', '浙江省', '330000', '宁波市', '330200', '慈溪市', '330282');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2560402889f8476650de01476666acbf', '浙江省', '330000', '宁波市', '330200', '奉化市', '330283');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2561402889f8476650de01476666acbf', '浙江省', '330000', '温州市', '330300', '鹿城区', '330302');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2562402889f8476650de01476666acbf', '浙江省', '330000', '温州市', '330300', '龙湾区', '330303');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2563402889f8476650de01476666acbf', '浙江省', '330000', '温州市', '330300', '瓯海区', '330304');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2564402889f8476650de01476666acbf', '浙江省', '330000', '温州市', '330300', '洞头县', '330322');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2565402889f8476650de01476666acbf', '浙江省', '330000', '温州市', '330300', '永嘉县', '330324');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2566402889f8476650de01476666acbf', '浙江省', '330000', '温州市', '330300', '平阳县', '330326');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2567402889f8476650de01476666acbf', '浙江省', '330000', '温州市', '330300', '苍南县', '330327');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2568402889f8476650de01476666acbf', '浙江省', '330000', '温州市', '330300', '文成县', '330328');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2569402889f8476650de01476666acbf', '浙江省', '330000', '温州市', '330300', '泰顺县', '330329');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2570402889f8476650de01476666acbf', '浙江省', '330000', '温州市', '330300', '瑞安市', '330381');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2571402889f8476650de01476666acbf', '浙江省', '330000', '温州市', '330300', '乐清市', '330382');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2572402889f8476650de01476666acbf', '浙江省', '330000', '嘉兴市', '330400', '南湖区', '330402');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2573402889f8476650de01476666acbf', '浙江省', '330000', '嘉兴市', '330400', '秀洲区', '330411');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2574402889f8476650de01476666acbf', '浙江省', '330000', '嘉兴市', '330400', '嘉善县', '330421');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2575402889f8476650de01476666acbf', '浙江省', '330000', '嘉兴市', '330400', '海盐县', '330424');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2576402889f8476650de01476666acbf', '浙江省', '330000', '嘉兴市', '330400', '海宁市', '330481');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2577402889f8476650de01476666acbf', '浙江省', '330000', '嘉兴市', '330400', '平湖市', '330482');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2578402889f8476650de01476666acbf', '浙江省', '330000', '嘉兴市', '330400', '桐乡市', '330483');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2579402889f8476650de01476666acbf', '浙江省', '330000', '湖州市', '330500', '吴兴区', '330502');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2580402889f8476650de01476666acbf', '浙江省', '330000', '湖州市', '330500', '南浔区', '330503');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2581402889f8476650de01476666acbf', '浙江省', '330000', '湖州市', '330500', '德清县', '330521');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2582402889f8476650de01476666acbf', '浙江省', '330000', '湖州市', '330500', '长兴县', '330522');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2583402889f8476650de01476666acbf', '浙江省', '330000', '湖州市', '330500', '安吉县', '330523');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2584402889f8476650de01476666acbf', '浙江省', '330000', '绍兴市', '330600', '越城区', '330602');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2585402889f8476650de01476666acbf', '浙江省', '330000', '绍兴市', '330600', '绍兴县', '330621');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2586402889f8476650de01476666acbf', '浙江省', '330000', '绍兴市', '330600', '新昌县', '330624');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2587402889f8476650de01476666acbf', '浙江省', '330000', '绍兴市', '330600', '诸暨市', '330681');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2588402889f8476650de01476666acbf', '浙江省', '330000', '绍兴市', '330600', '上虞市', '330682');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2589402889f8476650de01476666acbf', '浙江省', '330000', '绍兴市', '330600', '嵊州市', '330683');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2590402889f8476650de01476666acbf', '浙江省', '330000', '金华市', '330700', '婺城区', '330702');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2591402889f8476650de01476666acbf', '浙江省', '330000', '金华市', '330700', '金东区', '330703');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2592402889f8476650de01476666acbf', '浙江省', '330000', '金华市', '330700', '武义县', '330723');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2593402889f8476650de01476666acbf', '浙江省', '330000', '金华市', '330700', '浦江县', '330726');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2594402889f8476650de01476666acbf', '浙江省', '330000', '金华市', '330700', '磐安县', '330727');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2595402889f8476650de01476666acbf', '浙江省', '330000', '金华市', '330700', '兰溪市', '330781');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2596402889f8476650de01476666acbf', '浙江省', '330000', '金华市', '330700', '义乌市', '330782');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2597402889f8476650de01476666acbf', '浙江省', '330000', '金华市', '330700', '东阳市', '330783');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2598402889f8476650de01476666acbf', '浙江省', '330000', '金华市', '330700', '永康市', '330784');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2599402889f8476650de01476666acbf', '浙江省', '330000', '衢州市', '330800', '柯城区', '330802');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2600402889f8476650de01476666acbf', '浙江省', '330000', '衢州市', '330800', '衢江区', '330803');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2601402889f8476650de01476666acbf', '浙江省', '330000', '衢州市', '330800', '常山县', '330822');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2602402889f8476650de01476666acbf', '浙江省', '330000', '衢州市', '330800', '开化县', '330824');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2603402889f8476650de01476666acbf', '浙江省', '330000', '衢州市', '330800', '龙游县', '330825');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2604402889f8476650de01476666acbf', '浙江省', '330000', '衢州市', '330800', '江山市', '330881');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2605402889f8476650de01476666acbf', '浙江省', '330000', '舟山市', '330900', '定海区', '330902');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2606402889f8476650de01476666acbf', '浙江省', '330000', '舟山市', '330900', '普陀区', '330903');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2607402889f8476650de01476666acbf', '浙江省', '330000', '舟山市', '330900', '岱山县', '330921');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2608402889f8476650de01476666acbf', '浙江省', '330000', '舟山市', '330900', '嵊泗县', '330922');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2609402889f8476650de01476666acbf', '浙江省', '330000', '台州市', '331000', '椒江区', '331002');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2610402889f8476650de01476666acbf', '浙江省', '330000', '台州市', '331000', '黄岩区', '331003');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2611402889f8476650de01476666acbf', '浙江省', '330000', '台州市', '331000', '路桥区', '331004');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2612402889f8476650de01476666acbf', '浙江省', '330000', '台州市', '331000', '玉环县', '331021');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2613402889f8476650de01476666acbf', '浙江省', '330000', '台州市', '331000', '三门县', '331022');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2614402889f8476650de01476666acbf', '浙江省', '330000', '台州市', '331000', '天台县', '331023');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2615402889f8476650de01476666acbf', '浙江省', '330000', '台州市', '331000', '仙居县', '331024');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2616402889f8476650de01476666acbf', '浙江省', '330000', '台州市', '331000', '温岭市', '331081');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2617402889f8476650de01476666acbf', '浙江省', '330000', '台州市', '331000', '临海市', '331082');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2618402889f8476650de01476666acbf', '浙江省', '330000', '丽水市', '331100', '莲都区', '331102');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2619402889f8476650de01476666acbf', '浙江省', '330000', '丽水市', '331100', '青田县', '331121');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2620402889f8476650de01476666acbf', '浙江省', '330000', '丽水市', '331100', '缙云县', '331122');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2621402889f8476650de01476666acbf', '浙江省', '330000', '丽水市', '331100', '遂昌县', '331123');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2622402889f8476650de01476666acbf', '浙江省', '330000', '丽水市', '331100', '松阳县', '331124');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2623402889f8476650de01476666acbf', '浙江省', '330000', '丽水市', '331100', '云和县', '331125');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2624402889f8476650de01476666acbf', '浙江省', '330000', '丽水市', '331100', '庆元县', '331126');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2625402889f8476650de01476666acbf', '浙江省', '330000', '丽水市', '331100', '景宁畲族自治县', '331127');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2626402889f8476650de01476666acbf', '浙江省', '330000', '丽水市', '331100', '龙泉市', '331181');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2627402889f8476650de01476666acbf', '安徽省', '340000', '合肥市', '340100', '瑶海区', '340102');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2628402889f8476650de01476666acbf', '安徽省', '340000', '合肥市', '340100', '庐阳区', '340103');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2629402889f8476650de01476666acbf', '安徽省', '340000', '合肥市', '340100', '蜀山区', '340104');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2630402889f8476650de01476666acbf', '安徽省', '340000', '合肥市', '340100', '包河区', '340111');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2631402889f8476650de01476666acbf', '安徽省', '340000', '合肥市', '340100', '长丰县', '340121');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2632402889f8476650de01476666acbf', '安徽省', '340000', '合肥市', '340100', '肥东县', '340122');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2633402889f8476650de01476666acbf', '安徽省', '340000', '合肥市', '340100', '肥西县', '340123');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2634402889f8476650de01476666acbf', '安徽省', '340000', '合肥市', '340100', '庐江县', '340124');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2635402889f8476650de01476666acbf', '安徽省', '340000', '合肥市', '340100', '巢湖市', '340181');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2636402889f8476650de01476666acbf', '安徽省', '340000', '芜湖市', '340200', '镜湖区', '340202');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2637402889f8476650de01476666acbf', '安徽省', '340000', '芜湖市', '340200', '弋江区', '340203');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2638402889f8476650de01476666acbf', '安徽省', '340000', '芜湖市', '340200', '鸠江区', '340207');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2639402889f8476650de01476666acbf', '安徽省', '340000', '芜湖市', '340200', '三山区', '340208');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2640402889f8476650de01476666acbf', '安徽省', '340000', '芜湖市', '340200', '芜湖县', '340221');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2641402889f8476650de01476666acbf', '安徽省', '340000', '芜湖市', '340200', '繁昌县', '340222');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2642402889f8476650de01476666acbf', '安徽省', '340000', '芜湖市', '340200', '南陵县', '340223');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2643402889f8476650de01476666acbf', '安徽省', '340000', '芜湖市', '340200', '无为县', '340225');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2644402889f8476650de01476666acbf', '安徽省', '340000', '蚌埠市', '340300', '龙子湖区', '340302');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2645402889f8476650de01476666acbf', '安徽省', '340000', '蚌埠市', '340300', '蚌山区', '340303');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2646402889f8476650de01476666acbf', '安徽省', '340000', '蚌埠市', '340300', '禹会区', '340304');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2647402889f8476650de01476666acbf', '安徽省', '340000', '蚌埠市', '340300', '淮上区', '340311');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2648402889f8476650de01476666acbf', '安徽省', '340000', '蚌埠市', '340300', '怀远县', '340321');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2649402889f8476650de01476666acbf', '安徽省', '340000', '蚌埠市', '340300', '五河县', '340322');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2650402889f8476650de01476666acbf', '安徽省', '340000', '蚌埠市', '340300', '固镇县', '340323');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2651402889f8476650de01476666acbf', '安徽省', '340000', '淮南市', '340400', '大通区', '340402');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2652402889f8476650de01476666acbf', '安徽省', '340000', '淮南市', '340400', '田家庵区', '340403');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2653402889f8476650de01476666acbf', '安徽省', '340000', '淮南市', '340400', '谢家集区', '340404');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2654402889f8476650de01476666acbf', '安徽省', '340000', '淮南市', '340400', '八公山区', '340405');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2655402889f8476650de01476666acbf', '安徽省', '340000', '淮南市', '340400', '潘集区', '340406');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2656402889f8476650de01476666acbf', '安徽省', '340000', '淮南市', '340400', '凤台县', '340421');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2657402889f8476650de01476666acbf', '安徽省', '340000', '马鞍山市', '340500', '花山区', '340503');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2658402889f8476650de01476666acbf', '安徽省', '340000', '马鞍山市', '340500', '雨山区', '340504');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2659402889f8476650de01476666acbf', '安徽省', '340000', '马鞍山市', '340500', '博望区', '340506');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2660402889f8476650de01476666acbf', '安徽省', '340000', '马鞍山市', '340500', '当涂县', '340521');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2661402889f8476650de01476666acbf', '安徽省', '340000', '马鞍山市', '340500', '含山县', '340522');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2662402889f8476650de01476666acbf', '安徽省', '340000', '马鞍山市', '340500', '和县', '340523');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2663402889f8476650de01476666acbf', '安徽省', '340000', '淮北市', '340600', '杜集区', '340602');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2664402889f8476650de01476666acbf', '安徽省', '340000', '淮北市', '340600', '相山区', '340603');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2665402889f8476650de01476666acbf', '安徽省', '340000', '淮北市', '340600', '烈山区', '340604');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2666402889f8476650de01476666acbf', '安徽省', '340000', '淮北市', '340600', '濉溪县', '340621');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2667402889f8476650de01476666acbf', '安徽省', '340000', '铜陵市', '340700', '铜官山区', '340702');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2668402889f8476650de01476666acbf', '安徽省', '340000', '铜陵市', '340700', '狮子山区', '340703');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2669402889f8476650de01476666acbf', '安徽省', '340000', '铜陵市', '340700', '郊区', '340711');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2670402889f8476650de01476666acbf', '安徽省', '340000', '铜陵市', '340700', '铜陵县', '340721');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2671402889f8476650de01476666acbf', '安徽省', '340000', '安庆市', '340800', '迎江区', '340802');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2672402889f8476650de01476666acbf', '安徽省', '340000', '安庆市', '340800', '大观区', '340803');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2673402889f8476650de01476666acbf', '安徽省', '340000', '安庆市', '340800', '宜秀区', '340811');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2674402889f8476650de01476666acbf', '安徽省', '340000', '安庆市', '340800', '怀宁县', '340822');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2675402889f8476650de01476666acbf', '安徽省', '340000', '安庆市', '340800', '枞阳县', '340823');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2676402889f8476650de01476666acbf', '安徽省', '340000', '安庆市', '340800', '潜山县', '340824');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2677402889f8476650de01476666acbf', '安徽省', '340000', '安庆市', '340800', '太湖县', '340825');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2678402889f8476650de01476666acbf', '安徽省', '340000', '安庆市', '340800', '宿松县', '340826');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2679402889f8476650de01476666acbf', '安徽省', '340000', '安庆市', '340800', '望江县', '340827');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2680402889f8476650de01476666acbf', '安徽省', '340000', '安庆市', '340800', '岳西县', '340828');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2681402889f8476650de01476666acbf', '安徽省', '340000', '安庆市', '340800', '桐城市', '340881');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2682402889f8476650de01476666acbf', '安徽省', '340000', '黄山市', '341000', '屯溪区', '341002');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2683402889f8476650de01476666acbf', '安徽省', '340000', '黄山市', '341000', '黄山区', '341003');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2684402889f8476650de01476666acbf', '安徽省', '340000', '黄山市', '341000', '徽州区', '341004');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2685402889f8476650de01476666acbf', '安徽省', '340000', '黄山市', '341000', '歙县', '341021');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2686402889f8476650de01476666acbf', '安徽省', '340000', '黄山市', '341000', '休宁县', '341022');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2687402889f8476650de01476666acbf', '安徽省', '340000', '黄山市', '341000', '黟县', '341023');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2688402889f8476650de01476666acbf', '安徽省', '340000', '黄山市', '341000', '祁门县', '341024');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2689402889f8476650de01476666acbf', '安徽省', '340000', '滁州市', '341100', '琅琊区', '341102');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2690402889f8476650de01476666acbf', '安徽省', '340000', '滁州市', '341100', '南谯区', '341103');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2691402889f8476650de01476666acbf', '安徽省', '340000', '滁州市', '341100', '来安县', '341122');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2692402889f8476650de01476666acbf', '安徽省', '340000', '滁州市', '341100', '全椒县', '341124');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2693402889f8476650de01476666acbf', '安徽省', '340000', '滁州市', '341100', '定远县', '341125');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2694402889f8476650de01476666acbf', '安徽省', '340000', '滁州市', '341100', '凤阳县', '341126');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2695402889f8476650de01476666acbf', '安徽省', '340000', '滁州市', '341100', '天长市', '341181');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2696402889f8476650de01476666acbf', '安徽省', '340000', '滁州市', '341100', '明光市', '341182');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2697402889f8476650de01476666acbf', '安徽省', '340000', '阜阳市', '341200', '颍州区', '341202');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2698402889f8476650de01476666acbf', '安徽省', '340000', '阜阳市', '341200', '颍东区', '341203');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2699402889f8476650de01476666acbf', '安徽省', '340000', '阜阳市', '341200', '颍泉区', '341204');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2700402889f8476650de01476666acbf', '安徽省', '340000', '阜阳市', '341200', '临泉县', '341221');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2701402889f8476650de01476666acbf', '安徽省', '340000', '阜阳市', '341200', '太和县', '341222');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2702402889f8476650de01476666acbf', '安徽省', '340000', '阜阳市', '341200', '阜南县', '341225');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2703402889f8476650de01476666acbf', '安徽省', '340000', '阜阳市', '341200', '颍上县', '341226');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2704402889f8476650de01476666acbf', '安徽省', '340000', '阜阳市', '341200', '界首市', '341282');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2705402889f8476650de01476666acbf', '安徽省', '340000', '宿州市', '341300', '埇桥区', '341302');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2706402889f8476650de01476666acbf', '安徽省', '340000', '宿州市', '341300', '砀山县', '341321');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2707402889f8476650de01476666acbf', '安徽省', '340000', '宿州市', '341300', '萧县', '341322');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2708402889f8476650de01476666acbf', '安徽省', '340000', '宿州市', '341300', '灵璧县', '341323');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2709402889f8476650de01476666acbf', '安徽省', '340000', '宿州市', '341300', '泗县', '341324');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2710402889f8476650de01476666acbf', '安徽省', '340000', '六安市', '341500', '金安区', '341502');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2711402889f8476650de01476666acbf', '安徽省', '340000', '六安市', '341500', '裕安区', '341503');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2712402889f8476650de01476666acbf', '安徽省', '340000', '六安市', '341500', '寿县', '341521');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2713402889f8476650de01476666acbf', '安徽省', '340000', '六安市', '341500', '霍邱县', '341522');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2714402889f8476650de01476666acbf', '安徽省', '340000', '六安市', '341500', '舒城县', '341523');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2715402889f8476650de01476666acbf', '安徽省', '340000', '六安市', '341500', '金寨县', '341524');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2716402889f8476650de01476666acbf', '安徽省', '340000', '六安市', '341500', '霍山县', '341525');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2717402889f8476650de01476666acbf', '安徽省', '340000', '亳州市', '341600', '谯城区', '341602');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2718402889f8476650de01476666acbf', '安徽省', '340000', '亳州市', '341600', '涡阳县', '341621');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2719402889f8476650de01476666acbf', '安徽省', '340000', '亳州市', '341600', '蒙城县', '341622');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2720402889f8476650de01476666acbf', '安徽省', '340000', '亳州市', '341600', '利辛县', '341623');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2721402889f8476650de01476666acbf', '安徽省', '340000', '池州市', '341700', '贵池区', '341702');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2722402889f8476650de01476666acbf', '安徽省', '340000', '池州市', '341700', '东至县', '341721');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2723402889f8476650de01476666acbf', '安徽省', '340000', '池州市', '341700', '石台县', '341722');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2724402889f8476650de01476666acbf', '安徽省', '340000', '池州市', '341700', '青阳县', '341723');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2725402889f8476650de01476666acbf', '安徽省', '340000', '宣城市', '341800', '宣州区', '341802');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2726402889f8476650de01476666acbf', '安徽省', '340000', '宣城市', '341800', '郎溪县', '341821');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2727402889f8476650de01476666acbf', '安徽省', '340000', '宣城市', '341800', '广德县', '341822');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2728402889f8476650de01476666acbf', '安徽省', '340000', '宣城市', '341800', '泾县', '341823');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2729402889f8476650de01476666acbf', '安徽省', '340000', '宣城市', '341800', '绩溪县', '341824');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2730402889f8476650de01476666acbf', '安徽省', '340000', '宣城市', '341800', '旌德县', '341825');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2731402889f8476650de01476666acbf', '安徽省', '340000', '宣城市', '341800', '宁国市', '341881');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2732402889f8476650de01476666acbf', '福建省', '350000', '福州市', '350100', '鼓楼区', '350102');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2733402889f8476650de01476666acbf', '福建省', '350000', '福州市', '350100', '台江区', '350103');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2734402889f8476650de01476666acbf', '福建省', '350000', '福州市', '350100', '仓山区', '350104');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2735402889f8476650de01476666acbf', '福建省', '350000', '福州市', '350100', '马尾区', '350105');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2736402889f8476650de01476666acbf', '福建省', '350000', '福州市', '350100', '晋安区', '350111');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2737402889f8476650de01476666acbf', '福建省', '350000', '福州市', '350100', '闽侯县', '350121');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2738402889f8476650de01476666acbf', '福建省', '350000', '福州市', '350100', '连江县', '350122');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2739402889f8476650de01476666acbf', '福建省', '350000', '福州市', '350100', '罗源县', '350123');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2740402889f8476650de01476666acbf', '福建省', '350000', '福州市', '350100', '闽清县', '350124');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2741402889f8476650de01476666acbf', '福建省', '350000', '福州市', '350100', '永泰县', '350125');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2742402889f8476650de01476666acbf', '福建省', '350000', '福州市', '350100', '平潭县', '350128');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2743402889f8476650de01476666acbf', '福建省', '350000', '福州市', '350100', '福清市', '350181');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2744402889f8476650de01476666acbf', '福建省', '350000', '福州市', '350100', '长乐市', '350182');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2745402889f8476650de01476666acbf', '福建省', '350000', '厦门市', '350200', '思明区', '350203');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2746402889f8476650de01476666acbf', '福建省', '350000', '厦门市', '350200', '海沧区', '350205');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2747402889f8476650de01476666acbf', '福建省', '350000', '厦门市', '350200', '湖里区', '350206');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2748402889f8476650de01476666acbf', '福建省', '350000', '厦门市', '350200', '集美区', '350211');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2749402889f8476650de01476666acbf', '福建省', '350000', '厦门市', '350200', '同安区', '350212');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2750402889f8476650de01476666acbf', '福建省', '350000', '厦门市', '350200', '翔安区', '350213');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2751402889f8476650de01476666acbf', '福建省', '350000', '莆田市', '350300', '城厢区', '350302');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2752402889f8476650de01476666acbf', '福建省', '350000', '莆田市', '350300', '涵江区', '350303');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2753402889f8476650de01476666acbf', '福建省', '350000', '莆田市', '350300', '荔城区', '350304');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2754402889f8476650de01476666acbf', '福建省', '350000', '莆田市', '350300', '秀屿区', '350305');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2755402889f8476650de01476666acbf', '福建省', '350000', '莆田市', '350300', '仙游县', '350322');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2756402889f8476650de01476666acbf', '福建省', '350000', '三明市', '350400', '梅列区', '350402');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2757402889f8476650de01476666acbf', '福建省', '350000', '三明市', '350400', '三元区', '350403');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2758402889f8476650de01476666acbf', '福建省', '350000', '三明市', '350400', '明溪县', '350421');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2759402889f8476650de01476666acbf', '福建省', '350000', '三明市', '350400', '清流县', '350423');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2760402889f8476650de01476666acbf', '福建省', '350000', '三明市', '350400', '宁化县', '350424');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2761402889f8476650de01476666acbf', '福建省', '350000', '三明市', '350400', '大田县', '350425');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2762402889f8476650de01476666acbf', '福建省', '350000', '三明市', '350400', '尤溪县', '350426');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2763402889f8476650de01476666acbf', '福建省', '350000', '三明市', '350400', '沙县', '350427');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2764402889f8476650de01476666acbf', '福建省', '350000', '三明市', '350400', '将乐县', '350428');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2765402889f8476650de01476666acbf', '福建省', '350000', '三明市', '350400', '泰宁县', '350429');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2766402889f8476650de01476666acbf', '福建省', '350000', '三明市', '350400', '建宁县', '350430');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2767402889f8476650de01476666acbf', '福建省', '350000', '三明市', '350400', '永安市', '350481');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2768402889f8476650de01476666acbf', '福建省', '350000', '泉州市', '350500', '鲤城区', '350502');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2769402889f8476650de01476666acbf', '福建省', '350000', '泉州市', '350500', '丰泽区', '350503');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2770402889f8476650de01476666acbf', '福建省', '350000', '泉州市', '350500', '洛江区', '350504');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2771402889f8476650de01476666acbf', '福建省', '350000', '泉州市', '350500', '泉港区', '350505');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2772402889f8476650de01476666acbf', '福建省', '350000', '泉州市', '350500', '惠安县', '350521');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2773402889f8476650de01476666acbf', '福建省', '350000', '泉州市', '350500', '安溪县', '350524');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2774402889f8476650de01476666acbf', '福建省', '350000', '泉州市', '350500', '永春县', '350525');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2775402889f8476650de01476666acbf', '福建省', '350000', '泉州市', '350500', '德化县', '350526');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2776402889f8476650de01476666acbf', '福建省', '350000', '泉州市', '350500', '金门县', '350527');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2777402889f8476650de01476666acbf', '福建省', '350000', '泉州市', '350500', '石狮市', '350581');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2778402889f8476650de01476666acbf', '福建省', '350000', '泉州市', '350500', '晋江市', '350582');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2779402889f8476650de01476666acbf', '福建省', '350000', '泉州市', '350500', '南安市', '350583');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2780402889f8476650de01476666acbf', '福建省', '350000', '漳州市', '350600', '芗城区', '350602');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2781402889f8476650de01476666acbf', '福建省', '350000', '漳州市', '350600', '龙文区', '350603');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2782402889f8476650de01476666acbf', '福建省', '350000', '漳州市', '350600', '云霄县', '350622');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2783402889f8476650de01476666acbf', '福建省', '350000', '漳州市', '350600', '漳浦县', '350623');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2784402889f8476650de01476666acbf', '福建省', '350000', '漳州市', '350600', '诏安县', '350624');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2785402889f8476650de01476666acbf', '福建省', '350000', '漳州市', '350600', '长泰县', '350625');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2786402889f8476650de01476666acbf', '福建省', '350000', '漳州市', '350600', '东山县', '350626');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2787402889f8476650de01476666acbf', '福建省', '350000', '漳州市', '350600', '南靖县', '350627');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2788402889f8476650de01476666acbf', '福建省', '350000', '漳州市', '350600', '平和县', '350628');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2789402889f8476650de01476666acbf', '福建省', '350000', '漳州市', '350600', '华安县', '350629');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2790402889f8476650de01476666acbf', '福建省', '350000', '漳州市', '350600', '龙海市', '350681');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2791402889f8476650de01476666acbf', '福建省', '350000', '南平市', '350700', '延平区', '350702');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2792402889f8476650de01476666acbf', '福建省', '350000', '南平市', '350700', '顺昌县', '350721');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2793402889f8476650de01476666acbf', '福建省', '350000', '南平市', '350700', '浦城县', '350722');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2794402889f8476650de01476666acbf', '福建省', '350000', '南平市', '350700', '光泽县', '350723');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2795402889f8476650de01476666acbf', '福建省', '350000', '南平市', '350700', '松溪县', '350724');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2796402889f8476650de01476666acbf', '福建省', '350000', '南平市', '350700', '政和县', '350725');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2797402889f8476650de01476666acbf', '福建省', '350000', '南平市', '350700', '邵武市', '350781');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2798402889f8476650de01476666acbf', '福建省', '350000', '南平市', '350700', '武夷山市', '350782');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2799402889f8476650de01476666acbf', '福建省', '350000', '南平市', '350700', '建瓯市', '350783');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2800402889f8476650de01476666acbf', '福建省', '350000', '南平市', '350700', '建阳市', '350784');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2801402889f8476650de01476666acbf', '福建省', '350000', '龙岩市', '350800', '新罗区', '350802');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2802402889f8476650de01476666acbf', '福建省', '350000', '龙岩市', '350800', '长汀县', '350821');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2803402889f8476650de01476666acbf', '福建省', '350000', '龙岩市', '350800', '永定县', '350822');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2804402889f8476650de01476666acbf', '福建省', '350000', '龙岩市', '350800', '上杭县', '350823');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2805402889f8476650de01476666acbf', '福建省', '350000', '龙岩市', '350800', '武平县', '350824');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2806402889f8476650de01476666acbf', '福建省', '350000', '龙岩市', '350800', '连城县', '350825');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2807402889f8476650de01476666acbf', '福建省', '350000', '龙岩市', '350800', '漳平市', '350881');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2808402889f8476650de01476666acbf', '福建省', '350000', '宁德市', '350900', '蕉城区', '350902');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2809402889f8476650de01476666acbf', '福建省', '350000', '宁德市', '350900', '霞浦县', '350921');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2810402889f8476650de01476666acbf', '福建省', '350000', '宁德市', '350900', '古田县', '350922');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2811402889f8476650de01476666acbf', '福建省', '350000', '宁德市', '350900', '屏南县', '350923');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2812402889f8476650de01476666acbf', '福建省', '350000', '宁德市', '350900', '寿宁县', '350924');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2813402889f8476650de01476666acbf', '福建省', '350000', '宁德市', '350900', '周宁县', '350925');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2814402889f8476650de01476666acbf', '福建省', '350000', '宁德市', '350900', '柘荣县', '350926');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2815402889f8476650de01476666acbf', '福建省', '350000', '宁德市', '350900', '福安市', '350981');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2816402889f8476650de01476666acbf', '福建省', '350000', '宁德市', '350900', '福鼎市', '350982');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2817402889f8476650de01476666acbf', '江西省', '360000', '南昌市', '360100', '东湖区', '360102');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2818402889f8476650de01476666acbf', '江西省', '360000', '南昌市', '360100', '西湖区', '360103');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2819402889f8476650de01476666acbf', '江西省', '360000', '南昌市', '360100', '青云谱区', '360104');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2820402889f8476650de01476666acbf', '江西省', '360000', '南昌市', '360100', '湾里区', '360105');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2821402889f8476650de01476666acbf', '江西省', '360000', '南昌市', '360100', '青山湖区', '360111');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2822402889f8476650de01476666acbf', '江西省', '360000', '南昌市', '360100', '南昌县', '360121');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2823402889f8476650de01476666acbf', '江西省', '360000', '南昌市', '360100', '新建县', '360122');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2824402889f8476650de01476666acbf', '江西省', '360000', '南昌市', '360100', '安义县', '360123');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2825402889f8476650de01476666acbf', '江西省', '360000', '南昌市', '360100', '进贤县', '360124');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2826402889f8476650de01476666acbf', '江西省', '360000', '景德镇市', '360200', '昌江区', '360202');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2827402889f8476650de01476666acbf', '江西省', '360000', '景德镇市', '360200', '珠山区', '360203');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2828402889f8476650de01476666acbf', '江西省', '360000', '景德镇市', '360200', '浮梁县', '360222');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2829402889f8476650de01476666acbf', '江西省', '360000', '景德镇市', '360200', '乐平市', '360281');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2830402889f8476650de01476666acbf', '江西省', '360000', '萍乡市', '360300', '安源区', '360302');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2831402889f8476650de01476666acbf', '江西省', '360000', '萍乡市', '360300', '湘东区', '360313');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2832402889f8476650de01476666acbf', '江西省', '360000', '萍乡市', '360300', '莲花县', '360321');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2833402889f8476650de01476666acbf', '江西省', '360000', '萍乡市', '360300', '上栗县', '360322');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2834402889f8476650de01476666acbf', '江西省', '360000', '萍乡市', '360300', '芦溪县', '360323');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2835402889f8476650de01476666acbf', '江西省', '360000', '九江市', '360400', '庐山区', '360402');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2836402889f8476650de01476666acbf', '江西省', '360000', '九江市', '360400', '浔阳区', '360403');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2837402889f8476650de01476666acbf', '江西省', '360000', '九江市', '360400', '九江县', '360421');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2838402889f8476650de01476666acbf', '江西省', '360000', '九江市', '360400', '武宁县', '360423');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2839402889f8476650de01476666acbf', '江西省', '360000', '九江市', '360400', '修水县', '360424');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2840402889f8476650de01476666acbf', '江西省', '360000', '九江市', '360400', '永修县', '360425');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2841402889f8476650de01476666acbf', '江西省', '360000', '九江市', '360400', '德安县', '360426');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2842402889f8476650de01476666acbf', '江西省', '360000', '九江市', '360400', '星子县', '360427');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2843402889f8476650de01476666acbf', '江西省', '360000', '九江市', '360400', '都昌县', '360428');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2844402889f8476650de01476666acbf', '江西省', '360000', '九江市', '360400', '湖口县', '360429');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2845402889f8476650de01476666acbf', '江西省', '360000', '九江市', '360400', '彭泽县', '360430');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2846402889f8476650de01476666acbf', '江西省', '360000', '九江市', '360400', '瑞昌市', '360481');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2847402889f8476650de01476666acbf', '江西省', '360000', '九江市', '360400', '共青城市', '360482');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2848402889f8476650de01476666acbf', '江西省', '360000', '新余市', '360500', '渝水区', '360502');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2849402889f8476650de01476666acbf', '江西省', '360000', '新余市', '360500', '分宜县', '360521');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2850402889f8476650de01476666acbf', '江西省', '360000', '鹰潭市', '360600', '月湖区', '360602');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2851402889f8476650de01476666acbf', '江西省', '360000', '鹰潭市', '360600', '余江县', '360622');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2852402889f8476650de01476666acbf', '江西省', '360000', '鹰潭市', '360600', '贵溪市', '360681');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2853402889f8476650de01476666acbf', '江西省', '360000', '赣州市', '360700', '章贡区', '360702');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2854402889f8476650de01476666acbf', '江西省', '360000', '赣州市', '360700', '赣县', '360721');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2855402889f8476650de01476666acbf', '江西省', '360000', '赣州市', '360700', '信丰县', '360722');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2856402889f8476650de01476666acbf', '江西省', '360000', '赣州市', '360700', '大余县', '360723');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2857402889f8476650de01476666acbf', '江西省', '360000', '赣州市', '360700', '上犹县', '360724');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2858402889f8476650de01476666acbf', '江西省', '360000', '赣州市', '360700', '崇义县', '360725');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2859402889f8476650de01476666acbf', '江西省', '360000', '赣州市', '360700', '安远县', '360726');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1344402889f8476650de01476666acbf', '江西省', '360000', '赣州市', '360700', '龙南县', '360727');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('75402889f8476650de01476666acbf00', '江西省', '360000', '赣州市', '360700', '定南县', '360728');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('76402889f8476650de01476666acbf00', '江西省', '360000', '赣州市', '360700', '全南县', '360729');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('77402889f8476650de01476666acbf00', '江西省', '360000', '赣州市', '360700', '宁都县', '360730');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('78402889f8476650de01476666acbf00', '江西省', '360000', '赣州市', '360700', '于都县', '360731');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('79402889f8476650de01476666acbf00', '江西省', '360000', '赣州市', '360700', '兴国县', '360732');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('80402889f8476650de01476666acbf00', '江西省', '360000', '赣州市', '360700', '会昌县', '360733');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('81402889f8476650de01476666acbf00', '江西省', '360000', '赣州市', '360700', '寻乌县', '360734');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('82402889f8476650de01476666acbf00', '江西省', '360000', '赣州市', '360700', '石城县', '360735');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('83402889f8476650de01476666acbf00', '江西省', '360000', '赣州市', '360700', '瑞金市', '360781');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('84402889f8476650de01476666acbf00', '江西省', '360000', '赣州市', '360700', '南康市', '360782');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('85402889f8476650de01476666acbf00', '江西省', '360000', '吉安市', '360800', '吉州区', '360802');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('86402889f8476650de01476666acbf00', '江西省', '360000', '吉安市', '360800', '青原区', '360803');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('87402889f8476650de01476666acbf00', '江西省', '360000', '吉安市', '360800', '吉安县', '360821');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('88402889f8476650de01476666acbf00', '江西省', '360000', '吉安市', '360800', '吉水县', '360822');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('89402889f8476650de01476666acbf00', '江西省', '360000', '吉安市', '360800', '峡江县', '360823');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('90402889f8476650de01476666acbf00', '江西省', '360000', '吉安市', '360800', '新干县', '360824');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('91402889f8476650de01476666acbf00', '江西省', '360000', '吉安市', '360800', '永丰县', '360825');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('92402889f8476650de01476666acbf00', '江西省', '360000', '吉安市', '360800', '泰和县', '360826');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('93402889f8476650de01476666acbf00', '江西省', '360000', '吉安市', '360800', '遂川县', '360827');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('94402889f8476650de01476666acbf00', '江西省', '360000', '吉安市', '360800', '万安县', '360828');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('95402889f8476650de01476666acbf00', '江西省', '360000', '吉安市', '360800', '安福县', '360829');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('96402889f8476650de01476666acbf00', '江西省', '360000', '吉安市', '360800', '永新县', '360830');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('97402889f8476650de01476666acbf00', '江西省', '360000', '吉安市', '360800', '井冈山市', '360881');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('98402889f8476650de01476666acbf00', '江西省', '360000', '宜春市', '360900', '袁州区', '360902');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('99402889f8476650de01476666acbf00', '江西省', '360000', '宜春市', '360900', '奉新县', '360921');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('100402889f8476650de01476666acbf0', '江西省', '360000', '宜春市', '360900', '万载县', '360922');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('101402889f8476650de01476666acbf0', '江西省', '360000', '宜春市', '360900', '上高县', '360923');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('102402889f8476650de01476666acbf0', '江西省', '360000', '宜春市', '360900', '宜丰县', '360924');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('103402889f8476650de01476666acbf0', '江西省', '360000', '宜春市', '360900', '靖安县', '360925');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('104402889f8476650de01476666acbf0', '江西省', '360000', '宜春市', '360900', '铜鼓县', '360926');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('105402889f8476650de01476666acbf0', '江西省', '360000', '宜春市', '360900', '丰城市', '360981');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('106402889f8476650de01476666acbf0', '江西省', '360000', '宜春市', '360900', '樟树市', '360982');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('107402889f8476650de01476666acbf0', '江西省', '360000', '宜春市', '360900', '高安市', '360983');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('108402889f8476650de01476666acbf0', '江西省', '360000', '抚州市', '361000', '临川区', '361002');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('109402889f8476650de01476666acbf0', '江西省', '360000', '抚州市', '361000', '南城县', '361021');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('110402889f8476650de01476666acbf0', '江西省', '360000', '抚州市', '361000', '黎川县', '361022');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('111402889f8476650de01476666acbf0', '江西省', '360000', '抚州市', '361000', '南丰县', '361023');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('112402889f8476650de01476666acbf0', '江西省', '360000', '抚州市', '361000', '崇仁县', '361024');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('113402889f8476650de01476666acbf0', '江西省', '360000', '抚州市', '361000', '乐安县', '361025');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('114402889f8476650de01476666acbf0', '江西省', '360000', '抚州市', '361000', '宜黄县', '361026');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('115402889f8476650de01476666acbf0', '江西省', '360000', '抚州市', '361000', '金溪县', '361027');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('116402889f8476650de01476666acbf0', '江西省', '360000', '抚州市', '361000', '资溪县', '361028');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('117402889f8476650de01476666acbf0', '江西省', '360000', '抚州市', '361000', '东乡县', '361029');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('118402889f8476650de01476666acbf0', '江西省', '360000', '抚州市', '361000', '广昌县', '361030');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('119402889f8476650de01476666acbf0', '江西省', '360000', '上饶市', '361100', '信州区', '361102');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('120402889f8476650de01476666acbf0', '江西省', '360000', '上饶市', '361100', '上饶县', '361121');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('121402889f8476650de01476666acbf0', '江西省', '360000', '上饶市', '361100', '广丰县', '361122');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('122402889f8476650de01476666acbf0', '江西省', '360000', '上饶市', '361100', '玉山县', '361123');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('123402889f8476650de01476666acbf0', '江西省', '360000', '上饶市', '361100', '铅山县', '361124');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('124402889f8476650de01476666acbf0', '江西省', '360000', '上饶市', '361100', '横峰县', '361125');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('125402889f8476650de01476666acbf0', '江西省', '360000', '上饶市', '361100', '弋阳县', '361126');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('126402889f8476650de01476666acbf0', '江西省', '360000', '上饶市', '361100', '余干县', '361127');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('127402889f8476650de01476666acbf0', '江西省', '360000', '上饶市', '361100', '鄱阳县', '361128');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('128402889f8476650de01476666acbf0', '江西省', '360000', '上饶市', '361100', '万年县', '361129');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('129402889f8476650de01476666acbf0', '江西省', '360000', '上饶市', '361100', '婺源县', '361130');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('130402889f8476650de01476666acbf0', '江西省', '360000', '上饶市', '361100', '德兴市', '361181');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('131402889f8476650de01476666acbf0', '山东省', '370000', '济南市', '370100', '历下区', '370102');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('132402889f8476650de01476666acbf0', '山东省', '370000', '济南市', '370100', '市中区', '370103');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('133402889f8476650de01476666acbf0', '山东省', '370000', '济南市', '370100', '槐荫区', '370104');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('134402889f8476650de01476666acbf0', '山东省', '370000', '济南市', '370100', '天桥区', '370105');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('135402889f8476650de01476666acbf0', '山东省', '370000', '济南市', '370100', '历城区', '370112');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('136402889f8476650de01476666acbf0', '山东省', '370000', '济南市', '370100', '长清区', '370113');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('137402889f8476650de01476666acbf0', '山东省', '370000', '济南市', '370100', '平阴县', '370124');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('138402889f8476650de01476666acbf0', '山东省', '370000', '济南市', '370100', '济阳县', '370125');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('139402889f8476650de01476666acbf0', '山东省', '370000', '济南市', '370100', '商河县', '370126');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('140402889f8476650de01476666acbf0', '山东省', '370000', '济南市', '370100', '章丘市', '370181');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('141402889f8476650de01476666acbf0', '山东省', '370000', '青岛市', '370200', '市南区', '370202');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('142402889f8476650de01476666acbf0', '山东省', '370000', '青岛市', '370200', '市北区', '370203');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('143402889f8476650de01476666acbf0', '山东省', '370000', '青岛市', '370200', '四方区', '370205');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('144402889f8476650de01476666acbf0', '山东省', '370000', '青岛市', '370200', '黄岛区', '370211');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('145402889f8476650de01476666acbf0', '山东省', '370000', '青岛市', '370200', '崂山区', '370212');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('146402889f8476650de01476666acbf0', '山东省', '370000', '青岛市', '370200', '李沧区', '370213');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('147402889f8476650de01476666acbf0', '山东省', '370000', '青岛市', '370200', '城阳区', '370214');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('148402889f8476650de01476666acbf0', '山东省', '370000', '青岛市', '370200', '胶州市', '370281');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('149402889f8476650de01476666acbf0', '山东省', '370000', '青岛市', '370200', '即墨市', '370282');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('150402889f8476650de01476666acbf0', '山东省', '370000', '青岛市', '370200', '平度市', '370283');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('151402889f8476650de01476666acbf0', '山东省', '370000', '青岛市', '370200', '胶南市', '370284');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('152402889f8476650de01476666acbf0', '山东省', '370000', '青岛市', '370200', '莱西市', '370285');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('153402889f8476650de01476666acbf0', '山东省', '370000', '淄博市', '370300', '淄川区', '370302');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('154402889f8476650de01476666acbf0', '山东省', '370000', '淄博市', '370300', '张店区', '370303');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('155402889f8476650de01476666acbf0', '山东省', '370000', '淄博市', '370300', '博山区', '370304');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('156402889f8476650de01476666acbf0', '山东省', '370000', '淄博市', '370300', '临淄区', '370305');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('157402889f8476650de01476666acbf0', '山东省', '370000', '淄博市', '370300', '周村区', '370306');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('158402889f8476650de01476666acbf0', '山东省', '370000', '淄博市', '370300', '桓台县', '370321');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('159402889f8476650de01476666acbf0', '山东省', '370000', '淄博市', '370300', '高青县', '370322');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('160402889f8476650de01476666acbf0', '山东省', '370000', '淄博市', '370300', '沂源县', '370323');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('161402889f8476650de01476666acbf0', '山东省', '370000', '枣庄市', '370400', '市中区', '370402');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('162402889f8476650de01476666acbf0', '山东省', '370000', '枣庄市', '370400', '薛城区', '370403');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('163402889f8476650de01476666acbf0', '山东省', '370000', '枣庄市', '370400', '峄城区', '370404');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('164402889f8476650de01476666acbf0', '山东省', '370000', '枣庄市', '370400', '台儿庄区', '370405');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('165402889f8476650de01476666acbf0', '山东省', '370000', '枣庄市', '370400', '山亭区', '370406');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('166402889f8476650de01476666acbf0', '山东省', '370000', '枣庄市', '370400', '滕州市', '370481');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('167402889f8476650de01476666acbf0', '山东省', '370000', '东营市', '370500', '东营区', '370502');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('168402889f8476650de01476666acbf0', '山东省', '370000', '东营市', '370500', '河口区', '370503');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('169402889f8476650de01476666acbf0', '山东省', '370000', '东营市', '370500', '垦利县', '370521');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('170402889f8476650de01476666acbf0', '山东省', '370000', '东营市', '370500', '利津县', '370522');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('171402889f8476650de01476666acbf0', '山东省', '370000', '东营市', '370500', '广饶县', '370523');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('172402889f8476650de01476666acbf0', '山东省', '370000', '烟台市', '370600', '芝罘区', '370602');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('173402889f8476650de01476666acbf0', '山东省', '370000', '烟台市', '370600', '福山区', '370611');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('174402889f8476650de01476666acbf0', '山东省', '370000', '烟台市', '370600', '牟平区', '370612');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('175402889f8476650de01476666acbf0', '山东省', '370000', '烟台市', '370600', '莱山区', '370613');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('176402889f8476650de01476666acbf0', '山东省', '370000', '烟台市', '370600', '长岛县', '370634');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('177402889f8476650de01476666acbf0', '山东省', '370000', '烟台市', '370600', '龙口市', '370681');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('178402889f8476650de01476666acbf0', '山东省', '370000', '烟台市', '370600', '莱阳市', '370682');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('179402889f8476650de01476666acbf0', '山东省', '370000', '烟台市', '370600', '莱州市', '370683');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('180402889f8476650de01476666acbf0', '山东省', '370000', '烟台市', '370600', '蓬莱市', '370684');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('181402889f8476650de01476666acbf0', '山东省', '370000', '烟台市', '370600', '招远市', '370685');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('182402889f8476650de01476666acbf0', '山东省', '370000', '烟台市', '370600', '栖霞市', '370686');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('183402889f8476650de01476666acbf0', '山东省', '370000', '烟台市', '370600', '海阳市', '370687');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('184402889f8476650de01476666acbf0', '山东省', '370000', '潍坊市', '370700', '潍城区', '370702');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('185402889f8476650de01476666acbf0', '山东省', '370000', '潍坊市', '370700', '寒亭区', '370703');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('186402889f8476650de01476666acbf0', '山东省', '370000', '潍坊市', '370700', '坊子区', '370704');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('187402889f8476650de01476666acbf0', '山东省', '370000', '潍坊市', '370700', '奎文区', '370705');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('188402889f8476650de01476666acbf0', '山东省', '370000', '潍坊市', '370700', '临朐县', '370724');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('189402889f8476650de01476666acbf0', '山东省', '370000', '潍坊市', '370700', '昌乐县', '370725');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('190402889f8476650de01476666acbf0', '山东省', '370000', '潍坊市', '370700', '青州市', '370781');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('191402889f8476650de01476666acbf0', '山东省', '370000', '潍坊市', '370700', '诸城市', '370782');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('192402889f8476650de01476666acbf0', '山东省', '370000', '潍坊市', '370700', '寿光市', '370783');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('193402889f8476650de01476666acbf0', '山东省', '370000', '潍坊市', '370700', '安丘市', '370784');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('194402889f8476650de01476666acbf0', '山东省', '370000', '潍坊市', '370700', '高密市', '370785');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('195402889f8476650de01476666acbf0', '山东省', '370000', '潍坊市', '370700', '昌邑市', '370786');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('196402889f8476650de01476666acbf0', '山东省', '370000', '济宁市', '370800', '市中区', '370802');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('197402889f8476650de01476666acbf0', '山东省', '370000', '济宁市', '370800', '任城区', '370811');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('198402889f8476650de01476666acbf0', '山东省', '370000', '济宁市', '370800', '微山县', '370826');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('199402889f8476650de01476666acbf0', '山东省', '370000', '济宁市', '370800', '鱼台县', '370827');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('200402889f8476650de01476666acbf0', '山东省', '370000', '济宁市', '370800', '金乡县', '370828');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('201402889f8476650de01476666acbf0', '山东省', '370000', '济宁市', '370800', '嘉祥县', '370829');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('202402889f8476650de01476666acbf0', '山东省', '370000', '济宁市', '370800', '汶上县', '370830');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('203402889f8476650de01476666acbf0', '山东省', '370000', '济宁市', '370800', '泗水县', '370831');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('204402889f8476650de01476666acbf0', '山东省', '370000', '济宁市', '370800', '梁山县', '370832');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('205402889f8476650de01476666acbf0', '山东省', '370000', '济宁市', '370800', '曲阜市', '370881');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('206402889f8476650de01476666acbf0', '山东省', '370000', '济宁市', '370800', '兖州市', '370882');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('207402889f8476650de01476666acbf0', '山东省', '370000', '济宁市', '370800', '邹城市', '370883');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('208402889f8476650de01476666acbf0', '山东省', '370000', '泰安市', '370900', '泰山区', '370902');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('209402889f8476650de01476666acbf0', '山东省', '370000', '泰安市', '370900', '岱岳区', '370911');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('210402889f8476650de01476666acbf0', '山东省', '370000', '泰安市', '370900', '宁阳县', '370921');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('211402889f8476650de01476666acbf0', '山东省', '370000', '泰安市', '370900', '东平县', '370923');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('212402889f8476650de01476666acbf0', '山东省', '370000', '泰安市', '370900', '新泰市', '370982');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('213402889f8476650de01476666acbf0', '山东省', '370000', '泰安市', '370900', '肥城市', '370983');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('214402889f8476650de01476666acbf0', '山东省', '370000', '威海市', '371000', '环翠区', '371002');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('215402889f8476650de01476666acbf0', '山东省', '370000', '威海市', '371000', '文登市', '371081');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('216402889f8476650de01476666acbf0', '山东省', '370000', '威海市', '371000', '荣成市', '371082');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('217402889f8476650de01476666acbf0', '山东省', '370000', '威海市', '371000', '乳山市', '371083');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('218402889f8476650de01476666acbf0', '山东省', '370000', '日照市', '371100', '东港区', '371102');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('219402889f8476650de01476666acbf0', '山东省', '370000', '日照市', '371100', '岚山区', '371103');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('220402889f8476650de01476666acbf0', '山东省', '370000', '日照市', '371100', '五莲县', '371121');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('221402889f8476650de01476666acbf0', '山东省', '370000', '日照市', '371100', '莒县', '371122');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('222402889f8476650de01476666acbf0', '山东省', '370000', '莱芜市', '371200', '莱城区', '371202');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('223402889f8476650de01476666acbf0', '山东省', '370000', '莱芜市', '371200', '钢城区', '371203');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('224402889f8476650de01476666acbf0', '山东省', '370000', '临沂市', '371300', '兰山区', '371302');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('225402889f8476650de01476666acbf0', '山东省', '370000', '临沂市', '371300', '罗庄区', '371311');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('226402889f8476650de01476666acbf0', '山东省', '370000', '临沂市', '371300', '河东区', '371312');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('227402889f8476650de01476666acbf0', '山东省', '370000', '临沂市', '371300', '沂南县', '371321');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('228402889f8476650de01476666acbf0', '山东省', '370000', '临沂市', '371300', '郯城县', '371322');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('229402889f8476650de01476666acbf0', '山东省', '370000', '临沂市', '371300', '沂水县', '371323');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('230402889f8476650de01476666acbf0', '山东省', '370000', '临沂市', '371300', '苍山县', '371324');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('231402889f8476650de01476666acbf0', '山东省', '370000', '临沂市', '371300', '费县', '371325');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('232402889f8476650de01476666acbf0', '山东省', '370000', '临沂市', '371300', '平邑县', '371326');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('233402889f8476650de01476666acbf0', '山东省', '370000', '临沂市', '371300', '莒南县', '371327');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('234402889f8476650de01476666acbf0', '山东省', '370000', '临沂市', '371300', '蒙阴县', '371328');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('235402889f8476650de01476666acbf0', '山东省', '370000', '临沂市', '371300', '临沭县', '371329');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('236402889f8476650de01476666acbf0', '山东省', '370000', '德州市', '371400', '德城区', '371402');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('237402889f8476650de01476666acbf0', '山东省', '370000', '德州市', '371400', '陵县', '371421');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('238402889f8476650de01476666acbf0', '山东省', '370000', '德州市', '371400', '宁津县', '371422');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('239402889f8476650de01476666acbf0', '山东省', '370000', '德州市', '371400', '庆云县', '371423');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('240402889f8476650de01476666acbf0', '山东省', '370000', '德州市', '371400', '临邑县', '371424');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('241402889f8476650de01476666acbf0', '山东省', '370000', '德州市', '371400', '齐河县', '371425');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('242402889f8476650de01476666acbf0', '山东省', '370000', '德州市', '371400', '平原县', '371426');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('243402889f8476650de01476666acbf0', '山东省', '370000', '德州市', '371400', '夏津县', '371427');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('244402889f8476650de01476666acbf0', '山东省', '370000', '德州市', '371400', '武城县', '371428');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('245402889f8476650de01476666acbf0', '山东省', '370000', '德州市', '371400', '乐陵市', '371481');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('246402889f8476650de01476666acbf0', '山东省', '370000', '德州市', '371400', '禹城市', '371482');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('247402889f8476650de01476666acbf0', '山东省', '370000', '聊城市', '371500', '东昌府区', '371502');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('248402889f8476650de01476666acbf0', '山东省', '370000', '聊城市', '371500', '阳谷县', '371521');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('249402889f8476650de01476666acbf0', '山东省', '370000', '聊城市', '371500', '莘县', '371522');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('250402889f8476650de01476666acbf0', '山东省', '370000', '聊城市', '371500', '茌平县', '371523');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('32402889f8476650de01476666acbf00', '山东省', '370000', '聊城市', '371500', '东阿县', '371524');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('33402889f8476650de01476666acbf00', '山东省', '370000', '聊城市', '371500', '冠县', '371525');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('34402889f8476650de01476666acbf00', '山东省', '370000', '聊城市', '371500', '高唐县', '371526');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('35402889f8476650de01476666acbf00', '山东省', '370000', '聊城市', '371500', '临清市', '371581');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('36402889f8476650de01476666acbf00', '山东省', '370000', '滨州市', '371600', '滨城区', '371602');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('37402889f8476650de01476666acbf00', '山东省', '370000', '滨州市', '371600', '惠民县', '371621');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('38402889f8476650de01476666acbf00', '山东省', '370000', '滨州市', '371600', '阳信县', '371622');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('39402889f8476650de01476666acbf00', '山东省', '370000', '滨州市', '371600', '无棣县', '371623');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('40402889f8476650de01476666acbf00', '山东省', '370000', '滨州市', '371600', '沾化县', '371624');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('41402889f8476650de01476666acbf00', '山东省', '370000', '滨州市', '371600', '博兴县', '371625');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('42402889f8476650de01476666acbf00', '山东省', '370000', '滨州市', '371600', '邹平县', '371626');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('43402889f8476650de01476666acbf00', '山东省', '370000', '菏泽市', '371700', '牡丹区', '371702');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('44402889f8476650de01476666acbf00', '山东省', '370000', '菏泽市', '371700', '曹县', '371721');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('45402889f8476650de01476666acbf00', '山东省', '370000', '菏泽市', '371700', '单县', '371722');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('46402889f8476650de01476666acbf00', '山东省', '370000', '菏泽市', '371700', '成武县', '371723');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('47402889f8476650de01476666acbf00', '山东省', '370000', '菏泽市', '371700', '巨野县', '371724');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('48402889f8476650de01476666acbf00', '山东省', '370000', '菏泽市', '371700', '郓城县', '371725');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('49402889f8476650de01476666acbf00', '山东省', '370000', '菏泽市', '371700', '鄄城县', '371726');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('50402889f8476650de01476666acbf00', '山东省', '370000', '菏泽市', '371700', '定陶县', '371727');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('51402889f8476650de01476666acbf00', '山东省', '370000', '菏泽市', '371700', '东明县', '371728');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('52402889f8476650de01476666acbf00', '河南省', '410000', '郑州市', '410100', '中原区', '410102');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('53402889f8476650de01476666acbf00', '河南省', '410000', '郑州市', '410100', '二七区', '410103');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('54402889f8476650de01476666acbf00', '河南省', '410000', '郑州市', '410100', '管城回族区', '410104');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('55402889f8476650de01476666acbf00', '河南省', '410000', '郑州市', '410100', '金水区', '410105');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('56402889f8476650de01476666acbf00', '河南省', '410000', '郑州市', '410100', '上街区', '410106');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('57402889f8476650de01476666acbf00', '河南省', '410000', '郑州市', '410100', '惠济区', '410108');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('58402889f8476650de01476666acbf00', '河南省', '410000', '郑州市', '410100', '中牟县', '410122');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('59402889f8476650de01476666acbf00', '河南省', '410000', '郑州市', '410100', '巩义市', '410181');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('60402889f8476650de01476666acbf00', '河南省', '410000', '郑州市', '410100', '荥阳市', '410182');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('61402889f8476650de01476666acbf00', '河南省', '410000', '郑州市', '410100', '新密市', '410183');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('62402889f8476650de01476666acbf00', '河南省', '410000', '郑州市', '410100', '新郑市', '410184');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('63402889f8476650de01476666acbf00', '河南省', '410000', '郑州市', '410100', '登封市', '410185');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('64402889f8476650de01476666acbf00', '河南省', '410000', '开封市', '410200', '龙亭区', '410202');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('65402889f8476650de01476666acbf00', '河南省', '410000', '开封市', '410200', '顺河回族区', '410203');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('66402889f8476650de01476666acbf00', '河南省', '410000', '开封市', '410200', '鼓楼区', '410204');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('67402889f8476650de01476666acbf00', '河南省', '410000', '开封市', '410200', '禹王台区', '410205');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('68402889f8476650de01476666acbf00', '河南省', '410000', '开封市', '410200', '金明区', '410211');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('69402889f8476650de01476666acbf00', '河南省', '410000', '开封市', '410200', '杞县', '410221');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('70402889f8476650de01476666acbf00', '河南省', '410000', '开封市', '410200', '通许县', '410222');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('71402889f8476650de01476666acbf00', '河南省', '410000', '开封市', '410200', '尉氏县', '410223');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('72402889f8476650de01476666acbf00', '河南省', '410000', '开封市', '410200', '开封县', '410224');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('73402889f8476650de01476666acbf00', '河南省', '410000', '开封市', '410200', '兰考县', '410225');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('74402889f8476650de01476666acbf00', '河南省', '410000', '洛阳市', '410300', '老城区', '410302');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('251402889f8476650de01476666acbf0', '河南省', '410000', '洛阳市', '410300', '西工区', '410303');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('252402889f8476650de01476666acbf0', '河南省', '410000', '洛阳市', '410300', '瀍河回族区', '410304');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('253402889f8476650de01476666acbf0', '河南省', '410000', '洛阳市', '410300', '涧西区', '410305');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('254402889f8476650de01476666acbf0', '河南省', '410000', '洛阳市', '410300', '吉利区', '410306');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('255402889f8476650de01476666acbf0', '河南省', '410000', '洛阳市', '410300', '洛龙区', '410311');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('256402889f8476650de01476666acbf0', '河南省', '410000', '洛阳市', '410300', '孟津县', '410322');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('257402889f8476650de01476666acbf0', '河南省', '410000', '洛阳市', '410300', '新安县', '410323');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('258402889f8476650de01476666acbf0', '河南省', '410000', '洛阳市', '410300', '栾川县', '410324');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('259402889f8476650de01476666acbf0', '河南省', '410000', '洛阳市', '410300', '嵩县', '410325');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('260402889f8476650de01476666acbf0', '河南省', '410000', '洛阳市', '410300', '汝阳县', '410326');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('261402889f8476650de01476666acbf0', '河南省', '410000', '洛阳市', '410300', '宜阳县', '410327');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('262402889f8476650de01476666acbf0', '河南省', '410000', '洛阳市', '410300', '洛宁县', '410328');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('263402889f8476650de01476666acbf0', '河南省', '410000', '洛阳市', '410300', '伊川县', '410329');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('264402889f8476650de01476666acbf0', '河南省', '410000', '洛阳市', '410300', '偃师市', '410381');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('265402889f8476650de01476666acbf0', '河南省', '410000', '平顶山市', '410400', '新华区', '410402');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('266402889f8476650de01476666acbf0', '河南省', '410000', '平顶山市', '410400', '卫东区', '410403');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('267402889f8476650de01476666acbf0', '河南省', '410000', '平顶山市', '410400', '石龙区', '410404');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('268402889f8476650de01476666acbf0', '河南省', '410000', '平顶山市', '410400', '湛河区', '410411');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('269402889f8476650de01476666acbf0', '河南省', '410000', '平顶山市', '410400', '宝丰县', '410421');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('270402889f8476650de01476666acbf0', '河南省', '410000', '平顶山市', '410400', '叶县', '410422');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('271402889f8476650de01476666acbf0', '河南省', '410000', '平顶山市', '410400', '鲁山县', '410423');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('272402889f8476650de01476666acbf0', '河南省', '410000', '平顶山市', '410400', '郏县', '410425');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('273402889f8476650de01476666acbf0', '河南省', '410000', '平顶山市', '410400', '舞钢市', '410481');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('274402889f8476650de01476666acbf0', '河南省', '410000', '平顶山市', '410400', '汝州市', '410482');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('275402889f8476650de01476666acbf0', '河南省', '410000', '安阳市', '410500', '文峰区', '410502');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('276402889f8476650de01476666acbf0', '河南省', '410000', '安阳市', '410500', '北关区', '410503');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('277402889f8476650de01476666acbf0', '河南省', '410000', '安阳市', '410500', '殷都区', '410505');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('278402889f8476650de01476666acbf0', '河南省', '410000', '安阳市', '410500', '龙安区', '410506');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('279402889f8476650de01476666acbf0', '河南省', '410000', '安阳市', '410500', '安阳县', '410522');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('280402889f8476650de01476666acbf0', '河南省', '410000', '安阳市', '410500', '汤阴县', '410523');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('281402889f8476650de01476666acbf0', '河南省', '410000', '安阳市', '410500', '滑县', '410526');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('282402889f8476650de01476666acbf0', '河南省', '410000', '安阳市', '410500', '内黄县', '410527');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('283402889f8476650de01476666acbf0', '河南省', '410000', '安阳市', '410500', '林州市', '410581');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('284402889f8476650de01476666acbf0', '河南省', '410000', '鹤壁市', '410600', '鹤山区', '410602');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('285402889f8476650de01476666acbf0', '河南省', '410000', '鹤壁市', '410600', '山城区', '410603');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('286402889f8476650de01476666acbf0', '河南省', '410000', '鹤壁市', '410600', '淇滨区', '410611');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('287402889f8476650de01476666acbf0', '河南省', '410000', '鹤壁市', '410600', '浚县', '410621');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('288402889f8476650de01476666acbf0', '河南省', '410000', '鹤壁市', '410600', '淇县', '410622');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('289402889f8476650de01476666acbf0', '河南省', '410000', '新乡市', '410700', '红旗区', '410702');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('290402889f8476650de01476666acbf0', '河南省', '410000', '新乡市', '410700', '卫滨区', '410703');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('291402889f8476650de01476666acbf0', '河南省', '410000', '新乡市', '410700', '凤泉区', '410704');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('292402889f8476650de01476666acbf0', '河南省', '410000', '新乡市', '410700', '牧野区', '410711');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('293402889f8476650de01476666acbf0', '河南省', '410000', '新乡市', '410700', '新乡县', '410721');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('294402889f8476650de01476666acbf0', '河南省', '410000', '新乡市', '410700', '获嘉县', '410724');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('295402889f8476650de01476666acbf0', '河南省', '410000', '新乡市', '410700', '原阳县', '410725');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('296402889f8476650de01476666acbf0', '河南省', '410000', '新乡市', '410700', '延津县', '410726');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('297402889f8476650de01476666acbf0', '河南省', '410000', '新乡市', '410700', '封丘县', '410727');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('298402889f8476650de01476666acbf0', '河南省', '410000', '新乡市', '410700', '长垣县', '410728');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('299402889f8476650de01476666acbf0', '河南省', '410000', '新乡市', '410700', '卫辉市', '410781');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('300402889f8476650de01476666acbf0', '河南省', '410000', '新乡市', '410700', '辉县市', '410782');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('301402889f8476650de01476666acbf0', '河南省', '410000', '焦作市', '410800', '解放区', '410802');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('302402889f8476650de01476666acbf0', '河南省', '410000', '焦作市', '410800', '中站区', '410803');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('303402889f8476650de01476666acbf0', '河南省', '410000', '焦作市', '410800', '马村区', '410804');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('304402889f8476650de01476666acbf0', '河南省', '410000', '焦作市', '410800', '山阳区', '410811');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('305402889f8476650de01476666acbf0', '河南省', '410000', '焦作市', '410800', '修武县', '410821');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('306402889f8476650de01476666acbf0', '河南省', '410000', '焦作市', '410800', '博爱县', '410822');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('307402889f8476650de01476666acbf0', '河南省', '410000', '焦作市', '410800', '武陟县', '410823');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('308402889f8476650de01476666acbf0', '河南省', '410000', '焦作市', '410800', '温县', '410825');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('309402889f8476650de01476666acbf0', '河南省', '410000', '焦作市', '410800', '沁阳市', '410882');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('310402889f8476650de01476666acbf0', '河南省', '410000', '焦作市', '410800', '孟州市', '410883');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('311402889f8476650de01476666acbf0', '河南省', '410000', '濮阳市', '410900', '华龙区', '410902');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('312402889f8476650de01476666acbf0', '河南省', '410000', '濮阳市', '410900', '清丰县', '410922');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('313402889f8476650de01476666acbf0', '河南省', '410000', '濮阳市', '410900', '南乐县', '410923');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('314402889f8476650de01476666acbf0', '河南省', '410000', '濮阳市', '410900', '范县', '410926');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('315402889f8476650de01476666acbf0', '河南省', '410000', '濮阳市', '410900', '台前县', '410927');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('316402889f8476650de01476666acbf0', '河南省', '410000', '濮阳市', '410900', '濮阳县', '410928');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('317402889f8476650de01476666acbf0', '河南省', '410000', '许昌市', '411000', '魏都区', '411002');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('318402889f8476650de01476666acbf0', '河南省', '410000', '许昌市', '411000', '许昌县', '411023');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('319402889f8476650de01476666acbf0', '河南省', '410000', '许昌市', '411000', '鄢陵县', '411024');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('320402889f8476650de01476666acbf0', '河南省', '410000', '许昌市', '411000', '襄城县', '411025');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('321402889f8476650de01476666acbf0', '河南省', '410000', '许昌市', '411000', '禹州市', '411081');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('322402889f8476650de01476666acbf0', '河南省', '410000', '许昌市', '411000', '长葛市', '411082');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('323402889f8476650de01476666acbf0', '河南省', '410000', '漯河市', '411100', '源汇区', '411102');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('324402889f8476650de01476666acbf0', '河南省', '410000', '漯河市', '411100', '郾城区', '411103');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('325402889f8476650de01476666acbf0', '河南省', '410000', '漯河市', '411100', '召陵区', '411104');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('326402889f8476650de01476666acbf0', '河南省', '410000', '漯河市', '411100', '舞阳县', '411121');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('327402889f8476650de01476666acbf0', '河南省', '410000', '漯河市', '411100', '临颍县', '411122');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('328402889f8476650de01476666acbf0', '河南省', '410000', '三门峡市', '411200', '湖滨区', '411202');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('329402889f8476650de01476666acbf0', '河南省', '410000', '三门峡市', '411200', '渑池县', '411221');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('330402889f8476650de01476666acbf0', '河南省', '410000', '三门峡市', '411200', '陕县', '411222');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('331402889f8476650de01476666acbf0', '河南省', '410000', '三门峡市', '411200', '卢氏县', '411224');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('332402889f8476650de01476666acbf0', '河南省', '410000', '三门峡市', '411200', '义马市', '411281');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('333402889f8476650de01476666acbf0', '河南省', '410000', '三门峡市', '411200', '灵宝市', '411282');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('334402889f8476650de01476666acbf0', '河南省', '410000', '南阳市', '411300', '宛城区', '411302');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('335402889f8476650de01476666acbf0', '河南省', '410000', '南阳市', '411300', '卧龙区', '411303');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('336402889f8476650de01476666acbf0', '河南省', '410000', '南阳市', '411300', '南召县', '411321');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('337402889f8476650de01476666acbf0', '河南省', '410000', '南阳市', '411300', '方城县', '411322');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('338402889f8476650de01476666acbf0', '河南省', '410000', '南阳市', '411300', '西峡县', '411323');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('339402889f8476650de01476666acbf0', '河南省', '410000', '南阳市', '411300', '镇平县', '411324');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('340402889f8476650de01476666acbf0', '河南省', '410000', '南阳市', '411300', '内乡县', '411325');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('341402889f8476650de01476666acbf0', '河南省', '410000', '南阳市', '411300', '淅川县', '411326');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('342402889f8476650de01476666acbf0', '河南省', '410000', '南阳市', '411300', '社旗县', '411327');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('343402889f8476650de01476666acbf0', '河南省', '410000', '南阳市', '411300', '唐河县', '411328');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('344402889f8476650de01476666acbf0', '河南省', '410000', '南阳市', '411300', '新野县', '411329');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('345402889f8476650de01476666acbf0', '河南省', '410000', '南阳市', '411300', '桐柏县', '411330');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('346402889f8476650de01476666acbf0', '河南省', '410000', '南阳市', '411300', '邓州市', '411381');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('347402889f8476650de01476666acbf0', '河南省', '410000', '商丘市', '411400', '梁园区', '411402');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('348402889f8476650de01476666acbf0', '河南省', '410000', '商丘市', '411400', '睢阳区', '411403');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('349402889f8476650de01476666acbf0', '河南省', '410000', '商丘市', '411400', '民权县', '411421');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('350402889f8476650de01476666acbf0', '河南省', '410000', '商丘市', '411400', '睢县', '411422');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('351402889f8476650de01476666acbf0', '河南省', '410000', '商丘市', '411400', '宁陵县', '411423');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('352402889f8476650de01476666acbf0', '河南省', '410000', '商丘市', '411400', '柘城县', '411424');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('353402889f8476650de01476666acbf0', '河南省', '410000', '商丘市', '411400', '虞城县', '411425');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('354402889f8476650de01476666acbf0', '河南省', '410000', '商丘市', '411400', '夏邑县', '411426');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('355402889f8476650de01476666acbf0', '河南省', '410000', '商丘市', '411400', '永城市', '411481');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('356402889f8476650de01476666acbf0', '河南省', '410000', '信阳市', '411500', '浉河区', '411502');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('357402889f8476650de01476666acbf0', '河南省', '410000', '信阳市', '411500', '平桥区', '411503');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('358402889f8476650de01476666acbf0', '河南省', '410000', '信阳市', '411500', '罗山县', '411521');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('359402889f8476650de01476666acbf0', '河南省', '410000', '信阳市', '411500', '光山县', '411522');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('360402889f8476650de01476666acbf0', '河南省', '410000', '信阳市', '411500', '新县', '411523');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('361402889f8476650de01476666acbf0', '河南省', '410000', '信阳市', '411500', '商城县', '411524');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('362402889f8476650de01476666acbf0', '河南省', '410000', '信阳市', '411500', '固始县', '411525');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('363402889f8476650de01476666acbf0', '河南省', '410000', '信阳市', '411500', '潢川县', '411526');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('364402889f8476650de01476666acbf0', '河南省', '410000', '信阳市', '411500', '淮滨县', '411527');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('365402889f8476650de01476666acbf0', '河南省', '410000', '信阳市', '411500', '息县', '411528');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('366402889f8476650de01476666acbf0', '河南省', '410000', '周口市', '411600', '川汇区', '411602');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('367402889f8476650de01476666acbf0', '河南省', '410000', '周口市', '411600', '扶沟县', '411621');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('368402889f8476650de01476666acbf0', '河南省', '410000', '周口市', '411600', '西华县', '411622');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('369402889f8476650de01476666acbf0', '河南省', '410000', '周口市', '411600', '商水县', '411623');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('370402889f8476650de01476666acbf0', '河南省', '410000', '周口市', '411600', '沈丘县', '411624');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('371402889f8476650de01476666acbf0', '河南省', '410000', '周口市', '411600', '郸城县', '411625');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('372402889f8476650de01476666acbf0', '河南省', '410000', '周口市', '411600', '淮阳县', '411626');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('373402889f8476650de01476666acbf0', '河南省', '410000', '周口市', '411600', '太康县', '411627');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('374402889f8476650de01476666acbf0', '河南省', '410000', '周口市', '411600', '鹿邑县', '411628');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('375402889f8476650de01476666acbf0', '河南省', '410000', '周口市', '411600', '项城市', '411681');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('376402889f8476650de01476666acbf0', '河南省', '410000', '驻马店市', '411700', '驿城区', '411702');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2206402889f8476650de01476666acbf', '河南省', '410000', '驻马店市', '411700', '西平县', '411721');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1103402889f8476650de01476666acbf', '河南省', '410000', '驻马店市', '411700', '上蔡县', '411722');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1993402889f8476650de01476666acbf', '河南省', '410000', '驻马店市', '411700', '平舆县', '411723');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1994402889f8476650de01476666acbf', '河南省', '410000', '驻马店市', '411700', '正阳县', '411724');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1995402889f8476650de01476666acbf', '河南省', '410000', '驻马店市', '411700', '确山县', '411725');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1996402889f8476650de01476666acbf', '河南省', '410000', '驻马店市', '411700', '泌阳县', '411726');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1997402889f8476650de01476666acbf', '河南省', '410000', '驻马店市', '411700', '汝南县', '411727');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1998402889f8476650de01476666acbf', '河南省', '410000', '驻马店市', '411700', '遂平县', '411728');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1999402889f8476650de01476666acbf', '河南省', '410000', '驻马店市', '411700', '新蔡县', '411729');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2000402889f8476650de01476666acbf', '河南省', '410000', '济源市', '419001', '济源市', '419001');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2001402889f8476650de01476666acbf', '湖北省', '420000', '武汉市', '420100', '江岸区', '420102');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2002402889f8476650de01476666acbf', '湖北省', '420000', '武汉市', '420100', '江汉区', '420103');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2003402889f8476650de01476666acbf', '湖北省', '420000', '武汉市', '420100', '硚口区', '420104');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2004402889f8476650de01476666acbf', '湖北省', '420000', '武汉市', '420100', '汉阳区', '420105');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2005402889f8476650de01476666acbf', '湖北省', '420000', '武汉市', '420100', '武昌区', '420106');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2006402889f8476650de01476666acbf', '湖北省', '420000', '武汉市', '420100', '青山区', '420107');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2007402889f8476650de01476666acbf', '湖北省', '420000', '武汉市', '420100', '洪山区', '420111');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2008402889f8476650de01476666acbf', '湖北省', '420000', '武汉市', '420100', '东西湖区', '420112');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2009402889f8476650de01476666acbf', '湖北省', '420000', '武汉市', '420100', '汉南区', '420113');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2010402889f8476650de01476666acbf', '湖北省', '420000', '武汉市', '420100', '蔡甸区', '420114');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2011402889f8476650de01476666acbf', '湖北省', '420000', '武汉市', '420100', '江夏区', '420115');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2012402889f8476650de01476666acbf', '湖北省', '420000', '武汉市', '420100', '黄陂区', '420116');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2013402889f8476650de01476666acbf', '湖北省', '420000', '武汉市', '420100', '新洲区', '420117');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2014402889f8476650de01476666acbf', '湖北省', '420000', '黄石市', '420200', '黄石港区', '420202');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2015402889f8476650de01476666acbf', '湖北省', '420000', '黄石市', '420200', '西塞山区', '420203');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2016402889f8476650de01476666acbf', '湖北省', '420000', '黄石市', '420200', '下陆区', '420204');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2017402889f8476650de01476666acbf', '湖北省', '420000', '黄石市', '420200', '铁山区', '420205');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2018402889f8476650de01476666acbf', '湖北省', '420000', '黄石市', '420200', '阳新县', '420222');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2019402889f8476650de01476666acbf', '湖北省', '420000', '黄石市', '420200', '大冶市', '420281');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2020402889f8476650de01476666acbf', '湖北省', '420000', '十堰市', '420300', '茅箭区', '420302');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2021402889f8476650de01476666acbf', '湖北省', '420000', '十堰市', '420300', '张湾区', '420303');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2022402889f8476650de01476666acbf', '湖北省', '420000', '十堰市', '420300', '郧县', '420321');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2023402889f8476650de01476666acbf', '湖北省', '420000', '十堰市', '420300', '郧西县', '420322');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2024402889f8476650de01476666acbf', '湖北省', '420000', '十堰市', '420300', '竹山县', '420323');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2025402889f8476650de01476666acbf', '湖北省', '420000', '十堰市', '420300', '竹溪县', '420324');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2026402889f8476650de01476666acbf', '湖北省', '420000', '十堰市', '420300', '房县', '420325');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2027402889f8476650de01476666acbf', '湖北省', '420000', '十堰市', '420300', '丹江口市', '420381');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2028402889f8476650de01476666acbf', '湖北省', '420000', '宜昌市', '420500', '西陵区', '420502');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2029402889f8476650de01476666acbf', '湖北省', '420000', '宜昌市', '420500', '伍家岗区', '420503');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2030402889f8476650de01476666acbf', '湖北省', '420000', '宜昌市', '420500', '点军区', '420504');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2031402889f8476650de01476666acbf', '湖北省', '420000', '宜昌市', '420500', '猇亭区', '420505');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2032402889f8476650de01476666acbf', '湖北省', '420000', '宜昌市', '420500', '夷陵区', '420506');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2033402889f8476650de01476666acbf', '湖北省', '420000', '宜昌市', '420500', '远安县', '420525');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2034402889f8476650de01476666acbf', '湖北省', '420000', '宜昌市', '420500', '兴山县', '420526');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2035402889f8476650de01476666acbf', '湖北省', '420000', '宜昌市', '420500', '秭归县', '420527');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2036402889f8476650de01476666acbf', '湖北省', '420000', '宜昌市', '420500', '长阳土家族自治县', '420528');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2037402889f8476650de01476666acbf', '湖北省', '420000', '宜昌市', '420500', '五峰土家族自治县', '420529');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2038402889f8476650de01476666acbf', '湖北省', '420000', '宜昌市', '420500', '宜都市', '420581');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2039402889f8476650de01476666acbf', '湖北省', '420000', '宜昌市', '420500', '当阳市', '420582');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2040402889f8476650de01476666acbf', '湖北省', '420000', '宜昌市', '420500', '枝江市', '420583');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2041402889f8476650de01476666acbf', '湖北省', '420000', '襄阳市', '420600', '襄城区', '420602');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2042402889f8476650de01476666acbf', '湖北省', '420000', '襄阳市', '420600', '樊城区', '420606');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2043402889f8476650de01476666acbf', '湖北省', '420000', '襄阳市', '420600', '襄州区', '420607');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2044402889f8476650de01476666acbf', '湖北省', '420000', '襄阳市', '420600', '南漳县', '420624');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2045402889f8476650de01476666acbf', '湖北省', '420000', '襄阳市', '420600', '谷城县', '420625');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2046402889f8476650de01476666acbf', '湖北省', '420000', '襄阳市', '420600', '保康县', '420626');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2047402889f8476650de01476666acbf', '湖北省', '420000', '襄阳市', '420600', '老河口市', '420682');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2048402889f8476650de01476666acbf', '湖北省', '420000', '襄阳市', '420600', '枣阳市', '420683');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2049402889f8476650de01476666acbf', '湖北省', '420000', '襄阳市', '420600', '宜城市', '420684');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2050402889f8476650de01476666acbf', '湖北省', '420000', '鄂州市', '420700', '梁子湖区', '420702');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2051402889f8476650de01476666acbf', '湖北省', '420000', '鄂州市', '420700', '华容区', '420703');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2052402889f8476650de01476666acbf', '湖北省', '420000', '鄂州市', '420700', '鄂城区', '420704');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2053402889f8476650de01476666acbf', '湖北省', '420000', '荆门市', '420800', '东宝区', '420802');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2054402889f8476650de01476666acbf', '湖北省', '420000', '荆门市', '420800', '掇刀区', '420804');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2055402889f8476650de01476666acbf', '湖北省', '420000', '荆门市', '420800', '京山县', '420821');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2056402889f8476650de01476666acbf', '湖北省', '420000', '荆门市', '420800', '沙洋县', '420822');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2057402889f8476650de01476666acbf', '湖北省', '420000', '荆门市', '420800', '钟祥市', '420881');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2058402889f8476650de01476666acbf', '湖北省', '420000', '孝感市', '420900', '孝南区', '420902');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2059402889f8476650de01476666acbf', '湖北省', '420000', '孝感市', '420900', '孝昌县', '420921');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2060402889f8476650de01476666acbf', '湖北省', '420000', '孝感市', '420900', '大悟县', '420922');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2061402889f8476650de01476666acbf', '湖北省', '420000', '孝感市', '420900', '云梦县', '420923');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2062402889f8476650de01476666acbf', '湖北省', '420000', '孝感市', '420900', '应城市', '420981');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2063402889f8476650de01476666acbf', '湖北省', '420000', '孝感市', '420900', '安陆市', '420982');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2064402889f8476650de01476666acbf', '湖北省', '420000', '孝感市', '420900', '汉川市', '420984');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2065402889f8476650de01476666acbf', '湖北省', '420000', '荆州市', '421000', '沙市区', '421002');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2066402889f8476650de01476666acbf', '湖北省', '420000', '荆州市', '421000', '荆州区', '421003');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2067402889f8476650de01476666acbf', '湖北省', '420000', '荆州市', '421000', '公安县', '421022');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2068402889f8476650de01476666acbf', '湖北省', '420000', '荆州市', '421000', '监利县', '421023');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2069402889f8476650de01476666acbf', '湖北省', '420000', '荆州市', '421000', '江陵县', '421024');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2070402889f8476650de01476666acbf', '湖北省', '420000', '荆州市', '421000', '石首市', '421081');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2071402889f8476650de01476666acbf', '湖北省', '420000', '荆州市', '421000', '洪湖市', '421083');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2072402889f8476650de01476666acbf', '湖北省', '420000', '荆州市', '421000', '松滋市', '421087');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2073402889f8476650de01476666acbf', '湖北省', '420000', '黄冈市', '421100', '黄州区', '421102');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2074402889f8476650de01476666acbf', '湖北省', '420000', '黄冈市', '421100', '团风县', '421121');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2075402889f8476650de01476666acbf', '湖北省', '420000', '黄冈市', '421100', '红安县', '421122');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2076402889f8476650de01476666acbf', '湖北省', '420000', '黄冈市', '421100', '罗田县', '421123');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2077402889f8476650de01476666acbf', '湖北省', '420000', '黄冈市', '421100', '英山县', '421124');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2078402889f8476650de01476666acbf', '湖北省', '420000', '黄冈市', '421100', '浠水县', '421125');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2079402889f8476650de01476666acbf', '湖北省', '420000', '黄冈市', '421100', '蕲春县', '421126');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2080402889f8476650de01476666acbf', '湖北省', '420000', '黄冈市', '421100', '黄梅县', '421127');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2081402889f8476650de01476666acbf', '湖北省', '420000', '黄冈市', '421100', '麻城市', '421181');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2082402889f8476650de01476666acbf', '湖北省', '420000', '黄冈市', '421100', '武穴市', '421182');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2083402889f8476650de01476666acbf', '湖北省', '420000', '咸宁市', '421200', '咸安区', '421202');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2084402889f8476650de01476666acbf', '湖北省', '420000', '咸宁市', '421200', '嘉鱼县', '421221');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2085402889f8476650de01476666acbf', '湖北省', '420000', '咸宁市', '421200', '通城县', '421222');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2086402889f8476650de01476666acbf', '湖北省', '420000', '咸宁市', '421200', '崇阳县', '421223');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2087402889f8476650de01476666acbf', '湖北省', '420000', '咸宁市', '421200', '通山县', '421224');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2088402889f8476650de01476666acbf', '湖北省', '420000', '咸宁市', '421200', '赤壁市', '421281');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2089402889f8476650de01476666acbf', '湖北省', '420000', '随州市', '421300', '曾都区', '421303');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2090402889f8476650de01476666acbf', '湖北省', '420000', '随州市', '421300', '随县', '421321');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2091402889f8476650de01476666acbf', '湖北省', '420000', '随州市', '421300', '广水市', '421381');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2092402889f8476650de01476666acbf', '湖北省', '420000', '恩施土家族苗族自治州', '421400', '恩施市', '422801');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2093402889f8476650de01476666acbf', '湖北省', '420000', '恩施土家族苗族自治州', '421400', '利川市', '422802');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2094402889f8476650de01476666acbf', '湖北省', '420000', '恩施土家族苗族自治州', '421400', '建始县', '422822');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2095402889f8476650de01476666acbf', '湖北省', '420000', '恩施土家族苗族自治州', '421400', '巴东县', '422823');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2096402889f8476650de01476666acbf', '湖北省', '420000', '恩施土家族苗族自治州', '421400', '宣恩县', '422825');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2097402889f8476650de01476666acbf', '湖北省', '420000', '恩施土家族苗族自治州', '421400', '咸丰县', '422826');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2098402889f8476650de01476666acbf', '湖北省', '420000', '恩施土家族苗族自治州', '421400', '来凤县', '422827');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2099402889f8476650de01476666acbf', '湖北省', '420000', '恩施土家族苗族自治州', '421400', '鹤峰县', '422828');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2100402889f8476650de01476666acbf', '湖北省', '420000', '仙桃市', '429004', '仙桃市', '429004');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2101402889f8476650de01476666acbf', '湖北省', '420000', '潜江市', '429005', '潜江市', '429005');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2102402889f8476650de01476666acbf', '湖北省', '420000', '天门市', '429006', '天门市', '429006');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2103402889f8476650de01476666acbf', '湖北省', '420000', '神农架林区', '429021', '神农架林区', '429021');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2104402889f8476650de01476666acbf', '湖南省', '430000', '长沙市', '430100', '芙蓉区', '430102');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2105402889f8476650de01476666acbf', '湖南省', '430000', '长沙市', '430100', '天心区', '430103');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2106402889f8476650de01476666acbf', '湖南省', '430000', '长沙市', '430100', '岳麓区', '430104');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2107402889f8476650de01476666acbf', '湖南省', '430000', '长沙市', '430100', '开福区', '430105');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2108402889f8476650de01476666acbf', '湖南省', '430000', '长沙市', '430100', '雨花区', '430111');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2109402889f8476650de01476666acbf', '湖南省', '430000', '长沙市', '430100', '望城区', '430112');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2110402889f8476650de01476666acbf', '湖南省', '430000', '长沙市', '430100', '长沙县', '430121');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2111402889f8476650de01476666acbf', '湖南省', '430000', '长沙市', '430100', '宁乡县', '430124');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2112402889f8476650de01476666acbf', '湖南省', '430000', '长沙市', '430100', '浏阳市', '430181');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2113402889f8476650de01476666acbf', '湖南省', '430000', '株洲市', '430200', '荷塘区', '430202');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2114402889f8476650de01476666acbf', '湖南省', '430000', '株洲市', '430200', '芦淞区', '430203');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2115402889f8476650de01476666acbf', '湖南省', '430000', '株洲市', '430200', '石峰区', '430204');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2116402889f8476650de01476666acbf', '湖南省', '430000', '株洲市', '430200', '天元区', '430211');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2117402889f8476650de01476666acbf', '湖南省', '430000', '株洲市', '430200', '株洲县', '430221');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2118402889f8476650de01476666acbf', '湖南省', '430000', '株洲市', '430200', '攸县', '430223');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2119402889f8476650de01476666acbf', '湖南省', '430000', '株洲市', '430200', '茶陵县', '430224');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2120402889f8476650de01476666acbf', '湖南省', '430000', '株洲市', '430200', '炎陵县', '430225');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2121402889f8476650de01476666acbf', '湖南省', '430000', '株洲市', '430200', '醴陵市', '430281');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2122402889f8476650de01476666acbf', '湖南省', '430000', '湘潭市', '430300', '雨湖区', '430302');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2123402889f8476650de01476666acbf', '湖南省', '430000', '湘潭市', '430300', '岳塘区', '430304');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2124402889f8476650de01476666acbf', '湖南省', '430000', '湘潭市', '430300', '湘潭县', '430321');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2125402889f8476650de01476666acbf', '湖南省', '430000', '湘潭市', '430300', '湘乡市', '430381');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2126402889f8476650de01476666acbf', '湖南省', '430000', '湘潭市', '430300', '韶山市', '430382');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2127402889f8476650de01476666acbf', '湖南省', '430000', '衡阳市', '430400', '珠晖区', '430405');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2128402889f8476650de01476666acbf', '湖南省', '430000', '衡阳市', '430400', '雁峰区', '430406');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2129402889f8476650de01476666acbf', '湖南省', '430000', '衡阳市', '430400', '石鼓区', '430407');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2130402889f8476650de01476666acbf', '湖南省', '430000', '衡阳市', '430400', '蒸湘区', '430408');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2131402889f8476650de01476666acbf', '湖南省', '430000', '衡阳市', '430400', '南岳区', '430412');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2132402889f8476650de01476666acbf', '湖南省', '430000', '衡阳市', '430400', '衡阳县', '430421');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2133402889f8476650de01476666acbf', '湖南省', '430000', '衡阳市', '430400', '衡南县', '430422');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2134402889f8476650de01476666acbf', '湖南省', '430000', '衡阳市', '430400', '衡山县', '430423');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2135402889f8476650de01476666acbf', '湖南省', '430000', '衡阳市', '430400', '衡东县', '430424');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2136402889f8476650de01476666acbf', '湖南省', '430000', '衡阳市', '430400', '祁东县', '430426');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2137402889f8476650de01476666acbf', '湖南省', '430000', '衡阳市', '430400', '耒阳市', '430481');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2138402889f8476650de01476666acbf', '湖南省', '430000', '衡阳市', '430400', '常宁市', '430482');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2139402889f8476650de01476666acbf', '湖南省', '430000', '邵阳市', '430500', '双清区', '430502');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2140402889f8476650de01476666acbf', '湖南省', '430000', '邵阳市', '430500', '大祥区', '430503');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2141402889f8476650de01476666acbf', '湖南省', '430000', '邵阳市', '430500', '北塔区', '430511');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2142402889f8476650de01476666acbf', '湖南省', '430000', '邵阳市', '430500', '邵东县', '430521');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2143402889f8476650de01476666acbf', '湖南省', '430000', '邵阳市', '430500', '新邵县', '430522');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2144402889f8476650de01476666acbf', '湖南省', '430000', '邵阳市', '430500', '邵阳县', '430523');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2145402889f8476650de01476666acbf', '湖南省', '430000', '邵阳市', '430500', '隆回县', '430524');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2146402889f8476650de01476666acbf', '湖南省', '430000', '邵阳市', '430500', '洞口县', '430525');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2147402889f8476650de01476666acbf', '湖南省', '430000', '邵阳市', '430500', '绥宁县', '430527');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2148402889f8476650de01476666acbf', '湖南省', '430000', '邵阳市', '430500', '新宁县', '430528');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2149402889f8476650de01476666acbf', '湖南省', '430000', '邵阳市', '430500', '城步苗族自治县', '430529');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2150402889f8476650de01476666acbf', '湖南省', '430000', '邵阳市', '430500', '武冈市', '430581');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2151402889f8476650de01476666acbf', '湖南省', '430000', '岳阳市', '430600', '岳阳楼区', '430602');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2152402889f8476650de01476666acbf', '湖南省', '430000', '岳阳市', '430600', '云溪区', '430603');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2153402889f8476650de01476666acbf', '湖南省', '430000', '岳阳市', '430600', '君山区', '430611');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2154402889f8476650de01476666acbf', '湖南省', '430000', '岳阳市', '430600', '岳阳县', '430621');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2155402889f8476650de01476666acbf', '湖南省', '430000', '岳阳市', '430600', '华容县', '430623');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2156402889f8476650de01476666acbf', '湖南省', '430000', '岳阳市', '430600', '湘阴县', '430624');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2157402889f8476650de01476666acbf', '湖南省', '430000', '岳阳市', '430600', '平江县', '430626');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2158402889f8476650de01476666acbf', '湖南省', '430000', '岳阳市', '430600', '汨罗市', '430681');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2159402889f8476650de01476666acbf', '湖南省', '430000', '岳阳市', '430600', '临湘市', '430682');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2160402889f8476650de01476666acbf', '湖南省', '430000', '常德市', '430700', '武陵区', '430702');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2161402889f8476650de01476666acbf', '湖南省', '430000', '常德市', '430700', '鼎城区', '430703');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2162402889f8476650de01476666acbf', '湖南省', '430000', '常德市', '430700', '安乡县', '430721');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2163402889f8476650de01476666acbf', '湖南省', '430000', '常德市', '430700', '汉寿县', '430722');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2164402889f8476650de01476666acbf', '湖南省', '430000', '常德市', '430700', '澧县', '430723');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2165402889f8476650de01476666acbf', '湖南省', '430000', '常德市', '430700', '临澧县', '430724');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2166402889f8476650de01476666acbf', '湖南省', '430000', '常德市', '430700', '桃源县', '430725');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2167402889f8476650de01476666acbf', '湖南省', '430000', '常德市', '430700', '石门县', '430726');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2168402889f8476650de01476666acbf', '湖南省', '430000', '常德市', '430700', '津市市', '430781');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2169402889f8476650de01476666acbf', '湖南省', '430000', '张家界市', '430800', '永定区', '430802');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2170402889f8476650de01476666acbf', '湖南省', '430000', '张家界市', '430800', '武陵源区', '430811');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2171402889f8476650de01476666acbf', '湖南省', '430000', '张家界市', '430800', '慈利县', '430821');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2172402889f8476650de01476666acbf', '湖南省', '430000', '张家界市', '430800', '桑植县', '430822');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2173402889f8476650de01476666acbf', '湖南省', '430000', '益阳市', '430900', '资阳区', '430902');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2174402889f8476650de01476666acbf', '湖南省', '430000', '益阳市', '430900', '赫山区', '430903');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2175402889f8476650de01476666acbf', '湖南省', '430000', '益阳市', '430900', '南县', '430921');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2176402889f8476650de01476666acbf', '湖南省', '430000', '益阳市', '430900', '桃江县', '430922');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2177402889f8476650de01476666acbf', '湖南省', '430000', '益阳市', '430900', '安化县', '430923');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2178402889f8476650de01476666acbf', '湖南省', '430000', '益阳市', '430900', '沅江市', '430981');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2179402889f8476650de01476666acbf', '湖南省', '430000', '郴州市', '431000', '北湖区', '431002');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2180402889f8476650de01476666acbf', '湖南省', '430000', '郴州市', '431000', '苏仙区', '431003');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2181402889f8476650de01476666acbf', '湖南省', '430000', '郴州市', '431000', '桂阳县', '431021');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2182402889f8476650de01476666acbf', '湖南省', '430000', '郴州市', '431000', '宜章县', '431022');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2183402889f8476650de01476666acbf', '湖南省', '430000', '郴州市', '431000', '永兴县', '431023');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2184402889f8476650de01476666acbf', '湖南省', '430000', '郴州市', '431000', '嘉禾县', '431024');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2185402889f8476650de01476666acbf', '湖南省', '430000', '郴州市', '431000', '临武县', '431025');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2186402889f8476650de01476666acbf', '湖南省', '430000', '郴州市', '431000', '汝城县', '431026');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2187402889f8476650de01476666acbf', '湖南省', '430000', '郴州市', '431000', '桂东县', '431027');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2188402889f8476650de01476666acbf', '湖南省', '430000', '郴州市', '431000', '安仁县', '431028');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2189402889f8476650de01476666acbf', '湖南省', '430000', '郴州市', '431000', '资兴市', '431081');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2190402889f8476650de01476666acbf', '湖南省', '430000', '永州市', '431100', '零陵区', '431102');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2191402889f8476650de01476666acbf', '湖南省', '430000', '永州市', '431100', '冷水滩区', '431103');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2192402889f8476650de01476666acbf', '湖南省', '430000', '永州市', '431100', '祁阳县', '431121');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2193402889f8476650de01476666acbf', '湖南省', '430000', '永州市', '431100', '东安县', '431122');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2194402889f8476650de01476666acbf', '湖南省', '430000', '永州市', '431100', '双牌县', '431123');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2195402889f8476650de01476666acbf', '湖南省', '430000', '永州市', '431100', '道县', '431124');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2196402889f8476650de01476666acbf', '湖南省', '430000', '永州市', '431100', '江永县', '431125');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2197402889f8476650de01476666acbf', '湖南省', '430000', '永州市', '431100', '宁远县', '431126');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2198402889f8476650de01476666acbf', '湖南省', '430000', '永州市', '431100', '蓝山县', '431127');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2199402889f8476650de01476666acbf', '湖南省', '430000', '永州市', '431100', '新田县', '431128');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2200402889f8476650de01476666acbf', '湖南省', '430000', '永州市', '431100', '江华瑶族自治县', '431129');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2201402889f8476650de01476666acbf', '湖南省', '430000', '怀化市', '431200', '鹤城区', '431202');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2202402889f8476650de01476666acbf', '湖南省', '430000', '怀化市', '431200', '中方县', '431221');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2203402889f8476650de01476666acbf', '湖南省', '430000', '怀化市', '431200', '沅陵县', '431222');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2204402889f8476650de01476666acbf', '湖南省', '430000', '怀化市', '431200', '辰溪县', '431223');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('2205402889f8476650de01476666acbf', '湖南省', '430000', '怀化市', '431200', '溆浦县', '431224');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1414402889f8476650de01476666acbf', '湖南省', '430000', '怀化市', '431200', '会同县', '431225');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1415402889f8476650de01476666acbf', '湖南省', '430000', '怀化市', '431200', '麻阳苗族自治县', '431226');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1416402889f8476650de01476666acbf', '湖南省', '430000', '怀化市', '431200', '新晃侗族自治县', '431227');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1417402889f8476650de01476666acbf', '湖南省', '430000', '怀化市', '431200', '芷江侗族自治县', '431228');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1418402889f8476650de01476666acbf', '湖南省', '430000', '怀化市', '431200', '靖州苗族侗族自治县', '431229');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1419402889f8476650de01476666acbf', '湖南省', '430000', '怀化市', '431200', '通道侗族自治县', '431230');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1420402889f8476650de01476666acbf', '湖南省', '430000', '怀化市', '431200', '洪江市', '431281');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1421402889f8476650de01476666acbf', '湖南省', '430000', '娄底市', '431300', '娄星区', '431302');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1422402889f8476650de01476666acbf', '湖南省', '430000', '娄底市', '431300', '双峰县', '431321');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1423402889f8476650de01476666acbf', '湖南省', '430000', '娄底市', '431300', '新化县', '431322');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1424402889f8476650de01476666acbf', '湖南省', '430000', '娄底市', '431300', '冷水江市', '431381');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1425402889f8476650de01476666acbf', '湖南省', '430000', '娄底市', '431300', '涟源市', '431382');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1426402889f8476650de01476666acbf', '湖南省', '430000', '湘西土家族苗族自治州', '431400', '吉首市', '433101');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1427402889f8476650de01476666acbf', '湖南省', '430000', '湘西土家族苗族自治州', '431400', '泸溪县', '433122');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1428402889f8476650de01476666acbf', '湖南省', '430000', '湘西土家族苗族自治州', '431400', '凤凰县', '433123');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1429402889f8476650de01476666acbf', '湖南省', '430000', '湘西土家族苗族自治州', '431400', '花垣县', '433124');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1430402889f8476650de01476666acbf', '湖南省', '430000', '湘西土家族苗族自治州', '431400', '保靖县', '433125');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1431402889f8476650de01476666acbf', '湖南省', '430000', '湘西土家族苗族自治州', '431400', '古丈县', '433126');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1432402889f8476650de01476666acbf', '湖南省', '430000', '湘西土家族苗族自治州', '431400', '永顺县', '433127');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1433402889f8476650de01476666acbf', '湖南省', '430000', '湘西土家族苗族自治州', '431400', '龙山县', '433130');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1434402889f8476650de01476666acbf', '广东省', '440000', '广州市', '440100', '荔湾区', '440103');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1435402889f8476650de01476666acbf', '广东省', '440000', '广州市', '440100', '越秀区', '440104');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1436402889f8476650de01476666acbf', '广东省', '440000', '广州市', '440100', '海珠区', '440105');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1437402889f8476650de01476666acbf', '广东省', '440000', '广州市', '440100', '天河区', '440106');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1438402889f8476650de01476666acbf', '广东省', '440000', '广州市', '440100', '白云区', '440111');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1439402889f8476650de01476666acbf', '广东省', '440000', '广州市', '440100', '黄埔区', '440112');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1440402889f8476650de01476666acbf', '广东省', '440000', '广州市', '440100', '番禺区', '440113');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1441402889f8476650de01476666acbf', '广东省', '440000', '广州市', '440100', '花都区', '440114');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1442402889f8476650de01476666acbf', '广东省', '440000', '广州市', '440100', '南沙区', '440115');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1443402889f8476650de01476666acbf', '广东省', '440000', '广州市', '440100', '萝岗区', '440116');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1444402889f8476650de01476666acbf', '广东省', '440000', '广州市', '440100', '增城市', '440183');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1445402889f8476650de01476666acbf', '广东省', '440000', '广州市', '440100', '从化市', '440184');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1446402889f8476650de01476666acbf', '广东省', '440000', '韶关市', '440200', '武江区', '440203');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1447402889f8476650de01476666acbf', '广东省', '440000', '韶关市', '440200', '浈江区', '440204');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1448402889f8476650de01476666acbf', '广东省', '440000', '韶关市', '440200', '曲江区', '440205');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1449402889f8476650de01476666acbf', '广东省', '440000', '韶关市', '440200', '始兴县', '440222');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1450402889f8476650de01476666acbf', '广东省', '440000', '韶关市', '440200', '仁化县', '440224');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1451402889f8476650de01476666acbf', '广东省', '440000', '韶关市', '440200', '翁源县', '440229');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1452402889f8476650de01476666acbf', '广东省', '440000', '韶关市', '440200', '乳源瑶族自治县', '440232');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1453402889f8476650de01476666acbf', '广东省', '440000', '韶关市', '440200', '新丰县', '440233');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1454402889f8476650de01476666acbf', '广东省', '440000', '韶关市', '440200', '乐昌市', '440281');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1455402889f8476650de01476666acbf', '广东省', '440000', '韶关市', '440200', '南雄市', '440282');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1456402889f8476650de01476666acbf', '广东省', '440000', '深圳市', '440300', '罗湖区', '440303');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1457402889f8476650de01476666acbf', '广东省', '440000', '深圳市', '440300', '福田区', '440304');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1458402889f8476650de01476666acbf', '广东省', '440000', '深圳市', '440300', '南山区', '440305');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1459402889f8476650de01476666acbf', '广东省', '440000', '深圳市', '440300', '宝安区', '440306');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1460402889f8476650de01476666acbf', '广东省', '440000', '深圳市', '440300', '龙岗区', '440307');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1461402889f8476650de01476666acbf', '广东省', '440000', '深圳市', '440300', '盐田区', '440308');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1462402889f8476650de01476666acbf', '广东省', '440000', '珠海市', '440400', '香洲区', '440402');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1463402889f8476650de01476666acbf', '广东省', '440000', '珠海市', '440400', '斗门区', '440403');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1464402889f8476650de01476666acbf', '广东省', '440000', '珠海市', '440400', '金湾区', '440404');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1465402889f8476650de01476666acbf', '广东省', '440000', '汕头市', '440500', '龙湖区', '440507');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1466402889f8476650de01476666acbf', '广东省', '440000', '汕头市', '440500', '金平区', '440511');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1467402889f8476650de01476666acbf', '广东省', '440000', '汕头市', '440500', '濠江区', '440512');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1468402889f8476650de01476666acbf', '广东省', '440000', '汕头市', '440500', '潮阳区', '440513');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1469402889f8476650de01476666acbf', '广东省', '440000', '汕头市', '440500', '潮南区', '440514');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1470402889f8476650de01476666acbf', '广东省', '440000', '汕头市', '440500', '澄海区', '440515');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1471402889f8476650de01476666acbf', '广东省', '440000', '汕头市', '440500', '南澳县', '440523');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1472402889f8476650de01476666acbf', '广东省', '440000', '佛山市', '440600', '禅城区', '440604');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1473402889f8476650de01476666acbf', '广东省', '440000', '佛山市', '440600', '南海区', '440605');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1474402889f8476650de01476666acbf', '广东省', '440000', '佛山市', '440600', '顺德区', '440606');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1475402889f8476650de01476666acbf', '广东省', '440000', '佛山市', '440600', '三水区', '440607');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1476402889f8476650de01476666acbf', '广东省', '440000', '佛山市', '440600', '高明区', '440608');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1477402889f8476650de01476666acbf', '广东省', '440000', '江门市', '440700', '蓬江区', '440703');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1478402889f8476650de01476666acbf', '广东省', '440000', '江门市', '440700', '江海区', '440704');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1479402889f8476650de01476666acbf', '广东省', '440000', '江门市', '440700', '新会区', '440705');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1480402889f8476650de01476666acbf', '广东省', '440000', '江门市', '440700', '台山市', '440781');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1481402889f8476650de01476666acbf', '广东省', '440000', '江门市', '440700', '开平市', '440783');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1482402889f8476650de01476666acbf', '广东省', '440000', '江门市', '440700', '鹤山市', '440784');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1483402889f8476650de01476666acbf', '广东省', '440000', '江门市', '440700', '恩平市', '440785');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1484402889f8476650de01476666acbf', '广东省', '440000', '湛江市', '440800', '赤坎区', '440802');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1485402889f8476650de01476666acbf', '广东省', '440000', '湛江市', '440800', '霞山区', '440803');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1486402889f8476650de01476666acbf', '广东省', '440000', '湛江市', '440800', '坡头区', '440804');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1487402889f8476650de01476666acbf', '广东省', '440000', '湛江市', '440800', '麻章区', '440811');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1488402889f8476650de01476666acbf', '广东省', '440000', '湛江市', '440800', '遂溪县', '440823');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1489402889f8476650de01476666acbf', '广东省', '440000', '湛江市', '440800', '徐闻县', '440825');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1490402889f8476650de01476666acbf', '广东省', '440000', '湛江市', '440800', '廉江市', '440881');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1491402889f8476650de01476666acbf', '广东省', '440000', '湛江市', '440800', '雷州市', '440882');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1492402889f8476650de01476666acbf', '广东省', '440000', '湛江市', '440800', '吴川市', '440883');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1493402889f8476650de01476666acbf', '广东省', '440000', '茂名市', '440900', '茂南区', '440902');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1494402889f8476650de01476666acbf', '广东省', '440000', '茂名市', '440900', '茂港区', '440903');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1495402889f8476650de01476666acbf', '广东省', '440000', '茂名市', '440900', '电白县', '440923');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1496402889f8476650de01476666acbf', '广东省', '440000', '茂名市', '440900', '高州市', '440981');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1497402889f8476650de01476666acbf', '广东省', '440000', '茂名市', '440900', '化州市', '440982');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1498402889f8476650de01476666acbf', '广东省', '440000', '茂名市', '440900', '信宜市', '440983');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1499402889f8476650de01476666acbf', '广东省', '440000', '肇庆市', '441200', '端州区', '441202');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1500402889f8476650de01476666acbf', '广东省', '440000', '肇庆市', '441200', '鼎湖区', '441203');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1501402889f8476650de01476666acbf', '广东省', '440000', '肇庆市', '441200', '广宁县', '441223');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1502402889f8476650de01476666acbf', '广东省', '440000', '肇庆市', '441200', '怀集县', '441224');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1503402889f8476650de01476666acbf', '广东省', '440000', '肇庆市', '441200', '封开县', '441225');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1504402889f8476650de01476666acbf', '广东省', '440000', '肇庆市', '441200', '德庆县', '441226');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1505402889f8476650de01476666acbf', '广东省', '440000', '肇庆市', '441200', '高要市', '441283');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1506402889f8476650de01476666acbf', '广东省', '440000', '肇庆市', '441200', '四会市', '441284');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1507402889f8476650de01476666acbf', '广东省', '440000', '惠州市', '441300', '惠城区', '441302');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1508402889f8476650de01476666acbf', '广东省', '440000', '惠州市', '441300', '惠阳区', '441303');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1509402889f8476650de01476666acbf', '广东省', '440000', '惠州市', '441300', '博罗县', '441322');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1510402889f8476650de01476666acbf', '广东省', '440000', '惠州市', '441300', '惠东县', '441323');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1511402889f8476650de01476666acbf', '广东省', '440000', '惠州市', '441300', '龙门县', '441324');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1512402889f8476650de01476666acbf', '广东省', '440000', '梅州市', '441400', '梅江区', '441402');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1513402889f8476650de01476666acbf', '广东省', '440000', '梅州市', '441400', '梅县', '441421');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1514402889f8476650de01476666acbf', '广东省', '440000', '梅州市', '441400', '大埔县', '441422');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1515402889f8476650de01476666acbf', '广东省', '440000', '梅州市', '441400', '丰顺县', '441423');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1516402889f8476650de01476666acbf', '广东省', '440000', '梅州市', '441400', '五华县', '441424');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1517402889f8476650de01476666acbf', '广东省', '440000', '梅州市', '441400', '平远县', '441426');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1518402889f8476650de01476666acbf', '广东省', '440000', '梅州市', '441400', '蕉岭县', '441427');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1519402889f8476650de01476666acbf', '广东省', '440000', '梅州市', '441400', '兴宁市', '441481');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1520402889f8476650de01476666acbf', '广东省', '440000', '汕尾市', '441500', '城区', '441502');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1521402889f8476650de01476666acbf', '广东省', '440000', '汕尾市', '441500', '海丰县', '441521');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1522402889f8476650de01476666acbf', '广东省', '440000', '汕尾市', '441500', '陆河县', '441523');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1523402889f8476650de01476666acbf', '广东省', '440000', '汕尾市', '441500', '陆丰市', '441581');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1524402889f8476650de01476666acbf', '广东省', '440000', '河源市', '441600', '源城区', '441602');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1525402889f8476650de01476666acbf', '广东省', '440000', '河源市', '441600', '紫金县', '441621');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1526402889f8476650de01476666acbf', '广东省', '440000', '河源市', '441600', '龙川县', '441622');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1527402889f8476650de01476666acbf', '广东省', '440000', '河源市', '441600', '连平县', '441623');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1528402889f8476650de01476666acbf', '广东省', '440000', '河源市', '441600', '和平县', '441624');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1529402889f8476650de01476666acbf', '广东省', '440000', '河源市', '441600', '东源县', '441625');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1530402889f8476650de01476666acbf', '广东省', '440000', '阳江市', '441700', '江城区', '441702');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1531402889f8476650de01476666acbf', '广东省', '440000', '阳江市', '441700', '阳西县', '441721');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1532402889f8476650de01476666acbf', '广东省', '440000', '阳江市', '441700', '阳东县', '441723');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1533402889f8476650de01476666acbf', '广东省', '440000', '阳江市', '441700', '阳春市', '441781');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1534402889f8476650de01476666acbf', '广东省', '440000', '清远市', '441800', '清城区', '441802');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1535402889f8476650de01476666acbf', '广东省', '440000', '清远市', '441800', '佛冈县', '441821');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1536402889f8476650de01476666acbf', '广东省', '440000', '清远市', '441800', '阳山县', '441823');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1537402889f8476650de01476666acbf', '广东省', '440000', '清远市', '441800', '连山壮族瑶族自治县', '441825');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1538402889f8476650de01476666acbf', '广东省', '440000', '清远市', '441800', '连南瑶族自治县', '441826');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1539402889f8476650de01476666acbf', '广东省', '440000', '清远市', '441800', '清新县', '441827');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1540402889f8476650de01476666acbf', '广东省', '440000', '清远市', '441800', '英德市', '441881');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1541402889f8476650de01476666acbf', '广东省', '440000', '清远市', '441800', '连州市', '441882');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1542402889f8476650de01476666acbf', '广东省', '440000', '东莞市', '441900', '东莞市', '441900');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1543402889f8476650de01476666acbf', '广东省', '440000', '中山市', '442000', '中山市', '442000');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1544402889f8476650de01476666acbf', '广东省', '440000', '潮州市', '445100', '湘桥区', '445102');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1545402889f8476650de01476666acbf', '广东省', '440000', '潮州市', '445100', '潮安县', '445121');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1546402889f8476650de01476666acbf', '广东省', '440000', '潮州市', '445100', '饶平县', '445122');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1547402889f8476650de01476666acbf', '广东省', '440000', '揭阳市', '445200', '榕城区', '445202');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1548402889f8476650de01476666acbf', '广东省', '440000', '揭阳市', '445200', '揭东县', '445221');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1549402889f8476650de01476666acbf', '广东省', '440000', '揭阳市', '445200', '揭西县', '445222');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1550402889f8476650de01476666acbf', '广东省', '440000', '揭阳市', '445200', '惠来县', '445224');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1551402889f8476650de01476666acbf', '广东省', '440000', '揭阳市', '445200', '普宁市', '445281');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1552402889f8476650de01476666acbf', '广东省', '440000', '云浮市', '445300', '云城区', '445302');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1553402889f8476650de01476666acbf', '广东省', '440000', '云浮市', '445300', '新兴县', '445321');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1554402889f8476650de01476666acbf', '广东省', '440000', '云浮市', '445300', '郁南县', '445322');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1555402889f8476650de01476666acbf', '广东省', '440000', '云浮市', '445300', '云安县', '445323');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1556402889f8476650de01476666acbf', '广东省', '440000', '云浮市', '445300', '罗定市', '445381');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1557402889f8476650de01476666acbf', '广西壮族自治区', '450000', '南宁市', '450100', '兴宁区', '450102');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1558402889f8476650de01476666acbf', '广西壮族自治区', '450000', '南宁市', '450100', '青秀区', '450103');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1559402889f8476650de01476666acbf', '广西壮族自治区', '450000', '南宁市', '450100', '江南区', '450105');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1560402889f8476650de01476666acbf', '广西壮族自治区', '450000', '南宁市', '450100', '西乡塘区', '450107');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('377402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '南宁市', '450100', '良庆区', '450108');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('378402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '南宁市', '450100', '邕宁区', '450109');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('379402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '南宁市', '450100', '武鸣县', '450122');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('380402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '南宁市', '450100', '隆安县', '450123');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('381402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '南宁市', '450100', '马山县', '450124');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('382402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '南宁市', '450100', '上林县', '450125');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('383402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '南宁市', '450100', '宾阳县', '450126');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('384402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '南宁市', '450100', '横县', '450127');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('385402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '柳州市', '450200', '城中区', '450202');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('386402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '柳州市', '450200', '鱼峰区', '450203');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('387402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '柳州市', '450200', '柳南区', '450204');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('388402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '柳州市', '450200', '柳北区', '450205');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('389402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '柳州市', '450200', '柳江县', '450221');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('390402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '柳州市', '450200', '柳城县', '450222');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('391402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '柳州市', '450200', '鹿寨县', '450223');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('392402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '柳州市', '450200', '融安县', '450224');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('393402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '柳州市', '450200', '融水苗族自治县', '450225');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('394402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '柳州市', '450200', '三江侗族自治县', '450226');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('395402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '桂林市', '450300', '秀峰区', '450302');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('396402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '桂林市', '450300', '叠彩区', '450303');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('397402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '桂林市', '450300', '象山区', '450304');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('398402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '桂林市', '450300', '七星区', '450305');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('399402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '桂林市', '450300', '雁山区', '450311');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('400402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '桂林市', '450300', '阳朔县', '450321');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('401402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '桂林市', '450300', '临桂县', '450322');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('402402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '桂林市', '450300', '灵川县', '450323');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('403402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '桂林市', '450300', '全州县', '450324');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('404402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '桂林市', '450300', '兴安县', '450325');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('405402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '桂林市', '450300', '永福县', '450326');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('406402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '桂林市', '450300', '灌阳县', '450327');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('407402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '桂林市', '450300', '龙胜各族自治县', '450328');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('408402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '桂林市', '450300', '资源县', '450329');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('409402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '桂林市', '450300', '平乐县', '450330');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('410402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '桂林市', '450300', '荔浦县', '450331');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('411402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '桂林市', '450300', '恭城瑶族自治县', '450332');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('412402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '梧州市', '450400', '万秀区', '450403');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('413402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '梧州市', '450400', '蝶山区', '450404');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('414402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '梧州市', '450400', '长洲区', '450405');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('415402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '梧州市', '450400', '苍梧县', '450421');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('416402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '梧州市', '450400', '藤县', '450422');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('417402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '梧州市', '450400', '蒙山县', '450423');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('418402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '梧州市', '450400', '岑溪市', '450481');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('419402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '北海市', '450500', '海城区', '450502');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('420402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '北海市', '450500', '银海区', '450503');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('421402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '北海市', '450500', '铁山港区', '450512');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('422402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '北海市', '450500', '合浦县', '450521');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('423402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '防城港市', '450600', '港口区', '450602');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('424402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '防城港市', '450600', '防城区', '450603');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('425402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '防城港市', '450600', '上思县', '450621');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('426402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '防城港市', '450600', '东兴市', '450681');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('427402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '钦州市', '450700', '钦南区', '450702');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('428402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '钦州市', '450700', '钦北区', '450703');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('429402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '钦州市', '450700', '灵山县', '450721');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('430402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '钦州市', '450700', '浦北县', '450722');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('431402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '贵港市', '450800', '港北区', '450802');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('432402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '贵港市', '450800', '港南区', '450803');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('433402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '贵港市', '450800', '覃塘区', '450804');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('434402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '贵港市', '450800', '平南县', '450821');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('435402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '贵港市', '450800', '桂平市', '450881');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('436402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '玉林市', '450900', '玉州区', '450902');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('437402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '玉林市', '450900', '容县', '450921');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('438402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '玉林市', '450900', '陆川县', '450922');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('439402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '玉林市', '450900', '博白县', '450923');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('440402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '玉林市', '450900', '兴业县', '450924');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('441402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '玉林市', '450900', '北流市', '450981');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('442402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '百色市', '451000', '右江区', '451002');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('443402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '百色市', '451000', '田阳县', '451021');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('444402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '百色市', '451000', '田东县', '451022');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('445402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '百色市', '451000', '平果县', '451023');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('446402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '百色市', '451000', '德保县', '451024');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('447402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '百色市', '451000', '靖西县', '451025');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('448402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '百色市', '451000', '那坡县', '451026');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('449402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '百色市', '451000', '凌云县', '451027');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('450402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '百色市', '451000', '乐业县', '451028');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('451402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '百色市', '451000', '田林县', '451029');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('452402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '百色市', '451000', '西林县', '451030');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('453402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '百色市', '451000', '隆林各族自治县', '451031');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('454402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '贺州市', '451100', '八步区', '451102');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('455402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '贺州市', '451100', '昭平县', '451121');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('456402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '贺州市', '451100', '钟山县', '451122');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('457402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '贺州市', '451100', '富川瑶族自治县', '451123');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('458402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '河池市', '451200', '金城江区', '451202');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('459402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '河池市', '451200', '南丹县', '451221');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('460402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '河池市', '451200', '天峨县', '451222');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('461402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '河池市', '451200', '凤山县', '451223');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('462402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '河池市', '451200', '东兰县', '451224');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('463402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '河池市', '451200', '罗城仫佬族自治县', '451225');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('464402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '河池市', '451200', '环江毛南族自治县', '451226');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('465402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '河池市', '451200', '巴马瑶族自治县', '451227');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('466402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '河池市', '451200', '都安瑶族自治县', '451228');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('467402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '河池市', '451200', '大化瑶族自治县', '451229');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('468402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '河池市', '451200', '宜州市', '451281');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('469402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '来宾市', '451300', '兴宾区', '451302');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('470402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '来宾市', '451300', '忻城县', '451321');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('471402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '来宾市', '451300', '象州县', '451322');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('472402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '来宾市', '451300', '武宣县', '451323');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('473402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '来宾市', '451300', '金秀瑶族自治县', '451324');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('474402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '来宾市', '451300', '合山市', '451381');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('475402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '崇左市', '451400', '江洲区', '451402');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('476402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '崇左市', '451400', '扶绥县', '451421');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('477402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '崇左市', '451400', '宁明县', '451422');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('478402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '崇左市', '451400', '龙州县', '451423');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('479402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '崇左市', '451400', '大新县', '451424');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('480402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '崇左市', '451400', '天等县', '451425');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('481402889f8476650de01476666acbf0', '广西壮族自治区', '450000', '崇左市', '451400', '凭祥市', '451481');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('482402889f8476650de01476666acbf0', '海南省', '460000', '海口市', '460100', '秀英区', '460105');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('483402889f8476650de01476666acbf0', '海南省', '460000', '海口市', '460100', '龙华区', '460106');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('484402889f8476650de01476666acbf0', '海南省', '460000', '海口市', '460100', '琼山区', '460107');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('485402889f8476650de01476666acbf0', '海南省', '460000', '海口市', '460100', '美兰区', '460108');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('486402889f8476650de01476666acbf0', '海南省', '460000', '三亚市', '460200', '西沙群岛', '460321');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('487402889f8476650de01476666acbf0', '海南省', '460000', '三亚市', '460200', '南沙群岛', '460322');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('488402889f8476650de01476666acbf0', '海南省', '460000', '三亚市', '460200', '中沙群岛的岛礁及其海域', '460323');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('489402889f8476650de01476666acbf0', '海南省', '460000', '五指山市', '469001', '五指山市', '469001');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('490402889f8476650de01476666acbf0', '海南省', '460000', '琼海市', '469002', '琼海市', '469002');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('491402889f8476650de01476666acbf0', '海南省', '460000', '儋州市', '469003', '儋州市', '469003');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('492402889f8476650de01476666acbf0', '海南省', '460000', '文昌市', '469005', '文昌市', '469005');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('493402889f8476650de01476666acbf0', '海南省', '460000', '万宁市', '469006', '万宁市', '469006');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('494402889f8476650de01476666acbf0', '海南省', '460000', '东方市', '469007', '东方市', '469007');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('495402889f8476650de01476666acbf0', '海南省', '460000', '定安县', '469021', '定安县', '469021');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('496402889f8476650de01476666acbf0', '海南省', '460000', '屯昌县', '469022', '屯昌县', '469022');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('497402889f8476650de01476666acbf0', '海南省', '460000', '澄迈县', '469023', '澄迈县', '469023');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('498402889f8476650de01476666acbf0', '海南省', '460000', '临高县', '469024', '临高县', '469024');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('499402889f8476650de01476666acbf0', '海南省', '460000', '白沙黎族自治县', '469025', '白沙黎族自治县', '469025');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('500402889f8476650de01476666acbf0', '海南省', '460000', '昌江黎族自治县', '469026', '昌江黎族自治县', '469026');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('501402889f8476650de01476666acbf0', '海南省', '460000', '乐东黎族自治县', '469027', '乐东黎族自治县', '469027');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('502402889f8476650de01476666acbf0', '海南省', '460000', '陵水黎族自治县', '469028', '陵水黎族自治县', '469028');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('503402889f8476650de01476666acbf0', '海南省', '460000', '保亭黎族苗族自治县', '469029', '保亭黎族苗族自治县', '469029');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('504402889f8476650de01476666acbf0', '海南省', '460000', '琼中黎族苗族自治县', '469030', '琼中黎族苗族自治县', '469030');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('505402889f8476650de01476666acbf0', '重庆市', '500000', '重庆市', '500000', '万州区', '500101');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('506402889f8476650de01476666acbf0', '重庆市', '500000', '重庆市', '500000', '涪陵区', '500102');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('507402889f8476650de01476666acbf0', '重庆市', '500000', '重庆市', '500000', '渝中区', '500103');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('508402889f8476650de01476666acbf0', '重庆市', '500000', '重庆市', '500000', '大渡口区', '500104');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('509402889f8476650de01476666acbf0', '重庆市', '500000', '重庆市', '500000', '江北区', '500105');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('510402889f8476650de01476666acbf0', '重庆市', '500000', '重庆市', '500000', '沙坪坝区', '500106');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('511402889f8476650de01476666acbf0', '重庆市', '500000', '重庆市', '500000', '九龙坡区', '500107');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('512402889f8476650de01476666acbf0', '重庆市', '500000', '重庆市', '500000', '南岸区', '500108');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('513402889f8476650de01476666acbf0', '重庆市', '500000', '重庆市', '500000', '北碚区', '500109');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('514402889f8476650de01476666acbf0', '重庆市', '500000', '重庆市', '500000', '綦江区', '500110');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1561402889f8476650de01476666acbf', '重庆市', '500000', '重庆市', '500000', '大足区', '500111');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1562402889f8476650de01476666acbf', '重庆市', '500000', '重庆市', '500000', '渝北区', '500112');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1563402889f8476650de01476666acbf', '重庆市', '500000', '重庆市', '500000', '巴南区', '500113');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1564402889f8476650de01476666acbf', '重庆市', '500000', '重庆市', '500000', '黔江区', '500114');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1565402889f8476650de01476666acbf', '重庆市', '500000', '重庆市', '500000', '长寿区', '500115');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1566402889f8476650de01476666acbf', '重庆市', '500000', '重庆市', '500000', '江津区', '500116');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1567402889f8476650de01476666acbf', '重庆市', '500000', '重庆市', '500000', '合川区', '500117');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1568402889f8476650de01476666acbf', '重庆市', '500000', '重庆市', '500000', '永川区', '500118');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1569402889f8476650de01476666acbf', '重庆市', '500000', '重庆市', '500000', '南川区', '500119');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1570402889f8476650de01476666acbf', '重庆市', '500000', '重庆市', '500000', '潼南县', '500223');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1571402889f8476650de01476666acbf', '重庆市', '500000', '重庆市', '500000', '铜梁县', '500224');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1572402889f8476650de01476666acbf', '重庆市', '500000', '重庆市', '500000', '荣昌县', '500226');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1573402889f8476650de01476666acbf', '重庆市', '500000', '重庆市', '500000', '璧山县', '500227');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1574402889f8476650de01476666acbf', '重庆市', '500000', '重庆市', '500000', '梁平县', '500228');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1575402889f8476650de01476666acbf', '重庆市', '500000', '重庆市', '500000', '城口县', '500229');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1576402889f8476650de01476666acbf', '重庆市', '500000', '重庆市', '500000', '丰都县', '500230');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1577402889f8476650de01476666acbf', '重庆市', '500000', '重庆市', '500000', '垫江县', '500231');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1578402889f8476650de01476666acbf', '重庆市', '500000', '重庆市', '500000', '武隆县', '500232');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1579402889f8476650de01476666acbf', '重庆市', '500000', '重庆市', '500000', '忠县', '500233');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1580402889f8476650de01476666acbf', '重庆市', '500000', '重庆市', '500000', '开县', '500234');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1581402889f8476650de01476666acbf', '重庆市', '500000', '重庆市', '500000', '云阳县', '500235');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1582402889f8476650de01476666acbf', '重庆市', '500000', '重庆市', '500000', '奉节县', '500236');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1583402889f8476650de01476666acbf', '重庆市', '500000', '重庆市', '500000', '巫山县', '500237');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1584402889f8476650de01476666acbf', '重庆市', '500000', '重庆市', '500000', '巫溪县', '500238');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1585402889f8476650de01476666acbf', '重庆市', '500000', '重庆市', '500000', '石柱土家族自治县', '500240');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1586402889f8476650de01476666acbf', '重庆市', '500000', '重庆市', '500000', '秀山土家族苗族自治县', '500241');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1587402889f8476650de01476666acbf', '重庆市', '500000', '重庆市', '500000', '酉阳土家族苗族自治县', '500242');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1588402889f8476650de01476666acbf', '重庆市', '500000', '重庆市', '500000', '彭水苗族土家族自治县', '500243');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1589402889f8476650de01476666acbf', '四川省', '510000', '成都市', '510100', '锦江区', '510104');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1590402889f8476650de01476666acbf', '四川省', '510000', '成都市', '510100', '青羊区', '510105');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1591402889f8476650de01476666acbf', '四川省', '510000', '成都市', '510100', '金牛区', '510106');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1592402889f8476650de01476666acbf', '四川省', '510000', '成都市', '510100', '武侯区', '510107');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1593402889f8476650de01476666acbf', '四川省', '510000', '成都市', '510100', '成华区', '510108');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1594402889f8476650de01476666acbf', '四川省', '510000', '成都市', '510100', '龙泉驿区', '510112');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1595402889f8476650de01476666acbf', '四川省', '510000', '成都市', '510100', '青白江区', '510113');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1596402889f8476650de01476666acbf', '四川省', '510000', '成都市', '510100', '新都区', '510114');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1597402889f8476650de01476666acbf', '四川省', '510000', '成都市', '510100', '温江区', '510115');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1598402889f8476650de01476666acbf', '四川省', '510000', '成都市', '510100', '金堂县', '510121');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1599402889f8476650de01476666acbf', '四川省', '510000', '成都市', '510100', '双流县', '510122');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1600402889f8476650de01476666acbf', '四川省', '510000', '成都市', '510100', '郫县', '510124');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1601402889f8476650de01476666acbf', '四川省', '510000', '成都市', '510100', '大邑县', '510129');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1602402889f8476650de01476666acbf', '四川省', '510000', '成都市', '510100', '蒲江县', '510131');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1603402889f8476650de01476666acbf', '四川省', '510000', '成都市', '510100', '新津县', '510132');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1604402889f8476650de01476666acbf', '四川省', '510000', '成都市', '510100', '都江堰市', '510181');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1605402889f8476650de01476666acbf', '四川省', '510000', '成都市', '510100', '彭州市', '510182');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1606402889f8476650de01476666acbf', '四川省', '510000', '成都市', '510100', '邛崃市', '510183');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1607402889f8476650de01476666acbf', '四川省', '510000', '成都市', '510100', '崇州市', '510184');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1608402889f8476650de01476666acbf', '四川省', '510000', '自贡市', '510300', '自流井区', '510302');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1609402889f8476650de01476666acbf', '四川省', '510000', '自贡市', '510300', '贡井区', '510303');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1610402889f8476650de01476666acbf', '四川省', '510000', '自贡市', '510300', '大安区', '510304');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1611402889f8476650de01476666acbf', '四川省', '510000', '自贡市', '510300', '沿滩区', '510311');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1612402889f8476650de01476666acbf', '四川省', '510000', '自贡市', '510300', '荣县', '510321');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1613402889f8476650de01476666acbf', '四川省', '510000', '自贡市', '510300', '富顺县', '510322');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1614402889f8476650de01476666acbf', '四川省', '510000', '攀枝花市', '510400', '东区', '510402');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1615402889f8476650de01476666acbf', '四川省', '510000', '攀枝花市', '510400', '西区', '510403');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1616402889f8476650de01476666acbf', '四川省', '510000', '攀枝花市', '510400', '仁和区', '510411');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1617402889f8476650de01476666acbf', '四川省', '510000', '攀枝花市', '510400', '米易县', '510421');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1618402889f8476650de01476666acbf', '四川省', '510000', '攀枝花市', '510400', '盐边县', '510422');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1619402889f8476650de01476666acbf', '四川省', '510000', '泸州市', '510500', '江阳区', '510502');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1620402889f8476650de01476666acbf', '四川省', '510000', '泸州市', '510500', '纳溪区', '510503');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1621402889f8476650de01476666acbf', '四川省', '510000', '泸州市', '510500', '龙马潭区', '510504');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1622402889f8476650de01476666acbf', '四川省', '510000', '泸州市', '510500', '泸县', '510521');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1623402889f8476650de01476666acbf', '四川省', '510000', '泸州市', '510500', '合江县', '510522');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1624402889f8476650de01476666acbf', '四川省', '510000', '泸州市', '510500', '叙永县', '510524');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1625402889f8476650de01476666acbf', '四川省', '510000', '泸州市', '510500', '古蔺县', '510525');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1626402889f8476650de01476666acbf', '四川省', '510000', '德阳市', '510600', '旌阳区', '510603');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1627402889f8476650de01476666acbf', '四川省', '510000', '德阳市', '510600', '中江县', '510623');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1628402889f8476650de01476666acbf', '四川省', '510000', '德阳市', '510600', '罗江县', '510626');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1629402889f8476650de01476666acbf', '四川省', '510000', '德阳市', '510600', '广汉市', '510681');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1630402889f8476650de01476666acbf', '四川省', '510000', '德阳市', '510600', '什邡市', '510682');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1631402889f8476650de01476666acbf', '四川省', '510000', '德阳市', '510600', '绵竹市', '510683');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1632402889f8476650de01476666acbf', '四川省', '510000', '绵阳市', '510700', '涪城区', '510703');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1633402889f8476650de01476666acbf', '四川省', '510000', '绵阳市', '510700', '游仙区', '510704');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1634402889f8476650de01476666acbf', '四川省', '510000', '绵阳市', '510700', '三台县', '510722');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1635402889f8476650de01476666acbf', '四川省', '510000', '绵阳市', '510700', '盐亭县', '510723');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1636402889f8476650de01476666acbf', '四川省', '510000', '绵阳市', '510700', '安县', '510724');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1637402889f8476650de01476666acbf', '四川省', '510000', '绵阳市', '510700', '梓潼县', '510725');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1638402889f8476650de01476666acbf', '四川省', '510000', '绵阳市', '510700', '北川羌族自治县', '510726');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1639402889f8476650de01476666acbf', '四川省', '510000', '绵阳市', '510700', '平武县', '510727');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1640402889f8476650de01476666acbf', '四川省', '510000', '绵阳市', '510700', '江油市', '510781');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1641402889f8476650de01476666acbf', '四川省', '510000', '广元市', '510800', '利州区', '510802');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1642402889f8476650de01476666acbf', '四川省', '510000', '广元市', '510800', '元坝区', '510811');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1643402889f8476650de01476666acbf', '四川省', '510000', '广元市', '510800', '朝天区', '510812');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1644402889f8476650de01476666acbf', '四川省', '510000', '广元市', '510800', '旺苍县', '510821');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1645402889f8476650de01476666acbf', '四川省', '510000', '广元市', '510800', '青川县', '510822');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1646402889f8476650de01476666acbf', '四川省', '510000', '广元市', '510800', '剑阁县', '510823');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1647402889f8476650de01476666acbf', '四川省', '510000', '广元市', '510800', '苍溪县', '510824');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1648402889f8476650de01476666acbf', '四川省', '510000', '遂宁市', '510900', '船山区', '510903');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1649402889f8476650de01476666acbf', '四川省', '510000', '遂宁市', '510900', '安居区', '510904');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1650402889f8476650de01476666acbf', '四川省', '510000', '遂宁市', '510900', '蓬溪县', '510921');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1651402889f8476650de01476666acbf', '四川省', '510000', '遂宁市', '510900', '射洪县', '510922');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1652402889f8476650de01476666acbf', '四川省', '510000', '遂宁市', '510900', '大英县', '510923');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1653402889f8476650de01476666acbf', '四川省', '510000', '内江市', '511000', '市中区', '511002');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1654402889f8476650de01476666acbf', '四川省', '510000', '内江市', '511000', '东兴区', '511011');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1655402889f8476650de01476666acbf', '四川省', '510000', '内江市', '511000', '威远县', '511024');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1656402889f8476650de01476666acbf', '四川省', '510000', '内江市', '511000', '资中县', '511025');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1657402889f8476650de01476666acbf', '四川省', '510000', '内江市', '511000', '隆昌县', '511028');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1658402889f8476650de01476666acbf', '四川省', '510000', '乐山市', '511100', '市中区', '511102');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1659402889f8476650de01476666acbf', '四川省', '510000', '乐山市', '511100', '沙湾区', '511111');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1660402889f8476650de01476666acbf', '四川省', '510000', '乐山市', '511100', '五通桥区', '511112');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1661402889f8476650de01476666acbf', '四川省', '510000', '乐山市', '511100', '金口河区', '511113');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1662402889f8476650de01476666acbf', '四川省', '510000', '乐山市', '511100', '犍为县', '511123');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1663402889f8476650de01476666acbf', '四川省', '510000', '乐山市', '511100', '井研县', '511124');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1664402889f8476650de01476666acbf', '四川省', '510000', '乐山市', '511100', '夹江县', '511126');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1665402889f8476650de01476666acbf', '四川省', '510000', '乐山市', '511100', '沐川县', '511129');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1666402889f8476650de01476666acbf', '四川省', '510000', '乐山市', '511100', '峨边彝族自治县', '511132');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1667402889f8476650de01476666acbf', '四川省', '510000', '乐山市', '511100', '马边彝族自治县', '511133');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1668402889f8476650de01476666acbf', '四川省', '510000', '乐山市', '511100', '峨眉山市', '511181');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1669402889f8476650de01476666acbf', '四川省', '510000', '南充市', '511300', '顺庆区', '511302');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1670402889f8476650de01476666acbf', '四川省', '510000', '南充市', '511300', '高坪区', '511303');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1671402889f8476650de01476666acbf', '四川省', '510000', '南充市', '511300', '嘉陵区', '511304');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1672402889f8476650de01476666acbf', '四川省', '510000', '南充市', '511300', '南部县', '511321');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1673402889f8476650de01476666acbf', '四川省', '510000', '南充市', '511300', '营山县', '511322');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1674402889f8476650de01476666acbf', '四川省', '510000', '南充市', '511300', '蓬安县', '511323');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1675402889f8476650de01476666acbf', '四川省', '510000', '南充市', '511300', '仪陇县', '511324');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1676402889f8476650de01476666acbf', '四川省', '510000', '南充市', '511300', '西充县', '511325');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1677402889f8476650de01476666acbf', '四川省', '510000', '南充市', '511300', '阆中市', '511381');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1678402889f8476650de01476666acbf', '四川省', '510000', '眉山市', '511400', '东坡区', '511402');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1679402889f8476650de01476666acbf', '四川省', '510000', '眉山市', '511400', '仁寿县', '511421');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1680402889f8476650de01476666acbf', '四川省', '510000', '眉山市', '511400', '彭山县', '511422');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1681402889f8476650de01476666acbf', '四川省', '510000', '眉山市', '511400', '洪雅县', '511423');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1682402889f8476650de01476666acbf', '四川省', '510000', '眉山市', '511400', '丹棱县', '511424');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1683402889f8476650de01476666acbf', '四川省', '510000', '眉山市', '511400', '青神县', '511425');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1684402889f8476650de01476666acbf', '四川省', '510000', '宜宾市', '511500', '翠屏区', '511502');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1685402889f8476650de01476666acbf', '四川省', '510000', '宜宾市', '511500', '南溪区', '511503');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1686402889f8476650de01476666acbf', '四川省', '510000', '宜宾市', '511500', '宜宾县', '511521');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1687402889f8476650de01476666acbf', '四川省', '510000', '宜宾市', '511500', '江安县', '511523');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1688402889f8476650de01476666acbf', '四川省', '510000', '宜宾市', '511500', '长宁县', '511524');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1689402889f8476650de01476666acbf', '四川省', '510000', '宜宾市', '511500', '高县', '511525');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1690402889f8476650de01476666acbf', '四川省', '510000', '宜宾市', '511500', '珙县', '511526');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1691402889f8476650de01476666acbf', '四川省', '510000', '宜宾市', '511500', '筠连县', '511527');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1692402889f8476650de01476666acbf', '四川省', '510000', '宜宾市', '511500', '兴文县', '511528');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1693402889f8476650de01476666acbf', '四川省', '510000', '宜宾市', '511500', '屏山县', '511529');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1694402889f8476650de01476666acbf', '四川省', '510000', '广安市', '511600', '广安区', '511602');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1695402889f8476650de01476666acbf', '四川省', '510000', '广安市', '511600', '岳池县', '511621');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1696402889f8476650de01476666acbf', '四川省', '510000', '广安市', '511600', '武胜县', '511622');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1697402889f8476650de01476666acbf', '四川省', '510000', '广安市', '511600', '邻水县', '511623');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1698402889f8476650de01476666acbf', '四川省', '510000', '广安市', '511600', '华蓥市', '511681');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1699402889f8476650de01476666acbf', '四川省', '510000', '达州市', '511700', '通川区', '511702');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1700402889f8476650de01476666acbf', '四川省', '510000', '达州市', '511700', '达县', '511721');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1701402889f8476650de01476666acbf', '四川省', '510000', '达州市', '511700', '宣汉县', '511722');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1702402889f8476650de01476666acbf', '四川省', '510000', '达州市', '511700', '开江县', '511723');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1703402889f8476650de01476666acbf', '四川省', '510000', '达州市', '511700', '大竹县', '511724');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1704402889f8476650de01476666acbf', '四川省', '510000', '达州市', '511700', '渠县', '511725');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1705402889f8476650de01476666acbf', '四川省', '510000', '达州市', '511700', '万源市', '511781');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1706402889f8476650de01476666acbf', '四川省', '510000', '雅安市', '511800', '雨城区', '511802');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1707402889f8476650de01476666acbf', '四川省', '510000', '雅安市', '511800', '名山区', '511803');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1708402889f8476650de01476666acbf', '四川省', '510000', '雅安市', '511800', '荥经县', '511822');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1709402889f8476650de01476666acbf', '四川省', '510000', '雅安市', '511800', '汉源县', '511823');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1710402889f8476650de01476666acbf', '四川省', '510000', '雅安市', '511800', '石棉县', '511824');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1711402889f8476650de01476666acbf', '四川省', '510000', '雅安市', '511800', '天全县', '511825');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1712402889f8476650de01476666acbf', '四川省', '510000', '雅安市', '511800', '芦山县', '511826');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1713402889f8476650de01476666acbf', '四川省', '510000', '雅安市', '511800', '宝兴县', '511827');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1714402889f8476650de01476666acbf', '四川省', '510000', '巴中市', '511900', '巴州区', '511902');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1715402889f8476650de01476666acbf', '四川省', '510000', '巴中市', '511900', '通江县', '511921');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1716402889f8476650de01476666acbf', '四川省', '510000', '巴中市', '511900', '南江县', '511922');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1717402889f8476650de01476666acbf', '四川省', '510000', '巴中市', '511900', '平昌县', '511923');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1718402889f8476650de01476666acbf', '四川省', '510000', '资阳市', '512000', '雁江区', '512002');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1719402889f8476650de01476666acbf', '四川省', '510000', '资阳市', '512000', '安岳县', '512021');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1720402889f8476650de01476666acbf', '四川省', '510000', '资阳市', '512000', '乐至县', '512022');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1721402889f8476650de01476666acbf', '四川省', '510000', '资阳市', '512000', '简阳市', '512081');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1722402889f8476650de01476666acbf', '四川省', '510000', '阿坝藏族羌族自治州', '512100', '汶川县', '513221');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1723402889f8476650de01476666acbf', '四川省', '510000', '阿坝藏族羌族自治州', '512100', '理县', '513222');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1724402889f8476650de01476666acbf', '四川省', '510000', '阿坝藏族羌族自治州', '512100', '茂县', '513223');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1725402889f8476650de01476666acbf', '四川省', '510000', '阿坝藏族羌族自治州', '512100', '松潘县', '513224');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1726402889f8476650de01476666acbf', '四川省', '510000', '阿坝藏族羌族自治州', '512100', '九寨沟县', '513225');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1727402889f8476650de01476666acbf', '四川省', '510000', '阿坝藏族羌族自治州', '512100', '金川县', '513226');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1728402889f8476650de01476666acbf', '四川省', '510000', '阿坝藏族羌族自治州', '512100', '小金县', '513227');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1729402889f8476650de01476666acbf', '四川省', '510000', '阿坝藏族羌族自治州', '512100', '黑水县', '513228');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1730402889f8476650de01476666acbf', '四川省', '510000', '阿坝藏族羌族自治州', '512100', '马尔康县', '513229');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1731402889f8476650de01476666acbf', '四川省', '510000', '阿坝藏族羌族自治州', '512100', '壤塘县', '513230');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1732402889f8476650de01476666acbf', '四川省', '510000', '阿坝藏族羌族自治州', '512100', '阿坝县', '513231');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1733402889f8476650de01476666acbf', '四川省', '510000', '阿坝藏族羌族自治州', '512100', '若尔盖县', '513232');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1734402889f8476650de01476666acbf', '四川省', '510000', '阿坝藏族羌族自治州', '512100', '红原县', '513233');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1735402889f8476650de01476666acbf', '四川省', '510000', '甘孜藏族自治州', '512200', '康定县', '513321');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1736402889f8476650de01476666acbf', '四川省', '510000', '甘孜藏族自治州', '512200', '泸定县', '513322');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1737402889f8476650de01476666acbf', '四川省', '510000', '甘孜藏族自治州', '512200', '丹巴县', '513323');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1738402889f8476650de01476666acbf', '四川省', '510000', '甘孜藏族自治州', '512200', '九龙县', '513324');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1739402889f8476650de01476666acbf', '四川省', '510000', '甘孜藏族自治州', '512200', '雅江县', '513325');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1740402889f8476650de01476666acbf', '四川省', '510000', '甘孜藏族自治州', '512200', '道孚县', '513326');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1741402889f8476650de01476666acbf', '四川省', '510000', '甘孜藏族自治州', '512200', '炉霍县', '513327');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1742402889f8476650de01476666acbf', '四川省', '510000', '甘孜藏族自治州', '512200', '甘孜县', '513328');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1743402889f8476650de01476666acbf', '四川省', '510000', '甘孜藏族自治州', '512200', '新龙县', '513329');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1744402889f8476650de01476666acbf', '四川省', '510000', '甘孜藏族自治州', '512200', '德格县', '513330');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1745402889f8476650de01476666acbf', '四川省', '510000', '甘孜藏族自治州', '512200', '白玉县', '513331');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1746402889f8476650de01476666acbf', '四川省', '510000', '甘孜藏族自治州', '512200', '石渠县', '513332');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1747402889f8476650de01476666acbf', '四川省', '510000', '甘孜藏族自治州', '512200', '色达县', '513333');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1748402889f8476650de01476666acbf', '四川省', '510000', '甘孜藏族自治州', '512200', '理塘县', '513334');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1749402889f8476650de01476666acbf', '四川省', '510000', '甘孜藏族自治州', '512200', '巴塘县', '513335');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1750402889f8476650de01476666acbf', '四川省', '510000', '甘孜藏族自治州', '512200', '乡城县', '513336');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1751402889f8476650de01476666acbf', '四川省', '510000', '甘孜藏族自治州', '512200', '稻城县', '513337');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1752402889f8476650de01476666acbf', '四川省', '510000', '甘孜藏族自治州', '512200', '得荣县', '513338');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1753402889f8476650de01476666acbf', '四川省', '510000', '凉山彝族自治州', '512300', '西昌市', '513401');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1754402889f8476650de01476666acbf', '四川省', '510000', '凉山彝族自治州', '512300', '木里藏族自治县', '513422');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1755402889f8476650de01476666acbf', '四川省', '510000', '凉山彝族自治州', '512300', '盐源县', '513423');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1756402889f8476650de01476666acbf', '四川省', '510000', '凉山彝族自治州', '512300', '德昌县', '513424');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1757402889f8476650de01476666acbf', '四川省', '510000', '凉山彝族自治州', '512300', '会理县', '513425');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1758402889f8476650de01476666acbf', '四川省', '510000', '凉山彝族自治州', '512300', '会东县', '513426');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1759402889f8476650de01476666acbf', '四川省', '510000', '凉山彝族自治州', '512300', '宁南县', '513427');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1760402889f8476650de01476666acbf', '四川省', '510000', '凉山彝族自治州', '512300', '普格县', '513428');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1761402889f8476650de01476666acbf', '四川省', '510000', '凉山彝族自治州', '512300', '布拖县', '513429');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1762402889f8476650de01476666acbf', '四川省', '510000', '凉山彝族自治州', '512300', '金阳县', '513430');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1763402889f8476650de01476666acbf', '四川省', '510000', '凉山彝族自治州', '512300', '昭觉县', '513431');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1764402889f8476650de01476666acbf', '四川省', '510000', '凉山彝族自治州', '512300', '喜德县', '513432');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1765402889f8476650de01476666acbf', '四川省', '510000', '凉山彝族自治州', '512300', '冕宁县', '513433');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1766402889f8476650de01476666acbf', '四川省', '510000', '凉山彝族自治州', '512300', '越西县', '513434');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1767402889f8476650de01476666acbf', '四川省', '510000', '凉山彝族自治州', '512300', '甘洛县', '513435');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1768402889f8476650de01476666acbf', '四川省', '510000', '凉山彝族自治州', '512300', '美姑县', '513436');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1769402889f8476650de01476666acbf', '四川省', '510000', '凉山彝族自治州', '512300', '雷波县', '513437');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1770402889f8476650de01476666acbf', '贵州省', '520000', '贵阳市', '520100', '南明区', '520102');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1771402889f8476650de01476666acbf', '贵州省', '520000', '贵阳市', '520100', '云岩区', '520103');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1772402889f8476650de01476666acbf', '贵州省', '520000', '贵阳市', '520100', '花溪区', '520111');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1773402889f8476650de01476666acbf', '贵州省', '520000', '贵阳市', '520100', '乌当区', '520112');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1774402889f8476650de01476666acbf', '贵州省', '520000', '贵阳市', '520100', '白云区', '520113');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1775402889f8476650de01476666acbf', '贵州省', '520000', '贵阳市', '520100', '小河区', '520114');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1776402889f8476650de01476666acbf', '贵州省', '520000', '贵阳市', '520100', '开阳县', '520121');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('515402889f8476650de01476666acbf0', '贵州省', '520000', '贵阳市', '520100', '息烽县', '520122');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('516402889f8476650de01476666acbf0', '贵州省', '520000', '贵阳市', '520100', '修文县', '520123');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('517402889f8476650de01476666acbf0', '贵州省', '520000', '贵阳市', '520100', '清镇市', '520181');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('518402889f8476650de01476666acbf0', '贵州省', '520000', '六盘水市', '520200', '钟山区', '520201');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('519402889f8476650de01476666acbf0', '贵州省', '520000', '六盘水市', '520200', '六枝特区', '520203');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('520402889f8476650de01476666acbf0', '贵州省', '520000', '六盘水市', '520200', '水城县', '520221');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('521402889f8476650de01476666acbf0', '贵州省', '520000', '六盘水市', '520200', '盘县', '520222');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('522402889f8476650de01476666acbf0', '贵州省', '520000', '遵义市', '520300', '红花岗区', '520302');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('523402889f8476650de01476666acbf0', '贵州省', '520000', '遵义市', '520300', '汇川区', '520303');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('524402889f8476650de01476666acbf0', '贵州省', '520000', '遵义市', '520300', '遵义县', '520321');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('525402889f8476650de01476666acbf0', '贵州省', '520000', '遵义市', '520300', '桐梓县', '520322');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('526402889f8476650de01476666acbf0', '贵州省', '520000', '遵义市', '520300', '绥阳县', '520323');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('527402889f8476650de01476666acbf0', '贵州省', '520000', '遵义市', '520300', '正安县', '520324');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('528402889f8476650de01476666acbf0', '贵州省', '520000', '遵义市', '520300', '道真仡佬族苗族自治县', '520325');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('529402889f8476650de01476666acbf0', '贵州省', '520000', '遵义市', '520300', '务川仡佬族苗族自治县', '520326');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('530402889f8476650de01476666acbf0', '贵州省', '520000', '遵义市', '520300', '凤冈县', '520327');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('531402889f8476650de01476666acbf0', '贵州省', '520000', '遵义市', '520300', '湄潭县', '520328');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('532402889f8476650de01476666acbf0', '贵州省', '520000', '遵义市', '520300', '余庆县', '520329');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('533402889f8476650de01476666acbf0', '贵州省', '520000', '遵义市', '520300', '习水县', '520330');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('534402889f8476650de01476666acbf0', '贵州省', '520000', '遵义市', '520300', '赤水市', '520381');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('535402889f8476650de01476666acbf0', '贵州省', '520000', '遵义市', '520300', '仁怀市', '520382');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('536402889f8476650de01476666acbf0', '贵州省', '520000', '安顺市', '520400', '西秀区', '520402');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('537402889f8476650de01476666acbf0', '贵州省', '520000', '安顺市', '520400', '平坝县', '520421');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('538402889f8476650de01476666acbf0', '贵州省', '520000', '安顺市', '520400', '普定县', '520422');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('539402889f8476650de01476666acbf0', '贵州省', '520000', '安顺市', '520400', '镇宁布依族苗族自治县', '520423');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('540402889f8476650de01476666acbf0', '贵州省', '520000', '安顺市', '520400', '关岭布依族苗族自治县', '520424');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('541402889f8476650de01476666acbf0', '贵州省', '520000', '安顺市', '520400', '紫云苗族布依族自治县', '520425');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('542402889f8476650de01476666acbf0', '贵州省', '520000', '毕节市', '520500', '七星关区', '520502');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('543402889f8476650de01476666acbf0', '贵州省', '520000', '毕节市', '520500', '大方县', '520521');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('544402889f8476650de01476666acbf0', '贵州省', '520000', '毕节市', '520500', '黔西县', '520522');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('545402889f8476650de01476666acbf0', '贵州省', '520000', '毕节市', '520500', '金沙县', '520523');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('546402889f8476650de01476666acbf0', '贵州省', '520000', '毕节市', '520500', '织金县', '520524');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('547402889f8476650de01476666acbf0', '贵州省', '520000', '毕节市', '520500', '纳雍县', '520525');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('548402889f8476650de01476666acbf0', '贵州省', '520000', '毕节市', '520500', '威宁彝族回族苗族自治县', '520526');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('549402889f8476650de01476666acbf0', '贵州省', '520000', '毕节市', '520500', '赫章县', '520527');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('550402889f8476650de01476666acbf0', '贵州省', '520000', '铜仁市', '520600', '碧江区', '520602');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('551402889f8476650de01476666acbf0', '贵州省', '520000', '铜仁市', '520600', '万山区', '520603');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('552402889f8476650de01476666acbf0', '贵州省', '520000', '铜仁市', '520600', '江口县', '520621');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('553402889f8476650de01476666acbf0', '贵州省', '520000', '铜仁市', '520600', '玉屏侗族自治县', '520622');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('554402889f8476650de01476666acbf0', '贵州省', '520000', '铜仁市', '520600', '石阡县', '520623');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('555402889f8476650de01476666acbf0', '贵州省', '520000', '铜仁市', '520600', '思南县', '520624');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('556402889f8476650de01476666acbf0', '贵州省', '520000', '铜仁市', '520600', '印江土家族苗族自治县', '520625');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('557402889f8476650de01476666acbf0', '贵州省', '520000', '铜仁市', '520600', '德江县', '520626');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('558402889f8476650de01476666acbf0', '贵州省', '520000', '铜仁市', '520600', '沿河土家族自治县', '520627');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('559402889f8476650de01476666acbf0', '贵州省', '520000', '铜仁市', '520600', '松桃苗族自治县', '520628');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('560402889f8476650de01476666acbf0', '贵州省', '520000', '黔西南布依族苗族自治州', '520700', '兴义市', '522301');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('561402889f8476650de01476666acbf0', '贵州省', '520000', '黔西南布依族苗族自治州', '520700', '兴仁县', '522322');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('562402889f8476650de01476666acbf0', '贵州省', '520000', '黔西南布依族苗族自治州', '520700', '普安县', '522323');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('563402889f8476650de01476666acbf0', '贵州省', '520000', '黔西南布依族苗族自治州', '520700', '晴隆县', '522324');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('564402889f8476650de01476666acbf0', '贵州省', '520000', '黔西南布依族苗族自治州', '520700', '贞丰县', '522325');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('565402889f8476650de01476666acbf0', '贵州省', '520000', '黔西南布依族苗族自治州', '520700', '望谟县', '522326');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('566402889f8476650de01476666acbf0', '贵州省', '520000', '黔西南布依族苗族自治州', '520700', '册亨县', '522327');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('567402889f8476650de01476666acbf0', '贵州省', '520000', '黔西南布依族苗族自治州', '520700', '安龙县', '522328');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('568402889f8476650de01476666acbf0', '贵州省', '520000', '黔东南苗族侗族自治州', '520800', '凯里市', '522601');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('569402889f8476650de01476666acbf0', '贵州省', '520000', '黔东南苗族侗族自治州', '520800', '黄平县', '522622');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('570402889f8476650de01476666acbf0', '贵州省', '520000', '黔东南苗族侗族自治州', '520800', '施秉县', '522623');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('571402889f8476650de01476666acbf0', '贵州省', '520000', '黔东南苗族侗族自治州', '520800', '三穗县', '522624');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('572402889f8476650de01476666acbf0', '贵州省', '520000', '黔东南苗族侗族自治州', '520800', '镇远县', '522625');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('573402889f8476650de01476666acbf0', '贵州省', '520000', '黔东南苗族侗族自治州', '520800', '岑巩县', '522626');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('574402889f8476650de01476666acbf0', '贵州省', '520000', '黔东南苗族侗族自治州', '520800', '天柱县', '522627');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('575402889f8476650de01476666acbf0', '贵州省', '520000', '黔东南苗族侗族自治州', '520800', '锦屏县', '522628');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('576402889f8476650de01476666acbf0', '贵州省', '520000', '黔东南苗族侗族自治州', '520800', '剑河县', '522629');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('577402889f8476650de01476666acbf0', '贵州省', '520000', '黔东南苗族侗族自治州', '520800', '台江县', '522630');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('578402889f8476650de01476666acbf0', '贵州省', '520000', '黔东南苗族侗族自治州', '520800', '黎平县', '522631');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('579402889f8476650de01476666acbf0', '贵州省', '520000', '黔东南苗族侗族自治州', '520800', '榕江县', '522632');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('580402889f8476650de01476666acbf0', '贵州省', '520000', '黔东南苗族侗族自治州', '520800', '从江县', '522633');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('581402889f8476650de01476666acbf0', '贵州省', '520000', '黔东南苗族侗族自治州', '520800', '雷山县', '522634');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('582402889f8476650de01476666acbf0', '贵州省', '520000', '黔东南苗族侗族自治州', '520800', '麻江县', '522635');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('583402889f8476650de01476666acbf0', '贵州省', '520000', '黔东南苗族侗族自治州', '520800', '丹寨县', '522636');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('584402889f8476650de01476666acbf0', '贵州省', '520000', '黔东南苗族侗族自治州', '520800', '都匀市', '522701');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('585402889f8476650de01476666acbf0', '贵州省', '520000', '黔东南苗族侗族自治州', '520800', '福泉市', '522702');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('586402889f8476650de01476666acbf0', '贵州省', '520000', '黔东南苗族侗族自治州', '520800', '荔波县', '522722');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('587402889f8476650de01476666acbf0', '贵州省', '520000', '黔东南苗族侗族自治州', '520800', '贵定县', '522723');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('588402889f8476650de01476666acbf0', '贵州省', '520000', '黔东南苗族侗族自治州', '520800', '瓮安县', '522725');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('589402889f8476650de01476666acbf0', '贵州省', '520000', '黔东南苗族侗族自治州', '520800', '独山县', '522726');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('590402889f8476650de01476666acbf0', '贵州省', '520000', '黔东南苗族侗族自治州', '520800', '平塘县', '522727');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('591402889f8476650de01476666acbf0', '贵州省', '520000', '黔东南苗族侗族自治州', '520800', '罗甸县', '522728');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('592402889f8476650de01476666acbf0', '贵州省', '520000', '黔东南苗族侗族自治州', '520800', '长顺县', '522729');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('593402889f8476650de01476666acbf0', '贵州省', '520000', '黔东南苗族侗族自治州', '520800', '龙里县', '522730');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('594402889f8476650de01476666acbf0', '贵州省', '520000', '黔东南苗族侗族自治州', '520800', '惠水县', '522731');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('595402889f8476650de01476666acbf0', '贵州省', '520000', '黔东南苗族侗族自治州', '520800', '三都水族自治县', '522732');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('596402889f8476650de01476666acbf0', '云南省', '530000', '昆明市', '530100', '五华区', '530102');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('597402889f8476650de01476666acbf0', '云南省', '530000', '昆明市', '530100', '盘龙区', '530103');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('598402889f8476650de01476666acbf0', '云南省', '530000', '昆明市', '530100', '官渡区', '530111');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('599402889f8476650de01476666acbf0', '云南省', '530000', '昆明市', '530100', '西山区', '530112');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('600402889f8476650de01476666acbf0', '云南省', '530000', '昆明市', '530100', '东川区', '530113');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('601402889f8476650de01476666acbf0', '云南省', '530000', '昆明市', '530100', '呈贡区', '530114');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('602402889f8476650de01476666acbf0', '云南省', '530000', '昆明市', '530100', '晋宁县', '530122');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('603402889f8476650de01476666acbf0', '云南省', '530000', '昆明市', '530100', '富民县', '530124');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('604402889f8476650de01476666acbf0', '云南省', '530000', '昆明市', '530100', '宜良县', '530125');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('605402889f8476650de01476666acbf0', '云南省', '530000', '昆明市', '530100', '石林彝族自治县', '530126');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('606402889f8476650de01476666acbf0', '云南省', '530000', '昆明市', '530100', '嵩明县', '530127');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('607402889f8476650de01476666acbf0', '云南省', '530000', '昆明市', '530100', '禄劝彝族苗族自治县', '530128');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('608402889f8476650de01476666acbf0', '云南省', '530000', '昆明市', '530100', '寻甸回族彝族自治县', '530129');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('609402889f8476650de01476666acbf0', '云南省', '530000', '昆明市', '530100', '安宁市', '530181');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('610402889f8476650de01476666acbf0', '云南省', '530000', '曲靖市', '530300', '麒麟区', '530302');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('611402889f8476650de01476666acbf0', '云南省', '530000', '曲靖市', '530300', '马龙县', '530321');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('612402889f8476650de01476666acbf0', '云南省', '530000', '曲靖市', '530300', '陆良县', '530322');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('613402889f8476650de01476666acbf0', '云南省', '530000', '曲靖市', '530300', '师宗县', '530323');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('614402889f8476650de01476666acbf0', '云南省', '530000', '曲靖市', '530300', '罗平县', '530324');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('615402889f8476650de01476666acbf0', '云南省', '530000', '曲靖市', '530300', '富源县', '530325');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('616402889f8476650de01476666acbf0', '云南省', '530000', '曲靖市', '530300', '会泽县', '530326');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('617402889f8476650de01476666acbf0', '云南省', '530000', '曲靖市', '530300', '沾益县', '530328');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('618402889f8476650de01476666acbf0', '云南省', '530000', '曲靖市', '530300', '宣威市', '530381');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('619402889f8476650de01476666acbf0', '云南省', '530000', '玉溪市', '530400', '红塔区', '530402');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('620402889f8476650de01476666acbf0', '云南省', '530000', '玉溪市', '530400', '江川县', '530421');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('621402889f8476650de01476666acbf0', '云南省', '530000', '玉溪市', '530400', '澄江县', '530422');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('622402889f8476650de01476666acbf0', '云南省', '530000', '玉溪市', '530400', '通海县', '530423');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('623402889f8476650de01476666acbf0', '云南省', '530000', '玉溪市', '530400', '华宁县', '530424');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('624402889f8476650de01476666acbf0', '云南省', '530000', '玉溪市', '530400', '易门县', '530425');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('625402889f8476650de01476666acbf0', '云南省', '530000', '玉溪市', '530400', '峨山彝族自治县', '530426');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('626402889f8476650de01476666acbf0', '云南省', '530000', '玉溪市', '530400', '新平彝族傣族自治县', '530427');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('627402889f8476650de01476666acbf0', '云南省', '530000', '玉溪市', '530400', '元江哈尼族彝族傣族自治县', '530428');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('628402889f8476650de01476666acbf0', '云南省', '530000', '保山市', '530500', '隆阳区', '530502');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('629402889f8476650de01476666acbf0', '云南省', '530000', '保山市', '530500', '施甸县', '530521');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('630402889f8476650de01476666acbf0', '云南省', '530000', '保山市', '530500', '腾冲县', '530522');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('631402889f8476650de01476666acbf0', '云南省', '530000', '保山市', '530500', '龙陵县', '530523');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('632402889f8476650de01476666acbf0', '云南省', '530000', '保山市', '530500', '昌宁县', '530524');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('633402889f8476650de01476666acbf0', '云南省', '530000', '昭通市', '530600', '昭阳区', '530602');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('634402889f8476650de01476666acbf0', '云南省', '530000', '昭通市', '530600', '鲁甸县', '530621');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('635402889f8476650de01476666acbf0', '云南省', '530000', '昭通市', '530600', '巧家县', '530622');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('636402889f8476650de01476666acbf0', '云南省', '530000', '昭通市', '530600', '盐津县', '530623');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('637402889f8476650de01476666acbf0', '云南省', '530000', '昭通市', '530600', '大关县', '530624');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('638402889f8476650de01476666acbf0', '云南省', '530000', '昭通市', '530600', '永善县', '530625');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('639402889f8476650de01476666acbf0', '云南省', '530000', '昭通市', '530600', '绥江县', '530626');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('640402889f8476650de01476666acbf0', '云南省', '530000', '昭通市', '530600', '镇雄县', '530627');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('641402889f8476650de01476666acbf0', '云南省', '530000', '昭通市', '530600', '彝良县', '530628');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('642402889f8476650de01476666acbf0', '云南省', '530000', '昭通市', '530600', '威信县', '530629');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('643402889f8476650de01476666acbf0', '云南省', '530000', '昭通市', '530600', '水富县', '530630');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('644402889f8476650de01476666acbf0', '云南省', '530000', '丽江市', '530700', '古城区', '530702');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('645402889f8476650de01476666acbf0', '云南省', '530000', '丽江市', '530700', '玉龙纳西族自治县', '530721');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('646402889f8476650de01476666acbf0', '云南省', '530000', '丽江市', '530700', '永胜县', '530722');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('647402889f8476650de01476666acbf0', '云南省', '530000', '丽江市', '530700', '华坪县', '530723');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('648402889f8476650de01476666acbf0', '云南省', '530000', '丽江市', '530700', '宁蒗彝族自治县', '530724');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('649402889f8476650de01476666acbf0', '云南省', '530000', '普洱市', '530800', '思茅区', '530802');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('650402889f8476650de01476666acbf0', '云南省', '530000', '普洱市', '530800', '宁洱哈尼族彝族自治县', '530821');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('651402889f8476650de01476666acbf0', '云南省', '530000', '普洱市', '530800', '墨江哈尼族自治县', '530822');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('652402889f8476650de01476666acbf0', '云南省', '530000', '普洱市', '530800', '景东彝族自治县', '530823');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('653402889f8476650de01476666acbf0', '云南省', '530000', '普洱市', '530800', '景谷傣族彝族自治县', '530824');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('654402889f8476650de01476666acbf0', '云南省', '530000', '普洱市', '530800', '镇沅彝族哈尼族拉祜族自治县', '530825');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('655402889f8476650de01476666acbf0', '云南省', '530000', '普洱市', '530800', '江城哈尼族彝族自治县', '530826');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('656402889f8476650de01476666acbf0', '云南省', '530000', '普洱市', '530800', '孟连傣族拉祜族佤族自治县', '530827');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('657402889f8476650de01476666acbf0', '云南省', '530000', '普洱市', '530800', '澜沧拉祜族自治县', '530828');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('658402889f8476650de01476666acbf0', '云南省', '530000', '普洱市', '530800', '西盟佤族自治县', '530829');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('659402889f8476650de01476666acbf0', '云南省', '530000', '临沧市', '530900', '临翔区', '530902');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('660402889f8476650de01476666acbf0', '云南省', '530000', '临沧市', '530900', '凤庆县', '530921');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('661402889f8476650de01476666acbf0', '云南省', '530000', '临沧市', '530900', '云县', '530922');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('662402889f8476650de01476666acbf0', '云南省', '530000', '临沧市', '530900', '永德县', '530923');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('663402889f8476650de01476666acbf0', '云南省', '530000', '临沧市', '530900', '镇康县', '530924');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('664402889f8476650de01476666acbf0', '云南省', '530000', '临沧市', '530900', '双江拉祜族佤族布朗族傣族自治县', '530925');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('665402889f8476650de01476666acbf0', '云南省', '530000', '临沧市', '530900', '耿马傣族佤族自治县', '530926');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('666402889f8476650de01476666acbf0', '云南省', '530000', '临沧市', '530900', '沧源佤族自治县', '530927');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('667402889f8476650de01476666acbf0', '云南省', '530000', '楚雄彝族自治州', '531000', '楚雄市', '532301');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('668402889f8476650de01476666acbf0', '云南省', '530000', '楚雄彝族自治州', '531000', '双柏县', '532322');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('669402889f8476650de01476666acbf0', '云南省', '530000', '楚雄彝族自治州', '531000', '牟定县', '532323');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('670402889f8476650de01476666acbf0', '云南省', '530000', '楚雄彝族自治州', '531000', '南华县', '532324');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('671402889f8476650de01476666acbf0', '云南省', '530000', '楚雄彝族自治州', '531000', '姚安县', '532325');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('672402889f8476650de01476666acbf0', '云南省', '530000', '楚雄彝族自治州', '531000', '大姚县', '532326');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('673402889f8476650de01476666acbf0', '云南省', '530000', '楚雄彝族自治州', '531000', '永仁县', '532327');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('674402889f8476650de01476666acbf0', '云南省', '530000', '楚雄彝族自治州', '531000', '元谋县', '532328');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('675402889f8476650de01476666acbf0', '云南省', '530000', '楚雄彝族自治州', '531000', '武定县', '532329');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('676402889f8476650de01476666acbf0', '云南省', '530000', '楚雄彝族自治州', '531000', '禄丰县', '532331');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('677402889f8476650de01476666acbf0', '云南省', '530000', '红河哈尼族彝族自治州', '531100', '个旧市', '532501');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('678402889f8476650de01476666acbf0', '云南省', '530000', '红河哈尼族彝族自治州', '531100', '开远市', '532502');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('679402889f8476650de01476666acbf0', '云南省', '530000', '红河哈尼族彝族自治州', '531100', '蒙自市', '532503');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('680402889f8476650de01476666acbf0', '云南省', '530000', '红河哈尼族彝族自治州', '531100', '屏边苗族自治县', '532523');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('681402889f8476650de01476666acbf0', '云南省', '530000', '红河哈尼族彝族自治州', '531100', '建水县', '532524');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('682402889f8476650de01476666acbf0', '云南省', '530000', '红河哈尼族彝族自治州', '531100', '石屏县', '532525');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('683402889f8476650de01476666acbf0', '云南省', '530000', '红河哈尼族彝族自治州', '531100', '弥勒县', '532526');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('684402889f8476650de01476666acbf0', '云南省', '530000', '红河哈尼族彝族自治州', '531100', '泸西县', '532527');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('685402889f8476650de01476666acbf0', '云南省', '530000', '红河哈尼族彝族自治州', '531100', '元阳县', '532528');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('686402889f8476650de01476666acbf0', '云南省', '530000', '红河哈尼族彝族自治州', '531100', '红河县', '532529');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('687402889f8476650de01476666acbf0', '云南省', '530000', '红河哈尼族彝族自治州', '531100', '金平苗族瑶族傣族自治县', '532530');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('688402889f8476650de01476666acbf0', '云南省', '530000', '红河哈尼族彝族自治州', '531100', '绿春县', '532531');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('689402889f8476650de01476666acbf0', '云南省', '530000', '红河哈尼族彝族自治州', '531100', '河口瑶族自治县', '532532');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('690402889f8476650de01476666acbf0', '云南省', '530000', '文山壮族苗族自治州', '531200', '文山市', '532601');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('691402889f8476650de01476666acbf0', '云南省', '530000', '文山壮族苗族自治州', '531200', '砚山县', '532622');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('692402889f8476650de01476666acbf0', '云南省', '530000', '文山壮族苗族自治州', '531200', '西畴县', '532623');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('693402889f8476650de01476666acbf0', '云南省', '530000', '文山壮族苗族自治州', '531200', '麻栗坡县', '532624');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('694402889f8476650de01476666acbf0', '云南省', '530000', '文山壮族苗族自治州', '531200', '马关县', '532625');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('695402889f8476650de01476666acbf0', '云南省', '530000', '文山壮族苗族自治州', '531200', '丘北县', '532626');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('696402889f8476650de01476666acbf0', '云南省', '530000', '文山壮族苗族自治州', '531200', '广南县', '532627');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('697402889f8476650de01476666acbf0', '云南省', '530000', '文山壮族苗族自治州', '531200', '富宁县', '532628');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('698402889f8476650de01476666acbf0', '云南省', '530000', '西双版纳傣族自治州', '531300', '景洪市', '532801');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('699402889f8476650de01476666acbf0', '云南省', '530000', '西双版纳傣族自治州', '531300', '勐海县', '532822');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('700402889f8476650de01476666acbf0', '云南省', '530000', '西双版纳傣族自治州', '531300', '勐腊县', '532823');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('701402889f8476650de01476666acbf0', '云南省', '530000', '大理白族自治州', '531400', '大理市', '532901');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('702402889f8476650de01476666acbf0', '云南省', '530000', '大理白族自治州', '531400', '漾濞彝族自治县', '532922');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('703402889f8476650de01476666acbf0', '云南省', '530000', '大理白族自治州', '531400', '祥云县', '532923');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('704402889f8476650de01476666acbf0', '云南省', '530000', '大理白族自治州', '531400', '宾川县', '532924');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('705402889f8476650de01476666acbf0', '云南省', '530000', '大理白族自治州', '531400', '弥渡县', '532925');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('706402889f8476650de01476666acbf0', '云南省', '530000', '大理白族自治州', '531400', '南涧彝族自治县', '532926');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('707402889f8476650de01476666acbf0', '云南省', '530000', '大理白族自治州', '531400', '巍山彝族回族自治县', '532927');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('708402889f8476650de01476666acbf0', '云南省', '530000', '大理白族自治州', '531400', '永平县', '532928');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('709402889f8476650de01476666acbf0', '云南省', '530000', '大理白族自治州', '531400', '云龙县', '532929');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('710402889f8476650de01476666acbf0', '云南省', '530000', '大理白族自治州', '531400', '洱源县', '532930');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('711402889f8476650de01476666acbf0', '云南省', '530000', '大理白族自治州', '531400', '剑川县', '532931');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('712402889f8476650de01476666acbf0', '云南省', '530000', '大理白族自治州', '531400', '鹤庆县', '532932');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('713402889f8476650de01476666acbf0', '云南省', '530000', '德宏傣族景颇族自治州', '531500', '瑞丽市', '533102');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('714402889f8476650de01476666acbf0', '云南省', '530000', '德宏傣族景颇族自治州', '531500', '芒市', '533103');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('715402889f8476650de01476666acbf0', '云南省', '530000', '德宏傣族景颇族自治州', '531500', '梁河县', '533122');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('716402889f8476650de01476666acbf0', '云南省', '530000', '德宏傣族景颇族自治州', '531500', '盈江县', '533123');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('717402889f8476650de01476666acbf0', '云南省', '530000', '德宏傣族景颇族自治州', '531500', '陇川县', '533124');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('718402889f8476650de01476666acbf0', '云南省', '530000', '怒江傈僳族自治州', '531600', '泸水县', '533321');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('719402889f8476650de01476666acbf0', '云南省', '530000', '怒江傈僳族自治州', '531600', '福贡县', '533323');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('720402889f8476650de01476666acbf0', '云南省', '530000', '怒江傈僳族自治州', '531600', '贡山独龙族怒族自治县', '533324');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('721402889f8476650de01476666acbf0', '云南省', '530000', '怒江傈僳族自治州', '531600', '兰坪白族普米族自治县', '533325');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('722402889f8476650de01476666acbf0', '云南省', '530000', '迪庆藏族自治州', '531700', '香格里拉县', '533421');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('723402889f8476650de01476666acbf0', '云南省', '530000', '迪庆藏族自治州', '531700', '德钦县', '533422');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('724402889f8476650de01476666acbf0', '云南省', '530000', '迪庆藏族自治州', '531700', '维西傈僳族自治县', '533423');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('725402889f8476650de01476666acbf0', '西藏自治区', '540000', '拉萨市', '540100', '城关区', '540102');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('726402889f8476650de01476666acbf0', '西藏自治区', '540000', '拉萨市', '540100', '林周县', '540121');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('727402889f8476650de01476666acbf0', '西藏自治区', '540000', '拉萨市', '540100', '当雄县', '540122');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('728402889f8476650de01476666acbf0', '西藏自治区', '540000', '拉萨市', '540100', '尼木县', '540123');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('729402889f8476650de01476666acbf0', '西藏自治区', '540000', '拉萨市', '540100', '曲水县', '540124');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('730402889f8476650de01476666acbf0', '西藏自治区', '540000', '拉萨市', '540100', '堆龙德庆县', '540125');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('731402889f8476650de01476666acbf0', '西藏自治区', '540000', '拉萨市', '540100', '达孜县', '540126');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('732402889f8476650de01476666acbf0', '西藏自治区', '540000', '拉萨市', '540100', '墨竹工卡县', '540127');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('733402889f8476650de01476666acbf0', '西藏自治区', '540000', '昌都地区', '540200', '昌都县', '542121');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('734402889f8476650de01476666acbf0', '西藏自治区', '540000', '昌都地区', '540200', '江达县', '542122');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('735402889f8476650de01476666acbf0', '西藏自治区', '540000', '昌都地区', '540200', '贡觉县', '542123');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('736402889f8476650de01476666acbf0', '西藏自治区', '540000', '昌都地区', '540200', '类乌齐县', '542124');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('737402889f8476650de01476666acbf0', '西藏自治区', '540000', '昌都地区', '540200', '丁青县', '542125');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('738402889f8476650de01476666acbf0', '西藏自治区', '540000', '昌都地区', '540200', '察雅县', '542126');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('739402889f8476650de01476666acbf0', '西藏自治区', '540000', '昌都地区', '540200', '八宿县', '542127');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('740402889f8476650de01476666acbf0', '西藏自治区', '540000', '昌都地区', '540200', '左贡县', '542128');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('741402889f8476650de01476666acbf0', '西藏自治区', '540000', '昌都地区', '540200', '芒康县', '542129');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('742402889f8476650de01476666acbf0', '西藏自治区', '540000', '昌都地区', '540200', '洛隆县', '542132');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('743402889f8476650de01476666acbf0', '西藏自治区', '540000', '昌都地区', '540200', '边坝县', '542133');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('744402889f8476650de01476666acbf0', '西藏自治区', '540000', '山南地区', '540300', '乃东县', '542221');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('745402889f8476650de01476666acbf0', '西藏自治区', '540000', '山南地区', '540300', '扎囊县', '542222');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('746402889f8476650de01476666acbf0', '西藏自治区', '540000', '山南地区', '540300', '贡嘎县', '542223');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('747402889f8476650de01476666acbf0', '西藏自治区', '540000', '山南地区', '540300', '桑日县', '542224');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('748402889f8476650de01476666acbf0', '西藏自治区', '540000', '山南地区', '540300', '琼结县', '542225');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('749402889f8476650de01476666acbf0', '西藏自治区', '540000', '山南地区', '540300', '曲松县', '542226');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('750402889f8476650de01476666acbf0', '西藏自治区', '540000', '山南地区', '540300', '措美县', '542227');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('751402889f8476650de01476666acbf0', '西藏自治区', '540000', '山南地区', '540300', '洛扎县', '542228');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('752402889f8476650de01476666acbf0', '西藏自治区', '540000', '山南地区', '540300', '加查县', '542229');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('753402889f8476650de01476666acbf0', '西藏自治区', '540000', '山南地区', '540300', '隆子县', '542231');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('754402889f8476650de01476666acbf0', '西藏自治区', '540000', '山南地区', '540300', '错那县', '542232');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('755402889f8476650de01476666acbf0', '西藏自治区', '540000', '山南地区', '540300', '浪卡子县', '542233');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('756402889f8476650de01476666acbf0', '西藏自治区', '540000', '日喀则地区', '540400', '日喀则市', '542301');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('757402889f8476650de01476666acbf0', '西藏自治区', '540000', '日喀则地区', '540400', '南木林县', '542322');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('758402889f8476650de01476666acbf0', '西藏自治区', '540000', '日喀则地区', '540400', '江孜县', '542323');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('759402889f8476650de01476666acbf0', '西藏自治区', '540000', '日喀则地区', '540400', '定日县', '542324');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('760402889f8476650de01476666acbf0', '西藏自治区', '540000', '日喀则地区', '540400', '萨迦县', '542325');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('761402889f8476650de01476666acbf0', '西藏自治区', '540000', '日喀则地区', '540400', '拉孜县', '542326');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('762402889f8476650de01476666acbf0', '西藏自治区', '540000', '日喀则地区', '540400', '昂仁县', '542327');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('763402889f8476650de01476666acbf0', '西藏自治区', '540000', '日喀则地区', '540400', '谢通门县', '542328');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('764402889f8476650de01476666acbf0', '西藏自治区', '540000', '日喀则地区', '540400', '白朗县', '542329');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('765402889f8476650de01476666acbf0', '西藏自治区', '540000', '日喀则地区', '540400', '仁布县', '542330');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('766402889f8476650de01476666acbf0', '西藏自治区', '540000', '日喀则地区', '540400', '康马县', '542331');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('767402889f8476650de01476666acbf0', '西藏自治区', '540000', '日喀则地区', '540400', '定结县', '542332');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('768402889f8476650de01476666acbf0', '西藏自治区', '540000', '日喀则地区', '540400', '仲巴县', '542333');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('769402889f8476650de01476666acbf0', '西藏自治区', '540000', '日喀则地区', '540400', '亚东县', '542334');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('770402889f8476650de01476666acbf0', '西藏自治区', '540000', '日喀则地区', '540400', '吉隆县', '542335');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('771402889f8476650de01476666acbf0', '西藏自治区', '540000', '日喀则地区', '540400', '聂拉木县', '542336');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('772402889f8476650de01476666acbf0', '西藏自治区', '540000', '日喀则地区', '540400', '萨嘎县', '542337');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('773402889f8476650de01476666acbf0', '西藏自治区', '540000', '日喀则地区', '540400', '岗巴县', '542338');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('774402889f8476650de01476666acbf0', '西藏自治区', '540000', '那曲地区', '540500', '那曲县', '542421');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('775402889f8476650de01476666acbf0', '西藏自治区', '540000', '那曲地区', '540500', '嘉黎县', '542422');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('776402889f8476650de01476666acbf0', '西藏自治区', '540000', '那曲地区', '540500', '比如县', '542423');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('777402889f8476650de01476666acbf0', '西藏自治区', '540000', '那曲地区', '540500', '聂荣县', '542424');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('778402889f8476650de01476666acbf0', '西藏自治区', '540000', '那曲地区', '540500', '安多县', '542425');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('779402889f8476650de01476666acbf0', '西藏自治区', '540000', '那曲地区', '540500', '申扎县', '542426');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('780402889f8476650de01476666acbf0', '西藏自治区', '540000', '那曲地区', '540500', '索县', '542427');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('781402889f8476650de01476666acbf0', '西藏自治区', '540000', '那曲地区', '540500', '班戈县', '542428');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('782402889f8476650de01476666acbf0', '西藏自治区', '540000', '那曲地区', '540500', '巴青县', '542429');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('783402889f8476650de01476666acbf0', '西藏自治区', '540000', '那曲地区', '540500', '尼玛县', '542430');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('784402889f8476650de01476666acbf0', '西藏自治区', '540000', '那曲地区', '540500', '普兰县', '542521');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('785402889f8476650de01476666acbf0', '西藏自治区', '540000', '那曲地区', '540500', '札达县', '542522');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('786402889f8476650de01476666acbf0', '西藏自治区', '540000', '那曲地区', '540500', '噶尔县', '542523');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('787402889f8476650de01476666acbf0', '西藏自治区', '540000', '那曲地区', '540500', '日土县', '542524');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('788402889f8476650de01476666acbf0', '西藏自治区', '540000', '那曲地区', '540500', '革吉县', '542525');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('789402889f8476650de01476666acbf0', '西藏自治区', '540000', '那曲地区', '540500', '改则县', '542526');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('790402889f8476650de01476666acbf0', '西藏自治区', '540000', '那曲地区', '540500', '措勤县', '542527');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('791402889f8476650de01476666acbf0', '西藏自治区', '540000', '林芝地区', '540600', '林芝县', '542621');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('792402889f8476650de01476666acbf0', '西藏自治区', '540000', '林芝地区', '540600', '工布江达县', '542622');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('793402889f8476650de01476666acbf0', '西藏自治区', '540000', '林芝地区', '540600', '米林县', '542623');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('794402889f8476650de01476666acbf0', '西藏自治区', '540000', '林芝地区', '540600', '墨脱县', '542624');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('795402889f8476650de01476666acbf0', '西藏自治区', '540000', '林芝地区', '540600', '波密县', '542625');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('796402889f8476650de01476666acbf0', '西藏自治区', '540000', '林芝地区', '540600', '察隅县', '542626');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('797402889f8476650de01476666acbf0', '西藏自治区', '540000', '林芝地区', '540600', '朗县', '542627');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('798402889f8476650de01476666acbf0', '陕西省', '610000', '西安市', '610100', '新城区', '610102');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('799402889f8476650de01476666acbf0', '陕西省', '610000', '西安市', '610100', '碑林区', '610103');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('800402889f8476650de01476666acbf0', '陕西省', '610000', '西安市', '610100', '莲湖区', '610104');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('801402889f8476650de01476666acbf0', '陕西省', '610000', '西安市', '610100', '灞桥区', '610111');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('802402889f8476650de01476666acbf0', '陕西省', '610000', '西安市', '610100', '未央区', '610112');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('803402889f8476650de01476666acbf0', '陕西省', '610000', '西安市', '610100', '雁塔区', '610113');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('804402889f8476650de01476666acbf0', '陕西省', '610000', '西安市', '610100', '阎良区', '610114');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('805402889f8476650de01476666acbf0', '陕西省', '610000', '西安市', '610100', '临潼区', '610115');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('806402889f8476650de01476666acbf0', '陕西省', '610000', '西安市', '610100', '长安区', '610116');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('807402889f8476650de01476666acbf0', '陕西省', '610000', '西安市', '610100', '蓝田县', '610122');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('808402889f8476650de01476666acbf0', '陕西省', '610000', '西安市', '610100', '周至县', '610124');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('809402889f8476650de01476666acbf0', '陕西省', '610000', '西安市', '610100', '户县', '610125');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('810402889f8476650de01476666acbf0', '陕西省', '610000', '西安市', '610100', '高陵县', '610126');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('811402889f8476650de01476666acbf0', '陕西省', '610000', '铜川市', '610200', '王益区', '610202');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('812402889f8476650de01476666acbf0', '陕西省', '610000', '铜川市', '610200', '印台区', '610203');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('813402889f8476650de01476666acbf0', '陕西省', '610000', '铜川市', '610200', '耀州区', '610204');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('814402889f8476650de01476666acbf0', '陕西省', '610000', '铜川市', '610200', '宜君县', '610222');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('815402889f8476650de01476666acbf0', '陕西省', '610000', '宝鸡市', '610300', '渭滨区', '610302');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('816402889f8476650de01476666acbf0', '陕西省', '610000', '宝鸡市', '610300', '金台区', '610303');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('817402889f8476650de01476666acbf0', '陕西省', '610000', '宝鸡市', '610300', '陈仓区', '610304');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('818402889f8476650de01476666acbf0', '陕西省', '610000', '宝鸡市', '610300', '凤翔县', '610322');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('819402889f8476650de01476666acbf0', '陕西省', '610000', '宝鸡市', '610300', '岐山县', '610323');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('820402889f8476650de01476666acbf0', '陕西省', '610000', '宝鸡市', '610300', '扶风县', '610324');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('821402889f8476650de01476666acbf0', '陕西省', '610000', '宝鸡市', '610300', '眉县', '610326');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('822402889f8476650de01476666acbf0', '陕西省', '610000', '宝鸡市', '610300', '陇县', '610327');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('823402889f8476650de01476666acbf0', '陕西省', '610000', '宝鸡市', '610300', '千阳县', '610328');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('824402889f8476650de01476666acbf0', '陕西省', '610000', '宝鸡市', '610300', '麟游县', '610329');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('825402889f8476650de01476666acbf0', '陕西省', '610000', '宝鸡市', '610300', '凤县', '610330');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('826402889f8476650de01476666acbf0', '陕西省', '610000', '宝鸡市', '610300', '太白县', '610331');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('827402889f8476650de01476666acbf0', '陕西省', '610000', '咸阳市', '610400', '秦都区', '610402');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('828402889f8476650de01476666acbf0', '陕西省', '610000', '咸阳市', '610400', '杨陵区', '610403');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('829402889f8476650de01476666acbf0', '陕西省', '610000', '咸阳市', '610400', '渭城区', '610404');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('830402889f8476650de01476666acbf0', '陕西省', '610000', '咸阳市', '610400', '三原县', '610422');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('831402889f8476650de01476666acbf0', '陕西省', '610000', '咸阳市', '610400', '泾阳县', '610423');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('832402889f8476650de01476666acbf0', '陕西省', '610000', '咸阳市', '610400', '乾县', '610424');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('833402889f8476650de01476666acbf0', '陕西省', '610000', '咸阳市', '610400', '礼泉县', '610425');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('834402889f8476650de01476666acbf0', '陕西省', '610000', '咸阳市', '610400', '永寿县', '610426');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('835402889f8476650de01476666acbf0', '陕西省', '610000', '咸阳市', '610400', '彬县', '610427');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('836402889f8476650de01476666acbf0', '陕西省', '610000', '咸阳市', '610400', '长武县', '610428');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('837402889f8476650de01476666acbf0', '陕西省', '610000', '咸阳市', '610400', '旬邑县', '610429');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('838402889f8476650de01476666acbf0', '陕西省', '610000', '咸阳市', '610400', '淳化县', '610430');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('839402889f8476650de01476666acbf0', '陕西省', '610000', '咸阳市', '610400', '武功县', '610431');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('840402889f8476650de01476666acbf0', '陕西省', '610000', '咸阳市', '610400', '兴平市', '610481');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('841402889f8476650de01476666acbf0', '陕西省', '610000', '渭南市', '610500', '临渭区', '610502');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('842402889f8476650de01476666acbf0', '陕西省', '610000', '渭南市', '610500', '华县', '610521');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('843402889f8476650de01476666acbf0', '陕西省', '610000', '渭南市', '610500', '潼关县', '610522');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('844402889f8476650de01476666acbf0', '陕西省', '610000', '渭南市', '610500', '大荔县', '610523');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('845402889f8476650de01476666acbf0', '陕西省', '610000', '渭南市', '610500', '合阳县', '610524');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('846402889f8476650de01476666acbf0', '陕西省', '610000', '渭南市', '610500', '澄城县', '610525');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('847402889f8476650de01476666acbf0', '陕西省', '610000', '渭南市', '610500', '蒲城县', '610526');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('848402889f8476650de01476666acbf0', '陕西省', '610000', '渭南市', '610500', '白水县', '610527');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('849402889f8476650de01476666acbf0', '陕西省', '610000', '渭南市', '610500', '富平县', '610528');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('850402889f8476650de01476666acbf0', '陕西省', '610000', '渭南市', '610500', '韩城市', '610581');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('851402889f8476650de01476666acbf0', '陕西省', '610000', '渭南市', '610500', '华阴市', '610582');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('852402889f8476650de01476666acbf0', '陕西省', '610000', '延安市', '610600', '宝塔区', '610602');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('853402889f8476650de01476666acbf0', '陕西省', '610000', '延安市', '610600', '延长县', '610621');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('854402889f8476650de01476666acbf0', '陕西省', '610000', '延安市', '610600', '延川县', '610622');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('855402889f8476650de01476666acbf0', '陕西省', '610000', '延安市', '610600', '子长县', '610623');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('856402889f8476650de01476666acbf0', '陕西省', '610000', '延安市', '610600', '安塞县', '610624');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('857402889f8476650de01476666acbf0', '陕西省', '610000', '延安市', '610600', '志丹县', '610625');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('858402889f8476650de01476666acbf0', '陕西省', '610000', '延安市', '610600', '吴起县', '610626');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('859402889f8476650de01476666acbf0', '陕西省', '610000', '延安市', '610600', '甘泉县', '610627');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('860402889f8476650de01476666acbf0', '陕西省', '610000', '延安市', '610600', '富县', '610628');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('861402889f8476650de01476666acbf0', '陕西省', '610000', '延安市', '610600', '洛川县', '610629');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('862402889f8476650de01476666acbf0', '陕西省', '610000', '延安市', '610600', '宜川县', '610630');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('863402889f8476650de01476666acbf0', '陕西省', '610000', '延安市', '610600', '黄龙县', '610631');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('864402889f8476650de01476666acbf0', '陕西省', '610000', '延安市', '610600', '黄陵县', '610632');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('865402889f8476650de01476666acbf0', '陕西省', '610000', '汉中市', '610700', '汉台区', '610702');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('866402889f8476650de01476666acbf0', '陕西省', '610000', '汉中市', '610700', '南郑县', '610721');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('867402889f8476650de01476666acbf0', '陕西省', '610000', '汉中市', '610700', '城固县', '610722');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('868402889f8476650de01476666acbf0', '陕西省', '610000', '汉中市', '610700', '洋县', '610723');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('869402889f8476650de01476666acbf0', '陕西省', '610000', '汉中市', '610700', '西乡县', '610724');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('870402889f8476650de01476666acbf0', '陕西省', '610000', '汉中市', '610700', '勉县', '610725');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('871402889f8476650de01476666acbf0', '陕西省', '610000', '汉中市', '610700', '宁强县', '610726');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('872402889f8476650de01476666acbf0', '陕西省', '610000', '汉中市', '610700', '略阳县', '610727');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('873402889f8476650de01476666acbf0', '陕西省', '610000', '汉中市', '610700', '镇巴县', '610728');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('874402889f8476650de01476666acbf0', '陕西省', '610000', '汉中市', '610700', '留坝县', '610729');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('875402889f8476650de01476666acbf0', '陕西省', '610000', '汉中市', '610700', '佛坪县', '610730');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('876402889f8476650de01476666acbf0', '陕西省', '610000', '榆林市', '610800', '榆阳区', '610802');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('877402889f8476650de01476666acbf0', '陕西省', '610000', '榆林市', '610800', '神木县', '610821');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('878402889f8476650de01476666acbf0', '陕西省', '610000', '榆林市', '610800', '府谷县', '610822');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('879402889f8476650de01476666acbf0', '陕西省', '610000', '榆林市', '610800', '横山县', '610823');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('880402889f8476650de01476666acbf0', '陕西省', '610000', '榆林市', '610800', '靖边县', '610824');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('881402889f8476650de01476666acbf0', '陕西省', '610000', '榆林市', '610800', '定边县', '610825');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('882402889f8476650de01476666acbf0', '陕西省', '610000', '榆林市', '610800', '绥德县', '610826');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('883402889f8476650de01476666acbf0', '陕西省', '610000', '榆林市', '610800', '米脂县', '610827');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('884402889f8476650de01476666acbf0', '陕西省', '610000', '榆林市', '610800', '佳县', '610828');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('885402889f8476650de01476666acbf0', '陕西省', '610000', '榆林市', '610800', '吴堡县', '610829');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('886402889f8476650de01476666acbf0', '陕西省', '610000', '榆林市', '610800', '清涧县', '610830');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('887402889f8476650de01476666acbf0', '陕西省', '610000', '榆林市', '610800', '子洲县', '610831');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('888402889f8476650de01476666acbf0', '陕西省', '610000', '安康市', '610900', '汉滨区', '610902');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('889402889f8476650de01476666acbf0', '陕西省', '610000', '安康市', '610900', '汉阴县', '610921');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('890402889f8476650de01476666acbf0', '陕西省', '610000', '安康市', '610900', '石泉县', '610922');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('891402889f8476650de01476666acbf0', '陕西省', '610000', '安康市', '610900', '宁陕县', '610923');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('892402889f8476650de01476666acbf0', '陕西省', '610000', '安康市', '610900', '紫阳县', '610924');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('893402889f8476650de01476666acbf0', '陕西省', '610000', '安康市', '610900', '岚皋县', '610925');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('894402889f8476650de01476666acbf0', '陕西省', '610000', '安康市', '610900', '平利县', '610926');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('895402889f8476650de01476666acbf0', '陕西省', '610000', '安康市', '610900', '镇坪县', '610927');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('896402889f8476650de01476666acbf0', '陕西省', '610000', '安康市', '610900', '旬阳县', '610928');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('897402889f8476650de01476666acbf0', '陕西省', '610000', '安康市', '610900', '白河县', '610929');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('898402889f8476650de01476666acbf0', '陕西省', '610000', '商洛市', '611000', '商州区', '611002');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('899402889f8476650de01476666acbf0', '陕西省', '610000', '商洛市', '611000', '洛南县', '611021');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('900402889f8476650de01476666acbf0', '陕西省', '610000', '商洛市', '611000', '丹凤县', '611022');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('901402889f8476650de01476666acbf0', '陕西省', '610000', '商洛市', '611000', '商南县', '611023');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('902402889f8476650de01476666acbf0', '陕西省', '610000', '商洛市', '611000', '山阳县', '611024');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('903402889f8476650de01476666acbf0', '陕西省', '610000', '商洛市', '611000', '镇安县', '611025');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('904402889f8476650de01476666acbf0', '陕西省', '610000', '商洛市', '611000', '柞水县', '611026');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('905402889f8476650de01476666acbf0', '甘肃省', '620000', '兰州市', '620100', '城关区', '620102');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('906402889f8476650de01476666acbf0', '甘肃省', '620000', '兰州市', '620100', '七里河区', '620103');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('907402889f8476650de01476666acbf0', '甘肃省', '620000', '兰州市', '620100', '西固区', '620104');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('908402889f8476650de01476666acbf0', '甘肃省', '620000', '兰州市', '620100', '安宁区', '620105');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('909402889f8476650de01476666acbf0', '甘肃省', '620000', '兰州市', '620100', '红古区', '620111');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('910402889f8476650de01476666acbf0', '甘肃省', '620000', '兰州市', '620100', '永登县', '620121');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('911402889f8476650de01476666acbf0', '甘肃省', '620000', '兰州市', '620100', '皋兰县', '620122');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('912402889f8476650de01476666acbf0', '甘肃省', '620000', '兰州市', '620100', '榆中县', '620123');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('913402889f8476650de01476666acbf0', '甘肃省', '620000', '嘉峪关市', '620200', '金昌市', '620300');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('914402889f8476650de01476666acbf0', '甘肃省', '620000', '嘉峪关市', '620200', '金川区', '620302');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('915402889f8476650de01476666acbf0', '甘肃省', '620000', '嘉峪关市', '620200', '永昌县', '620321');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('916402889f8476650de01476666acbf0', '甘肃省', '620000', '白银市', '620400', '白银区', '620402');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('917402889f8476650de01476666acbf0', '甘肃省', '620000', '白银市', '620400', '平川区', '620403');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('918402889f8476650de01476666acbf0', '甘肃省', '620000', '白银市', '620400', '靖远县', '620421');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('919402889f8476650de01476666acbf0', '甘肃省', '620000', '白银市', '620400', '会宁县', '620422');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('920402889f8476650de01476666acbf0', '甘肃省', '620000', '白银市', '620400', '景泰县', '620423');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('921402889f8476650de01476666acbf0', '甘肃省', '620000', '天水市', '620500', '秦州区', '620502');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('922402889f8476650de01476666acbf0', '甘肃省', '620000', '天水市', '620500', '麦积区', '620503');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('923402889f8476650de01476666acbf0', '甘肃省', '620000', '天水市', '620500', '清水县', '620521');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('924402889f8476650de01476666acbf0', '甘肃省', '620000', '天水市', '620500', '秦安县', '620522');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('925402889f8476650de01476666acbf0', '甘肃省', '620000', '天水市', '620500', '甘谷县', '620523');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('926402889f8476650de01476666acbf0', '甘肃省', '620000', '天水市', '620500', '武山县', '620524');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('927402889f8476650de01476666acbf0', '甘肃省', '620000', '天水市', '620500', '张家川回族自治县', '620525');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('928402889f8476650de01476666acbf0', '甘肃省', '620000', '武威市', '620600', '凉州区', '620602');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('929402889f8476650de01476666acbf0', '甘肃省', '620000', '武威市', '620600', '民勤县', '620621');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('930402889f8476650de01476666acbf0', '甘肃省', '620000', '武威市', '620600', '古浪县', '620622');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('931402889f8476650de01476666acbf0', '甘肃省', '620000', '武威市', '620600', '天祝藏族自治县', '620623');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('932402889f8476650de01476666acbf0', '甘肃省', '620000', '张掖市', '620700', '甘州区', '620702');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('933402889f8476650de01476666acbf0', '甘肃省', '620000', '张掖市', '620700', '肃南裕固族自治县', '620721');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('934402889f8476650de01476666acbf0', '甘肃省', '620000', '张掖市', '620700', '民乐县', '620722');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('935402889f8476650de01476666acbf0', '甘肃省', '620000', '张掖市', '620700', '临泽县', '620723');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('936402889f8476650de01476666acbf0', '甘肃省', '620000', '张掖市', '620700', '高台县', '620724');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('937402889f8476650de01476666acbf0', '甘肃省', '620000', '张掖市', '620700', '山丹县', '620725');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('938402889f8476650de01476666acbf0', '甘肃省', '620000', '平凉市', '620800', '崆峒区', '620802');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('939402889f8476650de01476666acbf0', '甘肃省', '620000', '平凉市', '620800', '泾川县', '620821');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('940402889f8476650de01476666acbf0', '甘肃省', '620000', '平凉市', '620800', '灵台县', '620822');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('941402889f8476650de01476666acbf0', '甘肃省', '620000', '平凉市', '620800', '崇信县', '620823');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('942402889f8476650de01476666acbf0', '甘肃省', '620000', '平凉市', '620800', '华亭县', '620824');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('943402889f8476650de01476666acbf0', '甘肃省', '620000', '平凉市', '620800', '庄浪县', '620825');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('944402889f8476650de01476666acbf0', '甘肃省', '620000', '平凉市', '620800', '静宁县', '620826');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('945402889f8476650de01476666acbf0', '甘肃省', '620000', '酒泉市', '620900', '肃州区', '620902');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('946402889f8476650de01476666acbf0', '甘肃省', '620000', '酒泉市', '620900', '金塔县', '620921');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('947402889f8476650de01476666acbf0', '甘肃省', '620000', '酒泉市', '620900', '瓜州县', '620922');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('948402889f8476650de01476666acbf0', '甘肃省', '620000', '酒泉市', '620900', '肃北蒙古族自治县', '620923');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('949402889f8476650de01476666acbf0', '甘肃省', '620000', '酒泉市', '620900', '阿克塞哈萨克族自治县', '620924');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('950402889f8476650de01476666acbf0', '甘肃省', '620000', '酒泉市', '620900', '玉门市', '620981');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('951402889f8476650de01476666acbf0', '甘肃省', '620000', '酒泉市', '620900', '敦煌市', '620982');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('952402889f8476650de01476666acbf0', '甘肃省', '620000', '庆阳市', '621000', '西峰区', '621002');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('953402889f8476650de01476666acbf0', '甘肃省', '620000', '庆阳市', '621000', '庆城县', '621021');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('954402889f8476650de01476666acbf0', '甘肃省', '620000', '庆阳市', '621000', '环县', '621022');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('955402889f8476650de01476666acbf0', '甘肃省', '620000', '庆阳市', '621000', '华池县', '621023');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('956402889f8476650de01476666acbf0', '甘肃省', '620000', '庆阳市', '621000', '合水县', '621024');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('957402889f8476650de01476666acbf0', '甘肃省', '620000', '庆阳市', '621000', '正宁县', '621025');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('958402889f8476650de01476666acbf0', '甘肃省', '620000', '庆阳市', '621000', '宁县', '621026');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('959402889f8476650de01476666acbf0', '甘肃省', '620000', '庆阳市', '621000', '镇原县', '621027');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('960402889f8476650de01476666acbf0', '甘肃省', '620000', '定西市', '621100', '安定区', '621102');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('961402889f8476650de01476666acbf0', '甘肃省', '620000', '定西市', '621100', '通渭县', '621121');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('962402889f8476650de01476666acbf0', '甘肃省', '620000', '定西市', '621100', '陇西县', '621122');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('963402889f8476650de01476666acbf0', '甘肃省', '620000', '定西市', '621100', '渭源县', '621123');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('964402889f8476650de01476666acbf0', '甘肃省', '620000', '定西市', '621100', '临洮县', '621124');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('965402889f8476650de01476666acbf0', '甘肃省', '620000', '定西市', '621100', '漳县', '621125');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('966402889f8476650de01476666acbf0', '甘肃省', '620000', '定西市', '621100', '岷县', '621126');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('967402889f8476650de01476666acbf0', '甘肃省', '620000', '陇南市', '621200', '武都区', '621202');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('968402889f8476650de01476666acbf0', '甘肃省', '620000', '陇南市', '621200', '成县', '621221');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('969402889f8476650de01476666acbf0', '甘肃省', '620000', '陇南市', '621200', '文县', '621222');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('970402889f8476650de01476666acbf0', '甘肃省', '620000', '陇南市', '621200', '宕昌县', '621223');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('971402889f8476650de01476666acbf0', '甘肃省', '620000', '陇南市', '621200', '康县', '621224');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('972402889f8476650de01476666acbf0', '甘肃省', '620000', '陇南市', '621200', '西和县', '621225');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('973402889f8476650de01476666acbf0', '甘肃省', '620000', '陇南市', '621200', '礼县', '621226');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('974402889f8476650de01476666acbf0', '甘肃省', '620000', '陇南市', '621200', '徽县', '621227');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('975402889f8476650de01476666acbf0', '甘肃省', '620000', '陇南市', '621200', '两当县', '621228');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('976402889f8476650de01476666acbf0', '甘肃省', '620000', '临夏回族自治州', '621300', '临夏市', '622901');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('977402889f8476650de01476666acbf0', '甘肃省', '620000', '临夏回族自治州', '621300', '临夏县', '622921');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('978402889f8476650de01476666acbf0', '甘肃省', '620000', '临夏回族自治州', '621300', '康乐县', '622922');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('979402889f8476650de01476666acbf0', '甘肃省', '620000', '临夏回族自治州', '621300', '永靖县', '622923');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('980402889f8476650de01476666acbf0', '甘肃省', '620000', '临夏回族自治州', '621300', '广河县', '622924');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('981402889f8476650de01476666acbf0', '甘肃省', '620000', '临夏回族自治州', '621300', '和政县', '622925');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('982402889f8476650de01476666acbf0', '甘肃省', '620000', '临夏回族自治州', '621300', '东乡族自治县', '622926');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('983402889f8476650de01476666acbf0', '甘肃省', '620000', '临夏回族自治州', '621300', '积石山保安族东乡族撒拉族自治县', '622927');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('984402889f8476650de01476666acbf0', '甘肃省', '620000', '甘南藏族自治州', '621400', '合作市', '623001');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('985402889f8476650de01476666acbf0', '甘肃省', '620000', '甘南藏族自治州', '621400', '临潭县', '623021');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('986402889f8476650de01476666acbf0', '甘肃省', '620000', '甘南藏族自治州', '621400', '卓尼县', '623022');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('987402889f8476650de01476666acbf0', '甘肃省', '620000', '甘南藏族自治州', '621400', '舟曲县', '623023');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('988402889f8476650de01476666acbf0', '甘肃省', '620000', '甘南藏族自治州', '621400', '迭部县', '623024');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('989402889f8476650de01476666acbf0', '甘肃省', '620000', '甘南藏族自治州', '621400', '玛曲县', '623025');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('990402889f8476650de01476666acbf0', '甘肃省', '620000', '甘南藏族自治州', '621400', '碌曲县', '623026');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('991402889f8476650de01476666acbf0', '甘肃省', '620000', '甘南藏族自治州', '621400', '夏河县', '623027');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('992402889f8476650de01476666acbf0', '青海省', '630000', '西宁市', '630100', '城东区', '630102');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('993402889f8476650de01476666acbf0', '青海省', '630000', '西宁市', '630100', '城中区', '630103');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('994402889f8476650de01476666acbf0', '青海省', '630000', '西宁市', '630100', '城西区', '630104');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('995402889f8476650de01476666acbf0', '青海省', '630000', '西宁市', '630100', '城北区', '630105');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('996402889f8476650de01476666acbf0', '青海省', '630000', '西宁市', '630100', '大通回族土族自治县', '630121');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('997402889f8476650de01476666acbf0', '青海省', '630000', '西宁市', '630100', '湟中县', '630122');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('998402889f8476650de01476666acbf0', '青海省', '630000', '西宁市', '630100', '湟源县', '630123');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('999402889f8476650de01476666acbf0', '青海省', '630000', '海东地区', '630200', '平安县', '632121');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1000402889f8476650de01476666acbf', '青海省', '630000', '海东地区', '630200', '民和回族土族自治县', '632122');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1001402889f8476650de01476666acbf', '青海省', '630000', '海东地区', '630200', '乐都县', '632123');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1002402889f8476650de01476666acbf', '青海省', '630000', '海东地区', '630200', '互助土族自治县', '632126');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1003402889f8476650de01476666acbf', '青海省', '630000', '海东地区', '630200', '化隆回族自治县', '632127');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1004402889f8476650de01476666acbf', '青海省', '630000', '海东地区', '630200', '循化撒拉族自治县', '632128');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1005402889f8476650de01476666acbf', '青海省', '630000', '海北藏族自治州', '630300', '门源回族自治县', '632221');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1006402889f8476650de01476666acbf', '青海省', '630000', '海北藏族自治州', '630300', '祁连县', '632222');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1007402889f8476650de01476666acbf', '青海省', '630000', '海北藏族自治州', '630300', '海晏县', '632223');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1008402889f8476650de01476666acbf', '青海省', '630000', '海北藏族自治州', '630300', '刚察县', '632224');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1009402889f8476650de01476666acbf', '青海省', '630000', '黄南藏族自治州', '630400', '同仁县', '632321');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1010402889f8476650de01476666acbf', '青海省', '630000', '黄南藏族自治州', '630400', '尖扎县', '632322');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1011402889f8476650de01476666acbf', '青海省', '630000', '黄南藏族自治州', '630400', '泽库县', '632323');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1012402889f8476650de01476666acbf', '青海省', '630000', '黄南藏族自治州', '630400', '河南蒙古族自治县', '632324');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1013402889f8476650de01476666acbf', '青海省', '630000', '海南藏族自治州', '630500', '共和县', '632521');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1014402889f8476650de01476666acbf', '青海省', '630000', '海南藏族自治州', '630500', '同德县', '632522');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1015402889f8476650de01476666acbf', '青海省', '630000', '海南藏族自治州', '630500', '贵德县', '632523');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1016402889f8476650de01476666acbf', '青海省', '630000', '海南藏族自治州', '630500', '兴海县', '632524');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1017402889f8476650de01476666acbf', '青海省', '630000', '海南藏族自治州', '630500', '贵南县', '632525');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1018402889f8476650de01476666acbf', '青海省', '630000', '果洛藏族自治州', '630600', '玛沁县', '632621');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1019402889f8476650de01476666acbf', '青海省', '630000', '果洛藏族自治州', '630600', '班玛县', '632622');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1020402889f8476650de01476666acbf', '青海省', '630000', '果洛藏族自治州', '630600', '甘德县', '632623');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1021402889f8476650de01476666acbf', '青海省', '630000', '果洛藏族自治州', '630600', '达日县', '632624');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1022402889f8476650de01476666acbf', '青海省', '630000', '果洛藏族自治州', '630600', '久治县', '632625');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1023402889f8476650de01476666acbf', '青海省', '630000', '果洛藏族自治州', '630600', '玛多县', '632626');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1024402889f8476650de01476666acbf', '青海省', '630000', '玉树藏族自治州', '630700', '玉树县', '632721');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1025402889f8476650de01476666acbf', '青海省', '630000', '玉树藏族自治州', '630700', '杂多县', '632722');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1026402889f8476650de01476666acbf', '青海省', '630000', '玉树藏族自治州', '630700', '称多县', '632723');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1027402889f8476650de01476666acbf', '青海省', '630000', '玉树藏族自治州', '630700', '治多县', '632724');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1028402889f8476650de01476666acbf', '青海省', '630000', '玉树藏族自治州', '630700', '囊谦县', '632725');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1029402889f8476650de01476666acbf', '青海省', '630000', '玉树藏族自治州', '630700', '曲麻莱县', '632726');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1030402889f8476650de01476666acbf', '青海省', '630000', '海西蒙古族藏族自治州', '630800', '格尔木市', '632801');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1031402889f8476650de01476666acbf', '青海省', '630000', '海西蒙古族藏族自治州', '630800', '德令哈市', '632802');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1032402889f8476650de01476666acbf', '青海省', '630000', '海西蒙古族藏族自治州', '630800', '乌兰县', '632821');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1033402889f8476650de01476666acbf', '青海省', '630000', '海西蒙古族藏族自治州', '630800', '都兰县', '632822');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1034402889f8476650de01476666acbf', '青海省', '630000', '海西蒙古族藏族自治州', '630800', '天峻县', '632823');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1035402889f8476650de01476666acbf', '宁夏回族自治区', '640000', '银川市', '640100', '兴庆区', '640104');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1036402889f8476650de01476666acbf', '宁夏回族自治区', '640000', '银川市', '640100', '西夏区', '640105');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1037402889f8476650de01476666acbf', '宁夏回族自治区', '640000', '银川市', '640100', '金凤区', '640106');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1038402889f8476650de01476666acbf', '宁夏回族自治区', '640000', '银川市', '640100', '永宁县', '640121');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1039402889f8476650de01476666acbf', '宁夏回族自治区', '640000', '银川市', '640100', '贺兰县', '640122');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1040402889f8476650de01476666acbf', '宁夏回族自治区', '640000', '银川市', '640100', '灵武市', '640181');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1041402889f8476650de01476666acbf', '宁夏回族自治区', '640000', '石嘴山市', '640200', '大武口区', '640202');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1042402889f8476650de01476666acbf', '宁夏回族自治区', '640000', '石嘴山市', '640200', '惠农区', '640205');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1043402889f8476650de01476666acbf', '宁夏回族自治区', '640000', '石嘴山市', '640200', '平罗县', '640221');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1044402889f8476650de01476666acbf', '宁夏回族自治区', '640000', '吴忠市', '640300', '利通区', '640302');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1045402889f8476650de01476666acbf', '宁夏回族自治区', '640000', '吴忠市', '640300', '红寺堡区', '640303');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1046402889f8476650de01476666acbf', '宁夏回族自治区', '640000', '吴忠市', '640300', '盐池县', '640323');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1047402889f8476650de01476666acbf', '宁夏回族自治区', '640000', '吴忠市', '640300', '同心县', '640324');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1048402889f8476650de01476666acbf', '宁夏回族自治区', '640000', '吴忠市', '640300', '青铜峡市', '640381');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1049402889f8476650de01476666acbf', '宁夏回族自治区', '640000', '固原市', '640400', '原州区', '640402');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1050402889f8476650de01476666acbf', '宁夏回族自治区', '640000', '固原市', '640400', '西吉县', '640422');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1051402889f8476650de01476666acbf', '宁夏回族自治区', '640000', '固原市', '640400', '隆德县', '640423');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1052402889f8476650de01476666acbf', '宁夏回族自治区', '640000', '固原市', '640400', '泾源县', '640424');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1053402889f8476650de01476666acbf', '宁夏回族自治区', '640000', '固原市', '640400', '彭阳县', '640425');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1054402889f8476650de01476666acbf', '宁夏回族自治区', '640000', '中卫市', '640500', '沙坡头区', '640502');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1055402889f8476650de01476666acbf', '宁夏回族自治区', '640000', '中卫市', '640500', '中宁县', '640521');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1056402889f8476650de01476666acbf', '宁夏回族自治区', '640000', '中卫市', '640500', '海原县', '640522');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1057402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '乌鲁木齐市', '650100', '天山区', '650102');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1058402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '乌鲁木齐市', '650100', '沙依巴克区', '650103');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1059402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '乌鲁木齐市', '650100', '新市区', '650104');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1060402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '乌鲁木齐市', '650100', '水磨沟区', '650105');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1061402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '乌鲁木齐市', '650100', '头屯河区', '650106');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1062402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '乌鲁木齐市', '650100', '达坂城区', '650107');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1063402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '乌鲁木齐市', '650100', '米东区', '650109');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1064402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '乌鲁木齐市', '650100', '乌鲁木齐县', '650121');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1065402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '克拉玛依市', '650200', '独山子区', '650202');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1066402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '克拉玛依市', '650200', '克拉玛依区', '650203');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1067402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '克拉玛依市', '650200', '白碱滩区', '650204');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1068402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '克拉玛依市', '650200', '乌尔禾区', '650205');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1069402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '吐鲁番地区', '650300', '吐鲁番市', '652101');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1070402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '吐鲁番地区', '650300', '鄯善县', '652122');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1071402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '吐鲁番地区', '650300', '托克逊县', '652123');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1072402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '哈密地区', '650400', '哈密市', '652201');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1073402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '哈密地区', '650400', '巴里坤哈萨克自治县', '652222');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1074402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '哈密地区', '650400', '伊吾县', '652223');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1075402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '昌吉回族自治州', '650500', '昌吉市', '652301');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1076402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '昌吉回族自治州', '650500', '阜康市', '652302');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1077402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '昌吉回族自治州', '650500', '呼图壁县', '652323');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1078402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '昌吉回族自治州', '650500', '玛纳斯县', '652324');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1079402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '昌吉回族自治州', '650500', '奇台县', '652325');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1080402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '昌吉回族自治州', '650500', '吉木萨尔县', '652327');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1081402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '昌吉回族自治州', '650500', '木垒哈萨克自治县', '652328');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1082402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '博尔塔拉蒙古自治州', '650600', '博乐市', '652701');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1083402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '博尔塔拉蒙古自治州', '650600', '精河县', '652722');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1084402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '博尔塔拉蒙古自治州', '650600', '温泉县', '652723');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1085402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '巴音郭楞蒙古自治州', '650700', '库尔勒市', '652801');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1086402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '巴音郭楞蒙古自治州', '650700', '轮台县', '652822');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1087402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '巴音郭楞蒙古自治州', '650700', '尉犁县', '652823');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1088402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '巴音郭楞蒙古自治州', '650700', '若羌县', '652824');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1089402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '巴音郭楞蒙古自治州', '650700', '且末县', '652825');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1090402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '巴音郭楞蒙古自治州', '650700', '焉耆回族自治县', '652826');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1091402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '巴音郭楞蒙古自治州', '650700', '和静县', '652827');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1092402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '巴音郭楞蒙古自治州', '650700', '和硕县', '652828');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1093402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '巴音郭楞蒙古自治州', '650700', '博湖县', '652829');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1094402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '阿克苏地区', '650800', '阿克苏市', '652901');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1095402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '阿克苏地区', '650800', '温宿县', '652922');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1096402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '阿克苏地区', '650800', '库车县', '652923');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1097402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '阿克苏地区', '650800', '沙雅县', '652924');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1098402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '阿克苏地区', '650800', '新和县', '652925');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1099402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '阿克苏地区', '650800', '拜城县', '652926');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1100402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '阿克苏地区', '650800', '乌什县', '652927');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1101402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '阿克苏地区', '650800', '阿瓦提县', '652928');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1102402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '阿克苏地区', '650800', '柯坪县', '652929');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('28402889f8476650de01476666acbf00', '新疆维吾尔自治区', '650000', '克孜勒苏柯尔克孜自治州', '650900', '阿图什市', '653001');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('29402889f8476650de01476666acbf00', '新疆维吾尔自治区', '650000', '克孜勒苏柯尔克孜自治州', '650900', '阿克陶县', '653022');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('30402889f8476650de01476666acbf00', '新疆维吾尔自治区', '650000', '克孜勒苏柯尔克孜自治州', '650900', '阿合奇县', '653023');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('31402889f8476650de01476666acbf00', '新疆维吾尔自治区', '650000', '克孜勒苏柯尔克孜自治州', '650900', '乌恰县', '653024');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1104402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '喀什地区', '651000', '喀什市', '653101');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1105402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '喀什地区', '651000', '疏附县', '653121');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1106402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '喀什地区', '651000', '疏勒县', '653122');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1107402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '喀什地区', '651000', '英吉沙县', '653123');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1108402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '喀什地区', '651000', '泽普县', '653124');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1109402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '喀什地区', '651000', '莎车县', '653125');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1110402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '喀什地区', '651000', '叶城县', '653126');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1111402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '喀什地区', '651000', '麦盖提县', '653127');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1112402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '喀什地区', '651000', '岳普湖县', '653128');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1113402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '喀什地区', '651000', '伽师县', '653129');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1114402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '喀什地区', '651000', '巴楚县', '653130');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1115402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '喀什地区', '651000', '塔什库尔干塔吉克自治县', '653131');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1116402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '和田地区', '651100', '和田市', '653201');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1117402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '和田地区', '651100', '和田县', '653221');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1118402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '和田地区', '651100', '墨玉县', '653222');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1119402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '和田地区', '651100', '皮山县', '653223');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1120402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '和田地区', '651100', '洛浦县', '653224');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1121402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '和田地区', '651100', '策勒县', '653225');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1122402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '和田地区', '651100', '于田县', '653226');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1123402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '和田地区', '651100', '民丰县', '653227');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1124402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '伊犁哈萨克自治州', '651200', '伊宁市', '654002');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1125402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '伊犁哈萨克自治州', '651200', '奎屯市', '654003');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1126402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '伊犁哈萨克自治州', '651200', '伊宁县', '654021');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1127402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '伊犁哈萨克自治州', '651200', '察布查尔锡伯自治县', '654022');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1128402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '伊犁哈萨克自治州', '651200', '霍城县', '654023');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1129402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '伊犁哈萨克自治州', '651200', '巩留县', '654024');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1131402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '伊犁哈萨克自治州', '651200', '新源县', '654025');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1132402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '伊犁哈萨克自治州', '651200', '昭苏县', '654026');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1133402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '伊犁哈萨克自治州', '651200', '特克斯县', '654027');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1134402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '伊犁哈萨克自治州', '651200', '尼勒克县', '654028');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1135402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '塔城地区', '651300', '塔城市', '654201');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1136402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '塔城地区', '651300', '乌苏市', '654202');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1137402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '塔城地区', '651300', '额敏县', '654221');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1138402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '塔城地区', '651300', '沙湾县', '654223');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1139402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '塔城地区', '651300', '托里县', '654224');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1140402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '塔城地区', '651300', '裕民县', '654225');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1141402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '塔城地区', '651300', '和布克赛尔蒙古自治县', '654226');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1142402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '阿勒泰地区', '651400', '阿勒泰市', '654301');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1143402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '阿勒泰地区', '651400', '布尔津县', '654321');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1144402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '阿勒泰地区', '651400', '富蕴县', '654322');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1145402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '阿勒泰地区', '651400', '福海县', '654323');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1146402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '阿勒泰地区', '651400', '哈巴河县', '654324');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1147402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '阿勒泰地区', '651400', '青河县', '654325');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1148402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '阿勒泰地区', '651400', '吉木乃县', '654326');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1149402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '石河子市', '659001', '石河子市', '659001');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1150402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '阿拉尔市', '659002', '阿拉尔市', '659002');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1151402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '图木舒克市', '659003', '图木舒克市', '659003');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1152402889f8476650de01476666acbf', '新疆维吾尔自治区', '650000', '五家渠市', '659004', '五家渠市', '659004');

insert into weixin_address_code (ID, PROVINCE, PROVINCECODE, CITY, CITYCODE, COUNTY, COUNTYCODE)
values ('1153402889f8476650de01476666acbf', '境外', '999999', '境外', '999999', '境外', '999999');

