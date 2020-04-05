package com.example.domain.model.customer;

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

	@Column(name = "first_name", nullable = false, length = NamePart.SIZE_MAX)
	private String value;

	protected FirstName() {}
}
