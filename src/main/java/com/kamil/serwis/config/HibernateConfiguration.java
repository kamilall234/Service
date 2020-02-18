package com.kamil.serwis.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactoryMySQL",
        basePackages = "com.kamil.serwis.repository.RepoTest",
        transactionManagerRef = "MySQLTransactionManager")
@EnableTransactionManagement
public class HibernateConfiguration {

    private final String URLDatabase = "jdbc:mariadb://localhost:3306/SerwisDB";
    private final String User = "test";
    private final String Password = "password";
    private final String SQLDatabase = "org.mariadb.jdbc.Driver";


    @Bean(name ="entityManagerFactoryMySQL")
    @Primary
    LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf =
                new LocalContainerEntityManagerFactoryBean();
        emf.setPackagesToScan("com.kamil.serwis.dao.SQL");
        emf.setDataSource(createDataSource());
        emf.setJpaVendorAdapter(createJpaVendorAdapter());
        emf.setJpaProperties(createHibernateProperties());
        emf.setPersistenceUnitName("MySQLPersistence");
//        emf.afterPropertiesSet();
        System.out.println("Data source do bazy" + emf.getDataSource().toString() + " " +emf.getPersistenceUnitName());
        return emf;
    }
    @Primary
    private DataSource createDataSource() {
        DataSource dataSource= DataSourceBuilder.create()
                .url(this.URLDatabase)
                .username(User)
                .password(Password)
                .driverClassName(SQLDatabase)
                .build();
        return dataSource;
    }
    @Primary
    private JpaVendorAdapter createJpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }
    @Primary
    private Properties createHibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "create");
        properties.setProperty(
                "hibernate.dialect", "org.hibernate.dialect.MySQL55Dialect");
        properties.setProperty("hibernate.show_sql","true");
       /*properties.setProperty("com.mysql.cj.jdbc.Driver","");*/
        return properties;
    }

    @Bean(name = "MySQLTransactionManager")
    @Primary
    PlatformTransactionManager transactionManager(@Qualifier("entityManagerFactoryMySQL") EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }

}
