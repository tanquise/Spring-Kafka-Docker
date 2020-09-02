package com.pe.example.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import com.pe.example.entity.Invoice;
import com.pe.example.service.IInvoiceService;

@Component
public class PayKafkaListener {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private IInvoiceService iInvoiceService;
	
	@KafkaListener(topics = "pay-events")
	public void updateState(Invoice invoice, Acknowledgment acknowledgment) {
		log.info("Received invoice " + invoice.getIdInvoice());
		iInvoiceService.update(invoice);
		acknowledgment.acknowledge();
	}
}
