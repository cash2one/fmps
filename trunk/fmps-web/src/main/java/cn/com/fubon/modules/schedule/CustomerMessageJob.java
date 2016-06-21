/**
 * 
 */
package cn.com.fubon.modules.schedule;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 
 * 
 * @author binbin.wang
 *
 */
public class CustomerMessageJob extends QuartzJobBean {

	/**
	 * 
	 */
	public CustomerMessageJob() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mi:ss").format(new Date()));
	}
	
}
