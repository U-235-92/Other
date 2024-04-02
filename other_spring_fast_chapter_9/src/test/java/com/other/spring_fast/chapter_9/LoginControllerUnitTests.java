package com.other.spring_fast.chapter_9;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import com.other.spring_fast.chapter_9.request_scope.LoginController;
import com.other.spring_fast.chapter_9.request_scope.LoginProcessor;

@ExtendWith(MockitoExtension.class)
public class LoginControllerUnitTests {

	@Mock
	private Model model;
	@Mock
	private LoginProcessor loginProcessor;
	@InjectMocks
	private LoginController loginController;
	
	@Test
	public void loginPostLoginSuceedsTest() {
		BDDMockito.given(loginProcessor.login()).willReturn(false);
		String result = loginController.loginPost("natalie", "password", model);
		assertEquals("login.html", result);
		verify(model).addAttribute("message", "You are now logged in.");
	}
}
