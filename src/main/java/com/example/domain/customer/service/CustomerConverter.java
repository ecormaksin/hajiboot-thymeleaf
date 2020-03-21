package com.example.domain.customer.service;

import org.springframework.stereotype.Service;

import com.example.domain.customer.model.Customer;
import com.example.domain.customer.model.CustomerForm;
import com.example.domain.customer.model.FirstName;
import com.example.domain.customer.model.LastName;

//@Mapper
//public interface CustomerConverter {
//@Service
public class CustomerConverter {

//	@Mapping(target = "firstName", source = "firstName.value")
//	@Mapping(target = "lastName", source = "lastName.value")
//	Customer formToEntity(CustomerForm aCustomerForm);
	public Customer formToEntity(CustomerForm aCustomerForm) {
		Customer customer = new Customer();
		customer.setFirstName(aCustomerForm.getFirstName().getValue());
		customer.setLastName(aCustomerForm.getLastName().getValue());
		return customer;
	}
	
//	@Mapping(target = "firstName.value", source = "firstName")
//	@Mapping(target = "lastName.value", source = "lastName")
//	void updateFormFromEntity(Customer aCustomer, @MappingTarget CustomerForm form);
	public void updateFormFromEntity(Customer aCustomer, CustomerForm form) {
		FirstName firstName = new FirstName(aCustomer.getFirstName());
		form.setFirstName(firstName);
		LastName lastName = new LastName(aCustomer.getLastName());
		form.setLastName(lastName);
	}
}
