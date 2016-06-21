package cn.com.fubon.fo.huodong.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.jeecgframework.core.common.service.CommonService;

import cn.com.fubon.fo.huodong.entity.HuodongRecord;

public interface LunarNewYearService extends CommonService {	
	
	//判断用户是否首次进入,true 首次进入 。false 重复进入
	public boolean isFirstEnter(String huodongid, String openid);
    //获取客户的帮抢朋友列表
	public List<Map<String, Object>> getFriendList(String huodongid, String openid);
	 //获取客户的保额
	public  BigDecimal  getAmount(String huodongid, String openid);
	 //获取自己帮抢的保额
	public  BigDecimal  getSelfAmount(String huodongid,String sponsor, String openid);
	//查询"是否帮他领取过保额"
	public boolean isHelpHim(String sponsor, String huodongid, String openid);
	//获取帮他抢的保额
	public  BigDecimal  getHelpHisAmount(String sponsor, String huodongid, String openid);
	//查询一共抢了多少保额
	public Long getPremiumCount(String hdid);
	//查询各省份参与人数
	public List<Map<String, Object>> getPeopleInProvince(String hdid);
	//最快抢满10万的用户
	public Map<String, Object> getFastestPeople(String hdid);
	//查询"是否有活动保单"
	public boolean hasPolicy(String huodongid, String openid);
	//查询"活动记录"
	public HuodongRecord getHuodongRecord(String huodongid, String openid);
	//查询"用户是否已登记，参与活动"
	public boolean isUserCheckIn(String identifynumber,String customercname);
	
}
