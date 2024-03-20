package com.other.spring_fast.chapter_9.session_scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.other.spring_fast.chapter_9.application_scope.LoginCountService;

@Controller
public class MainController {

	@Autowired
	private LoginCountService loginCountService;
	private final LoggedUserManagementService loggedUserManagementService;
	
	public MainController(LoggedUserManagementService loggedUserManagementService) {
		this.loggedUserManagementService = loggedUserManagementService;
	}
	
	@GetMapping("/main")
	public String home(@RequestParam(required = false) String Logout, Model model) {
		if(Logout != null) {
			loggedUserManagementService.setUsername(null);
		}
		String username = loggedUserManagementService.getUsername();
		int count = loginCountService.getCount();
		if(username ==  null) {
			return "redirect:/";
		}
		model.addAttribute("username", username);
		model.addAttribute("loginCount", count);
		return "main.html";
	}
}
