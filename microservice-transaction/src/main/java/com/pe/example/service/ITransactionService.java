package com.pe.example.service;

import java.util.List;

import com.pe.example.entity.Transaction;

public interface ITransactionService {

	public void save(Transaction transaction);
	public List<Transaction> findAll();
}
