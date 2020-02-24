package com.example.port.adapter.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.domain.customer.Customer;
import com.example.domain.customer.CustomerRepository;

@Repository
public class JpaCustomerRepositoryWrapper implements CustomerRepository {

	JpaCustomerRepository jpaCustomerRepository;
	
	JpaCustomerRepositoryWrapper(JpaCustomerRepository aJpaCustomerRepository) {
		this.jpaCustomerRepository = aJpaCustomerRepository;
	}
	
	public List<Customer> findAll() {
		return this.jpaCustomerRepository.findAll();
	}
	
	public List<Customer> findAllOrderByName() {
		return this.jpaCustomerRepository.findAllOrderByName();
	}
	
	public Customer findOne(Integer customerId) {
		return this.jpaCustomerRepository.getOne(customerId);
	}
	
	public Customer save(Customer customer) {
		return this.jpaCustomerRepository.save(customer);
	}

	public void delete(Integer customerId) {
		this.jpaCustomerRepository.deleteById(customerId);
	}
}
