package com.example.usecase.customer;

import org.springframework.stereotype.Service;

import com.example.domain.model.customer.Customer;
import com.example.domain.model.customer.CustomerId;
import com.example.domain.model.customer.CustomerRepository;
import com.example.domain.model.user.User;

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
