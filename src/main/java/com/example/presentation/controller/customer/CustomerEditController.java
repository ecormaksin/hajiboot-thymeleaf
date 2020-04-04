package com.example.presentation.controller.customer;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.domain.customer.model.Customer;
import com.example.usecase.customer.CustomerFindOneUseCase;
import com.example.usecase.customer.CustomerUpdateUseCase;
import com.example.usecase.user.LoginUserDetails;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("customers/edit")
@RequiredArgsConstructor
public class CustomerEditController {

	private final CustomerFindOneUseCase customerFindOneUseCase;
	private final CustomerUpdateUseCase customerUpdateUseCase;
	private final CustomerConverter customerConverter;
	
	@ModelAttribute
	CustomerForm setUpForm() {
		return new CustomerForm();
	}
	
	@GetMapping(params = "form")
	String editForm(@RequestParam Integer id, CustomerForm form) {
		Customer customer = customerFindOneUseCase.findOne(id);
		customerConverter.updateFormFromEntity(customer, form);
		return "customers/edit";
	}
	
	@PostMapping
	String edit(@RequestParam Integer id, @Validated CustomerForm form, BindingResult result, @AuthenticationPrincipal LoginUserDetails userDetails) {
		if (result.hasErrors()) {
			return editForm(id, form);
		}
		Customer customer = customerConverter.formToEntity(form);
		customerUpdateUseCase.update(id, customer, userDetails.getUser());
		return "redirect:/customers";
	}
	
	@GetMapping(params = "goToTop")
	String goToTop() {
		return "redirect:/customers";
	}
}
