package cn.com.fubon.wechatClaims.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.system.pojo.base.TSBaseUser;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import weixin.guanjia.message.entity.ReceiveMessage;
import cn.com.fubon.util.Constants;
import cn.com.fubon.wechatClaims.entity.WeiXinCustomerServiceChatDetail;
import cn.com.fubon.wechatClaims.entity.WeiXinCustomerServiceChatInfo;
import cn.com.fubon.wechatClaims.service.CustomerChatService;

/**
 * 客服聊天记录类
 * 
 * @author patrick.z
 */
@Service("customerChatService")
@Transactional
public class CustomerChatServiceImpl extends CommonServiceImpl implements
		CustomerChatService {

	private static final Logger logger = Logger
			.getLogger(CustomerChatServiceImpl.class);

	@Override
	public List<Map<String, Object>> getWeiXinCustomerChatList(String registno) {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public void saveWeiXinCustomerServiceChatInfo(
			WeiXinCustomerServiceChatInfo weiXinCustomerServiceChatInfo) {
		// TODO Auto-generated method stub
		this.save(weiXinCustomerServiceChatInfo);
	}

	@Override
	public void saveWeiXinCustomerServiceChatDetail(
			WeiXinCustomerServiceChatDetail weiXinCustomerServiceChatDetail) {
		// TODO Auto-generated method stub
		this.save(weiXinCustomerServiceChatDetail);

	}

	@Override
	public List<Map<String, Object>> getRegistNoListByOperatorCode(
			String operatorCode,String roleCode) {
		// TODO Auto-generated method stub
		logger.debug("getRegistNoListByOperatorCode(String operatorCode,String roleCode)"
				+ operatorCode+roleCode);
		boolean tag = checkUserRole(roleCode);
		List<Map<String, Object>> registNoList = new ArrayList<Map<String, Object>>();
		String sql = " select distinct re.registNo,re.reportorName,re.licenseNo,re.reportDate,re.reportTime,re.operatorCode,"
				+ "re.certiMaterialType,re.remark,re.caseStatus,re.newCarFlag,re.openid,re.nickname,re.headimgurl,"
				+ "re.sessionState,"
				+ "(select count(*) from weixin_customer_service_chat_map where 1=1 "
				+ "and message_readed =0  and claim_registno= re.registNo"
				+ ") as messageTotal,"
				+ "(select distinct count(licenseNo) from weixin_report_info where openid= re.openid"
				+ ") as licenseTotal,"
				+ "(select distinct count(openid) from weixin_report_info where licenseNo = re.licenseNo"
				+ ") as openidTotal "
				+ "from weixin_report_info re left join weixin_customer_service_chat_map mp "
				+ "on mp.claim_registno = re.registNo " + "where 1=1 ";
		if (tag) {
			sql += "and re.operatorCode=? ";
		}
			sql += "and ("
				+ "mp.message_readed <> 1 or re.sessionState = 1" //and re.caseStatus=1 
				+ ")";

		sql += " order by reportDate desc";
		if (tag) {
			registNoList = this.findForJdbc(sql, new String[] { operatorCode });
		} else {
			registNoList = this.findForJdbc(sql);
		}

		return registNoList;
	}

	@Override
	public List<Map<String, Object>> getHistoryRegistNoListByOperatorCode(
			String operatorCode, String roleCode,String licenseNo, String registNo,
			String startTime, String endTime) {
		// TODO Auto-generated method stub
		logger.debug("getHistoryRegistNoListByOperatorCode(String operatorCode, String roleCode,String licenseNo, String registNo,"
			+"String startTime, String endTime)"
				+ operatorCode+roleCode+licenseNo+registNo+startTime+endTime);
		boolean tag = checkUserRole(roleCode);
		List<Map<String, Object>> registNoList = new ArrayList<Map<String, Object>>();
		String sql = " select distinct re.registNo,re.reportorName,re.licenseNo,re.reportDate,re.reportTime,re.operatorCode,"
				+ "re.certiMaterialType,re.remark,re.caseStatus,re.newCarFlag,re.openid,re.nickname,re.headimgurl,"
				+ "re.sessionState "
				+ "from weixin_report_info re left join weixin_customer_service_chat_map mp "
				+ "on mp.claim_registno = re.registNo "
				+ "where 1=1 ";
				//+ "and re.caseStatus=1 ";
		if (tag) {// 非admin加工号限制条件
			sql += "and re.operatorCode=? ";
		}
		if (!StringUtils.isEmpty(licenseNo)) {
			sql += "and re.licenseNo like '" + licenseNo + "%'";
		}
		if (!StringUtils.isEmpty(startTime)) {
			sql += "and date_format(concat(re.reportDate,' ',re.reportTime),'%Y-%c-%d %H:%i:%s') >= date_format('"
					+ startTime + "','%Y-%c-%d %H:%i:%s') ";
		}
		if (!StringUtils.isEmpty(endTime)) {
			sql += "and date_format(concat(re.reportDate,' ',re.reportTime),'%Y-%c-%d %H:%i:%s') <=  date_format('"
					+ endTime + "','%Y-%c-%d %H:%i:%s') ";
		}
		if (!StringUtils.isEmpty(registNo)) {
			sql += "and re.registNo ='" + registNo + "'";
		}
		if (tag) {// 非admin加工号限制条件
			registNoList = this.findForJdbc(sql, new String[] { operatorCode });
		} else {
			registNoList = this.findForJdbc(sql);
		}
		
		return registNoList;
	}

	@Override
	public List<Map<String, Object>> getCustomerServiceChatList(String registNo) {
		// TODO Auto-generated method stub
		logger.debug("getCustomerServiceChatReaded(String registNo)" + registNo);
		String sql = " select * from weixin_customer_service_chat_map "
				+ "where 1=1 " + "and claim_registno = ? "
				+ "order by createtime ";
		List<Map<String, Object>> registNoList = this.findForJdbc(sql,
				new String[] { registNo });
		return registNoList;
	}

	@Override
	public List<Map<String, Object>> getCustomerServiceChatNotReaded(
			String registNo) {
		// TODO Auto-generated method stub
		logger.debug("getCustomerServiceChatNotReaded(String registNo)" + registNo);
		String sql = " select *,cscm.ID as cid from weixin_customer_service_chat_map cscm,weixin_receive_message rm "
				+ "where 1=1 " 
				+ "and cscm.message_id = rm.ID "
				+ "and cscm.claim_registno = ? "
				+ "and cscm.message_readed = "+Constants.WECHATCLAIMS_MESSAGE_NOTREADED
				+ " and cscm.message_source= "+Constants.WECHATCLAIMS_MESSAGE_SOURCE_USER
				+ " order by cscm.createtime ";
		List<Map<String, Object>> registNoList = this.findForJdbc(sql,
				new String[] { registNo });
		return registNoList;
	}
	
	@Override
	public int getCustomerServiceChatReadedImages(String registNo) {
		String sql = " select count(*) as readedCount "
				+ "  from weixin_customer_service_chat_map cscm, weixin_receive_message rm " 
				+ " where 1 = 1"
				+ "   and cscm.message_id = rm.ID "
				+ "   and cscm.claim_registno = ? "
				+ "	  and cscm.message_readed = "+Constants.WECHATCLAIMS_MESSAGE_READED
				+ "   and cscm.message_source= "+Constants.WECHATCLAIMS_MESSAGE_SOURCE_USER
				+ "   and rm.msgtype = 'image' "
				+ " order by cscm.createtime ";
		Map<String,Object> map = this.findOneForJdbc(sql,new String[] { registNo });
		return Integer.parseInt(String.valueOf(map.get("readedCount")));
	}

	@Override
	public List<Map<String, Object>> getCustomerServiceChatReaded(
			String registNo) {
		// TODO Auto-generated method stub
		logger.debug("getCustomerServiceChatReaded(String registNo)"
				+ registNo);
		String sql = " select * from ("
				+ "SELECT * FROM weixin_customer_service_chat_map "
				+ "where 1=1" + " and claim_registno = ? "
				+ "and message_readed = "+Constants.WECHATCLAIMS_MESSAGE_READED
				+ " ORDER BY createtime desc LIMIT 10) csm "
				+ "order by csm.createtime";
		List<Map<String, Object>> registNoList = this.findForJdbc(sql,
				new String[] { registNo });
		return registNoList;
	}

	@Override
	public boolean updCustomerServiceChatMessageReadedById(String id) {
		// TODO Auto-generated method stub
		logger.debug("updCustomerServiceChatMessageReadedById(String id)" + id);
		String sql = "update weixin_customer_service_chat_map set message_readed="+Constants.WECHATCLAIMS_MESSAGE_READED
				+" where id in("
				+ id + ")";
		int rowInt = this.updateBySqlString(sql);
		if (rowInt >= 1) {
			logger.debug("update success,return value:" + rowInt);
			return true;
		} else {
			logger.debug("update fail,return value:" + rowInt);
			return false;
		}
	}

	@Override
	public WeiXinCustomerServiceChatInfo getWeiXinCustomerServiceChatInfo(
			String id) {
		// TODO Auto-generated method stub
		return this.get(WeiXinCustomerServiceChatInfo.class, id);
	}

	@Override
	public ReceiveMessage getReceiveMessage(String id) {
		// TODO Auto-generated method stub
		return this.get(ReceiveMessage.class, id);
	}

	@Override
	public TSBaseUser getTSBaseUser(String operatorCode) {
		// TODO Auto-generated method stub
		return this.findUniqueByProperty(TSBaseUser.class, "userName",
				operatorCode);
	}
	
	/**
	 *检测用户角色(admin和微理赔主管可看到全部的案件)
	 */
	@SuppressWarnings("unused")
	private boolean checkUserRole(String roleCode){
		boolean chkRes = true;
		String chkRoleCode = "";
		List<String> roleCodeList =(List<String>)StringUtil.parseString2ListByCustomerPattern(",",roleCode);
		if(roleCodeList.size()>0){
			chkRoleCode = roleCodeList.get(0);
		}
		if (chkRoleCode.equals(Constants.WEIXIN_USER_ROLE_ADMIN) || chkRoleCode.equals(Constants.WEIXIN_USER_ROLE_WECHAT_ADMIN)) {
			chkRes = false;
		}
		return chkRes;
	}

	@Override
	public Map<String, Object> getLastCustomerServiceChatList(
			String registNo) {
		// TODO Auto-generated method stub
		Map<String, Object> customerServiceChatMap = null;
		String sql = " select * from weixin_customer_service_chat_map "
				+ "where 1=1 " + "and claim_registno = ? "
				+ "order by createtime  desc LIMIT 1";
		List<Map<String, Object>> registNoList = this.findForJdbc(sql,
				new String[] { registNo });
		if(registNoList!=null && registNoList.size()>0){
			customerServiceChatMap = registNoList.get(0);
		}
		return customerServiceChatMap;
	}

	@Override
	public List<Map<String, Object>> getTimeoutTWRegistNoListByOperatorCode(
			String operatorCode, String roleCode) {
		// TODO Auto-generated method stub
		boolean tag = checkUserRole(roleCode);
		List<Map<String, Object>> registNoList = new ArrayList<Map<String, Object>>();
		String sql = " select distinct re.registNo,re.reportorName,re.licenseNo,re.reportDate,re.reportTime,re.operatorCode,"
				+ "re.certiMaterialType,re.remark,re.caseStatus,re.newCarFlag,re.openid,re.nickname,re.headimgurl,"
				+ "re.sessionState "
				+ "from weixin_report_info re left join weixin_customer_service_chat_map mp "
				+ "on mp.claim_registno = re.registNo " + "where 1=1 ";
		if (tag) {
			sql += "and re.operatorCode=? ";
		}
			sql += "and TIMESTAMPDIFF(MINUTE,"
				+ "(select createtime from weixin_customer_service_chat_map where 1=1 and claim_registno = re.registNo order by createtime  desc LIMIT 1)"
				+ ", now()) = 25 "
				+ "and ("
				+ "mp.message_readed <> "+Constants.WECHATCLAIMS_MESSAGE_READED+" or re.sessionState ="+Constants.WECHATCLAIMS_REGISTNO_SESSTIONSTATE_LINE //and re.caseStatus=1 
				+ ")";

		if (tag) {
			registNoList = this.findForJdbc(sql, new String[] { operatorCode });
		} else {
			registNoList = this.findForJdbc(sql);
		}

		return registNoList;
	}

	@Override
	public List<Map<String, Object>> getTimeoutTHRegistNoListByOperatorCode(
			String operatorCode, String roleCode) {
		// TODO Auto-generated method stub
		boolean tag = checkUserRole(roleCode);
		List<Map<String, Object>> registNoList = new ArrayList<Map<String, Object>>();
		String sql = " select distinct re.registNo,re.reportorName,re.licenseNo,re.reportDate,re.reportTime,re.operatorCode,"
				+ "re.certiMaterialType,re.remark,re.caseStatus,re.newCarFlag,re.openid,re.nickname,re.headimgurl,"
				+ "re.sessionState "
				+ "from weixin_report_info re left join weixin_customer_service_chat_map mp "
				+ "on mp.claim_registno = re.registNo " + "where 1=1 ";
		if (tag) {
			sql += "and re.operatorCode=? ";
		}
		sql += "and TIMESTAMPDIFF(MINUTE,"
				+ "(select createtime from weixin_customer_service_chat_map where 1=1 and claim_registno = re.registNo order by createtime  desc LIMIT 1)"
				+ ", now()) >= 30 "
				+ "and ("
				+ "mp.message_readed <> "+Constants.WECHATCLAIMS_MESSAGE_READED+" or re.sessionState = "+Constants.WECHATCLAIMS_REGISTNO_SESSTIONSTATE_LINE //and re.caseStatus=1 
				+ ")";

		if (tag) {
			registNoList = this.findForJdbc(sql, new String[] { operatorCode });
		} else {
			registNoList = this.findForJdbc(sql);
		}

		return registNoList;
	}

	@Override
	public List<Map<String, Object>> getPageHistoryRegistNoListByOperatorCode(
			int currPageNo, String operatorCode, String roleCode,
			String licenseNo, String registNo, String startTime, String endTime) {
		// TODO Auto-generated method stub
		logger.debug("getHistoryPageRegistNoListByOperatorCode(int currPageNo,String operatorCode, String roleCode,String licenseNo, String registNo,"
			+"String startTime, String endTime)"
			+currPageNo+ operatorCode+roleCode+licenseNo+registNo+startTime+endTime);
		
		//当前页起始记录数处理
		int pageNumber=0;
		if(currPageNo > 1){
			pageNumber =  (currPageNo-1) * Constants.WECHATCLAIMS_REGISTNO_PAGESIZE;
		}
		
		boolean tag = checkUserRole(roleCode);
		List<Map<String, Object>> registNoList = new ArrayList<Map<String, Object>>();
		String sql = " select distinct re.registNo,re.reportorName,re.licenseNo,re.reportDate,re.reportTime,re.operatorCode,"
				+ "re.certiMaterialType,re.remark,re.caseStatus,re.newCarFlag,re.openid,re.nickname,re.headimgurl,"
				+ "re.sessionState "
				+ "from weixin_report_info re left join weixin_customer_service_chat_map mp "
				+ "on mp.claim_registno = re.registNo "
				+ "where 1=1 ";
				//+ "and re.caseStatus=1 ";
		if (tag) {// 非admin加工号限制条件
			sql += "and re.operatorCode=? ";
		}
		if (!StringUtils.isEmpty(licenseNo)) {
			sql += "and re.licenseNo like '" + licenseNo + "%'";
		}
		if (!StringUtils.isEmpty(startTime)) {
			sql += "and date_format(concat(re.reportDate,' ',re.reportTime),'%Y-%c-%d %H:%i:%s') >= date_format('"
					+ startTime + "','%Y-%c-%d %H:%i:%s') ";
		}
		if (!StringUtils.isEmpty(endTime)) {
			sql += "and date_format(concat(re.reportDate,' ',re.reportTime),'%Y-%c-%d %H:%i:%s') <=  date_format('"
					+ endTime + "','%Y-%c-%d %H:%i:%s') ";
		}
		if (!StringUtils.isEmpty(registNo)) {
			sql += "and re.registNo ='" + registNo + "'";
		}
		sql += " ORDER BY re.reportDate desc LIMIT "+pageNumber+","+Constants.WECHATCLAIMS_REGISTNO_PAGESIZE;
		if (tag) {// 非admin加工号限制条件
			registNoList = this.findForJdbc(sql, new String[] { operatorCode });
		} else {
			registNoList = this.findForJdbc(sql);
		}
		
		return registNoList;
	}
}
