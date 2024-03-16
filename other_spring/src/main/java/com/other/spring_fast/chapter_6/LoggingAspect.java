package com.other.spring_fast.chapter_6;

import java.util.Arrays;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

@Aspect
@Order(2)
public class LoggingAspect {

	private Logger logger = Logger.getLogger(LoggingAspect.class.getName());
	
	@Around("execution(* com.other.spring_fast.chapter_6.CommentService.publishComment(..))")
	public Object logExecution(ProceedingJoinPoint joinPoint) throws Throwable {
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
		logger.info("Method " + methodName + " with parameters " + Arrays.asList(arguments) + " will execute");
		Comment comment = new Comment();
		comment.setText("Some other text!");
		Object[] newArguments = {comment};
		Object returnedByMethod = joinPoint.proceed(newArguments);
		logger.info("Method executed and returned " + returnedByMethod);
		return "FAILED";
	}
	
	@Around("@annotation(ToLog)")
	public String logAspect(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("Method annotated @ToLog execute");
		joinPoint.proceed();
		logger.info("Method annotated @ToLog finished");
		return "NO WAY";
	}
	
	@AfterReturning(value = "execution(* com.other.spring_fast.chapter_6.CommentService.editComment(Comment))", returning = "result")
	public void logReduce(Object result) {
		logger.info("Reduced log message. Output: " + result);
	}
	
	@Around("@annotation(ToChain)")
	public Object chainLog(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("Logging Aspect: Calling the intercepted method");
		Object returnedValue = joinPoint.proceed();
		logger.info("Logging Aspect: Method executed and returned " + returnedValue);
		return returnedValue;
	}
}
