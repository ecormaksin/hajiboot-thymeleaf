package com.example.application;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.domain.customer.Customer;
import com.example.domain.customer.CustomerRepository;

@Service
public class CustomerService {
	CustomerRepository customerRepository;

	CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
	
	public Customer findOne(Integer id) {
		return customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
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
