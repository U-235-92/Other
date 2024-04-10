package aq.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aq.project.model.Coffee;

@RestController
@RequestMapping(value = "/coffees") 
public class RestApiDemoController {

	private List<Coffee> coffees = new ArrayList<>();
	
	public RestApiDemoController() {
		coffees.addAll(List.of(new Coffee("Cafe Cereza"), new Coffee("Cafe Ganador"), new Coffee("Cafe Lareno"), new Coffee("Cafe Tres Pontas")));
	}
	
	@GetMapping
	Iterable<Coffee> getCoffees() {
		return coffees;
	}
	
	@PostMapping
	Coffee postCoffee(@RequestBody Coffee coffee) {
		coffees.add(coffee);
		return coffee;
	}
	
	@PutMapping("/{id}")
	ResponseEntity<Coffee> putCoffee(@PathVariable String id, @RequestBody Coffee coffee) {
		int coffeIndex = -1;
		for(Coffee c : coffees) {
			if(c.getId().equals(id)) {
				coffeIndex = coffees.indexOf(c);
				coffees.set(coffeIndex, coffee);
			}
		}
		return (coffeIndex == -1) ? 
					ResponseEntity.status(HttpStatus.CREATED).body(postCoffee(coffee)) : 
					ResponseEntity.status(HttpStatus.OK).body(coffee);
	}
	
	@DeleteMapping("/{id}")
	void deleteCoffee(@PathVariable String id) {
		coffees.removeIf(c -> c.getId().equals(id));
	}
}
