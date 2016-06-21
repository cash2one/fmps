package cn.com.fubon.fo.repairplatform.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.web.system.pojo.base.TSType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.fubon.fo.repairplatform.dao.RepairPlatformDao;
import cn.com.fubon.fo.repairplatform.entity.WeixinRepairEvaluation;
import cn.com.fubon.fo.repairplatform.entity.WeixinRepairPlatform;
import cn.com.fubon.fo.repairplatform.service.RepairPlatformService;

@Service("repairPlatformService")
@Transactional
public class RepairPlatformServiceImpl extends CommonServiceImpl implements
		RepairPlatformService {
	@Resource
	public RepairPlatformDao repairPlatformDao;

	/**
	 * 
	 */
	@Override
	public List<WeixinRepairPlatform> getRepairPlatformList(String city) {
		return this.findByProperty(WeixinRepairPlatform.class, "city", city);
	}

	/**
	 * 
	 */
	@Override
	public List<Map<String, Object>> getCity() {
		return this
				.findForJdbc("select distinct we.city from weixin_repair_platform we");

	}

	/*
	 * @Override public List<WeixinRepairEvaluation> findChannelList(int start,
	 * int count) throws Exception { // TODO Auto-generated method stub String
	 * sql = "select * from weixin_repair_evaluation LIMIT 0,1 ";
	 * List<WeixinRepairEvaluation> weixinRepairEvaluation = ; return
	 * weixinRepairEvaluation; }
	 */

	// public List<WeixinRepairEvaluation> findEvaluationList(int start,
	// int count, DetachedCriteria dc) {
	// // 统计的总行数
	// dc.setProjection(Projections.rowCount());
	// // 清空统计函数
	// dc.setProjection(null);
	// // dc.setResultTransformer(dc.DISTINCT_ROOT_ENTITY);
	// List<WeixinRepairEvaluation> weixinRepairEvaluation = this.pageList(dc,
	// start, count);
	//
	// return weixinRepairEvaluation;
	//
	// }

	public List<WeixinRepairEvaluation> findEvaluationList(int start,
			int count, String evaluationstate, String repairId) {
		String sql = "";
		String order = " and comment is not null and  evaluation is not null order by createtime desc";
		if (evaluationstate.equals("1")) {
			sql = "select * from weixin_repair_evaluation where repairid=?"
					+ repairId + order;
		}
		if (evaluationstate.equals("2")) {
			sql = "select * from weixin_repair_evaluation  where repairid=?"
					+ repairId + " and evaluation BETWEEN 4 and 5 " + order;

		}
		if (evaluationstate.equals("3")) {
			sql = "select * from weixin_repair_evaluation  where repairid=?"
					+ repairId + " and evaluation BETWEEN 1 and 3" + order;

		}

		List<WeixinRepairEvaluation> weixinRepairEvaluation = this
				.findObjForJdbc(sql, start, count, WeixinRepairEvaluation.class);

		return weixinRepairEvaluation;

	}

	public List<Map<String, Object>> findEvaluationListt(int start, int count,
			String evaluationstate, String repairId) {
		String sql = "";
		String order = " and comment is not null and  evaluation is not null order by createtime desc";
		if (evaluationstate.equals("1")) {
			sql = "select * from weixin_repair_evaluation where repairid=? "
					+ order;
		}
		if (evaluationstate.equals("2")) {
			sql = "select * from weixin_repair_evaluation  where repairid=? and evaluation BETWEEN 4 and 5 "
					+ order;

		}
		if (evaluationstate.equals("3")) {
			sql = "select * from weixin_repair_evaluation  where repairid=? and evaluation BETWEEN 1 and 3"
					+ order;

		}

		List<Map<String, Object>> weixinRepairEvaluations = this
				.findForJdbcParam(sql, start, count, new String[] { repairId });

		return weixinRepairEvaluations;

	}

	/**
	 * 从数字字典里取出地区
	 * 
	 * @author qingqu.huang
	 * @date 20150702
	 * @param typegroupcode
	 * @return
	 */
	@Override
	public List<TSType> getCityFromTSType(String typegroupcode) {
		return repairPlatformDao.getCityFromTSType(typegroupcode);
	}
}
