package org.jeecgframework.core.timer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.text.ParseException;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.quartz.SchedulerException;
import org.quartz.TriggerKey;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 动态任务,用以动态调整Spring的任务
 * @author JueYue
 * @date 2013-9-20
 * @version 1.0
 */
@Service(value="dynamicTask")
public class DynamicTask {
	
	private static Logger logger = Logger.getLogger(DynamicTask.class);

	@Autowired
	private DataBaseSchedulerFactoryBean schedulerFactory;
	
	/**
	 * 更新定时任务的触发表达式
	 * 
	 * @param triggerName
	 *            触发器名字
	 * @param start
	 *            触发表达式
	 * @return 成功则返回true，否则返回false
	 */
	public boolean startOrStop(String triggerName,
			boolean start) {
		try {
			if(start){
				schedulerFactory.getScheduler().resumeTrigger(TriggerKey.triggerKey(triggerName));
				logger.info("trigger the start successfully!!");
			}else{
				schedulerFactory.getScheduler().pauseTrigger(TriggerKey.triggerKey(triggerName));
				logger.info("trigger the pause successfully!!");
			}
			return true;
		}  catch (SchedulerException e) {
			logger.error("Fail to reschedule. " + e);
			return false;
		}
	}

	/**
	 * 更新定时任务的触发表达式
	 * 
	 * @param triggerName
	 *            触发器名字
	 * @param cronExpression
	 *            触发表达式
	 * @return 成功则返回true，否则返回false
	 */
	public boolean updateCronExpression(String triggerName,
			String cronExpression) {
		
		CronTriggerImpl trigger = null;
		try{
			trigger = (CronTriggerImpl)ApplicationContextUtil
				.getContext().getBean(triggerName);
		}catch(NoSuchBeanDefinitionException ex){
			logger.error("updateCronExpression NoSuchBeanDefinitionException!triggerName=>" + triggerName,ex);
			return false;
		}
		
		if (StringUtils.equals(trigger.getCronExpression(), cronExpression)) {
			logger.info("cronExpression is same with the running Schedule , no need to update.");
			return true;
		}
		
		try{
			trigger.setCronExpression(cronExpression);
			schedulerFactory.getScheduler().rescheduleJob(trigger.getKey(),trigger);
			updateSpringMvcTaskXML(triggerName,cronExpression);
			logger.info("Update the cronExpression successfully!!");
			return true;
		}catch(SchedulerException e){
			logger.error("Fail to reschedule. ",e);
			return false;
		}catch(ParseException e){
			logger.error("Fail to set cronExpression. ",e);
			return false;
		}
	}

	/**
	 * 更新spring-mvc-timeTask.xml 配置文件
	 * @param trigger
	 * @param cronExpression 
	 */
	@SuppressWarnings("unchecked")
	public synchronized static void updateSpringMvcTaskXML(String triggerName, String cronExpression) {
		Document document = null;
		File file = null;
		SAXReader saxReader = new SAXReader();
		try {
			URI url = DynamicTask.class.getClassLoader().getResource("spring/spring-mvc-timeTask.xml").toURI();
			file = new File(url.getPath());
			document = saxReader.read(new FileInputStream(file));
		} catch (Exception e) {
			logger.error("读取系统中用到的SQL 语句XML出错");
			throw new RuntimeException("---------读取spring-mvc-timeTask.xml文件出错:" + e.getMessage());
		}
		Element root = document.getRootElement();
		List<Element> beans = root.elements();
		for (Element bean : beans) {
			if(bean.attribute("id")!=null&&
					bean.attribute("id").getValue().equals(triggerName)){
				beans = bean.elements();
				for (Element temp : beans) {
					if(temp.attribute("name")!=null&&
							temp.attribute("name").getValue().equals("cronExpression")){
						temp.attribute("value").setValue(cronExpression);
						break;
					}
				}
				break;
			}
		}
		XMLWriter  fileWriter = null;
		try {
			OutputFormat xmlFormat = OutputFormat.createPrettyPrint();
			xmlFormat.setEncoding("utf-8");
			fileWriter = new XMLWriter(new FileOutputStream(file),xmlFormat);
			fileWriter.write(document);
		} catch (IOException e) {
			logger.error("updateSpringMvcTaskXML catch IOException , triggerName==>" 
			+ triggerName + " , cronExpression==>" + cronExpression,e);
		}finally{
			try {
				fileWriter.close();
			} catch (IOException e) {
				logger.error("updateSpringMvcTaskXML finally catch IOException , triggerName==>" 
						+ triggerName + " , cronExpression==>" + cronExpression,e);
			}
		}
		
	}

}
