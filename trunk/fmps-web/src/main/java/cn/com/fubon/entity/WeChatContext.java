package cn.com.fubon.entity;

import java.util.HashMap;
import java.util.Map;

import cn.com.fubon.util.CachedUtils;

public class WeChatContext implements java.io.Serializable   {	
   private static final long serialVersionUID = 1L;
   private  Map map ;	
   public WeChatContext(){
		map=new HashMap();		
	}	
   public  Object get(String key){	   
	   return map.get(key);	   
      }	
	public void save(String key ,Object object){		
		map.put(key, object);		
	}	
	
	public void remove(String key){
		map.remove(key);		
	}
}
