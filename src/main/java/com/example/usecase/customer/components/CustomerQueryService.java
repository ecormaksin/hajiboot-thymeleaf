package com.example.usecase.customer.components;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.domain.customer.model.Customer;
import com.example.domain.customer.model.CustomerId;
import com.example.domain.customer.repository.CustomerRepository;
import com.example.usecase.customer.CustomerNotFoundException;

import lombok.RequiredArgsConstructor;

//@Service
@RequiredArgsConstructor
public class CustomerQueryService {

	private final CustomerRepository customerRepository;
	
	public List<Customer> findAll() {
		return customerRepository.findAllWithUserOrderByName();
	}
	
	public Page<Customer> findAll(Pageable pageable) {
		return customerRepository.findAllOrderByName(pageable);
	}
	
	public Customer findOne(Integer id) {
		CustomerId customerId = new CustomerId(id);
		return customerRepository.findById(customerId).orElseThrow(CustomerNotFoundException::new);
	}
}
