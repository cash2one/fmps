/**
 * 
 */
package cn.com.fubon.webservice;

import java.util.Date;

import org.jeecgframework.core.util.UUIDGenerator;

import jodd.datetime.JDateTime;
import cn.com.fubon.util.XmlUtils;
import cn.com.fubon.webservice.entity.request.FbWSRequest;
import cn.com.fubon.webservice.entity.request.RequestHead;

/**
 * @author binbin.wang
 *
 */
public class WSInvokeDemo {

	/**
	 * 
	 */
	public WSInvokeDemo() {
		// TODO Auto-generated constructor stub
	}
	
	public static FbWSRequest initRequest() {
		FbWSRequest request = new FbWSRequest();
		
		RequestHead requestHead = new RequestHead();
		requestHead.setClientCode(WsConstants.REQUEST_HEAD_KEY_CLIENT_CODE_COREOS);
		requestHead.setServerCode(WsConstants.REQUEST_HEAD_KEY_SERVER_CODE);
		requestHead.setTranscationCode(WsConstants.REQUEST_HEAD_KEY_TRANSATION_CODE_1);
		
		JDateTime dateTime = new JDateTime(new Date());
		String date = dateTime.toString("YYYYMMDD");
		String time = dateTime.toString("hhmmss");
		requestHead.setTranscationDate(date);
		requestHead.setTranscationTime(time);
		requestHead.setTranscationSeqNo(UUIDGenerator.generate());
		
		request.setRequestHead(requestHead);
		
		return request;
	}
	
	public static void main(String[] args) {
		try {
			
			String entryUrl = "";
			
			MainWebServiceClient client = new MainWebServiceClient();
			client.startExecuteChain();
			
			FbWSRequest request = initRequest();
			
			System.out.println(XmlUtils.toXML(request));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
