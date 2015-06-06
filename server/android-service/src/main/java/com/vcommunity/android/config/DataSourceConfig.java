package com.vcommunity.android.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import java.lang.annotation.Annotation;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

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

    @Value("${mybatis.typeAliasesPackage")
    private String typeAliasesPacage;

    @Value("${mybatis.mapperLocations}")
    private String mapperLocations;

    @Value("${mybatis.annotationClass}")
    private String annotationClass;

    @Value("${mybatis.basePackage}")
    private String basePackage;

    @Value("${vc.jpa.hibernate.naming-strategy}")
    private String nameStrategy;

    @Value("${vc.jpa.hibernate.cache.region.factory_class}")
    private String cacheFactoryClass;

    @Value("${vc.jpa.net.sf.ehcache.configurationResourceName}")
    private String ehcacheConfigruationName;

    /**
     * 初始化数据库连接池，使用Druid
     *
     * @return
     * @throws SQLException
     */
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

    /**
     * 初始化MyBatis的SqlSessionFactory
     *
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean
                .setMapperLocations(resolver.getResources(mapperLocations));
        sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasesPacage);

        return sqlSessionFactoryBean.getObject();
    }

    /**
     * MyBatis进行包扫描
     *
     * @return
     * @throws ClassNotFoundException
     */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() throws ClassNotFoundException {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage(basePackage);
        mapperScannerConfigurer.setAnnotationClass((Class<? extends Annotation>) Class.forName(annotationClass));

        return mapperScannerConfigurer;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean customerEntityManagerFactory(EntityManagerFactoryBuilder builder) throws SQLException {
        Map<String, String> map = new HashMap<>();
        map.put("hibernate.naming-strategy", nameStrategy);
        map.put("net.sf.ehcache.configurationResourceName", cacheFactoryClass);
        map.put("hibernate.ejb.naming_strategy", ehcacheConfigruationName);

        LocalContainerEntityManagerFactoryBean bean = builder.dataSource(dataSource())
                                                             .packages("com.vcommunity")
                                                             .properties(map)
                                                             .build();

        return bean;
    }

}
