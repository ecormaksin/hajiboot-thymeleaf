package com.example.usecase.customer;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.domain.model.customer.Customer;
import com.example.domain.model.customer.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerFindAllUseCase {

	private final CustomerRepository customerRepository;
	
	public List<Customer> findAll() {
		return customerRepository.findAllWithUserOrderByName();
	}
}
