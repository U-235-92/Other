package com.other.ee.jpa.examples;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@SuppressWarnings(value = "unused")
public class Main {

	public static void main(String[] args) {
		EntityManager entityManager = getEntityManager();
		saveBooks(entityManager);
		printEntityFromDB(entityManager, Book.class, "Select b from Book b");
		saveBoy(entityManager);
		printEntityFromDB(entityManager, Boy.class, "Select b from Boy b");
		savePerson(entityManager);
		printEntityFromDB(entityManager, Person.class, "Select p from Person p");
		makeHouse(entityManager);
		printEntityFromDB(entityManager, House.class, "Select h from House h");
		saveChild(entityManager);
		printEntityFromDB(entityManager, Child.class, "Select c from Child c");
		entityManager.close();
	}

	private static EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("inheriting");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}
	
	private static void saveBooks(EntityManager entityManager) {
		entityManager.getTransaction().begin();
		Book book1 = new Book("History", "Old Man", 875);
		book1.setPrice(9.99);
		Book book2 = new Book("Cooking with Ananym", "Young Man", 400);
		book2.setPrice(8.88);
		Book book3 = new Book("All small important things", "Middle Man", 1500);
		book3.setPrice(7.77);
		entityManager.persist(book1);
		entityManager.persist(book2);
		entityManager.persist(book3);
		entityManager.getTransaction().commit();
	}
	
	private static void saveBoy(EntityManager entityManager) {
		entityManager.getTransaction().begin();
		Toy lego = new Toy("Lego");
		Toy car = new Toy("Car");
		List<Toy> toys = new ArrayList<Toy>();
		toys.add(lego); toys.add(car);
		Boy boy = new Boy("Max", toys, Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
		entityManager.persist(boy);
		entityManager.getTransaction().commit();
		
	}
	
	private static void savePerson(EntityManager entityManager) {
		entityManager.getTransaction().begin();
		PersonDetails details = new PersonDetails("Hello (:", Color.BLUE, null);
		Person person = new Person("Mike", new Date(), details);
		details.setPerson(person);
		entityManager.persist(person);
		entityManager.getTransaction().commit();
	}
	
	private static void makeHouse(EntityManager entityManager) {
		entityManager.getTransaction().begin();
		Address address = new Address("Country", "City", "Street", "Number", "Zip");
		House house = new House(100, 1, address);
		entityManager.persist(house);
		entityManager.getTransaction().commit();
	}
	
	private static void saveChild(EntityManager entityManager) {
		entityManager.getTransaction().begin();
		Child child = new Child();
		child.setParentFeature("Feature of PARENT");
		child.setChildFeature("Feature of CHILD");
		entityManager.persist(child);
		entityManager.getTransaction().commit();
	}
	
	private static void printEntityFromDB(EntityManager entityManager, Class<?> clazz, String jpql) {
		entityManager.getTransaction().begin();
		entityManager.createQuery(jpql, clazz).getResultList().forEach(System.out::println);
		entityManager.getTransaction().commit();
	}
}
