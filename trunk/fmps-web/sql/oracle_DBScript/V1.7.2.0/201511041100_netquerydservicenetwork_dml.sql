insert into netquerydservicenetwork (NETWORKNAME,PHONENUMBER,ADDRESS,AREA,OPENINGDATE,NETWORKID,NETWORKLEVEL) values('四川省分公司','028-68890257','四川省成都市锦江区一环路东五段8号1栋16层3-5号','四川',to_date('2015/6/29','YYYY/MM/DD'),'5100000000','2');


insert into netquerydservicenetwork (NETWORKNAME,PHONENUMBER,ADDRESS,AREA,OPENINGDATE,NETWORKID,NETWORKLEVEL) values('阜新市彰武支公司','0418-3686611','辽宁省阜新市彰武县彰武镇御景苑小区南承路49#49-9门','辽宁',to_date('2015/09/17','YYYY/MM/DD'),'2109003700','3');

insert into netquerydservicenetwork (NETWORKNAME,PHONENUMBER,ADDRESS,AREA,OPENINGDATE,NETWORKID,NETWORKLEVEL) values('沈阳市沈河支公司','024-22970250','辽宁省沈阳市沈河区小西路73号（奉天大厦一楼）','辽宁',to_date('2015/10/10','YYYY/MM/DD'),'2101013500','3');

update netquerydservicenetwork set PHONENUMBER='024-86697098' where NETWORKNAME='沈阳中心支公司';

update netquerydservicenetwork set PHONENUMBER='0416-2116888' where NETWORKNAME='锦州中心支公司';

update netquerydservicenetwork set ADDRESS='辽宁省锦州市黑山县黑山镇八街解放南街6D璀璨明都1#楼南2#' where NETWORKNAME='锦州市黑山支公司';

update netquerydservicenetwork set PHONENUMBER='0416-6695510',ADDRESS='辽宁省锦州市北镇市广宁乡八家子村' where NETWORKNAME='锦州市北镇支公司';