package com.example.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//@Controller
public class LoginController {

	@GetMapping("loginForm")
	String loginForm() {
		return "loginForm";
	}
}
