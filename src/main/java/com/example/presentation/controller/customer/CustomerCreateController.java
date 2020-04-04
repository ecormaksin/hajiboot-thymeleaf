package com.example.presentation.controller.customer;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.customer.model.Customer;
import com.example.usecase.customer.CustomerCreateUseCase;
import com.example.usecase.user.LoginUserDetails;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("customers/create")
@RequiredArgsConstructor
public class CustomerCreateController {

	private final CustomerCreateUseCase customerCreateUseCase;
	private final CustomerConverter customerConverter;
	private final CustomerListController customerListController;
		
	@ModelAttribute
	CustomerForm setUpForm() {
		return new CustomerForm();
	}
	
	@PostMapping
	String create(@Validated CustomerForm form, BindingResult result, Model model, @AuthenticationPrincipal LoginUserDetails userDetails) {
		if (result.hasErrors()) {
			return customerListController.list(model);
		}
		Customer customer = customerConverter.formToEntity(form);
		customerCreateUseCase.create(customer, userDetails.getUser());
		return "redirect:/customers";
	}
}
