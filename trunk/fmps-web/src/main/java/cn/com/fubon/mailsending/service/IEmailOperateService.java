package cn.com.fubon.mailsending.service;

import org.jeecgframework.core.common.service.CommonService;

/**
 * 邮件操作日志
 * 
 * @author yaoming.zhang
 *
 */
public interface IEmailOperateService extends CommonService{
	
	/**
	 * 日志添加
	 * 
	 * @param operatelogId
	 * @param operater
	 * @param operateType
	 * @param huodongid
	 * @param importBatchId
	 * @param logContent
	 */
	public void addLog(String operatelogId, String operater, String operateType, String huodongid, String importBatchId, String logContent);

}
