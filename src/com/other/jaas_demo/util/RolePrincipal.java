package com.other.jaas_demo.util;

import java.security.Principal;
import java.util.Objects;

public class RolePrincipal implements Principal {

	private String name;
	
	public RolePrincipal(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
            return false;

        if (this == obj)
            return true;

        if (!(obj instanceof RolePrincipal))
            return false;
        RolePrincipal that = (RolePrincipal) obj;

        if (this.getName().equals(that.getName()))
            return true;
        return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
