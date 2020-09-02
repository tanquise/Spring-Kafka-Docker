package com.pe.example.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pe.example.entity.Invoice;
import com.pe.example.entity.Operation;
import com.pe.example.service.IInvoiceService;
import com.pe.example.service.IOperationService;

@Controller
@RequestMapping("/operation")
public class OperationController {

	@Autowired
	private IOperationService iOperationService;
	
	@Autowired
	private IInvoiceService iInvoiceService;
	
	@PostMapping
	public @ResponseBody Operation save(@RequestBody Operation operation) {
		operation.setDate(new Date());
		iOperationService.save(operation);
		Invoice invoice = iInvoiceService.getOne(operation.getIdInvoice().getIdInvoice());
		iInvoiceService.update(invoice);
		return operation;
	}
	
	@GetMapping
	public String findAll(Model model) {
		model.addAttribute("operationList", iOperationService.findAll());
		return "operationList";
	}
	
}
