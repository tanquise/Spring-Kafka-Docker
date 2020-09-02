package com.pe.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pe.example.service.IInvoiceService;

@Controller
public class InvoiceController {

	@Autowired
	private IInvoiceService iInvoiceService;
	
	@GetMapping(name = "/")
	public String getAll(Model model) {
		model.addAttribute("InvoiceList", iInvoiceService.findAll());
		return "invoiceList";
	}
}
