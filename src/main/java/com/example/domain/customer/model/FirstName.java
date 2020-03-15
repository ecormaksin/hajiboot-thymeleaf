package com.example.domain.customer.model;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public class FirstName extends NamePart {

	protected FirstName() {}
	
	public FirstName(String value) {
		super(value);
	}
}
