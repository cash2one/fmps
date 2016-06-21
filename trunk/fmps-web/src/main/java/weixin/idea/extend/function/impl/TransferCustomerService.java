package weixin.idea.extend.function.impl;

import org.apache.log4j.Logger;
import org.jeecgframework.core.util.MyBeanUtils;

import cn.com.fubon.handler.imp.message.EventMessageHandler;
import jodd.bean.BeanUtil;
import weixin.guanjia.core.entity.message.resp.BaseMessageResp;
import weixin.guanjia.core.entity.message.resp.TextMessageResp;
import weixin.idea.extend.function.KeyServiceI;

public class TransferCustomerService implements KeyServiceI {
	private static final Logger logger = Logger
			.getLogger(TransferCustomerService.class);

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String excute(String content, TextMessageResp defaultMessage){
		return null;
	}

	@Override
	public BaseMessageResp excuteReturnBaseMessage(String content,
			TextMessageResp defaultMessage) {	
		logger.info("如下用户已经输入关键字进入人工客服==>"+defaultMessage.getFromUserName()); 
		BaseMessageResp baseMessageResp=new BaseMessageResp();
	 	   try {
			MyBeanUtils.copyBean2Bean(baseMessageResp,defaultMessage);
		    } catch (Exception e) {
		    	logger.info("MyBeanUtils.copyBean2Bean出错了"); 
		    	e.printStackTrace();			
		       }
	 	       baseMessageResp.setMsgType("transfer_customer_service"); 		
		return baseMessageResp;
		 
	}

}
