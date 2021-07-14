package com.everis.p2pservice.redis.document;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import lombok.Data;


@Data
public class BootCoin implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String desRate;
	private Double mountRate;
	private long status;

}
