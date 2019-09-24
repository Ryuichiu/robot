package de.robot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "de.robot.repository")
public class DataSourceConfig {

    @Value("${database.driver}")
    private String MYSQL_JDBC_DRIVER;

    @Value("${database.host}")
    private String DATABASE_HOST;

    @Value("${database.port}")
    private int DATABASE_PORT;

    @Value("${database.name}")
    private String DATABASE_NAME;

    @Value("${database.username}")
    private String DATABASE_USERNAME;

    @Value("${database.password}")
    private String DATABASE_PASSWORD;


    @Bean(name = "datasource")
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://" + DATABASE_HOST + ":" + DATABASE_PORT + "/" + DATABASE_NAME + "?serverTimezone=UTC?");
        dataSource.setUsername(DATABASE_USERNAME);
        dataSource.setPassword(DATABASE_PASSWORD);
        return dataSource;
    }
}
