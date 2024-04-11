package aq.project.repository;

import org.springframework.data.repository.CrudRepository;

import aq.project.model.Coffee;

public interface CoffeeRepository extends CrudRepository<Coffee, String> {

}
