package com.example.presentation.controller.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.domain.customer.model.CustomerId;
import com.example.usecase.customer.CustomerDeleteUseCase;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("customers/delete")
@RequiredArgsConstructor
public class CustomerDeleteController {

	private final CustomerDeleteUseCase customerDeleteUseCase;
	
	@PostMapping
	String delete(@RequestParam Integer id) {
		customerDeleteUseCase.delete(new CustomerId(id));
		return "redirect:/customers";
	}
}
