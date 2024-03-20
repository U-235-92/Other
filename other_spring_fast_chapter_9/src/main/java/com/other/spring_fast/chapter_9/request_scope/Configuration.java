package com.other.spring_fast.chapter_9.request_scope;

import org.springframework.context.annotation.ComponentScan;

@org.springframework.context.annotation.Configuration
@ComponentScan(basePackages = {"com.other.spring_fast.chapter_9.request_scope", "com.other.spring_fast.chapter_9.session_scope",
		"com.other.spring_fast.chapter_9.application_scope"})
public class Configuration {

}
