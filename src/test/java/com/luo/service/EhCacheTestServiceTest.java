package com.luo.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;

import com.luo.baseTest.SpringTestCase;

public class EhCacheTestServiceTest extends SpringTestCase {
	
	@Autowired  
    private EhCacheTestService ehCacheTestService;
	@Autowired
	private CacheManager cacheManager;
	@Autowired
	private EhCacheManagerFactoryBean ehcache;
	
	@Test  
    public void getTimestampTest() throws InterruptedException{  
		System.out.println(cacheManager.getCache("cacheTest"));
        System.out.println("第一次调用：" + ehCacheTestService.getTimestamp("param"));
        System.out.println("第一次调用sss：" + ehCacheTestService.getTimestamp("paramsss"));
        System.out.println("第一次调用add：" + ehCacheTestService.add("addparam"));
        System.out.println(ehcache.getObject().getCache("cacheTest").getKeys().toString());
        ehCacheTestService.delete("param");
        ehCacheTestService.delete("addparam");
        Thread.sleep(2000);
        System.out.println("2秒之后调用：" + ehCacheTestService.getTimestamp("param"));
        System.out.println("2秒之后调用sss：" + ehCacheTestService.getTimestamp("paramsss"));
        System.out.println("2秒之后调用add：" + ehCacheTestService.add("addparam"));
        Thread.sleep(11000);
        //系统设定的访问cache最大间隔时间为10秒
        System.out.println("再过11秒之后调用：" + ehCacheTestService.getTimestamp("param"));
        System.out.println("2秒之后调用sss：" + ehCacheTestService.getTimestamp("paramsss"));
        System.out.println("再过11秒之后调用add：" + ehCacheTestService.add("addparam"));
    } 
}
