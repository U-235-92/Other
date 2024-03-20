package com.other.spring_fast.chapter_9.request_scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@Autowired
	private LoginProcessor loginProcessor;
	
	@GetMapping(path = "/")
	public String loginGet() {
		return "login.html";
	}
	
	@PostMapping(path = "/")
	public String loginPost(@RequestParam String username, @RequestParam String password, Model model) {
		loginProcessor.setPassword(password);
		loginProcessor.setUsername(username);
		boolean loggedIn = loginProcessor.login();
		if(loggedIn) {
			return "redirect:/main";
		}
		model.addAttribute("message", "Login failed!");
		return "login.html";
	}
}
