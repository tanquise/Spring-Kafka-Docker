package com.pe.example.service;

import java.util.List;

import com.pe.example.entity.Operation;

public interface IOperationService {

	public Operation getOne(Long id);
	public void save(Operation operation);
	public List<Operation> findAll();
}
