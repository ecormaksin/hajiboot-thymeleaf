package com.example.application.customer.components;

import org.springframework.stereotype.Service;

import com.example.domain.customer.model.Customer;
import com.example.domain.customer.model.CustomerForm;
import com.example.domain.customer.repository.CustomerRepository;
import com.example.domain.customer.service.CustomerConverter;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerCommandService {

	private final CustomerRepository customerRepository;
	private final CustomerConverter customerConverter;
	
	public Customer create(CustomerForm form) {
		Customer customer = customerConverter.formToEntity(form);
		return create(customer);
	}
	
	public Customer create(Customer customer) {
		return customerRepository.save(customer);
	}

	public Customer update(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public void delete(Integer id) {
		customerRepository.deleteById(id);
	}
}
