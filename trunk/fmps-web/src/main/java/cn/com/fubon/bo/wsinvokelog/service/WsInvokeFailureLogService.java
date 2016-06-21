/**
 * 
 */
package cn.com.fubon.bo.wsinvokelog.service;

import org.jeecgframework.core.common.service.CommonService;

import cn.com.fubon.bo.wsinvokelog.entity.WsInvokeFailureLog;

/**
 * @author binbin.wang
 *
 */
public interface WsInvokeFailureLogService extends CommonService {
	public void saveNextInvokeFailureLog(WsInvokeFailureLog wsInvokeFailureLog);
}
