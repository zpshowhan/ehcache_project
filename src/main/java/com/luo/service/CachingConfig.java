/**   
* @Title: CachingConfig.java 
* @Package com.luo.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @Company:方正
* @author zhaolei  
* @date 2017年12月8日 下午4:03:41 
* @version V1.0   
*/
package com.luo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/** 
* @ClassName: CachingConfig 
* @Description: TODO java方式注解ehcache 
* @Company:方正
* @author zhaolei 
* @version 1.0 2017年12月8日 下午4:03:41 
*/
//@Configuration
//@EnableCaching//<!-- 启用缓存注解 --> <cache:annotation-driven cache-manager="cacheManager" />
public class CachingConfig {

	private static final Logger logger = LoggerFactory.getLogger(CachingConfig.class);  

//    @Bean  
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {  
        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();  
        ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource(  
                "ehcache-setting.xml"));  
        return ehCacheManagerFactoryBean;  
    }  

//    @Bean  
    public CacheManager cacheManager() {  
        logger.info("EhCacheCacheManager"); 
        EhCacheCacheManager cacheManager = new EhCacheCacheManager();  
        cacheManager.setCacheManager(ehCacheManagerFactoryBean().getObject());  
        return cacheManager;  
    }  
    public static void main(String[] args) {
    	CachingConfig config=new CachingConfig();
    	System.out.println(config.cacheManager());
	}
}
