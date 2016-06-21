package cn.com.fubon.wechatClaims.service;

import cn.com.fubon.entity.WeChatContext;

public interface WeChatContextService {
	
	public WeChatContext getWeChatContext(String openid) ;

	public void saveWeChatContext(WeChatContext weChatContext, String openid);

}
