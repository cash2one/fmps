/* 个人中心改版--菜单"个人信息"地址修改 */
update weixin_menuentity set url='https://open.weixin.qq.com/connect/oauth2/authorize?appid={APPID}&redirect_uri={domain}/fo/binded/personalCenterController.do?method=Index&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect'
where name='个人信息';