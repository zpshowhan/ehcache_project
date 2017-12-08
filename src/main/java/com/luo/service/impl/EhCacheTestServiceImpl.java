package com.luo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.luo.service.EhCacheTestService;

@Service
public class EhCacheTestServiceImpl implements EhCacheTestService {
	
	
	/**
	 * value 代表cache名称（一个cache中会有多条缓存）
	 * key 代表cache中的一条缓存的key（一条缓存格式是<key,val>格式）
	 */
	@Cacheable(value="cacheTest",key="#param")
	public String getTimestamp(String param) {
		Long timestamp = System.currentTimeMillis();
		return timestamp.toString();
	}

	public void update(String param) {
		// TODO Auto-generated method stub
		
	}

	@CachePut(value="cacheTest",key="#param")
	public String add(String param) {
		// TODO Auto-generated method stub
		Long timestamp = System.currentTimeMillis();
		return timestamp.toString()+"=>>"+param;
	}

	public List select(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	@CacheEvict(value="cacheTest",key="#param", condition="#param=='param'")
	public void delete(String param) {
		// TODO Auto-generated method stub
		
	}

}
