package org.jeecgframework.core.extend.datasource;

import org.apache.log4j.Logger;

/**
 *类名：DataSourceContextHolder.java
 *功能：获得和设置上下文环境的类，主要负责改变上下文数据源的名称
 */
public class DataSourceContextHolder {

	private static final ThreadLocal contextHolder=new ThreadLocal();
	private static Logger log = Logger.getLogger(DataSourceContextHolder.class);
	
	public static void setDataSourceType(DataSourceType dataSourceType){
		log.info("dataSourceType==>" + dataSourceType.toString());
		contextHolder.set(dataSourceType);
	}
	
	public static DataSourceType getDataSourceType(){
		return (DataSourceType) contextHolder.get();
	}
	
	public static void clearDataSourceType(){
		contextHolder.remove();
	}
	
}
