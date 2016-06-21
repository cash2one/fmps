/**
 * 
 */
package cn.com.fubon.fo.card.service.imp;

import java.util.List;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.DataGridReturn;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.fubon.fo.card.entity.Customer;
import cn.com.fubon.fo.card.entity.PolicyInsured;
import cn.com.fubon.fo.card.service.IPolicyInsuredService;

/**
 * 卡单激活模块service
 * 
 * @author guojunjie
 *
 */
@Service("policyInsuredService")
@Transactional
public class PolicyInsuredServiceImp extends CommonServiceImpl implements
		IPolicyInsuredService {
	private static final Logger logger = Logger
			.getLogger(PolicyInsuredServiceImp.class);

	@Override
	public DataGridReturn getDataGridReturn(CriteriaQuery cq, boolean isOffset) {
		return super.getDataGridReturn(cq, isOffset);
	}

	@Override
	public <T> List<T> getList(Class clas) {
		return super.getList(clas);
	}

	@Override
	public PolicyInsured getPolicyInsured(Customer insured, String cardno,
			String identity) {
		List<PolicyInsured> policyInsuredList = this.findByProperty(
				PolicyInsured.class, "policyno", cardno); // 后续加入证件类型
		if (policyInsuredList.size() > 0) {
			return policyInsuredList.get(0);
		} else {
			PolicyInsured policyInsured = new PolicyInsured();
			policyInsured.setCustomer(insured);
			policyInsured.setPolicyno(cardno);
			policyInsured.setIdentity(identity);
			this.save(policyInsured);
			return policyInsured;
		}
	}
}
