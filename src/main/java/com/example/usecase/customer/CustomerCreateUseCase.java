package com.example.usecase.customer;

import org.springframework.stereotype.Service;

import com.example.domain.customer.model.Customer;
import com.example.domain.customer.repository.CustomerRepository;
import com.example.domain.user.model.User;

@Service
public class CustomerCreateUseCase extends CustomerAbstractSaveUseCase {

	CustomerCreateUseCase(CustomerRepository aCustomerRepository) {
		super(aCustomerRepository);
	}
	
	public Customer create(Customer customer, User user) {
		return super.save(customer, user);
	}
}
