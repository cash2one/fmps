package cn.com.fubon.fo.customerbind.service;

import java.util.List;
import java.util.Map;

import org.jeecgframework.core.common.service.CommonService;

import cn.com.fubon.fo.customerbind.entity.WeiXinGzUserInfo;

public interface CustomerBindService extends CommonService {

	public Map<String, String> findCustomerInfo(String identifynumber,
			String customercname);

	public boolean isBinded(String openid);
	public boolean isBinded(String identifynumber,String customercname);
	public boolean isAutoInsuranceCustomer(String openid);
	public boolean isAuthenticated(String openid);
	/**
	 * 已绑定且有手机号用户
	 * @return
	 */
	public List<WeiXinGzUserInfo> findBindCustemer();
}
