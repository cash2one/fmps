package cn.com.fubon.fo.claim.service;

import java.util.List;
import java.util.Map;

import org.jeecgframework.core.common.service.CommonService;

public interface NotCarClientService extends CommonService {
	
	public int getCount(String openid,String caseno);
	
	public Map<String, Object> getImgtypeCount(String openid,String caseno);
	
	public boolean isExist(String registNo);
	
	public void updateRegistInfo(String registNo, String policyNo,
			String reportDate, String reportTime, String startDate,
			String endDate, String remark, String caseStatus,
			String insuredName, String reportorName);
	
	public List<Map<String, Object>> getUploadedImg(String openid, String caseno);
	
	public List<Map<String, Object>> getImgList(String registNo, String currenttime);
	
	public Integer updateStatus(String mediaid,String status);
	
}
