package com.example.usecase.customer;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.domain.customer.model.Customer;
import com.example.domain.customer.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerFindAllUseCase {

	private final CustomerRepository customerRepository;
	
	public List<Customer> findAll() {
		return customerRepository.findAllWithUserOrderByName();
	}
}
