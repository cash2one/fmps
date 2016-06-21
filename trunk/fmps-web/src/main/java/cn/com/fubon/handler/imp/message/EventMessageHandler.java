package cn.com.fubon.handler.imp.message;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import jodd.util.StringUtil;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.jeecgframework.core.util.JSONHelper;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.guanjia.core.entity.message.event.BaseEvent;
import weixin.guanjia.core.entity.message.event.ClickEvent;
import weixin.guanjia.core.entity.message.event.LocationEvent;
import weixin.guanjia.core.entity.message.event.SubscribeEvent;
import weixin.guanjia.core.entity.message.event.TemplateSendJobFinishEvent;
import weixin.guanjia.core.entity.message.resp.BaseMessageResp;
import weixin.guanjia.core.entity.message.resp.TextMessageResp;
import weixin.guanjia.core.util.WeixinUtil;
import weixin.idea.huodong.entity.HuodongEntity;
import weixin.idea.huodong.service.HuodongService;
import weixin.popular.api.MessageAPI;
import weixin.popular.bean.message.NewsMessage;
import weixin.popular.bean.message.NewsMessage.Article;
import weixin.popular.util.JsonUtil;
import weixin.util.WeiXinConstants;
import cn.com.fubon.bo.wxtemplatemessage.entity.WeiXinTemplateMessageSendLog;
import cn.com.fubon.fo.customerbind.entity.WeiXinGzUserInfo;
import cn.com.fubon.fo.event.entity.CustomerLocationEvent;
import cn.com.fubon.fo.event.service.ICustomerLocationEventService;
import cn.com.fubon.fo.event.service.IEventProcessingService;
import cn.com.fubon.fo.repairplatform.entity.response.RecommendRepairListResponse;
import cn.com.fubon.handler.imp.AbstractMessageHandler;
import cn.com.fubon.util.CachedUtils;
import cn.com.fubon.util.Constants;
import cn.com.fubon.wechatClaims.service.ClaimsSessionManagement;

/**
 * 事件处理类
 * 
 * @author shanqi.wang
 *
 */
@Service("eventMessageHandler")
@Transactional
public class EventMessageHandler extends AbstractMessageHandler<BaseEvent> {

	private IEventProcessingService eventProcessingService;
	private SystemService systemService;
	private WeixinAccountServiceI weixinAccountService;
	@Resource
	private ICustomerLocationEventService customerLocationEventService;

	@Resource
	private ClaimsSessionManagement claimsSessionManagement;
	
	@Resource
	private HuodongService huodongService;

	private static final Logger logger = Logger
			.getLogger(EventMessageHandler.class);

	public WeixinAccountServiceI getWeixinAccountService() {
		return weixinAccountService;
	}

	@Autowired
	public void setWeixinAccountService(
			WeixinAccountServiceI weixinAccountService) {
		this.weixinAccountService = weixinAccountService;
	}

	public SystemService getSystemService() {
		return systemService;
	}

	@Autowired
	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}

	@Override
	protected BaseEvent convert(Map<String, String> requestMap)
			throws Exception {
		BaseEvent baseEvent = new BaseEvent();
		// MyBeanUtils.copyMap2Bean(baseEvent, requestMap); 目前用这种方式拷贝会出错
		// BeanUtil.populateBean(baseEvent, requestMap);
		baseEvent.setFromUserName(requestMap.get("FromUserName"));
		baseEvent.setToUserName(requestMap.get("ToUserName"));
		baseEvent.setCreateTime(Long.parseLong(requestMap.get("CreateTime")));
		baseEvent.setMsgType(requestMap.get("MsgType"));
		logger.info("convert requestMap Event ==>" + requestMap.get("Event"));
		baseEvent.setEvent(requestMap.get("Event"));
		if (requestMap.get("Event").equals(WeiXinConstants.EVENT_TYPE_LOCATION)) {
			LocationEvent locationEvent = new LocationEvent();
			locationEvent.setFromUserName(requestMap.get("FromUserName"));
			locationEvent.setToUserName(requestMap.get("ToUserName"));
			locationEvent.setCreateTime(Long.parseLong(requestMap
					.get("CreateTime")));
			locationEvent.setMsgType(requestMap.get("MsgType"));
			locationEvent.setEvent(requestMap.get("Event"));
			locationEvent.setLatitude(requestMap.get("Latitude"));
			locationEvent.setLongitude(requestMap.get("Longitude"));
			locationEvent.setPrecision(requestMap.get("Precision"));
			return locationEvent;
		} else if (requestMap.get("Event").equals(
				WeiXinConstants.EVENT_TYPE_CLICK)) {
			ClickEvent ClickEvent = new ClickEvent();
			ClickEvent.setFromUserName(requestMap.get("FromUserName"));
			ClickEvent.setToUserName(requestMap.get("ToUserName"));
			ClickEvent.setCreateTime(Long.parseLong(requestMap
					.get("CreateTime")));
			ClickEvent.setMsgType(requestMap.get("MsgType"));
			ClickEvent.setEvent(requestMap.get("Event"));
			ClickEvent.setEventKey(requestMap.get("EventKey"));
			return ClickEvent;
		} else if (requestMap.get("Event").equals(
				WeiXinConstants.EVENT_TYPE_SUBSCRIBE)) {
			SubscribeEvent subscribeEvent = new SubscribeEvent();
			subscribeEvent.setFromUserName(requestMap.get("FromUserName"));
			subscribeEvent.setToUserName(requestMap.get("ToUserName"));
			subscribeEvent.setCreateTime(Long.parseLong(requestMap
					.get("CreateTime")));
			subscribeEvent.setMsgType(requestMap.get("MsgType"));
			subscribeEvent.setEvent(requestMap.get("Event"));
			if (requestMap.get("EventKey") != null) {
				subscribeEvent.setEventKey(requestMap.get("EventKey"));
			}
			return subscribeEvent;
		} else if (requestMap.get("Event").equals(
				WeiXinConstants.EVENT_TYPE_TEMPLATESENDJOBFINISH)) { // 模板消息事件

			TemplateSendJobFinishEvent templateSendJobFinishEvent = new TemplateSendJobFinishEvent();
			templateSendJobFinishEvent.setEvent(requestMap.get("Event"));
			templateSendJobFinishEvent.setFromUserName(requestMap
					.get("FromUserName"));
			templateSendJobFinishEvent.setMsgID(requestMap.get("MsgID"));
			String weixinStatus = requestMap.get("Status");
			Integer status = null;
			switch (weixinStatus) {
			case Constants.TEMPLATE_MESSAGE_WEIXIN_SUCCESS:
				status = Constants.TEMPLATE_MESSAGE_SUCCESS;
				break;
			case Constants.TEMPLATE_MESSAGE_WEIXIN_USER_BLOCK:
				status = Constants.TEMPLATE_MESSAGE_USER_BLOCK;
				break;
			case Constants.TEMPLATE_MESSAGE_WEIXIN_SYSTEM_FAILED:
				status = Constants.TEMPLATE_MESSAGE_SYSTEM_FAILED;
				break;
			}

			templateSendJobFinishEvent.setStatus(status);
			templateSendJobFinishEvent.setCreateTime(Long.parseLong(requestMap
					.get("CreateTime")) * 1000);

			logger.info("convert Event TEMPLATESENDJOBFINISH FromUserName==>"
					+ requestMap.get("FromUserName") + " weixinStatus==>"
					+ weixinStatus + " MsgID==>" + requestMap.get("MsgID")
					+ " status==>" + status);

			return templateSendJobFinishEvent;
		}
		return baseEvent;
	}

	@Override
	protected BaseMessageResp doExecute(BaseEvent baseEvent) throws Exception {
		String messageRespContent = ""; // 默认返回空
		if (baseEvent.getEvent().equals(WeiXinConstants.EVENT_TYPE_SUBSCRIBE)) {
			messageRespContent = this.doSubscribe((SubscribeEvent) baseEvent); // 关注事件
			sendMessage(baseEvent.getFromUserName()); //发送图文客服消息
		} else if (baseEvent.getEvent().equals(
				WeiXinConstants.EVENT_TYPE_UNSUBSCRIBE)) {
			messageRespContent = this.doUnSubscribe(baseEvent); // 取消关注事件
		} else if (baseEvent.getEvent()
				.equals(WeiXinConstants.EVENT_TYPE_CLICK)) {
			messageRespContent = this.doEvenTypeClick((ClickEvent) baseEvent);
			// CLICK(自定义菜单点击事件)处理
		} else if (baseEvent.getEvent().equals(WeiXinConstants.EVENT_TYPE_VIEW)) {
			// 事件类型：VIEW(自定义菜单点击事件)
		} else if (baseEvent.getEvent().equals(
				WeiXinConstants.EVENT_TYPE_LOCATION)) {
			// 上报地理位置处理
			this.doLocationEven((LocationEvent) baseEvent);
			return null; // 上报地理位置，无需反馈给客户端。
		} else if (baseEvent.getEvent().equals(
				WeiXinConstants.EVENT_TYPE_TEMPLATESENDJOBFINISH)) {
			// 模板消息发送记录入库 weixin_template_message_send_log
			this.doTemplateSendJobFinishEvent((TemplateSendJobFinishEvent) baseEvent);
			return null;
		} else {

		}
		// 构造返回对象
		TextMessageResp textMessageResp = new TextMessageResp();
		textMessageResp.setToUserName(baseEvent.getFromUserName());
		textMessageResp.setFromUserName(baseEvent.getToUserName());
		java.util.Date date = new Date();
		textMessageResp.setCreateTime(date.getTime());
		textMessageResp.setContent(messageRespContent);
		return textMessageResp;
	}

	private void doLocationEven(LocationEvent baseEvent)
			throws IllegalAccessException, InvocationTargetException {
		// 构造地理位置实体对象
		CustomerLocationEvent customerLocationEvent = new CustomerLocationEvent();
		WeixinAccountEntity weixinAccountEntity = weixinAccountService
				.findByToUsername(baseEvent.getToUserName());
		customerLocationEvent.setAccountid(weixinAccountEntity);
		customerLocationEvent.setCreateTime(new Date(
				baseEvent.getCreateTime() * 1000));
		customerLocationEvent.setEvent(baseEvent.getEvent());
		customerLocationEvent.setFromUserName(baseEvent.getFromUserName());
		customerLocationEvent.setLatitude(baseEvent.getLatitude());
		customerLocationEvent.setLongitude(baseEvent.getLongitude());
		customerLocationEvent.setMsgType(baseEvent.getMsgType());
		customerLocationEvent.setPrecision(baseEvent.getPrecision());
		customerLocationEvent.setToUserName(baseEvent.getToUserName());
		// 删除旧的地理信息
		String days = ResourceUtil
				.getSessionattachmenttitle("CLEAN_OLD_LOCATION");
		Integer del = customerLocationEventService.delOldCustomerLocation(
				baseEvent.getFromUserName(), days);
		// 保全地理位置对象 owJamuDWCLSI2D8yfY8Sx8z8MrZg
		customerLocationEventService.save(customerLocationEvent);
		// 获取客户最后一次上报的地理位置
		// customerLocationEventService.getLastestCustomerLocation("owJamuDWCLSI2D8yfY8Sx8z8MrZg");

	}

	// 关注事件处理
	protected String doSubscribe(SubscribeEvent baseEvent) throws Exception {
		WeixinAccountEntity weixinAccountEntity = weixinAccountService
				.findByToUsername(baseEvent.getToUserName());
		// 获取accessToken
		String accessToken = weixinAccountService
				.getAccessToken(weixinAccountEntity);
		String requestUrl = WeixinUtil.get_customer_url.replace("ACCESS_TOKEN",
				accessToken).replace("OPENID", baseEvent.getFromUserName());
		JSONObject CustomerJSONObject = WeixinUtil.httpRequest(requestUrl,
				"GET", null);
		//WeiXinGzUserInfo weiXinGzUserInfo = (WeiXinGzUserInfo) JSONHelper.json2Object(CustomerJSONObject.toString(),WeiXinGzUserInfo.class);
		WeiXinGzUserInfo weiXinGzUserInfo = JsonUtil.parseObject(CustomerJSONObject.toString(),	WeiXinGzUserInfo.class);		
		java.util.Date date = new Date();		
		weiXinGzUserInfo.setAccount(weixinAccountEntity);
		weiXinGzUserInfo.setAddtime(date);		
		weiXinGzUserInfo.setEventKey(baseEvent.getEventKey());		
		// 1:关注
		// 0:取消关注
		// 先保存数据到数据库中
		try {
			eventProcessingService.customerSubscribe(weiXinGzUserInfo);
		} catch (Exception e) {
			logger.info("saveCustomerSubscribeError===openid====>"
					+ weiXinGzUserInfo.getOpenid(),e);
		}
		// 获取欢迎模板信息
		// Map<String, Object> openid = new HashMap<String, Object>();
		// openid.put("openid", baseEvent.getFromUserName());
		return "     欢迎关注富邦财险，如您需要查询个人名下保单,"
		// + " <a href=\"" + ResourceUtil.getDomain()
		// + "/fo/customerBindController.do?method=bindIndex&openid="
		// + baseEvent.getFromUserName() + "\"" + "> 请点此认证身份 </a> \n\n "
				+ "可在我->保单里查询。\n\n" + "     如您要使用车险微信闪赔，请直接在对话框输入报案的手机号发送给我们。";
		// return MessageUtil.getWelcomeConent();
	}

	protected String doEvenTypeClick(ClickEvent clickEvent) {
		String returnMessage = "";
		if (clickEvent.getEventKey().equals("badh"))
			returnMessage = "4008-817-518";
		if (clickEvent.getEventKey().equals("wlp"))
			returnMessage = claimsSessionManagement.clickMenuen(clickEvent
					.getFromUserName());
		// if (clickEvent.getEventKey().equals("wxpt"))
		// returnMessage = this.getRepairPlatformPromptMessage(clickEvent
		// .getFromUserName());
		return returnMessage;
	}

	protected String doUnSubscribe(BaseEvent baseEvent) {
		// 更改 weixin_gzuserinfo 表 关注 状态
		try {
			eventProcessingService.customerUnsubscribe(baseEvent
					.getFromUserName());
		} catch (Exception e) {
			logger.info("save_UnSubscribe_Error===openid====>"
					+ baseEvent.getFromUserName() + ".ErrorMessage:"
					+ e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CachedUtils.delete(baseEvent.getFromUserName());
		CachedUtils.delete(baseEvent.getFromUserName()
				+ Constants.MEMKEY_IDENTIFYNUMBER);
		CachedUtils.delete(baseEvent.getFromUserName()
				+ Constants.MEMKEY_CUSTOMERCNAME);
		// added by qingqu.huang @date 2015-10-16 取消关注的时候，将memcached中用户关注状态删除
		CachedUtils.delete(baseEvent.getFromUserName() + "mobile");
		CachedUtils.delete(baseEvent.getFromUserName() + Constants.MEMKEY_WEIXIN_GZUSERINFO);
		logger.info("memcached删除" + baseEvent.getFromUserName() + "的关注状态");
		return "";
	}

	protected void doTemplateSendJobFinishEvent(
			TemplateSendJobFinishEvent templateSendJobFinishEvent) {
		String messageId = templateSendJobFinishEvent.getMsgID();
		logger.info("doTemplateSendJobFinishEvent message_Id==>" + messageId);
		WeiXinTemplateMessageSendLog sendLog = systemService
				.findUniqueByProperty(WeiXinTemplateMessageSendLog.class,
						"messageId", messageId);
		logger.info("WeiXinTemplateMessageSendLog ==>" + sendLog);
		sendLog.setStatus(templateSendJobFinishEvent.getStatus());
		systemService.saveOrUpdateWeiXinTemplateMessageSendLog(sendLog);

	}

	@Override
	protected void doAsyncExecute(BaseEvent requestMessage) {
		// TODO Auto-generated method stub
	}

	public IEventProcessingService getEventProcessingService() {
		return eventProcessingService;
	}

	@Autowired
	public void setEventProcessingService(
			IEventProcessingService eventProcessingService) {
		this.eventProcessingService = eventProcessingService;
	}

	protected String getRepairPlatformPromptMessage(String openid) {
		String Message = "";
		String menu = "https://open.weixin.qq.com/connect/oauth2/authorize?appid={APPID}&redirect_uri={domain}/fo/repairPlatformController.do?method=index&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
		String Mark = (String) CachedUtils
				.get(Constants.MEMKEY_WEIXIN_locationMessage + openid);
		// 点击了菜单或者已经上传了地理位置
		if ("Y".equals(Mark) || "M".equals(Mark)) {
			List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService
					.findValidWeixinAccounts();
			WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList
					.get(0);
			menu = menu.replace("{APPID}",
					weixinAccountEntity.getAccountappid()).replace("{domain}",
					ResourceUtil.getDomain());
			Message = "您好，请点击如下链接进入维修平台 <a href=\"" + menu + "\""
					+ "> 维修平台 </a> ";
		} else {
			Message = "您好，请点击左下角“键盘”图标，点击“+”键，再点击“位置”图标，发送位置信息给我，即可为您寻找最近的维修厂。";
			CachedUtils.set(Constants.MEMKEY_WEIXIN_locationMessage + openid,
					30 * 60, "M"); // 用户点击了菜单
		}

		return Message;
	}
	
	//2016春节活动发送抽奖信息给客户
	private void sendMessage(String openid){
		if(this.isRangeOfDate()){			
		 String accessToken = weixinAccountService.getAccessTokenFromAccountEntity();	
		String domain=	ResourceUtil.getDomain();		
		//String title, String description, String url,	String picurl
		Article	 Article= new Article("新春大奖抽不停，万一中了呢","让您久等了，点击下方“查看全文”，开启您的幸运之门吧！",domain+"/fo/lunarNewYearController.do?huodongMain",domain+"/plug-in/huodong/lunarnewyear/images/message.jpg");	
		List<Article> articles=new ArrayList<Article>();	
		articles.add(Article);
		NewsMessage newsMessage=new NewsMessage(openid,articles);
			( new MessageAPI() ).messageCustomSend(accessToken, newsMessage);
		}
	}
	
	//判断是否在活动期间内
		private   boolean isRangeOfDate() {
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String startTime=(String)CachedUtils.get(Constants.HUODON_START_DATE); //活动开始时间
			String endTime=(String)CachedUtils.get(Constants.HUODON_END_DATE);  //活动结束时间		
			if(StringUtil.isEmpty(startTime)||StringUtil.isEmpty(endTime)){		
			   HuodongEntity huodongEntity=huodongService.getEntity(HuodongEntity.class,"8a828edfedfre68475034fd3dca5799634");		
			   startTime=sf.format(huodongEntity.getStarttime());
			   endTime=sf.format(huodongEntity.getEndtime());
			   CachedUtils.set(Constants.HUODON_START_DATE,startTime);
			   CachedUtils.set(Constants.HUODON_END_DATE,endTime);		
			}
			Date nowdate = new Date();
			try {
				if (nowdate.after(sf.parse(startTime))
						&& nowdate.before(sf.parse(endTime))) {
					return true;
				}
			} catch (ParseException e) {
				logger.error("日期格式化出错...", e);
				return false;
			}
			return false;
		}
	
	
	
}
