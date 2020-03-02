package com.example.domain.customer.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerForm {
	
	@NotNull
	@Valid
	private FirstName firstName;
	
	@NotNull
	@Valid
	private LastName lastName;
}
