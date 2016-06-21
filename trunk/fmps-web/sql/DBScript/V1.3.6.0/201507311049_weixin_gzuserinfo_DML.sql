/* 更新生产关注数据,证件代码为空且认证时间不为空的数据 */
update weixin_gzuserinfo set bindtime=null where identifynumber is null;