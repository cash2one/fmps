package cn.com.fubon.fo.customerclaims.service.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.com.fubon.fo.customerclaims.dao.NewCustomerClaimsDao;
import cn.com.fubon.fo.customerclaims.service.NewCustomerClaimsService;

/**
 * 
 * @author fbxmn07
 *
 */
@Service("newCustomerClaimsService")
@Transactional
public class NewCustomerClaimsServiceImpl extends CommonServiceImpl implements NewCustomerClaimsService {

	@Resource
	private NewCustomerClaimsDao newCustomerClaimsDao;
	
	@Override
	public List<Map<String, Object>> getIndexInfo(String insuredname,
			String identifynumber) {
		return newCustomerClaimsDao.getIndexInfo(insuredname, identifynumber);
	}

	@Override
	public List<Map<String, Object>> getDetailInfo(String registno) {
		return newCustomerClaimsDao.getDetailInfo(registno);
	}

	@Override
	public Map<String, Object> getClaimRecordInfo(String id) {
		return newCustomerClaimsDao.getClaimRecordInfo(id);
	}


}
