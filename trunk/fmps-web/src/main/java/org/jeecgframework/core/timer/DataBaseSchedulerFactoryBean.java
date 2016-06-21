package org.jeecgframework.core.timer;

import java.util.Set;
import org.jeecgframework.core.util.IpUtil;
import org.jeecgframework.web.system.pojo.base.TSTimeTaskEntity;
import org.jeecgframework.web.system.service.TimeTaskServiceI;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
/**
 * 读取数据库 然后判断是否启动任务
 * @author JueYue
 * @date 2013-9-22
 * @version 1.0
 */
public class DataBaseSchedulerFactoryBean extends SchedulerFactoryBean {
	
	@Autowired
	private TimeTaskServiceI timeTaskService;
	/**
	 * 读取数据库判断是否开始定时任务
	 */
	public void afterPropertiesSet() throws Exception {
		super.afterPropertiesSet();
		Set<TriggerKey> triggerKeys = this.getScheduler().getTriggerKeys(null);
		TSTimeTaskEntity task;
	/*	 InetAddress addr = InetAddress.getLocalHost();
		 String ip=addr.getHostAddress().toString();//获得本机IP */
		
		for(TriggerKey trigerKey : triggerKeys){
			task = timeTaskService.findUniqueByProperty(TSTimeTaskEntity.class,
					"taskId",trigerKey.getName());
			// 数据库查询不到的定时任务或者IP不是本机或者定时任务无效或者任务的运行状态不为1时，都停止
			if(task == null || !IpUtil.hasPassIpCheck(task.getIpFilter())
					|| !"1".equals(task.getIsEffect()) || !"1".equals(task.getIsStart())){
				this.getScheduler().pauseTrigger(
						TriggerKey.triggerKey(trigerKey.getName()));
			}
		}
	}
	
	

}
