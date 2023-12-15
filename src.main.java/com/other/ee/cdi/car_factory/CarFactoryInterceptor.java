package com.other.ee.cdi.car_factory;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.other.ee.cdi.car_factory.LogProducerType.LogType;

import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Interceptor
@Loggable
public class CarFactoryInterceptor {

	@Inject 
	@LogProducerType(type = LogType.INTERCEPTOR)
	private Logger logger;
	
	@AroundInvoke
	private Object intercept(InvocationContext invocationContext) throws Exception {
		logger.log(Level.INFO, "Intercept of method [" + invocationContext.getMethod().getName() + "]");
		return invocationContext.proceed();
	}
}
