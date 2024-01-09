package com.other.jaas.demo;

import java.security.AccessController;
import java.security.PrivilegedAction;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

import com.other.jaas.demo.util.AccountPermission;
import com.other.jaas.demo.util.SimpleCallbackHandler;

public class MainApp {

	@SuppressWarnings({ "removal", "deprecation" })
	public static void main(String[] args) {
		System.setProperty("java.security.policy", "src.main.java/com/other/jaas/demo/permission_test.policy");
		System.setProperty("java.security.auth.login.config", "src.main.java/com/other/jaas/demo/log_config.config");
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
			System.out.println("Try to do action...");
			AccountPermission permission = new AccountPermission("add", "prohibited");
			AccessController.checkPermission(permission); 
	        return null;
		};
		Subject subject = loginContext.getSubject();
		Subject.doAsPrivileged(subject, action, null);
	}
}
