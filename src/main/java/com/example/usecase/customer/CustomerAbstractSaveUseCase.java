package com.example.usecase.customer;

import com.example.domain.customer.model.Customer;
import com.example.domain.customer.repository.CustomerRepository;
import com.example.domain.user.model.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class CustomerAbstractSaveUseCase {

	protected final CustomerRepository customerRepository;

	protected Customer save(Customer customer, User user) {
		customer.setUser(user);
		return customerRepository.save(customer);
	}
}
