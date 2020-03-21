package com.example.presentation.controller.customer;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.application.customer.components.CustomerCommandService;
import com.example.application.customer.components.CustomerQueryService;
import com.example.application.user.components.LoginUserDetails;
import com.example.domain.customer.model.Customer;
import com.example.domain.customer.model.CustomerForm;

import lombok.RequiredArgsConstructor;

//@Controller
@RequestMapping("customers")
@RequiredArgsConstructor
public class CustomerController {

	private final CustomerQueryService customerQueryService;
	private final CustomerCommandService customerCommandService;
	
	@ModelAttribute
	CustomerForm setUpForm() {
		return new CustomerForm();
	}
	
	@GetMapping
	String list(Model model) {
		List<Customer> customers = customerQueryService.findAll();
		model.addAttribute("customers", customers);
		return "customers/list";
	}
	
	@PostMapping(value = "create")
	String create(@Validated CustomerForm form, BindingResult result, Model model, @AuthenticationPrincipal LoginUserDetails userDetails) {
		if (result.hasErrors()) {
			return list(model);
		}
		customerCommandService.create(form, userDetails.getUser());
		return "redirect:/customers";
	}
	
	@GetMapping(value = "edit", params = "form")
	String editForm(@RequestParam Integer id, CustomerForm form) {
		customerQueryService.findOne(id, form);
		return "customers/edit";
	}
	
	@PostMapping(value = "edit")
	String edit(@RequestParam Integer id, @Validated CustomerForm form, BindingResult result, @AuthenticationPrincipal LoginUserDetails userDetails) {
		if (result.hasErrors()) {
			return editForm(id, form);
		}
		customerCommandService.update(id, form, userDetails.getUser());
		return "redirect:/customers";
	}
	
	@GetMapping(value = "edit", params = "goToTop")
	String goToTop() {
		return "redirect:/customers";
	}
	
	@PostMapping(value = "delete")
	String delete(@RequestParam Integer id) {
		customerCommandService.delete(id);
		return "redirect:/customers";
	}
}
