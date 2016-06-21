package cn.com.fubon.fo.customernewcarlicence.service.impl;

import java.util.List;
import java.util.Map;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.fubon.fo.customernewcarlicence.service.CustomerNewCarLicenceService;


@Service("customerNewCarLicenceService")
@Transactional
public class CustomerNewCarLicenceServiceImpl extends CommonServiceImpl implements  
		CustomerNewCarLicenceService     {

	@Override
	public List<Map<String, Object>> getCustomerNewCarLicenceRecord(
			String identifynumber,String customercname , String  framenoList) {		 	
		return null;
	}

	@Override
	public Map<String, Object>  getCustomerPolicyNoAndCustomerID(String identifynumber,String customercname,String frameno){
	  return null;
	}
	
	@Override
	public Map<String, Object>  getWeiXinOpenId(String customerId){	 	
	          String  sql =" select openid from   weixin_gzuserinfo  where customercode=? " ;                       
			  Map<String, Object>   returnRecord= findOneForJdbc(sql,customerId);	
	return returnRecord;
	}
	
	@Override
	public List<Map<String, Object>> getNewCarHasLicenceRecord(
			String identifynumber,String customercname) {
		String sql ="select  li.frameno from weixin_newcar_licenseno li where li.identifynumber=? and li.customercname=? ";			  
		List<Map<String, Object>> returnList= this.findForJdbc(sql, new String[]{identifynumber,customercname} );		
		return returnList;
	}
	
	
	
}
