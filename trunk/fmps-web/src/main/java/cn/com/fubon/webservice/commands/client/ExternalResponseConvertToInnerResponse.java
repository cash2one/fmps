/**
 * 
 */
package cn.com.fubon.webservice.commands.client;

import java.lang.annotation.Annotation;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.log4j.Logger;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;

import cn.com.fubon.util.XmlUtils;
import cn.com.fubon.webservice.ResponseHandler;
import cn.com.fubon.webservice.WsConstants;
import cn.com.fubon.webservice.entity.response.FbWSResponse;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 请求发送到服务端
 * @author binbin.wang
 *
 */
public class ExternalResponseConvertToInnerResponse  implements Command {

	private static final Logger logger = Logger.getLogger(ExternalResponseConvertToInnerResponse.class);
	
	@Autowired
	private Mapper mapper;
	
	/**
	 * 
	 */
	public ExternalResponseConvertToInnerResponse() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Context context) throws Exception {
		
		//外部响应类类名
		String externalResponseClassName = (String)context.get(WsConstants.CHAIN_CONTEXT_KEY_EXTERNL_RESPONSE_CLASS_NAME);
		logger.info("externalResponseClassName====>"+externalResponseClassName);
		//外部响应XML
		String externalResponseXML = (String)context.get(WsConstants.CHAIN_CONTEXT_KEY_WS_EXTERNL_RESPONSE_XML);
		//转换成对象
		Class externalResponseClass = Class.forName(externalResponseClassName);
		Annotation annotation = externalResponseClass.getAnnotation(XStreamAlias.class);
		String annotationValue = (String)AnnotationUtils.getValue(annotation);
		Object externalResonse = XmlUtils.fromXML(externalResponseXML, annotationValue, externalResponseClass);

		//转换成内部响应类
		FbWSResponse fbWsResponse = mapper.map(externalResonse, FbWSResponse.class);		
		context.put(WsConstants.CHAIN_CONTEXT_KEY_WS_RESPOSNE, fbWsResponse);
		context.put(WsConstants.CHAIN_CONTEXT_KEY_WS_EXTERNL_RESPONSE, externalResonse);
		
		//针对不同的ResponseBody子类转ResponseBody并覆盖context中的Response对象
		ResponseHandler	responseHandler = (ResponseHandler)context.get(WsConstants.CHAIN_CONTEXT_KEY_WS_RESPONSE_HANDLER);
		responseHandler.convertExternalResponseToInnerResponse(context);
		
		return false;
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		/*String xml = "<?xml version='1.0' encoding='utf-8'?><Underwrite><sender><messageType>1</messageType><transactionNo>123456790</transactionNo><clientCode>100</clientCode><auditStruts>8888</auditStruts><auditMessage>重复提交</auditMessage></sender></Underwrite>";
		XStream xStream = new XStream();
		xStream.autodetectAnnotations(true);
		CommonResonse externalResonse = (CommonResponse)xStream.fromXML(xml);
		
		System.out.println(externalResonse.toString());
		*/
		
		Class externalResponseClass = Class.forName("cn.com.fubon.webservice.externl.coresystem.entity.CommonResponse");
		
		Annotation annotation = externalResponseClass.getAnnotation(XStreamAlias.class);
		String value = (String)org.springframework.core.annotation.AnnotationUtils.getValue(annotation);
		
		System.out.println(value);
	}

	
}
