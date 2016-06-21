package org.jeecgframework.web.demo.service.impl.test;

import java.net.SocketException;
import org.apache.log4j.Logger;
import org.jeecgframework.core.util.oConvertUtils;
import org.jeecgframework.web.demo.service.test.TaskDemoServiceI;
import org.springframework.stereotype.Service;
@Service("taskDemoService")
public class TaskDemoServiceImpl implements TaskDemoServiceI {
	Logger logger = Logger.getLogger(TaskDemoServiceImpl.class);
	
	public void work() {
		
		try{
			logger.info("IP=>" + oConvertUtils.getRealIp());
		}catch(SocketException e){
			logger.error("getRealIp failed!",e);
		}
	}

}
