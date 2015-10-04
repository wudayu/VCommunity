package com.vcommunity.core.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author James
 * @since V1.0
 */
@Configuration
public class DatabaseConfig {
    @Value("${vc.db.driverName}")
    private String driverName;
    @Value("${vc.db.username}")
    private String userName;
    @Value("${vc.db.password}")
    private String password;
    @Value("${vc.db.url}")
    private String url;
    @Value("${vc.db.pool.jmxEnabled}")
    private Boolean jmxEnabled;
    @Value("${vc.db.pool.testWhileIdle}")
    private Boolean testWhileIdle;
    @Value("${vc.db.pool.testWhileIdle}")
    private Boolean testOnBorrow;
    @Value("${vc.db.pool.validationQuery}")
    private String validationQuery;
    @Value("${vc.db.pool.testOnReturn}")
    private Boolean testOnReturn;
    @Value("${vc.db.pool.validationInterval}")
    private Integer validationInterval;
    @Value("${vc.db.pool.timeBetweenEvictionRunsMillis}")
    private Integer timeBetweenEvictionRunsMillis;
    @Value("${vc.db.pool.maxActive}")
    private Integer maxActive;
    @Value("${vc.db.pool.initialSize}")
    private Integer initialSize;
    @Value("${vc.db.pool.maxWait}")
    private Integer maxWait;
    @Value("${vc.db.pool.removeAbandonedTimeout}")
    private Integer removeAbandonedTimeout;
    @Value("${vc.db.pool.minEvictableIdleTimeMillis}")
    private Integer minEvictableIdleTimeMillis;
    @Value("${vc.db.pool.minIdle}")
    private Integer minIdle;
    @Value("${vc.db.pool.logAbandoned}")
    private Boolean logAbandoned;
    @Value("${vc.db.pool.removeAbandoned}")
    private Boolean removeAbandoned;

    @Bean
    public DataSource dataSource() {
        PoolProperties poolProperties = new PoolProperties();
        poolProperties.setJmxEnabled(jmxEnabled);
        poolProperties.setTestWhileIdle(testWhileIdle);
        poolProperties.setTestOnBorrow(testOnBorrow);
        poolProperties.setValidationQuery(validationQuery);
        poolProperties.setTestOnReturn(testOnReturn);
        poolProperties.setValidationInterval(validationInterval);
        poolProperties.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        poolProperties.setMaxActive(maxActive);
        poolProperties.setInitialSize(initialSize);
        poolProperties.setMaxWait(maxWait);
        poolProperties.setRemoveAbandonedTimeout(removeAbandonedTimeout);
        poolProperties.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        poolProperties.setMinIdle(minIdle);
        poolProperties.setLogAbandoned(logAbandoned);
        poolProperties.setRemoveAbandoned(removeAbandoned);
        poolProperties.setJdbcInterceptors("org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"
                + "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer;"
                + "org.apache.tomcat.jdbc.pool.interceptor.ResetAbandonedTimer");
        poolProperties.setDriverClassName(driverName);
        poolProperties.setUrl(url);
        poolProperties.setUsername(userName);
        poolProperties.setPassword(password);

       DataSource dataSource = new DataSource(poolProperties);

        return dataSource;
    }


}
