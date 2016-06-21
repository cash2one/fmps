package cn.com.fubon.fo.repairplatform.entity.response;

import java.util.List;
import cn.com.fubon.common.entity.RepairCase;
import cn.com.fubon.fo.repairplatform.entity.BaseResult;

public class RepairCaseResponse extends BaseResult {	
	private List<RepairCase> repairCaseList; // 维修厂列表	

	public List<RepairCase> getRepairCaseList() {
		return repairCaseList;
	}

	public void setRepairCaseList(List<RepairCase> repairCaseList) {
		this.repairCaseList = repairCaseList;
	}
}
