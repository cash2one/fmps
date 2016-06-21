package org.jeecgframework.web.system.service;

import org.jeecgframework.core.common.service.CommonService;

public interface TimeTaskServiceI extends CommonService{
	public boolean isExistsTaskId(String taskId);
}
