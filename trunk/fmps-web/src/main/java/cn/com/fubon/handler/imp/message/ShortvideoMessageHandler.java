package cn.com.fubon.handler.imp.message;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.jeecgframework.core.util.ResourceUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.guanjia.core.entity.message.req.ShortvideoMessage;
import weixin.guanjia.core.entity.message.resp.BaseMessageResp;
import weixin.guanjia.core.entity.message.resp.TextMessageResp;
import weixin.guanjia.message.entity.ReceiveMessage;
import weixin.guanjia.message.service.ReceiveMessageServiceI;
import weixin.util.DateUtils;
import cn.com.fubon.handler.imp.AbstractMessageHandler;
import cn.com.fubon.util.Constants;
import cn.com.fubon.wechatClaims.service.ClaimsSessionManagement;

@Service("shortvideoMessageHandler")
@Transactional
public class ShortvideoMessageHandler extends
		AbstractMessageHandler<ShortvideoMessage> {
	@Resource
	private ClaimsSessionManagement claimsSessionManagement;
	@Resource
	private ReceiveMessageServiceI receiveMessageService;
	@Resource
	private WeixinAccountServiceI weixinAccountService;

	@Override
	protected ShortvideoMessage convert(Map<String, String> requestMap)
			throws Exception {
		// TODO Auto-generated method stub
		ShortvideoMessage shortvideoMessage = new ShortvideoMessage();
		shortvideoMessage.setCreateTime(Long.parseLong(requestMap
				.get("CreateTime")));
		shortvideoMessage.setFromUserName(requestMap.get("FromUserName"));
		shortvideoMessage.setMsgId(Long.parseLong(requestMap.get("MsgId")));
		shortvideoMessage.setMsgType(requestMap.get("MsgType"));
		shortvideoMessage.setToUserName(requestMap.get("ToUserName"));
		shortvideoMessage.setMediaId(requestMap.get("MediaId"));
		shortvideoMessage.setThumbMediaId(requestMap.get("ThumbMediaId"));
		return shortvideoMessage;
	}

	@Override
	protected BaseMessageResp doExecute(ShortvideoMessage shortvideoMessage)
			throws Exception {
		// TODO Auto-generated method stub
		TextMessageResp textMessageResp = new TextMessageResp();
		textMessageResp.setToUserName(shortvideoMessage.getFromUserName());
		textMessageResp.setFromUserName(shortvideoMessage.getToUserName());
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
		receiveMessage.setFromUserName(shortvideoMessage.getFromUserName());
		receiveMessage.setToUserName(shortvideoMessage.getToUserName());
		receiveMessage.setMsgId(Long.toString(shortvideoMessage.getMsgId()));
		receiveMessage.setMsgType(shortvideoMessage.getMsgType());
		receiveMessage.setAccount(weixinAccountService
				.findByToUsername(shortvideoMessage.getToUserName()));
		receiveMessage.setMediaId(shortvideoMessage.getMediaId());
		receiveMessage.setThumbMediaId(shortvideoMessage.getThumbMediaId());
		this.receiveMessageService.save(receiveMessage);
		// 微理赔处理,按照客户的openid 查询到了客户进入微理赔。
		if (claimsSessionManagement.isClaimsDeal(shortvideoMessage
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
	protected void doAsyncExecute(ShortvideoMessage requestMessage) {
		// TODO Auto-generated method stub

	}

}
