package com.example.usecase.customer;

import com.example.domain.model.customer.Customer;
import com.example.domain.model.customer.CustomerRepository;
import com.example.domain.model.user.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class CustomerAbstractSaveUseCase {

	protected final CustomerRepository customerRepository;

	protected Customer save(Customer customer, User user) {
		customer.setUser(user);
		return customerRepository.save(customer);
	}
}
