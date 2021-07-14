package com.everis.p2pservice.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.everis.p2pservice.redis.document.BootCoin;
import com.everis.p2pservice.redis.service.BootCoinService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/bootcoin-rate")
public class BootCoinController {
	
	@Autowired
	private BootCoinService bootCoinService;
	
	@PostMapping
    public Mono<Boolean> put(@RequestBody BootCoin coin) {
        return bootCoinService.put(coin.getId(), coin);
    }
	
	@GetMapping("/{key}")
    public Mono<Object> get(@PathVariable("key") String key) {
        return bootCoinService.get(key);
    }
	
	@DeleteMapping("/{key}")
    public Mono<Boolean> delete(@PathVariable("key") String key) {
        return bootCoinService.delete(key);
    }
	

}
