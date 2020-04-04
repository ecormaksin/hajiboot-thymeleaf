package com.example.usecase.customer;

import org.springframework.stereotype.Service;

import com.example.domain.customer.model.Customer;
import com.example.domain.customer.model.CustomerId;
import com.example.domain.customer.repository.CustomerRepository;
import com.example.domain.user.model.User;

@Service
public class CustomerUpdateUseCase extends CustomerAbstractSaveUseCase {

	CustomerUpdateUseCase(CustomerRepository aCustomerRepository) {
		super(aCustomerRepository);
	}
	
	public Customer update(Integer id, Customer customer, User user) {
		customer.setCustomerId(new CustomerId(id));
		return super.save(customer, user);
	}
}
