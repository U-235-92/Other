package com.other.ee.jpa.shop.main;

import java.util.List;

import com.other.ee.jpa.shop.client.Address;
import com.other.ee.jpa.shop.client.Client;
import com.other.ee.jpa.shop.client.ClientDetails;
import com.other.ee.jpa.shop.item.Book;
import com.other.ee.jpa.shop.item.Order;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
	}

	private static EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shop");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}
	
	private static Client getClient() {
		Address address = new Address("Russia", "Engels", "Telmana", "16", "413100");
		ClientDetails clientDetails = new ClientDetails("Blue", "88005558558", address);
		Client client = new Client("Nikolai", 29, clientDetails);
		clientDetails.setClient(client);
		return client;
	}
	
	private static Order<Book> getOrder() {
		Book book1 = new Book("History", "Old Man", 875);
		Book book2 = new Book("Cooking with Ananym", "Young Man", 400);
		Book book3 = new Book("All small important things", "Middle Man", 1500);
		Client client = getClient();
		List<Book> books = List.of(book1, book2, book3);
		Order<Book> order = new Order<Book>(client, books);
		return order;
	}
}
