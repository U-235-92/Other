package com.other.spring_fast.chapter_3;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.other.spring_fast.chapter_3")
public class ProjectConfig {

	/*
	 * chapter_3.1
	 * @Bean public Parrot parrot() { 
	 * Supplier<Parrot> supplierParrot = Parrot::new;
	 * Parrot parrot = supplierParrot.get(); parrot.setName("Koko"); return parrot;
	 * }
	 * 
	 * @Bean public Person person(Parrot parrot) { 
	 * Person person = new Person();
	 * person.setName("Ella"); person.setParrot(parrot); return person; }
	 */
	
	@Bean
	public Parrot parrot1() {
		Parrot parrot = new Parrot();
		parrot.setName("Koko");
		return parrot;
	}
	
	@Bean
	public Parrot parrot2() {
		Parrot parrot = new Parrot();
		parrot.setName("Miki");
		return parrot;
	}
	
//	@Bean
//	public Person person(@Qualifier("parrot2") Parrot parrot) {
//		Person person = new Person();
//		person.setName("Ella");
//		person.setParrot(parrot);
//		return person;
//	}
}
