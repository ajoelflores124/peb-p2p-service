package com.everis.p2pservice.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "purchase_bootcoin")
public class PurchaseBootcoin implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2465819240512823291L;
	@Id
	private String id;
	
	@Field(name = "date_pur")
    private Date datePur;
	@Field(name = "type_pur")
    private String typePur;    
    @Field(name = "desc_pur")
    private String descPur;
    
    @Field(name = "amount_pur")
    private double amountPur;
    
    @Field(name = "num_doc_pur")
    private String numDocPurchaser;//comprador
    
    @Field(name = "num_doc_sel")
    private String numDocSeller;//vendedor
    
    
    @Field(name = "phone_pur")
    private String phonePurchaser;//comprador
    
    @Field(name = "phone_sel")
    private String phoneSeller;//vendedor
    
    @Field(name = "num_acc_pur")
    private String numAccPurchaser;//comprador
    
    @Field(name = "num_acc_sel")
    private String numAccSeller;//comprador
    
    
    private long status;
}
