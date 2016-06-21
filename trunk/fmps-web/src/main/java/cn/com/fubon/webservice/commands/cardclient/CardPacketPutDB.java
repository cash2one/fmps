/**
 * 
 */
package cn.com.fubon.webservice.commands.cardclient;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.UUIDGenerator;

import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.guanjia.account.service.impl.WeixinAccountServiceImpl;
import weixin.util.DateUtils;
import cn.com.fubon.transaction.entity.TransactionRecord;
import cn.com.fubon.transaction.service.ITransactionRecordService;

/**
 * 卡单激活模块webservice日志
 * 
 * @author qingqu.huang
 * @date 2015-05-18
 */
public class CardPacketPutDB {
	
	private ITransactionRecordService transactionRecordService;
	private WeixinAccountServiceI weixinAccountService;

	public void writeLog(String requestxml, String responsexml) {
		weixinAccountService = (WeixinAccountServiceI) ApplicationContextUtil
				.getContext().getBean("weixinAccountService");
		transactionRecordService=(ITransactionRecordService) ApplicationContextUtil
				.getContext().getBean("transactionRecordService");
		List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService
				.findValidWeixinAccounts();
		WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList
				.get(0);
		TransactionRecord transactionRecordEntity = new TransactionRecord();
		transactionRecordEntity.setTransactionId(UUIDGenerator.generate());
		Timestamp dateTime = Timestamp.valueOf(DateUtils
				.getDate("yyyy-MM-dd HH:mm:ss"));
		transactionRecordEntity.setCreateTime(dateTime);
		transactionRecordEntity.setFromuser("100");
		transactionRecordEntity.setTouser("PRPALL");
		transactionRecordEntity.setTransactionFormat("xml");
		transactionRecordEntity.setTransactionType("card");
		transactionRecordEntity.setAccount(weixinAccountEntity);
		transactionRecordEntity.setExternalRequest(requestxml);
		transactionRecordEntity.setExternalResponse(responsexml);
		transactionRecordService.save(transactionRecordEntity);
	}
}
