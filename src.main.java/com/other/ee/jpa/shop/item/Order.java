package com.other.ee.jpa.shop.item;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.other.ee.jpa.shop.client.Client;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Order<T extends Item> {

	@Id
	@GeneratedValue
	private int id;
	@OneToOne
	@JoinColumn(name = "client_id")
	private Client client;
	@OneToMany
	@JoinColumn(name = "order_fk")
	private List<T> items;
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate;
	
	public Order() {
		super();
	}
	
	public Order(Client client, List<T> items) {
		super();
		this.client = client;
		this.items = items;
	}
	
	public int getId() {
		return id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}

	public double getTotalPrice() {
		return items.stream().map(items -> items.getPrice()).reduce((price1, price2) -> price1 + price2).or(() -> Optional.of(0.0)).get();
	}
}
