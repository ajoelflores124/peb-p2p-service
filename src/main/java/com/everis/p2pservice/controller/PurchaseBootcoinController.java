package com.everis.p2pservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.p2pservice.entity.PurchaseBootcoin;
import com.everis.p2pservice.service.PurchaseBootcoinService;
import com.fasterxml.jackson.annotation.JacksonInject.Value;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/purchase-bootcoin")
public class PurchaseBootcoinController {

	
	@Autowired
	private PurchaseBootcoinService purchaseService; 
	
	@PostMapping
	public Mono<PurchaseBootcoin> savePurchaseBootcoin(@RequestBody PurchaseBootcoin purchase) {
		return purchaseService.savePurchaseBootcoin(purchase);
	}
	
	@PutMapping
	public Mono<PurchaseBootcoin> updatePurchaseBootcoin(@RequestBody PurchaseBootcoin purchase) {
		return purchaseService.updatePurchaseBootcoin(purchase);
	}
	
	@DeleteMapping("/{id}")
	public Mono<Void> deletePurchaseBootcoin(@PathVariable String id) {
		return purchaseService.deletePurchaseBootcoin(id);
	}
	
	@GetMapping("/validate-pay/{id}/{status}")
	public Mono<PurchaseBootcoin> validatePayPurchaseBootcoin(@PathVariable String id,@PathVariable String status) {
		
		return purchaseService.validateMadePayPurchaseYanki(id, Long.parseLong(status));
	}
	
	
}
