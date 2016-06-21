/**
 * 
 */
package cn.com.fubon.fo.card.service.imp;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.DataGridReturn;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.com.fubon.fo.card.entity.Customer;
import cn.com.fubon.fo.card.entity.Policy;
import cn.com.fubon.fo.card.entity.PolicyInsured;
import cn.com.fubon.fo.card.service.IPolicyService;
import cn.com.fubon.fo.totaiwan.entity.TaiwanConstants;

/**
 * 卡单激活模块service
 * 
 * @author guojunjie
 *
 */
@Service("policyService")
@Transactional
public class PolicyServiceImp extends CommonServiceImpl implements
		IPolicyService {
	private static final Logger logger = Logger
			.getLogger(PolicyServiceImp.class);

	@Override
	public DataGridReturn getDataGridReturn(CriteriaQuery cq, boolean isOffset) {
		return super.getDataGridReturn(cq, isOffset);
	}

	@Override
	public <T> List<T> getList(Class clas) {
		return super.getList(clas);
	}

	public Policy getPolicy(String policyNo) {
		Policy policy = null;
		List<Policy> policyList = this.findByProperty(Policy.class, "policyno",
				policyNo);
		if (policyList.size() > 0) {
			policy = policyList.get(0);
		} else {
			policy = new Policy();
		}
		return policy;
	}

	@Override
	public Policy getPolicyByOrderNo(String orderno) {
		Policy policy = null;
		List<Policy> policyList = this.findByProperty(Policy.class, "orderno",
				orderno);
		if (policyList.size() > 0) {
			policy = policyList.get(0);
		}	
	    if(policy != null){
	    	//获取被保险人
	    	List<Customer> insuredList=new ArrayList<Customer>();
	    	List<PolicyInsured> policyInsuredList=this.findByProperty(PolicyInsured.class, "orderno",orderno);	
	    	for(PolicyInsured policyInsured:policyInsuredList){
	    		Customer customer= policyInsured.getCustomer();
	    		customer.setOccupationgrade(policyInsured.getOccupationgrade());//职业类别（1~6）
	    		customer.setOccupationcode(policyInsured.getOccupationcode());//职业代码
	    		customer.setOccupationname(policyInsured.getOccupationname());//职业类别中文名称
	    		insuredList.add(customer); 
	    	}
	    	policy.setInsuredList(insuredList);		
	    }
		return policy;	 
	}

	@Override
	public void setPolicyNoByOrderNo(String orderno, String policyNo) {
		Policy policy = this.findByProperty(Policy.class, "orderno",orderno).get(0);
		policy.setPolicyno(policyNo);
		policy.setType(TaiwanConstants.POLICYTYPE_2);
		policy.setStatus(TaiwanConstants.POLICYSTATUS_2);
		this.updateEntitie(policy);
		List<PolicyInsured> policyInsuredList = this.findByProperty(PolicyInsured.class, "orderno",orderno) ;
		for(PolicyInsured policyInsured:policyInsuredList){
			policyInsured.setPolicyno(policyNo); 
			this.updateEntitie(policyInsured);
		}		
	}
}
