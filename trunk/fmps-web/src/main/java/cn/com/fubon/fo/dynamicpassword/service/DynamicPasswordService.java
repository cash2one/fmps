package cn.com.fubon.fo.dynamicpassword.service;

import org.jeecgframework.core.common.service.CommonService;

import cn.com.fubon.fo.dynamicpassword.entity.TSDynamicPassword;

public interface DynamicPasswordService extends CommonService{
	public boolean findLatestTSDynamicPassword(String mobile);
	
	public void saveDynamicPassword(TSDynamicPassword tsDynamicPassword);
	
	public boolean isValidDynamicPassword(String mobile,String dynamicPassword);
	
	public Boolean sendMsg(String url,String msgid,String dynamicPassword,String mobile); 
	
	Boolean sendReadClauseMsg(String url, String msgId, String dynamicPassword,
			String mobile,String customercname);
	
	public boolean isBindedMobile(String mobile);
	
}
