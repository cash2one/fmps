package cn.com.fubon.reportform.user.service.impl;

import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.DataGridReturn;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.fubon.reportform.user.service.IGasolineGiftReportService;

/**
 * 加油宝报表
 * 
 * @author yaoming.zhang
 * @date 2015-10-27
 */
@Service("GasolineGiftReportService")
@Transactional
public class GasolineGiftReportServiceImpl extends CommonServiceImpl implements
		IGasolineGiftReportService {

	@Override
	public DataGridReturn getDataGridReturn(CriteriaQuery cq, boolean isOffset) {
		return super.getDataGridReturn(cq, isOffset);
	}

}
