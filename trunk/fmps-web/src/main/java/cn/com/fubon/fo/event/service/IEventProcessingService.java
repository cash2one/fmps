package cn.com.fubon.fo.event.service;

import org.jeecgframework.core.common.service.CommonService;

import weixin.guanjia.core.entity.message.event.BaseEvent;
import cn.com.fubon.fo.customerbind.entity.WeiXinGzUserInfo;
/**
 * 事件接口服务类
 * 
 * @author shanqi.wang
 *
 */

public interface IEventProcessingService extends CommonService  {

	/**
	 * 保存关注用户数据
	 */

	public void customerSubscribe(WeiXinGzUserInfo weiXinGzUserInfo) throws Exception ;

	/**
	 * 更新取消关注用户
	 */

	public void customerUnsubscribe(String OpenID);

}
