package aq.project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aq.project.model.Aircraft;
import aq.project.service.PlaneFinderService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/aircraft")
@RequiredArgsConstructor
public class PlaneFinderController {

	@NonNull
	private PlaneFinderService service;
	
	@GetMapping
	public List<Aircraft> getPlanes() {
		return service.getAircraft();
	}
}
