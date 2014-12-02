package no.ciber.tutorial.spring_hibernate.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

public class DatasourceConfig {

    private static final String MODEL_PACKAGE = "no.ciber.tutorial.spring_hibernate.model";
    private static final String DB_DRIVER_CLASS = "org.hsqldb.jdbcDriver";
    private static final String DB_CONNECTION_URL = "jdbc:hsqldb:mem:testdb";
    private static final String DB_USERNAME = "sa";
    private static final String DB_PASSWORD = "";

    public DataSource dataSource() {
        BasicDataSource ds = new BasicDataSource();
        return ds;

    }


    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        return em;
    }

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
