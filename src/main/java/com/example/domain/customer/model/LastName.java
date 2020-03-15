package com.example.domain.customer.model;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public class LastName extends NamePart {
	
	protected LastName() {}
	
	public LastName(String value) {
		super(value);
	}
}
