package com.tb.wiredcoffee.web.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Version.CUSTOMER_API + "/customers")
public class CustomerController {

	@GetMapping("/{id}")
	public Customer getCustomer(@PathVariable Long id) {
		
		final Customer customer = new Customer();
		customer.setId(id);
		customer.setName("Name for " + id);
		
		return customer;
	}
}
