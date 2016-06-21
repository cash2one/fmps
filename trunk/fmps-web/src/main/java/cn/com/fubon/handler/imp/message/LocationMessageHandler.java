package cn.com.fubon.handler.imp.message;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.jeecgframework.core.util.ResourceUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.guanjia.core.entity.message.req.LocationMessage;
import weixin.guanjia.core.entity.message.resp.BaseMessageResp;
import weixin.guanjia.core.entity.message.resp.TextMessageResp;
import weixin.guanjia.message.entity.ReceiveMessage;
import weixin.guanjia.message.service.ReceiveMessageServiceI;
import weixin.util.DateUtils;
import cn.com.fubon.handler.imp.AbstractMessageHandler;
import cn.com.fubon.util.CachedUtils;
import cn.com.fubon.util.Constants;
import cn.com.fubon.wechatClaims.service.ClaimsSessionManagement;

@Service("locationMessageHandler")
@Transactional
public class LocationMessageHandler extends
		AbstractMessageHandler<LocationMessage> {

	@Resource
	private ClaimsSessionManagement claimsSessionManagement;
	@Resource
	private ReceiveMessageServiceI receiveMessageService;
	@Resource
	private WeixinAccountServiceI weixinAccountService;

	@Override
	protected LocationMessage convert(Map<String, String> requestMap) {
		// TODO Auto-generated method stub
		LocationMessage locationMessage = new LocationMessage();
		locationMessage.setCreateTime(Long.parseLong(requestMap
				.get("CreateTime")));
		locationMessage.setFromUserName(requestMap.get("FromUserName"));
		locationMessage.setMsgId(Long.parseLong(requestMap.get("MsgId")));
		locationMessage.setMsgType(requestMap.get("MsgType"));
		locationMessage.setToUserName(requestMap.get("ToUserName"));
		locationMessage.setScale(requestMap.get("Scale"));
		locationMessage.setLabel(requestMap.get("Label"));
		locationMessage.setLocation_X(requestMap.get("Location_X"));
		locationMessage.setLocation_Y(requestMap.get("Location_Y"));
		return locationMessage;
	}

	@Override
	protected BaseMessageResp doExecute(LocationMessage locationMessage)
			throws Exception {

		TextMessageResp textMessageResp = new TextMessageResp();
		textMessageResp.setToUserName(locationMessage.getFromUserName());
		textMessageResp.setFromUserName(locationMessage.getToUserName());
		java.util.Date date = new Date();
		textMessageResp.setCreateTime(date.getTime());
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);   
		int hour = calendar.get(calendar.HOUR_OF_DAY);
		String content = Constants.WEIXIN_MESSAGE_DEFAULT_REPLY;
		int startWorkHour = Integer.parseInt(ResourceUtil.getStartWorkHour());
		int endWorkHour = Integer.parseInt(ResourceUtil.getEndWorkHour());
		if(hour<startWorkHour || hour>endWorkHour){
			content += Constants.WEIXIN_MESSAGE_DEFAULT_REPLY_TIMING;
		}
		textMessageResp.setContent(content);

		// 保存接收到的信息
		ReceiveMessage receiveMessage = new ReceiveMessage();
		Timestamp temp = Timestamp.valueOf(DateUtils
				.getDate("yyyy-MM-dd HH:mm:ss"));
		receiveMessage.setCreateTime(temp);
		receiveMessage.setFromUserName(locationMessage.getFromUserName());
		receiveMessage.setToUserName(locationMessage.getToUserName());
		receiveMessage.setMsgId(Long.toString(locationMessage.getMsgId()));
		receiveMessage.setMsgType(locationMessage.getMsgType());
		receiveMessage.setAccount(weixinAccountService
				.findByToUsername(locationMessage.getToUserName()));
		receiveMessage.setLabel(locationMessage.getLabel());
		receiveMessage.setLocation_X(locationMessage.getLocation_X());
		receiveMessage.setLocation_Y(locationMessage.getLocation_Y());
		receiveMessage.setScale(locationMessage.getScale());
		this.receiveMessageService.save(receiveMessage);
//		String Mark = (String) CachedUtils
//				.get(Constants.MEMKEY_WEIXIN_locationMessage
//						+ locationMessage.getFromUserName());
//		// 用户点击了维修平台菜单
//		if ("M".equals(Mark)) {
//			String menu = "https://open.weixin.qq.com/connect/oauth2/authorize?appid={APPID}&redirect_uri={domain}/fo/repairPlatformController.do?method=index&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
//			List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService
//					.findValidWeixinAccounts();
//			WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList
//					.get(0);
//			menu = menu.replace("{APPID}",
//					weixinAccountEntity.getAccountappid()).replace("{domain}",
//					ResourceUtil.getDomain());
//			String Content = "您好，请点击如下链接进入维修平台 <a href=\"" + menu + "\""
//					+ "> 维修平台 </a> ";
//			textMessageResp.setContent(Content);
//			return textMessageResp;
//		} else { // 标记用户上传了地理位置
//			CachedUtils.set(Constants.MEMKEY_WEIXIN_locationMessage
//					+ locationMessage.getFromUserName(), 10 * 60, "Y");
//		}
		// 微理赔处理,按照客户的openid 查询到了客户进入微理赔。
		if (claimsSessionManagement.isClaimsDeal(locationMessage
				.getFromUserName())) {
			String retMessage = claimsSessionManagement
					.messageProcessing(receiveMessage);
			textMessageResp.setContent(retMessage);
			return textMessageResp;
		}
		// TODO Auto-generated method stub
		return textMessageResp;
	}

	@Override
	protected void doAsyncExecute(LocationMessage requestMessage) {
		// TODO Auto-generated method stub

	}

}
