package com.example.usecase.customer;

import org.springframework.stereotype.Service;

import com.example.domain.model.customer.Customer;
import com.example.domain.model.customer.CustomerRepository;
import com.example.domain.model.user.User;

@Service
public class CustomerCreateUseCase extends CustomerAbstractSaveUseCase {

	CustomerCreateUseCase(CustomerRepository aCustomerRepository) {
		super(aCustomerRepository);
	}
	
	public Customer create(Customer customer, User user) {
		return super.save(customer, user);
	}
}
