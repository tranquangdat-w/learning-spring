package com.mycompany.restwebapp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class ProjectConfig {
  @Value("${custom.datasource.url}")
  private String dataSourceUrl;

  @Value("${custom.datasource.username}")
  private String userName; 

  @Value("${custom.datasource.password}")
  private String password;

  @Bean
  public DataSource dataSource() {
    HikariDataSource dataSource = new HikariDataSource();

    dataSource.setJdbcUrl(this.dataSourceUrl);
    dataSource.setUsername(this.userName);
    dataSource.setPassword(this.password);
    dataSource.setConnectionTimeout(1000);

    return dataSource;
  }
}
