package com.everis.p2pservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.everis.p2pservice.model.Customer;
import com.everis.p2pservice.topic.producer.P2pServiceProducer;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/bootcoin-customer")
public class BootcoinCustomerController {
	
	@Autowired
	private P2pServiceProducer p2pServiceProducer;
	
	@PostMapping
	public Mono<Customer> saveCustomerBootcoin(@RequestBody Customer customer) {
		p2pServiceProducer.sendSaveCustomerService(customer);
		return Mono.just(customer);
	}
	
}
