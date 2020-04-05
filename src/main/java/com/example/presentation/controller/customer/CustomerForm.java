package com.example.presentation.controller.customer;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.domain.model.customer.NamePart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerForm {
	
	@NotNull
	@Size(min = NamePart.SIZE_MIN, max = NamePart.SIZE_MAX)
	private String firstName;
	
	@NotNull
	@Size(min = NamePart.SIZE_MIN, max = NamePart.SIZE_MAX)
	private String lastName;
}
