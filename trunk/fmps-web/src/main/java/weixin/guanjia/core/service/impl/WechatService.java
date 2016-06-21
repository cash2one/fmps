package weixin.guanjia.core.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.http.HttpServletRequest;

import jodd.util.StringUtil;

import org.apache.log4j.Logger;
import org.jeecgframework.core.util.LogUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.guanjia.base.service.SubscribeServiceI;
import weixin.guanjia.base.service.WeixinExpandconfigServiceI;
import weixin.guanjia.core.entity.message.resp.Article;
import weixin.guanjia.core.entity.message.resp.BaseMessageResp;
import weixin.guanjia.core.entity.message.resp.NewsMessageResp;
import weixin.guanjia.core.entity.message.resp.TextMessageResp;
import weixin.guanjia.core.util.MessageUtil;
import weixin.guanjia.message.dao.TextTemplateDao;
import weixin.guanjia.message.service.AutoResponseServiceI;
import weixin.guanjia.message.service.NewsItemServiceI;
import weixin.guanjia.message.service.NewsTemplateServiceI;
import weixin.guanjia.message.service.TextTemplateServiceI;
import weixin.util.DateUtils;
import cn.com.fubon.handler.MessageHandler;
import cn.com.fubon.transaction.entity.TransactionRecord;
import cn.com.fubon.transaction.service.ITransactionRecordService;
import cn.com.fubon.util.CachedUtils;
import cn.com.fubon.util.Constants;
import cn.com.fubon.webservice.WsConstants;

@Service("wechatService")
public class WechatService {
	@Autowired
	private TextTemplateDao textTemplateDao;
	@Autowired
	private AutoResponseServiceI autoResponseService;
	@Autowired
	private TextTemplateServiceI textTemplateService;
	@Autowired
	private NewsTemplateServiceI newsTemplateService;

	@Autowired
	private NewsItemServiceI newsItemService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private SubscribeServiceI subscribeService;
	@Autowired
	private WeixinExpandconfigServiceI weixinExpandconfigService;
	@Autowired
	private WeixinAccountServiceI weixinAccountService;
	@Autowired
	private ITransactionRecordService transactionRecordService;
	private ExecutorService exec = Executors.newFixedThreadPool(5); // 默认开启5个线程
	final Logger logger = Logger.getLogger(WechatService.class);

	public String coreService(HttpServletRequest request) {

		String responseXML = "";
		String responseMessage = "";
		String resquestXML = "";
		// 默认返回的文本消息内容
		String respContent = "请求处理异常，请稍候尝试！";
		String unique = ""; // 关键字排重
		Timestamp reqDateTime = Timestamp.valueOf(DateUtils
				.getDate("yyyy-MM-dd HH:mm:ss.SSS"));
		String signature = request.getParameter("signature");
		try {
			// xml请求解析
			Map<String, String> requestMap = MessageUtil.parseXml(request);
			resquestXML = requestMap.get("rawMessage");
			String msgId = requestMap.get("MsgId");
			// 消息类型
			String msgType = requestMap.get("MsgType");
			// 发送方帐号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			// 公众帐号
			String toUserName = requestMap.get("ToUserName");
			// 消息内容
			String content = requestMap.get("Content");
			logger.info("------------微信客户端发送请求---------------------   |   fromUserName:"
					+ fromUserName
					+ "   |   ToUserName:"
					+ toUserName
					+ "   |   msgType:"
					+ msgType
					+ "   |   msgId:"
					+ msgId
					+ "   |   content:" + content);

			if (StringUtil.isEmpty(msgId)) {
				unique = requestMap.get("FromUserName")
						+ requestMap.get("CreateTime");
			} else {
				unique = msgId;
			}

			if (this.isRetransmission(unique)) {
				logger.info("微信传输过来的msgId重复========>：" + unique);
			} else {
				this.saveCachedUnique(unique);
				// 没有重复记录的做法
				MessageHandler messageHandler = MessageUtil
						.getActualMessageHandler(msgType);
				BaseMessageResp resp = messageHandler.execute(requestMap);
				// 报文处理后系统时间
				Timestamp respDateTime = Timestamp.valueOf(DateUtils
						.getDate("yyyy-MM-dd HH:mm:ss.SSS"));
				if (resp != null) { // 如果 messageHandler 返回NULL ,就回复空字符串
					responseXML = MessageUtil.messageToXml(resp);
				}
				if (resp instanceof TextMessageResp) {// 如果回复为文本且内容为空，直接回复空字符窜
					if (StringUtil.isEmpty(((TextMessageResp) resp)
							.getContent())) {
						responseXML = "";
					} else {
						responseMessage = ((TextMessageResp) resp).getContent();
					}

				}
				exec.execute(new WechatXmlThread(unique, resquestXML,
						responseXML, responseMessage, reqDateTime,
						respDateTime, signature));
			}
		} catch (Exception e) {
			LogUtil.info("process message failture on coreService ====> "
					+ e.getMessage());
			e.printStackTrace();
		}
		LogUtil.info("response message to wechat server ===>\n" + responseXML);
		return responseXML;
	}

	/**
	 * 根据 unique 查询Cached,数据库，判断是否有重复记录，返回TRUE为有从夫记录
	 * 
	 * @param unique
	 * @return
	 */

	private boolean isRetransmission(String unique) {
		logger.debug("getExpireSet,unique=========>" + unique);
		boolean flag = false;
		String CachedValues = (String) CachedUtils
				.get(Constants.MEMKEY_WEIXIN_unique + unique);
		if ("1".equals(CachedValues)) {
			logger.info("isRetransmissionCached========= 数据重复   ===> " + unique);
			flag = true;
		} 
	//从数据库查询比较耗性能，先不从数据库查询	
//		else {
//			int recordNumber = transactionRecordService
//					.queryTotalBytransactionId(unique);
//			logger.info("isRetransmissionMysql========= 数据库记录条数   ===> "
//					+ recordNumber);
//			flag = recordNumber > 0;
//		}
		return flag;
	}

	/**
	 * 为排重，微信服务器传过来的报文，存入排重ID到cache.保存时间1分钟
	 * 
	 * @param unique
	 */
	private void saveCachedUnique(String unique) {
		logger.debug("saveCachedUnique,unique=========>" + unique);
		CachedUtils.set(Constants.MEMKEY_WEIXIN_unique + unique, 60, "1");
	}

	public class WechatXmlThread implements Runnable {
		private String transaction_id = "";
		private String requestXML = "";
		private String responseXML = "";
		private String responseMessage = "";
		private Timestamp reqDatetime;
		private Timestamp respDatetime;
		private String signature;

		public WechatXmlThread(String transaction_id, String requestXML,
				String responseXML, String responseMessage,
				Timestamp reqDatetime, Timestamp respDatetime, String signature) {
			this.transaction_id = transaction_id;
			this.requestXML = requestXML;
			this.responseXML = responseXML;
			this.responseMessage = responseMessage;
			this.reqDatetime = reqDatetime;
			this.respDatetime = respDatetime;
			this.signature = signature;
		}

		public void save() {
			List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService
					.findValidWeixinAccounts();
			WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList
					.get(0);
			Timestamp dateTime = Timestamp.valueOf(DateUtils
					.getDate("yyyy-MM-dd HH:mm:ss"));
			TransactionRecord transactionRecord = new TransactionRecord();
			transactionRecord
					.setFromuser(WsConstants.REQUEST_HEAD_KEY_SERVER_CODE_WECHAT);
			transactionRecord
					.setTouser(WsConstants.REQUEST_HEAD_KEY_SERVER_CODE);
			transactionRecord
					.setTransactionType(WsConstants.REQUEST_HEAD_KEY_TRANSATION_CODE_30);
			transactionRecord.setAccount(weixinAccountEntity);
			transactionRecord.setTransactionId(transaction_id);
			transactionRecord.setInternalRequest(requestXML);
			transactionRecord.setExternalRequest(requestXML);
			transactionRecord.setInternalResponse(responseMessage);
			transactionRecord.setExternalResponse(responseXML);
			transactionRecord.setCreateTime(dateTime);
			transactionRecord.setReqDateTime(reqDatetime);
			transactionRecord.setRespDateTime(respDatetime);
			transactionRecord.setTransactionFormat("XML");
			transactionRecord.setSignature(signature);
			transactionRecordService.save(transactionRecord);
		}

		@Override
		public void run() {
			try {
				this.save();
			} catch (Exception e) {
				logger.error("save wechat xml failure, cause by :"
						+ e.getMessage());
				e.printStackTrace();
			}
			logger.info("save wechat xml success。signature ===> " + signature);
		}
	}

	public static void main(String[] args) {
		NewsMessageResp resp = new NewsMessageResp();
		resp.setArticleCount(3);
		resp.setFromUserName("fromusername");
		resp.setToUserName("tousername");
		List<Article> articles = new ArrayList<Article>();
		Article article = new Article();
		article.setTitle("title");
		article.setPicUrl("picurl");
		article.setDescription("desc");
		article.setUrl("url");
		articles.add(article);
		resp.setArticles(articles);
		String result = MessageUtil.messageToXml(resp);
		System.out.println(result);
	}

}
