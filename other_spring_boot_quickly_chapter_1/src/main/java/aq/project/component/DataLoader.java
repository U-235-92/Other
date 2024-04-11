package aq.project.component;

import java.util.List;

import org.springframework.stereotype.Component;

import aq.project.model.Coffee;
import aq.project.repository.CoffeeRepository;
import jakarta.annotation.PostConstruct;

@Component
public class DataLoader {

	private final CoffeeRepository coffeeRepository;

	public DataLoader(CoffeeRepository coffeeRepository) {
		super();
		this.coffeeRepository = coffeeRepository;
	}
	
	@PostConstruct
	private void loadData() {
		coffeeRepository.saveAll(List.of(
				new Coffee("Cafe Cereza"), 
				new Coffee("Cafe Ganador"), 
				new Coffee("Cafe Lareno"), 
				new Coffee("Cafe Tres Pontas")));
	}
}
