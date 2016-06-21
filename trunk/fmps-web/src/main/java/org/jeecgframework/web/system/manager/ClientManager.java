package org.jeecgframework.web.system.manager;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import net.spy.memcached.MemcachedClient;
import net.spy.memcached.spring.MemcachedClientFactoryBean;

import org.apache.log4j.Logger;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.ContextHolderUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.web.system.pojo.base.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.com.fubon.util.CachedUtils;
import cn.com.fubon.util.WebApplicationUtils;

/**
 * 对在线用户的管理
 * @author JueYue
 * @date 2013-9-28
 * @version 1.0
 */
public class ClientManager {
	
	private static ClientManager instance = new ClientManager();
	
	private static Logger log = Logger.getLogger(ClientManager.class);
	
	public static ClientManager getInstance(){
		return instance;
	}
	
	/*private Map<String, Client> getAllUserMap() {
		Map<String, Client> users = (Map<String, Client>)memcachedClient.get(MEMCACHED_KEY_ALLUSERS);
		if (users == null)
			users = new HashMap<String, Client>();
		
		return users;
	}*/
	
	/**
	 * 
	 * @param sessionId
	 * @param client
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	public void addClient(String sessionId,Client client) throws NumberFormatException, Exception{
		//memcachedClient.set(key, exp, o)
		Integer exp =   Integer.valueOf(ResourceUtil.getMemcachedExpTimeout());
		CachedUtils.add(sessionId, exp, client);
		log.info("set client success, key==>" + sessionId + "; exp==>" + exp.toString());
	}
	/**
	 * @throws Exception 
	 */
	public void removeClient(String sessionId) throws Exception{
		try {
			CachedUtils.delete(sessionId);
		}catch(Exception e) {
			log.info("删除client失败；key==>" + sessionId + "在memcached服务器中不存在。");
		}
	}
	/**
	 * 
	 * @param sessionId
	 * @return
	 */
	/*public Client getClient(String sessionId){
		Client client = null;
		Object obj = null;
		try {
			obj = CachedUtils.get(sessionId);
			client = (Client)obj;
			log.info("get client success, key===>" + sessionId);
		}catch(Exception e) {
			log.info("get client failture；key==>" + sessionId + " not existed on memcached。obj typeof is ==>" + obj.getClass() + ";obj.toString==>" + obj.toString());
			e.printStackTrace();
		}
		return client;
	}
	*//**
	 *
	 * @return
	 *//*
	public Client getClient(){
		return getClient(ContextHolderUtils.getSession().getId());
	}*/
	/**
	 * 
	 * @return
	 */
	public Collection<Client> getAllClient(){
		return null;
	}

	public static void main(String[] args) {
		String str = "123";
		
		System.out.println(str.getClass().toString());
	}
	
}
