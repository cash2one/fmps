/**
 * 
 */
package cn.com.fubon.webservice.entity.request;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Date;

import jodd.datetime.JDateTime;

import org.jeecgframework.core.util.UUIDGenerator;

import cn.com.fubon.util.XmlUtils;
import cn.com.fubon.webservice.WsConstants;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author binbin.wang
 *
 */
@XStreamAlias("TRANSACTION")
public class FbWSRequest implements Serializable{

	@XStreamAlias("TRANSACTION_HEAD")
	private RequestHead requestHead;
	
	@XStreamAlias("TRANSACTION_BODY")
	private RequestBody requestBody;
	/**
	 * 
	 */
	public FbWSRequest() {
		// TODO Auto-generated constructor stub
	}

	public RequestHead getRequestHead() {
		return requestHead;
	}

	public void setRequestHead(RequestHead requestHead) {
		this.requestHead = requestHead;
	}
	
	public RequestBody getRequestBody() {
		return requestBody;
	}

	public void setRequestBody(RequestBody requestBody) {
		this.requestBody = requestBody;
	}

	public static void main(String[] args) throws ObjectStreamException {
		JDateTime jnow = new JDateTime(new Date());
		RequestHead requestHead = new RequestHead();
		requestHead
				.setClientCode(WsConstants.REQUEST_HEAD_KEY_CLIENT_CODE_COREOS);
		requestHead
				.setServerCode(WsConstants.REQUEST_HEAD_KEY_SERVER_CODE_CORE);
		requestHead
				.setTranscationCode(WsConstants.REQUEST_HEAD_KEY_TRANSATION_CODE_1);
		requestHead.setTranscationDate(jnow.toString("YYYYMMDD"));
		requestHead.setTranscationTime(jnow.toString("hhmmss"));
		requestHead.setTranscationSeqNo(UUIDGenerator.generate());

		FbWeixinBindRequestBody requestBody = new FbWeixinBindRequestBody();
		requestBody.setInsuredCode("5000000201039975");
		requestBody.setOpenid("oELqIsyh_VguKRN-0MONSbeLz5r0");
		requestBody.setNickName("zhangsan");
		requestBody.setTelephone("15248960000");

		FbWSRequest request = new FbWSRequest();
		request.setRequestHead(requestHead);
		request.setRequestBody(requestBody);
		
		System.out.println( XmlUtils.toXML(request));
	}


	
}
