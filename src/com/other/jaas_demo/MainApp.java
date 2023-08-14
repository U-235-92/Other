package com.other.jaas_demo;

import java.security.PrivilegedAction;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

import com.other.jaas_demo.util.AccountPermission;
import com.other.jaas_demo.util.SimpleCallbackHandler;

public class MainApp {

	public static void main(String[] args) {
		System.setProperty("java.security.policy", "src/com/other/jaas_demo/permission_test.policy");
		System.setProperty("java.security.auth.login.config", "src/com/other/jaas_demo/log_config.config");
		System.setSecurityManager(new SecurityManager());
		LoginContext loginContext = null;
		while(true) {
			try {
				loginContext = new LoginContext("Log_configuration", new SimpleCallbackHandler());
				loginContext.login();
				break;
			} catch (LoginException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Authentication success!");
		System.out.println("Subject principals:");
		loginContext.getSubject().getPrincipals().forEach(p -> System.out.println(p));
		PrivilegedAction<String> action = () -> {
			AccountPermission permission = new AccountPermission("add", "prohibited");
			SecurityManager securityManager = System.getSecurityManager();
			if (securityManager != null) {
				System.out.println("Try to do action...");
				try {					
					securityManager.checkPermission(permission);
					System.out.println("The action success");
				} catch(SecurityException e) {
					System.err.println(e.getMessage());
				}
	        }
	        return null;
		};
		Subject subject = loginContext.getSubject();
		Subject.doAsPrivileged(subject, action, null);
	}
}
