package cn.com.fubon.fo.event.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.MyBeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import weixin.guanjia.core.entity.message.event.BaseEvent;
import weixin.util.WeiXinConstants;
import cn.com.fubon.fo.event.service.IEventProcessingService;
import cn.com.fubon.transaction.entity.TransactionRecord;
import cn.com.fubon.fo.customerbind.entity.WeiXinGzUserInfo;
import cn.com.fubon.fo.customerclaims.controller.CustomerClaimsController;

/**
 * 事件处理服务类
 * 
 * @author shanqi.wang
 *
 */
@Service("eventProcessingService")
@Transactional
public class EventProcessingServiceImpl extends CommonServiceImpl implements
		IEventProcessingService {
	private static final Logger logger = Logger.getLogger(EventProcessingServiceImpl.class);
	/**
	 * 用户点击关注时，数据的保全及更新
	 */
	@Override
	public void customerSubscribe(WeiXinGzUserInfo weiXinGzUserInfo)
			throws Exception {
		logger.info("customerSubscribe(WeiXinGzUserInfo weiXinGzUserInfo):"+weiXinGzUserInfo.getOpenid());
		List<WeiXinGzUserInfo> weiXinGzUserInfoList = this.findByProperty(
				WeiXinGzUserInfo.class, "openid", weiXinGzUserInfo.getOpenid());
		if (weiXinGzUserInfoList.size() > 0) { // 如果已有客户就更新数据
			for (WeiXinGzUserInfo weiXinGzUser : weiXinGzUserInfoList) {
				MyBeanUtils
						.copyBeanNotNull2Bean(weiXinGzUserInfo, weiXinGzUser);
				this.updateEntitie(weiXinGzUser);
			}
		} else {
			this.save(weiXinGzUserInfo);
		}
	}

	/**
	 * 用户取消关注时删除 所有信息
	 */
	@Override
	public void customerUnsubscribe(String OpenID) {
		String sql="update weixin_gzuserinfo set subscribe='0',customercode=null,customercname=null,identifynumber=null,mobile=null,licenseno=null,bindType=null,bindTime=null,customerSex=null,customerBirthday=null,identifyType=null  where  openid=? ";
		logger.info("customerUnsubscribe(String OpenID):"+OpenID);
		//List<WeiXinGzUserInfo> weiXinGzUserInfoList = this.findByProperty(
		//		WeiXinGzUserInfo.class, "openid", OpenID);
		//this.deleteAllEntitie(weiXinGzUserInfoList); //用户取消关注，删除 所有信息 
		
		this.executeSql(sql,OpenID);
		//for (WeiXinGzUserInfo weiXinGzUserInfo : weiXinGzUserInfoList) {			
		//	weiXinGzUserInfo.setSubscribe(WeiXinConstants.UNSUBSCRIBE_TYPE_VALUE);			
		//	this.updateEntitie(weiXinGzUserInfo);
		//}
	}

}
