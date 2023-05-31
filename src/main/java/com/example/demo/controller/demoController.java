package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class demoController {

	@GetMapping("/")
	public String index() {
		return "inicio";
	}

	@GetMapping("/error")
	public String error() {
		return "inicio";
	}
	
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	
	@GetMapping("/documentation")
	public String documentation() {
		return "documentacion";
	}
	
	@GetMapping("/about")
	public String about() {
		return "about";
	}
	

}
