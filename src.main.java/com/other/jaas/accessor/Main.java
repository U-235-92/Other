package com.other.jaas.accessor;

import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

import com.other.jaas.accessor.authentication.ConsoleCallBackHandler;
import com.other.jaas.accessor.authorization.AccountPermission;


public class Main {
	
	@SuppressWarnings({ "removal", "deprecation" })
	public static void main(String[] args) {
		System.setProperty("java.security.policy", "src.main.java/com/other/jaas/accessor/account.policy");
		System.setProperty("java.security.auth.login.config", "src.main.java/com/other/jaas/accessor/authentication_module.config");
		Subject subject = null;
		while(true) {			
			try {
				LoginContext loginContext = new LoginContext("AccountLogModule", new ConsoleCallBackHandler());
				loginContext.login();
				subject = loginContext.getSubject();
				break;
			} catch (LoginException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Success!");
		PrivilegedAction<String> action = () -> {
			try {
				System.out.println("Try to check permission...");
				AccountPermission permission = new AccountPermission("admin_act", "allow");
				AccessController.checkPermission(permission); 
				System.out.println("Check success");
			} catch(AccessControlException e) {
				e.printStackTrace();
				System.exit(0);
			}
			return null;
		};
		Subject.doAsPrivileged(subject, action, null);
	}

}
