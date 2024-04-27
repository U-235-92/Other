package aq.project.message;

import java.util.List;
import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import aq.project.model.Aircraft;
import aq.project.repository.AircraftRepository;
import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class MessageConsumer {
	
	private final AircraftRepository repository;
	
	@Bean
	Consumer<List<Aircraft>> retrieveAircraftPositions() {
		return list -> {
			repository.deleteAll();
			repository.saveAll(list);
			repository.findAll().forEach(System.out::println);
		};
	}
}
