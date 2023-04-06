package com.example.appname.controllers;

import com.example.appname.models.User;

import com.example.appname.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AdminController {

	@Autowired
	private UserServices userService;

	@GetMapping("/admin")
	public String adminPage(Model model) {
		// Get all users
		Iterable<User> users = userService.findAllUsers();
		model.addAttribute("users", users);

		return "admin";
	}

	@GetMapping("/admin/user/{id}")
	public String userDetailPage(@PathVariable("id") int id, Model model) {
		// Get user by ID
		User user = userService.findUserById(id);
		model.addAttribute("user", user);
		

		return "user-detail";
	}
}