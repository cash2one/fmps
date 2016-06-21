package cn.com.fubon.fo.repairplatform.service;

import org.jeecgframework.core.common.service.CommonService;

import cn.com.fubon.fo.repairplatform.entity.BaseResult;
import cn.com.fubon.fo.repairplatform.entity.request.EvaluationSaveRequest;
import cn.com.fubon.fo.repairplatform.entity.request.GiftSetDetailRequest;
import cn.com.fubon.fo.repairplatform.entity.request.ReceiveGiftSetRequest;
import cn.com.fubon.fo.repairplatform.entity.request.RepairCaseListRequest;
import cn.com.fubon.fo.repairplatform.entity.request.RepairEntityRequest;
import cn.com.fubon.fo.repairplatform.entity.request.RepairListRequest;
import cn.com.fubon.fo.repairplatform.entity.response.GiftSetDetailResponse;
import cn.com.fubon.fo.repairplatform.entity.response.ReceiveGiftSetResponse;
import cn.com.fubon.fo.repairplatform.entity.response.RepairCaseResponse;
import cn.com.fubon.fo.repairplatform.entity.response.RepairEntityResponse;
import cn.com.fubon.fo.repairplatform.entity.response.RepairListResponse;

public interface RepairPlatformWsService extends CommonService {

	/**
	 * 获取维修厂列表
	 * 
	 * @param repairListRequest
	 * @return
	 */
	public String getRepairListResponse(
			RepairListRequest repairListRequest, String seqId );

	/*
	 * 获取单个维修厂信息（含评价）
	 */
	public RepairEntityResponse getRepairEntityResponse(
			RepairEntityRequest repairEntityRequest);

	/*
	 * 发送评价报文给企业号
	 */
	public BaseResult getEvaluationSave(
			EvaluationSaveRequest evaluationSaveRequest);

	/*
	 * 发送案件处理给企业号
	 */
	public BaseResult getRepairCaseListResponse(
			RepairCaseListRequest repairCaseListRequest);
	
	/*
	 * 获取维修厂活动券详情信息接口
	 */
	public GiftSetDetailResponse getGiftSetDetailResponse(
			GiftSetDetailRequest giftSetDetailRequest);
	
	/*
	 * 领用活动券接口
	 */
	public ReceiveGiftSetResponse receiveGiftSetResponse(
			ReceiveGiftSetRequest receiveGiftSetRequest);
}
