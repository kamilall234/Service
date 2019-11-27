package com.kamil.serwis.config;


import com.mysql.cj.MysqlConnection;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.provider.PersistenceProvider;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.Entity;
import java.io.IOException;


@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
@EntityScan(basePackages = {"com.kamil.serwis"})
public class HibernateConfiguration {

    @Bean(name = "entityManagerFactory")
    public LocalEntityManagerFactoryBean entityManagerFactoryBean(){
        LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
        factoryBean.setPersistenceUnitName("MySQL");
        return factoryBean;
    }

    @Bean(name = "transactionManager")
    public JpaTransactionManager JpaTransactionManagerBean(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
        System.out.println("EMF "+entityManagerFactoryBean().getObject().toString());
        return transactionManager;
    }
    

}
