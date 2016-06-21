ALTER TABLE weixin_gzuserinfo
    add bindType varchar(10) DEFAULT NULL COMMENT '认证类型 car车牌认证；other其他方式认证';
    
ALTER TABLE weixin_gzuserinfo
    add bindTime timestamp NULL DEFAULT NULL COMMENT '认证时间';
