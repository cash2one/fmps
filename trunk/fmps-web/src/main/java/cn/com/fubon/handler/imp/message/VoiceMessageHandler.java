package cn.com.fubon.handler.imp.message;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.jeecgframework.core.util.ResourceUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.guanjia.core.entity.message.req.VoiceMessage;
import weixin.guanjia.core.entity.message.resp.BaseMessageResp;
import weixin.guanjia.core.entity.message.resp.TextMessageResp;
import weixin.guanjia.core.util.WeixinUtil;
import weixin.guanjia.message.entity.ReceiveMessage;
import weixin.guanjia.message.service.ReceiveMessageServiceI;
import weixin.util.DateUtils;
import cn.com.fubon.handler.imp.AbstractMessageHandler;
import cn.com.fubon.util.Constants;
import cn.com.fubon.wechatClaims.service.ClaimsSessionManagement;

@Service("voiceMessageHandler")
@Transactional
public class VoiceMessageHandler extends AbstractMessageHandler<VoiceMessage> {

	@Resource
	private ClaimsSessionManagement claimsSessionManagement;
	@Resource
	private ReceiveMessageServiceI receiveMessageService;
	@Resource
	private WeixinAccountServiceI weixinAccountService;
	final Logger logger = Logger.getLogger(VoiceMessageHandler.class);

	@Override
	protected VoiceMessage convert(Map<String, String> requestMap)
			throws Exception {
		// TODO Auto-generated method stub
		VoiceMessage voiceMessage = new VoiceMessage();
		voiceMessage
				.setCreateTime(Long.parseLong(requestMap.get("CreateTime")));
		voiceMessage.setFormat(requestMap.get("Format"));
		voiceMessage.setFromUserName(requestMap.get("FromUserName"));
		voiceMessage.setMediaId(requestMap.get("MediaId"));
		voiceMessage.setMsgId(Long.parseLong(requestMap.get("MsgId")));
		voiceMessage.setMsgType(requestMap.get("MsgType"));
		voiceMessage.setToUserName(requestMap.get("ToUserName"));
		voiceMessage.setRecognition(requestMap.get("Recognition"));
		return voiceMessage;
	}

	@Override
	protected BaseMessageResp doExecute(VoiceMessage voiceMessage)
			throws Exception {
		// TODO Auto-generated method stub

		TextMessageResp textMessageResp = new TextMessageResp();
		textMessageResp.setToUserName(voiceMessage.getFromUserName());
		textMessageResp.setFromUserName(voiceMessage.getToUserName());
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
		receiveMessage.setFromUserName(voiceMessage.getFromUserName());
		receiveMessage.setToUserName(voiceMessage.getToUserName());
		receiveMessage.setMsgId(Long.toString(voiceMessage.getMsgId()));
		receiveMessage.setMsgType(voiceMessage.getMsgType());
		receiveMessage.setAccount(weixinAccountService
				.findByToUsername(voiceMessage.getToUserName()));
		receiveMessage.setMediaId(voiceMessage.getMediaId());
		receiveMessage.setContent(voiceMessage.getRecognition());
		this.receiveMessageService.save(receiveMessage);
		
		WeixinUtil.nonBlockingDownloadMedia(voiceMessage.getMediaId());
		
		logger.info("===保存语音信息==receiveMessage.getId()=>"
				+ receiveMessage.getId());
		// 微理赔处理,按照客户的openid 查询到了客户进入微理赔。
		if (claimsSessionManagement
				.isClaimsDeal(voiceMessage.getFromUserName())) {
			String retMessage = claimsSessionManagement
					.messageProcessing(receiveMessage);
			textMessageResp.setContent(retMessage);
			return textMessageResp;
		}
		// TODO Auto-generated method stub
		return textMessageResp;
	}

	@Override
	protected void doAsyncExecute(VoiceMessage requestMessage) {
		// TODO Auto-generated method stub

	}

}
