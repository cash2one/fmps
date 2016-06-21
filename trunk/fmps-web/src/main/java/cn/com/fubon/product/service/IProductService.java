/**
 * 
 */
package cn.com.fubon.product.service;

import java.util.Date;
import java.util.Map;

import org.jeecgframework.core.common.service.CommonService;

/**
 * @author qingqu.huang
 *
 */
public interface IProductService extends CommonService{
	public Date getFixedStartDate(String productId,String planId);
	public String getProductParameterValue(String productId,String planId,String type,String key);
	public String getProductParameterValue(String productId,String type,String key);
	public String getToTaiProductParameterValue(String productId);
	public String getNeedMailingAddressProductParameterValue(String productId);
	public Map<String,Object> getProductInfo(String planid);
	public String getToTaiProductDescription(String productId);
}
