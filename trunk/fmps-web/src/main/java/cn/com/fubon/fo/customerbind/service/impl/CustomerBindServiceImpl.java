package cn.com.fubon.fo.customerbind.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import weixin.util.WeiXinConstants;
import cn.com.fubon.fo.customerbind.dao.CustomerBindDao;
import cn.com.fubon.fo.customerbind.entity.WeiXinGzUserInfo;
import cn.com.fubon.fo.customerbind.service.CustomerBindService;

@Service("customerBindService")
@Transactional
public class CustomerBindServiceImpl extends CommonServiceImpl implements CustomerBindService{
	
	@Resource
	private CustomerBindDao oracleCustomerBindDao;
	@Resource
	private CustomerBindDao customerBindDao;

	@Override
	public Map<String,String> findCustomerInfo(String identifynumber,String customercname) {
		return oracleCustomerBindDao.findCustomerInfo(identifynumber,customercname);
	}
	
	/**
	 * 根据openid判断是否已绑定,已关注且认证时间不为空 modified by guofangfang 20150730
	 * @param openid
	 * @return
	 */
	@Override
	public boolean isBinded(String openid){
		WeiXinGzUserInfo weiXinGzUserInfo = this.findUniqueByProperty(WeiXinGzUserInfo.class, "openid", openid);
		if(weiXinGzUserInfo == null || !WeiXinConstants.SUBSCRIBE_TYPE_VALUE.equals(weiXinGzUserInfo.getSubscribe())
				|| weiXinGzUserInfo.getBindTime() == null){
			return false;
			
		}
		
		return true;
	}

	@Override
	public boolean isBinded(String identifynumber,String customercname){
		String sql = "select count(*) from weixin_gzuserinfo where bindtime is not null and upper(identifynumber)=? and customercname=?";
		long bindCount = getCountForJdbcParam(sql,new Object[]{identifynumber,customercname});
		return bindCount > 0;
	}

	/**
	 * 根据openid判断用户是否为车险用户，判断依据为车牌号licenseno是否为null. add by zhangyaoming 20160104
	 * @param openid
	 * @return
	 */
	@Override
	public boolean isAutoInsuranceCustomer(String openid) {
		WeiXinGzUserInfo weiXinGzUserInfo = this.findUniqueByProperty(WeiXinGzUserInfo.class, "openid", openid);
		if(weiXinGzUserInfo == null || weiXinGzUserInfo.getLicenseno() == null){
			return false;
		}
		
		return true;
	}
	
	/**
	 * 根据openid判断是否已认证,认证时间不为空 add by zhangyaoming 20160115
	 * @param openid
	 * @return
	 */
	@Override
	public boolean isAuthenticated(String openid){
		WeiXinGzUserInfo weiXinGzUserInfo = this.findUniqueByProperty(WeiXinGzUserInfo.class, "openid", openid);
		if(weiXinGzUserInfo == null || weiXinGzUserInfo.getBindTime() == null){
			return false;
			
		}
		
		return true;
	}
	
	
	public  List<WeiXinGzUserInfo> findBindCustemer(){
		WeiXinGzUserInfo weiXinGzUserInfo = new WeiXinGzUserInfo();
		CriteriaQuery cq = new CriteriaQuery(WeiXinGzUserInfo.class);
		cq.isNotNull("bindTime");
		cq.isNotNull("mobile");
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				weiXinGzUserInfo);
		List<WeiXinGzUserInfo> wguiList = this.getListByCriteriaQuery(cq, false);
			
	return wguiList;
	}

}
