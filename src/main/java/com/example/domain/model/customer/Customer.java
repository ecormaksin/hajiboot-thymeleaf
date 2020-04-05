package com.example.domain.model.customer;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.domain.model.user.User;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Entity
@Table(name = "customers")
public class Customer {
	@Setter
	@EmbeddedId
	private CustomerId customerId;
	
	@NonNull
	private FirstName firstName;
	
	@NonNull
	private LastName lastName;
	
	@Setter
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = true, name = "username")
	private User user;
	
	protected Customer() {}
	
	public Customer(@NonNull FirstName firstName, @NonNull LastName lastName) {
		super();
		this.customerId = new CustomerId();
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
