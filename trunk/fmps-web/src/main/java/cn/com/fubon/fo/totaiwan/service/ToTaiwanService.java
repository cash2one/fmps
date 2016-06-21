/**
 * 
 */
package cn.com.fubon.fo.totaiwan.service;

import java.util.List;
import java.util.Map;
import org.jeecgframework.core.common.service.CommonService;

/**
 * @author qingqu.huang
 *
 */
public interface ToTaiwanService extends CommonService {

	/**
	 * 根据用户openid统计该用户已上传的图片数量
	 * 
	 * @param openid
	 * @return
	 */
	public int getCount(String openid);

	public List<Map<String, Object>> findProductList(String salemode,String[] internalcodes);
	
	public List<Map<String, Object>> loadProvinceList();
	
	public List<Map<String, Object>> loadCityList(String provinceid);
	
	public List<Map<String, Object>> loadCounty(String cityid);
	
	public List<Map<String, Object>> getunPaidPolicyList(String openid,int start);
	
	public List<Map<String, Object>> getPolicyList(String openid,String status,int start); 
	
}
