package com.other.ee.jpa.motorcycle;

import java.io.OutputStream;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {

	//see https://github.com/Apress/beg-java-ee-7/blob/master/agoncal-book-javaee7-master/chapter04/chapter04-putting-together/src/main/java/org/agoncal/book/javaee7/chapter04/Main.java
	public static void main(String[] args) {
		Logger logger = getLogger();
		EntityManager entityManager = getEntityManager();
		logger.log(Level.INFO, "All motorcycles before INSERT operations");
		entityManager.createNamedQuery("selectAllMotorcycles", Motorcycle.class).getResultList().forEach(moto -> System.out.println(moto));
		putMotorcycleIntoDB(makeMotorcycle(400, 150, "Yamaha", "SR400"), entityManager);
		putMotorcycleIntoDB(makeMotorcycle(400, 150, "Honda", "SB400SS"), entityManager);
		logger.log(Level.INFO, "All motorcycles after INSERT operations");
		entityManager.createNamedQuery("selectAllMotorcycles", Motorcycle.class).getResultList().forEach(moto -> System.out.println(moto));
		logger.log(Level.INFO, "Select Yamaha SR400");
		Motorcycle selectedMoto = entityManager.createNamedQuery("selectYamahaSR400", Motorcycle.class).getSingleResult();
		System.out.println("Inserted moto: " + selectedMoto);
		entityManager.close();
	}
	
	private static Logger getLogger() {
		Logger logger = Logger.getLogger(Main.class.getName());
		logger.setLevel(Level.INFO);
		logger.setUseParentHandlers(false);
		logger.addHandler(new ConsoleHandler() {
			@Override
			protected void setOutputStream(OutputStream out) throws SecurityException {
				super.setOutputStream(System.out);
			}
		});
		return logger;
	}
	
	private static EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("motorcycle");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}
	
	private static void putMotorcycleIntoDB(Motorcycle motorcycle, EntityManager entityManager) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(motorcycle);
		transaction.commit();
	}
	
	private static Motorcycle makeMotorcycle(int engine, int topSpeed, String manufacturer, String model) {
		return new Motorcycle(engine, topSpeed, manufacturer, model);
	}

}
