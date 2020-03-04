package com.example.domain.customer.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.example.domain.customer.model.Customer;
import com.example.domain.customer.model.CustomerForm;

@Mapper
public interface CustomerConverter {

	@Mapping(target = "firstName", source = "firstName.value")
	@Mapping(target = "lastName", source = "lastName.value")
	Customer formToEntity(CustomerForm aCustomerForm);
	
	@Mapping(target = "firstName.value", source = "firstName")
	@Mapping(target = "lastName.value", source = "lastName")
	void updateFormFromEntity(Customer aCustomer, @MappingTarget CustomerForm form);
}
