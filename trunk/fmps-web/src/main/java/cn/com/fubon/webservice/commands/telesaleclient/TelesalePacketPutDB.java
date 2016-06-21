package cn.com.fubon.webservice.commands.telesaleclient;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.log4j.Logger;
import org.jeecgframework.core.util.UUIDGenerator;
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

public class TelesalePacketPutDB implements Command {
	@Resource(name = "transactionRecordService")
	private ITransactionRecordService transactionRecordService;
	@Resource(name = "weixinAccountService")
	private WeixinAccountServiceI weixinAccountService;

	@Autowired
	public ITransactionRecordService getTransactionRecordService() {
		return transactionRecordService;
	}

	public void setTransactionRecordService(
			ITransactionRecordService transactionRecordService) {
		this.transactionRecordService = transactionRecordService;
	}

	private static final Logger logger = Logger
			.getLogger(TelesalePacketPutDB.class);

	public TelesalePacketPutDB() {
	}

	@Override
	public boolean execute(Context context) throws Exception {
		String externalReSponseXml = (String) context
				.get(WsConstants.CHAIN_CONTEXT_KEY_WS_EXTERNL_RESPONSE_XML); // 响应
																				// XML
		String fbWsRequestXml = (String) context
				.get(WsConstants.CHAIN_CONTEXT_KEY_WS_REQUEST_XML); // 请求XML
		FbWSRequest fbWsRequest = (FbWSRequest) context
				.get(WsConstants.CHAIN_CONTEXT_KEY_WS_REQUEST);
		List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService
				.findValidWeixinAccounts();
		WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList
				.get(0);
		TransactionRecord transactionRecordEntity = new TransactionRecord();
		transactionRecordEntity.setTransactionId(UUIDGenerator.generate());
		Timestamp dateTime = Timestamp.valueOf(DateUtils
				.getDate("yyyy-MM-dd HH:mm:ss"));
		transactionRecordEntity.setCreateTime(dateTime);
		transactionRecordEntity.setFromuser(fbWsRequest.getRequestHead()
				.getClientCode());
		transactionRecordEntity.setTouser(fbWsRequest.getRequestHead()
				.getServerCode());
		transactionRecordEntity.setTransactionFormat("XML");
		transactionRecordEntity.setTransactionType(fbWsRequest.getRequestHead()
				.getTranscationCode());
		transactionRecordEntity.setAccount(weixinAccountEntity);
		transactionRecordEntity.setInternalRequest(fbWsRequestXml);
		transactionRecordEntity.setExternalResponse(externalReSponseXml);
		String requestTime = fbWsRequest.getRequestHead().getTranscationDate()
				+ fbWsRequest.getRequestHead().getTranscationTime();
		SimpleDateFormat dateFormatter = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss.SSS");
		SimpleDateFormat Formatter = new SimpleDateFormat(
				"yyyyMMddHHmmss");
		Date reqdate=Formatter.parse(requestTime);
		transactionRecordEntity.setReqDateTime(Timestamp.valueOf(dateFormatter.format(reqdate)));
		transactionRecordEntity.setRespDateTime(Timestamp.valueOf(DateUtils
				.getDate("yyyy-MM-dd HH:mm:ss.SSS")));
		transactionRecordService.save(transactionRecordEntity);
		return false;
	}

}
