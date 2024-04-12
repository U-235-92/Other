package aq.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aq.project.property.Droid;

@RestController
@RequestMapping("/droid")
public class DroidController {

	private final Droid droid;

	public DroidController(Droid droid) {
		super();
		this.droid = droid;
	}
	
	@GetMapping
	Droid getDroid() {
		return droid;
	}
}
