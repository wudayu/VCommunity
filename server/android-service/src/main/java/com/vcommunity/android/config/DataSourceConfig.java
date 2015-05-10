package com.vcommunity.android.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

/**
 * 初始化数据库连接池相关的bean
 *
 * @author James Chow
 * @createdate 2015/5/10
 * @contact zhouxy.vortex@gmail.com
 * @since v1.0
 */
@Configuration
@ConditionalOnExpression("${vcom.db.enable}")
public class DataSourceConfig {
    private static Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

    @Value("${db.jdbc.driver}")
    private String driver;

    @Value("${db.jdbc.url}")
    private String url;

    @Value("${db.jdbc.username}")
    private String username;

    @Value("${db.jdbc.password}")
    private String password;

    @Value("${db.jdbc.pool.initialSize}")
    private Integer initialSize;

    @Value("${db.jdbc.pool.minIdle}")
    private Integer minIdle;

    @Value("${db.jdbc.pool.maxActive}")
    private Integer maxActive;

    @Value("${db.jdbc.pool.maxWait}")
    private Long maxWait;

    @Value("${db.jdbc.pool.timeBetweenEvictionRunMillis}")
    private Long timeBetweenEvictionRunMillis;

    @Value("${db.jdbc.pool.minEvictableIdleTimeMillis}")
    private Long minEvictableIdleTimeMillis;

    @Value("${db.jdbc.pool.validationQuery}")
    private String validationQuery;

    @Value("${db.jdbc.pool.testWhileIdle}")
    private Boolean testWhileIdle;

    @Value("${db.jdbc.pool.testOnBorrow}")
    private Boolean testOnBorrow;

    @Value("${db.jdbc.pool.testOnReturn}")
    private Boolean testOnReturn;

    @Value("${db.jdbc.pool.poolPreparedStatements}")
    private Boolean poolPreparedStatements;

    @Value("${db.jdbc.pool.maxPoolPreparedStatementPerConnectionSize}")
    private Integer maxPoolPreparedStatementPerConnectionSize;

    @Value("${db.jdbc.pool.filters}")
    private String filters;

    @Bean
    public DruidDataSource dataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setInitialSize(initialSize);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxActive(maxActive);
        dataSource.setMaxWait(maxWait);
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunMillis);
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        dataSource.setValidationQuery(validationQuery);
        dataSource.setTestWhileIdle(testWhileIdle);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setTestOnReturn(testOnReturn);
        dataSource.setPoolPreparedStatements(poolPreparedStatements);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        dataSource.setFilters(filters);

        return dataSource;
    }



}
