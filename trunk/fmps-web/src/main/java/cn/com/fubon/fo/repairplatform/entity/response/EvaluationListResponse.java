package cn.com.fubon.fo.repairplatform.entity.response;

import java.util.List;

import cn.com.fubon.common.entity.WeixinEvaluation;
import cn.com.fubon.fo.repairplatform.entity.BaseResult;

public class EvaluationListResponse extends BaseResult {
	private List<WeixinEvaluation> evaluationList; // 评价列表

	public List<WeixinEvaluation> getEvaluationList() {
		return evaluationList;
	}

	public void setEvaluationList(List<WeixinEvaluation> evaluationList) {
		this.evaluationList = evaluationList;
	}
	
	

}
