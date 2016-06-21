package cn.com.fubon.transaction.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import weixin.guanjia.message.service.ReceiveMessageServiceI;
import cn.com.fubon.transaction.entity.TransactionRecord;
import cn.com.fubon.transaction.service.ITransactionRecordService;

/**
 * 报文记录服务类
 * @author shanqi.wang
 *
 */

@Service("transactionRecordService")
@Transactional
public class TransactionRecordServiceImpl extends CommonServiceImpl implements
		ITransactionRecordService {

	/**
	 * private String internalResponse; // '回复内部内容',
	 * private String externalResponse; // '回复外部内容',
	 */
	@Override
	public void UpdateResponseBytransactionId(String transactionId,
			String internalResponse, String externalResponse) {

		List<TransactionRecord> transactionRecordList = this.findByProperty(
				TransactionRecord.class, "transactionId", transactionId);

		for (TransactionRecord transactionRecord : transactionRecordList) {
			transactionRecord.setInternalResponse(internalResponse);
			transactionRecord.setExternalResponse(externalResponse);
			this.updateEntitie(transactionRecord);
		}

	}

	@Override
	public int queryTotalBytransactionId(String transactionId) {		
		Long count	=  this.getCountForJdbcParam("select count(id) from  weixin_transaction_record   where transaction_id=?", new String[]{transactionId});
		return count.intValue();
	}
}
