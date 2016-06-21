package cn.com.fubon.fo.personalcenter.service;

import java.util.Map;
import org.jeecgframework.core.common.service.CommonService;
import weixin.guanjia.account.entity.WeixinAccountEntity;

/**
 * 个人中心类
 * 
 * @author patrick.z
 */
public interface PersonalCenterService extends CommonService {

	/**
	 * 查询客户信息。
	 * @param openid
	 * @return
	 */
	Map<String, String> getCustomerInfoByOpenId(String openid);
	
	/**
	 * 
	 * 查找有效微信帐号
	 * */
	WeixinAccountEntity getWeixinAccountByStatus();
}
