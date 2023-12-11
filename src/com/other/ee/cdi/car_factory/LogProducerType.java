package com.other.ee.cdi.car_factory;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.inject.Qualifier;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface LogProducerType {
	
	LogType type();
	
	enum LogType {
		INTERCEPTOR, FACTORY;
	}
}
