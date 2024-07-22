package com.other.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.other.app.aspect.LogAspect;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

@Configuration
@ComponentScan(basePackages = {"com.other.controller", "com.other.repository", "com.other.service"})
@EnableAspectJAutoProxy
public class AppConfiguration {

	@Bean
	ValidatorFactory validatorFactory() {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		return validatorFactory;
	}

    @Bean
    Validator validator(ValidatorFactory validatorFactory) {
		return validatorFactory.getValidator();
	}
    
    @Bean
    LogAspect validationAspect() {
    	return new LogAspect();
    }
}
