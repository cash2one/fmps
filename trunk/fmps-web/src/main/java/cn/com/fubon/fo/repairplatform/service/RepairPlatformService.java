package cn.com.fubon.fo.repairplatform.service;

import java.util.List;
import java.util.Map;

import org.jeecgframework.core.common.service.CommonService;
import org.jeecgframework.web.system.pojo.base.TSType;

import cn.com.fubon.fo.repairplatform.entity.WeixinRepairEvaluation;
import cn.com.fubon.fo.repairplatform.entity.WeixinRepairPlatform;

public interface RepairPlatformService extends CommonService {

	/**
	 * 根据城市区号查询维修厂列表
	 * 
	 * @param AreaCode
	 * @return
	 */
	public List<WeixinRepairPlatform> getRepairPlatformList(String zoneCode);

	/**
	 * 返回不从复的城市列表
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getCity();

	/**
	 * 从数字字典里取出地区
	 * 
	 * @author qingqu.huang
	 * @date 20150702
	 * @param typegroupcode
	 * @return
	 */
	public List<TSType> getCityFromTSType(String typegroupcode);

	public List<WeixinRepairEvaluation> findEvaluationList(int start,
			int count, String evaluationstate, String repairId);

	public List<Map<String, Object>> findEvaluationListt(int start, int count,
			String evaluationstate, String repairId);

}
