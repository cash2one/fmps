package cn.com.fubon.wechatClaims.service.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import cn.com.fubon.entity.WeChatContext;
import cn.com.fubon.util.CachedUtils;
import cn.com.fubon.util.Constants;
import cn.com.fubon.wechatClaims.service.WeChatContextService;
import cn.com.fubon.wechatClaims.service.impl.ClaimsSessionManagementImpl.Progress;

@Service("weChatContextService")
public class WeChatContextServiceImpl implements WeChatContextService {
	private static final Logger logger = Logger
			.getLogger(WeChatContextServiceImpl.class);

	@Override
	public WeChatContext getWeChatContext(String openid) {
		WeChatContext weChatContext = (WeChatContext) CachedUtils
				.get(Constants.MEMKEY_WEIXIN_WeChat_claims + openid);
		if (weChatContext == null) {
			weChatContext = new WeChatContext();
			weChatContext.save(Constants.WEIXINCLAIMS_claimsProgress,
					Progress.Cancel_claim_session);
			weChatContext.save(Constants.WEIXINCLAIMS_claimsImage_total, 0);
			weChatContext.save(Constants.WEIXINCLAIMS_claimsphoneNO, 0);
			weChatContext.save(Constants.WEIXINCLAIMS_is_Ask, "N");

		}
		Progress claimsProgress = (Progress) weChatContext
				.get(Constants.WEIXINCLAIMS_claimsProgress);
		logger.info("getWeChatContext,openid=====>" + openid
				+ ";claimsProgress=========>" + claimsProgress);
		logger.info("getWeChatContext,openid=====>" + openid
				+ ";Image_total=========>"
				+ weChatContext.get(Constants.WEIXINCLAIMS_claimsImage_total));
		logger.info("getWeChatContext,openid=====>" + openid
				+ ";claimsphoneNO=========>"
				+ weChatContext.get(Constants.WEIXINCLAIMS_claimsphoneNO));
		return weChatContext;
	}

	@Override
	public void saveWeChatContext(WeChatContext weChatContext, String openid) {
		Progress claimsProgress = (Progress) weChatContext
				.get(Constants.WEIXINCLAIMS_claimsProgress);
		logger.info("saveWeChatContext,openid=========> " + openid
				+ "claimsProgress=========>" + claimsProgress);
		CachedUtils.set(Constants.MEMKEY_WEIXIN_WeChat_claims + openid,
				30 * 60, weChatContext);
	}

}
