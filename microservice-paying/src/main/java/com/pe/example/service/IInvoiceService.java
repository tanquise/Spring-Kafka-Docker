package com.pe.example.service;

import java.util.List;

import com.pe.example.entity.Invoice;

public interface IInvoiceService {

	public List<Invoice> findAll();
	public Invoice getOne(Long id);
	public void update(Invoice invoice);
	public void save(Invoice invoice);
}
