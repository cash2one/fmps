package cn.com.fubon.transaction.controller;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.util.DateUtils;
import cn.com.fubon.fo.event.service.IEventProcessingService;
import cn.com.fubon.transaction.entity.TransactionRecord;
import cn.com.fubon.transaction.service.ITransactionRecordService;

/**
 * 报文交易控制类
 * 
 * @Scope("prototype")
 * @Controller
 * @RequestMapping("transactionRecordController")
 */
public class TransactionRecordController {

	private ITransactionRecordService transactionRecord;
	private IEventProcessingService eventProcessingService;
	private WeixinAccountServiceI weixinAccountServiceI;

	@Autowired
	public void setTransactionRecord(ITransactionRecordService transactionRecord) {
		this.transactionRecord = transactionRecord;
	}

	@Autowired
	public void setWeixinAccountServiceI(
			WeixinAccountServiceI weixinAccountServiceI) {
		this.weixinAccountServiceI = weixinAccountServiceI;
	}

	@Autowired
	public void setiEventProcessingService(
			IEventProcessingService eventProcessingService) {
		this.eventProcessingService = eventProcessingService;
	}

	@RequestMapping(params = "update")
	public void update() throws IllegalAccessException,
			InvocationTargetException {

		transactionRecord.UpdateResponseBytransactionId("123456555",
				"transactionRecordEntity.setResponse","sdfsdfsdf");

	}

	@RequestMapping(params = "insert")
	public void insert() {

		WeixinAccountEntity weixinAccountEntity = weixinAccountServiceI
				.findByToUsername("ceshi");
		TransactionRecord transactionRecordEntity = new TransactionRecord();

		transactionRecordEntity.setTransactionId("123456555");
		 
		Timestamp temp = Timestamp.valueOf(DateUtils
				.getDate("yyyy-MM-dd HH:mm:ss"));
		transactionRecordEntity.setCreateTime(temp);
		transactionRecordEntity.setFromuser("fromuser bbbbbbbbbbbbbbbbbbbb");
	 
		transactionRecordEntity.setTouser("touser");
		transactionRecordEntity.setTransactionFormat("transactionFormat");
		transactionRecordEntity.setTransactionType("transactionType");
		transactionRecordEntity.setAccount(weixinAccountEntity);		
		transactionRecord.save(transactionRecordEntity);

	}

}
