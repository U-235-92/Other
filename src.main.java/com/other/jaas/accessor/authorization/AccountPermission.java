package com.other.jaas.accessor.authorization;

import java.security.BasicPermission;
import java.security.Permission;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("serial")
public class AccountPermission extends BasicPermission {

	private static final String ALLOW = "allow";
	private static final String FORBID = "forbid";
	private String action;
	
	public AccountPermission(String name, String action) {
		super(name);
		this.action = action;
	}
	
	@Override
	public boolean implies(Permission incommingPermission) {
		if(!(incommingPermission instanceof AccountPermission)) {
			return false;
		}
		AccountPermission incommingAccountPermission = (AccountPermission) incommingPermission;
		if(action.equals(ALLOW)) {
			return incommingAccountPermission.getAction().equals(ALLOW);
		} else if(action.equals(FORBID)) {
			if(incommingAccountPermission.getAction().equals(ALLOW)) {
				return true;
			} else if(incommingAccountPermission.getAction().equals(FORBID)) {
				return false;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public String getAction() {
		return action;
	}
	
	private Set<String> getActionsSet() {
		Set<String> actions = new HashSet<String>();
		actions.addAll(Arrays.asList(getName().split(",")));
		return actions;
	}
}
