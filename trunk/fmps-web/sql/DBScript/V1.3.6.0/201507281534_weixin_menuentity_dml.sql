/* �������ĸİ�--�˵�"������Ϣ"��ַ�޸� */
update weixin_menuentity set url='https://open.weixin.qq.com/connect/oauth2/authorize?appid={APPID}&redirect_uri={domain}/fo/binded/personalCenterController.do?method=Index&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect'
where name='������Ϣ';