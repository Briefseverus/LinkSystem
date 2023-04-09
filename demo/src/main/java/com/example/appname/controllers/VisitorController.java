package com.example.appname.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class VisitorController {
	@GetMapping("/visit")
	public String visit() {
		return "visitor";
	}
}
