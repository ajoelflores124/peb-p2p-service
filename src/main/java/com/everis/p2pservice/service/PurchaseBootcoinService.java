package com.everis.p2pservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.p2pservice.entity.PurchaseBootcoin;
import com.everis.p2pservice.repository.IPurchaseBootcoinRepository;

import reactor.core.publisher.Mono;

@Service
public class PurchaseBootcoinService {

	
	@Autowired
	private IPurchaseBootcoinRepository purchaseBootcoinRepo;
	
	
	public Mono<PurchaseBootcoin> savePurchaseBootcoin(PurchaseBootcoin purchase){
		return purchaseBootcoinRepo.insert(purchase);
	}
	
	public Mono<PurchaseBootcoin> updatePurchaseBootcoin(PurchaseBootcoin purchase){
		return purchaseBootcoinRepo.save(purchase);
	}
	
	public Mono<Void> deletePurchaseBootcoin(String id){
		return purchaseBootcoinRepo.deleteById(id);
	}
	
}
