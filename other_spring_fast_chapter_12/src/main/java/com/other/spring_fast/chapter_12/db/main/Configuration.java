package com.other.spring_fast.chapter_12.db.main;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.zaxxer.hikari.HikariDataSource;

@org.springframework.context.annotation.Configuration
@ComponentScan(basePackages = {"com.other.spring_fast.chapter_12.db.repository", "com.other.spring_fast.chapter_12.db.controller"})
public class Configuration {

	@Value("${custom.datasource.url}")
	private String datasourceUrl;
	@Value("${custom.datasource.username}")
	private String datasourceUsername;
	@Value("${custom.datasource.password}")
	private String datasourcePassword;
	
	@Bean
	public DataSource dataSource() {
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setJdbcUrl(datasourceUrl);
		dataSource.setUsername(datasourceUsername);
		dataSource.setPassword(datasourcePassword);
		dataSource.setConnectionTimeout(10000);
		return dataSource;
	}
}
