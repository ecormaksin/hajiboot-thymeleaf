package com.example.presentation.controller.customer;

import org.springframework.stereotype.Component;

import com.example.domain.customer.model.Customer;
import com.example.domain.customer.model.FirstName;
import com.example.domain.customer.model.LastName;

//@Mapper
//public interface CustomerConverter {
@Component
public class CustomerConverter {

//	@Mapping(target = "firstName", source = "firstName.value")
//	@Mapping(target = "lastName", source = "lastName.value")
//	Customer formToEntity(CustomerForm aCustomerForm);
	public Customer formToEntity(CustomerForm aCustomerForm) {
		FirstName firstName = new FirstName(aCustomerForm.getFirstName());
		LastName lastName = new LastName(aCustomerForm.getLastName());
		return new Customer(firstName, lastName);
	}
	
//	@Mapping(target = "firstName.value", source = "firstName")
//	@Mapping(target = "lastName.value", source = "lastName")
//	void updateFormFromEntity(Customer aCustomer, @MappingTarget CustomerForm form);
	public void updateFormFromEntity(Customer aCustomer, CustomerForm form) {
		String firstName = aCustomer.getFirstName().getValue();
		form.setFirstName(firstName);
		String lastName = aCustomer.getLastName().getValue();
		form.setLastName(lastName);
	}
}
