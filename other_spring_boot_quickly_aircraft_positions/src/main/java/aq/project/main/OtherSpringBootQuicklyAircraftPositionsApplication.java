package aq.project.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"aq.project.repository"})
@ComponentScan(basePackages = {"aq.project.controller"})
@EntityScan(basePackages = {"aq.project.model"})
public class OtherSpringBootQuicklyAircraftPositionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OtherSpringBootQuicklyAircraftPositionsApplication.class, args);
	}

}
