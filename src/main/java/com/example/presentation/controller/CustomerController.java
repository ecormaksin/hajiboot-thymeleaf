package com.example.presentation.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.application.CustomerService;
import com.example.domain.customer.Customer;

@Controller
@RequestMapping("customers")
public class CustomerController {

	CustomerService customerService;
	
	CustomerController(CustomerService aCustomerService) {
		this.customerService = aCustomerService;
	}
	
	@GetMapping
	String list(Model model) {
		List<Customer> customers = customerService.findAll();
		model.addAttribute("customers", customers);
		return "customers/list";
	}
}
