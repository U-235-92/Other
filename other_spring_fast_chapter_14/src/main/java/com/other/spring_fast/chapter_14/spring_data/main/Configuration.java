package com.other.spring_fast.chapter_14.spring_data.main;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@org.springframework.context.annotation.Configuration
@ComponentScan(basePackages = {
		"com.other.spring_fast.chapter_14.spring_data.service",
		"com.other.spring_fast.chapter_14.spring_data.controller"})
@EnableJdbcRepositories(basePackages = "com.other.spring_fast.chapter_14.spring_data.repository")
public class Configuration {

}
