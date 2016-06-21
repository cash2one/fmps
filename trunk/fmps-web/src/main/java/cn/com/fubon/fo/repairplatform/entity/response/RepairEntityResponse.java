package cn.com.fubon.fo.repairplatform.entity.response;

import java.util.List;

import cn.com.fubon.common.entity.WeixinEvaluation;
import cn.com.fubon.common.entity.WeixinGiftSet;
import cn.com.fubon.common.entity.WeixinRepair;
import cn.com.fubon.common.entity.WeixinRepairImageUrl;
import cn.com.fubon.fo.repairplatform.entity.BaseResult;

public class RepairEntityResponse  extends BaseResult {
	
	private WeixinRepair repair; // 维修厂信息
	private  String	count; //评价数量
	private List<WeixinRepairImageUrl> repairImageList; //维修厂图片列表 
	private List<WeixinEvaluation> evaluationList; // 评价列表
	private String toBeEvaluated; // 待评价数量
	private List<WeixinGiftSet> giftSetList; //礼包
	private List<WeixinGiftSet> carWashList;  //洗车券 
	
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}	
	public WeixinRepair getRepair() {
		return repair;
	}
	public void setRepair(WeixinRepair repair) {
		this.repair = repair;
	}
	public List<WeixinRepairImageUrl> getRepairImageList() {
		return repairImageList;
	}
	public void setRepairImageList(List<WeixinRepairImageUrl> repairImageList) {
		this.repairImageList = repairImageList;
	}
	public List<WeixinEvaluation> getEvaluationList() {
		return evaluationList;
	}
	public void setEvaluationList(List<WeixinEvaluation> evaluationList) {
		this.evaluationList = evaluationList;
	}
	public String getToBeEvaluated() {
		return toBeEvaluated;
	}
	public void setToBeEvaluated(String toBeEvaluated) {
		this.toBeEvaluated = toBeEvaluated;
	}
	public List<WeixinGiftSet> getGiftSetList() {
		return giftSetList;
	}
	public void setGiftSetList(List<WeixinGiftSet> giftSetList) {
		this.giftSetList = giftSetList;
	}
	public List<WeixinGiftSet> getCarWashList() {
		return carWashList;
	}
	public void setCarWashList(List<WeixinGiftSet> carWashList) {
		this.carWashList = carWashList;
	}
	
}
