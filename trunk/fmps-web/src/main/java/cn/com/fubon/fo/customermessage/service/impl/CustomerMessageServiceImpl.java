/**
 * 
 */
package cn.com.fubon.fo.customermessage.service.impl;

import java.util.List;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.MyBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.guanjia.core.entity.message.customer.BaseCustomerMessage;
import weixin.guanjia.core.util.MessageUtil;
import weixin.guanjia.core.util.WeixinUtil;
import weixin.util.WeiXinConstants;
import cn.com.fubon.fo.customerbind.entity.WeiXinGzUserInfo;
import cn.com.fubon.fo.customermessage.entity.CustomerMessageRecord;
import cn.com.fubon.fo.customermessage.entity.CustomerMessageSendLog;
import cn.com.fubon.fo.customermessage.service.ICustomerMessageService;
import cn.com.fubon.util.Constants;

/**
 * 客服消息服务类
 * 
 * @author binbin.wang
 *
 */
@Service("customerMessageService")
@Transactional
public class CustomerMessageServiceImpl 
extends CommonServiceImpl implements ICustomerMessageService {

	private static final Logger logger = Logger.getLogger(CustomerMessageServiceImpl.class);
	
	private String accessTocken;
	
	@Autowired
	private WeixinAccountServiceI weixinAccountService;
	
	private String customerMessageEntryUrl;
	
	@Value("${CUSTOMER_MESSAGE_ENTRY_URL}")
	public void setCustomerMessageEntryUrl(String customerMessageEntryUrl) {
		this.customerMessageEntryUrl = customerMessageEntryUrl;
	}

	@Override
	public void sendMessage(CustomerMessageRecord customerMessageRecord, String newCustomerMessageEntryUrl) {
		//发送单笔客服消息
		try {
		//1、产生微信使用的客服消息
		BaseCustomerMessage customerMessage = MessageUtil.convertCustomerMessage(customerMessageRecord);
		//2、执行发送动作
		JSONObject jsonObj = doSendCustomerMessage(customerMessage, newCustomerMessageEntryUrl);
		//3、记录发送日志
	    int returnCode = Integer.parseInt(jsonObj.get(WeiXinConstants.WEIXIN_RETURN_JSON_KEY_ERROR_CODE).toString());
	    String returnMsg = jsonObj.get(WeiXinConstants.WEIXIN_RETURN_JSON_KEY_ERROR_MESSAGE).toString();
		insertCustomerMessageSendLog(customerMessageRecord, returnCode, returnMsg);
		
		//4、发送成功更新消息状态
		if(returnCode == WeiXinConstants.WEIXIN_RETURN_VALUE_OK) {	
			this.updateBySqlString("UPDATE weixin_customer_message_record t SET t.status = 1");//发送成功
		}else if (returnCode == WeiXinConstants.WEIXIN_RETURN_VALUE_SEND_MESSAGE_TIME_OUT) {	
			this.updateBySqlString("UPDATE weixin_customer_message_record t SET t.status = 2");//回复超时，取消发送
		}
		}catch(Exception e) {
			logger.info("send customer message failture。open_id:" + customerMessageRecord.getTouser());
			e.printStackTrace();
		}
	}
	
	@Override
	public List<CustomerMessageRecord> getNotSendedCustomerMessage(String weixinAccountId) {		
		return this.findHql("from CustomerMessageRecord cm where cm.status = 0 and cm.account.id=? order by cm.createTime asc", weixinAccountId);
	}
	
	/**
	 * 定时发送客服消息
	 */
	public void scheduleSendCustomerMessage() {

		List<WeixinAccountEntity> weixinAccountList = weixinAccountService.findValidWeixinAccounts();
		
		for(WeixinAccountEntity weixinAccount : weixinAccountList) {
			// 调用接口获取access_token
	        accessTocken = weixinAccountService.getAccessToken(weixinAccount);
	        String newCustomerMessageEntryUrl = customerMessageEntryUrl.replace("{ACCESS_TOKEN}",accessTocken);
			//logger.info("Access_Tocken:" + accessTocken);
		
			List<CustomerMessageRecord> customerMessageRecordList = this.getNotSendedCustomerMessage(weixinAccount.getId());
			for(CustomerMessageRecord customerMessageRecord : customerMessageRecordList) {
				this.sendMessage(customerMessageRecord, newCustomerMessageEntryUrl);
			}
		}
	}
	
	private JSONObject doSendCustomerMessage(BaseCustomerMessage customerMessage, String newCustomerMessageEntryUrl) {
		JSONObject jsonObj = JSONObject.fromObject(customerMessage);
		String jsonMessage = jsonObj.toString();
		
		logger.info("Send Customer Message:" + jsonMessage);
    	JSONObject jsonObject = WeixinUtil.httpRequest(newCustomerMessageEntryUrl, "POST", jsonMessage);
    	return jsonObject;
	}
	
	private void insertCustomerMessageSendLog(CustomerMessageRecord customerMessageRecord, int returnCode, String returnMsg) throws Exception {
				
		CustomerMessageSendLog cmSendLog = new CustomerMessageSendLog();
		MyBeanUtils.copyBean2Bean(cmSendLog, customerMessageRecord);
		
		cmSendLog.setCustomerMessageRecord(customerMessageRecord);
		cmSendLog.setReturnCode(returnCode);
		cmSendLog.setReturnMsg(returnMsg);
		
		this.save(cmSendLog);
	}
}
