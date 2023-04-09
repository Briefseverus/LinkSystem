package com.example.appname.controllers;

import org.springframework.web.bind.annotation.SessionAttributes;
import com.example.appname.models.User;

import com.example.appname.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@SessionAttributes("userInformation")
public class AdminController {

	@Autowired
	private UserServices userService;

	@GetMapping("/admin")
	public String adminPage(Model model) {
		// Get all users
		Iterable<User> users = userService.findAllUsers();
		model.addAttribute("users", users);

		return "admin-home";
	}

	@GetMapping("/admin/user/data/{id}")
	public String userDetailDataPage(@PathVariable("id") int id, Model model) {
		// Get user by ID
		User user = userService.findUserById(id);
		model.addAttribute("user", user);

		return "admin-user-data-detail";
	}

	@GetMapping("/admin/user/domain/{id}")
	public String userDetailLinkPage(@PathVariable("id") int id, Model model) {
		// Get user by ID
		User user = userService.findUserById(id);
		model.addAttribute("user", user);

		return "admin-user-domain-detail";
	}

	@GetMapping("/admin/user/del")
	public String visit() {
		return "visitor";
	}

	@GetMapping("/admin/user/register")
	public String getRegisterUser() {
		return "visitor";
	}

	@PostMapping("/admin/user/register")
	public String postRegisterUser() {
		return "admin-home";
	}

	@PostMapping("/admin/user/register/edit")
	public String postRegisterUserEdit() {
		return "admin-home";
	}
}