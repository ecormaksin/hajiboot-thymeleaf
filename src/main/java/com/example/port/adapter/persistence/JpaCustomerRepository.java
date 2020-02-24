package com.example.port.adapter.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.domain.customer.Customer;

public interface JpaCustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("SELECT x FROM Customer x ORDER BY x.firstName, x.lastName")
	List<Customer> findAllOrderByName();
}
