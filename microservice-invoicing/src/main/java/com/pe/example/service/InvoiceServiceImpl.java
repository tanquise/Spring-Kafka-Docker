package com.pe.example.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.example.entity.Invoice;
import com.pe.example.repository.InvoiceRepository;

@Service
public class InvoiceServiceImpl implements IInvoiceService{

	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private InvoiceRepository invoiceRepository;
	
	public Invoice getOne(Long idInvoice) {
		return invoiceRepository.findById(idInvoice).orElse(null);
	}

	@Transactional
	public void save(Invoice invoice) {
		if(invoiceRepository.existsById(invoice.getIdInvoice())) {
			log.info("Invoice id {} already exists - ignored", invoice.getIdInvoice());
		}else {
			invoiceRepository.save(invoice);
		}
	}
	
	@Transactional
	public void update(Invoice invoice) {
		invoiceRepository.save(invoice);
	}

	@Override
	public List<Invoice> findAll() {
		return (List<Invoice>) invoiceRepository.findAll();
	}

}
