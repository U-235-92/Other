package com.other.spring_fast.chapter_2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
/* chapter_2 part 2.2.2
 * @ComponentScan(basePackages = "com.other.spring_fast.chapter_2") */
public class ProjectConfig {

	/* chapter_2 part 2.2.1
	 * @Bean(name = "kesha") Parrot parrot1() { Parrot parrot = new Parrot();
	 * parrot.setName("Kesha"); return parrot; }
	 * 
	 * @Bean Parrot parrot2() { Parrot parrot = new Parrot();
	 * parrot.setName("Chirik"); return parrot; }
	 * 
	 * @Primary
	 * @Bean Parrot parrot3() { Parrot parrot = new Parrot();
	 * parrot.setName("Gosha"); return parrot; }
	 * 
	 * @Bean String hello() { return "Hello"; }
	 * 
	 * @Bean Integer ten() { return 10; }
	 */
}
