package com.example.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.CustomerService;
import com.example.domain.customer.Customer;

@RestController
@RequestMapping("api/customers")
public class CustomerRestController {
	CustomerService customerService;
	
	CustomerRestController(CustomerService aCustomerService) {
		this.customerService = aCustomerService;
	}
	
	// 顧客全件取得
	@GetMapping
	List<Customer> getCustomers() {
		List<Customer> customers = customerService.findAll();
		return customers;
	}
	
	// 顧客1件取得
	@GetMapping(value="{id}")
	Customer getCustomer(@PathVariable Integer id) {
		Customer customer = customerService.findOne(id);
		return customer;
	}
}
