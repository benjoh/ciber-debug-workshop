package no.ciber.tutorial.spring_hibernate.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "no.ciber.tutorial.spring_hibernate.dao")
public class DatasourceConfig {

    private static final String MODEL_PACKAGE = "no.ciber.tutorial.spring_hibernate.model";
    private static final String DB_DRIVER_CLASS = "org.hsqldb.jdbcDriver";
    private static final String DB_CONNECTION_URL = "jdbc:hsqldb:mem:testdb";
    private static final String DB_USERNAME = "sa";
    private static final String DB_PASSWORD = "";

    @Bean
    public DataSource dataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(DB_DRIVER_CLASS);
        ds.setUrl(DB_CONNECTION_URL);
        ds.setUsername(DB_USERNAME);
        ds.setPassword(DB_PASSWORD);
        return ds;

    }


    @Bean
    @Autowired
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan(MODEL_PACKAGE);
        em.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        em.setJpaProperties(hibernateProperties());
        return em;
    }

    @Bean
    @Autowired
    public PlatformTransactionManager transactionManager(LocalContainerEntityManagerFactoryBean entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory.getObject());
    }

    private Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "create");
        return hibernateProperties;
    }
}
