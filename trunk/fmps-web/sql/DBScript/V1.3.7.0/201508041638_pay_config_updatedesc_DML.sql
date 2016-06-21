update pay_config config set  config.value='我在富邦抢到了{amount}元红包，快来试试手气吧！' where config.`key`='desc';
DELETE FROM pay_config WHERE  `id`='300002';
INSERT INTO pay_config (`id`, `type`, `key`, `value`) VALUES ('300005', '分享', 'zonelink', 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=${appid}&redirect_uri=${WebRoot}/fo/cashCouponController.do?cashcoupon&response_type=code&scope=snsapi_userinfo&state=8a828ebb49166847014916deca570004_3#wechat_redirect');
INSERT INTO pay_config (`id`, `type`, `key`, `value`) VALUES ('300006', '分享', 'flink', 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=${appid}&redirect_uri=${WebRoot}/fo/cashCouponController.do?cashcoupon&response_type=code&scope=snsapi_userinfo&state=8a828ebb49166847014916deca570004_4#wechat_redirect');

