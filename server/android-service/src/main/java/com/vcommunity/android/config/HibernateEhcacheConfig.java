package com.vcommunity.android.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * @author James Chow
 * @createdate 2015/5/10
 * @contact zhouxy.vortex@gmail.com
 * @since v1.0
 */
@Configuration
public class HibernateEhcacheConfig {

    @Value("${ehcache.setting}")
    private String ehcacheSettingPath;

    @Bean
    public EhCacheManagerFactoryBean demoEhcacheManager() {
        EhCacheManagerFactoryBean bean = new EhCacheManagerFactoryBean();
        ClassPathResource classPathResource = new ClassPathResource(ehcacheSettingPath);
        bean.setConfigLocation(classPathResource);

        return bean;
    }
}
