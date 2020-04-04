package com.example.usecase.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.domain.customer.model.Customer;
import com.example.domain.customer.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerFindAllPageableUserCase {

	private final CustomerRepository customerRepository;
	
	public Page<Customer> findAll(Pageable pageable) {
		return customerRepository.findAllOrderByName(pageable);
	}
}
