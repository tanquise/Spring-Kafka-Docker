package com.pe.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.example.entity.Operation;
import com.pe.example.repository.OperationRepository;

@Service
public class OperationServiceImpl implements IOperationService{

	@Autowired
	private OperationRepository operationRepository;
	
	@Override
	public Operation getOne(Long id) {
		return operationRepository.findById(id).orElse(null);
	}

	@Override
	public void save(Operation operation) {
		operationRepository.saveAndFlush(operation);
	}

	@Override
	public List<Operation> findAll() {
		return operationRepository.findAll();
	}

}
