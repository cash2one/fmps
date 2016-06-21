package cn.com.fubon.wechatClaims.service;

import java.util.List;
import java.util.Map;

import org.jeecgframework.core.common.service.CommonService;

import cn.com.fubon.wechatClaims.entity.ReportInfo;

public interface ReportInfoService extends CommonService {
	/**
	 * 保存案件信息，如表中已有记录则更新
	 * 
	 * @param reportInfo
	 */
	public void saveOrUpdateReportInfo(ReportInfo reportInfo, String openid,
			String phoneNO);

	/**
	 * 查询案件信息表。
	 * 
	 * @author patrick.z
	 * @param registNo
	 * @return
	 */
	Map<String, Object> getReportInfoByRegistNo(String registNo);

	/**
	 * 根据ReportInfo查询列表
	 */
	public List<ReportInfo> getReportInfoList(ReportInfo reportInfoo,String flagStr);
	/**
	 * 更新案件信息表状态。
	 * 
	 * @author patrick.z
	 * @param registNo
	 * @return
	 */
	boolean updReportInfoByRegistNo(String registNo);

	public ReportInfo getReportInfo(String registNo);

	public List<ReportInfo> getReportInfoList(String openid);

	/**
	 * 根据案件号查询已经上传的图片张数
	 * 
	 * @param registNo
	 * @return
	 */
	public int getImageTotal(String registNo);

	/**
	 * 根据传入的状态值更新，聊天状态
	 * 
	 * @param registNo
	 * @param sessionState
	 * @return
	 */

	boolean updReportInfoByRegistNo(String registNo, int sessionState);

	/**
	 * 根据电话号码获取 案件信息
	 * 
	 * @param phone
	 * @return
	 */
	public ReportInfo getReportInfoByPhone(String phone);

	/**
	 * 根据电话号码获取未维修的报案列表
	 * 
	 * @param phone
	 * @return
	 */

	public List<ReportInfo> getReportInfoListForRepair(String phone);

	/**
	 * 根据 openid 获取 案件信息
	 * 
	 * @param openid
	 * @return
	 */
	public ReportInfo getReportInfoByOpenid(String openid);

	 /**
	  * 根据 registNo 查询案件信息，如已经有核保时间，再判断 案例的openid 与 传入的openid是否相同，不同返回 true
	  * @param registNo
	  * @param openid
	  * @return
	  */
	
	public boolean isUnderwriting(String registNo,String openid);
	
	/**
	 * 获取满足自动做核赔确认的报案列表
	 * @return
	 */
	
	public  List<ReportInfo>   getAutoConfirmReportInfoList();
	
}
