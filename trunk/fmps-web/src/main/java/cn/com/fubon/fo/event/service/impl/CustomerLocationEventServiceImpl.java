package cn.com.fubon.fo.event.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.MyBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.fubon.fo.event.entity.CustomerLocationEvent;
import cn.com.fubon.fo.event.service.ICustomerLocationEventService;

import com.ckfinder.connector.configuration.Events;
import com.ckfinder.connector.configuration.IBasePathBuilder;
import com.ckfinder.connector.configuration.IConfiguration;
import com.ckfinder.connector.data.AccessControlLevel;
import com.ckfinder.connector.data.PluginInfo;
import com.ckfinder.connector.data.ResourceType;


@Service("customerLocationEventService")
@Transactional
public class CustomerLocationEventServiceImpl extends CommonServiceImpl   implements
		ICustomerLocationEventService  {
	private CustomerLocationEvent customerLocationEvent ;	
	@Override
	public CustomerLocationEvent getLastestCustomerLocation(String OpenID) throws IllegalAccessException, InvocationTargetException{		
	  String Hql="from CustomerLocationEvent as t where t.createTime=(select max(s.createTime) from CustomerLocationEvent s) and t.fromUserName=?";
	 List<CustomerLocationEvent> weixin_event_locationList= this.findHql(Hql,OpenID );		
	 if (weixin_event_locationList.size()>0) customerLocationEvent=weixin_event_locationList.get(0);	 
		return customerLocationEvent;	 
	}
	@Override
	public Integer delOldCustomerLocation(String OpenID,String Days) {
		 String Sql	= "delete FROM weixin_event_location  where TO_DAYS(now())-TO_DAYS(createtime) > ? and fromusername=? ";
		return  this.executeSql(Sql,  new String[]{Days,OpenID});	
	} 
	
}
