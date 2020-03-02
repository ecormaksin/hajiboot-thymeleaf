package com.example.domain.customer.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class NamePart {
	
	protected static final int SIZE_MIN = 1;
	protected static final int SIZE_MAX = 127;

	@NotNull
	@Size(min = SIZE_MIN, max = SIZE_MAX)
	protected String value;
}
