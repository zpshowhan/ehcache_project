package com.luo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.config.CacheConfiguration;


/**
 * 通过spring获取ehcahe
 */

public class EhcacheUtils {

	@Autowired
	private static EhCacheManagerFactoryBean ehcache;
	
	private static CacheManager cacheManager = null;//唯一
	
	private static Cache cache = null;//变化
	
	/**
	 * 
	 * 获取缓存管理容器
	 * 
	 */
	public static CacheManager initCacheManager(){
		if(cacheManager==null){
			cacheManager=ehcache.getObject();
		}
		return cacheManager;
	}
	/**
	 * 初始化cache
	 */
	public static Cache initCache(String cacheName) {
		checkCacheManager();
		cache = cacheManager.getCache(cacheName);
		return cache;
	}
	
	/**
	 * 添加缓存<br>
	 * 注意，以下缓存是永久有效，是系统初始化数据到缓存中，<br>
	 * 如果不需要永久有效，请调用其他方法
	 * 
	 * @param key
	 *            关键字
	 * @param value
	 *            值
	 */
	public static void put(Object key, Object value) {
		checkCache();
		// 创建Element,然后放入Cache对象中
		Element element = new Element(key, value);
		cache.put(element);
	}
	/**
	 * 获取cache
	 * 
	 * @param key
	 *            关键字
	 * @return
	 */
	public static Object get(Object key) {
		checkCache();
		Element element = cache.get(key);
		if (null == element) {
			return null;
		}
		return element.getObjectValue();
	}
	
	/**
	 * 
	 * 向指定容器中设置值
	 * 
	 * @param vesselName
	 *            容器名
	 * 
	 * @param key
	 *            键
	 * 
	 * @param value
	 *            值
	 * 
	 * @return 返回真
	 * 
	 * @throws Exception
	 *             异常
	 */

	public static boolean setValue(String cacheName, String key, Object value) throws Exception {
		try {
			Cache myCache = cacheManager.getCache(cacheName);
			myCache.put(new Element(key, value));
			return true;
		} catch (Exception e) {
			throw new Exception("set cache " + cacheName + " failed!!!");
		}
	}
	/**
	 * 
	 * 从ehcache的指定容器中取值
	 * 
	 * @createTime 2015-4-23
	 * 
	 * @param key
	 *            键
	 * 
	 * @return 返回Object类型的值
	 * 
	 * @throws Exception
	 *             异常
	 */

	public static Object getValue(String cacheName, String key) throws Exception {
		try {
			Cache myCache = cacheManager.getCache(cacheName);
			return myCache.get(key).getObjectValue();
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * 
	 * 删除EHCache容器中的元素
	 * 
	 * @param cacheName
	 *            容器名
	 * 
	 * @param key
	 *            键
	 * 
	 * @return 真
	 * 
	 * @throws Exception
	 *             失败抛出异常
	 */

	public static boolean removeElment(String cacheName, String key) throws Exception {
		try {
			Cache myCache = cacheManager.getCache(cacheName);
			myCache.remove(key);
			return true;
		} catch (Exception e) {
			throw new Exception("remove cache " + cacheName + " failed!!!");
		}
	}
	/**
	 * 
	 * 删除指定容器中的所有元素
	 * 
	 * @param cacheName
	 *            容器名
	 * 
	 * @return 真
	 * 
	 * @throws Exception
	 *             失败抛出异常
	 */

	public static boolean clearCache(String cacheName) throws Exception {
		try {
			Cache myCache = cacheManager.getCache(cacheName);
			myCache.removeAll();
			return true;
		} catch (Exception e) {
			throw new Exception("clear cache " + cacheName + " failed!!!");
		}
	}
	/**
	 * 
	 * 获取所有的cache名称
	 * 
	 * @return
	 */

	public static String[] getAllCaches() {
		checkCacheManager();
		return cacheManager.getCacheNames();
	}
	/**
	 * 
	 * 获取Cache所有的Keys
	 * 
	 * @return
	 */

	@SuppressWarnings("rawtypes")
	public static List getKeys() {
		checkCache();
		return cache.getKeys();
	}
	private static void checkCacheManager() {
		if (null == cacheManager) {
			throw new IllegalArgumentException("调用前请先初始化CacheManager值：EHCacheUtil.initCacheManager");
		}
	}

	private static void checkCache() {
		if (null == cache) {
			throw new IllegalArgumentException("调用前请先初始化Cache值：EHCacheUtil.initCache(参数)");
		}
	}
	public static void main(String[] arg) {
		
	}
}
