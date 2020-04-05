package com.example.presentation.controller.customer;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.model.customer.Customer;
import com.example.usecase.customer.CustomerFindAllUseCase;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("customers")
@RequiredArgsConstructor
public class CustomerListController {

	private final CustomerFindAllUseCase customerFindAllUseCase;
	
	@ModelAttribute
	CustomerForm setUpForm() {
		return new CustomerForm();
	}
	
	@GetMapping
	String list(Model model) {
		List<Customer> customers = customerFindAllUseCase.findAll();
		model.addAttribute("customers", customers);
		return "customers/list";
	}
}
