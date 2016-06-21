
/*新增字段 customerSex*/
ALTER TABLE weixin_gzuserinfo ADD customerSex varchar(1) NULL COMMENT '认证客户的性别';

/*新增字段 customerBirthday*/
ALTER TABLE weixin_gzuserinfo ADD customerBirthday date NULL COMMENT '认证客户的生日';

/*新增字段 identifyType*/
ALTER TABLE weixin_gzuserinfo ADD identifyType varchar(10) NULL COMMENT '认证客户的证件类型';