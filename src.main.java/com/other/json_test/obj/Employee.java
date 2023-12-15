package com.other.json_test.obj;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

public class Employee {

	@JsonAnySetter
	private Map<String, Object> properties;
	private List<String> phones;
//	@JsonRawValue
//	@JsonValue
	private String name;
	@JsonProperty("OLD_NAME")
	private String changeMyNameWhenRead;
	@JsonProperty("NEW_NAME")
	private String changeMyNameWhenWrite;
	private int age;
	@JsonIgnore
	private int noSaveData;
	private Role role;
//	@JsonUnwrapped
	private Addres addres;
	
	public Employee() {
		super();
	}

	public Employee(int noSaveData, String changeMyNameWhenRead, String changeMyNameWhenWrite,
			Map<String, Object> properties, List<String> phones, String name, int age, Role role, Addres addres) {
		super();
		this.noSaveData = noSaveData;
		this.changeMyNameWhenRead = changeMyNameWhenRead;
		this.changeMyNameWhenWrite = changeMyNameWhenWrite;
		this.properties = properties;
		this.phones = phones;
		this.name = name;
		this.age = age;
		this.role = role;
		this.addres = addres;
	}

	public int getNoSaveData() {
		return noSaveData;
	}

	public void setNoSaveData(int noSaveData) {
		this.noSaveData = noSaveData;
	}

//	@JsonGetter("ABGDEF")
	public String getChangeMyNameWhenRead() {
		return changeMyNameWhenRead;
	}

	public void setChangeMyNameWhenRead(String changeMyNameWhenRead) {
		this.changeMyNameWhenRead = changeMyNameWhenRead;
	}

	public String getChangeMyNameWhenWrite() {
		return changeMyNameWhenWrite;
	}

	public void setChangeMyNameWhenWrite(String changeMyNameWhenWrite) {
		this.changeMyNameWhenWrite = changeMyNameWhenWrite;
	}

//	@JsonAnyGetter(enabled = true)
	public Map<String, Object> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, Object> properties) {
		this.properties = properties;
	}

	public List<String> getPhones() {
		return phones;
	}

	public void setPhones(List<String> phones) {
		this.phones = phones;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

//	@JsonValue
//	@JsonRawValue
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Addres getAddres() {
		return addres;
	}

	public void setAddres(Addres addres) {
		this.addres = addres;
	}

	@Override
//	@JsonValue
	public String toString() {
		return "Employee [noSaveData=" + noSaveData + ", changeMyNameWhenRead=" + changeMyNameWhenRead
				+ ", changeMyNameWhenWrite=" + changeMyNameWhenWrite + ", properties=" + properties + ", phones="
				+ phones + ", name=" + name + ", age=" + age + ", role=" + role + ", addres=" + addres + "]";
	}
}
