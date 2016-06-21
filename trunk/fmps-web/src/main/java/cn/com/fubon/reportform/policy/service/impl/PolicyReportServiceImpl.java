/**
 * 
 */
package cn.com.fubon.reportform.policy.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.DataGridReturn;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.fubon.reportform.policy.service.PolicyReportService;
import cn.com.fubon.reportform.user.service.impl.NoticeUserReportServiceImp;

/**
 * @author xiaomei.wu
 */
@Service("policyReportService")
@Transactional
public class PolicyReportServiceImpl extends CommonServiceImpl implements 
		PolicyReportService {
	private static final Logger logger = Logger
			.getLogger(NoticeUserReportServiceImp.class);

	@Override
	public DataGridReturn getDataGridReturn(CriteriaQuery cq, boolean isOffset) {
		return super.getDataGridReturn(cq, isOffset);
	}

	@Override
	public <T> List<T> getList(Class clas) {
		return super.getList(clas);
	}
}
