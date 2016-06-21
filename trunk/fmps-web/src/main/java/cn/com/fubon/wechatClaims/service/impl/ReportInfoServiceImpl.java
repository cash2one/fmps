package cn.com.fubon.wechatClaims.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.fubon.fo.customerbind.entity.WeiXinGzUserInfo;
import cn.com.fubon.util.Constants;
import cn.com.fubon.wechatClaims.entity.ReportInfo;
import cn.com.fubon.wechatClaims.service.ReportInfoService;

@Service("reportInfoService")
@Transactional
public class ReportInfoServiceImpl extends CommonServiceImpl implements
		ReportInfoService {
	private static final Logger logger = Logger
			.getLogger(ReportInfoServiceImpl.class);

	@Override
	public void saveOrUpdateReportInfo(ReportInfo reportInfo, String openid,
			String phoneNO) {
		reportInfo
				.setSessionState(Constants.WECHATCLAIMS_REGISTNO_SESSTIONSTATE_LINE);// 开启会话
		reportInfo.setOpenid(openid);
		WeiXinGzUserInfo weiXinGzUserInfo = this.getWeiXinGzUserInfo(openid);
		reportInfo.setNickname(weiXinGzUserInfo.getNickname());
		reportInfo.setHeadimgurl(weiXinGzUserInfo.getHeadimgurl());
		reportInfo.setPhoneNumber(phoneNO);
		ReportInfo reportInfoSelect = this.findUniqueByProperty(
				ReportInfo.class, "registNo", reportInfo.getRegistNo());
		if (reportInfoSelect != null) {
			logger.info("此案件已经保存过了，需要更新====案件号===>" + reportInfo.getRegistNo());
			reportInfoSelect.setSessionState(reportInfo.getSessionState());
			reportInfoSelect.setReportorName(reportInfo.getReportorName());
			reportInfoSelect.setLicenseNo(reportInfo.getLicenseNo());
			reportInfoSelect.setReportDate(reportInfo.getReportDate());
			reportInfoSelect.setReportTime(reportInfo.getReportTime());
			reportInfoSelect.setOperatorCode(reportInfo.getOperatorCode());
			reportInfoSelect.setOperatorName(reportInfo.getOperatorName());
			reportInfoSelect.setRemark(reportInfo.getRemark());
			reportInfoSelect.setCaseStatus(reportInfo.getCaseStatus());
			reportInfoSelect.setNewCarFlag(reportInfo.getNewCarFlag());
			reportInfoSelect.setSessionState(reportInfo.getSessionState());
			reportInfoSelect.setOpenid(reportInfo.getOpenid());
			reportInfoSelect.setPhoneNumber(phoneNO);
			reportInfoSelect.setNickname(weiXinGzUserInfo.getNickname());
			reportInfoSelect.setHeadimgurl(weiXinGzUserInfo.getHeadimgurl());
			reportInfoSelect.setKindName(reportInfo.getKindName());
			reportInfoSelect.setCarModel(reportInfo.getCarModel());
			this.saveOrUpdate(reportInfoSelect);
		} else {
			reportInfo.setCreateTime(DateUtils.getTimestamp());
			this.save(reportInfo);
		}
	}

	public WeiXinGzUserInfo getWeiXinGzUserInfo(String openid) {
		WeiXinGzUserInfo weiXinGzUserInfo = new WeiXinGzUserInfo();
		List<WeiXinGzUserInfo> weiXinGzUserInfoList = this.findByProperty(
				WeiXinGzUserInfo.class, "openid", openid);
		if (weiXinGzUserInfoList.size() > 0)
			weiXinGzUserInfo = weiXinGzUserInfoList.get(0);
		return weiXinGzUserInfo;
	}

	@Override
	public Map<String, Object> getReportInfoByRegistNo(String registNo) {
		// TODO Auto-generated method stub
		Map<String, Object> reportInfoMap = this
				.findOneForJdbc(
						" select * from weixin_report_info where registno=? ",
						registNo);
		return reportInfoMap;
	}

	public List<ReportInfo> getReportInfoList(ReportInfo reportInfoo,String flagStr) {
		ReportInfo reportInfo = new ReportInfo();
		List<ReportInfo> reportInfoList = new ArrayList<ReportInfo>();
		String phone = "";
		phone = reportInfoo.getPhoneNumber();
		String openid = "";
		phone = reportInfoo.getOpenid();
		if("1".equals(flagStr)){
			reportInfo.setPhoneNumber(phone);	
		}else{
			reportInfo.setOpenid(openid);	
		}
		reportInfo.setRepairState(0);
		CriteriaQuery cq = new CriteriaQuery(ReportInfo.class);
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				reportInfo);
		cq.add();
		reportInfoList = this.getListByCriteriaQuery(cq, true);
		return reportInfoList;
	}

	@Override
	public boolean updReportInfoByRegistNo(String registNo) {
		// TODO Auto-generated method stub
		int result = this
				.executeSql(
						" update weixin_report_info set sessionState =0 where registNo = ? ",
						registNo);
		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updReportInfoByRegistNo(String registNo, int sessionState) {
		// TODO Auto-generated method stub
		int result = this
				.executeSql(
						" update weixin_report_info set sessionState =? where registNo = ? ",
						sessionState, registNo);
		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public ReportInfo getReportInfo(String registNo) {
		ReportInfo reportInfo = new ReportInfo();
		List<ReportInfo> reportInfoInfoList = this.findByProperty(
				ReportInfo.class, "registNo", registNo);
		if (reportInfoInfoList.size() > 0)
			reportInfo = reportInfoInfoList.get(0);
		return reportInfo;
	}

	@Override
	public List<ReportInfo> getReportInfoList(String openid) {
		return this.findByProperty(ReportInfo.class, "openid", openid);
	}

	// select count (*) from weixin_customer_service_chat_map ma ,
	// weixin_receive_message me where ma.message_id=me.ID and
	// ma.claim_registno='605012015000000000024' ;

	@Override
	public int getImageTotal(String registNo) {
		String sql = "select COUNT(me.ID) as total from weixin_customer_service_chat_map   ma , weixin_receive_message me   where me.msgtype='image' and ma.message_id=me.ID and ma.claim_registno=?";
		Map<String, Object> totalMap = this.findOneForJdbc(sql, registNo);
		String total = totalMap.get("total").toString();
		return Integer.parseInt(total);
	}

	@Override
	public ReportInfo getReportInfoByOpenid(String openid) {
		ReportInfo reportInfo = null;
		List<ReportInfo> reportInfoInfoList = this.findByProperty(
				ReportInfo.class, "openid", openid);
		if (reportInfoInfoList.size() > 0)
			reportInfo = reportInfoInfoList.get(0);
		return reportInfo;
	}

	@Override
	public ReportInfo getReportInfoByPhone(String phone) {
		ReportInfo reportInfo = null;
		List<ReportInfo> reportInfoInfoList = this.findByProperty(
				ReportInfo.class, "phoneNumber", phone);
		if (reportInfoInfoList.size() > 0)
			reportInfo = reportInfoInfoList.get(0);
		return reportInfo;
	}

	@Override
	public List<ReportInfo> getReportInfoListForRepair(String phone) {
		// TODO Auto-generated method stub
		String query = "from ReportInfo w where w.repairId is null and  w.phoneNumber ='"
				+ phone + "'";
		List<ReportInfo> reportInfoList = this.findByQueryString(query);
		return reportInfoList;
	}
 
	
	@Override
	public boolean isUnderwriting(String registNo,String openid) {
		List<ReportInfo> reportInfoInfoList = this.findByProperty(
				ReportInfo.class, "registNo", registNo);
		if(reportInfoInfoList!=null){
		if(reportInfoInfoList.size()>0){
			ReportInfo reportInfo=reportInfoInfoList.get(0);	
			if(!reportInfo.getOpenid().equals(openid)&&reportInfo.getUnderwritingTime()!=null) return false;			
		}
		}
		
		return true;
	}

	@Override
	public List<ReportInfo> getAutoConfirmReportInfoList() {
		//1、未被手工确认 2、理赔状态为核赔提交  3、当前时间-核赔时间 > 5分钟 
				String HQL = "  from  ReportInfo where confirmStyle is null and  caseStatus = 110 and  underwritingTime <=:endDate ";
			/*	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd ");
				String date = df.format(new java.util.Date(new java.util.Date()
						.getTime() - 5 * 60 * 1000));
				java.sql.Date endDate = java.sql.Date.valueOf(date);*/
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				  Date now = new Date();		 
				  Date endDate = new Date(now .getTime() - 5 * 60 * 1000);
				return this.getSession().createQuery(HQL)
						.setParameter("endDate", endDate).list();
	}

}
