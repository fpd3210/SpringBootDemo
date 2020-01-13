package com.dpf.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @author dpf
 * @create 2020-01-12 23:10
 * @email 446933040@qq.com
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.dpf.repository2",entityManagerFactoryRef = "localContainerEntityManagerFactoryBeanTwo",transactionManagerRef = "platformTransactionManagerTwo")
public class JpaConfig2 {
    @Autowired
    @Qualifier(value = "dsTwo")
    DataSource dsOne;

    @Autowired
    JpaProperties jpaProperties;


    @Bean
    LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBeanTwo(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(dsOne)
                .packages("com.dpf.bean")
                .properties(jpaProperties.getProperties())
                .persistenceUnit("pu2")
                .build();
    }

    @Bean
    PlatformTransactionManager platformTransactionManagerTwo(EntityManagerFactoryBuilder builder) {
        LocalContainerEntityManagerFactoryBean factoryBeanOne = localContainerEntityManagerFactoryBeanTwo(builder);
        return new JpaTransactionManager(factoryBeanOne.getObject());
    }
}
