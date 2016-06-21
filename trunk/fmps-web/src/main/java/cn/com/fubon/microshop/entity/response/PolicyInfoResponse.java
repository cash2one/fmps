package cn.com.fubon.microshop.entity.response;

import cn.com.fubon.fo.card.entity.Policy;
import cn.com.fubon.rest.entity.BaseResult;

public class PolicyInfoResponse extends BaseResult {
	
	private Policy policy; // 保单信息

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}
	
	

}
