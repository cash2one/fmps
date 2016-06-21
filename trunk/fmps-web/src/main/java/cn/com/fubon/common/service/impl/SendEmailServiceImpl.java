/**
 * 
 */
package cn.com.fubon.common.service.impl;

import java.util.Map;

import org.apache.commons.mail.HtmlEmail;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.ResourceUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.fubon.common.entity.Contenttemplate;
import cn.com.fubon.common.service.SendEmailService;
import cn.com.fubon.util.CachedUtils;

/**
 * @author qingqu.huang
 *
 */
@Service("sendEmailServiceImpl")
@Transactional
public class SendEmailServiceImpl extends CommonServiceImpl implements
		SendEmailService {
	private static final Logger logger = Logger
			.getLogger(SendEmailServiceImpl.class);

	public boolean sendEmail(Map<String, String> templateMap, String email,
			String templateid) throws Exception {	
		logger.info("开始发送邮件..."+email);
		Contenttemplate template = (Contenttemplate) CachedUtils
				.get("templateid");
		if (template == null) {
			template = this.findUniqueByProperty(Contenttemplate.class, "id",
					templateid);
			if (template != null) {
				CachedUtils.add(template.getId(), template);
			}else{
				throw new Exception("找不到对应的模板消息....");
			}
		}
		String templatemsg = template.getTemplatemsg();
		for(int i=0;i<templateMap.size();i++){
			templatemsg=templatemsg.replace("{keyword"+i+"}", templateMap.get("keyword"+i+""));
		}
//		System.setProperty("java.net.preferIPv4Stack", "true");
//		System.setProperty("java.net.preferIPv6Addresses", "false");
		HtmlEmail htmlEmail = new HtmlEmail();
		htmlEmail.setHostName(ResourceUtil.getBundleEnvAbout().getString(
				"smtphost"));
		htmlEmail.setCharset("utf-8");
		htmlEmail.addTo(email);		
		htmlEmail.setFrom(
				ResourceUtil.getBundleEnvAbout().getString("smtpusername"),
				ResourceUtil.getBundleEnvAbout().getString("smtpfrom"));
		htmlEmail.setAuthentication(
				ResourceUtil.getBundleEnvAbout().getString("smtpusername"),
				ResourceUtil.getBundleEnvAbout().getString("smtppassword"));
		htmlEmail.setSubject(template.getTitle());
		htmlEmail.setHtmlMsg(templatemsg);
		htmlEmail.send();
		return true;

	}

}
