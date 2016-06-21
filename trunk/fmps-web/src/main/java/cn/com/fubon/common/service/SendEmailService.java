/**
 * 
 */
package cn.com.fubon.common.service;

import java.util.Map;

import org.jeecgframework.core.common.service.CommonService;

/**
 * @author qingqu.huang
 *
 */
public interface SendEmailService extends CommonService{

	public boolean sendEmail(Map<String, String> templateMap, String email,
			String templateid) throws Exception;
}
