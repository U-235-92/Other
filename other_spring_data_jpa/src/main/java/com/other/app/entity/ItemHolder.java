package com.other.app.entity;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class ItemHolder {

	@Id
	@GeneratedValue
	private long id;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "jnd_item_holder_item", joinColumns = @JoinColumn(name = "item_holder_id"), inverseJoinColumns = @JoinColumn(name = "item_id"))
	private List<Item> items = new CopyOnWriteArrayList<Item>();
}
