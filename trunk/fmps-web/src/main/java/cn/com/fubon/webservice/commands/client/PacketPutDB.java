/**
 * 
 */
package cn.com.fubon.webservice.commands.client;


import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.util.DateUtils;
import cn.com.fubon.transaction.entity.TransactionRecord;
import cn.com.fubon.transaction.service.ITransactionRecordService;
import cn.com.fubon.util.XmlUtils;
import cn.com.fubon.webservice.MainWebServiceClient;
import cn.com.fubon.webservice.WsConstants;
import cn.com.fubon.webservice.entity.request.FbWSRequest;
import cn.com.fubon.webservice.entity.response.FbWSResponse;

/**
 * 报文入库
 * @author binbin.wang
 *
 */
public class PacketPutDB  implements Command {
	@Resource(name="transactionRecordService")
	private ITransactionRecordService transactionRecordService;
	@Resource(name="weixinAccountService")
	private WeixinAccountServiceI weixinAccountService;
	
	@Autowired
	public ITransactionRecordService getTransactionRecordService() {
		return transactionRecordService;
	}

	public void setTransactionRecordService(ITransactionRecordService transactionRecordService) {
		this.transactionRecordService = transactionRecordService;
	}

	private static final Logger logger = Logger.getLogger(PacketPutDB.class);	
	/**
	 * 
	 */
	public PacketPutDB() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Context context) throws Exception {
		String externalRequestXml = (String)context.get(WsConstants.CHAIN_CONTEXT_KEY_WS_EXTERNL_REQUEST_XML); //外部 请求XML	
		String externalReSponseXml =(String)context.get(WsConstants.CHAIN_CONTEXT_KEY_WS_EXTERNL_RESPONSE_XML); //外部 响应 XML		
		String fbWsRequestXml =(String) context.get(WsConstants.CHAIN_CONTEXT_KEY_WS_REQUEST_XML); //内部请求XML
	   	FbWSResponse  fbWsResponse	=(FbWSResponse)context.get(WsConstants.CHAIN_CONTEXT_KEY_WS_RESPOSNE); 
	   	FbWSRequest fbWsRequest = (FbWSRequest)context.get(WsConstants.CHAIN_CONTEXT_KEY_WS_REQUEST);
		String fbWsResponseXML = XmlUtils.toXML(fbWsResponse);
//		TransactionRecord  TransactionRecord=new TransactionRecord();		
		List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService
					.findValidWeixinAccounts();
		WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList
					.get(0);
		TransactionRecord transactionRecordEntity = new TransactionRecord();
		transactionRecordEntity.setTransactionId(fbWsResponse.getResponseHead().getTranscationSeqNo());		 
		Timestamp dateTime = Timestamp.valueOf(DateUtils
				.getDate("yyyy-MM-dd HH:mm:ss"));
		transactionRecordEntity.setCreateTime(dateTime);
		transactionRecordEntity.setFromuser(fbWsRequest.getRequestHead().getClientCode());	 
		transactionRecordEntity.setTouser(fbWsRequest.getRequestHead().getServerCode());
		transactionRecordEntity.setTransactionFormat("XML");
		transactionRecordEntity.setTransactionType(fbWsRequest.getRequestHead().getTranscationCode());
		transactionRecordEntity.setAccount(weixinAccountEntity);
		transactionRecordEntity.setInternalRequest(fbWsRequestXml);
		transactionRecordEntity.setInternalResponse(fbWsResponseXML);
		transactionRecordEntity.setExternalRequest(externalRequestXml);
		transactionRecordEntity.setExternalResponse(externalReSponseXml);
		transactionRecordService.save(transactionRecordEntity);			
		return false;
	}

	
}
