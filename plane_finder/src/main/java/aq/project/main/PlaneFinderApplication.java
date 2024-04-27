package aq.project.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"aq.project.service", "aq.project.controller"})
public class PlaneFinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlaneFinderApplication.class, args);
	}

}
