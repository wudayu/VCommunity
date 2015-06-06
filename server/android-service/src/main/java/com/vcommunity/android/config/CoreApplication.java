package com.vcommunity.android.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author James Chow
 * @createdate 2015/5/10
 * @contact zhouxy.vortex@gmail.com
 * @since v1.0
 */
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class, JacksonAutoConfiguration.class,
                                     HibernateJpaAutoConfiguration.class })
@EnableScheduling
@EnableAsync
@ComponentScan(basePackages = { "com.vcommunity.android.config", "com.vcommunity.server.core.file.config" })
public class CoreApplication {
}
