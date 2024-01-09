package com.other.jaas.accessor.authentication;

import java.security.Principal;

public class LoginPrincipal implements Principal {

	private String name;
	
	public LoginPrincipal() {
		super();
		name = "No name";
	}

	public LoginPrincipal(String name) {
		super();
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}
}
