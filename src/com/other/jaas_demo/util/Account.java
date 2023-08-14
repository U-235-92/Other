package com.other.jaas_demo.util;

import java.util.Arrays;
import java.util.Objects;

public class Account {

	private String login;
	private char[] password;
	public Account(String login, char[] password) {
		super();
		this.login = login;
		this.password = password;
	}
	public String getLogin() {
		return login;
	}
	public char[] getPassword() {
		return password;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(login, password);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(obj.getClass() != getClass()) {
			return false;
		}
		if(obj == this) {
			return true;
		}
		Account acc = (Account) obj;
		if(acc.getLogin().equals(login) && Arrays.equals(acc.getPassword(), password)) {
			return true;
		}
		return false;
	}
}
