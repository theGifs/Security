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
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * TODO      从库
 * @package  com.sgcc.uap.config
 * @file     SecondaryConfig.java
 * @author   韩子强
 * @date     2019年12月26日 下午4:35:07
 * @version  V 1.0
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="entityManagerFactorySecondary",
        transactionManagerRef="transactionManagerSecondary",
        basePackages= { "com.sgcc.uap.tripartite.pgsql.test.*" }) //设置Repository所在位置
public class SecondaryConfig {

    @Autowired
    private JpaProperties jpaProperties;
    
    @Autowired
    @Qualifier("secondaryDataSource")
    private DataSource secondaryDataSource;
    
    
    @Value("${spring.jpa.hibernate.secondary-dialect}")
    private String secondaryDialect;

    
    @Bean(name = "entityManagerSecondary")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
     return entityManagerFactorySecondary(builder).getObject().createEntityManager();
    }
    
    @Bean(name = "entityManagerFactorySecondary")
    public LocalContainerEntityManagerFactoryBean entityManagerFactorySecondary(EntityManagerFactoryBuilder builder) {
     return builder
       .dataSource(secondaryDataSource)
       .properties(getVendorProperties(secondaryDataSource))
       .packages("com.sgcc.uap.tripartite.pgsql.test.*") //设置实体类所在位置
       .persistenceUnit("primaryPersistenceUnit")
       .build();
    }
    
    
    private Map<String, String> getVendorProperties(DataSource dataSource) {
        Map<String,String> map = new HashMap<>();
        map.put("hibernate.dialect",secondaryDialect);
        jpaProperties.setProperties(map);
        return jpaProperties.getHibernateProperties(dataSource);
    } 
    
    @Bean(name = "transactionManagerSecondary")
    PlatformTransactionManager transactionManagerSecondary(EntityManagerFactoryBuilder builder) {
     return new JpaTransactionManager(entityManagerFactorySecondary(builder).getObject());
    }
    
} 
