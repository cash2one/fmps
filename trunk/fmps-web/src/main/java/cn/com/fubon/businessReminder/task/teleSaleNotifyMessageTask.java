package cn.com.fubon.businessReminder.task;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import weixin.idea.huodong.entity.HuodongEntity;
import weixin.idea.huodong.service.HuodongService;
import cn.com.fubon.fo.customerbind.entity.WeiXinGzUserInfo;
import cn.com.fubon.fo.customerbind.service.CustomerBindService;
import cn.com.fubon.fo.dynamicpassword.service.DynamicPasswordService;
import cn.com.fubon.fo.dynamicpassword.service.ReadClauseService;
import cn.com.fubon.fo.personalcenter.service.PolicyService;
import cn.com.fubon.util.CachedUtils;
import cn.com.fubon.util.Constants;


@Service("teleSaleNotifyMessageTask")
@Transactional
public class teleSaleNotifyMessageTask {
	
	private static final Logger logger = Logger.getLogger(teleSaleNotifyMessageTask.class);
	
	@Resource
	private ReadClauseService readClauseService;
	
	@Resource
	private HuodongService huodongService;
	
	@Resource(name="PolicyService")
	private PolicyService policyService;
	
	@Resource
	private CustomerBindService customerBindService;
	

	public void sendReadClauseNotifyMessage() {
		//电销红包
		boolean isRod=isRangeOfDate(Constants.TELESALE_READ_CLAUSE_huodongid);
		//是否在活动区间内
		if (isRod){
			List<WeiXinGzUserInfo>	bindlist = customerBindService.findBindCustemer();
			if (!bindlist.isEmpty()){
				for (WeiXinGzUserInfo weiXinGzUserInfo : bindlist) {
					List<Map<String, Object>> unReadpolicys=policyService.isNeedSendNotifyMessage(weiXinGzUserInfo.getCustomercname(), weiXinGzUserInfo.getIdentifynumber());
					if(unReadpolicys.size()>0){
						String url =getPlatFormMsgUrlValue("PLATFORM_MSG_URL");
						logger.info("url=" + url + "========msgid="
								+ Constants.CUSTOMER_READ_CLAUSE_MSGID
								+ "========policyno="
								+ unReadpolicys.get(0).get("policyno")
								+ "========mobile="
								+ weiXinGzUserInfo.getMobile()
								+ "========customer="
								+ weiXinGzUserInfo.getCustomercname());
						readClauseService.sendReadClauseMsg(url, Constants.CUSTOMER_READ_CLAUSE_MSGID, unReadpolicys.get(0).get("policyno").toString(), weiXinGzUserInfo.getMobile(),weiXinGzUserInfo.getCustomercname());
					}
				}
			}
		}
		
	}
	//判断是否在活动期间内
	private   boolean isRangeOfDate(String  huodongid) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String startTime=(String)CachedUtils.get(Constants.HUODON_START_DATE+huodongid); //活动开始时间
		String endTime=(String)CachedUtils.get(Constants.HUODON_END_DATE+huodongid);  //活动结束时间		
		if(StringUtil.isEmpty(startTime)||StringUtil.isEmpty(endTime)){		
		   HuodongEntity huodongEntity=huodongService.getEntity(HuodongEntity.class,huodongid);		
		   startTime=sf.format(huodongEntity.getStarttime());
		   endTime=sf.format(huodongEntity.getEndtime());
		   CachedUtils.set(Constants.HUODON_START_DATE+huodongid,startTime);
		   CachedUtils.set(Constants.HUODON_END_DATE+huodongid,endTime);		
		}
		Date nowdate = new Date();
		try {
			if (nowdate.after(sf.parse(startTime))
					&& nowdate.before(sf.parse(endTime))) {
				return true;
			}
		} catch (ParseException e) {
			logger.error("日期格式化出错...", e);
			return false;
		}
		return false;
	}
	
	public String getPlatFormMsgUrlValue(String platformMsgUrl) {
		ResourceBundle resourceBundle = ResourceUtil.getBundleEnvAbout();
		return resourceBundle.getString(platformMsgUrl);
	}
}
