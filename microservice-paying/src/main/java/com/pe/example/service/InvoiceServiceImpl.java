package com.pe.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pe.example.entity.Invoice;
import com.pe.example.repository.InvoiceRepository;

@Service
public class InvoiceServiceImpl implements IInvoiceService{

	@Autowired
	private InvoiceRepository invoiceRepository;
	
	@Autowired
	private KafkaTemplate<String, Invoice> kafkaTemplate;
	
	@Override
	public List<Invoice> findAll() {
		return invoiceRepository.findAll();
	}

	@Override
	@Transactional
	public void update(Invoice invoice) {
		invoice.setState("1");
		invoiceRepository.saveAndFlush(invoice);
		invoiceUpdateEvent(invoice);
	}

	@Override
	@Transactional
	public void save(Invoice invoice) {
		invoiceRepository.saveAndFlush(invoice);
		invoiceCreateEvent(invoice);
	}
	
	@Override
	public Invoice getOne(Long id) {
		return invoiceRepository.getOne(id);
	}
	
	private void invoiceCreateEvent(Invoice invoice) {
		kafkaTemplate.send("pay-events", invoice.getIdInvoice() + "created", invoice);
	}
	
	private void invoiceUpdateEvent(Invoice invoice) {
		kafkaTemplate.send("pay-events", invoice.getIdInvoice() + "update", invoice);
	}

}
