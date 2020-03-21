package com.example.application.customer.components;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.domain.customer.model.Customer;
import com.example.domain.customer.model.CustomerForm;
import com.example.domain.customer.repository.CustomerRepository;
import com.example.domain.customer.service.CustomerConverter;

import lombok.RequiredArgsConstructor;

//@Service
@RequiredArgsConstructor
public class CustomerQueryService {

	private final CustomerRepository customerRepository;
	private final CustomerConverter customerConverter;
	
	public List<Customer> findAll() {
		return customerRepository.findAllWithUserOrderByName();
	}
	
	public Page<Customer> findAll(Pageable pageable) {
		return customerRepository.findAllOrderByName(pageable);
	}
	
	public Customer findOne(Integer id) {
		return customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
	}
	
	public void findOne(Integer id, CustomerForm form) {
		Customer customer = this.findOne(id);
		customerConverter.updateFormFromEntity(customer, form);
	}
}
