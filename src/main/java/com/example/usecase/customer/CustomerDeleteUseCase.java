package com.example.usecase.customer;

import org.springframework.stereotype.Service;

import com.example.domain.customer.model.CustomerId;
import com.example.domain.customer.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerDeleteUseCase {

	private final CustomerRepository customerRepository;

	public void delete(CustomerId customerId) {
		customerRepository.deleteById(customerId);
	}
}
