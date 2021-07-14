package com.everis.p2pservice.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.everis.p2pservice.entity.PurchaseBootcoin;

import reactor.core.publisher.Mono;

@Repository
public interface IPurchaseBootcoinRepository extends ReactiveMongoRepository<PurchaseBootcoin, String>{

 
	
}
