package com.green.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Users")
public class UserController {
	
	// /Users/List
	@RequestMapping("/List")
	public String list() {
		
		return "users/list";
	}
}
