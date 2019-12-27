package com.yx.bootswagger.multisources.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * TODO      主库配置
 * @package  com.sgcc.uap.config
 * @file     PrimaryConfig.java
 * @author   韩子强
 * @date     2019年12月26日 下午4:31:08
 * @version  V 1.0
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="entityManagerFactoryPrimary",
        transactionManagerRef="transactionManagerPrimary",
        basePackages= { "com.sgcc.uap.*.*.repositories","com.sgcc.uap.*.repositories" }) //设置Repository所在位置
public class PrimaryConfig {

    
    @Autowired
    private JpaProperties jpaProperties;
    
    @Autowired
    @Qualifier("primaryDataSource")
    private DataSource primaryDataSource;
    
    
    @Value("${spring.jpa.hibernate.primary-dialect}")
    private String primaryDialect;// 获取对应的数据库方言
    
    
    @Primary
    @Bean(name = "entityManagerPrimary")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
     return entityManagerFactoryPrimary(builder).getObject().createEntityManager();
    }
    
    @Primary
    @Bean(name = "entityManagerFactoryPrimary")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryPrimary(EntityManagerFactoryBuilder builder) {
     return builder
       .dataSource(primaryDataSource)
       .properties(getVendorProperties(primaryDataSource))
       .packages("com.sgcc.uap.*.*.domain","com.sgcc.uap.*.domain") //设置实体类所在位置
       .persistenceUnit("primaryPersistenceUnit")
       .build();
    }
    
    

    //spring boot  1.X 版本
    /*private Map<String, String> getVendorProperties(DataSource dataSource) {
        Map<String,String> map = new HashMap<>();
        map.put("hibernate.dialect",primaryDialect);// 设置对应的数据库方言
        jpaProperties.setProperties(map);
        return jpaProperties.getHibernateProperties(dataSource);
    } */
//    sprnig boot 2.X
    private Map<String, String> getVendorProperties(DataSource dataSource) {
        Map<String,String> map = new HashMap<>();
        map.put("hibernate.dialect",primaryDialect);// 设置对应的数据库方言
        jpaProperties.setProperties(map);
//        return jpaProperties.getHibernateProperties(dataSource);
        return null;
    }
    
    @Primary
    @Bean(name = "transactionManagerPrimary")
    public PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder) {
     return new JpaTransactionManager(entityManagerFactoryPrimary(builder).getObject());
    }
    
    
    
} 