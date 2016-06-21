package weixin.popular.api;

import java.nio.charset.Charset;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.jboss.logging.Logger;
import org.jeecgframework.core.common.service.CommonService;
import org.jeecgframework.core.util.ApplicationContextUtil;
import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.popular.bean.Article;
import weixin.popular.bean.BaseResult;
import weixin.popular.bean.Media;
import weixin.popular.bean.MessageSendResult;
import weixin.popular.bean.Uploadvideo;
import weixin.popular.bean.massmessage.MassMessage;
import weixin.popular.bean.message.Message;
import weixin.popular.bean.templatemessage.TemplateMessage;
import weixin.popular.bean.templatemessage.TemplateMessageItem;
import weixin.popular.bean.templatemessage.TemplateMessageResult;
import weixin.popular.client.JsonResponseHandler;
import weixin.popular.util.JsonUtil;
import cn.com.fubon.bo.wxtemplatemessage.entity.WeiXinTemplate;
import cn.com.fubon.bo.wxtemplatemessage.entity.WeiXinTemplateMessageRecord;
import cn.com.fubon.bo.wxtemplatemessage.entity.WeiXinTemplateMessageSendLog;
import cn.com.fubon.util.Constants;

/**
 * 当用户主动发消息给公众号的时候
 * （包括发送信息、点击自定义菜单click事件、订阅事件、扫描二维码事件、支付成功事件、用户维权），
 * 微信将会把消息数据推送给开发者，
 * 开发者在一段时间内（目前修改为48小时）可以调用客服消息接口，
 * 通过POST一个JSON数据包来发送消息给普通用户，
 * 在48小时内不限制发送次数。
 * 此接口主要用于客服等有人工消息处理环节的功能，方便开发者为用户提供更加优质的服务。
 * 
 * @author LiYi
 *
 */
public class MessageAPI extends BaseAPI{
	Logger logger = Logger.getLogger(MessageAPI.class);

	/**
	 * 消息发送
	 * 
	 * @param access_token
	 * @param messageJson
	 * @return
	 */
	public BaseResult messageCustomSend(String access_token,String messageJson){
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/cgi-bin/message/custom/send")
				.addParameter("access_token",access_token)
				.setEntity(
						new StringEntity(messageJson,Charset.forName("utf-8")))
				.build();
		return localHttpClient.execute(httpUriRequest,
				JsonResponseHandler.createResponseHandler(BaseResult.class));
	}

	/**
	 * 消息发送
	 * 
	 * @param access_token
	 * @param message
	 * @return
	 */
	public BaseResult messageCustomSend(String access_token,Message message){
		String str = JsonUtil.toJSONString(message);
		return messageCustomSend(access_token,str);
	}

	/**
	 * 高级群发 构成 MassMPnewsMessage 对象的前置请求接口
	 * 
	 * @param access_token
	 * @param articles
	 *            图文信息 1-10 个
	 * @return
	 */
	public Media mediaUploadnews(String access_token,List<Article> articles){
		String str = JsonUtil.toJSONString(articles);
		String messageJson = "{\"articles\":" + str + "}";
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/cgi-bin/media/uploadnews")
				.addParameter("access_token",access_token)
				.setEntity(
						new StringEntity(messageJson,Charset.forName("utf-8")))
				.build();
		return localHttpClient.execute(httpUriRequest,
				JsonResponseHandler.createResponseHandler(Media.class));
	}

	/**
	 * 高级群发 构成 MassMPvideoMessage 对象的前置请求接口
	 * 
	 * @param access_token
	 * @param uploadvideo
	 * @return
	 */
	public Media mediaUploadvideo(String access_token,Uploadvideo uploadvideo){
		String messageJson = JsonUtil.toJSONString(uploadvideo);
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(MEDIA_URI + "/cgi-bin/media/uploadvideo")
				.addParameter("access_token",access_token)
				.setEntity(
						new StringEntity(messageJson,Charset.forName("utf-8")))
				.build();
		return localHttpClient.execute(httpUriRequest,
				JsonResponseHandler.createResponseHandler(Media.class));
	}

	/**
	 * 高级群发接口 根据分组进行群发
	 * 
	 * @param access_token
	 * @param messageJson
	 * @return
	 */
	public MessageSendResult messageMassSendall(String access_token,
			String messageJson){
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/cgi-bin/message/mass/sendall")
				.addParameter("access_token",access_token)
				.setEntity(
						new StringEntity(messageJson,Charset.forName("utf-8")))
				.build();
		return localHttpClient.execute(httpUriRequest,JsonResponseHandler
				.createResponseHandler(MessageSendResult.class));
	}

	/**
	 * 高级群发接口 根据分组进行群发
	 * 
	 * @param access_token
	 * @param massMessage
	 * @return
	 */
	public MessageSendResult messageMassSendall(String access_token,
			MassMessage massMessage){
		String str = JsonUtil.toJSONString(massMessage);
		return messageMassSendall(access_token,str);
	}

	/**
	 * 高级群发接口 根据OpenID列表群发
	 * 
	 * @param access_token
	 * @param messageJson
	 * @return
	 */
	public MessageSendResult messageMassSend(String access_token,
			String messageJson){
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/cgi-bin/message/mass/send")
				.addParameter("access_token",access_token)
				.setEntity(
						new StringEntity(messageJson,Charset.forName("utf-8")))
				.build();
		return localHttpClient.execute(httpUriRequest,JsonResponseHandler
				.createResponseHandler(MessageSendResult.class));
	}

	/**
	 * 高级群发接口 根据OpenID列表群发
	 * 
	 * @param access_token
	 * @param massMessage
	 * @return
	 */
	public MessageSendResult messageMassSend(String access_token,
			MassMessage massMessage){
		String str = JsonUtil.toJSONString(massMessage);
		return messageMassSend(access_token,str);
	}

	/**
	 * 高级群发接口 删除群发
	 * 请注意，只有已经发送成功的消息才能删除删除消息只是将消息的图文详情页失效，
	 * 已经收到的用户，还是能在其本地看到消息卡片。
	 * 另外，删除群发消息只能删除图文消息和视频消息，其他类型的消息一经发送，无法删除。
	 * 
	 * @param access_token
	 * @param msgid
	 * @return
	 */
	public BaseResult messageMassDelete(String access_token,String msgid){
		String messageJson = "{\"msgid\":" + msgid + "}";
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/cgi-bin/message/mass/delete")
				.addParameter("access_token",access_token)
				.setEntity(
						new StringEntity(messageJson,Charset.forName("utf-8")))
				.build();
		return localHttpClient.execute(httpUriRequest,
				JsonResponseHandler.createResponseHandler(BaseResult.class));
	}

	/**
	 * 重构后发送模板消息
	 * 
	 * @author fangfang.guo
	 * @date 20150908
	 * @return 返回WeiXinTemplateMessageRecord.getId()
	 */
	public String sendTemplateMessage(String templateMessageId,
			String url,
			String toUser,Map<String,String> messageParams){
		LinkedHashMap<String,TemplateMessageItem> messageData = new LinkedHashMap<String,TemplateMessageItem>();
		for(String key : messageParams.keySet()){
			TemplateMessageItem item = new TemplateMessageItem(
					messageParams.get(key),
					Constants.TEMPLATE_MESSAGE_ITEM_COLOR);
			messageData.put(key,item);
		}

		return sendTemplateMessage(templateMessageId,url,toUser,messageData);
	}

	/**
	 * 重构后发送模板消息
	 * 
	 * @author fangfang.guo
	 * @date 20150907
	 * @return 返回WeiXinTemplateMessageRecord.getId()
	 */
	public String sendTemplateMessage(String templateMessageId,
			String url,
			String toUser,
			LinkedHashMap<String,TemplateMessageItem> templateMessageData){

		TemplateMessage templateMessage = new TemplateMessage();

		CommonService commonService = (CommonService)ApplicationContextUtil
				.getContext().getBean("commonService");
		WeiXinTemplate weiXinTemplate = commonService.findUniqueByProperty(
				WeiXinTemplate.class,"id",templateMessageId);
		logger.info("weixin_template.weixin_template_id==>"
				+ weiXinTemplate.getTemplateId());

		templateMessage.setTemplate_id(weiXinTemplate.getTemplateId());
		templateMessage.setUrl(url);
		templateMessage.setTopcolor(Constants.TEMPLATE_MESSAGE_ITEM_TOPCOLOR);
		templateMessage.setData(templateMessageData);
		templateMessage.setTouser(toUser);

		String messageJson = JsonUtil.toJSONString(templateMessage);

		TemplateMessageResult templateMessageResult = realSendTemplateMessage(messageJson);

		return saveMessageRecordAndLog(templateMessage,weiXinTemplate,
				messageJson,
				templateMessageResult);
	}

	public TemplateMessageResult realSendTemplateMessage(String messageJson){
		WeixinAccountServiceI weixinAccountService = (WeixinAccountServiceI)ApplicationContextUtil
				.getContext().getBean("weixinAccountService");
		String accessToken = weixinAccountService
				.getAccessTokenFromAccountEntity();
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/cgi-bin/message/template/send")
				.addParameter("access_token",accessToken)
				.setEntity(
						new StringEntity(messageJson,Charset.forName("utf-8")))
				.build();

		TemplateMessageResult templateMessageResult = localHttpClient.execute(
				httpUriRequest,JsonResponseHandler
						.createResponseHandler(TemplateMessageResult.class));

		logger.info("sendTemplateMessage invoked errcode==>"
				+ templateMessageResult.getErrcode() + " errmsg==>"
				+ templateMessageResult.getErrmsg() + " msgid==>"
				+ templateMessageResult.getMsgid());

		return templateMessageResult;
	}

	/**
	 * @param templateMessage
	 * @param weiXinTemplate
	 * @param messageJson
	 * @param templateMessageResult
	 * @return 返回WeiXinTemplateMessageRecord.getId()
	 */
	private String saveMessageRecordAndLog(TemplateMessage templateMessage,
			WeiXinTemplate weiXinTemplate,String messageJson,
			TemplateMessageResult templateMessageResult){
		WeixinAccountServiceI weixinAccountService = (WeixinAccountServiceI)ApplicationContextUtil
				.getContext().getBean("weixinAccountService");
		List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService
				.findValidWeixinAccounts();
		WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList
				.get(0);
		CommonService commonService = (CommonService)ApplicationContextUtil
				.getContext().getBean("commonService");
		// 入库weixin_template_mesasge_record,weixin_template_message_send_log
		WeiXinTemplateMessageRecord record = new WeiXinTemplateMessageRecord();
		record.setTouser(templateMessage.getTouser());
		record.setMessageContent(messageJson);
		record.setTemplate(weiXinTemplate);
		record.setAccount(weixinAccountEntity);
		record.setSendCount(1);
		record.setErrCode(templateMessageResult.getErrcode());
		record.setErrMsg(templateMessageResult.getErrmsg());
		record.setCreateTime(new Date());
		commonService.save(record);

		WeiXinTemplateMessageSendLog sendLog = new WeiXinTemplateMessageSendLog();
		sendLog.setCreateTime(new Date());
		sendLog.setErrCode(templateMessageResult.getErrcode());
		sendLog.setErrMsg(templateMessageResult.getErrmsg());
		sendLog.setMessageId(templateMessageResult.getMsgid() != null ? templateMessageResult
				.getMsgid().toString() : null);
		sendLog.setTouser(templateMessage.getTouser());
		sendLog.setTemplateMessageRecord(record);
		commonService.save(sendLog);

		return record.getId();
	}
}
