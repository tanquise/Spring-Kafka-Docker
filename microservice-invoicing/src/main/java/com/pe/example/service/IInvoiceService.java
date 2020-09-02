package com.pe.example.service;

import java.util.List;

import com.pe.example.entity.Invoice;

public interface IInvoiceService {

	public Invoice getOne(Long idInvoice);
	public void save(Invoice invoice);
	public void update(Invoice invoice);
	public List<Invoice> findAll();
}
