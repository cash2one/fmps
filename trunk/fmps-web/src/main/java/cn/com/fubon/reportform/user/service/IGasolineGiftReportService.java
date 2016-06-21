package cn.com.fubon.reportform.user.service;

import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.DataGridReturn;
import org.jeecgframework.core.common.service.CommonService;

/**
 * 加油宝报表
 * 
 * @author yaoming.zhang
 * @date 2015-10-27
 */
public interface IGasolineGiftReportService extends CommonService {

	public DataGridReturn getDataGridReturn(CriteriaQuery cq, boolean isOffset);

}
