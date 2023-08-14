package com.other.jaas_demo.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class SimpleLoginModule implements LoginModule {

	private Subject subject;
	private CallbackHandler callbackHandler;
	private static Map<Account, String> accountMap = new HashMap<>();
	
//	static {
//		try (FileInputStream fis = new FileInputStream(new File("src/com/other/jaas_demo/account_store.txt"));
//				InputStreamReader isr = new InputStreamReader(fis);
//				BufferedReader br = new BufferedReader(isr)){
//			String line = null;
//			while((line = br.readLine()) != null) {
//				String[] accountParts = line.split("!");
//				String login = accountParts[0];
//				char[] password = accountParts[1].toCharArray();
//				String role = accountParts[2];
//				Account account = new Account(login, password);
//				accountMap.put(account, role);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
	static {
		Account admin = new Account("admin", new char[] {'a', 'd', 'm', 'i', 'n'});
		Account user = new Account("user", new char[] {'1', '2', '3'});
		String adminRole = "admin";
		String userRole = "user";
		accountMap.put(admin, adminRole);
		accountMap.put(user, userRole);
	}
	
	@Override
	public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState,
			Map<String, ?> options) {
		this.subject = subject;
		this.callbackHandler = callbackHandler;
	}

	@Override
	public boolean login() throws LoginException {
		Callback nameCallback = new NameCallback("Login: ");
		Callback passCallback = new PasswordCallback("Password: ", true);
		Callback[] callbacks = new Callback[] {nameCallback, passCallback};
		try {
			callbackHandler.handle(callbacks);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} catch (UnsupportedCallbackException e) {
			System.err.println(e.getMessage());
		}
		String login = ((NameCallback) nameCallback).getName();
		char[] pass = ((PasswordCallback) passCallback).getPassword();
		Account logAccount = new Account(login, pass);
		if(checkLogin(logAccount)) {
			setUpSubjectPrincipal(logAccount);
			return true;
		} else {
			return false;
		}
	}

	private boolean checkLogin(Account account) {
		return accountMap.entrySet().stream().filter(entry -> entry.getKey().equals(account)).count() > 0;
	}

	private void setUpSubjectPrincipal(Account account) {
		for(Map.Entry<Account, String> entry : accountMap.entrySet()) {
			if(entry.getKey().equals(account)) {
				String roleName = accountMap.get(entry.getKey());
				subject.getPrincipals().add(new RolePrincipal(roleName));
				break;
			}
		}
	}

	@Override
	public boolean commit() throws LoginException {
		return true;
	}

	
	@Override
	public boolean abort() throws LoginException {
		return true;
	}

	@Override
	public boolean logout() throws LoginException {
		return true;
	}

}
