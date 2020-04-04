package com.example.domain.customer.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Embeddable
public class FirstName extends NamePart {

	@Column(name = "first_name", nullable = false, length = 30)
	private String value;

	protected FirstName() {}
}
