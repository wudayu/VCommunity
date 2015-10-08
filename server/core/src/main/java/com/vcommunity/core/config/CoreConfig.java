package com.vcommunity.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Core configuration.
 *
 * @author James
 * @since V1.0
 */
@Configuration
public class CoreConfig {
    @Value("${vc.thread.corePoolSize}")
    private Integer corePoolSize;
    @Value("${vc.thread.maxPoolSize}")
    private Integer maxPoolSize;
    @Value("${vc.thread.queueCapacity}")
    private Integer queueCapacity;

    @Bean
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(corePoolSize);
        threadPoolTaskExecutor.setMaxPoolSize(maxPoolSize);
        threadPoolTaskExecutor.setQueueCapacity(queueCapacity);

        return threadPoolTaskExecutor;
    }

}
