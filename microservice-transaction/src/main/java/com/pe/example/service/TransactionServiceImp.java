package com.pe.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.example.entity.Transaction;
import com.pe.example.repository.TransactionRepository;

@Service
public class TransactionServiceImp implements ITransactionService{

	@Autowired
	private TransactionRepository transactionRepository;
	
	@Override
	public void save(Transaction transaction) {
		Transaction transac = transactionRepository.findById(transaction.getIdInvoice()).orElse(null);
		if(transac != null) {
			transac.setAmount(transaction.getAmount());
			transac.setDate(transaction.getDate());
			transactionRepository.saveAndFlush(transac);
		}else {
			transactionRepository.saveAndFlush(transaction);
		}
	}

	@Override
	public List<Transaction> findAll() {
		return transactionRepository.findAll();
	}

}
