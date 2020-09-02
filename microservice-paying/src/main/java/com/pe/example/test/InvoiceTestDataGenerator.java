package com.pe.example.test;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pe.example.entity.Invoice;
import com.pe.example.service.IInvoiceService;

@Component
public class InvoiceTestDataGenerator {

	@Autowired
	private IInvoiceService iInvoiceService;
	
	@PostConstruct
	public void generateTestData() {
		iInvoiceService.save(
				new Invoice(1L,"Factura", "F001-1", 200.0,"0"));
		iInvoiceService.save(
				new Invoice(2L,"Factura", "F001-2", 500.0,"0"));
		iInvoiceService.save(
				new Invoice(3L,"Boleta", "B001-1", 700.0,"0"));
		iInvoiceService.save(
				new Invoice(4L,"Boleta", "B001-2", 800.0,"0"));
	}
}
