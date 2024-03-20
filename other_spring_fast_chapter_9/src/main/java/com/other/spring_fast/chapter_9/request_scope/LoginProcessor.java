package com.other.spring_fast.chapter_9.request_scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.other.spring_fast.chapter_9.application_scope.LoginCountService;
import com.other.spring_fast.chapter_9.session_scope.LoggedUserManagementService;

@Component
@RequestScope
public class LoginProcessor {

	private String username;
	private String password;
	@Autowired
	private LoginCountService loginCountService;
	private final LoggedUserManagementService loggedUserManagementService;
	
	public LoginProcessor(LoggedUserManagementService loggedUserManagementService) {
		this.loggedUserManagementService = loggedUserManagementService;
	}
	
	public boolean login() {
		loginCountService.increment();
		String username = this.getUsername();
		String password = this.getPassword();
		boolean logResult = false;
		if("natalie".equals(username) && "password".equals(password)) {
			logResult = true;
			loggedUserManagementService.setUsername(username);
		}
		return logResult;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
