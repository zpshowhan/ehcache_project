
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
