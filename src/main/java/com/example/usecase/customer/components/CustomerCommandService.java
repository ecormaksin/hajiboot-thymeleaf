package com.example.usecase.customer.components;

import org.springframework.stereotype.Service;

import com.example.domain.customer.model.Customer;
import com.example.domain.customer.model.CustomerId;
import com.example.domain.customer.repository.CustomerRepository;
import com.example.domain.user.model.User;

import lombok.RequiredArgsConstructor;

//@Service
@RequiredArgsConstructor
public class CustomerCommandService {

	private final CustomerRepository customerRepository;

	private Customer save(Customer customer, User user) {
		customer.setUser(user);
		return customerRepository.save(customer);
	}
	
	public Customer create(Customer customer, User user) {
		return this.save(customer, user);
	}

	public Customer update(Integer id, Customer customer, User user) {
		customer.setCustomerId(new CustomerId(id));
		return this.save(customer, user);
	}
	
	public void delete(CustomerId customerId) {
		customerRepository.deleteById(customerId);
	}
}
