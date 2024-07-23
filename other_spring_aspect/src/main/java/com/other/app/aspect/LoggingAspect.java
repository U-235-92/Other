package com.other.app.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private static final Logger logger = Logger.getLogger(LoggingAspect.class.getName());
	
	@Around("execution(* com.other.app.service.*.*(..))")
	public Object log(ProceedingJoinPoint pjp) {
		logger.info("[Aspect]: call " + pjp.getSignature().getDeclaringType().getName() + "." + pjp.getSignature().getName());
		Object returnValue = null;
		try {
			returnValue = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return returnValue;
	}
}
