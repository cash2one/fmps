package cn.com.fubon.transaction.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.jeecgframework.core.common.service.CommonService;

import cn.com.fubon.transaction.entity.TransactionRecord;

/**
 * 报文记录接口类
 * @author shanqi.wang
 *
 */

public interface ITransactionRecordService extends CommonService {
	 

/**
 * 根据实体类   transactionId报文id 更新数据库response 回复内容 字段
 * 
 * @param entity
 * @throws IllegalAccessException
 * @throws InvocationTargetException
 */
public void UpdateResponseBytransactionId(String transactionId, String internalResponse, String externalResponse );


/**
 *根据微信XML中   transactionId报文id 查询系统记录数量
 * 
 * @param entity
 * @throws IllegalAccessException
 * @throws InvocationTargetException
 */
public int queryTotalBytransactionId(String transactionId );

}