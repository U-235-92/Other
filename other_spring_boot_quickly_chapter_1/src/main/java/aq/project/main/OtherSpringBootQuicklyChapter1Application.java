package aq.project.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("aq.project.controller")
public class OtherSpringBootQuicklyChapter1Application {

	public static void main(String[] args) {
		SpringApplication.run(OtherSpringBootQuicklyChapter1Application.class, args);
	}

}
