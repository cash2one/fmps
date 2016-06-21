/**
 * 
 */
package cn.com.fubon.fo.customermessage.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import jodd.bean.BeanUtil;
import jodd.datetime.JDateTime;

import org.apache.commons.collections.map.HashedMap;
import org.jeecgframework.core.util.MyBeanUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import weixin.guanjia.core.entity.message.req.TextMessage;
import cn.com.fubon.fo.customermessage.service.ICustomerMessageService;
import cn.com.fubon.webservice.MainWebServiceClient;
import cn.com.fubon.webservice.entity.request.FbWSRequest;
import cn.com.fubon.webservice.entity.request.FbWeixinBindRequestBody;
import cn.com.fubon.webservice.entity.request.RequestHead;

/**
 * 
 * @author binbin.wang
 *
 */

@Scope("prototype")
@Controller
@RequestMapping("/fo/customerMessageController")
public class CustomerMessageController {

	private ICustomerMessageService customerMessageService;
	
	
	@Resource(name="coreosWSClientWeixinBind")
	private MainWebServiceClient wsClient;
	
	@Autowired
	public void setCustomerMessageService(
			ICustomerMessageService customerMessageService) {
		this.customerMessageService = customerMessageService;
	}

	
	/**
	 * <a></a>
	 * 
	 * @return
	 */
	
	@RequestMapping(params = "add")
	public String add(){
		try {
			JDateTime jnow = new JDateTime(new Date());
			
			RequestHead requestHead = new RequestHead();
			requestHead.setClientCode("100");
			requestHead.setServerCode("FMPS");
			requestHead.setTranscationCode("1");
			requestHead.setTranscationDate(jnow.toString("YYYYMMDD"));
			requestHead.setTranscationTime(jnow.toString("hhmmss"));
			requestHead.setTranscationSeqNo("123456790");
			
			FbWeixinBindRequestBody requestBody = new FbWeixinBindRequestBody();
			requestBody.setInsuredCode("5000002000000002");
			requestBody.setOpenid("openid_aaaaa");
			requestBody.setNickName("zhangsan");
			requestBody.setTelephone("13599521190");
			
			FbWSRequest request = new FbWSRequest();
			request.setRequestHead(requestHead);
			request.setRequestBody(requestBody);
			
			wsClient.setRequest(request);
			wsClient.startExecuteChain();
		}catch(Exception e) {
			System.out.println("调用WS出错，错误信息：");
			e.printStackTrace();
		}
		
		/*CustomerMessageSendLog cms = new CustomerMessageSendLog();
		cms.setToUserId("aaa");
		cms.setMessageType("text");
		cms.setMessageContent("message content");
		cms.setSendStatus(1);*/
		
		/*customerMessageService.save(cms);*/
		//CustomerMessageRecord cmr = customerMessageService.getEntity(entityName, id);
		System.out.println(new Date().toString());
		return "";
	}
	
	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
		
		TextMessage tm = new TextMessage();
		
		Map<String, String> map = new HashedMap();
		map.put("content", "this is content");
		map.put("aaa", "this is aaa");
		
		//MyBeanUtils.copyMap2Bean_Nobig(tm, map);
		BeanUtils.copyProperties(tm, map);
		
		System.out.println(tm.getContent());
	}
	
}
