package com.example.appname.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("userInformation")

public class UserController {
	@GetMapping("/user")
	public String userHome() {
		return "user-home";
	}

	@GetMapping("/user/link")
	public String userLink() {
		return "user-link";
	}

	@GetMapping("/user/data")
	public String userDataDetail() {
		return "user-data-detail";

	}

	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}

	@GetMapping("/checklogin")
	public String postLogin() {
		return "main";

	}
}
