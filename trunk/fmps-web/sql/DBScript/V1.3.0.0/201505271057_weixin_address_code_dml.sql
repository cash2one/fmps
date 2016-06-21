/*只保留公司机构所在省份*/
delete from weixin_address_code where province not in ('福建省','重庆市','辽宁省');