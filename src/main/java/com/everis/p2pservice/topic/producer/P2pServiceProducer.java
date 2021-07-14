package com.everis.p2pservice.topic.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.everis.p2pservice.model.Customer;
import com.everis.p2pservice.model.Movement;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class P2pServiceProducer {

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	private final static String BOOTCOIN_TOPIC = "p2pservice-topic";
	private final static String YANKI_MOVEMENT_TOPIC = "yanki-movement-topic";
	
	
	public void sendSaveCustomerService(Customer customer) {
		log.info("enviando el objeto cliente bootcoin");
		kafkaTemplate.send(BOOTCOIN_TOPIC, customer );
	}
	
	public void sendSaveMovementService(Movement movement) {
		log.info("enviando el objeto movement yanki (bootcoin)");
		kafkaTemplate.send(YANKI_MOVEMENT_TOPIC, movement );
	}
	 
}
