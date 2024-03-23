package com.other.spring_fast.chapter_11.main;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@org.springframework.context.annotation.Configuration
@EnableFeignClients(basePackages = "com.other.spring_fast.chapter_11.proxy")
@ComponentScan(basePackages = {"com.other.spring_fast.chapter_11.controller", "com.other.spring_fast.chapter_11.proxy"})
public class Configuration {

}
