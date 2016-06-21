package cn.com.fubon.fo.event.service;

import java.lang.reflect.InvocationTargetException;

import org.jeecgframework.core.common.service.CommonService;

import cn.com.fubon.fo.customerbind.entity.WeiXinGzUserInfo;
import cn.com.fubon.fo.event.entity.CustomerLocationEvent;

/**
 * 保存用户地理位置信息
 * @author shanqi.wang
 *
 */

public interface ICustomerLocationEventService extends CommonService   {

	 	
	/**
	 * 根据 用户OpenID 查找用户最近的地理位置
	 * @param OpenID
	 * @return
	 */
	public CustomerLocationEvent getLastestCustomerLocation(String OpenID) throws IllegalAccessException, InvocationTargetException;
	
	/**
	 * 根据 用户OpenID 删除 X天前的历史数据
	 * @param OpenID
	 * @return
	 */
	public Integer delOldCustomerLocation(String OpenID,String Days)  ;
	
}
