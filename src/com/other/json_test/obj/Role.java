package com.other.json_test.obj;

import com.fasterxml.jackson.annotation.JsonValue;

@SuppressWarnings("unused")
public enum Role {

	MANAGER(1, 100), PRINCIPAL(2, 200), WORKER(3, 300);
	
	private int id;
//	@JsonValue
	private int addition;
	
	Role(int id, int addition) {
		this.id = id;
		this.addition = addition;
	}

	public int getId() {
		return id;
	}

	public int getAddition() {
		return addition;
	}
	
	
}
