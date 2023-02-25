package com.qian.config;

import com.google.common.cache.CacheBuilder;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @Author: 小小千千
 * @CreateTime: 2023/2/25 19:03
 * @Description:
 */
@Configuration
@EnableCaching
public class GuavaConfig {
    @Bean
    public CacheManager cacheManager() {
        GuavaCacheManager cacheManager = new GuavaCacheManager();
        cacheManager.setCacheBuilder(
                CacheBuilder.newBuilder().
                        //缓存过期时间
                                expireAfterWrite(10, TimeUnit.SECONDS).
                        maximumSize(1000));
        return cacheManager;
    }
}
