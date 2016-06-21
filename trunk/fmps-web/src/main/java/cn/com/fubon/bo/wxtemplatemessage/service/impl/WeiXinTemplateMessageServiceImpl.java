/**
 * 
 */
package cn.com.fubon.bo.wxtemplatemessage.service.impl;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.fubon.bo.wxtemplatemessage.service.WeiXinTemplateMessageService;

/**
 * @author binbin.wang
 *
 */
@Service("templateMessageService")
@Transactional
public class WeiXinTemplateMessageServiceImpl extends CommonServiceImpl implements WeiXinTemplateMessageService {

	/**
	 * 
	 */
	public WeiXinTemplateMessageServiceImpl() {
}

}
