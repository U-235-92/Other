package aq.project.main;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = {"aq.project.controller", "aq.project.component"})
@EnableJpaRepositories(basePackages = {"aq.project.repository"})
@EntityScan(basePackages = {"aq.project.model"})
public class ProjectConfiguration {

}
