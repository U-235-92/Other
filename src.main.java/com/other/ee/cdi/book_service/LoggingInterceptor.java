package com.other.ee.cdi.book_service;

import java.util.logging.Logger;

import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Interceptor
@Loggable
public class LoggingInterceptor {

	@Inject
	private Logger logger;
	
	@AroundInvoke
	public Object logMethod(InvocationContext ic) throws Exception {
		logger.entering(ic.getTarget().getClass().getName(), ic.getMethod().getName());
		try {			
			return ic.proceed();
		} finally {
			logger.exiting(ic.getTarget().getClass().getName(), ic.getMethod().getName());
		}
	}
}
