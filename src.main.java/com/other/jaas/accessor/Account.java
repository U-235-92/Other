package com.other.jaas.accessor;

import java.io.OutputStream;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Account {

	private String login;
	private Logger logger;
	
	{
		logger = Logger.getLogger(Account.class.getName());
		logger.addHandler(new ConsoleHandler() {
			@Override
			protected void setOutputStream(OutputStream out) throws SecurityException {
				super.setOutputStream(System.out);
			}
		});
		logger.setLevel(Level.INFO);
	}
	
	public Account() {
		super();
	}

	public Account(String login) {
		super();
		this.login = login;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void doCommonAction() {
		logger.info("Common acction was called");
	}
	
	public void doPrivelegedAction() {
		logger.info("Priveleged acction was called");
	}
	
	public void doGroupAction() {
		logger.info("Group acction was called");
	}
}
