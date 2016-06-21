/**
 * 
 */
package cn.com.fubon.handler.imp.message;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.jeecgframework.core.util.LogUtil;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.PropertiesUtil;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.oConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.guanjia.base.entity.WeixinExpandconfigEntity;
import weixin.guanjia.base.service.WeixinExpandconfigServiceI;
import weixin.guanjia.core.entity.message.req.TextMessage;
import weixin.guanjia.core.entity.message.resp.Article;
import weixin.guanjia.core.entity.message.resp.BaseMessageResp;
import weixin.guanjia.core.entity.message.resp.NewsMessageResp;
import weixin.guanjia.core.entity.message.resp.TextMessageResp;
import weixin.guanjia.message.dao.TextTemplateDao;
import weixin.guanjia.message.entity.AutoResponse;
import weixin.guanjia.message.entity.NewsItem;
import weixin.guanjia.message.entity.ReceiveMessage;
import weixin.guanjia.message.entity.TextTemplate;
import weixin.guanjia.message.service.AutoResponseServiceI;
import weixin.guanjia.message.service.CustomerMessageService;
import weixin.guanjia.message.service.NewsItemServiceI;
import weixin.guanjia.message.service.NewsTemplateServiceI;
import weixin.guanjia.message.service.ReceiveMessageServiceI;
import weixin.idea.extend.function.KeyServiceI;
import weixin.util.DateUtils;
import weixin.util.WeiXinConstants;
import cn.com.fubon.handler.imp.AbstractMessageHandler;
import cn.com.fubon.util.Constants;
import cn.com.fubon.util.FBStringUtils;
import cn.com.fubon.wechatClaims.service.ClaimsSessionManagement;

/**
 * 文本消息处理器
 * 
 * @author pollux
 *
 */
@Service("textMessageHandler")
@Transactional
public class TextMessageHandler extends AbstractMessageHandler<TextMessage> {

	@Autowired
	private ReceiveMessageServiceI receiveMessageService;
	@Autowired
	private WeixinAccountServiceI weixinAccountService;
	@Autowired
	private AutoResponseServiceI autoResponseService;
	@Autowired
	private TextTemplateDao textTemplateDao;
	@Autowired
	private WeixinExpandconfigServiceI weixinExpandconfigService;
	@Autowired
	private NewsItemServiceI newsItemService;
	@Autowired
	private NewsTemplateServiceI newsTemplateService;
	@Resource
	private ClaimsSessionManagement claimsSessionManagement;
	ResourceBundle bundler = ResourceBundle.getBundle("sysConfig");
	String sys_accountId;
	private static final Logger logger = Logger
			.getLogger(TextMessageHandler.class);

	@Override
	protected TextMessage convert(Map<String, String> requestMap)
			throws IllegalAccessException, InvocationTargetException {

		List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService
				.findValidWeixinAccounts();
		WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList
				.get(0);
		sys_accountId = weixinAccountEntity.getId();
		// sys_accountId =
		// weixinAccountService.findByToUsername(requestMap.get("ToUserName")).getId();
		TextMessage textMessage = new TextMessage();
		MyBeanUtils.copyMap2Bean(textMessage, requestMap);
		textMessage.setContent(requestMap.get("Content"));
		textMessage.setCreateTime(Long.parseLong(requestMap.get("CreateTime")));
		textMessage.setFromUserName(requestMap.get("FromUserName"));
		textMessage.setMsgId(Long.parseLong(requestMap.get("MsgId")));
		textMessage.setMsgType(requestMap.get("MsgType"));
		textMessage.setToUserName(requestMap.get("ToUserName"));
		return textMessage;
	}

	@Override
	protected BaseMessageResp doExecute(TextMessage textMessage)
			throws Exception {
		// 构造默认返回对象
		TextMessageResp textMessageResp = new TextMessageResp();
		textMessageResp.setToUserName(textMessage.getFromUserName());
		textMessageResp.setFromUserName(textMessage.getToUserName());
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
		// =================================================================================================================
		// 保存接收到的信息
		ReceiveMessage receiveMessage = new ReceiveMessage();
		receiveMessage
				.setContent(this.conversionEmoji(textMessage.getContent()));
		Timestamp temp = Timestamp.valueOf(DateUtils
				.getDate("yyyy-MM-dd HH:mm:ss"));
		receiveMessage.setCreateTime(temp);
		receiveMessage.setFromUserName(textMessage.getFromUserName());
		receiveMessage.setToUserName(textMessage.getToUserName());
		receiveMessage.setMsgId(Long.toString(textMessage.getMsgId()));
		receiveMessage.setMsgType(textMessage.getMsgType());
		receiveMessage.setResponse("0");
		receiveMessage.setAccount(weixinAccountService
				.findByToUsername(textMessage.getToUserName()));
		this.receiveMessageService.save(receiveMessage);
		
		// 双11活动-Uber优惠码
		if(textMessage.getContent().contains("优惠码")){
			textMessageResp.setContent("uber优惠码为：富邦保险");
			return textMessageResp;
		}
		
		// 微理赔处理,按照客户的openid 查询到了客户进入微理赔，或客户输入了手机号码，进入微理赔处理。
		if (claimsSessionManagement.isClaimsDeal(textMessage.getFromUserName())
				|| FBStringUtils.checkMobile(textMessage.getContent())) {
			String retMessage = claimsSessionManagement
					.messageProcessing(receiveMessage);
			textMessageResp.setContent(retMessage);
			return textMessageResp;
		}

		// =================================================================================================================
		// Step.1 判断关键字信息中是否管理该文本内容。有的话优先采用数据库中的回复
		LogUtil.info("------------微信客户端发送请求--------------Step.1 判断关键字信息中是否管理该文本内容。有的话优先采用数据库中的回复---");
		AutoResponse autoResponse = findKey(textMessage.getContent());
		// 根据系统配置的关键字信息，返回对应的消息
		if (autoResponse != null) {
			String resMsgType = autoResponse.getMsgType();
			if (WeiXinConstants.REQ_MESSAGE_TYPE_TEXT.equals(resMsgType)) {
				// 根据返回消息key，获取对应的文本消息返回给微信客户端
				TextTemplate textTemplate = textTemplateDao.getTextTemplate(
						sys_accountId, autoResponse.getTemplateName());
				textMessageResp.setContent(textTemplate.getContent());
			} else if (WeiXinConstants.RESP_MESSAGE_TYPE_NEWS
					.equals(resMsgType)) {
				List<NewsItem> newsList = this.newsItemService.findByProperty(
						NewsItem.class, "newsTemplate.id",
						autoResponse.getResContent());
				/*
				 * NewsTemplate newsTemplate = newsTemplateService.getEntity(
				 * NewsTemplate.class, autoResponse.getResContent());
				 */
				List<Article> articleList = new ArrayList<Article>();
				for (NewsItem news : newsList) {
					Article article = new Article();
					article.setTitle(news.getTitle());
					article.setPicUrl(ResourceUtil.getDomain() + "/"
							+ news.getImagePath());
					String url = "";
					if (oConvertUtils.isEmpty(news.getUrl())) {
						url = ResourceUtil.getDomain()
								+ "/newsItemController.do?goContent&id="
								+ news.getId();
					} else {
						url = news.getUrl();
					}
					article.setUrl(url);
					article.setDescription(news.getDescription());
					articleList.add(article);
				}
				NewsMessageResp newsResp = new NewsMessageResp();
				newsResp.setCreateTime(new Date().getTime());
				newsResp.setFromUserName(textMessage.getToUserName());
				newsResp.setToUserName(textMessage.getFromUserName());
				newsResp.setArticleCount(newsList.size());
				newsResp.setArticles(articleList);
				return newsResp;
			}
		} else {
			// Step.2 通过微信扩展接口（支持二次开发，例如：翻译，天气）
			LogUtil.info("------------微信客户端发送请求--------------Step.2  通过微信扩展接口（支持二次开发，例如：翻译，天气）---");
			List<WeixinExpandconfigEntity> weixinExpandconfigEntityLst = weixinExpandconfigService
					.findByProperty(WeixinExpandconfigEntity.class, "keyword",
							textMessage.getContent());
			if (weixinExpandconfigEntityLst.size() != 0) {
				String className = weixinExpandconfigEntityLst.get(0)
						.getClassname();
				KeyServiceI keyService = (KeyServiceI) Class.forName(className)
						.newInstance();
				BaseMessageResp baseMessageResp = keyService
						.excuteReturnBaseMessage(textMessage.getContent(),
								textMessageResp);
				return baseMessageResp;
			}
		}
		return textMessageResp;
	}

	/**
	 * 遍历关键字管理中是否存在用户输入的关键字信息
	 * 
	 * @param content
	 * @return
	 */
	private AutoResponse findKey(String content) {
		String HQL = "from AutoResponse where keyWord like ? "
				+ " and accountid= ? ";
		// List<AutoResponse>
		// autoResponses=autoResponseService.findByQueryString(HQL);
		List<AutoResponse> autoResponses = autoResponseService.findHql(HQL,
				new Object[] { '%' + content + '%', sys_accountId });
		LogUtil.info("---------sys_accountId----关键字查询结果条数：----" + autoResponses != null ? autoResponses
				.size() : 0);
		return autoResponses.size() > 0 ? autoResponses.get(0) : null;
	}

	/**
	 * 执行异步调用消息，一般用于调用核心系统的webservice
	 */
	@Override
	protected void doAsyncExecute(TextMessage requestMessage) {

		CustomerMessageService cms;
		// cms.sendMessage(json)

	}

	protected String conversionEmoji(String Content) {
		int result = Content.indexOf("/");
		if (result >= 0) {
			logger.info("有表情需要处理");
			PropertiesUtil p = new PropertiesUtil("wechat_emotion.properties");
			Properties wp = p.getProperties();
			Set<Object> keySet = wp.keySet();
			Iterator<Object> it = keySet.iterator();
			while (it.hasNext()) {
				String key = (String) it.next();
				String value = wp.getProperty(key);
				Content = Content.replace(key, value);
			}
			Content = Content.length() > 500 ? "用户发送表情个数太多，超出显示范围" : Content;
		}
		return Content;
	}

}
