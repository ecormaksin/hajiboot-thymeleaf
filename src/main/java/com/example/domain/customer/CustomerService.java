package com.example.domain.customer;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	CustomerRepository customerRepository;

	CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
	
	public Customer getOne(Integer id) {
		return customerRepository.getOne(id);
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
