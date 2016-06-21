package cn.com.fubon.fo.dynamicpassword.service;

import org.jeecgframework.core.common.service.CommonService;

public interface ReadClauseService extends CommonService{	
	Boolean sendReadClauseMsg(String url, String msgId, String dynamicPassword,
			String mobile,String customercname);
	
}
