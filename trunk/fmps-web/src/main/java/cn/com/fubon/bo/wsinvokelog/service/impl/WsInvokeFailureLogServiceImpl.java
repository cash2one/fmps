/**
 * 
 */
package cn.com.fubon.bo.wsinvokelog.service.impl;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;

import cn.com.fubon.bo.wsinvokelog.entity.WsInvokeFailureLog;
import cn.com.fubon.bo.wsinvokelog.service.WsInvokeFailureLogService;
import cn.com.fubon.webservice.entity.request.FbWSRequest;
import cn.com.fubon.webservice.entity.response.FbWSResponse;

/**
 * @author binbin.wang
 *
 */
@Service("wsInvokeFailureLogService")
public class WsInvokeFailureLogServiceImpl extends CommonServiceImpl implements WsInvokeFailureLogService {

	/**
	 * 
	 */
	public WsInvokeFailureLogServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void saveNextInvokeFailureLog(WsInvokeFailureLog wsInvokeFailureLog) {
		
	}
	
}
