package com.other.ee.jpa.shop;

import java.util.List;
import java.util.Map;

import com.other.ee.jpa.shop.item.Item;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

@Entity
@Access(AccessType.FIELD)
public class Shop<T extends Item> {

	@Id
	@GeneratedValue
	private int id;
	@Column(name = "shop_name")
	private String name;
	@OneToMany
	@JoinColumn(name = "shop_fk")
	private List<T> items;
	@ElementCollection
	@CollectionTable(name = "fiction_table")
	@MapKeyColumn(name = "fiction_int")
	@Column(name = "fiction_string")
	private Map<Integer, String> fictionMap;
	@Enumerated(EnumType.STRING)
	private ShopType type;
	@Transient
	private String transientString;
	
	public Shop() {
		super();
	}

	public Shop(int id, String name, List<T> items, Map<Integer, String> fictionMap, ShopType type, String transientString) {
		super();
		this.id = id;
		this.name = name;
		this.items = items;
		this.fictionMap = fictionMap;
		this.type = type;
		this.transientString = transientString;
	}

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public List<T> getItems() {
		return items;
	}
	
	public Map<Integer, String> getFictionMap() {
		return fictionMap;
	}

	public ShopType getType() {
		return type;
	}

	public String getTransientString() {
		return transientString;
	}
}
