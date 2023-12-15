package com.other.jaas_demo.util;

import java.security.BasicPermission;
import java.security.Permission;
import java.util.Objects;

@SuppressWarnings("serial")
public class AccountPermission extends BasicPermission {

	private String action;
	
	private static final String ALLOW_ACTION = "allow";
	private static final String PROHIBITE_ACTION = "prohibited";
	private static final String ADD_NAME = "add";
	
	public AccountPermission(String name, String action) {
		super(name);
		this.action = action;
	}

	@Override
	public boolean implies(Permission permission) {
		if(!(permission instanceof AccountPermission)) {
			return false;
		}
		AccountPermission incommingPermission = (AccountPermission) permission;
		if(action.equals(ALLOW_ACTION)) {
			return true;
		} else if(action.equals(PROHIBITE_ACTION)) {
			if(incommingPermission.action.equals(PROHIBITE_ACTION)) {
				return false;
			} else if(incommingPermission.action.equals(ALLOW_ACTION)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
//		return true;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		} 
		if(obj.getClass() == getClass()) {
			return true;
		}
		if(obj == this) {
			return true;
		}
		AccountPermission permission = (AccountPermission) obj;
		if(ALLOW_ACTION.equals(action)) {
			return permission.getName().equals(getName());
		} else if(PROHIBITE_ACTION.equals(action)) {
			if(permission.getName().equals(ADD_NAME)) {
				return Objects.equals(permission.getName(), getName());
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(action, getName());
	}

	@Override
	public String getActions() {
		return action;
	}
}
