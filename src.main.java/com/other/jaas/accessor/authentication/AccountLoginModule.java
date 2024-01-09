package com.other.jaas.accessor.authentication;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

import com.other.jaas.accessor.Account;

public class AccountLoginModule implements LoginModule {

	private Subject subject;
	private CallbackHandler callbackHandler;
	private Set<Account> accounts = new HashSet<Account>();
	{
		Account ADMIN = new Account("admin");
		Account GROUP = new Account("group");
		Account COMMON = new Account("common");
		accounts.add(ADMIN);
		accounts.add(GROUP);
		accounts.add(COMMON);
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
		Callback[] callbacks = new Callback[] {nameCallback};
		try {
			callbackHandler.handle(callbacks);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} catch (UnsupportedCallbackException e) {
			System.err.println(e.getMessage());
		}
		String login = ((NameCallback) nameCallback).getName();
		Account logAccount = new Account(login);
		if(checkLogin(logAccount)) {
			setUpSubjectPrincipal(logAccount);
			return true;
		} else {
			return false;
		}
	}

	private boolean checkLogin(Account account) {
		return accounts.stream().filter(entry -> entry.getLogin().equals(account.getLogin())).count() > 0;
	}
	
	private void setUpSubjectPrincipal(Account logAccount) {
		LoginPrincipal principal = new LoginPrincipal(logAccount.getLogin());
		subject.getPrincipals().add(principal);
	}
	
	@Override
	public boolean commit() throws LoginException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean abort() throws LoginException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean logout() throws LoginException {
		// TODO Auto-generated method stub
		return true;
	}

}
