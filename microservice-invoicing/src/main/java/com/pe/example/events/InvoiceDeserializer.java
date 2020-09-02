package com.pe.example.events;

import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.pe.example.entity.Invoice;

public class InvoiceDeserializer extends JsonDeserializer<Invoice>{
	
	public InvoiceDeserializer() {
        super(Invoice.class);
    }

}
