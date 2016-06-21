package cn.com.fubon.businessReminder.task;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.jeecgframework.core.util.ResourceUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alipay.util.UtilDate;

import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.popular.api.MessageAPI;
import cn.com.fubon.businessReminder.entity.NewCarMsgEntity;
import cn.com.fubon.businessReminder.service.ICustomerNotifyMessageService;
import cn.com.fubon.businessReminder.util.ReflectUtil;

/**
 * @author yaoming.zhang
 *
 */
@Service("customerNotifyMessageTask")
@Transactional
public class CustomerNotifyMessageTask {
	
	private static final Logger logger = Logger.getLogger(CustomerNotifyMessageTask.class);
	
	@Resource
	private ICustomerNotifyMessageService customerNotifyMessageService;
	
	@Resource
	private WeixinAccountServiceI weixinAccountService;
	
	/**
	 * 新车上牌变更
	 */
	public void sendNewCarUpdateLicenceMessage() {
		String templateMessageId = getTemplateMessageValue("template_message_id_3");
		Map<String, String> messageData = new HashMap<String, String>();
		// 点击模板消息详情跳转地址
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid={APPID}&redirect_uri={domain}/fo/binded/customerNewCarLicenceController.do?method=getCustomerNewCarLicence&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
		String domain= ResourceUtil.getDomain();
		url= url.replace("{APPID}", getAppid()).replace("{domain}", domain);
		
		Set<String> copyIdSet = new HashSet<String>();
		// 1、查询需要发送消息的新车列表
		List<Map<String, Object>> list = this.customerNotifyMessageService.getNewCarUpdateLicenceList();
		for (Map<String, Object> map : list) {
			NewCarMsgEntity msg = ReflectUtil.reflect(NewCarMsgEntity.class, map);

			// 礼貌性、称谓性的用语
			messageData.put("first", "尊敬的" + msg.getInsuredname() + msg.getSex() + "：\r\n\r\n爱车上牌后请您尽快更新保单的车牌信息");
			// 车型名称
			messageData.put("keyword1", msg.getBrandname());
			// 发动机号
			messageData.put("keyword2", msg.getEngineno());
			// 车架号
			messageData.put("keyword3", msg.getFrameno());
			// 详情
			messageData.put("remark", "\r\n\r\n点击详情，进行新车车牌变更。\r\n车牌变更有助于您的理赔时效。\r\n若需帮助，请回复'0'（转人工服务）");

			// 2、发送模板消息
			String recordid = new MessageAPI().sendTemplateMessage(templateMessageId, url, msg.getOpenid(), messageData);
			logger.info("[新车号牌更新提醒消息]" + UtilDate.getDateFormatter() + "为openid[" + msg.getOpenid() + "]推送消息");

			// 3、更新该条信息的recordid及sendstatus状态为1
			this.customerNotifyMessageService.updateRecordByid(msg.getId(), recordid);

			copyIdSet.add(msg.getId()); // 保存需要拷贝的weixin_customer_notify_message.id
		}

		for (String id : copyIdSet) {
			// 4、判断该记录是否已经发送成功3次
			// 如果尚未达到3次，则复制下个月发送的数据,新增的记录规则为:record_id为空、nextsendtime下次发送时间在原来基础上增加一个月,sendstatus为0
			boolean needCopy = this.customerNotifyMessageService.needCopy(id);
			if(needCopy){
				this.customerNotifyMessageService.copyNextMonthRecord(id);
			}
		}
	}
	
	/**
	 * 生日提醒消息
	 */
	public void sendBirthdayBlessMessage() {
		String templateMessageId = getTemplateMessageValue("template_message_id_4");
		Map<String, String> messageData = new HashMap<String, String>();
		// 点击模板消息详情跳转地址
		String url = "";

		// 1、查询需要发送消息的生日提醒列表
		List<Map<String, Object>> list = this.customerNotifyMessageService.getBirthdayBlessList();
		for (Map<String, Object> map : list) {
			NewCarMsgEntity msg = ReflectUtil.reflect(NewCarMsgEntity.class, map);

			// 礼貌性、称谓性的用语
			messageData.put("first", "尊敬的" + msg.getInsuredname() + msg.getSex() + "：");
			// 祝福语
			messageData.put("keyword1", "\r\n今天是您的生日\r\n衷心祝愿\r\n生日快乐\r\n事事顺心");

			// 2、发送模板消息
			String recordid = new MessageAPI().sendTemplateMessage(templateMessageId, url, msg.getOpenid(), messageData);
			logger.info("[生日提醒消息]" + UtilDate.getDateFormatter() + "为openid[" + msg.getOpenid() + "]推送消息");

			// 3、更新该条信息的recordid及sendstatus状态为1
			this.customerNotifyMessageService.updateRecordByid(msg.getId(), recordid);
		}
	}
	
	/**
	 * 通过key获取dbconfig-*.properties的value值
	 * 
	 * @param templateMessageKey
	 * @return
	 */
	public String getTemplateMessageValue(String templateMessageKey) {
		ResourceBundle resourceBundle = ResourceUtil.getBundleEnvAbout();
		return resourceBundle.getString(templateMessageKey);
	}
	
	/**
	 * 获取appid
	 * 
	 * @return
	 */
	public String getAppid() {
		List<WeixinAccountEntity> weixinAccountEntityList = weixinAccountService.findValidWeixinAccounts();
		WeixinAccountEntity weixinAccountEntity = weixinAccountEntityList.get(0);
		String appid = weixinAccountEntity.getAccountappid();
		
		return appid;
	}
	
}
