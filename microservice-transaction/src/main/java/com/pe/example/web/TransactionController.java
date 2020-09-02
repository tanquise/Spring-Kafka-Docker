package com.pe.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pe.example.service.ITransactionService;

@Controller
public class TransactionController {

	@Autowired
	private ITransactionService iTransactionService;
	
	@GetMapping(name = "/")
	public String getAll(Model model) {
		model.addAttribute("transactionList", iTransactionService.findAll());
		return "transactionList.html";
	}
}
