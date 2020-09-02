package com.pe.example.events;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import com.pe.example.entity.Transaction;
import com.pe.example.service.ITransactionService;

@Component
public class PayKafkaListener {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ITransactionService iTransactionService;
	
	@KafkaListener(topics = "pay-events")
	public void updateState(Transaction transaction, Acknowledgment acknowledgment) {
		log.info("Received transaction " + transaction.getIdTransaction());
		transaction.setDate(new Date());
		iTransactionService.save(transaction);
		acknowledgment.acknowledge();
	}
}
