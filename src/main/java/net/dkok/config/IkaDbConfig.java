package net.dkok.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/*
  ref. https://medium.com/@joeclever/using-multiple-datasources-with-spring-boot-and-spring-data-6430b00c02e7
       http://roufid.com/spring-boot-multiple-databases-configuration/
 */

@Configuration
@EnableJpaRepositories(
        basePackages = "net.dkok.ika",
        entityManagerFactoryRef = "ikaEntityManagerFactory",
        transactionManagerRef = "ikaTransactionManager"
)
public class IkaDbConfig {
    @Bean(name = "ikaDataSource")
    @ConfigurationProperties("vcap.services.ikadb.credentials")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "ikaEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean ikaEntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("ikaDataSource") DataSource dataSource) {
        Map<String, String> properties = new HashMap<>();
        properties.put("hibernate.dialect", "org.hibernate.dialect.SQLiteDialect");

        return builder
                .dataSource(dataSource)
                .packages("net.dkok.ika")
                .persistenceUnit("ika")
                .properties(properties)
                .build();
    }

    @Bean(name = "ikaTransactionManager")
    public PlatformTransactionManager ikaTransactionManager(
            @Qualifier("ikaEntityManagerFactory") EntityManagerFactory ikaEntityManagerFactory) {
        return new JpaTransactionManager(ikaEntityManagerFactory);
    }
}
