package aq.project.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import aq.project.model.Aircraft;
import aq.project.repository.AircraftRepository;

@EnableScheduling
@Component
public class PlaneFinderPoller {

	private WebClient client = WebClient.create("http://localhost:7634/aircraft");
	private final RedisConnectionFactory connectionFactory;
	private final RedisOperations<String, Aircraft> redisOperations;
	@Autowired
	private AircraftRepository repository;
	
	public PlaneFinderPoller(RedisConnectionFactory connectionFactory,
			RedisOperations<String, Aircraft> redisOperations) {
		super();
		this.connectionFactory = connectionFactory;
		this.redisOperations = redisOperations;
	}
	
	@Scheduled(fixedRate = 1000)
	private void pollPlanesByTemplate() {
		connectionFactory.getConnection().serverCommands().flushDb();
		client.get()
			.retrieve()
			.bodyToFlux(Aircraft.class)
			.filter(plane -> !plane.getReg().isEmpty())
			.toStream()
			.forEach(aircraft -> redisOperations.opsForValue().set(aircraft.getReg(), aircraft));
		redisOperations.opsForValue()
			.getOperations()
			.keys("*")
			.forEach(aircraft -> System.out.println(redisOperations.opsForValue().get(aircraft)));
	}
	
	@Scheduled(fixedRate = 1000)
	private void pollPlanesByRepository() {
		connectionFactory.getConnection().serverCommands().flushDb();
		client.get()
			.retrieve()
			.bodyToFlux(Aircraft.class)
			.filter(plane -> !plane.getReg().isEmpty())
			.toStream()
			.forEach(repository::save);
		repository
			.findAll()
			.forEach(System.out::println);
	}
}
