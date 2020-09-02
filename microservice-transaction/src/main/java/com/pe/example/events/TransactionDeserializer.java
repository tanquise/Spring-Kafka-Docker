package com.pe.example.events;

import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.pe.example.entity.Transaction;

public class TransactionDeserializer extends JsonDeserializer<Transaction>{
	
	public TransactionDeserializer() {
        super(Transaction.class);
    }
}