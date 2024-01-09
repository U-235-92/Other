package com.other.jaas.accessor.authorization;

import java.security.BasicPermission;
import java.security.Permission;

public class AccountPermission extends BasicPermission {

	private static final long serialVersionUID = 1L;
	private String actions;
	
	public AccountPermission(String name, String actions) {
		super(name);
		this.actions = actions;
	}
	
	@Override
	public boolean implies(Permission incommingPermission) {
		return super.implies(incommingPermission);
	}

	public String getActions() {
		return actions;
	}
	
	
}
