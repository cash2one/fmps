/**
 * 
 */
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
import weixin.guanjia.core.entity.message.req.ImageMessage;
import weixin.guanjia.core.entity.message.resp.BaseMessageResp;
import weixin.guanjia.core.entity.message.resp.TextMessageResp;
import weixin.guanjia.core.util.WeixinUtil;
import weixin.guanjia.message.entity.ReceiveMessage;
import weixin.guanjia.message.service.ReceiveMessageServiceI;
import weixin.util.DateUtils;
import cn.com.fubon.handler.imp.AbstractMessageHandler;
import cn.com.fubon.util.Constants;
import cn.com.fubon.wechatClaims.service.ClaimsSessionManagement;

/**
 * 图片消息处理器
 * 
 * @author pollux
 *
 */
@Service("imageMessageHandler")
@Transactional
public class ImageMessageHandler extends AbstractMessageHandler<ImageMessage> {

	@Resource
	private ClaimsSessionManagement claimsSessionManagement;
	@Resource
	private ReceiveMessageServiceI receiveMessageService;
	@Resource
	private WeixinAccountServiceI weixinAccountService;
	
	@Override
	protected ImageMessage convert(Map<String, String> requestMap) {
		// TODO Auto-generated method stub
		ImageMessage imageMessage = new ImageMessage();
		imageMessage.setPicUrl(requestMap.get("PicUrl"));
		imageMessage
				.setCreateTime(Long.parseLong(requestMap.get("CreateTime")));
		imageMessage.setFromUserName(requestMap.get("FromUserName"));
		imageMessage.setMsgId(Long.parseLong(requestMap.get("MsgId")));
		imageMessage.setMsgType(requestMap.get("MsgType"));
		imageMessage.setToUserName(requestMap.get("ToUserName"));
		imageMessage.setMediaId(requestMap.get("MediaId"));
		return imageMessage;
	}

	@Override
	protected BaseMessageResp doExecute(ImageMessage imageMessage)
			throws Exception {

		TextMessageResp textMessageResp = new TextMessageResp();
		textMessageResp.setToUserName(imageMessage.getFromUserName());
		textMessageResp.setFromUserName(imageMessage.getToUserName());
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
		receiveMessage.setPicUrl(imageMessage.getPicUrl());
		Timestamp temp = Timestamp.valueOf(DateUtils
				.getDate("yyyy-MM-dd HH:mm:ss"));
		receiveMessage.setCreateTime(temp);
		receiveMessage.setFromUserName(imageMessage.getFromUserName());
		receiveMessage.setToUserName(imageMessage.getToUserName());
		receiveMessage.setMsgId(Long.toString(imageMessage.getMsgId()));
		receiveMessage.setMsgType(imageMessage.getMsgType());
		receiveMessage.setAccount(weixinAccountService
				.findByToUsername(imageMessage.getToUserName()));
		receiveMessage.setMediaId(imageMessage.getMediaId());
		this.receiveMessageService.save(receiveMessage);
		
		WeixinUtil.nonBlockingDownloadMedia(imageMessage.getMediaId());
		
		// 微理赔处理,按照客户的openid 查询到了客户进入微理赔。
		if (claimsSessionManagement
				.isClaimsDeal(imageMessage.getFromUserName())) {
			String retMessage = claimsSessionManagement
					.messageProcessing(receiveMessage);
			textMessageResp.setContent(retMessage);
			return textMessageResp;
		}
		// TODO Auto-generated method stub
		return textMessageResp;
	}

	@Override
	protected void doAsyncExecute(ImageMessage requestMessage) {
		// TODO Auto-generated method stub

	}

}
