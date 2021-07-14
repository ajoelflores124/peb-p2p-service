package com.everis.p2pservice.service;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Service;
import com.everis.p2pservice.entity.PurchaseBootcoin;
import com.everis.p2pservice.model.Movement;
import com.everis.p2pservice.redis.document.BootCoin;
import com.everis.p2pservice.redis.service.BootCoinService;
import com.everis.p2pservice.repository.IPurchaseBootcoinRepository;
import com.everis.p2pservice.topic.producer.P2pServiceProducer;
import com.fasterxml.jackson.databind.ObjectMapper;

import reactor.core.publisher.Mono;

@Service
public class PurchaseBootcoinService {

	
	@Autowired
	private IPurchaseBootcoinRepository purchaseBootcoinRepo;
	
	@Autowired
	private P2pServiceProducer p2pServiceProducer;
	
	@Autowired
	private BootCoinService  bootCoinService;
	
	
	public Mono<PurchaseBootcoin> savePurchaseBootcoin(PurchaseBootcoin purchase){
		return purchaseBootcoinRepo.insert(purchase);
	}
	
	public Mono<PurchaseBootcoin> updatePurchaseBootcoin(PurchaseBootcoin purchase){
		return purchaseBootcoinRepo.save(purchase);
	}
	
	public Mono<Void> deletePurchaseBootcoin(String id){
		return purchaseBootcoinRepo.deleteById(id);
	}
	
	public Mono<PurchaseBootcoin> validateMadePayPurchaseYanki( String id ,long status  ){
		
		PurchaseBootcoin p= purchaseBootcoinRepo.findById(id).share().block();
		if(p.getStatus() == 2L) {
			throw new RuntimeException("Esta solicitud ya sido procesada");
		}
		Movement m=new Movement();
		//Obtenemos el tipo de cambio desde REDIS
		System.out.println("p.getTypePur()=>"+ p.getTypePur());
		Object obj=bootCoinService.get(p.getTypePur()).share().block();

		final ObjectMapper mapper = new ObjectMapper();
		final BootCoin b = mapper.convertValue((Map<String,BootCoin>)obj, BootCoin.class);
		// calculamos el monto 
		m.setAmount( p.getAmountPur() * b.getMountRate()  );

		m.setNumDoc( p.getNumDocPurchaser() );
		m.setDescription(p.getDescPur());
		//m.setAmount(p.getAmountPur());
		m.setDate(new Date());
		m.setTypeMov("R");//pago
		m.setPhone( p.getPhonePurchaser() );
		m.setPhoneOrigin( p.getPhoneSeller() );
		m.setYanki(true);
		m.setStatus(1L);
		p2pServiceProducer.sendSaveMovementService(m);

		p.setStatus(2L);

		return purchaseBootcoinRepo.save(p);
	}
	
}
