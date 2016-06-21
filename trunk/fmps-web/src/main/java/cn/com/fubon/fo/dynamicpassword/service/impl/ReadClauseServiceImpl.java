package cn.com.fubon.fo.dynamicpassword.service.impl;


import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import cn.com.fubon.fo.dynamicpassword.service.ReadClauseService;
import cn.com.fubon.util.HttpUtils;

@Service("readClauseService")
@Transactional
public class ReadClauseServiceImpl extends CommonServiceImpl implements
		ReadClauseService {

	private static final Logger logger = Logger
			.getLogger(ReadClauseServiceImpl.class);


	@Override
	public Boolean sendReadClauseMsg(String url, String msgId, String policyno,
			String mobile,String customercname) {
		try {
			//电销需求
			String sendMsg = "亲爱的"+customercname+"客户您好，您有新保单及条款未读取，请及时于我司公众微信号【富邦财险】内右下角的【我】进入【保单】查询及阅读，若有任何问题欢迎致电客服热线4008-817-518。";
			//String sendMsg = "亲爱的"+customercname+"客户您好，您有新保单及条款未读取，请于我司公众微信号【富邦财险】内右下角的【我】进入【保单】查询及阅读，阅读条款参与惊喜活动，若有任何问题欢迎致电客服热线4008-817-518。";
			logger.info("sendMsg ===>" + sendMsg);
			logger.info("prepare to invoke send SMS service, mobile===>"
					+ mobile);	
			sendMsg = Base64.encodeBase64String(sendMsg.getBytes("gbk"));
			Map<String, String> params = new HashMap<String, String>();
			params.put("msgId", msgId);
			params.put("phoneNum", mobile);
			params.put("businessno", policyno);
			params.put("sendMsg",sendMsg);
			params.put("dianxiao", "F");
			HttpUtils.post(url, params);

		} catch (Exception e) {
			// throw new Exception("连接核心失败");
			e.printStackTrace();
			logger.info("发送短信失败. cause by===>" + e.getMessage());
			return false;
		}

		return true;
	}
}