package com.tb.wiredcoffee.web.api;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping(Version.CUSTOMER_API + "/customers")
public class CustomerController {
	
	@Autowired
	StringRedisTemplate stringRedisTemplate;

	@GetMapping("/{id}")
	public Customer getCustomer(@PathVariable Long id) throws JsonMappingException, JsonParseException, IOException {
		
		String result = stringRedisTemplate.opsForValue().get(id.toString());
		
		Customer customer = new Customer();
		
		if (result != null) {
			
			ObjectMapper mapper = new ObjectMapper();
			customer = mapper.readValue(result, Customer.class);
		}
		
		return customer;
	}
	
	@PutMapping("/{id}")
	public String putCustomer(@PathVariable Long id, @RequestParam String name) throws JsonProcessingException {
		
		final Customer customer = new Customer();
		customer.setId(id);
		customer.setName(name);
		
		ObjectMapper mapper = new ObjectMapper();
		String cacheCustomerValue = mapper.writeValueAsString(customer);
		
		stringRedisTemplate.opsForValue().set(id.toString(), cacheCustomerValue);
		
		return cacheCustomerValue;
	}
}
