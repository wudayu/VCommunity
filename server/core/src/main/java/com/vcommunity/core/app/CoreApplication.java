package com.vcommunity.core.app;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author James
 * @since V1.0
 */
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class, JacksonAutoConfiguration.class,
        RedisAutoConfiguration.class })
@ComponentScan(value = { "com.vcommunity.core", "com.vcommunity.cache" })
public class CoreApplication {
}
