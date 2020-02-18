package com.kamil.serwis.config;



import org.hibernate.ogm.jpa.HibernateOgmPersistence;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
@EnableJpaRepositories(entityManagerFactoryRef = "MongoDB",
        basePackages = "com.kamil.serwis.repository.MongoTest",
        transactionManagerRef = "mongoTransactionManager")
@EnableTransactionManagement
public class MongoConfiguration {

    @Bean(name = "MongoDB")
    LocalContainerEntityManagerFactoryBean entityManagerFactoryMongo() {
        LocalContainerEntityManagerFactoryBean emf =
                new LocalContainerEntityManagerFactoryBean();
            emf.setPackagesToScan("com.kamil.serwis.dao.NoSQL");
            emf.setJpaVendorAdapter(createJpaVendorAdapter());
            emf.setJpaProperties(createHibernateProperties());
            emf.setPersistenceProviderClass(HibernateOgmPersistence.class);
            emf.setPersistenceUnitName("MongoDBPersistence");
            System.out.println(emf.getPersistenceProvider());
        return emf;
    }

    private JpaVendorAdapter createJpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }

    private Properties createHibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("javax.persistence.transactionType", "resource_local");
        properties.setProperty("hibernate.ogm.datastore.provider","mongodb");
        properties.setProperty("hibernate.ogm.datastore.host","localhost");
        properties.setProperty("hibernate.ogm.datastore.port","27017");
        properties.setProperty("hibernate.ogm.datastore.database", "test");
        properties.setProperty("hibernate.ogm.datastore.create_database", "true");
        properties.setProperty("hibernate.ogm.datastore.username","testUser");
        properties.setProperty("hibernate.ogm.datastore.password","password");
        properties.setProperty("hibernate.ogm.mongodb.authentication_database","admin");
        properties.setProperty("hibernate.transaction.jta.platform","JBossTS");
        properties.setProperty("OgmProperties.ENABLED","false");
        properties.setProperty("hibernate.show_sql","true");

        return properties;
    }


    @Bean("mongoTransactionManager")
    PlatformTransactionManager transactionManager(@Qualifier("MongoDB") EntityManagerFactory emf) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(emf);
        return new JpaTransactionManager(emf);
    }
}
