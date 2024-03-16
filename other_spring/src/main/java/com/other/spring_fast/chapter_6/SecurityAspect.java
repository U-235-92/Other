package com.other.spring_fast.chapter_6;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class SecurityAspect {

	private Logger logger = Logger.getLogger(SecurityAspect.class.getName());
	
	@Around("@annotation(ToChain)")
	public Object chainSecure(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("Security Aspect: Calling the intercepted method");
		Object returnedValue = joinPoint.proceed();
		logger.info("Security Aspect: Method executed and returned " + returnedValue);
		return returnedValue;
	}
}
