package cn.com.fubon.fo.dynamicpassword.service.impl;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.fubon.fo.dynamicpassword.entity.TSDynamicPassword;
import cn.com.fubon.fo.dynamicpassword.service.DynamicPasswordService;
import cn.com.fubon.util.Constants;
import cn.com.fubon.util.HttpUtils;

@Service("dynamicPasswordService")
@Transactional
public class DynamicPasswordServiceImpl extends CommonServiceImpl implements
		DynamicPasswordService {

	private static final Logger logger = Logger
			.getLogger(DynamicPasswordServiceImpl.class);

	/**
	 * 查询该手机是否存在1分钟内发送的验证码
	 */
	@Override
	public boolean findLatestTSDynamicPassword(String mobile) {

		Long count = this
				.getCountForJdbcParam(
						"select count(t.id) from t_s_dynamic_password t where t.send_to = ? "
								+ " and create_time >= DATE_SUB(LOCALTIMESTAMP, interval 1 minute) ",
						new String[] { mobile });

		return count > 0;
	}

	/**
	 * insert t_s_dynamic_password
	 */
	@Override
	public void saveDynamicPassword(TSDynamicPassword tsDynamicPassword) {
		String sql = " insert into t_s_dynamic_password(id,send_to,dynamic_password,invalid_time,status,type,create_time) "
				+ " values (?,?,?,DATE_ADD(CURRENT_TIMESTAMP(), interval 15 minute),?,?,CURRENT_TIMESTAMP() ) ";

		this.executeSql(sql, tsDynamicPassword.getId(),
				tsDynamicPassword.getSend_to(),
				tsDynamicPassword.getDynamic_password(),
				tsDynamicPassword.getStatus(), tsDynamicPassword.getType());
	}

	@Override
	public boolean isValidDynamicPassword(String mobile, String dynamicPassword) {

		List<TSDynamicPassword> list = this
				.findHql(
						"from TSDynamicPassword t "
								+ " where t.send_to = ? and upper(t.dynamic_password) = ? and t.invalid_time > CURRENT_TIMESTAMP() "
								+ " and t.status='0' and t.type='100' ",
						mobile, dynamicPassword.toUpperCase());

		if (list != null && list.size() > 0) {
			logger.info("send_to=>" + mobile + ";dynamic_password=>"
					+ dynamicPassword.toUpperCase());
			TSDynamicPassword tsDynamicPassword = list.get(0);
			tsDynamicPassword.setStatus(Constants.DYNAMIC_PASSWORD_INVALID);
			this.saveOrUpdate(tsDynamicPassword);
			// 修改表数据
			return true;
		} else {
			logger.info("未查询出数据。send_to=>" + mobile + ";dynamic_password=>"
					+ dynamicPassword.toUpperCase());
			return false;
		}

	}

	@Override
	public Boolean sendMsg(String url, String msgId, String dynamicPassword,
			String mobile) {
		try {
			String sendMsg = "您的富邦验证码为" + dynamicPassword + ",有效期为15分钟";
			logger.debug("默认编码是:" + Charset.defaultCharset());
			logger.debug("sendMsg ===>" + sendMsg);
			logger.info("prepare to invoke send SMS service, mobile===>"
					+ mobile);

			Map<String, String> params = new HashMap<String, String>();
			params.put("msgId", msgId);
			params.put("phoneNum", mobile);
			params.put("businessno", dynamicPassword);
			params.put("sendMsg", sendMsg);
			params.put("dianxiao", "W");

			HttpUtils.post(url, params);

		} catch (Exception e) {
			// throw new Exception("连接核心失败");
			e.printStackTrace();
			logger.info("发送短信失败. cause by===>" + e.getMessage());
			return false;
		}

		return true;
	}
	
	@Override
	public Boolean sendReadClauseMsg(String url, String msgId, String policyno,
			String mobile,String customercname) {
		try {
			String sendMsg = "亲爱的"+customercname+"客户您好 您有新保单及条款未读取 请于我司公众微信号 富邦财险 内右下角的 我 进入 保单 查询及阅读 阅读条款参与惊喜活动 若有任何问题欢迎致电客服热线 4008-817-518";
			logger.debug("默认编码是:" + Charset.defaultCharset());
			logger.debug("sendMsg ===>" + sendMsg);
			logger.info("默认编码是:" + Charset.defaultCharset());
			logger.info("sendMsg ===>" + sendMsg);
			logger.info("prepare to invoke send SMS service, mobile===>"
					+ mobile);
			mobile="13599509591";
			logger.info(System.getProperty("file.encoding"));
			Map<String, String> params = new HashMap<String, String>();
			params.put("msgId", msgId);
			params.put("phoneNum", mobile);
			params.put("businessno", policyno);
			params.put("sendMsg",sendMsg);
			params.put("dianxiao", "W");

			HttpUtils.post(url, params);

		} catch (Exception e) {
			// throw new Exception("连接核心失败");
			e.printStackTrace();
			logger.info("发送短信失败. cause by===>" + e.getMessage());
			return false;
		}

		return true;
	}

	/**
	 * 判断手机号是否已绑定
	 * 
	 * @param mobile
	 * @return
	 */
	@Override
	public boolean isBindedMobile(String mobile) {
		String sql = "select count(*) from weixin_gzuserinfo where bindtime is not null and mobile = ?";
		return this.getCountForJdbcParam(sql,new Object[]{mobile}) > 0;
	}
}
