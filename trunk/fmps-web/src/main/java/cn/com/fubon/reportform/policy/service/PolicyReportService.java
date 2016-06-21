/**
 * 
 */
package cn.com.fubon.reportform.policy.service;

import java.util.List;

import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.DataGridReturn;
import org.jeecgframework.core.common.service.CommonService;

/**
 * @author xiaomei.wu
 *
 */
public interface PolicyReportService extends CommonService {
	
	public DataGridReturn getDataGridReturn(CriteriaQuery cq, boolean isOffset);

	public <T> List<T> getList(Class clas);
}
