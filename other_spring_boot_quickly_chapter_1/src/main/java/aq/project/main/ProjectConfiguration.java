package aq.project.main;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import aq.project.property.Droid;

@Configuration
@ComponentScan(basePackages = {"aq.project.controller", "aq.project.component"})
@EnableJpaRepositories(basePackages = {"aq.project.repository"})
@EntityScan(basePackages = {"aq.project.model"})
@ConfigurationPropertiesScan(basePackages = "aq.project.property")
public class ProjectConfiguration {

	@Bean
	@ConfigurationProperties(prefix = "droid")
	Droid droid() {
		return new Droid();
	}
}
