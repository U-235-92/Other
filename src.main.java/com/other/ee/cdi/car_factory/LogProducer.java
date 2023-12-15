package com.other.ee.cdi.car_factory;

import java.io.OutputStream;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

import com.other.ee.cdi.car_factory.LogProducerType.LogType;

import jakarta.enterprise.inject.Produces;
import jakarta.enterprise.inject.spi.InjectionPoint;

public class LogProducer {

	@Produces
	@LogProducerType(type = LogType.FACTORY)
	public Logger produceFactoryLogger(InjectionPoint injectionPoint) {
		return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
	}

	@Produces 
	@LogProducerType(type = LogType.INTERCEPTOR)
	public Logger produceInterceptorLogger(InjectionPoint injectionPoint) {
		Logger logger = Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
		ConsoleHandler consoleHandler = new ConsoleHandler() {
			@Override
			protected synchronized void setOutputStream(OutputStream out) throws SecurityException {
				super.setOutputStream(System.out);
			}
		};
		logger.addHandler(consoleHandler);
		return logger;
	}
}
