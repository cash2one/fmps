/**
 * 
 */
package cn.com.fubon.util;

import java.util.concurrent.ExecutionException;

import net.spy.memcached.MemcachedClient;
import net.spy.memcached.internal.OperationFuture;

import org.apache.log4j.Logger;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;

/**
 * @author binbin.wang
 *
 */
public final class CachedUtils {

	private static MemcachedClient memcachedClient = null;
	private static String attachKey = null;

	private static Logger log = Logger.getLogger(CachedUtils.class);

	static {
		try {
			memcachedClient = (MemcachedClient) ApplicationContextUtil
					.getContext().getBean("memcachedClient");
			log.info("get memcachedClient successed");
			attachKey = ResourceUtil.getBundleEnvAbout()
					.getString("fmpsMemKey");
		} catch (Exception e) {
			log.info("get memcachedClient failure, cause by====>", e);
		}

	}

	/**
	 * 设置缓存对象，如果memcached中有相同的key，则会报错
	 * 
	 * @param key
	 * @param exp
	 * @param obj
	 */
	public static void add(String key, int exp, Object obj) {
		log.info("prepare add  to memcached, key===>" + key + ";exp===>" + exp
				+ ";obj===>" + obj.toString());
		memcachedClient.add(key + attachKey, exp, obj);
		log.info("add key successed,  key===>" + key);
	}

	public static void add(String key, Object obj) {
		Integer exp = Integer.valueOf(ResourceUtil.getMemcachedExpTimeout());
		memcachedClient.add(key + attachKey, exp, obj);
	}

	/**
	 * 设置缓存对象，如果memcached中有相同的key，则做替换操作
	 * 
	 * @param key
	 * @param exp
	 * @param obj
	 */
	public static void set(String key, int exp, Object obj) {
		if (StringUtil.isNotEmpty(obj)) { // 非空保存，如果为空，不保存。
			memcachedClient.set(key + attachKey, exp, obj);
		}
	}

	public static void set(String key, Object obj) {
		if (StringUtil.isNotEmpty(obj)) { // 非空保存，如果为空，不保存。
			Integer exp = Integer.valueOf(ResourceUtil.getMemcachedExpTimeout());
			memcachedClient.set(key + attachKey, exp, obj);
		}
	}

	/**
	 * 如果获取不存在的key,会返回null 如果memcache服务停掉,会报连接异常
	 * 
	 * @param key
	 * @return
	 */
	public static Object get(String key) {
		Object result = null;
		try {
			result = memcachedClient.get(key + attachKey);
		} catch (Exception e) {
			log.error("get key:[" + key + attachKey + "] failed cause by==>", e);
		}
		return result;
	}

	public static void delete(String key) {
		memcachedClient.delete(key + attachKey);
	}

	/**
	 * 判断添加是否成功
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public static boolean add(String key, String value) {
		OperationFuture<Boolean> future = memcachedClient.add(key + attachKey,
				3 * 60 * 1000, value);
		try {
			return future.get();
		} catch (InterruptedException e) {
			return false;
		} catch (ExecutionException e) {
			return false;
		}
	}

	public static long incr(String key, int by) {
		return memcachedClient.incr(key, by);
	}

	public static long incr(String key, int by, long def) {
		return memcachedClient.incr(key, by, def);
	}
	
	public static long desc(String key,int by){
		return memcachedClient.decr(key, by);
	}
}
