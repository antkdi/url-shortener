package io.github.antkdi.url_shortner;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * Created by IntelliJ IDEA on 2020-04-18 13:21 </br>
 * PROJECT : "url-shortner"  </br>
 * Department : Matching Technology </br>
 * Cell : AI Part </br>
 * ClassName : DataSourceConfiguration </br>
 * Descrption :   </br>
 *
 * @author <a href="mailto:antkdi@saramin.co.kr">hyungeun.jung</a>
 * @version 1.0
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"io.github.antkdi.url_shortner.repository"})
public class DataSourceConfiguration extends HikariConfig {

    //Default DataSource

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder, DataSource dataSource){
        return builder.dataSource(dataSource).packages("io.github.antkdi.url_shortner.entity").persistenceUnit("H2DBUnit").build();
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
