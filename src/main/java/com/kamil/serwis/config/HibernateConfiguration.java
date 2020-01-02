package com.kamil.serwis.config;


import com.mysql.cj.MysqlConnection;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.provider.PersistenceProvider;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;


@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
@EntityScan(basePackages = {"com.kamil.serwis"})
public class HibernateConfiguration {

    private final String URLDatabase = "jdbc:mysql://localhost:3306/SerwisDB";
    private final String User = "test";
    private final String Password = "test";
    private final String SQLDatabase = "com.mysql.jdbc.Driver";

    @Bean(name = "MySQL")
    LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf =
                new LocalContainerEntityManagerFactoryBean();
        emf.setPackagesToScan("com.kamil.serwis");
        emf.setDataSource(createDataSource());
        emf.setJpaVendorAdapter(createJpaVendorAdapter());
        emf.setJpaProperties(createHibernateProperties());
        emf.afterPropertiesSet();
        return emf;
    }

    private DataSource createDataSource() {
        return DataSourceBuilder.create()
                .url(URLDatabase)
                .username(User)
                .password(Password)
                .build();
    }

    private JpaVendorAdapter createJpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }

    private Properties createHibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "create");
        properties.setProperty(
                "hibernate.dialect", "org.hibernate.dialect.MySQL55Dialect");
        properties.setProperty("hibernate.show_sql","true");
        return properties;
    }

    @Bean
    PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}
