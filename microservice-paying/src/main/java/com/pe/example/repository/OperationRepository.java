package com.pe.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pe.example.entity.Operation;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long>{

}
