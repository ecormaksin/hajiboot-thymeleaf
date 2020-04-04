package com.example.domain.user.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.domain.customer.model.Customer;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@Entity
@Table(name = "users")
@ToString(exclude = "customers")
public class User {
	@Id
	private String username;
	
	@JsonIgnore
	private String encodedPassword;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	private List<Customer> customers;
	
	protected User() {}
}
