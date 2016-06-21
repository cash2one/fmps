package cn.com.fubon.fo.gasolinegift.service.impl;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.fubon.fo.common.dao.impl.OracleGenericBaseCommonDao;
import cn.com.fubon.fo.gasolinegift.service.OracleCarQuery;

@Service("oracleCarQuery")
@Transactional
public class OracleCarQueryImpl extends OracleGenericBaseCommonDao implements
		OracleCarQuery {
	
	public List<Map<String, Object>> queryOracleCarLicensenoList(String insuredname,String identifynumber ){
		
		String sql="select distinct ca.licenseno as licenseno from NETQUERYCITEM_CAR ca ,NETQUERYINSURED ins "  
                  +" where ca.policyno=ins.policyno "
                  +" and ins.insuredname=?" 
                  +" and ins.identifynumber=?";
		return this.findForJdbc(sql,insuredname,identifynumber);		
	}
	
}
