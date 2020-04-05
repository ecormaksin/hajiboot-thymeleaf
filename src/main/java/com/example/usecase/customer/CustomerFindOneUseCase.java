package com.example.usecase.customer;

import org.springframework.stereotype.Service;

import com.example.domain.model.customer.Customer;
import com.example.domain.model.customer.CustomerId;
import com.example.domain.model.customer.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerFindOneUseCase {

	private final CustomerRepository customerRepository;
	
	public Customer findOne(Integer id) {
		CustomerId customerId = new CustomerId(id);
		return customerRepository.findById(customerId).orElseThrow(CustomerNotFoundException::new);
	}
}
