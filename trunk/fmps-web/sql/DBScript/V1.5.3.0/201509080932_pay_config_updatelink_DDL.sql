update pay_config config set config.value='https://open.weixin.qq.com/connect/oauth2/authorize?appid={appid}&redirect_uri=${WebRoot}%2Ffo%2FcashCouponController.do%3Fcashcoupon%26fromtag%3D3%26huodongid%3D{huodongid}&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect' where config.key='zonelink';
update pay_config config set config.value='https://open.weixin.qq.com/connect/oauth2/authorize?appid={appid}&redirect_uri=${WebRoot}%2Ffo%2FcashCouponController.do%3Fcashcoupon%26fromtag%3D4%26huodongid%3D{huodongid}&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect' where config.key='flink';