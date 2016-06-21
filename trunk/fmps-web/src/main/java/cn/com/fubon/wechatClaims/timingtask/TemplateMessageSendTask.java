package cn.com.fubon.wechatClaims.timingtask;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.service.CommonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import weixin.popular.api.MessageAPI;
import weixin.popular.bean.templatemessage.TemplateMessage;
import weixin.popular.bean.templatemessage.TemplateMessageResult;
import weixin.popular.util.JsonUtil;
import cn.com.fubon.bo.wxtemplatemessage.entity.WeiXinTemplateMessageRecord;
import cn.com.fubon.bo.wxtemplatemessage.entity.WeiXinTemplateMessageSendLog;
import cn.com.fubon.util.Constants;

@Service("templateMessageSendTask")
@Transactional
public class TemplateMessageSendTask{

	private static final Logger logger = Logger
			.getLogger(TemplateMessageSendTask.class);

	@Resource
	private CommonService commonService;

	public void sendTemplateMessage() throws Exception{
		logger.info("templateMessageSendTask begin");
		List<WeiXinTemplateMessageRecord> weiXinTemplateMessageRecordList = this
				.getWeiXinTemplateMessageRecordList();
		for(WeiXinTemplateMessageRecord weiXinTemplateMessageRecord : weiXinTemplateMessageRecordList){
			String messageJson = weiXinTemplateMessageRecord
					.getMessageContent();
			// 消息重发
			TemplateMessageResult templateMessageResult = new MessageAPI()
					.realSendTemplateMessage(messageJson);

			String msgId = templateMessageResult.getMsgid() != null ? templateMessageResult
					.getMsgid().toString() : null;
			logger.info("templateMessageSendTask msgId==>" + msgId);
			weiXinTemplateMessageRecord
					.setSendCount(weiXinTemplateMessageRecord.getSendCount() + 1);

			TemplateMessage templateMessage = JsonUtil.parseObject(messageJson,
					TemplateMessage.class);
			WeiXinTemplateMessageSendLog sendLog = new WeiXinTemplateMessageSendLog();
			sendLog.setTouser(templateMessage.getTouser());
			sendLog.setTemplateMessageRecord(weiXinTemplateMessageRecord);
			sendLog.setCreateTime(new Date());
			sendLog.setErrCode(templateMessageResult.getErrcode());
			sendLog.setErrMsg(templateMessageResult.getErrmsg());
			sendLog.setMessageId(msgId);

			commonService.saveOrUpdate(weiXinTemplateMessageRecord);
			commonService.save(sendLog);
		}
	}

	/**
	 * 获取送达状态为由于其他原因失败 failed: system failed 的或者接口调用失败的,且发送次数没有达到最大次数的模板消息记录
	 * 
	 * @return List<WeiXinTemplateMessageRecord>
	 */
	private List<WeiXinTemplateMessageRecord> getWeiXinTemplateMessageRecordList(){
		String hql = "from WeiXinTemplateMessageRecord where (status=? or errCode != ?) and sendCount<?";
		return commonService.findHql(hql,
				Constants.TEMPLATE_MESSAGE_SYSTEM_FAILED,
				Constants.TEMPLATE_MESSAGE_WEIXIN_INVOKED_SUCCESS,
				Constants.TEMPLATE_MESSAGE_MAX_SEND_COUNT);
	}

}
