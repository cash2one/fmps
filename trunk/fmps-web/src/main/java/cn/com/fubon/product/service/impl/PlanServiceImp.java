/**
 * 
 */
package cn.com.fubon.product.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.DataGridReturn;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.fubon.product.service.IPlanService;

/**
 * 卡单激活模块service
 * 
 * @author guojunjie
 *
 */
@Service("planService")
@Transactional
public class PlanServiceImp extends CommonServiceImpl implements IPlanService {
	private static final Logger logger = Logger.getLogger(PlanServiceImp.class);

	@Override
	public DataGridReturn getDataGridReturn(CriteriaQuery cq, boolean isOffset) {
		return super.getDataGridReturn(cq, isOffset);
	}

	@Override
	public <T> List<T> getList(Class clas) {
		return super.getList(clas);
	}

}
