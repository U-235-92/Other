package com.other.ee.jpa.examples;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Access(AccessType.FIELD)
public class Boy {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "BOY_FK")
	private List<Toy> toys;
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	
	public Boy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Boy(String name, List<Toy> toys, Date dateOfBirth) {
		super();
		this.name = name;
		this.toys = toys;
		this.dateOfBirth = dateOfBirth;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Toy> getToys() {
		return toys;
	}
	
	public void setToys(List<Toy> toys) {
		this.toys = toys;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Boy [id=" + id + ", name=" + name + ", toys=" + toys + ", dateOfBirth=" + dateOfBirth + "]";
	}
}
