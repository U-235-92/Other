package aq.project.repository;

import org.springframework.data.repository.CrudRepository;

import aq.project.model.Aircraft;

public interface AircraftRepository extends CrudRepository<Aircraft, Long> {

}
