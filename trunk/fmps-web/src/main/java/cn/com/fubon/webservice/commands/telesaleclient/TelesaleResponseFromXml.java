package cn.com.fubon.webservice.commands.telesaleclient;

/**
 * 电销返回的Xml报文转成报文对象，报文对象转成电销线下订单对象
 * @author fangfang.guo
 */

import java.lang.annotation.Annotation;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.log4j.Logger;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.transaction.annotation.Transactional;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import cn.com.fubon.pay.entity.WeiXinOfflineOrderInfo;
import cn.com.fubon.util.XmlUtils;
import cn.com.fubon.webservice.MainWebServiceClient;
import cn.com.fubon.webservice.WsConstants;
import cn.com.fubon.webservice.externl.telesalesystem.TelesaleWebServiceUtil;
import cn.com.fubon.webservice.externl.telesalesystem.entity.TelesaleResponse;
import cn.com.fubon.webservice.externl.telesalesystem.resphandler.TelesaleResponseHandler;

@Transactional
public class TelesaleResponseFromXml implements Command {
	private static final Logger logger = Logger.getLogger(TelesaleResponseFromXml.class);
	@Override
	public boolean execute(Context context) throws Exception {
		String responseXml = (String) context
				.get(WsConstants.CHAIN_CONTEXT_KEY_WS_EXTERNL_RESPONSE_XML);
		
		String wsMethodName = (String) context
				.get(WsConstants.CHAIN_CONTEXT_KEY_WS_METHOD_NAME);
		if(wsMethodName.endsWith("updateFromWxClient")){ //这个判断是否为电销阅读条款报文
		  logger.info("电销阅读条款报文,换回的XML为===(0:更新出错。1:更新成功。2:不存在的保单)========>"+responseXml);
		  }else{
		 logger.info("移动支付报文,换回的XML为===========>"+responseXml);
		Class responseClass = TelesaleResponse.class;
		Annotation annotation = responseClass.getAnnotation(XStreamAlias.class);
		String annotationValue = (String) AnnotationUtils.getValue(annotation);
		TelesaleResponse telesaleResponse = (TelesaleResponse) XmlUtils.fromXML(responseXml,annotationValue, responseClass);
		TelesaleResponseHandler telesaleResponseHandler = TelesaleWebServiceUtil
				.getActualTelesaleResponseHandler(telesaleResponse.getTelesaleResponseHead().getPacketType());

		//报文对象转成电销线下订单对象
		WeiXinOfflineOrderInfo weiXinOfflineOrderInfo = telesaleResponseHandler.process(telesaleResponse);

		context.put("WeiXinOfflineOrderInfo", weiXinOfflineOrderInfo);
		context.put("TelesaleResponse", telesaleResponse);
		}
		return false;
	}

}
