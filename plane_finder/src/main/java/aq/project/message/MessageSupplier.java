package aq.project.message;

import java.util.function.Supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import aq.project.model.Aircraft;
import aq.project.service.PlaneFinderService;
import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class MessageSupplier {
	
	private final PlaneFinderService service;
	
	@Bean
	Supplier<Iterable<Aircraft>> reportPositions() {
		return () -> {
			return service.getAircraft();
		};
	}
}
