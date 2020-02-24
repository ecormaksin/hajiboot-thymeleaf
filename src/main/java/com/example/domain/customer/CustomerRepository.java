package com.example.domain.customer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("SELECT x FROM Customer x ORDER BY x.firstName, x.lastName")
	List<Customer> findAllOrderByName();
}