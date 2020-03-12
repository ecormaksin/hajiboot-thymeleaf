package com.example.application.customer.components;

import org.springframework.stereotype.Service;

import com.example.domain.customer.model.Customer;
import com.example.domain.customer.model.CustomerForm;
import com.example.domain.customer.repository.CustomerRepository;
import com.example.domain.customer.service.CustomerConverter;
import com.example.domain.user.model.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerCommandService {

	private final CustomerRepository customerRepository;
	private final CustomerConverter customerConverter;
	
	public Customer create(CustomerForm form, User user) {
		Customer customer = customerConverter.formToEntity(form);
		return create(customer, user);
	}
	
	public Customer create(Customer customer, User user) {
		return customerRepository.save(customer);
	}

	public Customer update(Integer id, CustomerForm form, User user) {
		Customer customer = customerConverter.formToEntity(form);
		customer.setId(id);
		return this.update(customer, user);
	}
	
	public Customer update(Customer customer, User user) {
		customer.setUser(user);
		return customerRepository.save(customer);
	}
	
	public void delete(Integer id) {
		customerRepository.deleteById(id);
	}
}
