package com.other.app.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LogAspect {
	
	private static Logger logger = Logger.getLogger(LogAspect.class.getName());
	
	@Around(value = "execution(* com.other.app.controller.StoreController.*(..))")
	public Object logCallMethod(ProceedingJoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		logger.info("Before call a method: " + methodName);
		Object returnedValue = null;
		try {
			returnedValue = joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		logger.info("After call a method: " + methodName);
		return returnedValue;
	}
}
