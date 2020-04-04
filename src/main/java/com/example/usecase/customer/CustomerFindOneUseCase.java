package com.example.usecase.customer;

import org.springframework.stereotype.Service;

import com.example.domain.customer.model.Customer;
import com.example.domain.customer.model.CustomerId;
import com.example.domain.customer.repository.CustomerRepository;

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
