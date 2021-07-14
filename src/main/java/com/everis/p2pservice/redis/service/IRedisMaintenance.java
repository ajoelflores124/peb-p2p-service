package com.everis.p2pservice.redis.service;

import reactor.core.publisher.Mono;

public interface IRedisMaintenance<T> {

	public Mono<Boolean> put(String key,T object);
	
}
