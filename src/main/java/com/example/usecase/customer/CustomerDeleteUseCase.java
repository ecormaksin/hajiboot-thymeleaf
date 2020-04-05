package com.example.usecase.customer;

import org.springframework.stereotype.Service;

import com.example.domain.model.customer.CustomerId;
import com.example.domain.model.customer.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerDeleteUseCase {

	private final CustomerRepository customerRepository;

	public void delete(CustomerId customerId) {
		customerRepository.deleteById(customerId);
	}
}
