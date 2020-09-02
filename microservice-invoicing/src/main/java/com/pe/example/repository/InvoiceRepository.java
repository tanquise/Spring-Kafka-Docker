package com.pe.example.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.pe.example.entity.Invoice;

@Repository
public interface InvoiceRepository extends PagingAndSortingRepository<Invoice, Long>{

}
