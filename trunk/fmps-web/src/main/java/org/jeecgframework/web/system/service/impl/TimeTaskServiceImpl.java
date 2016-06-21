package org.jeecgframework.web.system.service.impl;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.web.system.service.TimeTaskServiceI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("timeTaskService")
@Transactional
public class TimeTaskServiceImpl extends CommonServiceImpl implements TimeTaskServiceI {
	public boolean isExistsTaskId(String taskId){
		String sql = "select count(1) from t_s_timetask where TASK_ID = ?";
		return this.getCountForJdbcParam(sql,new Object[]{taskId}) > 0;
	}
}