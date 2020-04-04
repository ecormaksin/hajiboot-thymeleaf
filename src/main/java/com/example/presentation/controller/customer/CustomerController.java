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

import com.example.domain.customer.model.Customer;
import com.example.domain.customer.model.CustomerId;
import com.example.usecase.customer.components.CustomerCommandService;
import com.example.usecase.customer.components.CustomerQueryService;
import com.example.usecase.user.LoginUserDetails;

import lombok.RequiredArgsConstructor;

//@Controller
@RequestMapping("customers")
@RequiredArgsConstructor
public class CustomerController {

	private final CustomerQueryService customerQueryService;
	private final CustomerCommandService customerCommandService;
	private final CustomerConverter customerConverter;
	
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
		Customer customer = customerConverter.formToEntity(form);
		customerCommandService.create(customer, userDetails.getUser());
		return "redirect:/customers";
	}
	
	@GetMapping(value = "edit", params = "form")
	String editForm(@RequestParam Integer id, CustomerForm form) {
		Customer customer = customerQueryService.findOne(id);
		customerConverter.updateFormFromEntity(customer, form);
		return "customers/edit";
	}
	
	@PostMapping(value = "edit")
	String edit(@RequestParam Integer id, @Validated CustomerForm form, BindingResult result, @AuthenticationPrincipal LoginUserDetails userDetails) {
		if (result.hasErrors()) {
			return editForm(id, form);
		}
		Customer customer = customerConverter.formToEntity(form);
		customerCommandService.update(id, customer, userDetails.getUser());
		return "redirect:/customers";
	}
	
	@GetMapping(value = "edit", params = "goToTop")
	String goToTop() {
		return "redirect:/customers";
	}
	
	@PostMapping(value = "delete")
	String delete(@RequestParam Integer id) {
		customerCommandService.delete(new CustomerId(id));
		return "redirect:/customers";
	}
}
